package ro.vladfernoaga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private BasicAuthEntryPoint basicAuthEntryPoint;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/public/*", "/user/*")
		.permitAll()
		.antMatchers(HttpMethod.POST,"/user/*")
		.authenticated()
		.and()
		.csrf()
		.disable()
		.httpBasic()
		
		.authenticationEntryPoint(basicAuthEntryPoint);
	}
	
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        
		auth.inMemoryAuthentication()
                .withUser("vlad").password("123")
                .authorities("ROLE_USER")
                .and()
                .withUser("admin").password("adm")
                .authorities("ROLE_ADMIN");
    }
	
}
