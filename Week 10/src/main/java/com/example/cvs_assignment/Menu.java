package com.example.cvs_assignment;

import java.util.Scanner;

public class Menu {

    FileHandler readFile = new FileHandler();

    public void startProgram() {
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while(running) {
            System.out.println("Select an option: " +
                    "\n(1) Read File" +
                    "\n(2) Search for movie by title" +
                    "\n(3) Sort movie by rating" +
                    "\n(4) Get Basic info from movies" +
                    "\n(5) Close program");
            String menuChoice = input.nextLine();
            switch (menuChoice) {
                case "1":
                    readFile.readFile("test");
                    break;
                case "2":
                    readFile.searchOneMovie();
                    break;
                case "3":
                    readFile.sortByRating();
                    break;
                case "4":
                    readFile.getBasicData();
                    break;
                case "5":
                    running = false;
                    break;
            }
        }
    }
}
