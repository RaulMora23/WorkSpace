package org.example.apibiblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("repositorios")
public class ApiBibliotecaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiBibliotecaApplication.class, args);
    }

}
