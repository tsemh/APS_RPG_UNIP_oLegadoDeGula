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
        put("pieceOne.precombat.success.3",
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
                        "Seu rosto ainda conserva uma expressão de horror. A gosma escorre de suas roupas rasgadas. Um arrepio gelado percorre sua espinha.\n" +
                        "Lena não foi o suficiente...e está sendo absorvida...");

        put("pieceOne.directcombat",
                "Seu coração disparado pelo susto começa a se acalmar quando a mulher some de sua visão, a saída da nevoa já está a vista\n" +
                        "olhando para baixo você percebe que está pisando em uma gosma arroxeada.");
        put("pieceOne.directcombat.initiative.failure",
                "Por um instante, aquilo parece apenas viscoso… inofensivo.");
        put("pieceOne.directcombat.initiative.failure.2",
                "Então a superfície sob seus pés pulsa.");
        put("pieceOne.directcombat.initiative.failure.3",
                "A gosma se move como um organismo vivo, subindo lentamente pelas suas botas antes que você consiga reagir. O chão inteiro \n" +
                        "se ergue em silêncio, formando uma parede translúcida de matéria púrpura. Dentro dela, flutuando como um olho enterrado\n" +
                        "em carne líquida, um orbe negro se vira na sua direção.");
        put("pieceOne.directcombat.initiative.failure.4",
                "Você tenta recuar, mas já é tarde.");
        put("pieceOne.directcombat.initiative.failure.5",
                "O cubo colossal avança de uma vez, engolindo sua passagem em um movimento lento e inevitável. A substância gelatinosa envolve seu corpo\n" +
                        " com um frio sufocante, queimando sua pele enquanto o orbe escuro pulsa bem diante do seu rosto, como se estivesse observando cada pensamento seu.");
        put("pieceOne.directcombat.initiative.success",
                "Algo está errado.");
        put("pieceOne.directcombat.initiative.success.2",
                "A substância vibra sob seus pés, formando pequenas ondas que se espalham pelo chão. Seu instinto grita antes mesmo que sua mente compreenda.\n" +
                        " Você ergue o olhar a tempo de ver a névoa diante de você se deformar.");
        put("pieceOne.directcombat.initiative.success.3",
                "Um enorme cubo translúcido emerge do corredor, silencioso e grotesco. No centro da massa gelatinosa, um orbe negro flutua lentamente, encarando\n" +
                        " você como uma pupila viva aprisionada dentro daquela criatura púrpura.");
        put("pieceOne.directcombat.initiative.success.4",
                "No exato instante em que o monstro avança, você se joga para trás por puro reflexo. A massa gelatinosa passa raspando por você, deixando um rastro\n" +
                        "fumegante no chão de pedra.");
        // HABILIDADES DA PISTOLA - SUCESSO
        put("combat.pistola.success1", "Você estabiliza a respiração por um breve instante e aponta a pistola diretamente para o núcleo da GULA.\nO disparo atravessa o céu como um clarão seco, atingindo o centro da criatura e fazendo seu corpo se distorcer violentamente.");
        put("combat.pistola.success2", "Você desliza para o lado enquanto ergue rapidamente a pistola.\nSem parar o movimento, ele dispara diretamente contra o núcleo rachado da GULA.\nO tiro atravessa a energia instável da criatura, causando uma ruptura violenta em parte de sua estrutura.");
        put("combat.pistola.success3", "Você dispara rapidamente contra a GULA, acertando partes dispersas de seu corpo.\nO impacto faz pequenas ondas de energia roxa se espalharem pelo ar.");
        put("combat.pistola.success4", "Em um ataque de desespero, Você dispara repetidamente contra a GULA!\nAs balas perfuram a criatura de todos os lados, causando dano massivo!");

// HABILIDADES DA PISTOLA - FALHA
        put("combat.pistola.failure1", "No momento do disparo, o céu escurece por um instante.\nSua mira se perde por um segundo, e o tiro atravessa apenas uma parte instável do corpo da criatura sem causar dano significativo.");
        put("combat.pistola.failure2", "Você tenta atirar em movimento, mas a GULA distorce o ar ao redor com uma descarga elétrica repentina.\nO disparo perde precisão e atravessa apenas sombras e partículas da criatura.");
        put("combat.pistola.failure3", "Você tenta atirar sob pressão, mas a movimentação irregular da criatura faz o disparo errar completamente.\nO som do tiro ecoa pelo campo aberto enquanto a GULA continua avançando lentamente.");
        put("combat.pistola.failure4", "O desespero atrapalha a mira! Os disparos saem descontrolados e nenhum acerta o alvo.");

