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


    public boolean hasConflict(ArrayList<Rule> ruleList) throws Exception {
        Throwable var9 = null;
        try {
            ProverEnvironment prover = context.newProverEnvironment(new SolverContext.ProverOptions[]{SolverContext.ProverOptions.GENERATE_MODELS});
            Throwable var11 = null;

            try {
                prover.push();
                System.out.println(createSATModle(ruleList));
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

    private List<List<org.sosy_lab.java_smt.api.Model.ValueAssignment>> createSATModle(ArrayList<Rule> ruleList) throws InterruptedException, SolverException {


        NumeralFormula.IntegerFormula a = (NumeralFormula.IntegerFormula)this.ifmgr.makeVariable("a");
        this.prover.addConstraint(this.ifmgr.lessOrEquals(this.num(100), a));
        this.prover.addConstraint(this.ifmgr.lessOrEquals(a, this.num(1300)));
        this.prover.addConstraint(this.ifmgr.lessOrEquals(this.num(1100), a));
        this.prover.addConstraint(this.ifmgr.lessOrEquals(a, this.num(1200)));
        this.prover.addConstraint(this.ifmgr.lessOrEquals(this.num(1130), a));
        this.prover.addConstraint(this.ifmgr.lessOrEquals(a, this.num(1200)));
        this.prover.addConstraint(this.ifmgr.lessOrEquals(a, this.num(1200)));
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
