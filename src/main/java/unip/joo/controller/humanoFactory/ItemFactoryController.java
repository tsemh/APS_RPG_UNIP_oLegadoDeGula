package unip.joo.controller.humanoFactory;

import unip.joo.model.entities.Armadura;
import unip.joo.model.entities.Arma;
import unip.joo.model.entities.KitSobrevivencia;
import unip.joo.model.entities.Item;

public class ItemFactoryController {

    public static Item criarKitSobrevivencia(long id) {
        return new KitSobrevivencia(
            id,
            "Kit de Sobrevivência",
            "Restaura 25% da vida do personagem. Pode ser usado duas vezes.",
            25,
            2
        );
    }

    public static Item criarJaquetaReforcada(long id) {
        return new Armadura(
            id,
            "Jaqueta Reforçada",
            "Reduz danos de impacto em 10%.",
            10
        );
    }

    public static Item criarBarraDeMetal(long id) {
        return new Arma(
            id,
            "Barra de Metal",
            "Arma contundente improvisada.",
            3,
            10,
            3
        );
    }

    public static Item criarPistola(long id) {
        return new Arma(
            id,
            "Pistola",
            "Arma de fogo leve.",
            3,
            12,
            3
        );
    }
}
