package unip.joo.view;

import unip.joo.controller.drone.MonstroController;
import unip.joo.controller.humanoFactory.HumanoFactoryController;
import unip.joo.controller.protagonista.HumanoController;
import unip.joo.model.ENUM.NomeAtributo;
import unip.joo.model.entities.Atributo;
import unip.joo.model.entities.Habilidade;
import unip.joo.model.entities.Humano;
import unip.joo.model.entities.Monstro;
import unip.joo.resources.GameText;

import java.util.*;

public class Game {
    private final GameText gameText = new GameText();
    private final Scanner scanner = new Scanner(System.in);

    private final HumanoController humanoController = new HumanoController();
    private final Humano elodin = humanoController.createElodin();

    private final HumanoFactoryController humanoFactoryController = new HumanoFactoryController();
    private final int vigorElodin = elodin.getClasse().getAtributo(NomeAtributo.VIGOR);
    private final int forcaElodin = elodin.getClasse().getAtributo(NomeAtributo.FORCA);

    // Mapa para controlar o tempo de espera das habilidades (turno em que ficarão disponíveis)
    private final Map<Integer, Integer> abilityCooldown = new HashMap<>();
    private int currentTurn = 0;

    public void init() {
        gameStart();
    }

    // ==================== MÉTODOS DE MENU E VALIDAÇÃO ====================

    private void printText(String text) {
        System.out.println(text);
        scanner.nextLine();
    }

