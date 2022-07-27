package br.pucrio.opus.smells.tests.smells;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.pucrio.opus.smells.collector.GodClass;
import br.pucrio.opus.smells.collector.Smell;
import br.pucrio.opus.smells.collector.SmellName;
import br.pucrio.opus.smells.metrics.AggregateMetricValues;
import br.pucrio.opus.smells.resources.Type;
import br.pucrio.opus.smells.tests.util.GenericCollector;
import br.pucrio.opus.smells.tests.util.TypeLoader;

public class GodClassTest {
	
	@Before
	public void setup() {
		AggregateMetricValues aggr = AggregateMetricValues.getInstance();
		aggr.reset();
	}


	@Test
	public void firstStrategyClocAndTccTest() throws Exception {
		Type godClass = TypeLoader.loadOne(new File("test/br/pucrio/opus/smells/tests/dummy/GodClassFirstStrategy.java"));
		Type normalClass = TypeLoader.loadOne(new File("test/br/pucrio/opus/smells/tests/dummy/AnonymousClass.java"));
		Type normalClass2 = TypeLoader.loadOne(new File("test/br/pucrio/opus/smells/tests/dummy/FieldAccessedByMethod.java"));
		GenericCollector.collectTypeAndMethodsMetricValues(godClass);
		GenericCollector.collectTypeAndMethodsMetricValues(normalClass);
		GenericCollector.collectTypeAndMethodsMetricValues(normalClass2);

		GodClass smellDetector = new GodClass();
		List<Smell> smells = smellDetector.detect(godClass);
		Smell smell = smells.get(0);
		Assert.assertEquals(1, smells.size());
		Assert.assertEquals(SmellName.GodClass, smell.getName());
	}


	@Test
	public void secondStrategyWmcTest() throws Exception {
		Type godClass = TypeLoader.loadOne(new File("test/br/pucrio/opus/smells/tests/dummy/GodClassFirstStrategy.java"));
		Type normalClass = TypeLoader.loadOne(new File("test/br/pucrio/opus/smells/tests/dummy/AnonymousClass.java"));
		GenericCollector.collectTypeAndMethodsMetricValues(godClass);
		GenericCollector.collectTypeAndMethodsMetricValues(normalClass);

		GodClass smellDetector = new GodClass();
		List<Smell> smells = smellDetector.detect(godClass);
		Smell smell = smells.get(0);
		Assert.assertEquals(1, smells.size());
		Assert.assertEquals(SmellName.GodClass, smell.getName());

	}


}
