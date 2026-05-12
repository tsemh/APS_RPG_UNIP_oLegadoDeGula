package unip.joo.view;

import unip.joo.controller.Gula.MonstroController;
import unip.joo.model.ENUM.NomeAtributo;
import unip.joo.model.entities.Habilidade;
import unip.joo.model.entities.Humano;
import unip.joo.model.entities.Item;
import unip.joo.model.entities.Monstro;
import unip.joo.resources.SystemText;
import unip.joo.resources.ThirdActText;
import unip.joo.util.Util.*;

import java.util.*;

import static unip.joo.util.Util.*;

public class ThirdAct {
    private final ThirdActText thirdActText = new ThirdActText();
    private final SystemText systemText = new SystemText();
    private final Scanner scanner = new Scanner(System.in);
    private final MonstroController monstroController = new MonstroController();

    private Humano elodin;
    private Humano lena; // Encapsulamento
    private int forcaElodin;
    private int agilidadeElodin;
    private int vigorElodin;
    private int defaultLife;

    private final Map<Integer, Integer> abilityCooldown = new HashMap<>();
    private int currentTurn = 0;
    private Monstro gula = monstroController.createGula();

    public void init(Humano elodin, Humano lena, int defaultLife, boolean escape) {
        this.elodin = elodin;
        this.lena = lena;
        this.forcaElodin = elodin.getClasse().getAtributo(NomeAtributo.FORCA);
        this.agilidadeElodin = elodin.getClasse().getAtributo(NomeAtributo.AGILIDADE);
        this.vigorElodin = elodin.getClasse().getAtributo(NomeAtributo.VIGOR);
        this.defaultLife = defaultLife;

        elodin.menu(scanner);
        if(escape) {
            startDirectCombat();
        } else {
            thirdActInit();
        }
    }

    // ========================= TERCEIRO ATO ===========================

    private void thirdActInit() {
        Item pendrive = lena.getInventario().getItemById(6L);
        lena.transferItemTo(pendrive , elodin);
        List<String> initialDialogue = List.of(
                thirdActText.getThirdAct("pieceOne.ato"),
                thirdActText.getThirdAct("pieceOne.lenaApproaches.1"),
                lena.getFala("thirdAct.lena.penDrive.one"),
                String.format(systemText.getSystemMessage("item.received"),pendrive.getNome()),
                elodin.getFala("thirdAct.pieceOne.talkLena"),
                thirdActText.getThirdAct("pieceOne.lenaApproaches.2"),
                thirdActText.getThirdAct("pieceOne.lenaApproaches.3"),
                lena.getFala("thirdAct.lena.penDrive.two")
        );
        displayDialogue(scanner, initialDialogue);

        testAgilityToRun();
    }


    private void testAgilityToRun() {
        int valueTest = 10;

        List<String> dialogue = new ArrayList<>();
        dialogue.add(String.format(systemText.getSystemMessage("test.agilidade"), agilidadeElodin));

        int diceResult = 0;

        for (int roll = 1; roll <= vigorElodin; roll++) {
            diceResult = rollDice(1, 20);
            dialogue.add(String.format(systemText.getSystemMessage("roll.dice"), diceResult));
        }

        dialogue.add(thirdActText.getThirdAct("pieceOne.precombat.default"));

        if (diceResult >= valueTest) {
            dialogue.add(thirdActText.getThirdAct("pieceOne.precombat.success"));
            dialogue.add(thirdActText.getThirdAct("pieceOne.precombat.success.2"));
            dialogue.add(thirdActText.getThirdAct("pieceOne.precombat.success.3"));
        } else {
            dialogue.add(thirdActText.getThirdAct("pieceOne.precombat.failure"));
            dialogue.add(thirdActText.getThirdAct("pieceOne.precombat.failure.2"));

        }
        displayDialogue(scanner, dialogue);
        startDirectCombat();
    }


    private void startDirectCombat() {
        List<String> narrative = List.of(
                "INICIO COMBATE - DANTE VS GULA",
                "A criatura se aproxima lentamente.",
                "Seu núcleo roxo pulsa no escuro.",
                "Está na hora."
        );
        displayDialogue(scanner, narrative);
        startCombat();
    }

