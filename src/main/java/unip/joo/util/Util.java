package unip.joo.util;

import unip.joo.model.ENUM.NomeAtributo;
import unip.joo.model.entities.Monstro;
import unip.joo.resources.AsciiArt;
import unip.joo.resources.SystemText;

import java.util.*;

public class Util { // Classe utilitária
    private static final AsciiArt asciiArt = new AsciiArt(); // Atributo Estático / Atributo Final
    private static final SystemText systemText = new SystemText(); // Atributo Estático / Atributo Final

    // Método Estático
    public static int rollDice(int quantity, int sides) {
        int total = 0;
        for (int i = 0; i < quantity; i++) {
            total += (int) (Math.random() * sides) + 1;
        }
        return total;
    }

    public static void displayActPiece(Scanner scanner, Map<String, String> act, String piece) {
        act.forEach((key, value) -> {
            if (key.contains(piece)) {
                printText(scanner, value);
            }
        });
    }
    public static void printText(Scanner scanner, String text) {
        System.out.println(text);
        scanner.nextLine();
    }

    public static void displayDialogue(Scanner scanner, List<String> dialogue) {
        dialogue.forEach(text -> printText(scanner, text));
    }
    public static int getPlayerChoice(Scanner scanner, String menuText) {
        try {
            System.out.println(menuText);
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (Exception e) { // Tratamento de Exceções
            return -1;
        }
    }
    public static boolean isValidChoice(int choice, int... validOptions) {
        for (int option : validOptions) {
            if (choice == option) {
                return true;
            }
        }
        return false;
    }

    public static void handleInvalidChoice() {
        System.out.println(systemText.getSystemMessage("error.opcaoInvalida"));
    }

    public static String actualLife(int damage, int actualLife, int defaultLife) {

        return String.format(systemText.getSystemMessage("roll.losesLife"), damage)+"\n"+
               String.format(systemText.getSystemMessage("actualLife"), actualLife, defaultLife);
    }
    public static boolean verifyDeath(Scanner scanner,int life, List messageDeath){
        if(life <= 0){
            displayDialogue(scanner, messageDeath);
            printText(scanner, asciiArt.getAsciiArts("youDied"));
            System.exit(0);
            return true;
        } else {
            return false;
        }
    }
    //SOBRECARGA - OVERLOAD
    public static boolean verifyDeath(Scanner scanner,int life, String messageDeath){
        if(life <= 0){
            printText(scanner, messageDeath);
            printText(scanner, asciiArt.getAsciiArts("youDied"));
            System.exit(0);
            return true;
        } else {
            return false;
        }
    }

    public static boolean resolveInitiative(Scanner scanner,int playerAgility, int monsterAgility) {

        int playerRoll = rollDice(1, 20)+playerAgility;
        int monsterRoll = rollDice(1, 20)+monsterAgility;
        printText(scanner,String.format(systemText.getSystemMessage("test.iniciative"), playerRoll));
        printText(scanner,String.format(systemText.getSystemMessage("combat.roll.inciative"), playerRoll, monsterRoll));

        return playerRoll > monsterRoll;
    }

}
