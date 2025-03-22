package com.andre.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.XorCsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        var cookieCsrfTokenRepository = CookieCsrfTokenRepository.withHttpOnlyFalse();
        cookieCsrfTokenRepository.setCookiePath("/");

        XorCsrfTokenRequestAttributeHandler delegate = new XorCsrfTokenRequestAttributeHandler();
        delegate.setCsrfRequestAttributeName("_csrf");

        http
                .cors(cors ->
                        cors.configurationSource(corsConfigurationSource())
                )
                .authorizeHttpRequests(auth ->
                        auth.anyRequest().permitAll()
                )
                .httpBasic(withDefaults())
                .csrf(csrf -> csrf
                        .csrfTokenRepository(cookieCsrfTokenRepository)
                        .csrfTokenRequestHandler(delegate::handle)
                );

        return http.build();
    }

    @Bean
    UrlBasedCorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("https://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