    private void startFinalCombat() {
        gula =  monstroController.createCorruptedGula();
        List<String> narrative = List.of(
                "LUTA FINAL - DANTE VS GULA (CORROMPIDA)",
                "Agora desestabilizada pelo pen drive.",
                "Ela está fraca... mas ainda perigosa."
        );
        displayDialogue(scanner, narrative);
        startCombat();
    }

    private void startCombat() {
        try {
            initializeAbilityCooldown();
            currentTurn = 0;

            int danteAgilidade = agilidadeElodin;
            int gulaAgilidade = gula.getClasse().getAtributo(NomeAtributo.AGILIDADE);

            printText(scanner, String.format(">> INICIATIVA: Dante [%d] vs Gula [%d]", danteAgilidade, gulaAgilidade));

            boolean danteFirst = resolveInitiative(danteAgilidade, gulaAgilidade);

            if (danteFirst) {
                printText(scanner, ">> O núcleo de Gula pisca! Você vê uma fraqueza!");
                printText(scanner, ">> Dante começa a correr em direção à inimiga!");
            } else {
                printText(scanner, ">> Gula percebe seu alívio!");
                printText(scanner, ">> Ela avança em sua direção com tudo que tem!");
            }

            int gulaDefense = gula.getClasse().getDefesa();
            int gulaHealth = gula.getClasse().getVida();
            int elodinHealth = elodin.getClasse().getVida();
            int elodinDefense = elodin.getClasse().getDefesa();

            while (elodinHealth > 0 && gulaHealth > 0) {
                printText(scanner, String.format("\n>> TURNO [%d]", currentTurn));
                printText(scanner, String.format(">> Dante: [%d/%d] | Gula: [%d/%d]", elodinHealth, defaultLife, gulaHealth, 100));

                int choice = getPlayerChoice(scanner, "\n[1] Ataque Simples [4] Tiro de Precisão\n[2] Ataque Desesperado [5] Ver Habilidades");

                if (choice == 5) {
                    elodin.showAbilities(scanner);
                    continue;
                }

                if (!isValidChoice(choice, 1, 2, 4)) {
                    printText(scanner, "Opção inválida!");
                    continue;
                }

                executeElodinTurn(choice, gula, gulaDefense);
                currentTurn++;
                gulaHealth = gula.getClasse().getVida();
                elodinHealth = elodin.getClasse().getVida();

                if (gulaHealth > 0 && elodinHealth > 0) {
                    executeGulaTurn(gula, elodinDefense);
                    elodinHealth = elodin.getClasse().getVida();
                }
            }

            if (gulaHealth <= 0) {
                victoryCombat();
            } else {
                defeatCombat();
            }

        } catch (Exception e) {
            printText(scanner, "Erro durante o combate!");
            e.printStackTrace();
        }
    }

    private void initializeAbilityCooldown() {
        abilityCooldown.put(2, 0);
    }

    private boolean resolveInitiative(int elodinAgility, int gulaAgility) {
            int elodinRoll = rollDice(1, 20);
            int gulaRoll = rollDice(1, 20);

        printText(scanner, String.format(thirdActText.getThirdAct("combat.diceRoll"), elodinRoll));
        printText(scanner, String.format(thirdActText.getThirdAct("combat.enemyDiceRoll"), gulaRoll));

        return elodinRoll > gulaRoll;
    }

    private void showAvailableAbilities() {
        if (elodin.getClasse() == null) {
            System.out.println(systemText.getSystemMessage("error.noAbilities"));
            scanner.nextLine();
            return;
        }

        List<Habilidade> habilidades = elodin.getClasse().getHabilidades();
        
        if (habilidades == null || habilidades.isEmpty()) {
            System.out.println(systemText.getSystemMessage("error.noAbilities"));
            scanner.nextLine();
            return;
        }

        System.out.println("\n========== HABILIDADES ==========");
        for (Habilidade habilidade : habilidades) {
            System.out.println("- " + habilidade.getNome());
            System.out.println("  Descrição: " + habilidade.getDescricao());
            System.out.println("  Dados: " + habilidade.getQuantidadeDado() + "d" + habilidade.getValorDado() + " + " + habilidade.getValorExtra());
            System.out.println();
        }
        System.out.println("=================================");
        System.out.print("Pressione [ENTER] para continuar: ");
        scanner.nextLine();
    }

