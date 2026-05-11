package unip.joo.view;

import unip.joo.controller.Gula.MonstroController;
import unip.joo.model.ENUM.NomeAtributo;
import unip.joo.model.entities.Habilidade;
import unip.joo.model.entities.Humano;
import unip.joo.model.entities.Monstro;
import unip.joo.resources.GameText;
import unip.joo.util.Util.*;

import java.util.*;

import static unip.joo.util.Util.*;

public class ThirdAct {
    private final GameText gameText = new GameText();
    private final Scanner scanner = new Scanner(System.in);

    private Humano dante;
    private int forcaDante;
    private int agilidadeDante;
    private int vigorDante;
    private int defaultLife;

    private final Map<Integer, Integer> abilityCooldown = new HashMap<>();
    private int currentTurn = 0;

    public void init(Humano dante, int defaultLife) {
        this.dante = dante;
        this.forcaDante = dante.getClasse().getAtributo(NomeAtributo.FORCA);
        this.agilidadeDante = dante.getClasse().getAtributo(NomeAtributo.AGILIDADE);
        this.vigorDante = dante.getClasse().getAtributo(NomeAtributo.VIGOR);
        this.defaultLife = defaultLife;

        elodin.menu(scanner);
        thirdActInit();
    }

    // ========================= TERCEIRO ATO ===========================

    private void thirdActInit() {
        List<String> initialDialogue = List.of(
            "TERCEIRO ATO - A GULA",
                "Você observa aquilo se aproximando aos poucos...",
                "Lena olha para você e entrega uma espécie de aparelho com uma entrada antiga.",
                "Lena: Você não pode tentar matar ela, você tem que restaurar ela!",
                "Lena: Corra até a sala dos servidores e coloque esse PEN DRIVE em um servidor roxo!",
                "Lena: Corra, sua vida e talvez o resto da vida de todos nesse mundo, dependem disso!",
                ">> ITEM RECEBIDO: [PEN DRIVE]"
        );
        displayDialogue(scanner, initialDialogue);

        chooseToRun();
    }

    private void chooseToRun() {
        while (true) {
            int choice = getPlayerChoice(scanner, "\n[1] Correr para os servidores\n[2] Tentar enfrentar Gula");

            if (isValidChoice(choice, 1, 2)) {
                if (choice == 1) {
                    testStrengthToRun();
                } else {
                    startDirectCombat();
                }
                return;
            } else {
                handleInvalidChoice();
            }
        }
    }

    private void testStrengthToRun() {
        List<String> dialogue = new ArrayList<>();
        dialogue.add("Você tenta correr pela sua vida!");
        dialogue.add(String.format("Teste de Força [%d] vs DT 10", forcaDante));

        int diceRoll = rollDice(1, 20);
        int testResult = diceRoll + forcaDante;
        dialogue.add(String.format(">> Seu dado é: [%s]", diceRoll));

        displayDialogue(scanner, dialogue);

        if (testResult >= 10) {
            testAgilityToDodgeDoors();
        } else {
            failedToRunNarrative();
            startDirectCombat();
        }
    }

    private void testAgilityToDodgeDoors() {
        List<String> narrative = List.of(
                "Dante corre por sua vida, em disparada em linha reta!",
                "Conforme você avança, escuta cada vez mais os barulhos metálicos daquela coisa se aproximando.",
                "A I.A tenta impedir você bloqueando os caminhos!",
                "\nTeste de Agilidade para escapar dos bloqueios",
                String.format("Teste de Agilidade [%d] vs DT 12", agilidadeDante)
        );
        displayDialogue(scanner, narrative);

        int diceRoll = rollDice(1, 20);
        int testResult = diceRoll + agilidadeDante;

        printText(scanner, String.format(">> Seu dado é: [%s]", diceRoll));

        if (testResult >= 12) {
            successfulRunNarrative();
            startFinalCombat();
        } else {
            failedToDodgeNarrative();
            startDirectCombat();
        }
    }

    private void failedToRunNarrative() {
        List<String> dialogue = List.of(
                "Dante tenta correr, mas Gula é mais rápida.",
                "A porta que Lena apontava se fecha violentamente.",
                "Não há nada que você possa fazer além de enfrentar ela.",
                "Algo extremamente difícil... mas não impossível.",
                "Dante saca sua pistola e fica de frente para Gula."
        );
        displayDialogue(scanner, dialogue);
    }

    private void failedToDodgeNarrative() {
        List<String> dialogue = List.of(
                "Você tenta fazer um rolamento para passar pela porta antes que ela feche.",
                "Mas não é rápido o suficiente.",
                "Seu corpo bate na porta com força.",
                "Sua visão fica um pouco embaçada.",
                "Você olha para frente e vê... aquela que destruiu tudo que você amava.",
                "Se aproximando lentamente.",
                "Certeira de uma coisa... sua morte."
        );
        displayDialogue(scanner, dialogue);
    }

    private void successfulRunNarrative() {
        List<String> dialogue = List.of(
                "Dante se joga para frente e passa pela porta que ia se fechar!",
                "Ele rola para frente passando por outra... e consecutivamente por mais 3 portas!",
                "Pronto para acabar com isso!",
                "GULA acaba ficando para trás.",
                "Dante chega à sala dos servidores.",
                "Rapidamente colocando o pen drive no terminal principal e desestabilizando o sistema.",
                "Todas as portas se abrem.",
                "A GULA não parece tão imponente mais.",
                "Agora... é sua chance.",
                "Agora é seu momento."
        );
        displayDialogue(scanner, dialogue);
    }

