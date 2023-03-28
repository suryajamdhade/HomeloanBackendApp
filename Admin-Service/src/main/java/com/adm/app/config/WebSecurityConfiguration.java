//package com.adm.app.config;
//
//import java.util.Arrays;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private UserDetailsService userDetailsService;
//
//	@Bean
//	AuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//
//		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(new BCryptPasswordEncoder(11));
//
//		return provider;
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
//				.authenticated().and().formLogin().loginPage("/login").defaultSuccessUrl("/login/home").permitAll()
//				.and().cors().and().csrf().disable().logout().permitAll();
//
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder(11);
//	}
//
//	@Bean
//	public CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
//		configuration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
//
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		//source.registerCorsConfiguration("/**", configuration);
//
//		CorsConfiguration config = new CorsConfiguration();
//
//		config.addAllowedOrigin("*");
//		config.addAllowedHeader("*");
//		config.addAllowedMethod("*");
//
//		source.registerCorsConfiguration("/**", config);
//
//		CorsConfigurationSource configurationSource = new CorsConfigurationSource() {
//
//			@Override
//			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
//				// TODO Auto-generated method stub
//				return config;
//			}
//		};
//		return configurationSource;
//
//	}
//}
////
////
////
////
////
////
////
