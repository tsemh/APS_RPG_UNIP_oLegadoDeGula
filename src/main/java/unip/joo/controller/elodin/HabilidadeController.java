package unip.joo.controller.elodin;

import unip.joo.model.entities.Habilidade;
import unip.joo.model.ENUM.Efeito;
import unip.joo.resources.DescriptionText;

import java.util.ArrayList;
import java.util.List;

public class HabilidadeController {
    private final DescriptionText description =  new DescriptionText();

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
    public List<Habilidade> createpistolaAbilities() {
        List<Habilidade> habilidades = new ArrayList<>();
        habilidades.add(createTiroSimples());
        habilidades.add(createDisparoDeRuptura());
        habilidades.add(createDisparoDesesperado());
        return habilidades;
    }


    private Habilidade createEsquivaDesesperada() {
        return new Habilidade(
                1L,
                Efeito.ESQUIVA,
                "Esquiva Desesperada",
                description.getAbilities("habilidade.esquivaDesesperada"),
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
                description.getAbilities("habilidade.ultimoFolego"),
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
                description.getAbilities("RupturaDesesperada"),
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
                description.getAbilities("ViolenciaImprovisada"),
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
                description.getAbilities("ImpactoDeslizante"),
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
                description.getAbilities("EsmagaCranios"),
                2,
                10,
                3,
                2
        );
    }
    private Habilidade createTiroSimples() {
        return new Habilidade(
                7L,
                Efeito.DANO,
                "Tiro simples",
                description.getAbilities("tiroSimples"),
                2,
                8,
                3,
                1
        );
    }
    private Habilidade createDisparoDeRuptura() {
        return new Habilidade(
                7L,
                Efeito.DANO,
                "Disparo de Ruptura",
                description.getAbilities("disparoDeRuptura"),
                4,
                8,
                3,
                2
        );
    }
    private Habilidade createDisparoDesesperado() {
        return new Habilidade(
                7L,
                Efeito.DANO,
                "Disparo desesperado",
                description.getAbilities("disparoDesesperado"),
                5,
                8,
                1,
                4
        );
    }
}
