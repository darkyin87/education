package com.ak.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)

@Entity
@Table(name = "paymentdetail")
@Data
@ToString
public class PaymentDetail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="PAYMENTID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long paymentId;
	@Column(name="USERID")
	private String userId;
	@Column(name="CHILDRENID")
	private int childrenId;	
	@Column(name="DONATIONAMT")
	private int donationAmount;
	@Column(name="FREQUENCY")
	private String frequency;
	
	
	

	

	
	
	
}
