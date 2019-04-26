package com.gawekar;

import com.gawekar.service.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculatorSimpleApp implements CommandLineRunner {
    @Autowired
    private Calculator calculator;

    public static void main(String[] args) {
        SpringApplication.run(CalculatorSimpleApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=================================================================");
        System.out.println("=================================================================");
        System.out.println("=================================================================");
        System.out.println("Is simple calculator configured? " + calculator.isSimpleCaltulator());
        System.out.println("=================================================================");
        System.out.println("=================================================================");
        System.out.println("=================================================================");
    }
}
