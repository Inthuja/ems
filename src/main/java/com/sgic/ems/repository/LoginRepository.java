/**
 * 
 */
package com.sgic.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgic.ems.entity.Login;

/**
 * @author Elampoornan
 *
 */
@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{
	
	Login findByUserName(String userName);

}
