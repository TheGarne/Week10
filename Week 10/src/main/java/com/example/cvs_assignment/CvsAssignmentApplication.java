package com.example.cvs_assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CvsAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CvsAssignmentApplication.class, args);
        Menu menu = new Menu();
        menu.startProgram();
    }
}
