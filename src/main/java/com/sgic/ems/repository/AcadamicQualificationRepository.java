/**
 * 
 */
package com.sgic.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgic.ems.entity.AcadamicQualification;
import com.sgic.ems.entity.User;

/**
 * @author Elampoornan
 *
 */
@Repository
public interface AcadamicQualificationRepository extends JpaRepository<AcadamicQualification, Integer> {

	List<AcadamicQualification> getByUser(User user);
}
