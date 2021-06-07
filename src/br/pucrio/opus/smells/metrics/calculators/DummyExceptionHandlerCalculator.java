package br.pucrio.opus.smells.metrics.calculators;

import br.pucrio.opus.smells.ast.visitors.CatchClauseCollector;
import br.pucrio.opus.smells.metrics.MetricName;
import org.eclipse.jdt.core.dom.*;

import java.util.List;

public class DummyExceptionHandlerCalculator extends MetricValueCalculator{

    private boolean isDummy(CatchClause node) {
        if (node.getBody().statements().isEmpty()) { // empty catch
            return true;
        }
        return areAllStatementsDummy(node.getException().getName(), node.getBody().statements());
    }

    private boolean areAllStatementsDummy(SimpleName name, List<Statement> statements) {
        String exceptionVar = name.toString();
        for (Statement st : statements) {
            boolean isDummy = false;
            if (st instanceof EmptyStatement) {
                isDummy = true;
            } else if (st instanceof ExpressionStatement) {
                Expression exp = ((ExpressionStatement) st).getExpression();
                if (exp instanceof MethodInvocation) {
                    MethodInvocation mi = (MethodInvocation) exp;
                    String varName = mi.getExpression() != null ? mi.getExpression().toString() : "";
                    String methodName = mi.getName().toString();
                    int argsSize = mi.arguments().size();
                    if (isPrintStackTrace(exceptionVar, varName, methodName, argsSize) ||
                            isSystemOut(varName, methodName))
                        isDummy = true;
                }
            }
            if (!isDummy)
                return false;
        }
        return true;
    }

    private boolean isSystemOut(String varName, String methodName) {
        return (varName.equals("System.out") || varName.equals("System.err")) &&
                (methodName.equals("print") || methodName.equals("println"));
    }

    private boolean isPrintStackTrace(String exceptionVar, String varName, String method, int argsSize) {
        return exceptionVar.equals(varName) &&
                method.equals("printStackTrace") &&
                argsSize == 0;
    }

    @Override
    protected Double computeValue(ASTNode target) {
        Double result = 0.0;
        CatchClauseCollector visitor = new CatchClauseCollector();
        target.accept(visitor);
        for (CatchClause statement : visitor.getNodesCollected()){
            if (isDummy(statement)){
                result++;
            }
        }
        return result;
    }

    @Override
    public MetricName getMetricName() {
        return MetricName.DummyExceptionHandlerCount;
    }
}
