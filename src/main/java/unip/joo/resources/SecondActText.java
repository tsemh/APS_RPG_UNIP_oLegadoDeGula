package unip.joo.resources;

import java.util.LinkedHashMap;
import java.util.Map;

public class SecondActText {
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
    public String getSecondAct(String key) {return secondAct.get(key);}
    public Map getAllSecondsAct(){return secondAct;}
}
