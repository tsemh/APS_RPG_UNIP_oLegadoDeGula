package unip.joo.view;


import unip.joo.controller.humanoFactory.HumanoFactoryController;
import unip.joo.model.ENUM.NomeAtributo;
import unip.joo.model.entities.Habilidade;
import unip.joo.model.entities.Humano;
import unip.joo.model.entities.Item;
import unip.joo.model.entities.Monstro;
import unip.joo.resources.GameText;
import unip.joo.resources.SecondActText;
import unip.joo.resources.SystemText;
import unip.joo.util.Util.*;

import java.util.*;

import static unip.joo.util.Util.*;

public class SecondAct { // Classe de visão
    private final SecondActText secondActText = new SecondActText(); // Atributo Final
    private final SystemText systemText = new SystemText(); // Atributo Final
    private final Scanner scanner = new Scanner(System.in); // Atributo Final

    private Humano elodin; // Encapsulamento
    private Humano lena; // Encapsulamento
    private final HumanoFactoryController humanoFactoryController = new HumanoFactoryController();
    private int vigorElodin;
    private int forcaElodin;
    private int defaultLife;
    private boolean escape;

    // Mapa para controlar o tempo de espera das habilidades (turno em que ficarão disponíveis)
    private final Map<Integer, Integer> abilityCooldown = new HashMap<>();
    private int currentTurn = 0;

    public void init(Humano elodin,Humano lena, int defaultLife) {
        this.elodin = elodin;
        this.lena = lena;
        this.vigorElodin = elodin.getClasse().getAtributo(NomeAtributo.VIGOR);
        this.forcaElodin = elodin.getClasse().getAtributo(NomeAtributo.FORCA);
        this.defaultLife = defaultLife;

        elodin.menu(scanner);
        secondActInit();
    }
    public boolean escape() { return this.escape;}

    //  ========================= SEGUNDO ATO  ===================================

    private void secondActInit() {
        List<String> initialDialogue = List.of(
                secondActText.getSecondAct("pieceOne.ato"),
                secondActText.getSecondAct("pieceOne.outOfCity"),
                secondActText.getSecondAct("pieceOne.entranceFortress")
        );
        displayDialogue(scanner, initialDialogue);

        fortressGasResistanceAction();
    }

