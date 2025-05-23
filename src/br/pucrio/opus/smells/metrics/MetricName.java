package br.pucrio.opus.smells.metrics;

public enum MetricName {
	CELOC("ClassEffectiveLinesOfCode"),
	MELOC("MethodEffectiveLinesOfCode"),
	CC("CyclomaticComplexity"),
	IsAbstract,
	MaxCallChain,
	ParameterCount,
	OverrideRatio,
	PublicFieldCount,
	TCC("TightClassCohesion"),
	MaxNesting,
	NOAV("NumberOfAccessedVariables"),
	NOAM("NumberOfAccessorMethods"),
	WMC("WeightedMethodCount"),
	WOC("WeighOfClass"),
	CINT("CouplingIntensity"),
	CDISP("CouplingDispersion"),
	ChangingClasses("ChangingClasses"),
	ChangingMethods("ChangingMethods"),
	LCOM("LackOfCohesionOfMethods"),
	LCOM2,
	LCOM3,
	TryCount("NumberOfTryStatements"),
	CatchCount("NumberOfCatchStatements"),
	FinallyCount("NumberOfFinallyStatements"),
	ThrowCount("NumberOfThrowStatements"),
	TryNoCatchFinallyCount("NumberOfTryStatementsWithNoCatchAndFinally"),
	ThrownExceptionTypesCount,
	DummyExceptionHandlerCount("NumberOfDummyExceptionHandlers"),
	ExceptionalLOC;
	
	private String label;
	
	private MetricName() {
		this.label = name();
	}
	
	private MetricName(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	@Override
	public String toString() {
		return label;
	}
	
	
}
