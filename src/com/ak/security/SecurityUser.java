package com.ak.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ak.model.User;
import com.ak.model.UserRoles;

public class SecurityUser extends User implements UserDetails
{

	private static final long serialVersionUID = 1L;
	public SecurityUser(User user) {
		if(user != null)
		{
			System.out.println(" coming inside the security user" + user.getUserID());
			System.out.println(" first name -- " + user.getFirstName());
			this.setUserName(user.getUserName());
			this.setEmailID(user.getEmailID());
			this.setPassword(user.getPassword());
			this.setUserID(user.getUserID());
			this.setFirstName(user.getFirstName());
			
		}		
	}
	
	public SecurityUser() {
		
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		Set<UserRoles> userRoles = this.getRoles();
		System.out.println(" inside the granted authority");;
		if(userRoles != null)
		{
			for (UserRoles role : userRoles) {
				SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRole());
				System.out.println(" goinginsid ethe authorities");;
				authorities.add(authority);
			}
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername(){
		return super.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public long getUserID(){
		
		return super.getUserID();
	}
	
	@Override
	public String getFirstName(){
		return super.getFirstName();
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	
}