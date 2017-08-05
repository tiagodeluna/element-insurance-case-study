package com.tiagodeluna.insurance.domain;

import org.springframework.data.annotation.Transient;

public class Module {

	private ModuleType type;
	private String name;
	private double coverage;
	private double risk;
	@Transient
	private double minCoverage;
	@Transient
	private double maxCoverage;
	
	public Module() {
		super();
		this.coverage = 0;
		this.risk = 0;
	}

	public Module(String name, ModuleType type, double coverage, double risk) {
		super();
		this.name = name;
		this.type = type;
		this.coverage = coverage;
		this.risk = risk;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getCoverage() {
		return coverage;
	}
	
	public void setCoverage(double coverage) {
		this.coverage = coverage;
	}
	
	public double getRisk() {
		return risk;
	}
	
	public void setRisk(double risk) {
		this.risk = risk;
	}

	public ModuleType getType() {
		return type;
	}

	public void setType(ModuleType type) {
		this.type = type;
	}
	
	public double getMinCoverage() {
		return minCoverage;
	}

	public void setMinCoverage(double minCoverage) {
		this.minCoverage = minCoverage;
	}

	public double getMaxCoverage() {
		return maxCoverage;
	}

	public void setMaxCoverage(double maxCoverage) {
		this.maxCoverage = maxCoverage;
	}

	@Override
	public String toString() {
		return String.format("Module >> Name: %s, Type: %s, Risk: %s",
				this.name, this.type.toString(), this.risk * 100);
	}
}
