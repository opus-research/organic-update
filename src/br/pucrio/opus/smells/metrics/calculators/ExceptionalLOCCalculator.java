package br.pucrio.opus.smells.metrics.calculators;

import br.pucrio.opus.smells.ast.visitors.LinesOfCodeVisitor;
import br.pucrio.opus.smells.ast.visitors.TryStatementCollector;
import br.pucrio.opus.smells.metrics.MetricName;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Initializer;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TryStatement;

public class ExceptionalLOCCalculator extends MetricValueCalculator {

    private boolean hasTryParent(ASTNode node) {
        if(node == null || node instanceof Initializer || node instanceof MethodDeclaration)
            return false;

        if(node instanceof TryStatement)
            return true;

        return hasTryParent(node.getParent());
    }

    @Override
    protected Double computeValue(ASTNode target) {
        Double result = 0.0;
        TryStatementCollector visitor = new TryStatementCollector();
        target.accept(visitor);
        for (TryStatement statement : visitor.getNodesCollected()){
            if (!hasTryParent(statement.getParent())) {
                LinesOfCodeVisitor visitor2 = new LinesOfCodeVisitor();
                target.accept(visitor2);
                result += visitor2.getLoc().doubleValue();
            }
        }
        return result;
    }

    @Override
    public MetricName getMetricName() {
        return MetricName.ExceptionalLOC;
    }
}
