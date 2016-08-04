package com.ak.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@ComponentScan("com.ak.security")
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Override
    protected void configure(AuthenticationManagerBuilder registry) throws Exception {
		registry.authenticationProvider(authenticationProvider());
		registry.userDetailsService(customUserDetailsService);
    }

	  @Override
	  public void configure(WebSecurity web) throws Exception {
		  
	    web
	      .ignoring()
	         .antMatchers("/resources/**")
	         .antMatchers("/angular/**")
	    	.antMatchers("/hello");
	  }
	 
	  @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	     
	     
	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	        authenticationProvider.setUserDetailsService(customUserDetailsService);
	        //authenticationProvider.setPasswordEncoder(passwordEncoder());
	        return authenticationProvider;
	    }
	    
	    

	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
		  System.out.println(" is it coming here -- ");
	    http
	    .csrf().disable()
	    .authorizeRequests()
	        .antMatchers("/login","/login/form**","/register","/logout", "/welcome/**").permitAll()
	        .antMatchers("/admin","/admin/**").hasRole("ADMIN")
	        .antMatchers("/**").permitAll()
	        .anyRequest().authenticated()
	        .and()
	    .formLogin()
	        .loginPage("/login/form")
	        //.defaultSuccessUrl("/login")
	        //.loginProcessingUrl("/login")
	        .loginProcessingUrl("/login")
	        .defaultSuccessUrl("/register")
	        .failureUrl("/login/form?error")
	        .permitAll();

	  }
}
