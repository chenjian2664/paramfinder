package com.jian.paramfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.*;

@SpringBootApplication
@EnableScheduling
public class ParamfinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParamfinderApplication.class, args);
    }

}
