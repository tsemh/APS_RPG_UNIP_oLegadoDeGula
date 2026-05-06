package unip.joo.controller.drone;

import unip.joo.model.entities.Habilidade;
import unip.joo.model.ENUM.Efeito;
import unip.joo.resources.GameText;

import java.util.ArrayList;
import java.util.List;

public class HabilidadeController {
    private final GameText gameText = new GameText();

    public List<Habilidade> createAllHabilidades() {
        List<Habilidade> habilidades = new ArrayList<>();
        habilidades.add(createAtaqueEletrico());
        habilidades.add(createInvestidaMecanica());
        habilidades.add(createPulsoEletromagnetico());
        habilidades.add(createRaioEletrico());
        habilidades.add(createCanhaoEletrico());
        return habilidades;
    }

    private Habilidade createAtaqueEletrico() {
        return new Habilidade(
                1L,
                Efeito.ESQUIVA,
                "Ataque Elétrico",
                gameText.getDescriptions("habilidade.ataqueletrico"),
                1,
                10,
                2,
                1
        );
    }

    private Habilidade createInvestidaMecanica() {
        return new Habilidade(
                2L,
                Efeito.ESQUIVA,
                "Investida Mecânica",
                gameText.getDescriptions("habilidade.investidamecanica"),
                1,
                8,
                3,
                1
        );
    }

    private Habilidade createPulsoEletromagnetico() {
        return new Habilidade(
                3L,
                Efeito.ESQUIVA,
                "Pulso Eletromagnético",
                gameText.getDescriptions("habilidade.pulsoeletromagnetico"),
                2,
                10,
                3,
                2
        );
    }

    private Habilidade createRaioEletrico() {
        return new Habilidade(
                4L,
                Efeito.ESQUIVA,
                "Raio Elétrico",
                gameText.getDescriptions("habilidade.raioEletrico"),
                2,
                6,
                3,
                1
        );
    }

    private Habilidade createCanhaoEletrico() {
        return new Habilidade(
                5L,
                Efeito.ESQUIVA,
                "Canhão Elétrico",
                gameText.getDescriptions("habilidade.canhaoEletrico"),
                4,
                6,
                0,
                3
        );
    }
}
