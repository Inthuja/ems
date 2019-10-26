/**
 * 
 */
package com.sgic.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgic.ems.entity.Experience;
import com.sgic.ems.entity.User;

/**
 * @author Elampoornan
 *
 */
@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer>{

	List<Experience> getByUser(User user);
}
