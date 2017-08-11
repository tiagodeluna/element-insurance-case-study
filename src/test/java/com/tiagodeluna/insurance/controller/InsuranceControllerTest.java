package com.tiagodeluna.insurance.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.tiagodeluna.insurance.domain.Insurance;
import com.tiagodeluna.insurance.service.InsuranceService;

public class InsuranceControllerTest {

	private InsuranceController insuranceController;
	private InsuranceService insuranceService;
	
	@Before
	public void init() {
		this.insuranceService = EasyMock.createMock(InsuranceService.class);
		this.insuranceController = new InsuranceController(this.insuranceService);
	}
	
	@Test
	public void testGetAll(){
		List<Insurance> insurances = new ArrayList<>();
		
		EasyMock.expect(this.insuranceService.findAll()).andReturn(insurances);
		EasyMock.replay(this.insuranceService);
		
		this.insuranceService.findAll();
		
		assertEquals(insurances, insurances);
	}

	@Test
	public void testGetNew() {
		Insurance insurance = new Insurance();
		
		EasyMock.expect(this.insuranceService.newInsurance()).andReturn(insurance);
		EasyMock.replay(this.insuranceService);
		
		this.insuranceService.newInsurance();
		
		assertEquals(insurance, insurance);
	}

	@Test
	public void testSave(){
		Insurance insurance = new Insurance();
		Insurance newInsurance = new Insurance();
		
		this.insuranceService.save(insurance);
		EasyMock.expectLastCall();
		
		EasyMock.expect(this.insuranceService.newInsurance()).andReturn(newInsurance);
		EasyMock.replay(this.insuranceService);
		
		Insurance result = this.insuranceController.save(insurance);
		
		assertEquals(newInsurance, result);
		
	}
	
	@Test
	public void testCalculate(){
		Insurance insuranceMock = EasyMock.createMock(Insurance.class);
		
		insuranceMock.calculateTariff();
		EasyMock.expectLastCall();
		
		Insurance result = this.insuranceController.calculate(insuranceMock);
		
		assertEquals(insuranceMock, result);
	}
}
