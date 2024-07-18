/*package com.example.demo.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {
            UserModel user1 = new UserModel(
                    "morad",
                    "mm@gmail.com",
                    "moradii",
                    1L,
                    "info",
                    "web dev"
            );
            UserModel user2 = new UserModel(
                    "Oussama",
                    "oo@gmail.com",
                    "messi",
                    2L,
                    "info",
                    "data science"
            );

            userRepository.saveAll(
                    List.of(user1, user2)
            );
        };
    }

}
*/