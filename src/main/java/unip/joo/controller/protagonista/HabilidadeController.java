package unip.joo.controller.protagonista;

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
        habilidades.add(createEsquivaDesesperada());
        habilidades.add(createUltimoFolego());
        habilidades.add(createRupturaDesesperada());
        habilidades.add(createViolenciaImprovisada());
        habilidades.add(createImpactoDeslizante());
        habilidades.add(createEsmagaCranios());
        return habilidades;
    }

    private Habilidade createEsquivaDesesperada() {
        return new Habilidade(
                1L,
                Efeito.ESQUIVA,
                "Esquiva Desesperada",
                gameText.getDescriptions("habilidade.esquivaDesesperada"),
                1,
                4,
                0,
                2
        );
    }
    private Habilidade createUltimoFolego() {
        return new Habilidade(
                2L,
                Efeito.ESQUIVA,
                "Último fôlego",
                gameText.getDescriptions("habilidade.ultimoFolego"),
                1,
                1,
                0,
                1
        );
    }
    private Habilidade createRupturaDesesperada() {
        return new Habilidade(
                3L,
                Efeito.ESQUIVA,
                "Ruptura Desesperada",
                gameText.getTemporaryAbilities("RupturaDesesperada"),
                2,
                10,
                3,
                2
        );
    }
    private Habilidade createViolenciaImprovisada() {
        return new Habilidade(
                4L,
                Efeito.DANO,
                "Violência Improvisada",
                gameText.getTemporaryAbilities("ViolenciaImprovisada"),
                2,
                10,
                3,
                2
        );
    }
    private Habilidade createImpactoDeslizante() {
        return new Habilidade(
                5L,
                Efeito.DANO,
                "Impacto Deslizante",
                gameText.getTemporaryAbilities("ImpactoDeslizante"),
                2,
                10,
                3,
                2
        );
    }
    private Habilidade createEsmagaCranios() {
        return new Habilidade(
                6L,
                Efeito.DANO,
                "Esmaga Crânios",
                gameText.getTemporaryAbilities("EsmagaCranios"),
                2,
                10,
                3,
                2
        );
    }
}