    private boolean isItemEquipped(String itemName) {
        if (elodin.getInventario() == null || elodin.getInventario().getItens() == null) {
            return false;
        }

        for (unip.joo.model.entities.Item item : elodin.getInventario().getItens()) {
            if (item.getNome().equals(itemName) && item.isEquipado()) {
                return true;
            }
        }
        return false;
    }

    private void executeElodinTurn(int choice, Monstro gula, int gulaDefense) {
        List<String> dialogue = new ArrayList<>();
        int diceRoll = rollDice(1, 20);
        int attackRoll = diceRoll + forcaElodin;
        int baseDamage = 0;
        String narrativa = "";

        switch (choice) {
            case 1:
                baseDamage = rollDice(3, 10) + 3;
                narrativa = (attackRoll >= gulaDefense) ?
                        "Elodin avança com cautela e golpeia Gula com o cano de metal, acertando partes instáveis!" :
                        "Elodin tenta atacar, mas hesita no último instante. O golpe passa perto sem causar dano.";
                break;
            case 2:
                baseDamage = rollDice(3, 10) + 3;
                int dualDamage = rollDice(1, 10);
                baseDamage += dualDamage;
                narrativa = (attackRoll >= gulaDefense) ?
                        "Elodin percebe a instabilidade e avança sem pensar! Com força total, ele gira o cano acima da cabeça e desfere um golpe horizontal brutal!" :
                        "Elodin tenta atingir em cheio, mas Gula se desfaz em gosma escura. O golpe apenas atravessa energia instável!";
                break;
            case 4:
                diceRoll = rollDice(1, 20);
                attackRoll = diceRoll + agilidadeElodin;
                baseDamage = rollDice(3, 12) + 3;
                narrativa = (attackRoll >= gulaDefense) ?
                        "Elodin estabiliza a respiração e aponta a pistola para o núcleo de Gula. O disparo acerta em cheio!" :
                        "Elodin tenta atirar, mas as luzes piscam agressivamente. Seu disparo apenas atravessa uma parte instável.";
                break;
        }

        dialogue.add(String.format(">> Dado de ataque: [%d] vs Defesa de Gula: [%d]", attackRoll, gulaDefense));

        if (attackRoll >= gulaDefense) {
            int finalDamage = baseDamage;
            int newGulaHealth = gula.getClasse().getVida() - finalDamage;
            gula.getClasse().setVida(Math.max(0, newGulaHealth));
            dialogue.add(narrativa);
            dialogue.add(String.format(">> Gula perdeu [%d] pontos de vida!", finalDamage));
        } else {
            dialogue.add(narrativa);
            dialogue.add(">> FALHA NO ATAQUE!");
        }

        displayDialogue(scanner, dialogue);
    }

