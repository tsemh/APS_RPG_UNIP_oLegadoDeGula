package unip.joo.controller.drone;

import unip.joo.controller.drone.ClasseController;
import unip.joo.model.ENUM.Sexo;
import unip.joo.model.entities.Humano;
import unip.joo.model.entities.Monstro;

public class MonstroController {
    private unip.joo.controller.drone.ClasseController classe =  new ClasseController();

    public Monstro createDrone() {
        String nome = "Eletro drone";
        return new Monstro(
                false,
                400L,
                nome,
                "Descrição Drone",
                classe.createClasse(),
                null
        );
    }
}
