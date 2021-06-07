package br.pucrio.opus.smells.metrics.calculators;

import br.pucrio.opus.smells.ast.visitors.ThrowStatementVisitor;
import br.pucrio.opus.smells.metrics.MetricName;
import org.eclipse.jdt.core.dom.ASTNode;

public class NumberOfThrowCalculator extends MetricValueCalculator {

    @Override
    protected Double computeValue(ASTNode target){
        ThrowStatementVisitor visitor = new ThrowStatementVisitor();
        target.accept(visitor);
        return Double.valueOf(visitor.getNumberOfThrowStatements());
    }

    @Override
    public MetricName getMetricName() {
        return MetricName.ThrowCount;
    }
}
