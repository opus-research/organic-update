package br.pucrio.opus.smells.metrics.calculators;

import br.pucrio.opus.smells.metrics.MetricName;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.MethodDeclaration;

public class ThrownExceptionTypesCalculator extends MetricValueCalculator {

    @Override
    protected Double computeValue(ASTNode target) {
        MethodDeclaration declaration = (MethodDeclaration) target;
        return Double.valueOf(declaration.thrownExceptionTypes().size());
    }

    @Override
    public MetricName getMetricName() {
        return MetricName.ThrownExceptionTypesCount;
    }
}
