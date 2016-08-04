package com.ak.model;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "children")
@Data public class Children implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="childrenId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long childrenId;
	@Column(name="FIRSTNAME")
	private String firstName;
	@Column(name="LASTNAME")
	private String lastName;	
	@Column(name="FATHERNAME")
	private String fatherName;
	@Column(name="MOTHERNAME")
	private String motherName;
	@Column(name="PICTURE")
	private String picture;
	public long getChildrenId() {
		return childrenId;
	}
	public void setChildrenId(long childrenId) {
		this.childrenId = childrenId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Children [childrenId=" + childrenId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", fatherName=" + fatherName + ", motherName=" + motherName + ", picture=" + picture + "]";
	}
	

	
	


	

	
	
	
}
