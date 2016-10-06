package com.ak.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;


@Entity
@Table(name = "PAGES_SECTION")
@Data
@ToString
public class PagesSection implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@Column(name="PAGE_ID")
	private String pageId;
	@Column(name="SECTION_NAME")
	private String sectionName;
	@Column(name="SECTION_DETAIL")
	private String sectionDetail;
	
	
	
	
	
}



