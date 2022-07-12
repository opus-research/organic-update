package br.pucrio.opus.smells.tests.metrics;

import br.pucrio.opus.smells.ast.visitors.MethodCollector;
import br.pucrio.opus.smells.ast.visitors.TypeDeclarationCollector;
import br.pucrio.opus.smells.metrics.calculators.*;
import br.pucrio.opus.smells.tests.util.CompilationUnitLoader;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class RobustnessMetricsTest {

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
        this.compilationUnit = CompilationUnitLoader.getCompilationUnitDummyClass("TryCatch.java");

        TypeDeclarationCollector typeVisitor = new TypeDeclarationCollector();
        this.compilationUnit.accept(typeVisitor);
        TypeDeclaration type = typeVisitor.getNodesCollected().get(0);

        MethodCollector collector = new MethodCollector();
        type.accept(collector);
        methods = collector.getNodesCollected();
    }

    @Test
    public void tryCountTest() {
        NumberOfTryCalculator calc = new NumberOfTryCalculator();
        Assert.assertEquals(Double.valueOf(0), calc.getValue(findMethodByName("m1")));
        Assert.assertEquals(Double.valueOf(1), calc.getValue(findMethodByName("m21")));
        Assert.assertEquals(Double.valueOf(1), calc.getValue(findMethodByName("m22")));
        Assert.assertEquals(Double.valueOf(1), calc.getValue(findMethodByName("m23")));
        Assert.assertEquals(Double.valueOf(1), calc.getValue(findMethodByName("m24")));
        Assert.assertEquals(Double.valueOf(3), calc.getValue(findMethodByName("m31")));
        Assert.assertEquals(Double.valueOf(2), calc.getValue(findMethodByName("m51")));
    }

    @Test
    public void catchCountTest() {
        NumberOfCatchCalculator calc = new NumberOfCatchCalculator();
        Assert.assertEquals(Double.valueOf(2), calc.getValue(findMethodByName("m21")));
        Assert.assertEquals(Double.valueOf(3), calc.getValue(findMethodByName("m22")));
        Assert.assertEquals(Double.valueOf(0), calc.getValue(findMethodByName("m23")));
        Assert.assertEquals(Double.valueOf(0), calc.getValue(findMethodByName("m24")));
        Assert.assertEquals(Double.valueOf(3), calc.getValue(findMethodByName("m31")));
        Assert.assertEquals(Double.valueOf(0), calc.getValue(findMethodByName("m51")));
    }

    @Test
    public void finallyCountTest() {
        NumberOfFinallyCalculator calc = new NumberOfFinallyCalculator();
        Assert.assertEquals(Double.valueOf(0), calc.getValue(findMethodByName("m21")));
        Assert.assertEquals(Double.valueOf(0), calc.getValue(findMethodByName("m22")));
        Assert.assertEquals(Double.valueOf(0), calc.getValue(findMethodByName("m23")));
        Assert.assertEquals(Double.valueOf(1), calc.getValue(findMethodByName("m24")));
        Assert.assertEquals(Double.valueOf(1), calc.getValue(findMethodByName("m31")));
        Assert.assertEquals(Double.valueOf(2), calc.getValue(findMethodByName("m51")));
    }

    @Test
    public void throwsCountTest() {
        NumberOfThrowCalculator calc = new NumberOfThrowCalculator();
        Assert.assertEquals(Double.valueOf(1), calc.getValue(findMethodByName("m21")));
        Assert.assertEquals(Double.valueOf(1), calc.getValue(findMethodByName("m22")));
        Assert.assertEquals(Double.valueOf(0), calc.getValue(findMethodByName("m23")));
        Assert.assertEquals(Double.valueOf(0), calc.getValue(findMethodByName("m31")));
    }

    @Test
    public void tryNoCatchFinallyTest() {
        TryNoCatchFinallyCalculator calc = new TryNoCatchFinallyCalculator();
        Assert.assertEquals(Double.valueOf(0), calc.getValue(findMethodByName("m21")));
        Assert.assertEquals(Double.valueOf(0), calc.getValue(findMethodByName("m22")));
        Assert.assertEquals(Double.valueOf(0), calc.getValue(findMethodByName("m23")));
        Assert.assertEquals(Double.valueOf(1), calc.getValue(findMethodByName("m24")));
        Assert.assertEquals(Double.valueOf(0), calc.getValue(findMethodByName("m31")));
        Assert.assertEquals(Double.valueOf(0), calc.getValue(findMethodByName("m41")));
        Assert.assertEquals(Double.valueOf(2), calc.getValue(findMethodByName("m51")));
    }

    @Test
    public void dummyHandlerTest() {
        DummyExceptionHandlerCalculator calc = new DummyExceptionHandlerCalculator();
        Assert.assertEquals(Double.valueOf(1), calc.getValue(findMethodByName("m61")));
        Assert.assertEquals(Double.valueOf(1), calc.getValue(findMethodByName("m62")));
        Assert.assertEquals(Double.valueOf(1), calc.getValue(findMethodByName("m63")));
        Assert.assertEquals(Double.valueOf(1), calc.getValue(findMethodByName("m64")));
        Assert.assertEquals(Double.valueOf(1), calc.getValue(findMethodByName("m65")));
        Assert.assertEquals(Double.valueOf(0), calc.getValue(findMethodByName("m66")));
    }

    @Test
    public void exceptionalLOCTest() {
        ExceptionalELOCCalculator calc = new ExceptionalELOCCalculator();
        Assert.assertEquals(Double.valueOf(5), calc.getValue(findMethodByName("m21")));
        Assert.assertEquals(Double.valueOf(6), calc.getValue(findMethodByName("m22")));
        Assert.assertEquals(Double.valueOf(3), calc.getValue(findMethodByName("m23")));
        Assert.assertEquals(Double.valueOf(6), calc.getValue(findMethodByName("m24")));
        Assert.assertEquals(Double.valueOf(14), calc.getValue(findMethodByName("m31")));
        Assert.assertEquals(Double.valueOf(14), calc.getValue(findMethodByName("m41")));
    }
}
