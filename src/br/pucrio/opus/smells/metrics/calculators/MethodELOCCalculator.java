package br.pucrio.opus.smells.metrics.calculators;

import org.eclipse.jdt.core.dom.ASTNode;

import br.pucrio.opus.smells.ast.visitors.EffectiveLinesOfCodeVisitor;
import br.pucrio.opus.smells.metrics.MetricName;

public class MethodELOCCalculator extends MetricValueCalculator {
	
	@Override
	protected Double computeValue(ASTNode target) {
		EffectiveLinesOfCodeVisitor visitor = new EffectiveLinesOfCodeVisitor();
		target.accept(visitor);
		return visitor.getELoc().doubleValue();
	}

	@Override
	public MetricName getMetricName() {
		return MetricName.MELOC;
	}
	
	@Override
	public boolean shouldComputeAggregate() {
		return true;
	}

}