    private int getPlayerChoice(String menuText) {
        try {
            System.out.println(menuText);
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (Exception e) {
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

    // ==================== MÉTODOS DE DIÁLOGO ====================

    private void displayDialogue(List<String> dialogue) {
        dialogue.forEach(this::printText);
    }

    private void displayActPiece(Map<String, String> act, String piece) {
        act.forEach((key, value) -> {
            if (key.contains(piece)) {
                printText(value);
            }
        });
    }

    // ==================== SISTEMA DE COOLDOWN ====================

    private void initializeAbilityCooldown() {
        // Habilidade 3, 4, 5, 6 com tempo de espera (cooldown de 2 turnos)
        abilityCooldown.put(3, 0); // Ruptura Desesperada
        abilityCooldown.put(4, 0); // Violência Improvisada
        abilityCooldown.put(5, 0); // Impacto Deslizante
        abilityCooldown.put(6, 0); // Esmaga Crânios
    }

    private boolean isAbilityAvailable(int abilityId) {
        int availableTurn = abilityCooldown.getOrDefault(abilityId, 0);
        return currentTurn >= availableTurn;
    }

    private void setAbilityCooldown(int abilityId, int cooldownTurns) {
        abilityCooldown.put(abilityId, currentTurn + cooldownTurns);
    }

    private String getCooldownMessage(int abilityId, Habilidade ability) {
        int availableTurn = abilityCooldown.getOrDefault(abilityId, 0);
        int turnsRemaining = availableTurn - currentTurn;
        return String.format("⚠️ %s está em recarga! Ainda faltam %d turno(s) para poder usá-la novamente.",
                ability.getNome(), turnsRemaining);
    }

    // ==================== PRIMEIRO ATO ====================

    private void gameStart() {
        System.out.println(gameText.getSystemMessage("game.initial.suggestion"));
        scanner.nextLine();

        int attempts = 0;

        while (true) {
            int choice = getPlayerChoice(gameText.getSystemMessage("game.start"));

            if (isValidChoice(choice, 1, 2)) {
                if (choice == 1) {
                    firstAct();
                    return;
                } else {
                    System.out.println(gameText.getSystemMessage("game.close"));
                    return;
                }
            } else {
                if (attempts >= 2) {
                    System.out.println(gameText.getSystemMessage("game.close"));
                    return;
                } else {
                    handleInvalidChoice();
                    attempts++;
                }
            }
        }
    }

    private void firstAct() {
        Map<String, String> firstAct = gameText.getAllFirtsAct();
        displayActPiece(firstAct, "pieceOne");
        wakeUpInAlley();
        interactWithBeggar(firstAct);
        firstCombat();
    }

    private void wakeUpInAlley() {
        int diceResult = 0;
        int difficultyToGetUp = 8;

        List<String> dialogue = new ArrayList<>();

        dialogue.add(gameText.getSystemMessage("action.wakeUp.getUp"));
        dialogue.add(String.format(gameText.getSystemMessage("test.vigor"), vigorElodin));

        for (int roll = 1; roll <= vigorElodin; roll++) {
            diceResult = elodin.rollDice(1, 20);
            dialogue.add(String.format(gameText.getSystemMessage("roll.dice"), diceResult));

            if (diceResult >= difficultyToGetUp) {
                break;
            }
        }

        if (diceResult < difficultyToGetUp) {
            int damage = elodin.rollDice(1, 4);
            int newHealth = elodin.getClasse().getVida() - damage;
            elodin.getClasse().setVida(newHealth);

            dialogue.add(gameText.getSystemMessage("test.failure"));
            dialogue.add(gameText.getFirtsAct("action.wakeUp.getUp.failure"));
            dialogue.add(String.format(gameText.getSystemMessage("roll.losesLife"), damage));
            dialogue.add(gameText.getFirtsAct("action.wakeUp.getUp.failure.2"));
            dialogue.add(elodin.getFala("firstAct.lixo"));
        } else {
            dialogue.add(gameText.getFirtsAct("action.wakeUp.getUp.failure.2"));
        }

        dialogue.add(gameText.getFirtsAct("action.wakeUp.default"));
        dialogue.add(elodin.getFala("firstAct.pieceOne.claridade"));
        dialogue.add(gameText.getFirtsAct("action.wakeUp.default.2"));

        displayDialogue(dialogue);
        chooseTentInteraction();
    }

    private void chooseTentInteraction() {
        while (true) {
            int choice = getPlayerChoice(gameText.getFirtsAct("pieceTwo.init.choice.one"));

            if (isValidChoice(choice, 1, 2, 3)) {
                switch (choice) {
                    case 1:
                        interactWithScrapTent();
                        return;
                    case 2:
                        interactWithFoodTent();
                        return;
                    case 3:
                        interactWithLiquidTent();
                        return;
                }
            } else {
                handleInvalidChoice();
            }
        }
    }

    // ==================== INTERAÇÃO COM A BARACA DE SUCATA ====================

    private void interactWithScrapTent() {
        Humano dante = humanoFactoryController.createDante();

        List<String> initialDialogue = List.of(
                gameText.getFirtsAct("pieceTwo.scrap.init"),
                dante.getFala("init.one"),
                dante.getFala("init.two"),
                dante.getFala("init.three")
        );
        displayDialogue(initialDialogue);

        while (true) {
            int choice = getPlayerChoice(elodin.getFala("firstAct.pieceTwo.scrap.choice"));

            if (isValidChoice(choice, 1, 2)) {
                if (choice == 1) {
                    showScrapChoiceOne(dante);
                } else {
                    showScrapChoiceTwo(dante);
                }
                return;
            } else {
                handleInvalidChoice();
            }
        }
    }

    private void showScrapChoiceOne(Humano dante) {
        List<String> dialogue = List.of(
                dante.getFala("choice.one.one"),
                gameText.getFirtsAct("pieceTwo.scrap.one.one"),
                dante.getFala("choice.one.two"),
                gameText.getFirtsAct("pieceTwo.scrap.one.two"),
                dante.getFala("choice.one.three"),
                elodin.getFala("firstAct.pieceTwo.scrap.one.one"),
                gameText.getFirtsAct("pieceTwo.scrap.one.three"),
                elodin.getFala("firstAct.pieceTwo.scrap.one.two"),
                dante.getFala("choice.one.four"),
                dante.getFala("choice.one.five")
        );
        displayDialogue(dialogue);
    }

    private void showScrapChoiceTwo(Humano dante) {
        List<String> dialogue = List.of(
                dante.getFala("choice.two.one"),
                gameText.getFirtsAct("pieceTwo.scrap.two.one"),
                gameText.getFirtsAct("pieceTwo.scrap.two.two"),
                dante.getFala("choice.two.three"),
                dante.getFala("choice.two.four"),
                elodin.getFala("firstAct.pieceTwo.scrap.two.one"),
                dante.getFala("choice.two.five"),
                elodin.getFala("firstAct.pieceTwo.scrap.final.one"),
                dante.getFala("final.one"),
                dante.getFala("final.two"),
                dante.getFala("choice.two.two")
        );
        displayDialogue(dialogue);
    }

    // ==================== INTERAÇÃO COM A BARACA DE COMIDA ====================

    private void interactWithFoodTent() {
        Humano jonas = humanoFactoryController.createJonas();

        printText(gameText.getFirtsAct("pieceTwo.food.one.one"));
        printText(jonas.getFala("init.one"));

        while (true) {
            int choice = getPlayerChoice(elodin.getFala("firstAct.pieceTwo.food.choice"));

            if (isValidChoice(choice, 1, 2)) {
                if (choice == 1) {
                    showFoodChoiceOne(jonas);
                } else {
                    showFoodChoiceTwo(jonas);
                }
                return;
            } else {
                handleInvalidChoice();
            }
        }
    }

    private void showFoodChoiceOne(Humano jonas) {
        List<String> dialogue = List.of(
                gameText.getFirtsAct("pieceTwo.food.one.two"),
                jonas.getFala("choice.one.one"),
                jonas.getFala("choice.one.two"),
                jonas.getFala("choice.one.three"),
                jonas.getFala("choice.one.four"),
                elodin.getFala("firstAct.pieceTwo.food.one.one"),
                jonas.getFala("choice.one.five"),
                elodin.getFala("firstAct.pieceTwo.food.one.two"),
                jonas.getFala("choice.one.six"),
                jonas.getFala("choice.one.seven"),
                elodin.getFala("firstAct.pieceTwo.food.one.three"),
                gameText.getFirtsAct("pieceTwo.food.one.four"),
                jonas.getFala("choice.one.eight"),
                jonas.getFala("choice.one.nine"),
                gameText.getFirtsAct("pieceTwo.food.one.three")
        );
        displayDialogue(dialogue);
    }

    private void showFoodChoiceTwo(Humano jonas) {
        List<String> dialogue = List.of(
                gameText.getFirtsAct("pieceTwo.food.two.one"),
                jonas.getFala("choice.two.one"),
                jonas.getFala("choice.two.two"),
                jonas.getFala("choice.two.three"),
                jonas.getFala("choice.two.four"),
                elodin.getFala("firstAct.pieceTwo.food.two.one"),
                jonas.getFala("choice.two.five"),
                jonas.getFala("choice.two.six"),
                elodin.getFala("firstAct.pieceTwo.food.two.two"),
                jonas.getFala("final.one"),
                jonas.getFala("final.two")
        );
        displayDialogue(dialogue);
    }

    // ==================== INTERAÇÃO COM A BARACA DE LÍQUIDO ====================

    private void interactWithLiquidTent() {
        Humano simmom = humanoFactoryController.createSimmom();

        List<String> initialDialogue = List.of(
                gameText.getFirtsAct("pieceTwo.liquid.one.one"),
                simmom.getFala("init.one"),
                simmom.getFala("init.two"),
                simmom.getFala("init.three")
        );
        displayDialogue(initialDialogue);

        while (true) {
            int choice = getPlayerChoice(elodin.getFala("firstAct.pieceTwo.liquid.choice"));

            if (isValidChoice(choice, 1, 2)) {
                if (choice == 1) {
                    showLiquidChoiceOne(simmom);
                } else {
                    showLiquidChoiceTwo(simmom);
                }
                return;
            } else {
                handleInvalidChoice();
            }
        }
    }

    private void showLiquidChoiceOne(Humano simmom) {
        List<String> dialogue = List.of(
                simmom.getFala("choice.one.one"),
                gameText.getFirtsAct("pieceTwo.liquid.one.two"),
                simmom.getFala("choice.one.two"),
                simmom.getFala("choice.one.three"),
                elodin.getFala("firstAct.pieceTwo.liquid.one.one"),
                simmom.getFala("choice.one.four"),
                simmom.getFala("choice.one.five"),
                gameText.getFirtsAct("pieceTwo.liquid.one.one"),
                gameText.getFirtsAct("pieceTwo.liquid.one.two")
        );
        displayDialogue(dialogue);
    }

    private void showLiquidChoiceTwo(Humano simmom) {
        List<String> dialogue = List.of(
                gameText.getFirtsAct("pieceTwo.liquid.two.one"),
                simmom.getFala("choice.two.one"),
                elodin.getFala("firstAct.pieceTwo.liquid.two.one"),
                gameText.getFirtsAct("pieceTwo.liquid.two.two"),
                simmom.getFala("choice.two.two"),
                elodin.getFala("firstAct.pieceTwo.liquid.two.two"),
                simmom.getFala("choice.two.three")
        );
        displayDialogue(dialogue);
    }

    // ==================== INTERAÇÃO COM O MENDIGO ====================

    private void interactWithBeggar(Map<String, String> firstAct) {
        Humano beggar = humanoFactoryController.createBeggar();

        printText(gameText.getFirtsAct("prePieceThree.beggar.one"));
        printText(gameText.getFirtsAct("prePieceThree.beggar.two"));

        beggar.getAllFalas().values().forEach(this::printText);

        displayActPiece(firstAct, "pieceThree");
    }

    // ==================== SISTEMA DE COMBATE ====================

    private void firstCombat() {
        try {
            initializeAbilityCooldown();
            currentTurn = 0;

            MonstroController monstroController = new MonstroController();
            Monstro drone = monstroController.createDrone();

            if (drone == null || drone.getClasse() == null) {
                printText(gameText.getSystemMessage("error.invalidMonster"));
                return;
            }

            int elodinAgilidade = getElodinAgilidade();
            int droneAgilidade = getMonstroAgilidade(drone);

            printText(String.format(gameText.getSystemMessage("test.iniciativa"), elodinAgilidade));

            boolean elodinWinsInitiative = resolveInitiative(elodinAgilidade, droneAgilidade);

            if (elodinWinsInitiative) {
                printText(gameText.getFirtsAct("combat.drone.eletricPulse.failure"));
                startCombat(drone);
            } else {
                applyDroneSpecialAttack(drone);
                startCombat(drone);
            }
        } catch (Exception e) {
            printText(gameText.getSystemMessage("error.combatInit"));
            e.printStackTrace();
        }
    }

    private int getElodinAgilidade() {
        try {
            return elodin.getClasse().getAtributo(NomeAtributo.AGILIDADE);
        } catch (NullPointerException e) {
            printText(gameText.getSystemMessage("error.missingAttribute"));
            return 0;
        }
    }

    private int getMonstroAgilidade(Monstro monstro) {
        try {
            return monstro.getClasse().getAtributo(NomeAtributo.AGILIDADE);
        } catch (NullPointerException e) {
            printText(gameText.getSystemMessage("error.missingMonsterAttribute"));
            return 0;
        }
    }

    private boolean resolveInitiative(int playerAgility, int monsterAgility) {
        int playerRoll;
        int monsterRoll;
        int maxAttempts = 10;
        int attempts = 0;

        do {
            if (attempts >= maxAttempts) {
                printText(gameText.getSystemMessage("error.initiativeLimit"));
                return true;
            }

            playerRoll = rollDice(1, 20);
            monsterRoll = rollDice(1, 20);

            printText(String.format(gameText.getSystemMessage("roll.dice"), playerRoll));
            printText(String.format(gameText.getSystemMessage("roll.dice.opponent"), monsterRoll));

            if (playerRoll == monsterRoll) {
                printText(gameText.getSystemMessage("test.again"));
            }

            attempts++;
        } while (playerRoll == monsterRoll);

        return playerRoll > monsterRoll;
    }

    private int rollDice(int quantity, int sides) {
        if (quantity <= 0 || sides <= 0) {
            printText(gameText.getSystemMessage("error.invalidDice"));
            return 0;
        }

        int total = 0;
        for (int i = 0; i < quantity; i++) {
            total += (int) (Math.random() * sides) + 1;
        }
        return total;
    }

    private void applyDroneSpecialAttack(Monstro drone) {
        try {
            if (drone == null || drone.getClasse() == null) {
                printText(gameText.getSystemMessage("error.invalidMonster"));
                return;
            }

            Habilidade electricAbility = drone.getClasse().getHabilidade(3L);

            if (electricAbility == null) {
                printText(gameText.getSystemMessage("error.missingAbility"));
                return;
            }

            int diceQuantity = electricAbility.getQuantidadeDado();
            int diceValue = electricAbility.getValorDado();
            int extraValue = electricAbility.getValorExtra();

            printText(gameText.getFirtsAct("combat.drone.eletricPulse"));

            int damageReceived = rollDice(diceQuantity, diceValue) + extraValue;
            int newHealth = elodin.getClasse().getVida() - damageReceived;
            elodin.getClasse().setVida(Math.max(0, newHealth));

            printText(String.format(gameText.getSystemMessage("roll.losesLife"), damageReceived));

        } catch (Exception e) {
            printText(gameText.getSystemMessage("error.specialAttack"));
            e.printStackTrace();
        }
    }

    private void startCombat(Monstro drone) {
        try {
            printText(gameText.getFirtsAct("combat.drone.eletricPulse.default"));

            if (drone == null || drone.getClasse() == null) {
                printText(gameText.getSystemMessage("error.invalidMonster"));
                return;
            }

            printText(gameText.getSystemMessage("turn.your"));

            int droneDefense = drone.getClasse().getDefesa();
            int droneHealth = drone.getClasse().getVida();
            int playerHealth = elodin.getClasse().getVida();
            int playerDefense = elodin.getClasse().getDefesa();

            while (playerHealth > 0 && droneHealth > 0) {
                currentTurn++;
                printText(String.format(gameText.getSystemMessage("turn.counter"), currentTurn));

                int choice = getPlayerChoice(gameText.getSystemMessage("temporary.abilities"));

                if (choice == 5) {
                    showTemporaryAbilities();
                    continue;
                }

                if (!isValidChoice(choice, 1, 2, 3, 4)) {
                    printText(gameText.getSystemMessage("error.invalidOption"));
                    continue;
                }

                // Verifica se a habilidade está disponível (cooldown)
                if (!isAbilityAvailable(choice)) {
                    Habilidade ability = getAbilityById(choice);
                    if (ability != null) {
                        printText(getCooldownMessage(choice, ability));
                    }
                    continue;
                }

                executePlayerTurn(choice, drone, droneDefense);

                // Aplica cooldown de 2 turnos após usar a habilidade
                setAbilityCooldown(choice, 2);

                droneHealth = drone.getClasse().getVida();
                playerHealth = elodin.getClasse().getVida();

                if (droneHealth > 0 && playerHealth > 0) {
                    executeDroneTurn(drone, playerDefense);
                    playerHealth = elodin.getClasse().getVida();
                }
            }

        } catch (Exception e) {
            printText(gameText.getSystemMessage("error.combat"));
            e.printStackTrace();
        }
    }

    private Habilidade getAbilityById(int abilityId) {
        long[] abilityIds = {3, 4, 5, 6};
        if (abilityId >= 1 && abilityId <= abilityIds.length) {
            return elodin.getClasse().getHabilidade(abilityIds[abilityId - 1]);
        }
        return null;
    }

    private void executePlayerTurn(int abilityChoice, Monstro drone, int droneDefense) {
        try {
            int attackRoll = rollDice(1, 20) + forcaElodin;
            int baseDamage = rollDice(2, 10) + 3;

            List<String> combatDialogue = new ArrayList<>();
            combatDialogue.add(String.format(gameText.getSystemMessage("roll.dice.player"), attackRoll));
            combatDialogue.add(String.format(gameText.getSystemMessage("defense.opponent"), droneDefense));

            boolean isCritical = (attackRoll - forcaElodin) == 20;
            if (isCritical) {
                baseDamage = baseDamage * 2;
                combatDialogue.add(gameText.getSystemMessage("combat.player.critical"));
            }

            boolean attackHit = attackRoll >= droneDefense;

            if (attackHit) {
                int finalDamage = baseDamage;
                int newDroneHealth = drone.getClasse().getVida() - finalDamage;
                drone.getClasse().setVida(Math.max(0, newDroneHealth));
                combatDialogue.add(getSuccessMessage(abilityChoice));
                combatDialogue.add(String.format(gameText.getFirtsAct("roll.losesLife.drone"), finalDamage));
            } else {
                combatDialogue.add(gameText.getSystemMessage("test.failure"));
                combatDialogue.add(getFailureMessage(abilityChoice));
            }

            displayDialogue(combatDialogue);

        } catch (Exception e) {
            printText(gameText.getSystemMessage("error.playerTurn"));
            e.printStackTrace();
        }
    }

    private String getSuccessMessage(int abilityChoice) {
        switch (abilityChoice) {
            case 1: return gameText.getFirtsAct("combat.drone.ruptura.success");
            case 2: return gameText.getFirtsAct("combat.drone.habilidade2.success");
            case 3: return gameText.getFirtsAct("combat.drone.habilidade3.success");
            case 4: return gameText.getFirtsAct("combat.drone.habilidade4.success");
            default: return gameText.getSystemMessage("error.unknownAbility");
        }
    }

    private String getFailureMessage(int abilityChoice) {
        switch (abilityChoice) {
            case 1: return gameText.getFirtsAct("combat.drone.ruptura.failure");
            case 2: return gameText.getFirtsAct("combat.drone.habilidade2.failure");
            case 3: return gameText.getFirtsAct("combat.drone.habilidade3.failure");
            case 4: return gameText.getFirtsAct("combat.drone.habilidade4.failure");
            default: return gameText.getSystemMessage("error.unknownAbility");
        }
    }

    private void executeDroneTurn(Monstro drone, int playerDefense) {
        try {
            if (drone == null || drone.getClasse() == null) {
                printText(gameText.getSystemMessage("error.invalidMonster"));
                return;
            }

            printText(gameText.getSystemMessage("turn.enemy"));

            int droneStrength = drone.getClasse().getAtributo(NomeAtributo.FORCA);
            int attackRoll = rollDice(1, 20) + droneStrength;

            printText(String.format(gameText.getSystemMessage("roll.dice.enemy"), attackRoll));
            printText(String.format(gameText.getSystemMessage("defense.player"), playerDefense));

            boolean attackHit = attackRoll >= playerDefense;

            if (attackHit) {
                int damage = rollDice(2, 8) + droneStrength;
                boolean isCritical = (attackRoll - droneStrength) == 20;

                if (isCritical) {
                    damage = damage * 2;
                    printText(gameText.getSystemMessage("combat.enemy.critical"));
                }

                int newHealth = elodin.getClasse().getVida() - damage;
                elodin.getClasse().setVida(Math.max(0, newHealth));
                printText(String.format(gameText.getSystemMessage("combat.player.damage.taken"), damage));

                if (elodin.getClasse().getVida() <= 0) {
                    printText(gameText.getSystemMessage("combat.player.death"));
                }
            } else {
                printText(gameText.getSystemMessage("combat.enemy.miss"));
            }

            printText("---------------------------");

        } catch (Exception e) {
            printText(gameText.getSystemMessage("error.monsterTurn"));
            e.printStackTrace();
        }
    }

    private void showTemporaryAbilities() {
        List<String> abilities = new ArrayList<>();
        long[] abilityIds = {3, 4, 5, 6};
        int[] abilityNumbers = {1, 2, 3, 4};

        for (int i = 0; i < abilityIds.length; i++) {
            Habilidade ability = elodin.getClasse().getHabilidade(abilityIds[i]);
            if (ability != null) {
                String status = isAbilityAvailable(abilityNumbers[i]) ? "✅" : "⏳";
                abilities.add(status + " " + ability.getNome() + ": \n" + ability.getDescricao() + "\n");
            }
        }

        abilities.add(gameText.getSystemMessage("util.enter"));
        displayDialogue(abilities);
    }

    private void droneRandomAttack() {
    }

    private void temporaryAbilities() {
        showTemporaryAbilities();
    }
}