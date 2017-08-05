package com.tiagodeluna.insurance.domain;

import java.util.ArrayList;
import java.util.List;

import org.mongojack.Id;
import org.mongojack.ObjectId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) 
public class Insurance {

	@Id
	@ObjectId
	private String id;
	private String clientName;
	private List<Module> modules;
	private double tariff;

	@ObjectId
	public String getId() {
		return id;
	}

	@ObjectId
	public void setId(String id) {
		this.id = id;
	}

	public Insurance() {
		super();
		this.modules = new ArrayList<Module>();
		this.tariff = 0;
	}
	
	public Insurance(String clientName, List<Module> modules, double tariff) {
		super();
		this.clientName = clientName;
		this.modules = modules;
		this.tariff = tariff;
	}

	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public List<Module> getModules() {
		return modules;
	}
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	public double getTariff() {
		return tariff;
	}
	public void setTariff(double tariff) {
		this.tariff = tariff;
	}
	public void calculateTariff() {
		this.tariff = 0;
		
		for(Module m : this.modules) {
			this.tariff = this.tariff + (m.getCoverage()*m.getRisk());
		}
	}
	@Override
	public String toString() {
		return String.format("Insurance >> Id: %s, Client: %s, Tariff: %s", this.id, this.clientName, this.tariff);
	}
}
