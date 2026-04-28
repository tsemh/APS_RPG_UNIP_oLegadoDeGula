package unip.joo.util;

import unip.joo.resources.GameText;

import java.util.Random;
import java.util.Scanner;

public class Util {
    private static final GameText gameText = new GameText();

    public static void consoleClean() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printSlow(String text, int delay) {
        try {
            Thread.sleep(delay);
            for (char c : text.toCharArray()) {
                System.out.print(c);

                delay = 10;
                if (c == '.' || c == '!' || c == '?') delay = 100;
                if (c == ',') delay = 50;

                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println();
    }

    public static long idGenerator(){
        long id = 0;
        id++;
        return id;
    }

}
