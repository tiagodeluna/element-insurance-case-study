package com.tiagodeluna.insurance.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tiagodeluna.insurance.domain.Insurance;
import com.tiagodeluna.insurance.service.InsuranceService;

@RestController
@RequestMapping("api")
public class InsuranceController {

	private static final Logger LOGGER = Logger.getLogger(InsuranceController.class.getName());

	private InsuranceService insuranceService;

	@Autowired
	public InsuranceController(InsuranceService insuranceService) {
		super();
		this.insuranceService = insuranceService;
	}
	
//	@RequestMapping("/greeting")
//	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
//		return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
//	}
	
	@RequestMapping
	public List<Insurance> getAll(){
		return insuranceService.findAll();
	}

	@RequestMapping("/new")
	public Insurance getNew() {
		LOGGER.log(Level.FINE, "Instantiating new Insurance");
		return insuranceService.newInsurance();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Insurance save(@RequestBody Insurance insurance){
		LOGGER.log(Level.FINE, "Saving Insurance");
		insuranceService.save(insurance);
		return insuranceService.newInsurance();
	}

	@RequestMapping(method=RequestMethod.POST, value="/calculate")
	public Insurance calculate(@RequestBody Insurance insurance){
		LOGGER.log(Level.FINE, "Calculating Insurance tariff");
		insurance.calculateTariff();
		return insurance;
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public void delete() {
		LOGGER.log(Level.FINE, "Removing all Insurances");
		insuranceService.deleteAll();
	}


}