    // Teste de resistência do Gás Tóxico na Entrada da Fortaleza
    private void fortressGasResistanceAction(){
        int diceResult = 0;
        int difficultyGasResistance = 12;

        List<String> dialogue = new ArrayList<>();

        dialogue.add(systemText.getSystemMessage("action.fortress.entry"));
        dialogue.add(String.format(systemText.getSystemMessage("test.vigor"), vigorElodin));

        for (int roll = 1; roll <= vigorElodin; roll++) {
            diceResult = rollDice(1, 20);
            dialogue.add(String.format(systemText.getSystemMessage("roll.dice"), diceResult));

            if (diceResult >= difficultyGasResistance) {
                break;
            }
        }
        if (diceResult < difficultyGasResistance) {
            int damage = rollDice(1, 8) + 4;
            int newHealth = elodin.getClasse().getVida() - damage;
            elodin.getClasse().setVida(newHealth);

            dialogue.add(systemText.getSystemMessage("test.failure"));
            dialogue.add(secondActText.getSecondAct("action.entranceFortress.GasResistance.failure"));
            dialogue.add(actualLife(damage, elodin.getClasse().getVida(), defaultLife));

        } else {
            int damage = rollDice(1, 4) + 2;
            int newHealth = elodin.getClasse().getVida() - damage;
            elodin.getClasse().setVida(newHealth);

            dialogue.add(systemText.getSystemMessage("test.success"));
            dialogue.add(secondActText.getSecondAct("action.entranceFortress.GasResistance.success"));
            dialogue.add(actualLife(damage, elodin.getClasse().getVida(), defaultLife));
        }
        dialogue.add(secondActText.getSecondAct("pieceTwo.Fortress"));

        displayDialogue(scanner, dialogue);
        verifyDeath(scanner, elodin.getClasse().getVida(), secondActText.getSecondAct("action.entranceFortress.GasResistance.death"));
        choiceRunOrStay();
    }
    //Verificar se vai correr ou ficar
    private void choiceRunOrStay(){
        while (true) {
            int choice = getPlayerChoice(scanner, secondActText.getSecondAct("pieceTwo.Fortress.init.choice.one"));

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

        dialogue.add(systemText.getSystemMessage("action.fortress.run"));
        dialogue.add(String.format(systemText.getSystemMessage("test.forca"), forcaElodin));

        for (int roll = 1; roll <= forcaElodin; roll++) {
            diceResult = rollDice(1, 20);
            dialogue.add(String.format(systemText.getSystemMessage("roll.dice"), diceResult));

            if (diceResult >= difficultyRun) {
                break;
            }
        }
        //Caso se sua tentativa de correr falhar
        if (diceResult < difficultyRun) {

            dialogue.add(systemText.getSystemMessage("test.failure"));
            dialogue.add(secondActText.getSecondAct("pieceTwo.Fortress.init.choice.run.failure"));
            dialogue.add(String.format(systemText.getSystemMessage("item.received"),receiveMask()));
            //ADICIONAR CÓDIGO PARA INSERIR A MÁSCARA DE GÁS NO INVENTÁRIO

            displayDialogue(scanner, dialogue);
            stayChoiceDialogue();
        } else {
            dialogue.add(secondActText.getSecondAct( "pieceTwo.Fortress.init.choice.run.success"));

            int damage = rollDice(1, 4) + 3;
            int newHealth = elodin.getClasse().getVida() - damage;
            elodin.getClasse().setVida(newHealth);
            dialogue.add(actualLife(damage, elodin.getClasse().getVida(), defaultLife));
            displayDialogue(scanner, dialogue);
            verifyDeath(scanner, elodin.getClasse().getVida(), secondActText.getSecondAct("action.entranceFortress.GasResistance.death"));
            escape = true;
        }

    }

    private void choiceStayRecieveItem(){
        printText(scanner, secondActText.getSecondAct("pieceTwo.Fortress.init.choice.stay"));
        printText(scanner, String.format(systemText.getSystemMessage("item.received"),receiveMask()));

        stayChoiceDialogue();
    }


    private void stayChoiceDialogue() {
        Humano lena = humanoFactoryController.createLena();
        List<String> dialogue = Arrays.asList(
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.1"),
                secondActText.getSecondAct("pieceTwo.Fortress.init.choice.stay.pause.1"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.2"),
                secondActText.getSecondAct("pieceTwo.Fortress.init.choice.stay.silence"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.3"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.4"),
                secondActText.getSecondAct("pieceTwo.Fortress.init.choice.stay.pause.2"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.5"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.6"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.7"),
                elodin.getFala("secondAct.pieceTwo.Fortress.choice.stay.1"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.8"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.9"),
                secondActText.getSecondAct("pieceTwo.Fortress.init.choice.stay.pause.3"),
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
                secondActText.getSecondAct("pieceTwo.Fortress.init.choice.stay.pause.3"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.15"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.16"),
                elodin.getFala("secondAct.pieceTwo.Fortress.choice.stay.4"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.17"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.18"),
                elodin.getFala("secondAct.pieceTwo.Fortress.choice.stay.5"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.19"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.20"),
                secondActText.getSecondAct("pieceTwo.Fortress.init.choice.stay.disturbance"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.21"),
                secondActText.getSecondAct("pieceTwo.Fortress.init.choice.stay.sensation"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.22"),
                lena.getFala("secondAct.pieceTwo.Fortress.choice.stay.23"),
                secondActText.getSecondAct("pieceTwo.Fortress.init.choice.stay.final"),
                secondActText.getSecondAct("pieceTwo.Fortress.init.choice.stay.final.2")

                );
        displayDialogue(scanner, dialogue);
    }
    private String receiveMask(){
        Item mask = lena.getInventario().getItemById(5L);
        lena.transferItemTo(mask , elodin);
        return mask.getNome();
    }
}