package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Player.InsufficientFundsException {

        Machine slotMachine = new Machine();

        System.out.println("⭐Rules:");
        System.out.println("⭐Each spin costs 5 coins. You start out with 50.");
        System.out.println("⭐Three sevens pays 30 coins.");
        System.out.println("⭐Any three of the same fruit pays 10 coins.");
        System.out.println("⭐Two sevens pays 4 coins.");
        System.out.println("⭐One seven pays 1 coin.");
        //System.out.println("Type '1' to spin. Type '0' to exit.");


        Scanner scanner  = new Scanner(System.in);

        int input;
        do {
            System.out.println();
            System.out.println("Type '1' to spin. Type '0' to exit.");
            input = scanner.nextInt();
            if (input == 1) {
                slotMachine.spinWheel();
            } else if (input != 0) {
                System.out.println("Invalid choice. Please type '1' to spin or '0' to exit.");
            }
        } while (input != 0);
        System.out.println("Exiting...");
        scanner.close();
    }
}