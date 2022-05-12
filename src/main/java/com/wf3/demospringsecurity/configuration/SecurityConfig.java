package com.wf3.demospringsecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// Designer ma classe comme étant une classe où je vais configurer ma chaîne de filtres
@Configuration
// Me permet de créer des filtres
@EnableWebSecurity
// WebSecurityConfigurerAdapter est une classe qui va me permettre de gérer les filtres
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
        .withUser("springuser").password(passwordEncoder().encode("0000")).roles("USER")
        .and()
        .withUser("springadmin").password(passwordEncoder().encode("1234")).roles("ADMIN", "USER");
    }

    /*
    Intégrer ma chaîne de filtres de sécurité dans la configuration de monn Spring Security
    Je vais spécialement ajouter des giltres sur mes requêtes HTTP.
    */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        // Ma méthode pour définir les rôles
        http.authorizeRequests()
        // Pour définir l'association entre les rôles et les différentes pages
        .antMatchers("/admin").hasRole("ADMIN")
        .antMatchers("/myAccount").hasRole("ADMIN")
        .antMatchers("/user").hasRole("USER")
        // anyRequest() et authenticated() pour permettre l'utilisation d'un formulaire
        .anyRequest().authenticated()
        .and()
        // Formulaire par défaut de Spring
        .formLogin()
        .and()
        .oauth2Login();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
