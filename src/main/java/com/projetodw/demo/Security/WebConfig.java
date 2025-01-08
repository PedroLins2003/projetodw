package com.projetodw.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebConfig  {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .cors(cors -> cors.configure(http))
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorizeConfig ->
                authorizeConfig
                    .requestMatchers(HttpMethod.POST,"/clientes").permitAll()
                    .requestMatchers(HttpMethod.POST,"/equipamento").permitAll()
                    .requestMatchers(HttpMethod.POST,"/requisicao").permitAll()
                    .requestMatchers(HttpMethod.POST,"/requisicaoequipamento").permitAll()
                    .requestMatchers(HttpMethod.POST,"/requisicaoservico").permitAll()
                    .requestMatchers(HttpMethod.PUT,"/clientes").permitAll()
                    .requestMatchers(HttpMethod.PUT,"/equipamento").permitAll()
                    .requestMatchers(HttpMethod.PUT,"/requisicao").permitAll()
                    .requestMatchers(HttpMethod.PUT,"/requisicaoequipamento").permitAll()
                    .requestMatchers(HttpMethod.PUT,"/requisicaoservico").permitAll()
                    .requestMatchers(HttpMethod.DELETE,"/clientes/{id:[0-9]+}").permitAll()
                    .requestMatchers(HttpMethod.DELETE,"/equipamento/{id:[0-9]+}").permitAll()
                    .requestMatchers(HttpMethod.DELETE,"/requisicao/{id:[0-9]+}").permitAll()
                    .requestMatchers(HttpMethod.DELETE,"/requisicaoequipamento/{id:[0-9]+}").permitAll()
                    .requestMatchers(HttpMethod.DELETE,"/requisicaoservico/{id:[0-9]+}").permitAll()
                    .requestMatchers(HttpMethod.GET, "/requisicao/{id:[0-9]+}").permitAll()
                    .anyRequest().authenticated()

                
            ).build();
    }
}
