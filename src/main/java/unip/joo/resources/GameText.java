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
                "roll.dice.enemy",
                ">> O dado de ataque do inimigo é: [%d]"
        );

        put(
                "combat.roll.attack",
                ">> Seu dado de ataque: [%d] vs Defesa do seu oponente: [%d]"
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
                ">> Dado de ataque do drone: [%d] vs Sua defesa: [%d]"
        );
        put(
                "combat.enemy.roll.pulso",
                ">> Dado de pulso do drone: [%d] vs Sua defesa: [%d]"
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
            "[1] Ir a barraca de sucatas\n " +
            "[2] Ir a barraca de comidas\n " +
            "[3] Ir a barraca de liquidos"
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
        put(
                "combat.drone.Violencia.failure",
                "Você tenta atacar de qualquer jeito, mas seu corpo ainda está instável. \n" +
                        "O golpe sai fraco, sem precisão, e o drone apenas se ajusta, evitando o impacto com \n" +
                        "mínimo esforço."
        );
        put(
                "combat.drone.Violencia.success",
                "Mesmo sem técnica, você consegue acertar um golpe simples com o cano enferrujado. \n" +
                        "Não é forte… mas é o suficiente para manter o inimigo recuando."
        );
        put(
                "combat.drone.Impacto.failure",
                "Você tenta dar um ataque direto no drone, mas ele acaba colocando um braço na frente, \n" +
                        "fazendo com que você não o acerte."
        );
        put(
                "combat.drone.Impacto.success",
                "Você corre em direção ao drone, desliza por baixo das pernas dele e dá um ataque direto \n" +
                        "nas costas da máquina, deixando-a um pouco desequilibrada."
        );
        put(
                "combat.drone.Esmaga.failure",
                "Você pula para dar um ataque mais forte no drone, mas ele simplesmente pula para \n" +
                        "trás, fazendo você acertar o chão com sua força."
        );
        put(
                "combat.drone.Esmaga.success",
                "Você pula para acertar o drone e acerta um golpe em cheio na cabeça dele, \n" +
                        "fazendo a máquina cair para trás."
        );
        
        // Ataques do Drone
        put(
                "combat.enemy.ataqueeletrico.failure",
                "A descarga passa raspando, queimando o ar ao seu lado. \n" +
                        "Seu corpo treme… mas você aguenta."
        );
        put(
                "combat.enemy.ataqueeletrico.success",
                "A eletricidade percorre seu corpo como um choque violento, travando seus músculos por \n" +
                        "um instante."
        );
        put(
                "combat.enemy.investida.failure",
                "Você consegue se jogar pro lado no último segundo, sentindo o vento do impacto."
        );
        put(
                "combat.enemy.investida.success",
                "O drone avança sem hesitar e colide com você, te jogando contra o chão com força brutal."
        );
        put(
                "combat.enemy.pulso.failure",
                "O pulso distorce o ar, mas você consegue se manter firme, mesmo com o corpo tremendo."
        );
        put(
                "combat.enemy.pulso.success",
                "Uma onda invisível atravessa seu corpo. Sua visão falha por um segundo. \n" +
                        "Seus movimentos ficam lentos."
        );
        
        put(
                "combat.victory.drone.death.one",
                "Com um grito de fúria que ecoa na sua própria mente, você aproveita a brecha e crava a sucata\n" +
                        "naquele olho metálico gigante, afundando cada vez mais o cano enferrujado dentro dele.\n" +
                        "Há resistência — sempre há — mas desta vez você não recua."
        );
        
        put(
                "combat.victory.drone.death.two",
                "A máquina emite um estrondo que atravessa o ar, seus movimentos ficam erráticos, descontrolados.\n" +
                        "Você sente uma mistura estranha sob suas mãos — sangue, óleo, metal. Talvez isso seja tudo que\n" +
                        "uma coisa assim possa oferecer. Talvez."
        );
        
        put(
                "combat.victory.drone.death.three",
                "E nesse instante, uma realização fria invade sua mente: matéria orgânica. A máquina a procura,\n" +
                        "a desperdiça, a consome. Você finalmente entende por qual motivo mais pessoas andam sumindo —\n" +
                        "não é apenas o metal que faz falta. Somos um recurso. Sempre fomos."
        );
        
        put(
                "combat.victory.drone.death.four",
                "O drone desaba. Inerte. Finalmente."
        );
        
        put(
                "combat.defeat.player.death.one",
                "Seu corpo falha. Cada nervo queimado, cada músculo tenso além do limite. Você tenta se mover,\n" +
                        "mas não consegue — a máquina é muito rápida, muito precisa, muito... perfeita."
        );
        
        put(
                "combat.defeat.player.death.two",
                "O último golpe não vem de uma direção. É como se viesse de todos os lados ao mesmo tempo.\n" +
                        "Você sente o metal penetrando, a dor elétrica que queima cada célula, e então... nada.\n" +
                        "Apenas silêncio absoluto."
        );
        
        put(
                "combat.defeat.player.death.three",
                "Você desaba. Seu corpo bate contra o chão úmido, coberto de poeira e sangue. A máquina fica\n" +
                        "sobre você, parada, observando. Sempre observando. Esperando que você se mova novamente.\n" +
                        "Mas você não vai se mover."
        );
        
        put(
                "combat.defeat.player.death.four",
                "A visão embaça. Sons distantes se dissolvem. Um zumbido constante nos ouvidos, como se a própria\n" +
                        "morte tivesse um som. Você tenta respirar, mas não há ar — apenas o cheiro de queimado e metal\n" +
                        "oxidado invadindo suas narinas."
        );
        
        put(
                "combat.defeat.player.death.five",
                "Nesse último instante, uma imagem vem à sua mente. Seu filho. Seu rosto. Onde ele está agora?\n" +
                        "O que vai acontecer com ele? Essas perguntas não terão respostas. Você já não está lá para\n" +
                        "respondê-las. Já não está em lugar algum."
        );
        put(
                "outcome.one",
                "Ofegante, você se apoia em uma pilastra, observando a destruição ao redor. A praça está\n" +
"um caos. Ao olhar para os mutantes e para os drones que atacam a multidão, você nota algo \n" +
"perturbador: eles não agem por instinto individual. Eles se movem em uníssono, \n" +
"flanqueando as vítimas com uma precisão matemática, como se respondessem a um comando."
        );
        put(
                "outcome.two",
                "Essa coordenação perfeita engatilha uma memória dolorosa do seu sonho: o som metálico\n" + 
"e o movimento em enxame dos drones que levaram sua filha."
        );
        put(
                "outcome.three",
                "Você percebe que, embora esses mutantes sejam de carne, a inteligência que os\n" + 
"guia é a mesma que controla os drones. Eles são terminais biológicos de uma rede maior. "
        );
        put(
                "outcome.four",
                "Sua mente estala, como um clique seco que reorganiza tudo. De repente, o insight surge, cristalino.\n" +
                "No fim das contas, tudo se resume à gula. Para pôr fim a todos esses “braços”, não adianta cortá-los\n" +
                "um a um, é preciso derrubar a infraestrutura que os sustenta."
       );
       put(
               "outcome.five",
               "Você limpa o sangue das mãos no casaco e olha na direção do Porto. O sol mal consegue\n
                atravessar a poluição, mas o seu caminho agora tem um propósito. Você sabe onde precisa \n
                ir. Você sabe o que precisa fazer. E não vai parar até conseguir."
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
                    "(1 vez por combate) "

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
