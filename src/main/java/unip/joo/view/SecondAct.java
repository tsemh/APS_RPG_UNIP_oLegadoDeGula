package unip.joo.view;


import unip.joo.controller.humanoFactory.HumanoFactoryController;
import unip.joo.model.ENUM.NomeAtributo;
import unip.joo.model.entities.Habilidade;
import unip.joo.model.entities.Humano;
import unip.joo.model.entities.Monstro;
import unip.joo.resources.GameText;
import unip.joo.util.Util.*;

import java.util.*;

import static unip.joo.util.Util.*;

public class SecondAct { // Classe de visão
    private final GameText gameText = new GameText(); // Atributo Final
    private final Scanner scanner = new Scanner(System.in); // Atributo Final

    private Humano elodin; // Encapsulamento
    private final HumanoFactoryController humanoFactoryController = new HumanoFactoryController();
    private int vigorElodin;
    private int forcaElodin;

    // Mapa para controlar o tempo de espera das habilidades (turno em que ficarão disponíveis)
    private final Map<Integer, Integer> abilityCooldown = new HashMap<>();
    private int currentTurn = 0;

    public void init(Humano elodin) {
        this.elodin = elodin;
        this.vigorElodin = elodin.getClasse().getAtributo(NomeAtributo.VIGOR);
        this.forcaElodin = elodin.getClasse().getAtributo(NomeAtributo.FORCA);
        secondActInit();
    }
    // ==================== MÉTODOS DE DIÁLOGO ====================

    private void displayActPiece(Map<String, String> act, String piece) {
        act.forEach((key, value) -> {
            if (key.contains(piece)) {
                printText(scanner, value);
            }
        });
    }

    // ==================== MÉTODOS DE MENU E VALIDAÇÃO ====================

