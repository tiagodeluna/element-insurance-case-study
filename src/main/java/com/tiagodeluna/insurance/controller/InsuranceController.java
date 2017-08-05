package com.tiagodeluna.insurance.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tiagodeluna.insurance.domain.Insurance;
import com.tiagodeluna.insurance.service.InsuranceService;

@Path("/insurance")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InsuranceController {

	private InsuranceService insuranceService;

	public InsuranceController() {
		super();
		insuranceService = new InsuranceService();
	}
	
	@GET
	public List<Insurance> getAll(){
		return insuranceService.findAll();
	}

	@GET
	@Path("/new")
	public Insurance getNew() {
		System.out.println("Instantiating...");
		return insuranceService.newInsurance();
	}

	@POST
	public Insurance save(Insurance insurance){
		System.out.println("Saving...");
		insuranceService.save(insurance);
		insurance = insuranceService.newInsurance();
		return insurance;
	}
	
	@POST
	@Path("/calculate")
	public Insurance calculate(Insurance insurance){
		insurance.calculateTariff();
		System.out.println("Calculating tariff...");
		return insurance;
	}
}
