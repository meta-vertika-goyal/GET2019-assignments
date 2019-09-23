package com.metacube.get2019.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

	@Configuration
	@EnableWebSecurity
	public class StudentApplicationSecurity extends WebSecurityConfigurerAdapter
	{
	    @Override
	    public void configure(HttpSecurity http) throws Exception
	    {
	    	
	    	http.authorizeRequests()
			.antMatchers("/**").hasRole("USER")
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/LoginPage").permitAll()
			.failureUrl("/failure");
	    	http.csrf().disable();
    }
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	    {
	        auth.inMemoryAuthentication()
	        .withUser("vertika").password("1234").roles("USER");
	    }
		
}
