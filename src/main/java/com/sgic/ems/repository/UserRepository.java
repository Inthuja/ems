/**
 * 
 */
package com.sgic.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgic.ems.entity.User;

/**
 * @author Elampoornan
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
