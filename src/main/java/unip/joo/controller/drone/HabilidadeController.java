package unip.joo.controller.drone;

import unip.joo.model.entities.Habilidade;
import unip.joo.model.ENUM.Efeito;
import unip.joo.resources.GameText;

import java.util.ArrayList;
import java.util.List;

import static unip.joo.util.Util.idGenerator;

public class HabilidadeController {
    private final GameText gameText = new GameText();

    public List<Habilidade> createAllHabilidades() {
        List<Habilidade> habilidades = new ArrayList<>();
        habilidades.add(createRaioEletrico());
        habilidades.add(createCanhaoEletrico());
        return habilidades;
    }

    private Habilidade createRaioEletrico() {
        return new Habilidade(
                3L,
                Efeito.ESQUIVA,
                "Raio Elétrico",
                gameText.getDescriptions("habilidade.raioEletrico"),
                2,
                6,
                3,
                4
        );
    }
    private Habilidade createCanhaoEletrico() {
        return new Habilidade(
                4L,
                Efeito.ESQUIVA,
                "Canhão Elétrico",
                gameText.getDescriptions("habilidade.canhaoEletrico"),
                4,
                6,
                0,
                5
        );
    }
}
