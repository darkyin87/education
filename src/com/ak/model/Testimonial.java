package com.ak.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;


@Entity
@Table(name = "TESTIMONIALS")
@Data
@ToString
public class Testimonial {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="TESTIMONIALID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long testimonialId;
	@Column(name="TESTIMONIAL")
	private String testimonial;
	@Column(name="TESTIMONIALBY")
	private String testimonialBy;	
	@Column(name="COMPANY")
	private String company;
	@Column(name="ROLE")
	private String role;
	

	

}
