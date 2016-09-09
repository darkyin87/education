package com.ak.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ak.model.PagesSection;
import com.ak.repository.PagesSectionRepository;

@Service
public class PageSectionServiceImpl implements PageSectionService{
	
	@Resource
    private PagesSectionRepository pagesSectionRepository;


	@Override
	public List<PagesSection> getPageSectionForPage(String pageId) {
		
		List<PagesSection> pagesSectionList = pagesSectionRepository.findByPageId(pageId);
		System.out.println(" the pages Section list -  " + pagesSectionList);
		// TODO Auto-generated method stub
		return pagesSectionList;
	}

}
