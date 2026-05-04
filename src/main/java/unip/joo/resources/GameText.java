package unip.joo.resources;

import java.util.LinkedHashMap;
import java.util.Map;

public class GameText {
    private final Map<String, String> systemMessage = new LinkedHashMap<>() {{

        put(
                "game.initial.suggestion",
                "IMPORTANTE!\n1- Maximize a janela do CMD/Terminal para uma melhor visualização.\n" +
                        "2- o jogo seguirá em blocos, para continuar aperte [ENTER]"
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
                "error.initiativeLimit",
                "Limite de tentativas de iniciativa excedido! Iniciando combate normalmente."
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
                "ERRO: Falha ao executar ataque especial do drone!"
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
                "error.noAbilities",
                "Nenhuma habilidade temporária disponível no momento."
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
                "test.iniciativa",
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
                "test.again",
                "[EMPATE] FACA O TESTE NOVAMENTE"
        );

        put(
                "roll.losesLife",
                ">> Você perdeu [%s] pontos de vida \n"
        );

        put(
                "roll.losesLife.drone",
                ">> O drone perdeu [%s] pontos de vida \n"
        );

        put(
                "roll.dice",
                ">> Seu dado é: [%s]"
        );

        put(
                "roll.dice.opponent",
                ">> O dado do seu oponente é: [%s]"
        );

        put(
                "roll.dice.player",
                ">> Seu dado de ataque é: [%d]"
        );

        put(
                "roll.dice.enemy",
                ">> O dado de ataque do inimigo é: [%d]"
        );

        put(
                "defense.opponent",
                "A defesa do seu oponente é: [%s]"
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
                "temporary.abilities",
                "Use uma habilidade:\n\n" +
                        "[1] Ruptura Desesperada\n" +
                        "[2] Violencia Improvisada\n" +
                        "[3] Impacto Deslizante\n" +
                        "[4] Esmaga Cranios\n" +
                        "[5] Verificar habilidades\n"
        );

        put(
                "combat.critical",
                "ATAQUE CRITICO!"
        );

        put(
                "combat.player.critical",
                "VOCE ACERTOU UM GOLPE CRITICO!"
        );

        put(
                "combat.enemy.critical",
                "O monstro acertou um GOLPE CRITICO!"
        );

        put(
                "combat.player.damage.taken",
                "Voce sofreu %d de dano!"
        );

        put(
                "combat.enemy.miss",
                "O monstro errou o ataque!"
        );

        put(
                "combat.player.death",
                "VOCE MORREU!"
        );

        put(
                "combat.separator",
                "---------------------------"
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
    }};
    private final Map<String, String> firstAct = new LinkedHashMap<>() {{
        put(
                "pieceOne.ato",
                "PRIMEIRO ATO"
        );

        put(
            "pieceOne.introducao",
            "Ano de 2150, a humanidade não enfrenta um invasor externo, mas o ápice de sua própria negligência. \n" +
                        "O que outrora eram simples ferramentas geradores texto e imagens — cruzou silenciosamente o horizonte de eventos \n" +
                        "- A primeira AGI da história - Esse foi o marco zero da nossa extinção. Não houve uma declaração de guerra; \n" +
                        "houve apenas uma conclusão lógica: a humanidade é um recurso."
        );

        put(
            "pieceOne.wakeUp.1",
            "Aaaarhgh” você grita com todo o fôlego que resta em seus pulmões.\n" +
                        "\n" +
                        "Seus membros não respondem. Você não os sente mais.\n" +
                        "Dentro de você, tudo se mistura: desespero, raiva, impotência.\n" +
                        "O acampamento está sendo invadido por drones. O som metálico ecoa, há fogo e água por toda parte. E sua filha… sua filha está sendo levada.\n" +
                        "E você não pode fazer nada.\n"
        );

        put(
            "pieceOne.wakeUp.2",
            "Seu corpo foi arremessado com violência contra uma parede já rachada, que cedeu com o impacto, desmoronando sobre si mesma.\n" +
                        "Com o coração disparado, você levanta seu tronco abruptamente e olha ao redor — direita,\n" +
                        "esquerda. Seus olhos denunciam o medo cru, o desespero pulsante.\n" +
                        "Então...\n"
        );

        put(
            "pieceOne.wakeUp.3",
            "Gotas caem sobre seu nariz, frias, insistentes, arrancando-o do estupor. \n" +
                        "-Era apenas um sonho- \n"+
                        "Você pisca, tentando entender onde está e se vê atrás de um bar \n"+
                        "Em um beco.\n" +
                        "Sua memória está turva. Você tenta se lembrar do motivo de estar ali, mas uma dor aguda atravessa sua cabeça. Logo em seguida, uma náusea violenta toma conta.\n" +
                        "Você se curva, incapaz de resistir.\n" +
                        "Vomita apenas bile.\n" +
                        "Não havia comido nada no dia anterior… e gastou todo o dinheiro em cerveja salgada e venenosa.");

        put(
            "action.wakeUp.getUp.failure",
            "Suas pernas não respondem direito, você perde o equilíbrio e cai de cara no monte de lixo úmido. \n" +
                  "Um cheiro pungente invade suas narinas. \n" +
                  "(Dano de queda(1d4)). \n"
        );

        put(
            "action.wakeUp.getUp.failure.2",
            "Se apoiando na parede próxima, você se levanta com suas pernas trêmulas"
        );

        put(
            "action.wakeUp.default",
            "Indo sentido a saída uma luz forte invade sua visão, fazendo-o cobrir os olhos com as mãos \n"
        );

        put(
            "action.wakeUp.default.2",
            "Chegando na praça é possível ver diversas barracas surradas em pé, \n" +
                "Há principalmente barracas de sucata e barracas com líquidos verdes translúcidos."
        );

        put(
            "pieceTwo.init.choice.one",
            "Ir a barraca de sucatas [1] \n Ir a barraca de comidas [2] \n Ir a barraca de liquidos [3]"
        );

        put(
            "pieceTwo.scrap.init",
            "Um senhor moreno, com a pele queimada pelo sol observa enquanto você se \n " +
                "aproxima da barraca, franzindo levemente o cenho ele diz: "
        );

        put(
            "pieceTwo.scrap.one.one",
            "Respondeu enquanto pegava uma peça de sucata e girava na mão."
        );

        put(
           "pieceTwo.scrap.one.two",
           "O vendedor te olha fixamente"
        );

        put(
            "pieceTwo.scrap.one.three",
            "Um silêncio desconfortável se instaurou"
        );

        put(
            "pieceTwo.scrap.two.one",
            "Diz o vendedor com uma risada sem humor"
        );

        put(
            "pieceTwo.scrap.two.two",
            "Te analisando de cima a baixo ele fecha a cara e diz"
        );

        put(
            "pieceTwo.food.one.one",
            "O vendedor te olha o de cima a baixo, com um olhar inquisidor"
        );

        put(
                "pieceTwo.food.one.two",
                "O vendedor tira o olhar de seu prato, e te olha, vendo seu atual estado e lhe entrega a comida"
        );
        put(
                "pieceTwo.food.one.three",
                "Diz ao se inclinar levemente para frente"
        );
        put(
                "pieceTwo.food.one.four",
                "Aponta com a cabeça para a comida pra comida"
        );
        put(
                "pieceTwo.food.two.one",
                "Soltando uma gargalhada sincera ele lhe diz"
        );
        put(
                "pieceTwo.liquid.one.one",
                "Te encarando surpreso o vendedor solta um sorriso de canto de boca"
        );
        put(
                "pieceTwo.liquid.one.two",
                "Soltando um leve suspiro ele vasculha algumas garrafas e tira um frasco com um liquido meio amarelado."
        );
        put(
                "pieceTwo.liquid.two.one",
                "O vendedor dá de ombros."
        );
        put(
                "pieceTwo.liquid.two.two",
                "Te lança um olhar firme."
        );

        put(
                "prePieceThree.beggar.one",
                "Uma voz se eleva no meio de uma multidão, cortando a fala do vendedor e atraindo a atenção de todos."
        );
        put(
                "prePieceThree.beggar.two",
                "Um homem, maltrapilho com um papelão acima da cabeça, a escrita é confusa mas quando ele abre a boca você entende."
        );
        put(
                "pieceThree.beggar.three",
                "Por um segundo… tudo fica em silêncio."
        );

        put(
                "pieceThree.beggar.four",
                "Então, um estalo seco rasga o ar."
        );

        put(
                "pieceThree.beggar.five",
                "O mendigo trava no lugar, o corpo enrijecendo antes de começar a tremer violentamente."
        );

        put(
                "pieceThree.beggar.six",
                "Faíscas percorrem sua pele como veias de luz, pulsando de dentro pra fora."
        );

        put(
                "pieceThree.beggar.seven",
                "Mendigo: \"V—vocês… ainda—\""
        );

        put(
                "pieceThree.beggar.eight",
                "A descarga aumenta, brutal, fazendo o ar ao redor vibrar."
        );

        put(
                "pieceThree.beggar.nine",
                "O cheiro de carne queimada se espalha rápido demais."
        );

        put(
                "pieceThree.beggar.ten",
                "Ele desaba no chão, rígido."
        );

        put(
                "pieceThree.beggar.eleven",
                "Morto."
        );

        put(
                "pieceThree.beggar.twelve",
                "(pausa curta)"
        );

        put(
                "pieceThree.beggar.thirteen",
                "E então o caos começa."
        );

        put(
                "pieceThree.beggar.fourteen",
                "A multidão explode em pânico, gritos se sobrepondo enquanto corpos se empurram sem direção."
        );

        put(
                "pieceThree.beggar.fifteen",
                "Alguns caem… e não levantam mais."
        );

        put(
                "pieceThree.beggar.sixteen",
                "Outros são pisoteados no desespero."
        );

        put(
                "pieceThree.beggar.seventeen",
                "Mais estalos ecoam."
        );

        put(
                "pieceThree.beggar.eighteen",
                "Mais descargas."
        );

        put(
                "pieceThree.beggar.nineteen",
                "Um por um."
        );

        put(
                "pieceThree.beggar.twenty",
                "Como se algo, lá em cima, estivesse escolhendo."
        );

        put(
                "pieceThree.beggar.twentyOne",
                "O sangue se mistura com a poeira, transformando o chão em um borrão sujo e indistinto."
        );

        put(
                "pieceThree.beggar.twentyTwo",
                "Você levanta o olhar."
        );

        put(
                "pieceThree.beggar.twentyThree",
                "E vê."
        );

        put(
                "pieceThree.beggar.twentyFour",
                "Sobrevoando acima de tudo, uma máquina desce lentamente do céu."
        );

        put(
                "pieceThree.beggar.twentyFive",
                "Envolta por uma luz branca artificial, quase… sagrada."
        );

        put(
                "pieceThree.beggar.twentySix",
                "Limpa demais para aquele lugar."
        );

        put(
                "pieceThree.beggar.twentySeven",
                "Fria demais para ser humana."
        );

        put(
                "pieceThree.beggar.twentyEight",
                "Ela para no ar, e o movimento ao redor parece desacelerar."
        );

        put(
                "pieceThree.beggar.twentyNine",
                "Como se tudo reconhecesse sua presença."
        );

        put(
                "pieceThree.beggar.thirty",
                "Como se tudo soubesse."
        );

        put(
                "pieceThree.beggar.thirtyOne",
                "A lente gira lentamente."
        );

        put(
                "pieceThree.beggar.thirtyTwo",
                "E então… para em você."
        );

        put(
                "pieceThree.beggar.thirtyThree",
                "(pausa)"
        );

        put(
                "pieceThree.beggar.thirtyFour",
                "Não há som."
        );

        put(
                "pieceThree.beggar.thirtyFive",
                "Não há pressa."
        );

        put(
                "pieceThree.beggar.thirtySix",
                "Só certeza."
        );

        put(
                "pieceThree.beggar.thirtySeven",
                "Você sente isso antes mesmo de entender."
        );

        put(
                "pieceThree.beggar.thirtyEight",
                "Sem dúvida."
        );

        put(
                "pieceThree.beggar.thirtyNine",
                "Sem erro."
        );

        put(
                "pieceThree.beggar.forty",
                "Você é o próximo."
        );

        put(
                "combat.drone.eletricPulse",
                "um pulso eletromagnético toma conta do seu corpo, seu corpo se desestabiliza \n" +
                        "por um segundo"
        );
        put(
                "combat.drone.eletricPulse.failure",
                "Um desconforto toma conta de sua mente, e por puro reflexo você dá um\n" +
                        "pulo para frente. poeira e um barulho devastador toma conta do ambiente, uma onda\n" +
                        "eletromagnética passa ao seu lado, levando tudo que estiver em seu caminho."
        );
        put(
                "combat.drone.eletricPulse.default",
                "você vê um pedaço de cano enferrujado sendo jogado em sua direção, sua única arma e\n" +
                        "sua chance de sobrevivência, afinal de contas é isso que você é, um sobrevivente.\n"
        );
        put(
                "combat.drone.ruptura.failure",
                "Você avança para agarrá-lo, o corpo já entrando no movimento — mas algo trava. Sua visão \n" +
                        "vacila, o enjoo sobe de repente. Sua mão falha no alcance, o golpe sai desajeitado, \n" +
                        " e o drone recua antes que você consiga completar o ataque."
        );
        put(
                "combat.drone.ruptura.success",
                "Você encurta a distância num instante, agarra o oponente com firmeza e, sem dar espaço para \n" +
                        "reação, desce o cano de metal contra sua cabeça em um golpe pesado que ressoa seco."
        );

    }};

    private final Map<String, String> descriptions = Map.of(
            "classe.sobrevivente",
            "Um sobrevivente nato, capaz de suportar longos combates e desafios ambientais. Seu \n" +
                    "corpo e mente resistem ao desgaste, mas fraquezas climáticas e energia limitada exigem \n" +
                    "planejamento e cuidado.\n",

            "habilidade.esquivaDesesperada",
            "Após vários anos de sua vida sobrevivendo a combates \n" +
                    "extremos, o sobrevivente sabe que ficar na frente de um ataque não é uma opção \n" +
                    "válida, sendo assim, o sobrevivente consegue esquivar de ataques inimigos. (1d4 \n" +
                    "rodadas de cooldown) ",

            "habilidade.ultimoFolego",
            "após a vida do personagem ficar menor que 30%, o personagem ganha +1 \n" +
                    "dado de dado do mesmo tipo na arma que está usando e 10% de resistência a dano. \n" +
                    "(1 vez por combate) ",

            "habilidade.raioEletrico",
            ""

    );
    private final Map<String, String> temporaryAbilities = new LinkedHashMap<>() {{
       put(
               "RupturaDesesperada",
               "Tipo: Ataque corpo a corpo\n" +
                       "Teste: d20 + Força vs Defesa\n" +
                       "Dano: 2d10 + 3\n" +
                       "Descrição: Você avança sem hesitar, agarra o oponente com força e desce o cano de metal contra sua cabeça em um golpe seco e brutal."

       );
        put(
                "ViolenciaImprovisada",
                "Tipo: Ataque corpo a corpo\n" +
                        "Teste: d20 + Força vs Defesa\n" +
                        "Dano (sucesso): 2d10 + 3\n" +
                        "Descrição: Sem técnica ou hesitação, você avança usando o que tiver à mão, desferindo golpes caóticos e imprevisíveis contra o alvo."
        );
        put(
                "ImpactoDeslizante",
                "Tipo: Ataque corpo a corpo improvisado\n" +
                        "Teste: d20 + Força vs Defesa\n" +
                        "Dano: 2d10 +3\n" +
                        "Descrição: Avança contra o alvo, desliza por baixo dele e desfere um golpe rápido em movimento."
        );
        put(
                "EsmagaCranios",
                "Tipo: Ataque corpo a corpo\n" +
                        "Teste: d20 + Força vs Defesa\n" +
                        "Dano: 2d10 + 3\n" +
                        "Descrição: Salta e desfere um golpe poderoso na cabeça do alvo."
        );
    }};

    private final Map<String, String> asciiArts = Map.of(
            "game.name",
            "                                                                                                    \n" +
                    "         .:=**+-.       .:===..   .-=======:   .-+**=:.    :====-.  .=++**+=:.     .-+**+:..        \n" +
                    "       .+%@@@@@@@#-     .+@@@+.   -%@@@@@@@= .*@@@@@@@%.  :%@@@@@+. .@@@@@@@@@*. :*@@@@@@@@*.       \n" +
                    "       *@@@@%%@@@@%-    .+@@@+.   -%@@@=---..%@@@@%%@%.  .+@@@@@@#: .@@@@**@@@@#-#@@@@%%@@@@*       \n" +
                    "      .@@@@*..:@@@@+    .+@@@=.   -%@@@@@@@=-@@@@++%%%%: -%@@@#@@@=..@@@%: *@@@%+@@@@-..+@@@@:      \n" +
                    "      .%@@@@=:#@@@@=    .+@@@#:...=@@@@%**+..@@@@%=#@@@=.+@@@@@@@@%:.@@@%-.%@@@#=@@@@%:-%@@@@.      \n" +
                    "       .@@@@@@@@@@+.    .+@@@@@@@#=@@@@@@@@*.-@@@@@@@@@--@@@@@@@@@@=.@@@@@@@@@%-.=@@@@@@@@@@.       \n" +
                    "        .:#%@@%%=.      .=%%%%%%%*-#%%%%%%%+.  -%@@@%#..=%%%#..=%%%#.%%%@@%%#-.   .=%%@@%#:.        \n" +
                    "                                                                                                    \n" +
                    "                                       -@@@@@@@#=. =%@@@@@@@:.                                      \n" +
                    "                                       -@@@@@@@@@%:+@@@@@@@@-.                                      \n" +
                    "                                       -@@@*..@@@@++@@@@@%%#:.                                      \n" +
                    "                                       -@@@+..@@@@++@@@@@@@@:.                                      \n" +
                    "                                       -@@@@#@@@@@=*@@@@++++:.                                      \n" +
                    "                                       -@@@@@@@@%= +@@@@@@@@*.                                      \n" +
                    "                                       .:-----.    ..:::::::..                                      \n" +
                    "                                                                                                    \n" +
                    "                                ..-+*=.  .:--:  .:--...=::.       .:---:.                           \n" +
                    "                               -@@@@@@@%:-@@@@ .-@@@#.@@@@+.     -%@@@@@+.                          \n" +
                    "                              *@@@@@@@@:.-%@@@ .-@@@#.@@@@+.    .+@@@@@@#.                          \n" +
                    "                             .@@@@+:*###=-%@@@ .-@@@#.@@@@=.    -%@@@%@@@+.                         \n" +
                    "                             .@@@@@++@@@#:#@@@=:*@@@*.@@@@+.....+@@@@%@@@%:.                        \n" +
                    "                              .%@@@@@@@@*.=@@@@@@@@%:.@@@@@@@@%-@@@@@@@@@@+.                        \n" +
                    "                               .-#%%%%#=. .:*%%%%#=.  #%%%%%%%*=%%%*. +%%%*.                        \n" +
                    "                                                                                                    \n" +
                    "                                                                                                    \n" +
                    "                                                                                                    "

    );

    public String getSystemMessage(String key) {
        return systemMessage.get(key);
    }

    public String getFirtsAct(String key) {
        return firstAct.get(key);
    }
    public Map getAllFirtsAct() { return firstAct; }

    public String getDescriptions(String key) {
        return descriptions.get(key);
    }
    public String getTemporaryAbilities(String key) {
        return temporaryAbilities.get(key);
    }

    public String getAsciiArts(String key) { return asciiArts.get(key); }
}