    private int getPlayerChoice(String menuText) {
        try {
            System.out.println(menuText);
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (Exception e) { // Tratamento de Exceções
            return -1;
        }
    }

    private boolean isValidChoice(int choice, int... validOptions) {
        for (int option : validOptions) {
            if (choice == option) {
                return true;
            }
        }
        return false;
    }

    private void handleInvalidChoice() {
        System.out.println(gameText.getSystemMessage("error.opcaoInvalida"));
    }


    //  ========================= SEGUNDO ATO  ===================================

    private void secondActInit() {
        List<String> initialDialogue = List.of(
                gameText.getSecondAct("pieceOne.ato"),
                gameText.getSecondAct("pieceOne.outOfCity"),
                gameText.getSecondAct("pieceOne.outOfCity.2"),
                gameText.getSecondAct("pieceOne.outOfCity.3"),
                gameText.getSecondAct("pieceOne.entranceFortress.1"),
                gameText.getSecondAct( "pieceOne.entranceFortress.2"),
                gameText.getSecondAct("pieceOne.entranceFortress.3"),
                gameText.getSecondAct("pieceOne.entranceFortress.4"),
                gameText.getSecondAct("pieceOne.entranceFortress.5"),
                gameText.getSecondAct("pieceOne.entranceFortress.6")
        );
        displayDialogue(scanner, initialDialogue);

        fortressGasResistanceAction();
    }

    // Teste de resistência do Gás Tóxico na Entrada da Fortaleza
    private void fortressGasResistanceAction(){
        int diceResult = 0;
        int difficultyGasResistance = 12;

        List<String> dialogue = new ArrayList<>();

        dialogue.add(gameText.getSystemMessage("action.fortress.entry"));
        dialogue.add(String.format(gameText.getSystemMessage("test.vigor"), vigorElodin));

        for (int roll = 1; roll <= vigorElodin; roll++) {
            diceResult = rollDice(1, 20);
            dialogue.add(String.format(gameText.getSystemMessage("roll.dice"), diceResult));

            if (diceResult >= difficultyGasResistance) {
                break;
            }
        }
        if (diceResult < difficultyGasResistance) {
            int damage = rollDice(1, 8) + 4;
            int newHealth = elodin.getClasse().getVida() - damage;
            elodin.getClasse().setVida(newHealth);

            dialogue.add(gameText.getSystemMessage("test.failure"));
            dialogue.add(gameText.getSecondAct("action.entranceFortress.GasResistance.failure"));
            dialogue.add(String.format(gameText.getSystemMessage("roll.losesLife"), damage));

        }
        else {
            int damage = rollDice(1, 4) + 2;
            int newHealth = elodin.getClasse().getVida() - damage;
            elodin.getClasse().setVida(newHealth);

            dialogue.add(gameText.getSystemMessage("test.success"));
            dialogue.add(gameText.getSecondAct("action.entranceFortress.GasResistance.success"));
            dialogue.add(String.format(gameText.getSystemMessage("roll.losesLife"), damage));
        }
        dialogue.add(gameText.getSecondAct("pieceTwo.Fortress.1"));
        dialogue.add(gameText.getSecondAct("pieceTwo.Fortress.2"));
        dialogue.add(gameText.getSecondAct("pieceTwo.Fortress.3"));
        dialogue.add(gameText.getSecondAct("pieceTwo.Fortress.4"));
        dialogue.add(gameText.getSecondAct("pieceTwo.Fortress.5"));
        dialogue.add(gameText.getSecondAct("pieceTwo.Fortress.6"));

        displayDialogue(scanner, dialogue);
        choiceRunOrStay();
    }
    //Verificar se vai correr ou ficar
    private void choiceRunOrStay(){
        while (true) {
            int choice = getPlayerChoice(gameText.getSecondAct("pieceTwo.Fortress.init.choice.one"));

            if (isValidChoice(choice, 1, 2)) {
                if (choice == 1){
                    choiceRunTest();
                } else {
                    choiceStayRecieveItem();
                }
                return;
            } else {
                handleInvalidChoice();
            }
        }
    }
    //Teste para verificar se você consegue fugir ou não da Mulher Mascarada
    private void choiceRunTest(){
        int diceResult = 0;
        int difficultyRun = 15;

        List<String> dialogue = new ArrayList<>();

        dialogue.add(gameText.getSystemMessage("action.fortress.run"));
        dialogue.add(String.format(gameText.getSystemMessage("test.forca"), forcaElodin));

        for (int roll = 1; roll <= forcaElodin; roll++) {
            diceResult = rollDice(1, 20);
            dialogue.add(String.format(gameText.getSystemMessage("roll.dice"), diceResult));

            if (diceResult >= difficultyRun) {
                break;
            }
        }
        //Caso se sua tentativa de correr falhar
        if (diceResult < difficultyRun) {
            dialogue.add(gameText.getSystemMessage("test.failure"));
            dialogue.add(gameText.getSecondAct("pieceTwo.Fortress.init.choice.run.failure.1"));
            dialogue.add(gameText.getSecondAct("pieceTwo.Fortress.init.choice.run.failure.2"));
            dialogue.add(gameText.getSecondAct("pieceTwo.Fortress.init.choice.run.failure.3"));
            dialogue.add(gameText.getSecondAct("pieceTwo.Fortress.init.choice.run.failure.4"));
            dialogue.add(gameText.getSystemMessage("pieceTwo.Fortress.GasmaskLady.Item"));
            //ADICIONAR CÓDIGO PARA INSERIR A MÁSCARA DE GÁS NO INVENTÁRIO

            displayDialogue(scanner, dialogue);
            stayChoiceDialogue();
        }
        //Caso se sua tentativa de correr ser sucesso
        else {
            dialogue.add(gameText.getSecondAct( "pieceTwo.Fortress.init.choice.run.success.1"));

            int damage = rollDice(1, 4) + 3;
            int newHealth = elodin.getClasse().getVida() - damage;
            elodin.getClasse().setVida(newHealth);
            dialogue.add(String.format(gameText.getSystemMessage("roll.losesLife"), damage));

            dialogue.add(gameText.getSecondAct( "pieceTwo.Fortress.init.choice.run.success.2"));

        }

    }

    private void choiceStayRecieveItem(){
        List<String> dialogue = new ArrayList<>();
        dialogue.add(gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.1"));
        dialogue.add(gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.3"));
        dialogue.add(gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.4"));
        dialogue.add(gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.5"));
        dialogue.add(gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.6"));
        dialogue.add(gameText.getSystemMessage("pieceTwo.Fortress.GasmaskLady.Item"));
        //ADICIONAR CÓDIGO PARA INSERIR A MÁSCARA DE GÁS NO INVENTÁRIO

        displayDialogue(scanner, dialogue);
        stayChoiceDialogue();
    }


    //DIALOGO DANDO ERRO QUANDO É TRIGGADO, DA UM HELP TIAGO (ANTES TAVA DANDO CERTO)
    private void stayChoiceDialogue() {
        Humano lena = humanoFactoryController.createLena();

        List<String> dialogue = List.of(
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.1"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.pause.1"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.2"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.silence"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.3"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.4"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.pause.2"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.5"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.6"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.7"),
                elodin.getFala("secondAct.pieceTwo.Fortress.choice.stay.1"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.8"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.9"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.pause.3"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.10"),
                elodin.getFala("secondAct.pieceTwo.Fortress.choice.stay.2"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.11"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.11.1"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.11.2"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.11.3"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.12"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.13"),
                elodin.getFala("secondAct.pieceTwo.Fortress.choice.stay.3"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.14"),
                gameText.getSecondAct( "pieceTwo.Fortress.init.choice.stay.pause.3"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.15"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.16"),
                elodin.getFala("secondAct.pieceTwo.Fortress.choice.stay.4"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.17"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.18"),
                elodin.getFala("secondAct.pieceTwo.Fortress.choice.stay.5"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.19"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.20"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.7"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.8"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.9"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.10"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.11"),
                gameText.getSecondAct( "pieceTwo.Fortress.init.choice.stay.12"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.13"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.21"),
                gameText.getSecondAct( "pieceTwo.Fortress.init.choice.stay.14"),
                gameText.getSecondAct( "pieceTwo.Fortress.init.choice.stay.15"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.16"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.17"),
                gameText.getSecondAct( "pieceTwo.Fortress.init.choice.stay.18"),
                gameText.getSecondAct( "pieceTwo.Fortress.init.choice.stay.19"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.20"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.21"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.22"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.23"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.24"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.25"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.26"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.27"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.28"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.29"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.30"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.31"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.32"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.33"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.34"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.35"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.36"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.22"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.37"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.38"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.39"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.23"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.40"),
                gameText.getSecondAct("pieceTwo.Fortress.init.choice.stay.41")
        );

        displayDialogue(scanner, dialogue);
    }
}