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
import javax.persistence.Transient;

import lombok.Data;


@Entity
@Table(name = "users")
@Data public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userID;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;	
	@Column(name="EMAIL_ID")
	private String emailID;
	@Column(name="phone_number")
	private String phoneNumber;
	@Column(name="ADDRESS_LINE1")
	private String addressLine1;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="zipcode")
	private String zipCode;	
	@Column(name="password")
	private String password;
	@Column(name="user_name")
	private String userName;
	@Column(name="ENABLED",columnDefinition="VARCHAR(45) DEFAULT 'YES'")
	private String enabled;
	@Transient
	private String token;
	@Transient
	private int childrenId;
	@Transient
	private int amount;
	
	
	

	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private Set<UserRoles> roles = new HashSet<>();
	
	public User() {
	}

	public User(String name, String email, String password) {
		//this.id = id;
		this.userName = name;
		this.emailID = email;
		this.password = password;
		//this.dob = dob;
	}
	
	


	@Override
	public String toString() {
		return "User [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", emailID=" + emailID
				+ ", phoneNumber=" + phoneNumber + ", addressLine1=" + addressLine1 + ", city=" + city + ", state="
				+ state + ", zipCode=" + zipCode + ", password=" + password + ", userName=" + userName + ", enabled="
				+ enabled + ",  roles=" + roles + "]";
	}

	public long getUserID() {
		return userID;
	}


	public void setUserID(long userID) {
		this.userID = userID;
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
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<UserRoles> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRoles> roles) {
		this.roles = roles;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public int getChildrenId() {
		return childrenId;
	}

	public void setChildrenId(int childrenId) {
		this.childrenId = childrenId;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
