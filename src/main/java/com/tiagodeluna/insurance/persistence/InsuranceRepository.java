package com.tiagodeluna.insurance.persistence;

import java.util.List;

import com.tiagodeluna.insurance.domain.Insurance;

public interface InsuranceRepository {

	void save(Insurance insurance);
	
	List<Insurance> findAll();
	
	void drop();
}
