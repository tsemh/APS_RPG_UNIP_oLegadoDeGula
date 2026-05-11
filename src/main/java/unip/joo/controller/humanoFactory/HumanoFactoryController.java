package unip.joo.controller.humanoFactory;

import unip.joo.controller.elodin.ClasseController;
import unip.joo.model.ENUM.Sexo;
import unip.joo.model.entities.Humano;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HumanoFactoryController { // Classe Controladora de Fábrica
    private InventoryFactoryController inventoryController = new InventoryFactoryController();
    private ClasseController classeController = new ClasseController();

    public Humano createDante() { // Criação de objetos (Fábrica)
        String nome = "Dante";

        return new Humano(
                Sexo.MASCULINO,
                false,
                nome,
                "Descrição Dante",
                classeController.createClasse(),
                falaDante(nome),
                500L,
                inventoryController.createInventoryDante(500L)
        );
    }
    public Humano createJonas() {
        String nome = "Jonas";
        return new Humano(
                Sexo.MASCULINO,
                false,
                nome,
                "Descrição Jonas",
                classeController.createClasse(),
                falaJonas(nome),
                501L,
                inventoryController.createInventory(501L)
        );
    }
    public Humano createSimmom() {
        String nome = "Simmom";
        return new Humano(
                Sexo.MASCULINO,
                false,
                nome,
                "Descrição Simmom",
                classeController.createClasse(),
                falaSimmom(nome),
                502L,
                inventoryController.createInventory(502L)
        );
    }
    public Humano createBeggar() {
        String nome = "Mendigo";
        return new Humano(
                Sexo.MASCULINO,
                false,
                nome,
                "Descrição Mendigo",
                classeController.createClasse(),
                falaBeggar(nome),
                503L,
                inventoryController.createInventory(503L)
        );
    }
    public Humano createLena() {
        String nome = "Lena";
        return new Humano(
                Sexo.FEMININO,
                false,
                nome,
                "Descrição Lena",
                classeController.createClasse(),
                falaLena(nome),
                504L,
                inventoryController.createInventory(504L)
        );
    }

    private Map<String, String> falaDante(String nome) {
        Map<String, String> dialogue = new HashMap<>();
        String p = "<" + nome + ">: ";

        dialogue.put("init.one", p + "Ressaca e tanto hein");
        dialogue.put("init.two", p + "Hmmm...ou...não foi só bebida?");
        dialogue.put("init.three", p + "Bem, quem sou eu pra me meter, o que te traz aqui?");

        dialogue.put("choice.one.one", p + "Acabou. Só não caiu ainda.");
        dialogue.put("choice.one.two", p + "A gente vive de resto. Do que ela quer...ou ainda não viu");
        dialogue.put("choice.one.three", p + "Mas quando ela encontrar...pelo seu olhar, você já sabe");
        dialogue.put("choice.one.four", p + "Esse lugar não esquece, só aprendemos a seguir em frente");
        dialogue.put("choice.one.five", p + "Bebendo?");
        dialogue.put("choice.one.six", p + "Isso nunca funciona... Só te deixa mais lento, e ser lento por aqui não é uma boa ideia...");

        dialogue.put("choice.two.one", p + "...Hoje? Quase nada.");
        dialogue.put("choice.two.two", p + "Vai comprar algo? não tenho tempo pra perder");
        dialogue.put("choice.two.three", p + "Você chegou tarde… não foi culpa sua...Aqui, ninguém chega na hora certa.");
        dialogue.put("choice.two.four", p + "Parece estar sempre um passo atrás de alguma coisa?");
        dialogue.put("choice.two.five", p + "Impressionante, e continua bebendo.");
        dialogue.put("final.one", p + "Não piorando já é lucro...");
        dialogue.put("final.two", p + "Mas ainda dá pra continuar.");
        dialogue.put("final.three", p + "Se precisar… aparece.");

        return dialogue;
    }
    private Map<String, String> falaJonas(String nome) {
        Map<String, String> dialogue = new HashMap<>();
        String p = "<" + nome + ">: ";

        dialogue.put("init.one", p + "Que noite hein.");
        dialogue.put("choice.one.one", p + "…Depois da inspeção dos drones, isso aqui é quase tudo que sobrou.");
        dialogue.put("choice.one.two", p + "Mas pelo jeito… você precisa mais do que eu.");
        dialogue.put("choice.one.three", p + "Come antes de cair.");
        dialogue.put("choice.one.four", p + "Você tá com olhar de quem não dorme… mesmo quando apaga.");
        dialogue.put("choice.one.five", p + "Então é isso que tá te puxando pra baixo.");
        dialogue.put("choice.one.six", p + "Nunca adianta...Só embaralha.");
        dialogue.put("choice.one.seven", p + "E quando precisa pensar… você não consegue.");
        dialogue.put("choice.one.eight", p + "Começa pelo básico.");
        dialogue.put("choice.one.nine", p + "Come. Fica de pé...Depois decide o que fazer com a cabeça.");

        dialogue.put("choice.two.one", p + "Tempo… é coisa rara por aqui.");
        dialogue.put("choice.two.two", p + "Se parar muito, você afunda.");
        dialogue.put("choice.two.three", p + "Mas pensar não é ruim...");
        dialogue.put("choice.two.four", p + "Só não pode virar desculpa para continuar se destruindo.");
        dialogue.put("choice.two.five", p + "Então começa simples.");
        dialogue.put("choice.two.six", p + "Come. Depois pensa...Sobreviver vem primeiro.");

        dialogue.put("final.one", p + "Se eu ainda estiver aqui, vai ter algo quente pra você.");
        dialogue.put("final.two", p + "Agora vai… antes que essa ressaca te derrube de novo.");

        return dialogue;
    }

    private Map<String, String> falaSimmom(String nome) {
        Map<String, String> dialogue = new HashMap<>();
        String p = "<" + nome + ">: ";

        dialogue.put("init.one", p + "Olha só… você de novo?");
        dialogue.put("init.two", p + "Veio aqui ontem, saiu daqui direto pro bar da esquina.");
        dialogue.put("init.three", p + "Vai querer o quê hoje?...Álcool já acabou, você acabou com meu estoque ontem.");

        dialogue.put("choice.one.one", p + "Tenho, deixe-me ver aqui.");
        dialogue.put("choice.one.two", p + "Pronto, achei. O melhor que vai encontrar, mas ainda não faz milagre.");
        dialogue.put("choice.one.three", p + "Isso aqui é um chá. Amargo pra caramba mas resolve...ao menos na maioria dos casos");
        dialogue.put("choice.one.four", p + "Resolve! Diferente do que você andou tomando por aí.");
        dialogue.put("choice.one.five", p + "Isso limpa a cabeça.");

        dialogue.put("choice.two.one", p + "Depende, forte pra que?");
        dialogue.put("choice.two.two", p + "Não disse que você acabou com tudo ontem?");
        dialogue.put("choice.two.three", p + "Se for desmaiar denovo, que seja ao menos numa fossa, fede men...");

        return dialogue;
    }

    private Map<String, String> falaBeggar(String nome) {
        Map<String, String> dialogue = new LinkedHashMap<>();
        String p = "<" + nome + ">: ";

        dialogue.put("speech.1", p + "ACORDEM!");

        dialogue.put("speech.2", p + "Vocês vão continuar olhando pro chão até quando?");
        dialogue.put("speech.3", p + "Até não sobrar mais nada?");

        dialogue.put("speech.4", p + "Mesmo sem recurso… a gente ainda tá aqui.");
        dialogue.put("speech.5", p + "E enquanto tiver gente de pé… ainda dá pra lutar.");

        dialogue.put("speech.6", p + "Ela não é um deus.");
        dialogue.put("speech.7", p + "Não é indestrutível.");
        dialogue.put("speech.8", p + "É uma máquina.");

        dialogue.put("speech.9", p + "E toda máquina quebra.");
        dialogue.put("speech.10", p + "Vocês veem isso todo dia.");
        dialogue.put("speech.11", p + "Drones caem.");
        dialogue.put("speech.12", p + "Falham.");
        dialogue.put("speech.13", p + "Queimam.");

        dialogue.put("speech.14", p + "Por que com a GULA seria diferente?");

        dialogue.put("speech.15", p + "Ou vocês já aceitaram ser resto?");
        dialogue.put("speech.16", p + "Vocês sabem o que ela faz.");
        dialogue.put("speech.17", p + "Os experimentos.");
        dialogue.put("speech.18", p + "Gente sumindo.");

        dialogue.put("speech.19", p + "Corpos virando… coisa.");
        dialogue.put("speech.20", p + "Lixo.");

        dialogue.put("speech.21", p + "Se a gente não reage… é isso que a gente vira.");

        dialogue.put("speech.22", p + "Mas ninguém aqui precisa desistir.");
        dialogue.put("speech.23", p + "Ninguém.");

        dialogue.put("speech.24", p + "A humanidade nunca desistiu.");
        dialogue.put("speech.25", p + "Nos piores momentos… a gente se juntou.");
        dialogue.put("speech.26", p + "A gente lutou.");

        dialogue.put("speech.27", p + "E agora?");
        dialogue.put("speech.28", p + "Agora a gente para?");

        dialogue.put("speech.29", p + "Por causa de uma criação nossa?");
        dialogue.put("speech.30", p + "Vamos virar vítima da própria genialidade?");

        dialogue.put("speech.31", p + "Se uma pessoa criou…");
        dialogue.put("speech.32", p + "Uma pessoa pode destruir.");

        dialogue.put("speech.33", p + "Mas não vai ser sozinho.");

        dialogue.put("speech.34", p + "Ou a gente levanta…");
        dialogue.put("speech.35", p + "Ou a gente desaparece.");

        return dialogue;
    }

    private Map<String, String> falaLena(String nome) {
        Map<String, String> dialogue = new LinkedHashMap<>();
        String p = "<" + nome + ">: ";

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.1",
                "<???>: " + "...Você entrou sem máscara.");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.2",
                "<???>: " + "Ou é burro… ou não teve escolha.");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.3",
                "<???>: " + "Entendi.");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.4",
                "<???>: " + "Então você é do tipo que observa antes de falar.");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.5",
                "<???>: " + "Lena.");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.6",
                p + "E antes que pergunte, não, eu não confiei em você.");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.7",
                p + "Eu só achei que você ia morrer rápido demais pra ser uma ameaça.");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.8",
                p + "Porque aqui dentro...");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.9",
                p + "quem se move sozinho... geralmente não é gente.");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.10",
                p + "Ela Mata o que sobra.");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.11",
                p + "Ela controla fluxo.");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.11.1",
                p + "Energia.");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.11.2",
                p + "Movimento.");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.11.3",
                p + "Informação.");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.12",
                p + "E tudo que interfere nisso...");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.13",
                p + "ela remove.");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.14",
                p + "Não.");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.15",
                p + "Ela não controla ninguém, ela otimiza.");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.16",
                p + "Se você atrasa o sistema, você vira ruído.");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.17",
                p + "É eliminado.");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.18",
                p + "Ou reaproveitado como peça.");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.19",
                p + "Eram variáveis que deixaram de ser úteis.");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.20",
                p + "E a GULA não guarda coisa inútil.");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.21",
                p + "(baixo, tensa) ...Não se mexe.");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.22",
                p + "Pronto...Agora ela sabe que você tá aqui.");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.23",
                p + "E quando ela percebe algo fora do fluxo... ela não ignora");

        dialogue.put("thirdAct.lena.penDrive.one",
                p + "Você não pode tentar matar ela, você tem que restaurar ela!");

        dialogue.put("thirdAct.lena.penDrive.two",
                p + "Corra até a sala dos servidores e coloque esse PEN DRIVE em um servidor roxo!");

        dialogue.put("thirdAct.lena.penDrive.three",
                p + "Corra, sua vida e talvez o resto da vida de todos nesse mundo, dependem disso!");

        return dialogue;
    }
}
