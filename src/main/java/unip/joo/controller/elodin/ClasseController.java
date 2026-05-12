package unip.joo.controller.elodin;

import java.util.ArrayList;
import java.util.List;

import unip.joo.model.ENUM.NomeAtributo;
import unip.joo.model.ENUM.NomeClasse;
import unip.joo.model.entities.Atributo;
import unip.joo.model.entities.Classe;
import unip.joo.resources.DescriptionText;
import unip.joo.resources.GameText;

public class ClasseController {
    private final DescriptionText description =  new DescriptionText();
    private HabilidadeController habilidades = new HabilidadeController();
    private List<Atributo> atributos;

    public Classe createClasse() {
        createAtributos();
        return new Classe(
                200L,
                this.atributos,
                60,
                15,
                NomeClasse.SOBREVIVENTE,
                description.getclasses("classe.sobrevivente"),
                habilidades.createAllHabilidades()
        );
    }

    private void createAtributos() {
        this.atributos = new ArrayList<>();

        this.atributos.add(new Atributo(NomeAtributo.FORCA, 1));
        this.atributos.add(new Atributo(NomeAtributo.AGILIDADE, 2));
        this.atributos.add(new Atributo(NomeAtributo.VIGOR, 2));
        this.atributos.add(new Atributo(NomeAtributo.INTELECTO, 3));
    }

}
