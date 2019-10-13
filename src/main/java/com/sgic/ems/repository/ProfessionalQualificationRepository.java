/**
 * 
 */
package com.sgic.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgic.ems.entity.ProfessionalQualification;

/**
 * @author Elampoornan
 *
 */
@Repository
public interface ProfessionalQualificationRepository extends JpaRepository<ProfessionalQualification, Integer>{

}
