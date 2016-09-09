package com.ak.service;

import java.util.List;

import com.ak.model.PagesSection;

public interface PageSectionService {
	
	public List<PagesSection> getPageSectionForPage(String pageId);

}
