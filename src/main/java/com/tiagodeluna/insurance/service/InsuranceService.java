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
		
		Module bike = new Module();
		bike.setName("Bike");
		bike.setType(ModuleType.BIKE);
		bike.setRisk(0.3);
		bike.setCoverage(0);
		bike.setMinCoverage(0);
		bike.setMaxCoverage(3000.0);
		insurance.getModules().add(bike);

		Module jewelry = new Module();
		jewelry.setName("Jewelry");
		jewelry.setType(ModuleType.JEWELRY);
		jewelry.setRisk(0.05);
		jewelry.setCoverage(500);
		jewelry.setMinCoverage(500.0);
		jewelry.setMaxCoverage(10000.0);
		insurance.getModules().add(jewelry);
		
		Module electronics = new Module();
		electronics.setName("Electronics");
		electronics.setType(ModuleType.ELECTRONICS);
		electronics.setRisk(0.35);
		electronics.setCoverage(500);
		electronics.setMinCoverage(500.0);
		electronics.setMaxCoverage(6000.0);
		insurance.getModules().add(electronics);

		Module sportsEquipment = new Module();
		sportsEquipment.setName("Sports Equipment");
		sportsEquipment.setType(ModuleType.SPORTS_EQUIPMENT);
		sportsEquipment.setRisk(0.3);
		sportsEquipment.setCoverage(0);
		sportsEquipment.setMinCoverage(0);
		sportsEquipment.setMaxCoverage(20000.0);
		insurance.getModules().add(sportsEquipment);
		
		insurance.calculateTariff();

		return insurance;
	}
	
	public void save(Insurance insurance) {
		insuranceRepository.save(insurance);
	}
	
	public List<Insurance> findAll() {
		List<Insurance> insurances = insuranceRepository.findAll(); 
		
		for (Insurance insurance : insurances) {
			System.out.println(insurance);
			insurance.getModules().forEach(System.out::println);
		}
		
		return insurances;
	}
	
	public void deleteAll() {
		insuranceRepository.drop();
	}
}
