package dev.ruchir.glucosense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "dev.ruchir.glucosense.model")
public class GlucoSenseApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlucoSenseApplication.class, args);
    }

}
