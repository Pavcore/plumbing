package com.pavcore.plumbing;

import org.springframework.boot.SpringApplication;

public class TestToiletApplication {

    public static void main(String[] args) {
        SpringApplication.from(ToiletApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
