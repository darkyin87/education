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
	
	
	@Override
	public List<Object[]> findWithDonation() {
		List<Object[]> childrenInSer = childrenRepository.findWithDonation();
		System.out.println("childrenIn serv --  " + childrenInSer.size());
		return childrenRepository.findWithDonation();
		
	}


	@Override
	public void save(Children children) {
		childrenRepository.save(children);
		// TODO Auto-generated method stub
		
	}
	

}
