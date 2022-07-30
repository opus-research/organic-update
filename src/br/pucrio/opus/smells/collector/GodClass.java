package br.pucrio.opus.smells.collector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.pucrio.opus.smells.metrics.AggregateMetricValues;
import br.pucrio.opus.smells.metrics.MetricName;
import br.pucrio.opus.smells.resources.Resource;

/**
 * All classes having (i) cohesion lower than the average of the system AND (ii) LOCs > 500
 * @author Diego Cedrim
 */
public class GodClass extends SmellDetector {
	
	@Override
	public List<Smell> detect(Resource resource) {
		AggregateMetricValues aggregate = AggregateMetricValues.getInstance();
		Double classLOC = resource.getMetricValue(MetricName.CELOC);
		Double classLOCAvg = aggregate.getAverageValue(MetricName.CELOC);
		Double classTCC = resource.getMetricValue(MetricName.TCC);
		Double tccAvg = aggregate.getAverageValue(MetricName.TCC);
		Double methodWMC = resource.getMetricValue(MetricName.WMC);
		Double wmcAvg = aggregate.getAverageValue(MetricName.WMC);
		Double thirdQuartileWmc = wmcAvg + (wmcAvg/2);

		if (classLOC >= classLOCAvg && methodWMC >= thirdQuartileWmc && (classTCC < tccAvg)) {
			StringBuilder builder = new StringBuilder();
			builder.append("CLOC: " + classLOC);
			builder.append("CLOC >= " + classLOCAvg);
			builder.append(", TCC: " + classTCC);
			builder.append(", TCC < " + tccAvg);
			builder.append(", WMC: " + methodWMC);
			builder.append(", WMCAvg: " + wmcAvg);
			builder.append(", thirdQuartileWmc: " + thirdQuartileWmc);
			builder.append(", WMC >= " + thirdQuartileWmc);
			
			Smell smell = super.createSmell(resource);
			smell.setReason(builder.toString());
			return Arrays.asList(smell);
		}
		return new ArrayList<>();
	}
	
	@Override
	protected SmellName getSmellName() {
		return SmellName.GodClass;
	}

}
