package unip.joo.util;

import unip.joo.resources.GameText;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Util {
    private static final GameText gameText = new GameText();

    public static int rollDice(int quantity, int sides) {
        int total = 0;
        for (int i = 0; i < quantity; i++) {
            total += (int) (Math.random() * sides) + 1;
        }
        return total;
    }
    public static void printText(Scanner scanner, String text) {
        System.out.println(text);
        scanner.nextLine();
    }
    public static void displayDialogue(Scanner scanner, List<String> dialogue) {
        dialogue.forEach(text -> printText(scanner, text));
    }
}
