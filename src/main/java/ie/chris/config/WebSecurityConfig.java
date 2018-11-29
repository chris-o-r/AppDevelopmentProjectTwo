package ie.chris.config;


import javax.sql.DataSource;

import org.apache.catalina.servlets.WebdavServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	PasswordEncoder passwordEncoder; 
	
	@Autowired
	DataSource dateSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		//All Users
		.antMatchers("/css/**", "/", "/project/*", "/signup", "/create/user", "/webjars/bootstrap/**", 
				"/h2-console/**", "/console/*").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").permitAll()
		.defaultSuccessUrl("/")
		.usernameParameter("email")
		.and().exceptionHandling().accessDeniedPage("/403");
		
		http.csrf().disable(); 
		http.headers().frameOptions().disable(); 
		  
	}
	
	@Override
	protected void configure (AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dateSource)
			.usersByUsernameQuery("SELECT user.email, user.password, user.enabled FROM user WHERE user.email=?")
			.authoritiesByUsernameQuery("SELECT role.email, role.description FROM role WHERE role.email=?");
	}
	
}
