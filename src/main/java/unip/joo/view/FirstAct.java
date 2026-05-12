package unip.joo.view;

import unip.joo.controller.drone.MonstroController;
import unip.joo.controller.humanoFactory.HumanoFactoryController;
import unip.joo.model.ENUM.NomeAtributo;
import unip.joo.model.entities.Habilidade;
import unip.joo.model.entities.Humano;
import unip.joo.model.entities.Item;
import unip.joo.model.entities.Monstro;
import unip.joo.resources.AsciiArt;
import unip.joo.resources.FirstActText;
import unip.joo.resources.SystemText;
import unip.joo.util.Util.*;

import java.util.*;

import static unip.joo.util.Util.*;

public class FirstAct { // Classe de visão
    private final SystemText systemText = new SystemText(); // Atributo Final
    private final FirstActText firstActText = new FirstActText(); // Atributo Final
    private final AsciiArt asciiArt = new AsciiArt(); // Atributo Final
    private final Scanner scanner = new Scanner(System.in); // Atributo Final

    private Humano elodin; // Encapsulamento
    private final HumanoFactoryController humanoFactoryController = new HumanoFactoryController();
    private int vigorElodin;
    private int forcaElodin;

    Humano dante = humanoFactoryController.createDante();
    Humano jonas = humanoFactoryController.createJonas();
    Humano simmom = humanoFactoryController.createSimmom();

    // Mapa para controlar o tempo de espera das habilidades (turno em que ficarão disponíveis)
    private final Map<Integer, Integer> abilityCooldown = new HashMap<>();
    private int currentTurn = 0;

    public void init(Humano elodin) {
        this.elodin = elodin;
        this.vigorElodin = elodin.getClasse().getAtributo(NomeAtributo.VIGOR);
        this.forcaElodin = elodin.getClasse().getAtributo(NomeAtributo.FORCA);
        
        gameStart();
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
        return String.format("%s está em recarga! Ainda faltam %d turno(s) para poder usá-la novamente.",
                ability.getNome(), turnsRemaining);
    }

    // ==================== PRIMEIRO ATO ====================

    private void gameStart() {
        System.out.println(systemText.getSystemMessage("game.initial.suggestion"));
        scanner.nextLine();

        int attempts = 0;

        while (true) {
            int choice = getPlayerChoice(scanner, systemText.getSystemMessage("game.start"));

            if (isValidChoice(choice, 1, 2)) {
                if (choice == 1) {
                    firstAct();
                    return;
                } else {
                    System.out.println(systemText.getSystemMessage("game.close"));
                    return;
                }
            } else {
                if (attempts >= 2) {
                    System.out.println(systemText.getSystemMessage("game.close"));
                    return;
                } else {
                    handleInvalidChoice();
                    attempts++;
                }
            }
        }
    }

    private void firstAct() {
        Map<String, String> firstAct = firstActText.getAllFirtsAct();
        displayActPiece(scanner, firstAct, "pieceOne");
        wakeUpInAlley();
        interactWithBeggar(firstAct);
        firstCombat();
    }

    private void wakeUpInAlley() {
        int diceResult = 0;
        int difficultyToGetUp = 8;

        List<String> dialogue = new ArrayList<>();

        dialogue.add(systemText.getSystemMessage("action.wakeUp.getUp"));
        dialogue.add(String.format(systemText.getSystemMessage("test.vigor"), vigorElodin));

        for (int roll = 1; roll <= vigorElodin; roll++) {
            diceResult = rollDice(1, 20);
            dialogue.add(String.format(systemText.getSystemMessage("roll.dice"), diceResult));

            if (diceResult >= difficultyToGetUp) {
                break;
            }
        }

        if (diceResult < difficultyToGetUp) {
            int damage = rollDice(1, 4);
            int newHealth = elodin.getClasse().getVida() - damage;
            elodin.getClasse().setVida(newHealth);

            dialogue.add(systemText.getSystemMessage("test.failure"));
            dialogue.add(firstActText.getFirtsAct("action.wakeUp.getUp.failure"));
            dialogue.add(String.format(systemText.getSystemMessage("roll.losesLife"), damage));
            dialogue.add(firstActText.getFirtsAct("action.wakeUp.getUp.failure.2"));
            dialogue.add(elodin.getFala("firstAct.lixo"));
        } else {
            dialogue.add(firstActText.getFirtsAct("action.wakeUp.getUp.failure.2"));
        }

        dialogue.add(firstActText.getFirtsAct("action.wakeUp.default"));
        dialogue.add(elodin.getFala("firstAct.pieceOne.claridade"));
        dialogue.add(firstActText.getFirtsAct("action.wakeUp.default.2"));

        displayDialogue(scanner, dialogue);
        chooseTentInteraction();
    }

