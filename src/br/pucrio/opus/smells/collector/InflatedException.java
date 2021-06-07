package br.pucrio.opus.smells.collector;

import br.pucrio.opus.smells.metrics.AggregateMetricValues;
import br.pucrio.opus.smells.metrics.MetricName;
import br.pucrio.opus.smells.resources.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InflatedException extends SmellDetector {
    @Override
    public List<Smell> detect(Resource resource) {
        AggregateMetricValues aggregate = AggregateMetricValues.getInstance();
        Double numberOfThrownExceptionTypes = resource.getMetricValue(MetricName.ThrownExceptionTypesCount);
        if (numberOfThrownExceptionTypes >= 3){
            String reasoning = "NumberOfThrownExceptionTypes >= 3";
            Smell smell = super.createSmell(resource);
            smell.setReason(reasoning);
            return Arrays.asList(smell);
        }
        return new ArrayList<>();
    }

    @Override
    protected SmellName getSmellName() {
        return SmellName.InflatedException;
    }
}
