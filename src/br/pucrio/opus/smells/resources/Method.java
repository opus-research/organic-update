package br.pucrio.opus.smells.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.annotations.Expose;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;

import br.pucrio.opus.smells.ast.visitors.MethodInvocationVisitor;
import br.pucrio.opus.smells.graph.CallGraph;

public class Method extends Resource {

	@Expose	private List<String> parametersTypes;

	@Expose private String methodSignature;
	
	public IMethodBinding getBinding() {
		MethodDeclaration declaration = (MethodDeclaration)this.getNode(); 
		IMethodBinding binding = declaration.resolveBinding();
		return binding;
	}
	
	protected void identifyKind() {
		MethodDeclaration declaration = (MethodDeclaration)this.getNode();
		StringBuffer buffer = new StringBuffer();
		int modifiers = declaration.getModifiers(); 
		
		if (Modifier.isPublic(modifiers)) {
			buffer.append("public ");
		}
		
		if (Modifier.isPrivate(modifiers)) {
			buffer.append("private ");
		}
		
		if (Modifier.isProtected(modifiers)) {
			buffer.append("protected ");
		}
		
		if (Modifier.isStatic(modifiers)) {
			buffer.append("static ");
		}
		
		if (Modifier.isAbstract(modifiers)) {
			buffer.append("abstract ");
		}
		
		if (Modifier.isFinal(modifiers)) {
			buffer.append("final ");
		}
		
		buffer.append("method");
		this.setKind(buffer.toString());
	}

	/**
	 * Every time a new method is declared, it must be
	 * registered in the call Graph
	 */
	private void registerOnCallGraph(MethodDeclaration node) {
		CallGraph graph = CallGraph.getInstance();
		IMethodBinding thisBinding = this.getBinding();
		if (thisBinding == null) {
			//TODO LOG!
			return;
		}
		
		/*
		 * Retrieves the list of method calls made by the new
		 * declared method
		 */
		MethodInvocationVisitor invocationVisitor = new MethodInvocationVisitor();
		node.accept(invocationVisitor);
		for (IMethodBinding methodBinding : invocationVisitor.getCalls()) {
			if (!(methodBinding.getDeclaringClass().getQualifiedName().startsWith("java"))){
				graph.addMethodCall(thisBinding, methodBinding);
			}
		}

	}

	private String getTypeParamsString(MethodDeclaration node){
		String result = "";
		try	{
			final List typeParameters = node.typeParameters();
			if (typeParameters.size() > 0){
				result = typeParameters.stream()
						.map(Object::toString)
						.collect(Collectors.joining(","))
						.toString();
			}
		}
		catch (Exception e){
			//Result will be blank.
		}
		return result;
	}
	
	public Method(SourceFile sourceFile, MethodDeclaration node) {
		super(sourceFile, node);
		this.registerOnCallGraph(node);
		
		this.parametersTypes = new ArrayList<>();
		for(SingleVariableDeclaration declaration : (List<SingleVariableDeclaration>)node.parameters()) {
			declaration.getName();
			String parameterType = declaration.getType().toString();
			parametersTypes.add(declaration.isVarargs() ? parameterType + "..." : parameterType);
		}
		
		IBinding binding = node.resolveBinding();
		if (binding != null) {
			IMethodBinding methodBinding = (IMethodBinding)binding;
			String classFqn = methodBinding.getDeclaringClass().getQualifiedName();
			String methodFqn = classFqn + "." + node.getName().toString();
			setFullyQualifiedName(methodFqn);
			this.methodSignature = methodFqn +
					"<" + getTypeParamsString(node) + ">" +
					"(" + String.join(", ", this.getParametersTypes()) + ")";
		}
	}
	
	public List<String> getParametersTypes() {
		return parametersTypes;
	}
	
	@Override
	public String toString() {
		return "Method [fqn=" + getFullyQualifiedName() + "]";
	}
	
}
