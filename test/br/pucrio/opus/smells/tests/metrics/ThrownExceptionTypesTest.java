package br.pucrio.opus.smells.tests.metrics;

import br.pucrio.opus.smells.ast.visitors.MethodCollector;
import br.pucrio.opus.smells.ast.visitors.TypeDeclarationCollector;
import br.pucrio.opus.smells.metrics.calculators.ThrownExceptionTypesCalculator;
import br.pucrio.opus.smells.tests.util.CompilationUnitLoader;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ThrownExceptionTypesTest {

    private CompilationUnit compilationUnit;
    private List<MethodDeclaration> methods;

    private MethodDeclaration findMethodByName(String name) {
        for (MethodDeclaration decls : methods) {
            if (decls.getName().toString().equals(name)) {
                return decls;
            }
        }
        return null;
    }

    @Before
    public void setup() throws IOException {
        this.compilationUnit = CompilationUnitLoader.getCompilationUnitDummyClass("Throws.java");

        TypeDeclarationCollector typeVisitor = new TypeDeclarationCollector();
        this.compilationUnit.accept(typeVisitor);
        TypeDeclaration type = typeVisitor.getNodesCollected().get(0);

        MethodCollector collector = new MethodCollector();
        type.accept(collector);
        methods = collector.getNodesCollected();
    }

    private Double getMetric(MethodDeclaration declaration) {
        ThrownExceptionTypesCalculator calc = new ThrownExceptionTypesCalculator();
        return calc.getValue(declaration);
    }

    @Test
    public void oneTest() {
        MethodDeclaration decl = findMethodByName("m1");
        Assert.assertEquals(Double.valueOf(1), getMetric(decl));
    }

    @Test
    public void twoTest() {
        MethodDeclaration decl = findMethodByName("m2");
        Assert.assertEquals(Double.valueOf(2), getMetric(decl));
    }

    @Test
    public void noneTest() {
        MethodDeclaration decl = findMethodByName("m3");
        Assert.assertEquals(Double.valueOf(0), getMetric(decl));
    }

    @Test
    public void fiveTest() {
        MethodDeclaration decl = findMethodByName("m4");
        Assert.assertEquals(Double.valueOf(5), getMetric(decl));
    }
}
