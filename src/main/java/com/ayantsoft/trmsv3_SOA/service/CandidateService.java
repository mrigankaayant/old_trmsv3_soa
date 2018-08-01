package com.ayantsoft.trmsv3_SOA.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayantsoft.trmsv3_SOA.hibernate.dao.CandidateDao;
import com.ayantsoft.trmsv3_SOA.util.CandidateUtil;

@Service
public class CandidateService implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 8128757701332187752L;
	
	@Autowired
	private CandidateDao candidateDao;
	
	
	public List<CandidateUtil> findCandidate(String propertyName,String propertyValue){
		return candidateDao.findCandidate(propertyName, propertyValue);
	}
	

}
