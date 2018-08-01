package com.ayantsoft.trmsv3_SOA.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayantsoft.trmsv3_SOA.service.CandidateService;
import com.ayantsoft.trmsv3_SOA.util.CandidateUtil;

@RestController
public class CandidateController implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5065686094913836208L;


	@Autowired
	private CandidateService candidateService;


	@RequestMapping(value = "/hr/candidates/{propertyName}/{propertyValue}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getCheck(@PathVariable String propertyName,@PathVariable String propertyValue) {
		List<CandidateUtil> candidates = null;
		HttpStatus httpStatus = null;
		try{

			if(propertyName.equals("id")||propertyName.equals("name")||propertyName.equals("email")||propertyName.equals("phone_no")){

				candidates = candidateService.findCandidate(propertyName, propertyValue);

				if(candidates == null || candidates.isEmpty()){
					httpStatus = HttpStatus.NO_CONTENT;
				}else{
					httpStatus = HttpStatus.OK;
				}
			}else{
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		}catch(Exception pe){
			pe.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<CandidateUtil>>(candidates, httpStatus);
	}

}