    private void chooseTentInteraction() {
        while (true) {
            int choice = getPlayerChoice(scanner, firstActText.getFirtsAct("pieceTwo.init.choice.one"));

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
        List<String> initialDialogue = List.of(
                firstActText.getFirtsAct("pieceTwo.scrap.init"),
                dante.getFala("init.one"),
                dante.getFala("init.two"),
                dante.getFala("init.three")
        );
        displayDialogue(scanner, initialDialogue);

        while (true) {
            int choice = getPlayerChoice(scanner, elodin.getFala("firstAct.pieceTwo.scrap.choice"));

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
                firstActText.getFirtsAct("pieceTwo.scrap.one.one"),
                dante.getFala("choice.one.two"),
                firstActText.getFirtsAct("pieceTwo.scrap.one.two"),
                dante.getFala("choice.one.three"),
                elodin.getFala("firstAct.pieceTwo.scrap.one.one"),
                firstActText.getFirtsAct("pieceTwo.scrap.one.three"),
                elodin.getFala("firstAct.pieceTwo.scrap.one.two"),
                dante.getFala("choice.one.four"),
                dante.getFala("choice.one.five")
        );
        displayDialogue(scanner, dialogue);
    }

    private void showScrapChoiceTwo(Humano dante) {
        List<String> dialogue = List.of(
                dante.getFala("choice.two.one"),
                firstActText.getFirtsAct("pieceTwo.scrap.two.one"),
                firstActText.getFirtsAct("pieceTwo.scrap.two.two"),
                dante.getFala("choice.two.three"),
                dante.getFala("choice.two.four"),
                elodin.getFala("firstAct.pieceTwo.scrap.two.one"),
                dante.getFala("choice.two.five"),
                elodin.getFala("firstAct.pieceTwo.scrap.final.one"),
                dante.getFala("final.one"),
                dante.getFala("final.two"),
                dante.getFala("choice.two.two")
        );
        displayDialogue(scanner, dialogue);
    }

    // ==================== INTERAÇÃO COM A BARACA DE COMIDA ====================

    private void interactWithFoodTent() {

        printText(scanner,firstActText.getFirtsAct("pieceTwo.food.one.one"));
        printText(scanner,jonas.getFala("init.one"));

        while (true) {
            int choice = getPlayerChoice(scanner, elodin.getFala("firstAct.pieceTwo.food.choice"));

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
                firstActText.getFirtsAct("pieceTwo.food.one.two"),
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
                firstActText.getFirtsAct("pieceTwo.food.one.four"),
                jonas.getFala("choice.one.eight"),
                jonas.getFala("choice.one.nine"),
                firstActText.getFirtsAct("pieceTwo.food.one.three")
        );
        displayDialogue(scanner, dialogue);
    }

    private void showFoodChoiceTwo(Humano jonas) {
        List<String> dialogue = List.of(
                firstActText.getFirtsAct("pieceTwo.food.two.one"),
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
        displayDialogue(scanner, dialogue);
    }

    // ==================== INTERAÇÃO COM A BARACA DE LÍQUIDO ====================

    private void interactWithLiquidTent() {
        List<String> initialDialogue = List.of(
                firstActText.getFirtsAct("pieceTwo.liquid.one.one"),
                simmom.getFala("init.one"),
                simmom.getFala("init.two"),
                simmom.getFala("init.three")
        );
        displayDialogue(scanner, initialDialogue);

        while (true) {
            int choice = getPlayerChoice(scanner, elodin.getFala("firstAct.pieceTwo.liquid.choice"));

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
                firstActText.getFirtsAct("pieceTwo.liquid.one.two"),
                simmom.getFala("choice.one.two"),
                simmom.getFala("choice.one.three"),
                elodin.getFala("firstAct.pieceTwo.liquid.one.one"),
                simmom.getFala("choice.one.four"),
                simmom.getFala("choice.one.five"),
                firstActText.getFirtsAct("pieceTwo.liquid.one.one"),
                firstActText.getFirtsAct("pieceTwo.liquid.one.two")
        );
        displayDialogue(scanner, dialogue);
    }

    private void showLiquidChoiceTwo(Humano simmom) {
        List<String> dialogue = List.of(
                firstActText.getFirtsAct("pieceTwo.liquid.two.one"),
                simmom.getFala("choice.two.one"),
                elodin.getFala("firstAct.pieceTwo.liquid.two.one"),
                firstActText.getFirtsAct("pieceTwo.liquid.two.two"),
                simmom.getFala("choice.two.two"),
                elodin.getFala("firstAct.pieceTwo.liquid.two.two"),
                simmom.getFala("choice.two.three")
        );
        displayDialogue(scanner, dialogue);
    }

    // ==================== INTERAÇÃO COM O MENDIGO ====================

    private void interactWithBeggar(Map<String, String> firstAct) {
        Humano beggar = humanoFactoryController.createBeggar();

        printText(scanner,firstActText.getFirtsAct("prePieceThree.beggar.one"));
        printText(scanner,firstActText.getFirtsAct("prePieceThree.beggar.two"));

        beggar.getAllFalas().values().forEach(text -> printText(scanner, text));

        displayActPiece(scanner, firstAct, "pieceThree");
    }

    // ==================== SISTEMA DE COMBATE ====================

    private void firstCombat() {
        try {
            initializeAbilityCooldown();
            currentTurn = 0;

            MonstroController monstroController = new MonstroController();
            Monstro drone = monstroController.createDrone();

            if (drone == null || drone.getClasse() == null) {
                printText(scanner, systemText.getSystemMessage("error.invalidMonster"));
                return;
            }

            int elodinAgilidade = getElodinAgilidade();
            int droneAgilidade = getMonstroAgilidade(drone);

            printText(scanner,String.format(systemText.getSystemMessage("test.iniciativa"), elodinAgilidade));

            boolean elodinWinsInitiative = resolveInitiative(elodinAgilidade, droneAgilidade);

            if (elodinWinsInitiative) {
                printText(scanner,firstActText.getFirtsAct("combat.drone.eletricPulse.failure"));
                startCombat(drone);
            } else {
                applyDroneSpecialAttack(drone);
                startCombat(drone);
            }
        } catch (Exception e) {
            printText(scanner,systemText.getSystemMessage("error.combatInit"));
            e.printStackTrace();
        }
    }

    private int getElodinAgilidade() {
        try {
            return elodin.getClasse().getAtributo(NomeAtributo.AGILIDADE);
        } catch (NullPointerException e) {
            printText(scanner,systemText.getSystemMessage("error.missingAttribute"));
            return 0;
        }
    }

    private int getMonstroAgilidade(Monstro monstro) {
        try {
            return monstro.getClasse().getAtributo(NomeAtributo.AGILIDADE);
        } catch (NullPointerException e) {
            printText(scanner,systemText.getSystemMessage("error.missingMonsterAttribute"));
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
                printText(scanner,systemText.getSystemMessage("error.initiativeLimit"));
                return true;
            }

            playerRoll = rollDice(1, 20);
            monsterRoll = rollDice(1, 20);

            printText(scanner,String.format(systemText.getSystemMessage("roll.dice"), playerRoll));
            printText(scanner,String.format(systemText.getSystemMessage("roll.dice.opponent"), monsterRoll));

            if (playerRoll == monsterRoll) {
                printText(scanner,systemText.getSystemMessage("test.again"));
            }

            attempts++;
        } while (playerRoll == monsterRoll);

        return playerRoll > monsterRoll;
    }



    private void applyDroneSpecialAttack(Monstro drone) {
        try {
            if (drone == null || drone.getClasse() == null) {
                printText(scanner,systemText.getSystemMessage("error.invalidMonster"));
                return;
            }

            Habilidade electricAbility = drone.getClasse().getHabilidade(3L);

            if (electricAbility == null) {
                printText(scanner,systemText.getSystemMessage("error.missingAbility"));
                return;
            }

            int diceQuantity = electricAbility.getQuantidadeDado();
            int diceValue = electricAbility.getValorDado();
            int extraValue = electricAbility.getValorExtra();

            printText(scanner,firstActText.getFirtsAct("combat.drone.eletricPulse"));

            int damageReceived = 0;
            if (diceQuantity > 0 && diceValue > 0) {
                damageReceived = rollDice(diceQuantity, diceValue) + extraValue;
            } else if (extraValue > 0) {
                damageReceived = extraValue;
            }

            if (damageReceived > 0) {
                int newHealth = elodin.getClasse().getVida() - damageReceived;
                elodin.getClasse().setVida(Math.max(0, newHealth));
                printText(scanner,String.format(systemText.getSystemMessage("roll.losesLife"), damageReceived));
            }

        } catch (Exception e) {
            printText(scanner,systemText.getSystemMessage("error.specialAttack"));
            e.printStackTrace();
        }
    }

    private void startCombat(Monstro drone) {
        try {
            printText(scanner,firstActText.getFirtsAct("combat.drone.eletricPulse.default"));

            if (drone == null || drone.getClasse() == null) {
                printText(scanner,systemText.getSystemMessage("error.invalidMonster"));
                return;
            }

            printText(scanner,systemText.getSystemMessage("turn.your"));

            int droneDefense = drone.getClasse().getDefesa();
            int droneHealth = drone.getClasse().getVida();
            int playerHealth = elodin.getClasse().getVida();
            int playerDefense = elodin.getClasse().getDefesa();

            while (playerHealth > 0 && droneHealth > 0) {
                printText(scanner,String.format(systemText.getSystemMessage("turn.counter"), currentTurn));

                int choice = getPlayerChoice(scanner, systemText.getSystemMessage("temporary.abilities"));

                if (choice == 5) {
                    showTemporaryAbilities();
                    continue;
                }

                if (!isValidChoice(choice, 1, 2, 3, 4)) {
                    printText(scanner,systemText.getSystemMessage("error.invalidOption"));
                    continue;
                }

                // Verifica se a habilidade está disponível (cooldown)
                if (!isAbilityAvailable(choice)) {
                    Habilidade ability = getAbilityById(choice);
                    if (ability != null) {
                        printText(scanner,getCooldownMessage(choice, ability));
                    }
                    continue;
                }

                executePlayerTurn(choice, drone, droneDefense);
                currentTurn++;
                // Aplica cooldown de 2 turnos após usar a habilidade
                setAbilityCooldown(choice, 2);

                droneHealth = drone.getClasse().getVida();
                playerHealth = elodin.getClasse().getVida();

                if (droneHealth > 0 && playerHealth > 0) {
                    executeDroneTurn(drone, playerDefense);
                    playerHealth = elodin.getClasse().getVida();
                }
            }
            
            // Desfecho do combate
            if (droneHealth <= 0) {
                Item kit= dante.getInventario().getItemById(1L);
                Item jaqueta= dante.getInventario().getItemById(2L);
                Item barra= dante.getInventario().getItemById(3L);
                Item pistola= dante.getInventario().getItemById(4L);

                dante.transferItemTo(kit, elodin);
                dante.transferItemTo(jaqueta, elodin);
                dante.transferItemTo(barra, elodin);
                dante.transferItemTo(pistola, elodin);

                List<String> victoryDialogue = new ArrayList<>();
                victoryDialogue.add(firstActText.getFirtsAct("combat.victory.drone.death.one"));
                victoryDialogue.add(firstActText.getFirtsAct("combat.victory.drone.death.two"));
                victoryDialogue.add(firstActText.getFirtsAct("combat.victory.drone.death.three"));
                victoryDialogue.add(firstActText.getFirtsAct("combat.victory.drone.death.four"));
                victoryDialogue.add(firstActText.getFirtsAct("outcome.one"));
                victoryDialogue.add(firstActText.getFirtsAct("outcome.two"));
                victoryDialogue.add(firstActText.getFirtsAct("outcome.three"));
                victoryDialogue.add(firstActText.getFirtsAct("outcome.four"));
                
                // Mensagens de itens recebidos
                victoryDialogue.add(String.format(systemText.getSystemMessage("item.received"), kit.getNome()));
                victoryDialogue.add(String.format(systemText.getSystemMessage("item.received"), jaqueta.getNome()));
                victoryDialogue.add(String.format(systemText.getSystemMessage("item.received"), barra.getNome()));
                victoryDialogue.add(String.format(systemText.getSystemMessage("item.received"), pistola.getNome()));
                
                victoryDialogue.add(firstActText.getFirtsAct("outcome.five"));
                victoryDialogue.add(asciiArt.getAsciiArts("game.name"));
                
                displayDialogue(scanner, victoryDialogue);

            } else if (playerHealth <= 0) {
                List<String> defeatDialogue = List.of(
                        firstActText.getFirtsAct("combat.defeat.player.death.one"),
                        firstActText.getFirtsAct("combat.defeat.player.death.two"),
                        firstActText.getFirtsAct("combat.defeat.player.death.three"),
                        firstActText.getFirtsAct("combat.defeat.player.death.four"),
                        firstActText.getFirtsAct("combat.defeat.player.death.five")
                );
                verifyDeath(scanner, playerHealth, defeatDialogue);
            }
        } catch (Exception e) {
            printText(scanner,systemText.getSystemMessage("error.combat"));
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
            int diceRoll = rollDice(1, 20);
            int attackRoll = diceRoll + forcaElodin;
            int baseDamage = rollDice(2, 10) + 3;

            List<String> combatDialogue = new ArrayList<>();
            combatDialogue.add(String.format(systemText.getSystemMessage("combat.roll.attack"), attackRoll, droneDefense));

            boolean isCritical = diceRoll == 20;
            boolean isCriticalError = diceRoll == 1;

            if (isCritical) {
                combatDialogue.add(systemText.getSystemMessage("combat.critical"));
            } else if (isCriticalError) {
                combatDialogue.add(systemText.getSystemMessage("combat.criticalError"));
            }

            boolean attackHit = attackRoll >= droneDefense;

            if (attackHit && !isCriticalError) {
                int finalDamage = baseDamage;
                if (isCritical) {
                finalDamage = baseDamage * 2;
                }
        
                int newDroneHealth = drone.getClasse().getVida() - finalDamage;
                drone.getClasse().setVida(Math.max(0, newDroneHealth));
                combatDialogue.add(getSuccessMessage(abilityChoice));
                combatDialogue.add(String.format(systemText.getSystemMessage("roll.losesLife.drone"), finalDamage));
            } else if (isCriticalError) {
                // Erro crítico: jogador se machuca com o próprio ataque
                int selfDamage = baseDamage;
                int newPlayerHealth = elodin.getClasse().getVida() - selfDamage;
                elodin.getClasse().setVida(Math.max(0, newPlayerHealth));
                combatDialogue.add(getCriticalErrorMessage(abilityChoice));
                combatDialogue.add(String.format(systemText.getSystemMessage("combat.player.self.damage"), selfDamage));
            } else {
                combatDialogue.add(systemText.getSystemMessage("test.failure"));
                combatDialogue.add(getFailureMessage(abilityChoice));
            }

            displayDialogue(scanner, combatDialogue);

        } catch (Exception e) {
            printText(scanner,systemText.getSystemMessage("error.playerTurn"));
            e.printStackTrace();
        }
    }

    private String getSuccessMessage(int abilityChoice) {
        String message;
        switch (abilityChoice) {
            case 1: message = firstActText.getFirtsAct("combat.drone.ruptura.success"); break;
            case 2: message = firstActText.getFirtsAct("combat.drone.Violencia.success"); break;
            case 3: message = firstActText.getFirtsAct("combat.drone.Impacto.success"); break;
            case 4: message = firstActText.getFirtsAct("combat.drone.Esmaga.success"); break;
            default: message = systemText.getSystemMessage("error.unknownAbility"); break;
        }
        return message != null ? message : systemText.getSystemMessage("combat.critical");
    }

    private String getFailureMessage(int abilityChoice) {
        String message;
        switch (abilityChoice) {
            case 1: message = firstActText.getFirtsAct("combat.drone.ruptura.failure"); break;
            case 2: message = firstActText.getFirtsAct("combat.drone.Violencia.failure"); break;
            case 3: message = firstActText.getFirtsAct("combat.drone.Impacto.failure"); break;
            case 4: message = firstActText.getFirtsAct("combat.drone.Esmaga.failure"); break;
            default: message = systemText.getSystemMessage("error.unknownAbility"); break;
        }
        return message != null ? message : systemText.getSystemMessage("test.failure");
    }

    private String getCriticalErrorMessage(int abilityChoice) {
        String message;
        switch (abilityChoice) {
            case 1: message = firstActText.getFirtsAct("combat.player.ruptura.criticalError"); break;
            case 2: message = firstActText.getFirtsAct("combat.player.Violencia.criticalError"); break;
            case 3: message = firstActText.getFirtsAct("combat.player.Impacto.criticalError"); break;
            case 4: message = firstActText.getFirtsAct("combat.player.Esmaga.criticalError"); break;
            default: message = systemText.getSystemMessage("combat.criticalError.default"); break;
        }
        return message != null ? message : systemText.getSystemMessage("combat.criticalError.default");
    }

    private void executeDroneTurn(Monstro drone, int playerDefense) {
        try {
            if (drone == null || drone.getClasse() == null) {
                printText(scanner,systemText.getSystemMessage("error.invalidMonster"));
                return;
            }

            printText(scanner,systemText.getSystemMessage("turn.enemy"));

            // Drone escolhe aleatoriamente um dos 3 ataques
            int attackChoice = rollDice(1, 3);
            int droneIntelecto = drone.getClasse().getAtributo(NomeAtributo.INTELECTO);
            int droneForca = drone.getClasse().getAtributo(NomeAtributo.FORCA);

            List<String> combatDialogue = new ArrayList<>();

            switch (attackChoice) {
                case 1: // Ataque Elétrico
                    executeDroneElectricAttack(drone, playerDefense, droneIntelecto, combatDialogue);
                    break;
                case 2: // Investida Mecânica
                    executeDroneMechanicalCharge(drone, playerDefense, droneForca, combatDialogue);
                    break;
                case 3: // Pulso Eletromagnético
                    executeDroneElectromagneticPulse(drone, playerDefense, droneIntelecto, combatDialogue);
                    break;
            }

            displayDialogue(scanner, combatDialogue);
            printText(scanner,systemText.getSystemMessage("combat.separator"));

        } catch (Exception e) {
            printText(scanner,systemText.getSystemMessage("error.monsterTurn"));
            e.printStackTrace();
        }
    }

    private void executeDroneElectricAttack(Monstro drone, int playerDefense, int droneIntelecto, List<String> dialogue) {
        int diceRoll = rollDice(1, 20);
        int droneAttackRoll = diceRoll + droneIntelecto;

        dialogue.add(systemText.getSystemMessage("combat.enemy.ataqueeletrico.name"));
        dialogue.add(String.format(systemText.getSystemMessage("combat.enemy.roll.attack"), droneAttackRoll, playerDefense));

        boolean isCritical = diceRoll == 20;
        boolean isCriticalError = diceRoll == 1;

        if (isCritical) {
            dialogue.add(systemText.getSystemMessage("combat.critical"));
        } else if (isCriticalError) {
            dialogue.add(systemText.getSystemMessage("combat.criticalError"));
        }

        if (droneAttackRoll >= playerDefense && !isCriticalError) {
            int damage = rollDice(1, 10) + 2;
            if (isCritical) {
                damage = damage * 2;
            }
            int newHealth = elodin.getClasse().getVida() - damage;
            elodin.getClasse().setVida(Math.max(0, newHealth));
            dialogue.add(firstActText.getFirtsAct("combat.enemy.ataqueeletrico.success"));
            dialogue.add(String.format(systemText.getSystemMessage("combat.player.damage.taken"), damage));
        } else if (isCriticalError) {
            // Erro crítico: drone se danifica com o próprio ataque
            int selfDamage = rollDice(1, 10) + 2;
            int newDroneHealth = drone.getClasse().getVida() - selfDamage;
            drone.getClasse().setVida(Math.max(0, newDroneHealth));
            dialogue.add(firstActText.getFirtsAct("combat.enemy.ataqueeletrico.criticalError"));
            dialogue.add(String.format(systemText.getSystemMessage("combat.enemy.self.damage"), selfDamage));
        } else {
            dialogue.add(firstActText.getFirtsAct("combat.enemy.ataqueeletrico.failure"));
        }
    }

    private void executeDroneMechanicalCharge(Monstro drone, int playerDefense, int droneForca, List<String> dialogue) {
        int diceRoll = rollDice(1, 20);
        int droneAttackRoll = diceRoll + droneForca;

        dialogue.add(systemText.getSystemMessage("combat.enemy.investida.name"));
        dialogue.add(String.format(systemText.getSystemMessage("combat.enemy.roll.attack"), droneAttackRoll, playerDefense));

        boolean isCritical = diceRoll == 20;
        boolean isCriticalError = diceRoll == 1;

        if (isCritical) {
            dialogue.add(systemText.getSystemMessage("combat.critical"));
        } else if (isCriticalError) {
            dialogue.add(systemText.getSystemMessage("combat.criticalError"));
        }

        if (droneAttackRoll >= playerDefense && !isCriticalError) {
            int damage = rollDice(1, 8) + 3;
            if (isCritical) {
                damage = damage * 2;
            }
            int newHealth = elodin.getClasse().getVida() - damage;
            elodin.getClasse().setVida(Math.max(0, newHealth));
            dialogue.add(firstActText.getFirtsAct("combat.enemy.investida.success"));
            dialogue.add(String.format(systemText.getSystemMessage("combat.player.damage.taken"), damage));
        } else if (isCriticalError) {
            int selfDamage = rollDice(1, 8) + 3;
            int newDroneHealth = drone.getClasse().getVida() - selfDamage;
            drone.getClasse().setVida(Math.max(0, newDroneHealth));
            dialogue.add(firstActText.getFirtsAct("combat.enemy.investida.criticalError"));
            dialogue.add(String.format(systemText.getSystemMessage("combat.enemy.self.damage"), selfDamage));
        } else {
            dialogue.add(firstActText.getFirtsAct("combat.enemy.investida.failure"));
        }
    }

    private void executeDroneElectromagneticPulse(Monstro drone, int playerDefense, int droneIntelecto, List<String> dialogue) {
        int diceRoll = rollDice(1, 20);
        int droneAttackRoll = diceRoll + droneIntelecto;

        dialogue.add(systemText.getSystemMessage("combat.enemy.pulso.name"));
        dialogue.add(String.format(systemText.getSystemMessage("combat.enemy.roll.pulso"), droneAttackRoll, playerDefense));

        boolean isCritical = diceRoll == 20;
        boolean isCriticalError = diceRoll == 1;

        if (isCritical) {
            dialogue.add(systemText.getSystemMessage("combat.critical"));
        } else if (isCriticalError) {
            dialogue.add(systemText.getSystemMessage("combat.criticalError"));
        }

        if (droneAttackRoll >= playerDefense && !isCriticalError) {
            int damage = rollDice(2, 10) + 3;
            if (isCritical) {
                damage = damage * 2;
            }
            int newHealth = elodin.getClasse().getVida() - damage;
            elodin.getClasse().setVida(Math.max(0, newHealth));
            dialogue.add(firstActText.getFirtsAct("combat.enemy.pulso.success"));
            dialogue.add(String.format(systemText.getSystemMessage("combat.player.damage.taken"), damage));
        } else if (isCriticalError) {
            int selfDamage = rollDice(2, 10)+3;
            int newDroneHealth = drone.getClasse().getVida() - selfDamage;
            drone.getClasse().setVida(Math.max(0, newDroneHealth));
            dialogue.add(firstActText.getFirtsAct("combat.enemy.pulso.criticalError"));
            dialogue.add(String.format(systemText.getSystemMessage("combat.enemy.self.damage"), selfDamage));
        } else {
            dialogue.add(firstActText.getFirtsAct("combat.enemy.pulso.failure"));
        }
    }

    private void showTemporaryAbilities() {
        List<String> abilities = new ArrayList<>();
        long[] abilityIds = {3, 4, 5, 6};
        int[] abilityNumbers = {1, 2, 3, 4};

        for (int i = 0; i < abilityIds.length; i++) {
            Habilidade ability = elodin.getClasse().getHabilidade(abilityIds[i]);
            if (ability != null) {
                String status = isAbilityAvailable(abilityNumbers[i]) ? "check" : "wait";
                abilities.add(status + " " + ability.getNome() + ": \n" + ability.getDescricao() + "\n");
            }
        }

        abilities.add(systemText.getSystemMessage("util.enter"));
        displayDialogue(scanner, abilities);
    }
}
