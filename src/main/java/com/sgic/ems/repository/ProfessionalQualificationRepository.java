/**
 * 
 */
package com.sgic.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgic.ems.entity.ProfessionalQualification;
import com.sgic.ems.entity.User;

/**
 * @author Elampoornan
 *
 */
@Repository
public interface ProfessionalQualificationRepository extends JpaRepository<ProfessionalQualification, Integer>{
	
	List<ProfessionalQualification> getByUser(User user);

}
