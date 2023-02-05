package org.vader.saber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SaberApplication {

    public static void main(String[] args) {

        SpringApplication.run(SaberApplication.class, args);
    }
}
