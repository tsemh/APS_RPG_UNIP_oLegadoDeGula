package unip.joo.controller.elodin;

import unip.joo.model.ENUM.Sexo;
import unip.joo.model.entities.Humano;

import java.util.HashMap;
import java.util.Map;

public class HumanoController { // Classe Controladora
    private ClasseController classe =  new ClasseController();
    private InventoryController inventoryFactory = new InventoryController();

    public Humano createElodin() { // Método Construtor de objetos via controller
        String nome = "Elodin";
        long id = 100L;
        return new Humano(
                Sexo.MASCULINO,
                true,
                nome,
                "Descrição protagonista",
                classe.createClasse(),
                falaElodin(nome),
                id,
                inventoryFactory.createInventory(id)
                );
    }

    private Map<String, String> falaElodin(String nome) {
        Map<String, String> dialogue = new HashMap<>();
        String p = "<" + nome + ">: ";

        dialogue.put("firstAct.pieceOne.lixo",
                p + "Argh merda, eu não devia ter misturado aquele lixo todo.");

        dialogue.put("firstAct.pieceOne.claridade",
                p + "Céus, que claridade");

        dialogue.put("firstAct.pieceTwo.scrap.choice",
                "[1] Como vocês ainda conseguem viver aqui? Com a GULA levando tudo… isso aqui devia ter acabado faz tempo.\n" +
                        "[2] O que você tem pra mim?");

        dialogue.put("firstAct.pieceTwo.scrap.one.one",
                p + "...Sim");

        dialogue.put("firstAct.pieceTwo.scrap.one.two",
                p + "E se eu quiser esquecer?");

        dialogue.put("firstAct.pieceTwo.scrap.two.one",
                p + "…Talvez");

        dialogue.put("firstAct.pieceTwo.scrap.final.one",
                p + "isso nunca vai melhorar? toda essa droga.");

        dialogue.put("firstAct.pieceTwo.food.choice",
                        "[1] Estou com fome… tem algo velho por ai? não vou mentir, não tenho nada para dar em troca.\n" +
                        "[2] Eu tô meio perdido… sem rumo. Talvez eu só precise de um tempo pra pensar.");

        dialogue.put("firstAct.pieceTwo.food.one.one",
                p + "Essas imagens...não somem da minha cabeça, não importa o que eu faça...");

        dialogue.put("firstAct.pieceTwo.food.one.two",
                p + "Eu tento esquecer, mas a bebida...");

        dialogue.put("firstAct.pieceTwo.food.one.three",
                p + "O que eu faço?");

        dialogue.put("firstAct.pieceTwo.food.two.one",
                p + "Difícil pensar direito com essa dor na cabeça… e sem comer.");

        dialogue.put("firstAct.pieceTwo.food.two.two",
                p + "Obrigado… talvez eu volte.");

        dialogue.put("firstAct.pieceTwo.liquid.choice",
                     "[1] Hmmm… você tem remédio pra dor de cabeça?\n" +
                     "[2] Tem algo forte ai?");

        dialogue.put("firstAct.pieceTwo.liquid.one.one",
                p + "Resolve mesmo… ou só me derruba de novo?");

        dialogue.put("firstAct.pieceTwo.liquid.two.one",
                p + "Tanto faz, contanto que me deixe entorpecido.");

        dialogue.put("firstAct.pieceTwo.liquid.two.two",
                p + "Tá... tinha esquecido.");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.1",
                p + "Por que você tá aqui… sozinha? \n  E por que ficou me encarando daquele jeito?");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.2",
                p + "...Ela.");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.3",
                p + "Você tá dizendo que ela controla pessoas?");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.4",
                p + "...E o que acontece com o ruído?");

        dialogue.put("secondAct.pieceTwo.Fortress.choice.stay.5",
                p + "Então o que eram essas pessoas...?");

        dialogue.put("thirdAct.pieceOne.talkLena",
                p + "E você?? o que pretende fazer???");

        return dialogue;
    }}
