package org.example.bootjwtsecurity.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
//                .csrf(AbstractHttpConfigurer::disable) // CSRF 비활성화
//                .csrf(csrf -> csrf.disable()) // CSRF 비활성화 2
                .csrf(csrf -> csrf.ignoringRequestMatchers("/api/**")) // REST API 무시하겠다...
//                .cors()
                .authorizeHttpRequests(
auth ->
                    auth
                            .requestMatchers("/api/**", "/swagger-ui/**","/v3/api-docs/**") // 여러 개를 한 번에 넣어도 된다...
                                .permitAll()
                            .anyRequest()
                                .authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .logout(Customizer.withDefaults());
        return http.build();
    }
}
