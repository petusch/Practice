package com.example.resthelloworld.config;

import com.example.resthelloworld.entity.Event;
import com.example.resthelloworld.repository.EventRepository;
import com.github.jasync.sql.db.Connection;
import com.github.jasync.sql.db.postgresql.PostgreSQLConnectionBuilder;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class EventConfig {

    @Bean
    Connection connection()
        {
            return PostgreSQLConnectionBuilder.createConnectionPool(
                    "jdbc:postgresql://localhost:5432/RegForm");
        }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Configuration
    @EnableWebSecurity
    public static class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity security) throws Exception
        {
            security.httpBasic().disable();
            security.csrf().disable();
        }
    }

//    @Bean
//    UserRepository userRepository(){
//
//        return new UserJasyncRepository(connection());
//        }

}
