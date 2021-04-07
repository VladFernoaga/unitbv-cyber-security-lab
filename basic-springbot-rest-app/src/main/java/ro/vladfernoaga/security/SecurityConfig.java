package ro.vladfernoaga.security;

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private CustomAuthenticationEntryPoint entryPoint;
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		http.authorizeRequests().antMatchers("/public/**").permitAll()
//		.anyRequest()
//		.authenticated()
//		.and()
//		.httpBasic()
//		.authenticationEntryPoint(entryPoint);
//	}
//
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/logout");
////		web.ignoring().antMatchers("/**");
//	}
//
//	@Bean
//	public UserDetailsService userDetailsService() {
//		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		manager.createUser(User.withUsername("user").password(encoder.encode("password")).roles("USER").build());
//		manager.createUser(User.withUsername("admin").password(encoder.encode("password")).roles("ADMIN").build());
//		return manager;
//
//	}

//}
