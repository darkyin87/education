package com.ak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ak.model.PagesSection;

public interface PagesSectionRepository extends JpaRepository<PagesSection, Long> {
	
	public List<PagesSection> findByPageId(String pageId);

}
