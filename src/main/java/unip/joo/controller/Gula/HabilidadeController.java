package unip.joo.controller.Gula;

import unip.joo.model.entities.Habilidade;
import unip.joo.model.ENUM.Efeito;
import unip.joo.resources.GameText;

import java.util.ArrayList;
import java.util.List;

public class HabilidadeController {
    private final GameText gameText = new GameText();

    public List<Habilidade> createAllHabilidades() {
        List<Habilidade> habilidades = new ArrayList<>();
        habilidades.add(createLaserConcentrado());
        habilidades.add(createTentaculosEnergia());
        habilidades.add(createLaserFinal());
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
}
