package com.example.user.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.example.user.Jwt.JwtAuthenticationFilter;


import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;
    private static final String[] SWAGGER_WHITELIST = {
        "/swagger-ui/**",
        "/v3/api-docs/**",
        "/swagger-resources/**",
        "/swagger-resources"
    }; 

    

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        
        return http
            .csrf(csrf -> 
                csrf
                .disable())
            .authorizeHttpRequests(authRequest ->
              authRequest
                .requestMatchers("/auth/**").permitAll()
                .requestMatchers(SWAGGER_WHITELIST).permitAll()
                .anyRequest().authenticated()
                )
            //.formLogin(withDefaults())
            .sessionManagement(sessionManager->
                sessionManager 
                  .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(authProvider)
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
            
            
    }

}

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

// private final UserDetailsService userDetailsService;
// private final JwtRequestFilter jwtRequestFilter;

// public SecurityConfig(UserDetailsService userDetailsService, JwtRequestFilter
// jwtRequestFilter) {
// this.userDetailsService = userDetailsService;
// this.jwtRequestFilter = jwtRequestFilter;
// }

// @Override
// protected void configure(HttpSecurity http) throws Exception {
// http.csrf().disable()
// .authorizeRequests()
// .antMatchers("/authenticate").permitAll() // Endpoint para la autenticación
// .antMatchers(HttpMethod.POST, "/employees").permitAll() // Permitir registro
// sin autenticación
// .anyRequest().authenticated()
// .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

// http.addFilterBefore(jwtRequestFilter,
// UsernamePasswordAuthenticationFilter.class);
// }

// @Bean
// public PasswordEncoder passwordEncoder() {
// return new BCryptPasswordEncoder();
// }
// }
