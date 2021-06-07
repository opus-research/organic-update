package br.pucrio.opus.smells.metrics.calculators;

import br.pucrio.opus.smells.ast.visitors.TryStatementCollector;
import br.pucrio.opus.smells.metrics.MetricName;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.TryStatement;

public class TryNoCatchFinallyCalculator extends MetricValueCalculator {

    @Override
    protected Double computeValue(ASTNode target){
        Double result = 0.0;
        TryStatementCollector visitor = new TryStatementCollector();
        target.accept(visitor);
        for (TryStatement statement : visitor.getNodesCollected()){
            if (statement.catchClauses().size() == 0 && statement.getFinally() != null){
                result++;
            }
        }
        return result;
    }

    @Override
    public MetricName getMetricName() {
        return MetricName.TryNoCatchFinallyCount;
    }
}

