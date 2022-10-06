package br.com.inverter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityWebConfig {

	@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/static/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/login").permitAll()
			.and()
			.logout().permitAll()
			.and().httpBasic();
		
		http.csrf().disable();
		
		return http.build();
	}
	
	@Bean
    InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withUsername("inv")
                .password(passwordEncoder().encode("inv"))
                .roles("USER")
                .build();
        
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("TopSuporte"))
                .roles("USER")
                .build();
        	
        return new InMemoryUserDetailsManager(user, admin);
    }
	

   @Bean
   PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   } 
   
}