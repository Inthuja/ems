/**
 * 
 */
package com.sgic.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgic.ems.entity.AcadamicQualification;

/**
 * @author Elampoornan
 *
 */
@Repository
public interface AcadamicQualificationRepository extends JpaRepository<AcadamicQualification, Integer> {

}
