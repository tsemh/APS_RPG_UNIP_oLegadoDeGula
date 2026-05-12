package unip.joo.resources;

import java.util.LinkedHashMap;
import java.util.Map;

public class ThirdActText {

    private final Map<String, String> thirdAct = new LinkedHashMap<>() {{
        put("pieceOne.ato", "TERCEIRO ATO - GULA");

        put("pieceOne.lenaApproaches.1", "Enquanto você observa aquela coisa se aproximar, Lena te entrega um pen drive \n" +
                "sem piscar, com os olhos vidrados, você não sabe se é medo ou euforia.\n" +
                "com certa dificuldade ela te olha com uma tez lúgubre.");
        put("pieceOne.lenaApproaches.2",
                "E então você percebe...");
        put("pieceOne.lenaApproaches.3",
                "Ela não pretende sair dali");
        put("pieceOne.lenaApproaches.4",
                "Sabendo que nada a fara mudar de ideia, com resignação você corre para porta que leva ao servidor.");

        put("pieceOne.precombat.success",
                "Você não hesita. Não olha para trás.\n" +
                        "Chegando à sala do servidor, encontra o terminal principal e pluga o pendrive na primeira entrada que vê.\n" +
                        "Por um instante, um silencio ensurdecedor se instaura mas por pouco tempo. Um chiado branco e constante começa a ecoar. \n" +
                        "Baixo no início, mas a cada instante que se passe ele aumenta, mais perto e mais intenso.");
        put("pieceOne.precombat.success.2",
                "O chiado cresce, preenchendo o corredor, engolindo todos os outros sons. Sua pele arrepia. Você sente antes de ver.");
        put("pieceOne.precombat.sucess.3",
                "Ela veio ao seu encontro.");

        put("pieceOne.precombat.default",
                "Você corre pelos corredores da fortaleza com o pendrive apertado na mão. Cada segundo parece uma eternidade,\n" +
                        " enquanto o som violento de luta ecoa pelas paredes de concreto.");
        put("pieceOne.precombat.failure",
                "Então um silêncio abissal desce sobre a fortaleza. Você hesita por um segundo, mas mordendo os lábios se força a continuar.\n" +
                        "Quando chega a passos da sala do servidor, um líquido pegajoso e viscoso começa a escorrer da tubulação acima da porta.\n" +
                        " Antes que você possa reagir, uma abertura se forma — um círculo perfeito sendo cortado no metal com precisão cirúrgica.\n" +
                        "De dentro da abertura, algo despenca. Um corpo.\n" +
                        "O cadáver de Lena, coberto por uma gosma roxa, e viscosa que caí continuamente até formar um cubo perfeito.\n");
        put("pieceOne.precombat.failure.2",
                "\n" +
                        "Seu rosto ainda conserva uma expressão de horror. A gosma escorre de suas roupas rasgadas. Um arrepio gelado percorre sua espinha.\n" +
                        "Lena não foi o suficiente...e está sendo absorvida...");
        put("directCombat.init",
                "INICIO COMBATE - DANTE VS GULA\n" +
                        "A criatura se aproxima lentamente.\n" +
                        "Seu núcleo roxo pulsa no escuro.\n" +
                        "Está na hora.");

        put("finalCombat.init",
                "LUTA FINAL - DANTE VS GULA (CORROMPIDA)\n" +
                        "Agora desestabilizada pelo pen drive.\n" +
                        "Ela está fraca... mas ainda perigosa.");

        put("combat.initiative", ">> INICIATIVA: Dante [%d] vs Gula [%d]");
        put("combat.danteFirst", ">> O núcleo de Gula pisca! Você vê uma fraqueza!\n>> Dante começa a correr em direção à inimiga!");
        put("combat.gulaFirst", ">> Gula percebe seu alívio!\n>> Ela avança em sua direção com tudo que tem!");

        put("combat.turn", ">> TURNO [%d]");
        put("combat.health", ">> Dante: [%d/%d] | Gula: [%d/%d]");
        put("combat.diceRoll", ">> Seu dado: [%s]");
        put("combat.enemyDiceRoll", ">> Dado de Gula: [%s]");
        put("combat.tie", ">> Empate! Rolando novamente...");
        put("combat.attackRoll", ">> Dado de ataque: [%d] vs Defesa de Gula: [%d]");

        put("dante.simpleAttack.success", "Dante avança com cautela e golpeia Gula com o cano de metal, acertando partes instáveis!");
        put("dante.simpleAttack.failure", "Dante tenta atacar, mas hesita no último instante. O golpe passa perto sem causar dano.");

        put("dante.desperateAttack.success",
                "Dante percebe a instabilidade e avança sem pensar! Com força total, ele gira o cano acima da cabeça e desfere um golpe horizontal brutal!");
        put("dante.desperateAttack.failure",
                "Dante tenta atingir em cheio, mas Gula se desfaz em gosma escura. O golpe apenas atravessa energia instável!");

        put("dante.gunshot.success", "Dante estabiliza a respiração e aponta a pistola para o núcleo de Gula. O disparo acerta em cheio!");
        put("dante.gunshot.failure", "Dante tenta atirar, mas as luzes piscam agressivamente. Seu disparo apenas atravessa uma parte instável.");

        put("combat.damageDealt", ">> Gula perdeu [%d] pontos de vida!");
        put("combat.failedAttack", ">> FALHA NO ATAQUE!");

        put("gula.laserAttack.success", "O núcleo de Gula pulsa violentamente! Uma descarga roxa escapa e atinge você brutalmente!");
        put("gula.laserAttack.failure", "A energia oscila descontrolada. O disparo explode contra o cenário antes de alcançá-lo.");

        put("gula.tentaclesAttack.success", "Partes do corpo de Gula se abrem violentamente! Tentáculos instáveis emergem e atingem você com brutalidade!");
        put("gula.tentaclesAttack.failure", "Os tentáculos avançam descontrolados, atingindo paredes. A instabilidade faz os ataques perderem precisão!");

        put("gula.finalAttack", "Gula para completamente! Seu núcleo começa a pulsar agressivamente! Uma gigantesca descarga roxa explode em sua direção!");

        put("combat.damageTaken", ">> Você perdeu [%d] pontos de vida!");
        put("combat.avoided", ">> Você conseguiu esquivar!");

        put("combat.gulasTurn", ">> TURNO DE GULA");

        put("victory.start", "\n========== VITÓRIA ==========\n");
        put("victory.narrative",
                "Gula recua pela primeira vez.\n" +
                        "Seu núcleo pisca violentamente enquanto partes de seu corpo perdem forma.\n" +
                        "O brilho roxo que preenchia tudo começa a enfraquecer.\n" +
                        "\nDante respira com dificuldade.\n" +
                        "Seu corpo dói.\n" +
                        "Suas mãos tremem.\n" +
                        "Mas ele continua avançando.\n" +
                        "\nA criatura tenta se recompor uma última vez.\n" +
                        "Distorcendo sua estrutura em formas impossíveis.\n" +
                        "Tarde demais.\n" +
                        "\nDante ergue o cano de metal acima da cabeça.\n" +
                        "Com toda a força que ainda resta... ele atravessa o núcleo de Gula.\n" +
                        "\nPor um instante...\n" +
                        "silêncio.\n" +
                        "\nEntão a criatura inteira começa a colapsar.\n" +
                        "A energia roxa explode pelo ambiente.\n" +
                        "As paredes tremem violentamente.\n" +
                        "Os tentáculos desaparecem.\n" +
                        "As luzes se apagam.\n" +
                        "\nE Gula finalmente deixa de existir.\n" +
                        "\nDante permanece parado diante dos restos da criatura.\n" +
                        "Tentando recuperar o ar.\n" +
                        "\nPela primeira vez em muito tempo...\n" +
                        "o silêncio parece seguro.\n" +
                        "\nFIM - O LEGADO DE GULA");

        put("defeat.start", "\n========== DERROTA ==========\n");
        put("defeat.narrative",
                "Dante tenta permanecer de pé.\n" +
                        "Seu corpo falha.\n" +
                        "O calor das queimaduras atravessa sua pele.\n" +
                        "A instalação inteira pisca ao redor dele.\n" +
                        "\nGula se aproxima lentamente.\n" +
                        "Sem pressa.\n" +
                        "Sem hesitação.\n" +
                        "Seu núcleo pulsa de forma pesada.\n" +
                        "Iluminando o corredor escuro com uma luz roxa instável.\n" +
                        "\nDante tenta erguer a arma mais uma vez.\n" +
                        "Mas seus braços não respondem.\n" +
                        "\nA criatura para diante dele.\n" +
                        "Por um breve instante...\n" +
                        "o brilho do núcleo reflete diretamente em seus olhos.\n" +
                        "\nEntão...\n" +
                        "tentáculos de energia atravessam seu corpo violentamente.\n" +
                        "O cano de metal cai no chão.\n" +
                        "A pistola desliza para longe.\n" +
                        "\nAs luzes da instalação começam a falhar uma última vez.\n" +
                        "\nE tudo desaparece em roxo.");
    }};

    public String getThirdAct(String key) {return thirdAct.get(key);}
}
