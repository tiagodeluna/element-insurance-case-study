package com.tiagodeluna.insurance.service;

import java.util.List;

import com.tiagodeluna.insurance.domain.Insurance;
import com.tiagodeluna.insurance.domain.Module;
import com.tiagodeluna.insurance.domain.ModuleType;
import com.tiagodeluna.insurance.persistence.InsuranceRepository;
import com.tiagodeluna.insurance.persistence.InsuranceRepositoryImpl;

public class InsuranceService {
	
	private InsuranceRepository insuranceRepository;

	public InsuranceService() {
		insuranceRepository = new InsuranceRepositoryImpl();
	}
	
	public Insurance newInsurance() {
		Insurance insurance = new Insurance();
		
		Module bike = new Module(ModuleType.BIKE, "Bike", 0.3, 0, 3000.0);
		insurance.getModules().add(bike);

		Module jewelry = new Module(ModuleType.JEWELRY, "Jewelry", 0.05, 500.0, 10000.0);
		insurance.getModules().add(jewelry);
		
		Module electronics = new Module(ModuleType.ELECTRONICS, "Electronics", 0.35, 500.0, 6000.0);
		insurance.getModules().add(electronics);

		Module sportsEquipment = new Module(ModuleType.SPORTS_EQUIPMENT, "Sports Equipment", 0.3, 0, 20000.0);
		insurance.getModules().add(sportsEquipment);
		
		insurance.calculateTariff();

		return insurance;
	}
	
	public void save(Insurance insurance) {
		insuranceRepository.save(insurance);
	}
	
	public List<Insurance> findAll() {
		List<Insurance> insurances = insuranceRepository.findAll(); 
		
		insurances.forEach(i -> {
			System.out.println(i);
			i.getModules().forEach(System.out::println);
		});
		
		return insurances;
	}
	
	public void deleteAll() {
		insuranceRepository.drop();
	}

	public void setInsuranceRepository(InsuranceRepository insuranceRepository) {
		this.insuranceRepository = insuranceRepository;
	}
	
}
