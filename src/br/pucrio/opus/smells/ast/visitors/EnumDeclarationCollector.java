package br.pucrio.opus.smells.ast.visitors;

import org.eclipse.jdt.core.dom.EnumDeclaration;

public class EnumDeclarationCollector extends CollectorVisitor<EnumDeclaration> {

    public boolean visit(EnumDeclaration node) {
        super.addCollectedNode(node);
        return true;
    }
}
