package br.pucrio.opus.smells.tests.smells;

import br.pucrio.opus.smells.ast.visitors.MethodCollector;
import br.pucrio.opus.smells.ast.visitors.TypeDeclarationCollector;
import br.pucrio.opus.smells.collector.InflatedException;
import br.pucrio.opus.smells.collector.Smell;
import br.pucrio.opus.smells.resources.Type;
import br.pucrio.opus.smells.tests.util.CompilationUnitLoader;
import br.pucrio.opus.smells.tests.util.GenericCollector;
import br.pucrio.opus.smells.tests.util.TypeLoader;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class InflatedExceptionTest {

    @Test
    public void InflatedExceptionTest() throws IOException {
        Type type = TypeLoader.loadOne(new File("test/br/pucrio/opus/smells/tests/dummy/Throws.java"));
        GenericCollector.collectTypeAndMethodsMetricValues(type);
        InflatedException smellDetector = new InflatedException();
        List<Smell> smells = smellDetector.detect(type.findMethodByName("m4"));
        Assert.assertEquals(1, smells.size());
    }
}
