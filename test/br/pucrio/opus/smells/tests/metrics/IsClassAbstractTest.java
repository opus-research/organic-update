package br.pucrio.opus.smells.tests.metrics;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.junit.Assert;
import org.junit.Test;

import br.pucrio.opus.smells.ast.visitors.TypeDeclarationCollector;
import br.pucrio.opus.smells.metrics.calculators.IsClassAbstract;
import br.pucrio.opus.smells.tests.util.CompilationUnitLoader;

public class IsClassAbstractTest {
	
	private List<TypeDeclaration> getTypes(File file) throws IOException {
		CompilationUnit unit = CompilationUnitLoader.getCompilationUnit(file);
		TypeDeclarationCollector visitor = new TypeDeclarationCollector();
		unit.accept(visitor);
		return visitor.getNodesCollected();
	}

	
	@Test
	public void tccOnFieldAccessedByMethodTest() throws IOException {
		List<TypeDeclaration> types = getTypes(new File("test/br/pucrio/opus/smells/tests/dummy/FieldAccessedByMethod.java"));
		TypeDeclaration node = types.get(0);
		IsClassAbstract calc = new IsClassAbstract();
		Assert.assertEquals(Double.valueOf(0), calc.getValue(node));
	}
	
	@Test
	public void tccOnMiscStructuresTest() throws IOException {
		List<TypeDeclaration> types = getTypes(new File("test/br/pucrio/opus/smells/tests/dummy/MiscStructures.java"));
		TypeDeclaration node = types.get(0);
		IsClassAbstract calc = new IsClassAbstract();
		Assert.assertEquals(Double.valueOf(0), calc.getValue(node));
	}
	
	@Test
	public void tccOnAnonymousClassTest() throws IOException {
		List<TypeDeclaration> types = getTypes(new File("test/br/pucrio/opus/smells/tests/dummy/AnonymousClass.java"));
		TypeDeclaration node = types.get(0);
		IsClassAbstract calc = new IsClassAbstract();
		Assert.assertEquals(Double.valueOf(1), calc.getValue(node));
	}
}
