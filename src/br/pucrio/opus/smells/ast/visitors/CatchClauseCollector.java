package br.pucrio.opus.smells.ast.visitors;

import org.eclipse.jdt.core.dom.CatchClause;

public class CatchClauseCollector extends CollectorVisitor<CatchClause>{
    @Override
    public boolean visit(CatchClause node) {
        super.addCollectedNode(node);
        return true;
    }
}
