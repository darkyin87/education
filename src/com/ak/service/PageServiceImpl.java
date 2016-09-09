package com.ak.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ak.model.Pages;
import com.ak.repository.PagesRepository;

@Service
public class PageServiceImpl implements PageService{
	
	@Resource
    private PagesRepository pagesRepository;

	@Override
	public void createPage(Pages page) {
		
		pagesRepository.save(page);

		
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Pages> getPages(){
		System.out.println(" coming inside the get Pages ");
		
		return pagesRepository.findAll();
	}

}
