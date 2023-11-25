package org.sid.inverntoryservice;

import org.apache.hc.core5.reactor.Command;
import org.hibernate.mapping.List;
import org.sid.inverntoryservice.entities.Product;
import org.sid.inverntoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;


@SpringBootApplication
public class InverntoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InverntoryServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(ProductRepository productRepository,
                            RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Product.class);
            productRepository.saveAll(
                        List.of(
                            Product.builder().name("Computer").price(1200).quantity(12).build(),
                            Product.builder().name("Printer").price(120).quantity(32).build(),
                            Product.builder().name("Smartphone").price(9000).quantity(25).build()

                        )
                );
        };
    }

}
