package com.ak.service;

import java.util.List;

import com.ak.model.Pages;

public interface PageService {
	public void createPage(Pages page);

	public List<Pages> getPages();

}
