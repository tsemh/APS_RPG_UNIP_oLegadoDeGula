package unip.joo.controller.Gula;

import unip.joo.model.entities.Habilidade;
import unip.joo.model.ENUM.Efeito;

import java.util.ArrayList;
import java.util.List;

public class HabilidadeController {

    public List<Habilidade> createAllHabilidades() {
        List<Habilidade> habilidades = new ArrayList<>();
        habilidades.add(createLaserConcentrado());
        habilidades.add(createTentaculosEnergia());
        habilidades.add(createLaserFinal());
        habilidades.add(createConsumo());
        habilidades.add(createSpecial());
        return habilidades;
    }

    public List<Habilidade> createAllCorruptedHabilidades() {
        List<Habilidade> habilidades = new ArrayList<>();
        habilidades.add(createCorruptedLaserConcentrado());
        habilidades.add(createCorruptedTentaculosEnergia());
        habilidades.add(createCorruptedLaserFinal());
        habilidades.add(createCorruptedConsumo());
        return habilidades;
    }

    private Habilidade createLaserConcentrado() {
        return new Habilidade(
                1L,
                Efeito.ESQUIVA,
                "Laser Concentrado",
                "Descarga roxa que queima estruturas",
                1,
                10,
                5,
                3
        );
    }

    private Habilidade createTentaculosEnergia() {
        return new Habilidade(
                2L,
                Efeito.ESQUIVA,
                "Tentáculos de Energia",
                "Tentáculos instáveis que atingem o alvo",
                2,
                6,
                3,
                1
        );
    }

    private Habilidade createLaserFinal() {
        return new Habilidade(
                3L,
                Efeito.ESQUIVA,
                "Laser Final",
                "Ataque finalizador de última resistência",
                2,
                12,
                5,
                1
        );
    }
    private Habilidade createConsumo() {
        return new Habilidade(
                4L,
                Efeito.CURA,
                "Consumo desenfreado",
                "Absorção da energia cincundante",
                5,
                10,
                5,
                5
        );
    }
    private Habilidade createSpecial() {
        return new Habilidade(
                5L,
                Efeito.CURA,
                "Ataque especial",
                "Ataque feito somendo ao encontrar o jogador desprevinido",
                2,
                10,
                5,
                100
        );
    }

    private Habilidade createCorruptedLaserConcentrado() {
        return new Habilidade(
                1L,
                Efeito.ESQUIVA,
                "Laser Concentrado [CORROMPIDO]",
                "Descarga roxa instável que causa menos dano",
                2,
                6,
                3,  // Dano reduzido
                3
        );
    }

    private Habilidade createCorruptedTentaculosEnergia() {
        return new Habilidade(
                2L,
                Efeito.ESQUIVA,
                "Tentáculos de Energia [CORROMPIDO]",
                "Tentáculos fracos e instáveis",
                3,
                4,
                2,  // Dano reduzido
                1
        );
    }

    private Habilidade createCorruptedLaserFinal() {
        return new Habilidade(
                3L,
                Efeito.ESQUIVA,
                "Laser Final [CORROMPIDO]",
                "Ataque finalizador enfraquecido",
                3,
                8,
                3,  // Dano reduzido
                5
        );
    }
    private Habilidade createCorruptedConsumo() {
        return new Habilidade(
                4L,
                Efeito.CURA,
                "Consumo Desenfreado [CORROMPIDO]",
                "Absorção da energia cincundante",
                3,
                8,
                5,
                10
        );
    }
}
