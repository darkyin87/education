package com.ak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ak.model.UserRoles;

public interface UserRolesRepository extends JpaRepository<UserRoles, Long> {

	//@Query("select a.role from UserRole a, User b where b.userName=?1 and a.userid=b.userId")
	//public List<String> findRoleByUserName(String username);
	
}
