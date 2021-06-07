package br.pucrio.opus.smells.ast.visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ThrowStatement;
import org.eclipse.jdt.core.dom.TryStatement;

public class ThrowStatementVisitor extends ASTVisitor {
    private Integer numberOfThrowStatements;

    public ThrowStatementVisitor(){
        numberOfThrowStatements = 0;
    }

    @Override
    public boolean visit(ThrowStatement node) {
        numberOfThrowStatements++;
        return true;
    }

    public Integer getNumberOfThrowStatements() {
        return numberOfThrowStatements;
    }
}
