package com.cg.iter.testController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.testDTO.Test;
import com.cg.iter.testService.TestService;

@RestController
@RequestMapping("/test")
public class TestController {
	
	TestService testService;

	@GetMapping ("/allTest")
	List<Test> getAllTest(){
		return testService.getAllTest();
	}
	
	@PostMapping("/addTest")
	String saveTest(@RequestBody Test test) {
		String success = "Product added";
		if(testService.saveTest(test)) {
			return success;
		}
		return "failed to add";
	}
	
	@PostMapping("/removeTest")
	String removeTest(@RequestParam String tid) {
		String success = "Product added";
		if(testService.removeTest(tid)) {
			return success;
		}
		return "failed to remove";
	}
	
	@PostMapping("/updateTest")
	String updateTest(@RequestBody Test test) {
		String success = "Product updated";
		if(testService.updateTest(test)) {
			return success;
		}
		return "failed to update";
	}
	
}
