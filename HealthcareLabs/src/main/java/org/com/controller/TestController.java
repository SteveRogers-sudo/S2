package org.com.controller;

import java.util.List;
import javax.validation.Valid;

import org.com.dao.TestRepositories;
import org.com.error.RecordNotFoundException;
import org.com.model.Test;
import org.com.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
//@CrossOrigin("http://localhost:4200")
public class TestController {
	@Autowired
	TestRepositories dao;
	@Autowired
	TestService testservice;
	
	@RequestMapping("/allTests")
	public List<Test> getAllTests(){
		return testservice.getAllTest();
		}
	
	@PostMapping("/addTest")
    public ResponseEntity<Test> saveTest(@Valid @RequestBody Test test) {
            return  testservice.addTest(test);
    }
	
	@DeleteMapping("/deleteTest/{id}")
	public String removeTest(@PathVariable("id") Integer testid) {
			return testservice.removeTest(testid);
	}
	
	@PutMapping("/updateTest")
    public ResponseEntity<Test> updateTest(@Valid @RequestBody Test test) {
			return testservice.updateTest(test);
        }
	

	@RequestMapping("/searchTest/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> findTest(@PathVariable("id") Integer testid) {
		return testservice.findTest(testid);
	}
	

	
    }
//@PostMapping("/addTest")
//@ExceptionHandler(RecordNotFoundException.class)
//	public ResponseEntity<Test> saveTest(@RequestBody Test test) {
//	Optional<Test> findById=dao.findById(test.getTestId());
//	try{
//		if(!findById.isPresent()) {
//			dao.save(test);
//			return new ResponseEntity<Test>(test, HttpStatus.OK);
//		}
//		else
//			throw new RecordNotFoundException("Test already present...");
//	}
//	catch(RecordNotFoundException e){
//		return new ResponseEntity<Test>(test, HttpStatus.NOT_FOUND);
//	}
//}

//	@PutMapping("/updateTest")
//    public ResponseEntity<Test> updateTest(@Valid @RequestBody Test test) {
//
//        Optional<Test> findById = dao.findById(test.getTestId());
//        try {
//            if (findById.isPresent()) {
//                dao.save(test);
//                return new ResponseEntity<Test>(test, HttpStatus.OK);
//            	} 
//            else {
//                throw new RecordNotFoundException("Test not present");
//            }
//        }
//        catch (RecordNotFoundException e) {
//            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }

//	@PutMapping("/updateTest")
//	public String updateTest(@RequestBody Test test) {
//		Optional<Test> findById=dao.findById(test.getTestId());
//		if(findById.isPresent()) {
//			dao.save(test);
//			return "Test updated";
//		}
//		return "Test not present";
//	}

//@RequestMapping("/searchTest/{id}")
//@ExceptionHandler(RecordNotFoundException.class)
//public ResponseEntity<?> findTest(@PathVariable("id") Integer tid) {
//	Optional<Test> findById=dao.findById(tid);
//	try {
//		if(findById.isPresent()) {
//			Test test=findById.get();
//			return new ResponseEntity<Test>(test,HttpStatus.OK);
//		}
//		else
//			throw new RecordNotFoundException("Test not found");
//	}
//	catch(RecordNotFoundException e) {
//		return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
//	}
//}
