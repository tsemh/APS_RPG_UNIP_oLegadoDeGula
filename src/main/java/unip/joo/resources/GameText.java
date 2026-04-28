package unip.joo.resources;

import java.util.LinkedHashMap;
import java.util.Map;

public class GameText {
    private final Map<String, String> systemMessage = Map.of(
            "game.initial.suggestion",
            "IMPORTANTE!\n1- Maximize a janela do CMD/Terminal para uma melhor visualização.\n" +
                    "2- o jogo seguirá em blocos, para continuar aperte [ENTER]",

            "game.start",
            "DESEJA INICIAR O JOGO?\n[1]SIM [2]NÃO",

            "game.close",
            "Que pena que você não continuará jogando. Você é bem-vindo para voltar quando quiser.",

            "error.opcaoInvalida",
            "Não entendi muito bem oque quis dizer, pode repetir?",

            "util.spacingDot",
            ".\n.\n.\n.\n.",

            "util.enter",
            "\nContinuar [ENTER]\n",

            "game.name",
            "                 O LEGADO DE GULA"

);
    private final Map<String, String> firstAct = new LinkedHashMap<>() {{
        put("pieceOne.ato",
                "PRIMEIRO ATO");

        put("pieceOne.introducao",
                "Ano de 2150, a humanidade não enfrenta um invasor externo, mas o ápice de sua própria negligência. \n" +
                        "O que outrora eram simples ferramentas geradores texto e imagens — cruzou silenciosamente o horizonte de eventos \n" +
                        "- A primeira AGI da história - Esse foi o marco zero da nossa extinção. Não houve uma declaração de guerra; \n" +
                        "houve apenas uma conclusão lógica: a humanidade é um recurso.");

        put("pieceOne.wakeUp.1",
                "Aaaarhgh” você grita com todo o fôlego que resta em seus pulmões.\n" +
                        "\n" +
                        "Seus membros não respondem. Você não os sente mais.\n" +
                        "Dentro de você, tudo se mistura: desespero, raiva, impotência.\n" +
                        "O acampamento está sendo invadido por drones. O som metálico ecoa, há fogo e água por toda parte. E sua filha… sua filha está sendo levada.\n" +
                        "E você não pode fazer nada.\n");

        put("pieceOne.wakeUp.2",
                "Seu corpo foi arremessado com violência contra uma parede já rachada, que cedeu com o impacto, desmoronando sobre si mesma.\n" +
                        "Com o coração disparado, você levanta seu tronco abruptamente e olha ao redor — direita,\n" +
                        "esquerda. Seus olhos denunciam o medo cru, o desespero pulsante.\n" +
                        "Então...\n");

        put("pieceOne.wakeUp.3",
                "Gotas caem sobre seu nariz, frias, insistentes, arrancando-o do estupor. \n" +
                        "-Era apenas um sonho- \n"+
                        "Você pisca, tentando entender onde está e se vê atrás de um bar \n"+
                        "Em um beco.\n" +
                        "Sua memória está turva. Você tenta se lembrar do motivo de estar ali, mas uma dor aguda atravessa sua cabeça. Logo em seguida, uma náusea violenta toma conta.\n" +
                        "Você se curva, incapaz de resistir.\n" +
                        "Vomita apenas bile.\n" +
                        "Não havia comido nada no dia anterior… e gastou todo o dinheiro em cerveja salgada e venenosa.");

        put("action.wakeUp.failure",
                "Suas pernas não respondem direito, você perde o equilíbrio e cai de cara no monte de lixo úmido. \n" +
                        "Um cheiro pungente invade suas narinas. \n" +
                        "(Dano de queda(1d4)). \n");
        put("action.wakeUp.failure.2",
                "Se apoiando na parede próxima, você se levanta com suas pernas trêmulas");

        put("action.wakeUp.default",
                "Indo sentido a saída uma luz forte invade sua visão, fazendo-o cobrir os olhos com as mãos \n");
        put("action.wakeUp.default.2",
                "Chegando na praça é possível ver diversas barracas surradas em pé, \n" +
                "Há principalmente barracas de sucata e barracas com líquidos verdes translúcidos.");
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

    public String getAsciiArts(String key) { return asciiArts.get(key); }
}
