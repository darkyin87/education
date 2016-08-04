package com.ak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ak.model.Children;

public interface ChildrenRepository extends JpaRepository<Children, Long> {
	
	
	public List<Children> findAll();
	
	

}
