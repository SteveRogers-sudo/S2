/**
 * 
 */
package com.cg.iter.testRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.iter.testDTO.Test;

/**
 * @author Bishal
 *
 */
public interface TestRepository extends JpaRepository<Test, String>{

}
