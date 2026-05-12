package unip.joo.controller.drone;

import unip.joo.model.entities.Monstro;

public class MonstroController {
    private unip.joo.controller.drone.ClasseController classe =  new ClasseController();
    private InventoryController inventoryFactory = new InventoryController();

    public Monstro createDrone() {
        String nome = "Eletro drone";
        long id = 400L;
        return new Monstro(
                false,
                id,
                nome,
                "Descrição Drone",
                classe.createClasse(),
                null,
                inventoryFactory.createInventory(id)
        );
    }
}
