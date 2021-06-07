package br.pucrio.opus.smells.ast.visitors;

import org.eclipse.jdt.core.dom.*;

import java.util.List;

public class TryStatementVisitor extends ASTVisitor {

    private Integer numberOfTryStatements;
    private Integer numberOfCatchStatements;
    private Integer numberOfFinallyStatements;

    public TryStatementVisitor(){
        numberOfTryStatements = 0;
        numberOfCatchStatements = 0;
        numberOfFinallyStatements = 0;
    }

    @Override
    public boolean visit(TryStatement node) {
        numberOfTryStatements++;
        List<CatchClause> catchClauseList = node.catchClauses();
        for (CatchClause clause : catchClauseList){
            numberOfCatchStatements++;
        }
        if (node.getFinally() != null){
            numberOfFinallyStatements++;
        }
        return true;
    }

    public Integer getNumberOfTryStatements() {
        return numberOfTryStatements;
    }

    public Integer getNumberOfCatchStatements() {
        return numberOfCatchStatements;
    }

    public Integer getNumberOfFinallyStatements() {
        return numberOfFinallyStatements;
    }
}
