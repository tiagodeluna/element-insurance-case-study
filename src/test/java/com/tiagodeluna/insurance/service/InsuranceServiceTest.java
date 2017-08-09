package com.tiagodeluna.insurance.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.tiagodeluna.insurance.domain.Insurance;
import com.tiagodeluna.insurance.persistence.InsuranceRepository;
import com.tiagodeluna.insurance.persistence.InsuranceRepositoryImpl;

public class InsuranceServiceTest {

	private InsuranceService insuranceService;
	private InsuranceRepository insuranceRepository;
	
	@Before
	public void init() {
		this.insuranceService = new InsuranceService();

		this.insuranceRepository = EasyMock.createMock(InsuranceRepositoryImpl.class);
		this.insuranceService.setInsuranceRepository(this.insuranceRepository);
	}
	
	@Test
	public void testNewInsurance() {
		Insurance insurance = this.insuranceService.newInsurance();
		
		assertNotNull(insurance);
		assertNotNull(insurance.getModules());
		assertEquals(4, insurance.getModules().size());
	}
	
	@Test
	public void testSave() {
		Insurance insurance = new Insurance();
		
		this.insuranceRepository.save(insurance);
		EasyMock.expectLastCall();
		
		this.insuranceService.save(insurance);
	}
	
	@Test
	public void testFindAll() {
		List<Insurance> insurances = new ArrayList<Insurance>();
		
		EasyMock.expect(this.insuranceRepository.findAll()).andReturn(insurances);
		EasyMock.replay(this.insuranceRepository);
		
		List<Insurance> result = this.insuranceService.findAll();
		
		assertEquals(result, insurances);
		
	}
	
	@Test
	public void testDeleteAll() {
		this.insuranceRepository.drop();
		EasyMock.expectLastCall();
		
		this.insuranceService.deleteAll();
	}
}
