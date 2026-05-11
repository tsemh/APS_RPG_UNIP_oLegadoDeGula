package unip.joo.controller.Gula;

import unip.joo.model.entities.Monstro;
import java.util.ArrayList;

public class MonstroController {
    private ClasseController classe = new ClasseController();

    public Monstro createGula() {
        String nome = "Gula";
        return new Monstro(
                false,
                401L,
                nome,
                "A entidade corrompida que tudo destruiu - A I.A que se tornou um deus",
                classe.createClasse(),
                null,
                new unip.joo.model.entities.Inventario(2L, 401L, 10, new ArrayList<>())
        );
    }
}
