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
                "test.forca",
                "INICIANDO TESTE DE FORÇA: haverá [%s] chances com d20"

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
                "roll.losesLife",
                ">> Você perdeu [%s] pontos de vida \n"
        );
        put(
                "actualLife",
                ">> Vida atual: [%s]/[%s] \n"
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
                "ACERTO CRITICO!"
        );

        put(
                "combat.criticalError",
                "ERRO CRITICO!"
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
                ">> Dado de ataque do drone: [%d] vs Sua defesa: [%d]"
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

        put(
                "pieceTwo.Fortress.GasmaskLady.Item",
                "ITEM RECEBIDO: [MÁSCARA DE GÁS]."
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
                        "O acampamento está sendo invadido por drones. O som metálico ecoa, há fogo e água por toda parte. E sua filha... sua filha está sendo levada.\n" +
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
                        "Não havia comido nada no dia anterior... e gastou todo o dinheiro em cerveja salgada e venenosa.");

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
                "[1] Ir a barraca de sucatas\n" +
                        "[2] Ir a barraca de comidas\n" +
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
                "pieceThree.beggar.one",
                "Por um segundo, tudo fica em silêncio.\n" +
                "Então um estalo seco rasga o ar.\n" +
                "O mendigo trava no lugar. Seu corpo enrijece antes de começar\n" +
                "a tremer violentamente. Faíscas percorrem sua pele como veias de luz," 
        );
        put(
                "pieceThree.beggar.two",
                "pulsando de dentro pra fora, a descarga aumenta, brutal, fazendo o ar ao redor vibrar.\n" +
                "O cheiro de carne queimada se espalha rápido demais.\n" +
                "Ele desaba no chão, rígido...sem vida."
        );
        put(
                "pieceThree.beggar.three",
                "E então o caos começa.\n" +
                "A multidão explode em pânico, gritando a plenos pulmões enquanto\n" +
                "seus corpos se empurram sem direção. Alguns caem e não levantam mais,\n" +
                "outros são pisoteados no desespero. Mais estalos ecoam."
        );
        put(
                "pieceThree.beggar.four",
                "O sangue se mistura com a poeira, transformando o chão em um borrão sujo e indistinto.\n" +
                "Você levanta o olhar, e vê sobrevoando acima de tudo, uma máquina desce lentamente do céu."
        );
        put(
                "pieceThree.beggar.five",
                "Envolta por uma luz branca artificial, quase... sagrada, limpa demais para aquele lugar. Fria demais para ser humana.\n" +
                "Ela para no ar e, o tempo parece desacelerar, como se tudo reconhecesse sua presença.\n" +
                "A lente parecendo um enorme olho gira lentamente parando em você."
        );
        put(
                "pieceThree.beggar.six",
                "..."
        );
        put(
                "pieceThree.beggar.seven",
                "Ela não emite som, calma como se nada estive acontecendo.\n"+
                "Você sente isso antes mesmo de entender, é um sentimento profundo.\n" +
                "que vem do seu amago, sem dúvida, sem questionamentos. Você é o próximo."
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
                        "Não é forte... mas é o suficiente para manter o inimigo recuando."
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
        put(
                "combat.player.ruptura.criticalError",
                "Você avança para agarrar o drone, mas tropeça no próprio pé! O cano enferrujado escorrega \n" +
                        "de sua mão e acerta seu próprio joelho, causando uma dor lancinante que o paralisa momentaneamente."
        );
        put(
                "combat.player.Violencia.criticalError",
                "Você tenta golpear desajeitadamente, perdendo completamente o controle! O cano sai voando \n" +
                        "de sua mão e volta na sua direção, acertando seu ombro com força surpreendente."
        );
        put(
                "combat.player.Impacto.criticalError",
                "Você tenta deslizar para atacar o drone, mas escorrega desastrosamente no chão sujo e cai \n" +
                        "de cara, batendo a cabeça no cano que estava segurando."
        );
        put(
                "combat.player.Esmaga.criticalError",
                "Você pula com toda a força para esmagar o drone, mas calcula mal a distância e cai de \n" +
                        "barriga no chão, o impacto reverberando por todo seu corpo como um trovão."
        );

        // Ataques do Drone
        put(
                "combat.enemy.ataqueeletrico.failure",
                "A descarga passa raspando, queimando o ar ao seu lado. \n" +
                        "Seu corpo treme... mas você aguenta."
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
                "combat.enemy.ataqueeletrico.criticalError",
                "O drone tenta liberar uma descarga elétrica devastadora, mas há um curto-circuito catastrófico! \n" +
                        "Faíscas voam de seu próprio corpo enquanto seus circuitos entram em colapso, danificando seus sistemas internos."
        );
        put(
                "combat.enemy.investida.criticalError",
                "O drone avança para uma investida mecânica violenta, mas calcula mal a trajetória e colide \n" +
                        "contra uma pilastra enferrujada com força bruta, danificando severamente seus servomotores."
        );
        put(
                "combat.enemy.pulso.criticalError",
                "O drone tenta emitir um pulso eletromagnético massivo, mas a sobrecarga causa um feedback \n" +
                        "devastador nos seus sistemas, danificando componentes vitais internos."
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
                "Nesse último instante, uma imagem vem à sua mente. Sua filha. Seu rosto. Onde ela está agora?\n" +
                        "O que vai acontecer com ela? Essas perguntas não terão respostas. Você já não está lá para\n" +
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
                "outcome.six",
                "Olhando ao redor você avista a barraca de sucata, não mais de pé com o vendedor já morto,\n"+
                        "e se convence de que mesmo morto ainda vai precisar de sua ajuda. Você vasculha a barra e " +
                        "encontra diversos itens que lhe ajudaram na viajem.:"
        );
        put(
                "outcome.five",
                "Você limpa o sangue das mãos no casaco e olha na direção do Porto. O sol mal consegue\n"+
                        "atravessar a poluição, mas o seu caminho agora tem um propósito. Você sabe onde precisa\n"+
                        "ir. Você sabe o que precisa fazer. E não vai parar até conseguir."
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
                    "                                                                                                    ",
                    "youDied",
                    "                                                                                                              \n" +
                            "                                                                                                              \n" +
                            "                                                                       .#@@@%:                                \n" +
                            "                        .::::::.  .:::::   .:-+=-:.       .:-:..:::.:::=%:::+-::                              \n" +
                            "                        #@@@@@@+  *@@@@% .@@@@@@@@@@.   =@@@@@@@@@@.@@@@@@@@@@@%                              \n" +
                            "                         :@@@@%.  .@@@* -@@@@#..@@@@@. %@@@@*=#@@@@. #@@@=  +@@%                              \n" +
                            "                          =@@@@+ .#@@%..@@@@@   .@@@@@-@@@@:   #@@%. #@@@+---.                                \n" +
                            "                           +@@@@-+@@@. .@@@@%   .@@@@@#@@@@.         #@@@@@@@.                                \n" +
                            "                            #@@@%@@@-  .@@@@@.  :@@@@%-@@@@-    ::   #@@@=  .:::                              \n" +
                            "                             %@@@@@+    -@@@@@--@@@@@. %@@@@@*#@@@%..#@@@=..*@@%                              \n" +
                            "                             .%@@@#.     .#@@@@@@@@*.   -@@@@@@@@#. @@@@@@@@@@@%                              \n" +
                            "                                             ....           ...                                               \n" +
                            "                                                                                                              \n" +
                            "       =++++++=   -+++++++.   .*%@@%=.   -++++++=-.    .+++++++=:     =+++++++++++.++++++  +++++=:++++:       \n" +
                            "       %@@@@@@@.  @@@@@@@@. +@@@@@@@@@@: +@@@@@@@@@@%  .@@@@@@@@@@@:  #@@@@@@@@@@@:@@@@@@  @@@@@%-@@@@-       \n" +
                            "        %@@@@@@% =@@@@@@@. #@@@@- .@@@@@: =@@@# .@@@@.   @@@@. =@@@*   +@@@*  -@@@..@@@@    @@@# -@@@@-       \n" +
                            "        %@@+@@@@.@@@-@@@@..@@@@#   =@@@@* =@@@#.=@@@@    @@@@..%@@@:   +@@@@%%%-   .@@@@    @@@# .@@@@.       \n" +
                            "        %@@=%@@@@@@@.@@@@.:@@@@*   -@@@@# =@@@@@@@@*.    @@@@@@@@%:    +@@@@@@@-   .@@@@    @@@#  #@@*        \n" +
                            "        %@@=.@@@@@@= @@@@..@@@@@.  *@@@@= =@@@# +@@@@ .. @@@@..@@@@-.. +@@@*  .===..@@@@-  :@@@*  ....        \n" +
                            "       -%@@*-#@@@@@.=@@@@=.:@@@@@#%@@@@#.-*@@@%=-@@@@#@.=@@@@+.@@@@%@*=#@@@%++*@@@. -@@@@@@@@@@. -@@@@.       \n" +
                            "       %@@@@*.@@@@=.@@@@@@. .+@@@@@@@%:  +@@@@@%.*@@@@#.@@@@@@:-@@@@@:#@@@@@@@@@@@.  .#@@@@@@#.  .%@@#.       \n" +
                            "                                                                                                              \n" +
                            "                                                                                                              \n" +
                            "                                                                                                              \n" +
                            "                                                                                                              \n" +
                            "                                                                                                              "

    
    );

    //  ========================= SEGUNDO ATO  ===================================

    private final Map<String, String> secondAct = new LinkedHashMap<>() {{
        put("pieceOne.ato", "SEGUNDO ATO");

        put("pieceOne.outOfCity",
                "Você deixa a cidade para trás e segue firme em direção à grande Fortaleza de Ferro.\n" +
                        "Pelo caminho, atravessa cenários de caos e sofrimento, ajudando quem ainda pode ser salvo.\n" +
                        "Mas após uma longa jornada, você finalmente chega em seu destino.");

        put("pieceOne.entranceFortress",
                "A fortaleza é imensa, tomada por correntes elétricas e pelo som constante de água escorrendo.\n" +
                        "Mas algo está errado. Não há guardas. Não há movimento humano.\n" +
                        "É como se o lugar ainda funcionasse mecanicamente, mas estivesse completamente abandonado.\n" +
                        "Ao se aproximar, um gás forte invade seus pulmões, corroendo você por dentro.");

        put("action.entranceFortress.GasResistance.success",
                "Você controla sua respiração. Mesmo com a dor intensa, consegue limitar o ar que entra.");

        put("action.entranceFortress.GasResistance.failure",
                "Seu corpo não resiste. O gás invade violentamente seu organismo, queimando e rasgando você por dentro.");

        put("action.entranceFortress.GasResistance.death",
                "Você avança, mas o ar falta e o chão foge sob seus pés.\n" +
                        "A névoa verde dança ao redor, fria e indiferente à sua luta.\n" +
                        "Você tenta se apoiar na parede, mas o braço já não responde.\n" +
                        "Os joelhos cedem. O corpo desaba no metal gelado.\n" +
                        "A água escorre pelas estruturas, ritmada como um relógio.\n" +
                        "Cada gotejo conta um segundo. Cada segundo doi mais.\n" +
                        "Até que a dor passa. O som some. A luz se apaga.\n" +
                        "E você fica ali, envolto pelo gás, esquecido pela fortaleza.");

        put("pieceTwo.Fortress",
                "Após entrar na fortaleza, você se depara com uma mulher. Ela é bonita, mas há algo estranho.\n" +
                        "Sua aparência contrasta com o ambiente hostil. De repente, ela se vira e corre em sua direção.\n" +
                        "A expressão dela é completamente fria. A mão dela vai até a bolsa, como se estivesse pegando algo.\n" +
                        "Ela está pronta para agir.");

        put("pieceTwo.Fortress.init.choice.one",
                "[1] Correr\n[2] Ficar.");

        put("pieceTwo.Fortress.init.choice.run.success",
                "Você corre mantendo o controle da respiração, como se já estivesse acostumado ao ambiente.\n" +
                        "A mulher para e fica em meio àquela névoa verde.");

        put("pieceTwo.Fortress.init.choice.run.failure",
                "Você tenta correr em desespero, mas o gás o domina. Você tropeça. Cai no chão. Sem forças.\n" +
                        "A mulher se aproxima lentamente, calma, fria. Mas ao invés de atacar, ela pega algo.\n" +
                        "Uma máscara. E coloca em você.");

        put("pieceTwo.Fortress.init.choice.stay",
                "Imóvel, você sente o gás pesar em seus pulmões e sua visão começar a oscilar.\n" +
                        "A figura parada diante de você apenas observa, sem pressa e sem qualquer ameaça.\n" +
                        "Ela abre a bolsa, retira uma máscara de gás e estende em sua direção.\n" +
                        "Naquele gesto silencioso, não há violência, apenas uma estranha cumplicidade.");

        put("pieceTwo.Fortress.init.choice.stay.pause.1",
                "(pausa curta, analisando)");

        put("pieceTwo.Fortress.init.choice.stay.silence",
                "(Silêncio)");

        put("pieceTwo.Fortress.init.choice.stay.pause.2",
                "(pausa)");

        put("pieceTwo.Fortress.init.choice.stay.pause.3",
                "...");

        put("pieceTwo.Fortress.init.choice.stay.disturbance",
                "Um som atravessa o silêncio: um clique seco, depois outro, e as luzes começam a tremer.\n" +
                        "A água escorrendo pelas estruturas muda de direção e por um instante tudo congela.\n" +
                        "Lena trava. Um ruído cresce pelos corredores - não são passos, é algo fluindo.\n" +
                        "Metal se ajustando, correntes rangendo, como se a fortaleza inteira estivesse se reorganizando.\n" +
                        "O ar pesa nos pulmões, difícil respirar mesmo protegido pela máscara.");

        put("pieceTwo.Fortress.init.choice.stay.sensation",
                "Você percebe que não é o gás. É outra coisa, algo que reconhece sua presença.\n" +
                        "Um sussurro então atravessa o ambiente, vindo não de um lugar, mas de tudo ao redor.\n" +
                        "Quase inaudível, a voz diz algo Incognoscível e o silêncio retorna.\n" +
                        "Lena fecha os olhos por um segundo, como quem já esperava por este momento.");

        put("pieceTwo.Fortress.init.choice.stay.final",
                "O som para e um silêncio sepulcral se instaura, deixando Lena visivelmente assustada, \n" +
                        "a ponto de transparecer leves tremores em suas pernas.");

        put("pieceTwo.Fortress.init.choice.stay.final.2",
                "Alguma coisa está vindo.");
    }};


    public String getSystemMessage(String key) {
        return systemMessage.get(key);
    }

    public String getFirtsAct(String key) {
        return firstAct.get(key);
    }
    public Map getAllFirtsAct() { return firstAct; }

    public String getSecondAct(String key) {return secondAct.get(key);}
    public Map getAllSecondsAct(){return secondAct;}

    public String getDescriptions(String key) {
        return descriptions.get(key);
    }
    public String getTemporaryAbilities(String key) {
        return temporaryAbilities.get(key);
    }

    public String getAsciiArts(String key) { return asciiArts.get(key); }
}