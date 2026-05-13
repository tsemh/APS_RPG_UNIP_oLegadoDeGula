package unip.joo.controller.humanoFactory;

import unip.joo.controller.elodin.HabilidadeController;
import unip.joo.model.ENUM.NomeAtributo;
import unip.joo.model.ENUM.NomeClasse;
import unip.joo.model.entities.Atributo;
import unip.joo.model.entities.Classe;
import unip.joo.resources.DescriptionText;

import java.util.ArrayList;
import java.util.List;

public class ClasseFactoryController {

    private final DescriptionText description =  new DescriptionText();
    private HabilidadeController habilidades = new HabilidadeController();
    private List<Atributo> atributos;

    public Classe createClasse() {
        createAtributos();
        return new Classe(
                1L,
                this.atributos,
                60,
                60,
                15,
                NomeClasse.PADRAO,
                description.getclasses("classe.sobrevivente"),
                habilidades.createAllHabilidades()
        );
    }

    private void createAtributos() {
        this.atributos = new ArrayList<>();

        this.atributos.add(new Atributo(NomeAtributo.FORCA, 1));
        this.atributos.add(new Atributo(NomeAtributo.AGILIDADE, 1));
        this.atributos.add(new Atributo(NomeAtributo.VIGOR, 1));
        this.atributos.add(new Atributo(NomeAtributo.INTELECTO, 1));
    }
}
