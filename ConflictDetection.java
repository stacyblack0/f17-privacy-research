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

	public ConflictDetection(SolverContext pContext, ProverEnvironment pProver) throws InvalidConfigurationException {
		this.bfmgr = pContext.getFormulaManager().getBooleanFormulaManager();
		this.ifmgr = pContext.getFormulaManager().getIntegerFormulaManager();
		this.prover = pProver;
		this.context = pContext;
		init();
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
	 * @param type what type of conflict to check for - time, or day
	 */
	public boolean hasConflict(ArrayList<Rule> ruleList, String type) throws Exception {
		Throwable var9 = null;
		try {
			ProverEnvironment prover = context.newProverEnvironment(new SolverContext.ProverOptions[]{SolverContext.ProverOptions.GENERATE_MODELS});
			Throwable var11 = null;

			try {
				prover.push();
				System.out.println(createSATModel(ruleList, type));
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
	 * @param type what type of conflict to check for - time, or day
	 */
	private List<List<org.sosy_lab.java_smt.api.Model.ValueAssignment>> createSATModel(ArrayList<Rule> ruleList, String type) throws InterruptedException, SolverException {

		for (Rule r : ruleList) {

			System.out.println(r.toString());

//			int timeStart = r.getCondition().getTimeStart();
//			int timeEnd = r.getCondition().getTimeEnd();
//			int dayStart = r.getCondition().getTimeStart();
//			int dayEnd = r.getCondition().getTimeEnd();

			int start;
			int end;

			if (type.equals("time")) {
				start = r.getCondition().getTimeStart();
				end = r.getCondition().getTimeEnd();
			} else {
				start = r.getCondition().getDayStart();
				end = r.getCondition().getDayEnd();
			}

			// in the database, null values for start/end times have been stored as -1
//			if (timeStart == -1) {
//				timeStart = 0;
//			}
//			if (timeEnd == -1) {
//				timeEnd = 23;
//			}
//			if (dayStart == -1) {
//				dayStart = 1;
//			}
//			if (dayEnd == -1) {
//				dayEnd = 7;
//			}
			if (start == -1 && type.equals("time")) {
				start = 0;
			} else if (start == -1 && type.equals("day")) {
				start = 1;
			}

			if (end == -1 && type.equals("time")) {
				end = 23;
			} else if (end == -1 && type.equals("day")) {
				end = 7;
			}

			System.out.println(start + " " + end);
			NumeralFormula.IntegerFormula a = this.ifmgr.makeVariable("a");
//			NumeralFormula.IntegerFormula b = this.ifmgr.makeVariable("b");
			// if condition specifies the weekend
//			if (dayStart == 7 && dayEnd == 1) {
////				NumeralFormula.IntegerFormula temp = this.ifmgr.makeVariable("a");
//				this.prover.addConstraint(this.ifmgr.equal(this.num(dayStart), a));
//				this.prover.addConstraint(this.ifmgr.equal(this.num(dayEnd), a));
////				NumeralFormula.IntegerFormula temp2 = this.ifmgr.makeVariable("b");
//				this.prover.addConstraint(this.ifmgr.lessOrEquals(this.num(dayStart), b));
//				this.prover.addConstraint(this.ifmgr.lessOrEquals(b, this.num(dayEnd)));
//			} else {
////				NumeralFormula.IntegerFormula temp = this.ifmgr.makeVariable("a");
//				this.prover.addConstraint(this.ifmgr.lessOrEquals(this.num(timeStart), a));
//				this.prover.addConstraint(this.ifmgr.lessOrEquals(a, this.num(timeEnd)));
////				NumeralFormula.IntegerFormula temp2 = this.ifmgr.makeVariable("b");
//				this.prover.addConstraint(this.ifmgr.lessOrEquals(this.num(dayStart), b));
//				this.prover.addConstraint(this.ifmgr.lessOrEquals(b, this.num(dayEnd)));
//			}
			if (start == 7 && end == 1) {
				NumeralFormula.IntegerFormula b = this.ifmgr.makeVariable("b");
				this.prover.addConstraint(this.ifmgr.equal(a, this.num(start)));
				this.prover.addConstraint(this.ifmgr.equal(b, this.num(end)));
			} else {
				this.prover.addConstraint(this.ifmgr.lessOrEquals(this.num(start), a));
				this.prover.addConstraint(this.ifmgr.lessOrEquals(a, this.num(end)));
			}
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
