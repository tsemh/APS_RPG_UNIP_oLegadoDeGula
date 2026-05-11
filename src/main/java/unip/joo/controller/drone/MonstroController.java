package unip.joo.controller.drone;

import unip.joo.model.entities.Monstro;

public class MonstroController {
    private unip.joo.controller.drone.ClasseController classe =  new ClasseController();
    private InventoryControllerDrone inventoryFactory = new InventoryControllerDrone();

    public Monstro createDrone() {
        String nome = "Eletro drone";
        return new Monstro(
                false,
                400L,
                nome,
                "Descrição Drone",
                classe.createClasse(),
                null,
                inventoryFactory.createInventory(400L)
        );
    }
}
