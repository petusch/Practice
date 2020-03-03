package com.example.resthelloworld.config;

import com.example.resthelloworld.repository.UserJasyncRepository;
import com.example.resthelloworld.repository.UserRepository;
import com.github.jasync.sql.db.Connection;
import com.github.jasync.sql.db.postgresql.PostgreSQLConnectionBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventConfig {

    @Bean
    Connection connection()
        {
            return PostgreSQLConnectionBuilder.createConnectionPool(
                    "jdbc:postgresql://localhost:5432/RegForm");
        }

    @Bean
    UserRepository userRepository(){

        return new UserJasyncRepository(connection());
        }

}
