package com.eugene.wsdemo;

import com.eugene.wsdemo.repository.CountryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = CountryRepository.class)
@SpringBootApplication
public class WsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsDemoApplication.class, args);
    }
}
