package unip.joo.view;

import unip.joo.controller.protagonista.HumanoController;
import unip.joo.model.ENUM.NomeAtributo;
import unip.joo.model.entities.Humano;
import unip.joo.resources.GameText;

import java.util.Map;
import java.util.Scanner;
import unip.joo.model.ENUM.NomeAtributo;

import static unip.joo.util.Util.*;

public class Game {
    private final GameText gameText = new GameText();
    private Scanner scanner = new Scanner(System.in);
    private HumanoController humanoController = new HumanoController();
    private Humano protagonista = humanoController.createProtagonista();

    public void init() {
        gameStart();;
    }

    private void gameStart() {
        System.out.println(gameText.getSystemMessage("game.initial.suggestion"));
        scanner.nextLine();

        int tentativas = 0;
        boolean rodando = true;

        while (rodando && tentativas < 3) {
            System.out.println(gameText.getSystemMessage("game.start"));

            String input = scanner.nextLine();

            try {
                int opcao = Integer.parseInt(input);

                switch (opcao) {
                    case 1:
                        firstAct();
                        return;

                    case 2:
                        System.out.println(gameText.getSystemMessage("game.close"));
                        return;

                    default:
                        throw new IllegalArgumentException();
                }

            } catch (IllegalArgumentException e) {
                if (tentativas >= 3) {
                    System.out.println(gameText.getSystemMessage("game.close"));
                } else {
                    System.out.println(gameText.getSystemMessage("error.opcaoInvalida"));
                }
            }
        }
    }

    private void firstAct () {
        Map<String, String> firstAct = gameText.getAllFirtsAct();
        callActPiece(firstAct, "pieceOne");
        alleyWakeUp();
    }
    private void alleyWakeUp() {
        int rolagem = 0;
        int falha = 8;
        int vigorProtagonista = protagonista.getClasse().getAtributo(NomeAtributo.VIGOR);

        System.out.println("Levantar [ENTER]");
        scanner.nextLine();
        System.out.println("INICIANDO TESTE DE VIGOR: "+vigorProtagonista+" rolagens com d20");
        for(int i =1; i <= vigorProtagonista; i++) {
            rolagem = protagonista.rollDice(1,20);
            printText(">> Seu dado é: ["+ rolagem+"]");
            if(rolagem >= falha) {
                break;
            }
        }
        if(rolagem < falha) {
            System.out.println("VOCÊ FALHOU NO TESTE");
            System.out.println(gameText.getFirtsAct("action.wakeUp.failure"));
            rolagem = protagonista.rollDice(1,4);
            printText(">> Você perdeu ["+ rolagem +"] pontos de vida \n");
            System.out.println(gameText.getFirtsAct("action.wakeUp.failure.2"));
            printText(protagonista.getFala("firstAct.lixo"));
        }
        System.out.println(gameText.getFirtsAct("action.wakeUp.default"));
        System.out.println(protagonista.getFala("firstAct.claridade"));
        printText(gameText.getFirtsAct("action.wakeUp.default.2"));
        optionChoice();
    }

    private void optionChoice() {
        System.out.println("Ir a barraca de sucatas [1] \n Ir a barraca de comidas [2] \n Ir a barraca de liquidos [3]");
        String input = scanner.nextLine();
        int opcao = Integer.parseInt(input);
        while (true) {
            try {
                switch (opcao) {
                    case 1:
                        scrapTent();
                        return;
                    case 2:
                        foodTent();
                        return;
                    case 3:
                        liquidTent();
                        return;
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println(gameText.getFirtsAct("error.opcaoInvalida"));
            }
        }
    }
    private void foodTent() {}
    private void scrapTent() {
        printText("Um senhor moreno, com a pele queimada pelo sol observa enquanto você se aproxima da barraca, franzindo levemente " +
                "o cenho ele diz: ");
        printText("<vendedor> Ressaca e tanto hein");
        printText("Hmmm...ou...não foi só bebida? ");
        printText("Bem, quem sou eu pra me meter, oque te trás aqui?");
        System.out.println("[1] Como vocês ainda conseguem viver aqui? Com a GULA levando tudo… isso aqui devia ter acabado faz tempo. \n" +
                "[2] O que você tem pra mim?");
        String input = scanner.nextLine();
        int opcao = Integer.parseInt(input);
        while (true) {
            try {
                switch (opcao) {
                    case 1:
                        scrapTentOne();
                        return;
                    case 2:
                        scrapTentTwo();
                        return;
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println(gameText.getFirtsAct("error.opcaoInvalida"));
            }
        }

    }
    private void scrapTentOne() {
        printText("<vendedor> Acabou. Só não caiu ainda.");
        printText("respondeu enquanto pegava uma peça de sucata e girava na mão.");
        printText("A gente vive de resto. Do que ela quer...ou ainda não viu");
        printText("O vendedor te olha fixamente");
        printText("<vendedor> Mas quando ela encontrar...pelo seu olhar, você já sabe");
        printText("<protagonista> ...Sim");
        printText("Um silêncio desconfortável se instaura");
        printText("<vendedor> Esse lugar não esquece, só aprendemos a seguir em frente");
        printText("<protagonista> E se eu quiser esquecer?");
        printText("<vendedor> Bebendo?");
        printText("<vendedor> Isso nunca funciona...Só te deixa mais lento, e ser lento por aqui não é uma boa ideia...");
    }
    private void scrapTentTwo() {
        printText("<vendedor>...Hoje? Quase nada.");
        printText("Diz o vendedor com uma risada sem humor");
        printText("Te analisando de cima a baixo ele fecha a cara e diz");
        printText("<vendedor> Vai comprar algo? não tenho tempo pra perder");
    }
    private void liquidTent() {}

    private void printText(String text) {
        System.out.println(text);
        scanner.nextLine();
    }
    private void callActPiece(Map<String, String> act, String piece) {
        act.forEach((key, value) -> {
            if (key.contains(piece)) {
                printText(value);
            }
        });
    }

}
