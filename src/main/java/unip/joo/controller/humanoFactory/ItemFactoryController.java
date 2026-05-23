package unip.joo.controller.humanoFactory;

import unip.joo.model.ENUM.Efeito;
import unip.joo.model.entities.*;

public class ItemFactoryController {

    public static Item createKitSobrevivencia() {
        return new KitSobrevivencia(
            1L,
            "Kit de Sobrevivência",
            "Restaura 75% da vida do personagem. Pode ser usado duas vezes.",
            75,
            2
        );
    }

    public static Item createJaquetaReforcada() {
        return new Armadura(
            2L,
            "Jaqueta Reforçada",
            "Aumente a defesa do usuário em 1 ponto.",
            1
        );
    }

    public static Item createBarraDeMetal() {
        return new Arma(
            3L,
            "Barra de Metal",
            "Arma contundente improvisada.",
            3,
            10,
            3
        );
    }

    public static Item createPistola() {
        return new Arma(
            4L,
            "Pistola",
            "Arma de fogo leve.",
            3,
            12,
            3
        );
    }
    public static Item createMascaraDeGas() {
        return new Armadura(
            5L,
            "Mascara de Gás",
            "Protege contra gases tóxicos, reduzindo danos em 100%.",
            100
        );
    }
    public static Item createPendrive() {
        return new Consumivel(
            6L,
            Efeito.DANO,
            "Pendrive",
            "Corrompe os sistemas de Gula",
            0,
            1
        );
    }
}
