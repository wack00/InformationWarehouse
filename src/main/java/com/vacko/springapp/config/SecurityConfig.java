/**
 * 
 */
package com.vacko.springapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
// @EnableGlobalMethodSecurity(prePostEnabled = true)
// @ImportResource("classpath:applicationContext-security.xml")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder registry)
			throws Exception {
		

		// registry.jdbcAuthentication().dataSource(dataSource);
		registry.userDetailsService(customUserDetailsService);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**"); // #3
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
				.disable()
				.authorizeRequests()
				.antMatchers("/login", "/login/form**", "/register", "/logout",
						"/rest/**", "/index", "/pag/*", "/sort/**",
						"/countApproveUp/*", "/countApproveDown/*",
						"/countDisapproveUp/*", "/countDisapproveDown/*",
						"/commentCountDisapproveDown/*","/commentCountDisapproveUp/*",
						"/commentCountApproveUp/*","/commentCountApproveDown/*",
						"/post/*", "/*")
				.permitAll()
				// #4
				.antMatchers("/adminPannel/","/adminPannel","/postPannel/","/commentPannel/","/reportPannel/","/commentDetail/*")
				.hasRole("ADMIN")
				// #6
				.anyRequest().authenticated()
				// 7
				.and().formLogin()
				// #8
				.loginPage("/login/form")
				// #9
				.loginProcessingUrl("/login").defaultSuccessUrl("/adminPannel/")
				
				.failureUrl("/login/form?error").permitAll(); // #5
	}
}
