/**
 * 
 */
package com.sgic.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgic.ems.entity.Experience;

/**
 * @author Elampoornan
 *
 */
@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer>{

}
