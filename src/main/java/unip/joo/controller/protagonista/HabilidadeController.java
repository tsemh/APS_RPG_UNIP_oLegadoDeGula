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
        return habilidades;
    }

    private Habilidade createEsquivaDesesperada() {
        return new Habilidade(
                idGenerator(),
                Efeito.ESQUIVA,
                "Esquiva Desesperada",
                gameText.getDescriptions("habilidade.esquivaDesesperada"),
                1,
                4
        );
    }
    private Habilidade createUltimoFolego() {
        return new Habilidade(
                idGenerator(),
                Efeito.ESQUIVA,
                "Último fôlego",
                gameText.getDescriptions("habilidade.ultimoFolego"),
                1,
                1
        );
    }
}
