package com.eugene.wsdemo;

import com.eugene.wsdemo.repository.CountryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = CountryRepository.class)
@ComponentScan(basePackages = {"com.eugene.wsdemo"})
@SpringBootApplication
public class WsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsDemoApplication.class, args);
    }
}
