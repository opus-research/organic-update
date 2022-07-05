package br.pucrio.opus.smells.ast.visitors;

import org.eclipse.jdt.core.dom.TypeDeclaration;

public class TypeDeclarationCollector extends CollectorVisitor<TypeDeclaration> {
	

	public boolean visit(TypeDeclaration node) {
		super.addCollectedNode(node);
		return true;
	}
}
