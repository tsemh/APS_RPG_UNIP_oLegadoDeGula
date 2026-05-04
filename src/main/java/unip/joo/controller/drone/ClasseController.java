package unip.joo.controller.drone;

import java.util.ArrayList;
import java.util.List;

import static unip.joo.util.Util.idGenerator;

import unip.joo.model.ENUM.NomeAtributo;
import unip.joo.model.ENUM.NomeClasse;
import unip.joo.model.entities.Atributo;
import unip.joo.model.entities.Classe;
import unip.joo.resources.GameText;

public class ClasseController {
    private final GameText gameText = new GameText();
    private HabilidadeController habilidades = new HabilidadeController();
    private List<Atributo> atributos;

    public Classe createClasse() {
        createAtributos();
        return new Classe(
                idGenerator(),
                this.atributos,
                60,
                12,
                NomeClasse.SOBREVIVENTE,
                gameText.getDescriptions("classe.drone"),
                habilidades.createAllHabilidades()
        );
    }

    private void createAtributos() {
        this.atributos = new ArrayList<>();

        this.atributos.add(new Atributo(NomeAtributo.FORCA, 4));
        this.atributos.add(new Atributo(NomeAtributo.AGILIDADE, 1));
        this.atributos.add(new Atributo(NomeAtributo.VIGOR, 4));
        this.atributos.add(new Atributo(NomeAtributo.INTELECTO, 1));
    }

}
