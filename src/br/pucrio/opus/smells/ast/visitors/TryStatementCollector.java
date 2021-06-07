package br.pucrio.opus.smells.ast.visitors;

import org.eclipse.jdt.core.dom.TryStatement;

public class TryStatementCollector extends CollectorVisitor<TryStatement>{
    @Override
    public boolean visit(TryStatement node) {
        super.addCollectedNode(node);
        return true;
    }
}