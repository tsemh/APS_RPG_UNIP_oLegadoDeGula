package unip.joo.controller.Gula;

import java.util.ArrayList;
import java.util.List;

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
                301L,
                this.atributos,
                120,
                16,
                NomeClasse.GULA,
                "A entidade corrompida que tudo destruiu",
                habilidades.createAllHabilidades()
        );
    }

    private void createAtributos() {
        this.atributos = new ArrayList<>();

        this.atributos.add(new Atributo(NomeAtributo.FORCA, 2));
        this.atributos.add(new Atributo(NomeAtributo.AGILIDADE, 3));
        this.atributos.add(new Atributo(NomeAtributo.VIGOR, 3));
        this.atributos.add(new Atributo(NomeAtributo.INTELECTO, 4));
    }

    public Classe createClasseCorrupted() {
        createAtributosCorrupted();
        return new Classe(
                302L,
                this.atributos,
                80,
                12,
                NomeClasse.GULA,
                "A entidade corrompida que tudo tendo destruir",
                habilidades.createAllHabilidades()
        );
    }

    private void createAtributosCorrupted() {
        this.atributos = new ArrayList<>();

        this.atributos.add(new Atributo(NomeAtributo.FORCA, 2));
        this.atributos.add(new Atributo(NomeAtributo.AGILIDADE, 2));
        this.atributos.add(new Atributo(NomeAtributo.VIGOR, 2));
        this.atributos.add(new Atributo(NomeAtributo.INTELECTO, 2));
    }
}
