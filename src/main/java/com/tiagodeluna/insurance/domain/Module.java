package com.tiagodeluna.insurance.domain;

public class Module {

//	@Id
//	@ObjectId
//	private String id;
	private ModuleType type;
	private String name;
	private double coverage;
	private double risk;
	
	
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
	
//	@ObjectId
//	public String getId() {
//		return id;
//	}

//	@ObjectId
//	public void setId(String id) {
//		this.id = id;
//	}

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
	
	@Override
	public String toString() {
		return String.format("Module >> Name: %s, Type: %s, Risk: %s",
				this.name, this.type.toString(), this.risk * 100);
	}
}
