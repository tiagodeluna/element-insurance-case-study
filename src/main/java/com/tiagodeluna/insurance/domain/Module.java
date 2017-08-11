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
	private boolean active;
	
	public Module() {
		super();
	}

	/**
	 * Constructor with non-transient fields.
	 * @param type
	 * @param name
	 * @param risk
	 * @param coverage
	 */
	public Module(ModuleType type, String name, double risk, double coverage) {
		super();
		this.name = name;
		this.type = type;
		this.coverage = coverage;
		this.risk = risk;
		this.active = true;
	}

	/**
	 * Constructor that sets all fields.
	 * @param type
	 * @param name
	 * @param risk
	 * @param minCoverage
	 * @param maxCoverage
	 */
	public Module(ModuleType type, String name, double risk, double minCoverage, double maxCoverage) {
		this(type, name, risk, minCoverage);
		this.minCoverage = minCoverage;
		this.maxCoverage = maxCoverage;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return String.format("Module >> Name: %s, Type: %s, Risk: %s",
				this.name, this.type.toString(), this.risk * 100);
	}
}
