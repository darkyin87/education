package com.ak.service;

import java.util.List;

import com.ak.model.PagesSection;

public interface PageSectionService {
	
	public void saveOrUpdate(List<PagesSection> pagesSectionList);
	public List<PagesSection> getPageSectionForPage(String pageId);

}