// HABILIDADES DA PISTOLA - ERRO CRÍTICO
        put("combat.pistola.criticalError1", "Você tenta mirar, mas sua mão treme e a arma falha no momento crítico!\nA pistola faz um barulho seco e o tiro sai em uma direção errada, ricocheteando no chão perto de você!");
        put("combat.pistola.criticalError2", "Ao tentar atirar em movimento, você tropeça em uma pedra e o disparo sai acidentalmente contra você mesmo!");
        put("combat.pistola.criticalError3", "Sob pressão, você puxa o gatilho com força, mas a arma escorrega da sua mão e dispara contra você!");
        put("combat.pistola.criticalError4", "No desespero, você atira sem mirar, mas o recuo faz a arma bater no seu rosto causando dano!");

// HABILIDADES DA BARRA DE METAL - SUCESSO
        put("combat.barra.success1", "Você avança sem hesitar, agarra o oponente com força e desce o cano de metal contra seu corpo em um golpe seco e brutal.");
        put("combat.barra.success2", "Sem técnica ou hesitação, você avança usando o que tiver à mão, desferindo golpes caóticos e imprevisíveis contra o alvo.");
        put("combat.barra.success3", "Avança contra o alvo, desliza por baixo dele e desfere um golpe rápido em movimento.");
        put("combat.barra.success4", "Salta e desfere um golpe poderoso no centro da criatura.");

// HABILIDADES DA BARRA DE METAL - FALHA
        put("combat.barra.failure1", "Você tenta atacar, mas a criatura flutua para trás rapidamente e o golpe passa raspando.");
        put("combat.barra.failure2", "Seus golpes são rápidos, mas imprecisos. A criatura consegue desviar de todos.");
        put("combat.barra.failure3", "Você desliza, mas perde o equilíbrio no momento do golpe. O ataque não acerta.");
        put("combat.barra.failure4", "Você pula para desferir o golpe, mas erra o timing e cai desajeitadamente no chão.");

// HABILIDADES DA BARRA DE METAL - ERRO CRÍTICO
        put("combat.barra.criticalError1", "Você avança com tudo, mas seu pé escorrega na grama e você cai com o próprio peso em cima do cano de metal!");
        put("combat.barra.criticalError2", "Seus movimentos descoordenados fazem com que você acerte uma rocha e se machuque com o impacto!");
        put("combat.barra.criticalError3", "Ao deslizar, você perde o controle e bate com a cabeça no chão violentamente!");
        put("combat.barra.criticalError4", "Você salta, mas falha completamente e cai de mau jeito, se machucando na queda!");

// ATAQUES DA GULA
        put("combat.gula.laserAttack", "O núcleo da GULA brilha intensamente.\nSem qualquer hesitação, uma descarga colossal de energia atravessa o céu em linha reta, queimando a vegetação e marcando o solo até atingir violentamente o alvo.");
        put("combat.gula.tentacleAttack", "A estrutura da GULA se movimenta de maneira antinatural enquanto enormes tentáculos de energia emergem silenciosamente de seu corpo.\nAs extensões atingem o alvo com violência brutal, espalhando energia roxa por todo o campo de batalha.");
        put("combat.gula.finalDischarge", "A GULA interrompe completamente seus movimentos.\nO céu inteiro começa a escurecer em perfeita sincronia com o núcleo da criatura.\nO chão vibra.\nO ar parece pesado.\nEntão, uma descarga colossal de energia atravessa toda a região como se estivesse apagando o próprio horizonte.");
        put("combat.gula.consumoEnergia", "O céu escurece repentinamente. O vento para. Uma energia invisível é drenada do ambiente e de tudo ao redor, inclsuive você. Essa energia vai diretamente para o núcleo da GULA.\nSeu corpo aumenta lentamente de tamanho enquanto ferimentos desaparecem quase instantaneamente.");
        put("combat.gula.specialAttack", "\nGula concentra energia em seu núcleo!\nUma onda de choque atravessa o campo aberto antes mesmo que Elodin possa reagir!");
        put("combat.gula.success", "O ataque da criatura acerta em cheio!");
        put("combat.gula.failure", "Por pouco, você consegue rolar para o lado e desviar do ataque!");
        put("combat.gula.criticalError", "A instabilidade da criatura faz o ataque sair completamente errado!\nGula se machuca com sua própria energia!");

