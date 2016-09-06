package com.ak.service;

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

}
