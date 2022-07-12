package br.pucrio.opus.smells.ast.visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.eclipse.jdt.core.dom.AnnotationTypeMemberDeclaration;
import org.eclipse.jdt.core.dom.AnonymousClassDeclaration;
import org.eclipse.jdt.core.dom.AssertStatement;
import org.eclipse.jdt.core.dom.BreakStatement;
import org.eclipse.jdt.core.dom.CatchClause;
import org.eclipse.jdt.core.dom.ContinueStatement;
import org.eclipse.jdt.core.dom.DoStatement;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.EnumConstantDeclaration;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.Initializer;
import org.eclipse.jdt.core.dom.LabeledStatement;
import org.eclipse.jdt.core.dom.LambdaExpression;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.SuperConstructorInvocation;
import org.eclipse.jdt.core.dom.SwitchCase;
import org.eclipse.jdt.core.dom.SwitchStatement;
import org.eclipse.jdt.core.dom.ThrowStatement;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclarationStatement;
import org.eclipse.jdt.core.dom.TypeLiteral;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.WhileStatement;

public class EffectiveLinesOfCodeVisitor extends ASTVisitor {

	private Integer eloc;
	
	public Integer getELoc() {
		return eloc;
	}
	
	public EffectiveLinesOfCodeVisitor() {
		this.eloc = 0;
	}
	
	@Override
	public boolean visit(AnnotationTypeDeclaration node) {
		eloc++;
		return true;
	}

	@Override
	public boolean visit(AnnotationTypeMemberDeclaration node) {
		eloc++;
		return true;
	}

	@Override
	public boolean visit(AnonymousClassDeclaration node) {
		eloc++;
		return true;
	}

	@Override
	public boolean visit(AssertStatement node) {
		eloc++;
		return true;
	}

	@Override
	public boolean visit(BreakStatement node) {
		eloc++;
		return true;
	}

	@Override
	public boolean visit(CatchClause node) {
		eloc++;
		return true;
	}


	@Override
	public boolean visit(ContinueStatement node) {
		eloc++;
		return true;
	}


	@Override
	public boolean visit(DoStatement node) {
		eloc++;
		return true;
	}


	@Override
	public boolean visit(EnhancedForStatement node) {
		eloc++;
		return true;
	}

	@Override
	public boolean visit(EnumConstantDeclaration node) {
		eloc++;
		return true;
	}

	@Override
	public boolean visit(EnumDeclaration node) {
		eloc++;
		return true;
	}

	@Override
	public boolean visit(ExpressionStatement node) {
		eloc++;
		return true;
	}

	@Override
	public boolean visit(FieldDeclaration node) {
		eloc++;
		return true;
	}

	@Override
	public boolean visit(ForStatement node) {
		eloc++;
		return true;
	}

	@Override
	public boolean visit(IfStatement node) {
		eloc++;
		return true;
	}

	@Override
	public boolean visit(ImportDeclaration node) {
		eloc++;
		return true;
	}

	@Override
	public boolean visit(Initializer node) {
		eloc++;
		return true;
	}


	@Override
	public boolean visit(LabeledStatement node) {
		eloc++;
		return true;
	}

	@Override
	public boolean visit(LambdaExpression node) {
		eloc++;
		return true;
	}

	@Override
	public boolean visit(MarkerAnnotation node) {
		eloc++;
		return true;
	}


	@Override
	public boolean visit(MethodDeclaration node) {
		eloc++;
		return true;
	}

	@Override
	public boolean visit(NormalAnnotation node) {
		eloc++;
		return true;
	}


	@Override
	public boolean visit(PackageDeclaration node) {
		eloc++;
		return true;
	}


	@Override
	public boolean visit(ReturnStatement node) {
		eloc++;
		return true;
	}


	@Override
	public boolean visit(SingleMemberAnnotation node) {
		eloc++;
		return true;
	}


	@Override
	public boolean visit(SuperConstructorInvocation node) {
		eloc++;
		return true;
	}


	@Override
	public boolean visit(SwitchCase node) {
		eloc++;
		return true;
	}

	@Override
	public boolean visit(SwitchStatement node) {
		eloc++;
		return true;
	}


	@Override
	public boolean visit(ThrowStatement node) {
		eloc++;
		return true;
	}

	@Override
	public boolean visit(TryStatement node) {
		eloc++;
		return true;
	}

	@Override
	public boolean visit(TypeDeclaration node) {
		eloc++;
		return true;
	}

	@Override
	public boolean visit(TypeDeclarationStatement node) {
		eloc++;
		return true;
	}

	@Override
	public boolean visit(TypeLiteral node) {
		eloc++;
		return true;
	}


	@Override
	public boolean visit(VariableDeclarationStatement node) {
		eloc++;
		return true;
	}

	@Override
	public boolean visit(WhileStatement node) {
		eloc++;
		return true;
	}


	
}
