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
    // ==================== CONSTANTES ====================
    private static final int COOLDOWN_TURNS = 2;
    private static final int AGILITY_TEST_DC = 10;
    private static final int SPECIAL_ATTACK_DICE = 2;
    private static final int SPECIAL_ATTACK_VALUE = 12;
    private static final int SPECIAL_ATTACK_EXTRA = 5;

    // IDs das habilidades
    private static final long HABILIDADE_RUPTURA = 3L;
    private static final long HABILIDADE_VIOLENCIA = 4L;
    private static final long HABILIDADE_IMPACTO = 5L;
    private static final long HABILIDADE_ESMAGA = 6L;
    private static final long HABILIDADE_TIRO_SIMPLES = 7L;
    private static final long HABILIDADE_DISPARO_RUPTURA = 8L;
    private static final long HABILIDADE_TIRO_PRECISAO = 9L;
    private static final long HABILIDADE_DISPARO_DESESPERADO = 10L;

    private static final long GULA_HAB_LASER = 1L;
    private static final long GULA_HAB_TENTACULOS = 2L;
    private static final long GULA_HAB_LASER_FINAL = 3L;
    private static final long GULA_HAB_CONSUMO = 4L;

    // ==================== ATRIBUTOS ====================
    private final ThirdActText thirdActText = new ThirdActText();
    private final SystemText systemText = new SystemText();
    private final Scanner scanner = new Scanner(System.in);
    private final MonstroController monstroController = new MonstroController();
    private final Map<Integer, Integer> abilityCooldown = new HashMap<>();

    private Humano elodin;
    private Humano lena;
    private int forcaElodin;
    private int agilidadeElodin;
    private int vigorElodin;
    private int defaultLife;
    private int currentTurn = 0;
    private Monstro gula;

    // ==================== INICIALIZAÇÃO ====================

    public void init(Humano elodin, Humano lena, int defaultLife, boolean escape) {
        initializeCharacterAttributes(elodin, lena, defaultLife);
        elodin.menu(scanner);

        if (escape) {
            startDirectCombat();
        } else {
            thirdActInit();
        }
    }

    private void initializeCharacterAttributes(Humano elodin, Humano lena, int defaultLife) {
        this.elodin = elodin;
        this.lena = lena;
        this.forcaElodin = elodin.getClasse().getAtributo(NomeAtributo.FORCA);
        this.agilidadeElodin = elodin.getClasse().getAtributo(NomeAtributo.AGILIDADE);
        this.vigorElodin = elodin.getClasse().getAtributo(NomeAtributo.VIGOR);
        this.defaultLife = defaultLife;
        this.gula = monstroController.createGula();
    }

    // ==================== SISTEMA DE COOLDOWN ====================

    private void initializeCooldown() {
        for (int i = 1; i <= 4; i++) {
            abilityCooldown.put(i, 0);
        }
    }

    private boolean isAbilityAvailable(int abilityId) {
        return currentTurn >= abilityCooldown.getOrDefault(abilityId, 0);
    }

    private void applyCooldown(int abilityId) {
        abilityCooldown.put(abilityId, currentTurn + COOLDOWN_TURNS);
    }

    private String getCooldownMessage(int abilityId, String abilityName) {
        int turnsRemaining = abilityCooldown.getOrDefault(abilityId, 0) - currentTurn;
        return String.format("%s está em recarga! Ainda faltam %d turno(s) para poder usá-la novamente.",
                abilityName, turnsRemaining);
    }

    // ==================== TERCEIRO ATO - CENA INICIAL ====================

    private void thirdActInit() {
        transferPendrive();
        displayInitialDialogue();
        testAgilityToRun();
    }

    private void transferPendrive() {
        Item pendrive = lena.getInventario().getItemById(6L);
        lena.transferItemTo(pendrive, elodin);
    }

    private void displayInitialDialogue() {
        Item pendrive = elodin.getInventario().getItemById(6L);
        List<String> dialogue = List.of(
                thirdActText.getThirdAct("pieceOne.ato"),
                thirdActText.getThirdAct("pieceOne.lenaApproaches.1"),
                lena.getFala("thirdAct.lena.penDrive.one"),
                String.format(systemText.getSystemMessage("item.received"), pendrive.getNome()),
                elodin.getFala("thirdAct.pieceOne.talkLena"),
                thirdActText.getThirdAct("pieceOne.lenaApproaches.2"),
                thirdActText.getThirdAct("pieceOne.lenaApproaches.3"),
                lena.getFala("thirdAct.lena.penDrive.two")
        );
        displayDialogue(scanner, dialogue);
    }

    private void testAgilityToRun() {
        List<String> dialogue = new ArrayList<>();
        dialogue.add(String.format(systemText.getSystemMessage("test.agilidade"), agilidadeElodin));

        int diceResult = rollRepeatedDice(vigorElodin, dialogue);
        dialogue.add(thirdActText.getThirdAct("pieceOne.precombat.default"));

        boolean success = diceResult >= AGILITY_TEST_DC;

        if (success) {
            handleAgilitySuccess(dialogue);
        } else {
            handleAgilityFailure(dialogue);
        }

        displayDialogue(scanner, dialogue);
        startCombat();
    }

    private int rollRepeatedDice(int rolls, List<String> dialogue) {
        int result = 0;
        for (int i = 0; i < rolls; i++) {
            result = rollDice(1, 20);
            dialogue.add(String.format(systemText.getSystemMessage("roll.dice"), result));
            if (result >= AGILITY_TEST_DC) break;
        }
        return result;
    }

    private void handleAgilitySuccess(List<String> dialogue) {
        dialogue.add(thirdActText.getThirdAct("pieceOne.precombat.success"));
        dialogue.add(thirdActText.getThirdAct("pieceOne.precombat.success.2"));
        dialogue.add(thirdActText.getThirdAct("pieceOne.precombat.success.3"));
        gula = monstroController.createCorruptedGula();
    }

    private void handleAgilityFailure(List<String> dialogue) {
        dialogue.add(thirdActText.getThirdAct("pieceOne.precombat.failure"));
        dialogue.add(thirdActText.getThirdAct("pieceOne.precombat.failure.2"));
    }

    // ==================== COMBATE DIRETO (SEM CENA) ====================

    private void startDirectCombat() {
        try {
            initializeCooldown();
            currentTurn = 0;

            displayDirectCombatDialogue();
            handleInitiative();
            startCombat();
        } catch (Exception e) {
            printText(scanner, systemText.getSystemMessage("error.combatInit"));
            e.printStackTrace();
        }
    }

    private void displayDirectCombatDialogue() {
        List<String> dialogue = new ArrayList<>();
        dialogue.add(thirdActText.getThirdAct("pieceOne.ato"));
        dialogue.add(thirdActText.getThirdAct("pieceOne.directcombat"));
        displayDialogue(scanner, dialogue);
    }

    private void handleInitiative() {
        int gulaAgilidade = gula.getClasse().getAtributo(NomeAtributo.AGILIDADE);
        boolean playerFirst = resolveInitiative(scanner, agilidadeElodin, gulaAgilidade);

        List<String> dialogue = new ArrayList<>();

        if (playerFirst) {
            addInitiativeSuccessDialogue(dialogue);
        } else {
            addInitiativeFailureDialogue(dialogue);
            applyGulaSpecialAttack();
        }

        displayDialogue(scanner, dialogue);
    }

    private void addInitiativeSuccessDialogue(List<String> dialogue) {
        dialogue.add(thirdActText.getThirdAct("pieceOne.directcombat.initiative.success"));
        dialogue.add(thirdActText.getThirdAct("pieceOne.directcombat.initiative.success.2"));
        dialogue.add(thirdActText.getThirdAct("pieceOne.directcombat.initiative.success.3"));
        dialogue.add(thirdActText.getThirdAct("pieceOne.directcombat.initiative.success.4"));
    }

    private void addInitiativeFailureDialogue(List<String> dialogue) {
        dialogue.add(thirdActText.getThirdAct("pieceOne.directcombat.initiative.failure"));
        dialogue.add(thirdActText.getThirdAct("pieceOne.directcombat.initiative.failure.2"));
        dialogue.add(thirdActText.getThirdAct("pieceOne.directcombat.initiative.failure.3"));
        dialogue.add(thirdActText.getThirdAct("pieceOne.directcombat.initiative.failure.4"));
        dialogue.add(thirdActText.getThirdAct("pieceOne.directcombat.initiative.failure.5"));
    }

    private void applyGulaSpecialAttack() {
        try {
            printText(scanner, thirdActText.getThirdAct("combat.gula.specialAttack"));
            int damage = rollDice(SPECIAL_ATTACK_DICE, SPECIAL_ATTACK_VALUE) + SPECIAL_ATTACK_EXTRA;

            if (damage > 0) {
                int newHealth = elodin.getClasse().getVida() - damage;
                elodin.getClasse().setVida(Math.max(0, newHealth));
                printText(scanner, String.format(systemText.getSystemMessage("roll.losesLife"), damage));
            }
        } catch (Exception e) {
            printText(scanner, systemText.getSystemMessage("error.specialAttack"));
            e.printStackTrace();
        }
    }

    // ==================== LOOP PRINCIPAL DO COMBATE ====================

    private void startCombat() {
        try {
            currentTurn = 0;
            int gulaDefense = gula.getClasse().getDefesa();
            int gulaHealth = gula.getClasse().getVida();
            int elodinHealth = elodin.getClasse().getVida();
            int elodinDefense = elodin.getClasse().getDefesa();

            printText(scanner, gula.getStatus());
            printText(scanner, systemText.getSystemMessage("turn.your"));

            while (elodinHealth > 0 && gulaHealth > 0) {
                printText(scanner, String.format(systemText.getSystemMessage("turn.counter"), currentTurn));

                int choice = getChoice();

                if (choice == 5) {
                    continue;
                }

                if (!isValidChoice(choice, 1, 2, 3, 4)) {
                    printText(scanner, systemText.getSystemMessage("error.invalidOption"));
                    continue;
                }

                if (!isAbilityAvailable(choice)) {
                    printCooldownMessage(choice);
                    continue;
                }

                executePlayerTurn(choice, gula, gulaDefense);
                applyCooldown(choice);

                currentTurn++;
                gulaHealth = gula.getClasse().getVida();
                elodinHealth = elodin.getClasse().getVida();

                if (gulaHealth > 0 && elodinHealth > 0) {
                    executeMonsterTurn(gula, elodinDefense);
                    elodinHealth = elodin.getClasse().getVida();
                }
            }

            resolveCombatOutcome(gulaHealth, elodinHealth);
        } catch (Exception e) {
            printText(scanner, "Erro durante o combate!");
            e.printStackTrace();
        }
    }

    private int getChoice() {
        Item pistola = elodin.getInventario().getItemById(4L);

        if (pistola != null && pistola.isEquipado()) {
            return showPistolaAbilities();
        } else {
            return showBarraMetalAbilities();
        }
    }

    private void printCooldownMessage(int choice) {
        Item pistola = elodin.getInventario().getItemById(4L);
        boolean hasPistol = pistola != null && pistola.isEquipado();
        String abilityName = getAbilityName(choice, hasPistol);
        printText(scanner, getCooldownMessage(choice, abilityName));
    }

    private void resolveCombatOutcome(int gulaHealth, int elodinHealth) {
        if (gulaHealth <= 0) {
            victoryCombat();
        } else if (elodinHealth <= 0) {
            defeatCombat();
        }
    }

    // ==================== MENUS DE HABILIDADES ====================

    private int showPistolaAbilities() {
        List<String> options = Arrays.asList(
                systemText.getSystemMessage("pistola.abilities")
        );
        return getPlayerChoice(scanner, String.join("\n", options));
    }

    private int showBarraMetalAbilities() {
        List<String> options = Arrays.asList(
                systemText.getSystemMessage("barra.abilities")
        );
        return getPlayerChoice(scanner, String.join("\n", options));
    }


    private String getAbilityName(int abilityId, boolean hasPistol) {
        long abilityIdentifier = getAbilityId(abilityId, hasPistol);
        Habilidade hab = elodin.getClasse().getHabilidade(abilityIdentifier);
        
        if (hab != null) {
            return hab.getNome();
        }
        return "Habilidade desconhecida";
    }

    private long getAbilityId(int choice, boolean hasPistol) {
        if (hasPistol) {
            return switch (choice) {
                case 1 -> HABILIDADE_TIRO_SIMPLES;
                case 2 -> HABILIDADE_DISPARO_RUPTURA;
                case 3 -> HABILIDADE_TIRO_PRECISAO;
                case 4 -> HABILIDADE_DISPARO_DESESPERADO;
                default -> 0L;
            };
        } else {
            return switch (choice) {
                case 1 -> HABILIDADE_RUPTURA;
                case 2 -> HABILIDADE_VIOLENCIA;
                case 3 -> HABILIDADE_IMPACTO;
                case 4 -> HABILIDADE_ESMAGA;
                default -> 0L;
            };
        }
    }

    // ==================== TURNO DO JOGADOR ====================

    private void executePlayerTurn(int choice, Monstro gula, int gulaDefense) {
        Item pistola = elodin.getInventario().getItemById(4L);
        boolean hasPistol = pistola != null && pistola.isEquipado();

        CombatTurnResult result = calculatePlayerTurn(hasPistol, choice, gulaDefense);
        displayPlayerTurnResult(result, hasPistol, choice);

        if (result.hit && !result.criticalError) {
            applyDamageToMonster(gula, result.finalDamage);
        } else if (result.criticalError) {
            applySelfDamage(result.selfDamage);
        }
    }

    private CombatTurnResult calculatePlayerTurn(boolean hasPistol, int choice, int gulaDefense) {
        int diceRoll = rollDice(1, 20);
        int attackRoll = diceRoll + (hasPistol ? agilidadeElodin : forcaElodin);
        int baseDamage = getBaseDamage(hasPistol, choice);

        boolean isCritical = diceRoll == 20;
        boolean isCriticalError = diceRoll == 1;
        boolean hit = attackRoll >= gulaDefense;

        int finalDamage = baseDamage;
        int selfDamage = baseDamage / 2;

        if (isCritical && hit && !isCriticalError) {
            finalDamage = baseDamage * 2;
        }

        return new CombatTurnResult(hit, isCritical, isCriticalError, finalDamage, selfDamage, attackRoll);
    }

    private int getBaseDamage(boolean hasPistol, int choice) {
        if (hasPistol) {
            return switch (choice) {
                case 1, 2, 3 -> rollDice(3, 12) + 3;
                case 4 -> rollDice(5, 8) + 1;
                default -> 0;
            };
        } else {
            return switch (choice) {
                case 1, 2, 3, 4 -> rollDice(2, 10) + 3;
                default -> 0;
            };
        }
    }

    private void displayPlayerTurnResult(CombatTurnResult result, boolean hasPistol, int choice) {
        List<String> dialogue = new ArrayList<>();
        dialogue.add(String.format(systemText.getSystemMessage("combat.roll.attack"), result.attackRoll,
                gula.getClasse().getDefesa()));

        if (result.isCritical) {
            dialogue.add(systemText.getSystemMessage("combat.critical"));
        } else if (result.criticalError) {
            dialogue.add(systemText.getSystemMessage("combat.criticalError"));
        }

        if (result.hit && !result.criticalError) {
            dialogue.add(getSuccessNarrative(hasPistol, choice));
            dialogue.add(String.format(systemText.getSystemMessage("roll.losesLife.drone"), result.finalDamage));
        } else if (result.criticalError) {
            dialogue.add(getCriticalErrorNarrative(hasPistol, choice));
            dialogue.add(String.format(systemText.getSystemMessage("combat.player.self.damage"), result.selfDamage));
        } else {
            dialogue.add(getFailureNarrative(hasPistol, choice));
            dialogue.add(systemText.getSystemMessage("test.failure"));
        }

        displayDialogue(scanner, dialogue);
    }

    private String getSuccessNarrative(boolean hasPistol, int choice) {
        String key = String.format("combat.%s.success%d", hasPistol ? "pistola" : "barra", choice);
        return thirdActText.getThirdAct(key);
    }

    private String getFailureNarrative(boolean hasPistol, int choice) {
        String key = String.format("combat.%s.failure%d", hasPistol ? "pistola" : "barra", choice);
        return thirdActText.getThirdAct(key);
    }

    private String getCriticalErrorNarrative(boolean hasPistol, int choice) {
        String key = String.format("combat.%s.criticalError%d", hasPistol ? "pistola" : "barra", choice);
        return thirdActText.getThirdAct(key);
    }

    private void applyDamageToMonster(Monstro gula, int damage) {
        int newHealth = gula.getClasse().getVida() - damage;
        gula.getClasse().setVida(Math.max(0, newHealth));
    }

    private void applySelfDamage(int damage) {
        int newHealth = elodin.getClasse().getVida() - damage;
        elodin.getClasse().setVida(Math.max(0, newHealth));
    }

    // ==================== TURNO DO MONSTRO ====================

    private void executeMonsterTurn(Monstro gula, int elodinDefense) {
        try {
            printText(scanner, systemText.getSystemMessage("turn.enemy"));

            int attackChoice = rollDice(1, 4);
            MonsterAttack attack = getMonsterAttack(gula, attackChoice);

            if (attack.isHealing) {
                applyMonsterHeal(gula, attack.damage);
                return;
            }

            CombatTurnResult result = calculateMonsterTurn(gula, attack, elodinDefense);
            displayMonsterTurnResult(attack, result);

            if (result.hit && !result.criticalError) {
                applyDamageToPlayer(result.finalDamage);
            } else if (result.criticalError) {
                applyDamageToMonster(gula, result.selfDamage);
            }

            printText(scanner, systemText.getSystemMessage("combat.separator"));
        } catch (Exception e) {
            printText(scanner, "Erro no turno de Gula!");
            e.printStackTrace();
        }
    }

    private MonsterAttack getMonsterAttack(Monstro gula, int choice) {
        return switch (choice) {
            case 1 -> createMonsterAttack(gula, GULA_HAB_LASER, "combat.gula.laserAttack", false);
            case 2 -> createMonsterAttack(gula, GULA_HAB_TENTACULOS, "combat.gula.tentacleAttack", false);
            case 3 -> createMonsterAttack(gula, GULA_HAB_LASER_FINAL, "combat.gula.finalDischarge", false);
            case 4 -> createMonsterAttack(gula, GULA_HAB_CONSUMO, "combat.gula.consumoEnergia", true);
            default -> createMonsterAttack(gula, GULA_HAB_LASER, "combat.gula.laserAttack", false);
        };
    }

    private MonsterAttack createMonsterAttack(Monstro gula, long abilityId, String narrativeKey, boolean isHealing) {
        Habilidade hab = gula.getClasse().getHabilidade(abilityId);
        int damage = 0;
        if (hab != null && !isHealing) {
            damage = rollDice(hab.getQuantidadeDado(), hab.getValorDado()) + hab.getValorExtra();
        } else if (hab != null && isHealing) {
            damage = rollDice(hab.getQuantidadeDado(), hab.getValorDado()) + hab.getValorExtra();
        }
        return new MonsterAttack(damage, thirdActText.getThirdAct(narrativeKey), isHealing);
    }

    private CombatTurnResult calculateMonsterTurn(Monstro gula, MonsterAttack attack, int playerDefense) {
        int diceRoll = rollDice(1, 20);
        int gulaAgilidade = gula.getClasse().getAtributo(NomeAtributo.AGILIDADE);
        int attackRoll = diceRoll + gulaAgilidade;

        boolean isCritical = diceRoll == 20;
        boolean isCriticalError = diceRoll == 1;
        boolean hit = attackRoll >= playerDefense;

        int finalDamage = attack.damage;
        int selfDamage = attack.damage / 2;

        if (isCritical && hit && !isCriticalError) {
            finalDamage = attack.damage * 2;
        }

        return new CombatTurnResult(hit, isCritical, isCriticalError, finalDamage, selfDamage, attackRoll);
    }

    private void displayMonsterTurnResult(MonsterAttack attack, CombatTurnResult result) {
        List<String> dialogue = new ArrayList<>();
        dialogue.add(String.format(systemText.getSystemMessage("combat.enemy.roll.attack"), result.attackRoll,
                elodin.getClasse().getDefesa()));

        if (result.isCritical) {
            dialogue.add(systemText.getSystemMessage("combat.critical"));
        } else if (result.criticalError) {
            dialogue.add(systemText.getSystemMessage("combat.criticalError"));
        }

        dialogue.add(attack.narrative);

        if (result.hit && !result.criticalError) {
            dialogue.add(thirdActText.getThirdAct("combat.gula.success"));
            dialogue.add(String.format(systemText.getSystemMessage("combat.player.damage.taken"), result.finalDamage));
        } else if (result.criticalError) {
            dialogue.add(thirdActText.getThirdAct("combat.gula.criticalError"));
            dialogue.add(String.format(systemText.getSystemMessage("combat.enemy.self.damage"), result.selfDamage));
        } else {
            dialogue.add(thirdActText.getThirdAct("combat.gula.failure"));
        }

        displayDialogue(scanner, dialogue);
    }

    private void applyMonsterHeal(Monstro gula, int healAmount) {
        int newHealth = gula.getClasse().getVida() + healAmount;
        int maxHealth = gula.getClasse().getVidaMaxima();
        gula.getClasse().setVida(Math.min(maxHealth, newHealth));
        int elodinNewHealth = elodin.getClasse().getVida() - healAmount;
        int elodinMaxHealth = elodin.getClasse().getVidaMaxima();
        elodin.getClasse().setVida(Math.min(elodinMaxHealth, elodinNewHealth));

        List<String> dialogue = new ArrayList<>();
        dialogue.add(thirdActText.getThirdAct("combat.gula.consumoEnergia"));
        dialogue.add(String.format(">> Gula recuperou [%d] pontos de vida!", healAmount));
        dialogue.add(String.format(">> Você perdeu [%d] pontos de vida!", healAmount));
        displayDialogue(scanner, dialogue);
    }

    private void applyDamageToPlayer(int damage) {
        int newHealth = elodin.getClasse().getVida() - damage;
        elodin.getClasse().setVida(Math.max(0, newHealth));
    }

    // ==================== DESFECHO DO COMBATE ====================

    private void victoryCombat() {
        List<String> victory = Arrays.asList(
                thirdActText.getThirdAct("combat.victory.2"),
                thirdActText.getThirdAct("combat.victory.3"),
                thirdActText.getThirdAct("combat.victory.4"),
                thirdActText.getThirdAct("combat.victory.5"),
                thirdActText.getThirdAct("combat.victory.6"),
                thirdActText.getThirdAct("combat.victory.7"),
                thirdActText.getThirdAct("combat.victory.8"),
                thirdActText.getThirdAct("combat.victory.9"),
                thirdActText.getThirdAct("combat.victory.10")
        );
        displayDialogue(scanner, victory);
    }

    private void defeatCombat() {
        List<String> defeat = Arrays.asList(
                thirdActText.getThirdAct("combat.defeat.2"),
                thirdActText.getThirdAct("combat.defeat.3"),
                thirdActText.getThirdAct("combat.defeat.4"),
                thirdActText.getThirdAct("combat.defeat.5"),
                thirdActText.getThirdAct("combat.defeat.6"),
                thirdActText.getThirdAct("combat.defeat.7"),
                thirdActText.getThirdAct("combat.defeat.8"),
                thirdActText.getThirdAct("combat.defeat.9"),
                thirdActText.getThirdAct("combat.defeat.10"),
                thirdActText.getThirdAct("combat.defeat.11"),
                thirdActText.getThirdAct("combat.defeat.12"),
                thirdActText.getThirdAct("combat.defeat.13")
        );
        verifyDeath(scanner, 0, defeat);
    }

    // ==================== RECORDS AUXILIARES ====================

    private record CombatTurnResult(boolean hit, boolean isCritical, boolean criticalError,
                                    int finalDamage, int selfDamage, int attackRoll) {}

    private record MonsterAttack(int damage, String narrative, boolean isHealing) {}
}