package com.tiagodeluna.insurance.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	
	private static final Logger LOGGER = Logger.getLogger(InsuranceController.class.getName());

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
		LOGGER.log(Level.FINE, "Instantiating new Insurance");
		return insuranceService.newInsurance();
	}

	@POST
	public Insurance save(Insurance insurance){
		LOGGER.log(Level.FINE, "Saving Insurance");
		insuranceService.save(insurance);
		return insuranceService.newInsurance();
	}
	
	@POST
	@Path("/calculate")
	public Insurance calculate(Insurance insurance){
		LOGGER.log(Level.FINE, "Calculating Insurance tariff");
		insurance.calculateTariff();
		return insurance;
	}

	public void setInsuranceService(InsuranceService insuranceService) {
		this.insuranceService = insuranceService;
	}
	
}
