package br.pucrio.opus.smells.metrics.calculators;

import br.pucrio.opus.smells.ast.visitors.TryStatementVisitor;
import br.pucrio.opus.smells.metrics.MetricName;
import org.eclipse.jdt.core.dom.ASTNode;

public class NumberOfTryCalculator extends MetricValueCalculator {

    @Override
    protected Double computeValue(ASTNode target){
        TryStatementVisitor visitor = new TryStatementVisitor();
        target.accept(visitor);
        return Double.valueOf(visitor.getNumberOfTryStatements());
    }

    @Override
    public MetricName getMetricName() {
        return MetricName.TryCount;
    }
}
