package br.pucrio.opus.smells.collector;

import com.google.gson.annotations.Expose;

public class Smell {

	@Expose	private SmellName name;

	@Expose private String reason;
	
	/**
	 * Line of code where the smell starts to appear
	 */
	@Expose private Integer startingLine;

	@Expose private Integer endingLine;
	
	public Smell(SmellName name) {
		this.name = name;
	}
	
	public Smell(SmellName name, String reason) {
		this.name = name;
		this.reason = reason;
	}
	
	public Smell(SmellName name, String reason, Integer line) {
		this.name = name;
		this.reason = reason;
		this.startingLine = line;
	}

	public SmellName getName() {
		return name;
	}

	public void setName(SmellName name) {
		this.name = name;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getStartingLine() {
		return startingLine;
	}

	public void setStartingLine(Integer line) {
		this.startingLine = line;
	}

	public Integer getEndingLine() {
		return endingLine;
	}

	public void setEndingLine(Integer endingLine) {
		this.endingLine = endingLine;
	}
	
}
