package unip.joo.resources;

import java.util.LinkedHashMap;
import java.util.Map;

public class SystemText {
    private final Map<String, String> systemMessage = new LinkedHashMap<>() {{

        put(
                "game.initial.suggestion",
                ".\n.\n.\nIMPORTANTE!\n1- Maximize a janela do CMD/Terminal para uma melhor visualização.\n" +
                        "2- O jogo seguirá em blocos, para continuar aperte [ENTER]\n" +
                        "3- Haverá testes em determinados momentos e não será exibido o valor necessário para passar no teste.\n" +
                        "4- O jogador terá um número de chances de repetir o teste com base em seus atributos, o teste será\n" +
                        "repetido até atingir o limite de tentativas ou até passar no teste."+
                        "5- Ao equipar um item ou usar um item consumível, será contato como tendo feito sua ação no turno\n" +
                        "6- Caso esteja em dúvida no que fazer, sua provável ação é [ENTER]. (Na dúvida aperte enter)\n" +
                        "7- Antes de executar uma ação, ou responder uma pergunta feita no jogo, clique no local abaixo da pergunta ou ação.\n" +
                        "uma vez é suficiente, porém sempre repita isso ao sair e voltar para o jogo."
        );

        put(
                "game.start",
                "DESEJA INICIAR O JOGO?\n[1]SIM [2]NAO"
        );

        put(
                "game.close",
                "Que pena que você não continuará jogando. Você é bem-vindo para voltar quando quiser."
        );

        put(
                "error.opcaoInvalida",
                "Não entendi muito bem o que quis dizer, pode repetir?"
        );

        put(
                "error.invalidMonster",
                "ERRO: Monstro inválido ou não inicializado! O combate não pode continuar."
        );

        put(
                "error.missingAttribute",
                "ERRO: Atributo de agilidade não encontrado para o personagem!"
        );

        put(
                "error.missingMonsterAttribute",
                "ERRO: Atributo do monstro não encontrado!"
        );

        put(
                "error.invalidDice",
                "ERRO: Valores de dado inválidos!"
        );

        put(
                "error.missingAbility",
                "ERRO: Habilidade não encontrada para este monstro!"
        );

        put(
                "error.specialAttack",
                "ERRO: Falha ao executar ataque especial do oponente!"
        );

        put(
                "error.combatLimit",
                "Limite de turnos de combate excedido! O combate foi interrompido."
        );

        put(
                "error.combat",
                "ERRO: Falha grave durante o combate!"
        );

        put(
                "error.playerTurn",
                "ERRO: Falha ao executar turno do jogador!"
        );

        put(
                "error.monsterTurn",
                "ERRO: Falha ao executar turno do monstro!"
        );

        put(
                "error.unknownAbility",
                "ERRO: Habilidade desconhecida!"
        );

        put(
                "error.combatInit",
                "ERRO: Falha ao inicializar o combate!"
        );

        put(
                "error.invalidOption",
                "Opção inválida! Escolha uma opção disponível no menu."
        );

        put(
                "util.spacingDot",
                ".\n.\n.\n.\n."
        );

        put(
                "util.enter",
                "\nContinuar [ENTER]\n"
        );

        put(
                "game.name",
                "                 O LEGADO DE GULA"
        );

        put(
                "action.wakeUp.getUp",
                "Levantar [ENTER]"
        );

        put(
                "test.vigor",
                "INICIANDO TESTE DE VIGOR: haverá [%s] chances com d20"
        );

        put(
                "test.forca",
                "INICIANDO TESTE DE FORÇA: haverá [%s] chances com d20"

        );
        put(
                "test.agilidade",
                "INICIANDO TESTE DE AGILIDADE: haverá [%s] chances com d20"

        );
        put(
                "test.iniciative",
                "INICIANDO TESTE DE INICIATIVA(agilidade)"
        );

        put(
                "test.failure",
                "VOCE FALHOU NO TESTE"
        );

        put(
                "test.success",
                "VOCE PASSOU NO TESTE"
        );

        put(
                "roll.losesLife",
                ">> Você perdeu [%s] pontos de vida \n"
        );
        put(
                "actualLife",
                ">> Vida atual: [%s]/[%s] \n"
        );
        put("bothActualLife",
        ">> Vida atual: [%s]/[%s] || Vida do oponente: [%s]/[%s] \n"
        );

        put(
                "roll.losesLife.drone",
                ">> O oponente perdeu [%s] pontos de vida \n"
        );


        put(
                "combat.roll.attack",
                ">> Seu dado de ataque: [%d] vs Defesa do seu oponente: [%d]"
        );
        put(
                "combat.roll.inciative",
                ">> Seu dado de Iniciativa: [%d] vs iniciativa do seu oponente: [%d]"
        );

        put(
                "defense.player",
                ">> Sua defesa é: [%d]"
        );

        put(
                "turn.your",
                "[SEU TURNO]"
        );

        put(
                "turn.enemy",
                "[TURNO DO INIMIGO]"
        );

        put(
                "turn.opponent",
                "[TURNO DO OPONENTE]"
        );

        put(
                "turn.counter",
                "========== TURNO [%d] =========="
        );

        put(
                "barra.abilities",
                "Use uma habilidade:\n\n" +
                        "[1] Ruptura Desesperada\n" +
                        "[2] Violencia Improvisada\n" +
                        "[3] Impacto Deslizante\n" +
                        "[4] Esmaga Cranios\n" +
                        "[5] Verificar habilidades\n"
        );
        put(
                "barra.abilities.inventory",
                "Use uma habilidade:\n\n" +
                        "[1] Ruptura Desesperada\n" +
                        "[2] Violencia Improvisada\n" +
                        "[3] Impacto Deslizante\n" +
                        "[4] Esmaga Cranios\n" +
                        "[5] Abrir inventário\n"
        );
        put(
                "pistola.abilities",
                "Use uma habilidade:\n\n" +
                        "[1] Tiro de Precisão\n" +
                        "[2] Disparo de Ruptura\n" +
                        "[3] Tiro Simples\n" +
                        "[4] Disparo Desesperado\n" +
                        "[5] Verificar habilidades\n"
        );
        put(
                "pistola.abilities.inventory",
                "Use uma habilidade:\n\n" +
                        "[1] Tiro de Precisão\n" +
                        "[2] Disparo de Ruptura\n" +
                        "[3] Tiro Simples\n" +
                        "[4] Disparo Desesperado\n" +
                        "[5] Abrir inventário\n"
        );

        put(
                "combat.critical",
                "ACERTO CRITICO!"
        );

        put(
                "combat.criticalError",
                "ERRO CRITICO!"
        );
        put(
                "roll.dice",
                "Seu dado é [%s]"
        );

        put(
                "combat.enemy.pulso.critical",
                "Pulso eletromagnético crítico! Efeitos ampliados!"
        );

        put(
                "combat.player.damage.taken",
                "Voce sofreu %d de dano!"
        );

        put(
                "combat.player.self.damage",
                "Você se machucou e perdeu %d pontos de vida!"
        );

        put(
                "combat.enemy.self.damage",
                "O monstro se danificou e perdeu %d pontos de vida!"
        );

        put(
                "combat.separator",
                "---------------------------"
        );

        put(
                "combat.enemy.ataqueeletrico.name",
                ">> Drone usa: Ataque Elétrico"
        );
        put(
                "combat.enemy.investida.name",
                ">> Drone usa: Investida Mecânica"
        );
        put(
                "combat.enemy.pulso.name",
                ">> Drone usa: Pulso Eletromagnético"
        );
        put(
                "combat.enemy.roll.attack",
                ">> Dado de ataque do oponente: [%d] vs Sua defesa: [%d]"
        );
        put(
                "combat.enemy.roll.pulso",
                ">> Dado de pulso do drone: [%d] vs Sua defesa: [%d]"
        );

        put(
                "combat.enemy.miss",
                "O monstro errou o ataque!"
        );

        // Mensagem de cooldown
        put(
                "combat.ability.cooldown",
                "[%s] esta em recarga! Ainda faltam %d turno(s) para poder usa-la novamente."
        );

        // Status para habilidades
        put(
                "ability.available",
                "[DISPONIVEL]"
        );

        put(
                "ability.cooldown",
                "[RECARREGANDO]"
        );
        // Mensagem de teste de resistencia do Segundo Ato
        put(
                "action.fortress.entry",
                "[RESISTA AO GÁS DA FORTALEZA]"
        );

        put(
                "action.fortress.run",
                "[FUJA DA MULHER MASCARADA]"

        );

        put(
                "item.received",
                ">> ITEM RECEBIDO: [%s]"
        );
        put("criticalError.consumo",
                ">> Gula sofreu [%d] de dano e você recuperou [%d] pontos de vida!");
        put("hit.consumo",
                ">> Gula recuperou [%d] pontos de vida e você perdeu [%d] pontos de vida!");
        put("cooldown",
                "%s está em recarga! Ainda faltam %d turno(s) para poder usá-la novamente.");
    }};

    public String getSystemMessage(String key) {
        return systemMessage.get(key);
    }
}