// ESQUIVA E ÚLTIMO FÔLEGO
        put("combat.dodge.success", "Você se joga no chão no último instante!\nO ataque passa sobre sua cabeça, mas você consegue escapar ileso!");
        put("combat.dodge.failure", "Você tenta desviar, mas seus movimentos estão lentos demais!\nO ataque acerta em cheio!");

        // VITÓRIA
        put("combat.victory.2",
                "Gula recua pela primeira vez. Seu núcleo pulsante treme violentamente, emitindo um som agudo e doloroso.\n" +
                        "Partes de seu corpo amorfo começam a perder forma, se dissolvendo no ar como fumaça.\n" +
                        "O brilho roxo que antes preenchia toda a instalação começa a enfraquecer...");
        put("combat.victory.3",
                "Elodin respira com dificuldade. Seus pulmões queimam. Seus braços tremem. Seu corpo inteiro pede para cair.\n" +
                        "Mas ele permanece de pé.");
        put("combat.victory.4",
                "Gula tenta se recompor uma última vez. Sua estrutura se distorce em formas cada vez mais instáveis,\n" +
                        "como se a própria existência da criatura estivesse se desfazendo.");
        put("combat.victory.5",
                "Elodin não hesita. Ele avança. O cano de metal sobe acima de sua cabeça.\n" +
                        "Com toda a força que ainda resta em seu corpo exausto...\n" +
                        "Ele desfere o golpe final diretamente no núcleo da criatura.\n\n" +
                        "O impacto ecoa como um trovão abafado.");
        put("combat.victory.6",
                "Por um instante... silêncio absoluto.\n\n" +
                        "Então a criatura inteira começa a colapsar. Rachaduras de luz roxa percorrem seu corpo como vidro quebrando.\n" +
                        "A energia acumulada explode pelo ambiente em ondas sufocantes.");
        put("combat.victory.7",
                "As paredes de concreto tremem. Os cabos de energia se rompem. Faíscas voam por todos os lados.\n" +
                        "Os tentáculos que antes ameaçavam tudo agora se retraem, se desfazem, desaparecem.");
        put("combat.victory.8",
                "As luzes da instalação se apagam uma por uma. Como se o próprio prédio estivesse exalando seu último suspiro.\n\n" +
                        "E então... silêncio novamente.");
        put("combat.victory.9",
                "Gula finalmente deixou de existir.\n\n" +
                        "Elodin permanece parado em meio aos destroços. O cano de metal ainda está em sua mão, agora frio e pesado.\n" +
                        "Ele tenta recuperar o fôlego. Cada respiração é uma batalha.");
        put("combat.victory.10",
                "Pela primeira vez em muito tempo... o silêncio parece seguro.\n\n" +
                        "Ele venceu.");

// DERROTA
        put("combat.defeat.2",
                "Elodin tenta permanecer de pé. Suas pernas cedem. Seus joelhos se dobram.\n" +
                        "O peso do próprio corpo é demais para suportar agora.");
        put("combat.defeat.3",
                "Ele cai de joelhos no chão frio e úmido. O calor das queimaduras atravessa sua pele como fogo lento.\n" +
                        "Sangue escorre de feridas que ele nem sentiu abrirem.");
        put("combat.defeat.4",
                "A instalação inteira pisca ao redor dele. Luzes alternam entre o brilho fraco e a escuridão total.\n" +
                        "Como se o local estivesse morrendo junto com ele.");
        put("combat.defeat.5",
                "Gula se aproxima lentamente. Sem pressa. Sem hesitação. Sem piedade.\n\n" +
                        "Seu núcleo pulsa de forma pesada e ritmada, iluminando o corredor escuro com uma luz roxa instável que dança nas paredes.");
        put("combat.defeat.6",
                "Cada pulsação parece ecoar dentro do peito de Elodin.\n\n" +
                        "Ele tenta erguer a arma mais uma vez. Seus dedos se recusam a obedecer.\n" +
                        "Os braços não respondem. Os músculos já não existem. Apenas dor. Apenas cansaço.");
        put("combat.defeat.7",
                "A criatura para diante dele. Tão perto que ele pode sentir a energia estática que emana de seu núcleo.\n" +
                        "Seus cabelos se erguem. Sua pele formiga.");
        put("combat.defeat.8",
                "Por um breve instante... o brilho roxo do núcleo reflete diretamente em seus olhos.\n" +
                        "Elodin encara a própria morte refletida naquela luz.");
        put("combat.defeat.9",
                "Então... tentáculos de energia atravessam seu corpo violentamente.\n" +
                        "Não há dor. Apenas um frio intenso que se espalha de dentro para fora.\n" +
                        "Como se algo estivesse sendo arrancado de sua alma.");
        put("combat.defeat.10",
                "O cano de metal escorrega de seus dedos. O som do metal contra o chão ecoa pelo corredor vazio.\n" +
                        "A pistola que estava em sua cintura desliza para longe, desaparecendo na escuridão.");
        put("combat.defeat.11",
                "As luzes da instalação começam a falhar uma última vez. Uma a uma. Como velas sendo apagadas pelo vento.");
        put("combat.defeat.12",
                "O corpo de Elodin desaba no chão. Seus olhos ainda estão abertos, mas já não veem nada.\n\n" +
                        "O silêncio volta a dominar o local. Apenas o pulsar lento e pesado do núcleo de Gula ecoando na escuridão.");
        put("combat.defeat.13",
                "E tudo desaparece em roxo.");
    }};

    public String getThirdAct(String key) {return thirdAct.get(key);}
}
