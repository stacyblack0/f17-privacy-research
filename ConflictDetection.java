import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.reader.DimacsReader;
import org.sat4j.reader.Reader;
import org.sat4j.specs.IProblem;
import org.sat4j.specs.ISolver;
import org.sosy_lab.common.ShutdownNotifier;
import org.sosy_lab.common.configuration.Configuration;
import org.sosy_lab.common.configuration.InvalidConfigurationException;
import org.sosy_lab.common.log.BasicLogManager;
import org.sosy_lab.common.log.LogManager;
import org.sosy_lab.java_smt.SolverContextFactory;
import org.sosy_lab.java_smt.api.*;
import tree.Rule;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ConflictDetection {

	private final BooleanFormulaManager bfmgr;
	private final IntegerFormulaManager ifmgr;
	private final ProverEnvironment prover;
	private final SolverContext context;

	public ConflictDetection() throws InvalidConfigurationException {

		Configuration config = Configuration.defaultConfiguration();
		LogManager logger = BasicLogManager.create(config);
		ShutdownNotifier notifier = ShutdownNotifier.createDummy();
		SolverContextFactory.Solvers[] values = SolverContextFactory.Solvers.values();

//		for (SolverContextFactory.Solvers solvers : values) {
//			System.out.println(solvers);
//		}

		SolverContextFactory.Solvers solver = values[2];
		System.out.println("\nUsing solver " + solver);
		SolverContext context = SolverContextFactory.createSolverContext(config, logger, notifier, solver);
		ProverEnvironment prover = context.newProverEnvironment(SolverContext.ProverOptions.GENERATE_MODELS);

		this.bfmgr = context.getFormulaManager().getBooleanFormulaManager();
		this.ifmgr = context.getFormulaManager().getIntegerFormulaManager();
		this.prover = prover;
		this.context = context;
	}

	public ConflictDetection(SolverContext pContext, ProverEnvironment pProver) throws InvalidConfigurationException {
		this.bfmgr = pContext.getFormulaManager().getBooleanFormulaManager();
		this.ifmgr = pContext.getFormulaManager().getIntegerFormulaManager();
		this.prover = pProver;
		this.context = pContext;
//		init();
	}

	private void init() throws InvalidConfigurationException {
		Configuration config = Configuration.defaultConfiguration();
		LogManager logger = BasicLogManager.create(config);
		ShutdownNotifier notifier = ShutdownNotifier.createDummy();

		SolverContextFactory.Solvers[] var4 = SolverContextFactory.Solvers.values();
		int var5 = var4.length;
		SolverContextFactory.Solvers solver = var4[2];
		System.out.println("\nUsing solver " + solver);
		SolverContext context = SolverContextFactory.createSolverContext(config, logger, notifier, solver);

	}


	/**
	 * Determines if a set of rules contains a conflict.
	 *
	 * @param ruleList the set of rules
	 */
	public boolean hasConflict(ArrayList<Rule> ruleList) throws Exception {
		Throwable var9 = null;
		try {
			ProverEnvironment prover = context.newProverEnvironment(SolverContext.ProverOptions.GENERATE_MODELS);
			Throwable var11 = null;

			try {
				prover.push();
				System.out.println(createSATModel(ruleList));
				prover.pop();
			} catch (Throwable var23) {
				var11 = var23;
				throw var23;
			} finally {
				if (prover != null) {
					$closeResource(var11, prover);
				}

			}
		} catch (Throwable var25) {
			var9 = var25;
			throw var25;
		} finally {
			if (context != null) {
				$closeResource(var9, context);
			}

		}
		return true;
	}

	/**
	 * @param ruleList the set of rules to check for a conflict
	 */
	private List<List<org.sosy_lab.java_smt.api.Model.ValueAssignment>> createSATModel(ArrayList<Rule> ruleList) throws InterruptedException, SolverException {

		for (Rule r : ruleList) {

			System.out.println(r.toString());

			int timeStart = r.getCondition().getTimeStart();
			int timeEnd = r.getCondition().getTimeEnd();
			int dayStart = r.getCondition().getDayStart();
			int dayEnd = r.getCondition().getDayEnd();

			int startHour = timeStart / 100;
			int endHour = timeEnd / 100;
//			int startMinute = timeStart - (startHour * 100);
//			int endMinute = timeEnd - (endHour * 100);

//			 in the database, null values for start/end times have been stored as -1
			if (timeStart == -1) {
				timeStart = 0;
			}
			if (timeEnd == -1) {
				timeEnd = 2300;
			}
			if (dayStart == -1) {
				dayStart = 1;
			}
			if (dayEnd == -1) {
				dayEnd = 7;
			}

			System.out.println("Time: " + startHour + " " + endHour);
			System.out.println("Day: " + dayStart + " " + dayEnd);

			NumeralFormula.IntegerFormula t = this.ifmgr.makeVariable("t"); // time
			NumeralFormula.IntegerFormula d = this.ifmgr.makeVariable("d"); // day
			NumeralFormula.IntegerFormula h = this.ifmgr.makeVariable("h"); // hour
			NumeralFormula.IntegerFormula m = this.ifmgr.makeVariable("m"); // minute

			// if condition specifies the weekend
			if (dayStart == 7 && dayEnd == 1) {
				this.prover.addConstraint(this.bfmgr.or(this.ifmgr.equal(d, this.num(dayStart)), this.ifmgr.equal(d, this.num(dayEnd))));
			} else {
				this.prover.addConstraint(this.ifmgr.lessOrEquals(this.num(dayStart), d));
				this.prover.addConstraint(this.ifmgr.lessOrEquals(d, this.num(dayEnd)));
			}

//			this.prover.addConstraint(this.ifmgr.lessOrEquals(this.num(timeStart), t));
//			this.prover.addConstraint(this.ifmgr.lessOrEquals(t, this.num(timeEnd)));
			this.prover.addConstraint(this.ifmgr.lessOrEquals(this.num(startHour), h));
			this.prover.addConstraint(this.ifmgr.lessOrEquals(h, this.num(endHour)));
			this.prover.addConstraint(this.ifmgr.lessOrEquals(this.num(0), m));
			this.prover.addConstraint(this.ifmgr.lessOrEquals(m, this.num(59)));
		}

		ArrayList models = new ArrayList();

		while (!this.prover.isUnsat()) {
			ImmutableList<Model.ValueAssignment> modelAssignments = this.prover.getModelAssignments();
			models.add(modelAssignments);
			List<BooleanFormula> modelAssignmentsAsFormulas = new ArrayList();
			UnmodifiableIterator var7 = modelAssignments.iterator();

			while (var7.hasNext()) {
				org.sosy_lab.java_smt.api.Model.ValueAssignment va = (org.sosy_lab.java_smt.api.Model.ValueAssignment)var7.next();
				modelAssignmentsAsFormulas.add(va.getAssignmentAsFormula());
			}

			this.prover.addConstraint(this.bfmgr.not(this.bfmgr.and(modelAssignmentsAsFormulas)));
		}

		return models;
	}

	private NumeralFormula.IntegerFormula num(int number) {
		return (NumeralFormula.IntegerFormula)this.ifmgr.makeNumber((long)number);
	}

	private NumeralFormula.IntegerFormula num(BigInteger number) {
		return (NumeralFormula.IntegerFormula)this.ifmgr.makeNumber(number);
	}

	private static void $closeResource(java.lang.Throwable t, java.lang.AutoCloseable a) throws Exception {
		if (t == null) {
			a.close();
			return;
		}

		try {
			a.close();
		} catch (Exception e) {
			t.addSuppressed(e);
		}
	}


	public boolean hasConflictLight(ArrayList<Rule> ruleList) throws Exception {
		int i = 0;
		ISolver solver = SolverFactory.newDefault();
		solver.setTimeout(60); // 1 hour timeout
		Reader reader = new DimacsReader(solver);
		// CNF filename is given on the command line

		final int MAXVAR = 200000;
		final int NBCLAUSES = 100000;

		// prepare the solver to accept MAXVAR variables. MANDATORY for MAXSAT solving
		solver.newVar(MAXVAR);
		solver.setExpectedNumberOfClauses(NBCLAUSES);
		String conditions1 = ruleList.get(0).getCondition().toString();
		String conditions2 = ruleList.get(1).getCondition().toString();

		if ((!conditions1.equals("") && !conditions2.equals("")) &&
				conditions1.equals(conditions2)) {
			solver.addClause(new VecInt(new int[]{i}));
			solver.addClause(new VecInt(new int[]{i}));
//							System.out.println("equivalent" + i);
		} else if ((!conditions1.equals("") && !conditions2.equals("")) &&
				!conditions1.equals(conditions2)) {
			solver.addClause(new VecInt(new int[]{i}));
			solver.addClause(new VecInt(new int[]{-i}));
//							System.out.println("not equivalent" + i);
		} else if (!conditions1.equals("") || !conditions2.equals("")) {
			solver.addClause(new VecInt(new int[]{i}));
//							System.out.println("only one" + i);
		}

		i++;

		String regex1 = ruleList.get(0).getRegex().getRegexString();
		String regex2 = ruleList.get(1).getRegex().getRegexString();

		if ((!regex1.equals("") && !regex2.equals("")) &&
				regex1.equals(regex2)) {
			solver.addClause(new VecInt(new int[]{i}));
			solver.addClause(new VecInt(new int[]{i}));
//							System.out.println("equivalent" + i);
		} else if ((!regex1.equals("") && !regex2.equals("")) &&
				!regex1.equals(regex2)) {
			solver.addClause(new VecInt(new int[]{i}));
			solver.addClause(new VecInt(new int[]{-i}));
//							System.out.println("not equivalent" + i);
		} else if (!regex1.equals("") || !regex2.equals("")) {
			solver.addClause(new VecInt(new int[]{i}));
//							System.out.println("only one" + i);
		}
		i = 1; // reset variable integer
		// we are done. Working now on the IProblem interface
		IProblem problem = solver;
		if (problem.isSatisfiable()) {
			System.out.println("Satisfiable !");
			System.out.println(reader.decode(problem.model()));
			System.out.println();
			return false;
		} else {
			System.out.println("Unsatisfiable !");
			System.out.println();
			return true;
		}
	}
}
