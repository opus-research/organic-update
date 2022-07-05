package br.pucrio.opus.smells.ast.visitors;

import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;

public class AnnotationTypeCollector extends CollectorVisitor<AnnotationTypeDeclaration>{

    public boolean visit(AnnotationTypeDeclaration node) {
        super.addCollectedNode(node);
        return true;
    }
}
