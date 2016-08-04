package com.ak.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ak.model.Children;
import com.ak.repository.ChildrenRepository;

@Service
public class ChildrenServiceImpl implements ChildrenService{
	
	@Resource
    private ChildrenRepository childrenRepository;

	@Override
	public List<Children> getAll() {
		
		return childrenRepository.findAll();
	
		
	}

}
