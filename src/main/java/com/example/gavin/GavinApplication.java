package com.example.gavin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class GavinApplication {

    public static void main(String[] args) {
        var ctx = new SpringApplicationBuilder(GavinApplication.class)
                .headless(false).run(args);
        ctx.getBean(ConsoleGUI.class);
    }

}