    private void executeGulaTurn(Monstro gula, int elodinDefense) {
        try {
            printText(scanner, "\n>> TURNO DE GULA");

            int attackChoice = rollDice(1, 3);

            List<String> dialogue = new ArrayList<>();
            int gulaAgilidade = gula.getClasse().getAtributo(NomeAtributo.AGILIDADE);
            int diceRoll = rollDice(1, 20);
            int attackRoll = diceRoll + gulaAgilidade;
            int damage = 0;

            switch (attackChoice) {
                case 1:
                    damage = rollDice(1, 10) + 5;
                    String laserNarrative = (attackRoll >= elodinDefense) ?
                            "O núcleo de Gula pulsa violentamente! Uma descarga roxa escapa e atinge você brutalmente!" :
                            "A energia oscila descontrolada. O disparo explode contra o cenário antes de alcançá-lo.";
                    dialogue.add(laserNarrative);
                    break;

                case 2:
                    damage = rollDice(2, 6) + 3;
                    String tentacleNarrative = (attackRoll >= elodinDefense) ?
                            "Partes do corpo de Gula se abrem violentamente! Tentáculos instáveis emergem e atingem você com brutalidade!" :
                            "Os tentáculos avançam descontrolados, atingindo paredes. A instabilidade faz os ataques perderem precisão!";
                    dialogue.add(tentacleNarrative);
                    break;

                case 3:
                    damage = rollDice(2, 12) + 5;
                    String finalNarrative = "Gula para completamente! Seu núcleo começa a pulsar agressivamente! Uma gigantesca descarga roxa explode em sua direção!";
                    dialogue.add(finalNarrative);
                    break;
            }

            if (attackRoll >= elodinDefense) {
                int newElodinHealth = elodin.getClasse().getVida() - damage;
                elodin.getClasse().setVida(Math.max(0, newElodinHealth));
                dialogue.add(String.format(">> Você perdeu [%d] pontos de vida!", damage));
            } else {
                dialogue.add(">> Você conseguiu esquivar!");
            }

            displayDialogue(scanner, dialogue);

        } catch (Exception e) {
            printText(scanner, "Erro no turno de Gula!");
            e.printStackTrace();
        }
    }

    private void victoryCombat() {
        List<String> victory = List.of(
                "\n========== VITÓRIA ==========",
                "",
                "Gula recua pela primeira vez.",
                "Seu núcleo pisca violentamente enquanto partes de seu corpo perdem forma.",
                "O brilho roxo que preenchia tudo começa a enfraquecer.",
                "",
                "Elodin respira com dificuldade.",
                "Seu corpo dói.",
                "Suas mãos tremem.",
                "Mas ele continua avançando.",
                "",
                "A criatura tenta se recompor uma última vez.",
                "Distorcendo sua estrutura em formas impossíveis.",
                "Tarde demais.",
                "",
                "Elodin ergue o cano de metal acima da cabeça.",
                "Com toda a força que ainda resta... ele atravessa o núcleo de Gula.",
                "",
                "Por um instante...",
                "silêncio.",
                "",
                "Então a criatura inteira começa a colapsar.",
                "A energia roxa explode pelo ambiente.",
                "As paredes tremem violentamente.",
                "Os tentáculos desaparecem.",
                "As luzes se apagam.",
                "",
                "E Gula finalmente deixa de existir.",
                "",
                "Elodin permanece parado diante dos restos da criatura.",
                "Tentando recuperar o ar.",
                "",
                "Pela primeira vez em muito tempo...",
                "o silêncio parece seguro.",
                "",
                "FIM - O LEGADO DE GULA"
        );
        displayDialogue(scanner, victory);
    }

    private void defeatCombat() {
        List<String> defeat = List.of(
                "\n========== DERROTA ==========",
                "",
                "Elodin tenta permanecer de pé.",
                "Seu corpo falha.",
                "O calor das queimaduras atravessa sua pele.",
                "A instalação inteira pisca ao redor dele.",
                "",
                "Gula se aproxima lentamente.",
                "Sem pressa.",
                "Sem hesitação.",
                "Seu núcleo pulsa de forma pesada.",
                "Iluminando o corredor escuro com uma luz roxa instável.",
                "",
                "Elodin tenta erguer a arma mais uma vez.",
                "Mas seus braços não respondem.",
                "",
                "A criatura para diante dele.",
                "Por um breve instante...",
                "o brilho do núcleo reflete diretamente em seus olhos.",
                "",
                "Então...",
                "tentáculos de energia atravessam seu corpo violentamente.",
                "O cano de metal cai no chão.",
                "A pistola desliza para longe.",
                "",
                "As luzes da instalação começam a falhar uma última vez.",
                "",
                "E tudo desaparece em roxo."
        );
        displayDialogue(scanner, defeat);
        verifyDeath(scanner, 0, "");
    }
}
