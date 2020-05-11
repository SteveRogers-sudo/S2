package com.cg.iter.testService;

import java.util.List;
import java.util.Optional;

import com.cg.iter.testException.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.iter.testDTO.Test;
import com.cg.iter.testRepository.TestRepository;

/**
 * @author Bishal
 *
 */
@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	TestRepository testRepo;

	
	@Override
	public List<Test> getAllTest() {
		return (List<Test>)testRepo.findAll();
	}
	
	@Override
	public boolean saveTest(Test test) {
		Optional<Test> find=testRepo.findById(test.getTestId());
		/*
		 * try{ if(!findById.isPresent()) { testRepo.save(test); return new
		 * ResponseEntity<Test>(test, HttpStatus.OK); } else throw new
		 * RecordNotFoundException("Already exists"); } catch(RecordNotFoundException
		 * e){ return new ResponseEntity<Test>(test, HttpStatus.NOT_FOUND); }
		 */
		if(find.isPresent()){
			testRepo.save(test);
			return true;
		}
		return false;
	}
	@Override
	public boolean removeTest(String tid) {
		Optional<Test> findById=testRepo.findById(tid);
		if(findById.isPresent()) {
			testRepo.deleteById(tid);
			return true;
		}
		return false;
	}

	

	@Override
	public boolean updateTest(Test test) {
		Optional<Test> findById=testRepo.findById(test.getTestId());
		if(findById.isPresent()) {
			testRepo.save(test);
			return true;
		}
		return false;
	}


}
