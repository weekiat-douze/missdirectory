package org.missdirectory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Hello! I am MissDirectory!\n");
        String mdMenu = "\n1. View/Modify Directory Templates" +
                "\n2. Create New Template" +
                "\n3. Generate Directory Structure" +
                "\n4. quit\n";
        System.out.println("What would you like to do today?" + mdMenu);

        String userInput = reader.next();
        while(!userInput.equals("4") && !userInput.equals("quit")) {
            switch (userInput) {
                case "1":
                    System.out.println("one");
                    break;
                case "2":
                    System.out.println("two");
                    break;
                default:
                    System.out.println("Please select one of the options." + mdMenu);
            }
            userInput = reader.next();
        }

        System.out.println("Good bye!");
    }
}
