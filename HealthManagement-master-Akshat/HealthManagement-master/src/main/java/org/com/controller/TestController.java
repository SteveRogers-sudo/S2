package org.com.controller;

import java.util.List;
import java.util.Optional;
import org.com.dao.TestRepositories;
import org.com.error.RecordNotFoundException;
import org.com.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")

public class TestController {
	@Autowired
	TestRepositories dao;
	
	@RequestMapping("/allTest")
	public List<Test> getAllTest(){
		return dao.findAll();
		}
	
	@RequestMapping("/searchTest/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> findTest(@PathVariable("id") String tid) {
		Optional<Test> findById=dao.findById(tid);
		try {
			if(findById.isPresent()) {
				Test test=findById.get();
				return new ResponseEntity<Test>(test,HttpStatus.OK);
			}
			else
				throw new RecordNotFoundException("Record not found");
		}
		catch(RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/addProduct",method = RequestMethod.POST)
//	@PostMapping("/addProduct")
	@ExceptionHandler(RecordNotFoundException.class)
		public ResponseEntity<Test> saveTest(@RequestBody Test test) {
		Optional<Test> findById=dao.findById(test.getTestId());
		try{
			if(!findById.isPresent()) {
				dao.save(test);
				return new ResponseEntity<Test>(test, HttpStatus.OK);
			}
			else
				throw new RecordNotFoundException("Record already present...");
		}
		catch(RecordNotFoundException e){
			return new ResponseEntity<Test>(test, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deleteTest/{id}")
	public String removeTest(@PathVariable("id") String tid) {
		Optional<Test> findById=dao.findById(tid);
		if(findById.isPresent()) {
			dao.deleteById(tid);
			return "test removed";
		}
		return "test not present";
	}
	
	@PutMapping("/updateTest")
	public String updateTest(@RequestBody Test test) {
		Optional<Test> findById=dao.findById(test.getTestId());
		if(findById.isPresent()) {
			dao.save(test);
			return "test updated";
		}
		return "test not present";
	}
	
	@RequestMapping("/averageCost")
	public String getAvgCost(){
		return "average cost: "+dao.getAvgCost();
	}
	
	@RequestMapping("/totalProducts")
	public String totalProducts(){
		return "total products: "+dao.count();
	}

}