    private void startDirectCombat() {
        List<String> narrative = List.of(
                "INICIO COMBATE - DANTE VS GULA",
                "A criatura se aproxima lentamente.",
                "Seu núcleo roxo pulsa no escuro.",
                "Está na hora."
        );
        displayDialogue(scanner, narrative);
        startCombat(new MonstroController().createGula(), false);
    }

    private void startFinalCombat() {
        List<String> narrative = List.of(
                "LUTA FINAL - DANTE VS GULA (CORROMPIDA)",
                "Agora desestabilizada pelo pen drive.",
                "Ela está fraca... mas ainda perigosa."
        );
        displayDialogue(scanner, narrative);
        startCombat(new MonstroController().createGula(), true);
    }

    private void startCombat(Monstro gula, boolean isFinalCombat) {
        try {
            initializeAbilityCooldown();
            currentTurn = 0;

            int danteAgilidade = agilidadeDante;
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
            int danteHealth = dante.getClasse().getVida();
            int danteDefense = dante.getClasse().getDefesa();

            while (danteHealth > 0 && gulaHealth > 0) {
                printText(scanner, String.format("\n>> TURNO [%d]", currentTurn));
                printText(scanner, String.format(">> Dante: [%d/%d] | Gula: [%d/%d]", danteHealth, defaultLife, gulaHealth, 100));

                int choice = getPlayerChoice(scanner, "\n[1] Ataque Simples [4] Tiro de Precisão\n[2] Ataque Desesperado [5] Ver Habilidades");

                if (choice == 5) {
                    dante.showAbilities(scanner);
                    continue;
                }

                if (!isValidChoice(choice, 1, 2, 4)) {
                    printText(scanner, "Opção inválida!");
                    continue;
                }

                executeDanteTurn(choice, gula, gulaDefense);
                currentTurn++;
                gulaHealth = gula.getClasse().getVida();
                danteHealth = dante.getClasse().getVida();

                if (gulaHealth > 0 && danteHealth > 0) {
                    executeGulaTurn(gula, danteDefense);
                    danteHealth = dante.getClasse().getVida();
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

    private boolean resolveInitiative(int danteAgility, int gulaAgility) {
            int danteRoll = rollDice(1, 20);
            int gulaRoll = rollDice(1, 20);

            printText(scanner, String.format(">> Seu dado: [%s] | Dado de Gula: [%s]", danteRoll, gulaRoll));

            attempts++;

        return danteRoll > gulaRoll;
    }

    private void executeDanteTurn(int choice, Monstro gula, int gulaDefense) {
        List<String> dialogue = new ArrayList<>();
        int diceRoll = rollDice(1, 20);
        int attackRoll = diceRoll + forcaDante;
        int baseDamage = 0;
        String narrativa = "";

        switch (choice) {
            case 1:
                baseDamage = rollDice(3, 10) + 3;
                narrativa = (attackRoll >= gulaDefense) ?
                        "Dante avança com cautela e golpeia Gula com o cano de metal, acertando partes instáveis!" :
                        "Dante tenta atacar, mas hesita no último instante. O golpe passa perto sem causar dano.";
                break;
            case 2:
                baseDamage = rollDice(3, 10) + 3;
                int dualDamage = rollDice(1, 10);
                baseDamage += dualDamage;
                narrativa = (attackRoll >= gulaDefense) ?
                        "Dante percebe a instabilidade e avança sem pensar! Com força total, ele gira o cano acima da cabeça e desfere um golpe horizontal brutal!" :
                        "Dante tenta atingir em cheio, mas Gula se desfaz em gosma escura. O golpe apenas atravessa energia instável!";
                break;
            case 4:
                diceRoll = rollDice(1, 20);
                attackRoll = diceRoll + agilidadeDante;
                baseDamage = rollDice(3, 12) + 3;
                narrativa = (attackRoll >= gulaDefense) ?
                        "Dante estabiliza a respiração e aponta a pistola para o núcleo de Gula. O disparo acerta em cheio!" :
                        "Dante tenta atirar, mas as luzes piscam agressivamente. Seu disparo apenas atravessa uma parte instável.";
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

    private void executeGulaTurn(Monstro gula, int danteDefense) {
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
                    String laserNarrative = (attackRoll >= danteDefense) ?
                            "O núcleo de Gula pulsa violentamente! Uma descarga roxa escapa e atinge você brutalmente!" :
                            "A energia oscila descontrolada. O disparo explode contra o cenário antes de alcançá-lo.";
                    dialogue.add(laserNarrative);
                    break;

                case 2:
                    damage = rollDice(2, 6) + 3;
                    String tentacleNarrative = (attackRoll >= danteDefense) ?
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

            if (attackRoll >= danteDefense) {
                int newDanteHealth = dante.getClasse().getVida() - damage;
                dante.getClasse().setVida(Math.max(0, newDanteHealth));
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
                "Dante respira com dificuldade.",
                "Seu corpo dói.",
                "Suas mãos tremem.",
                "Mas ele continua avançando.",
                "",
                "A criatura tenta se recompor uma última vez.",
                "Distorcendo sua estrutura em formas impossíveis.",
                "Tarde demais.",
                "",
                "Dante ergue o cano de metal acima da cabeça.",
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
                "Dante permanece parado diante dos restos da criatura.",
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
                "Dante tenta permanecer de pé.",
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
                "Dante tenta erguer a arma mais uma vez.",
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
