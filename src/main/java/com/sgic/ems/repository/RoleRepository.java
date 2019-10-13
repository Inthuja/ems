/**
 * 
 */
package com.sgic.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgic.ems.entity.Role;

/**
 * @author Elampoornan
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}

