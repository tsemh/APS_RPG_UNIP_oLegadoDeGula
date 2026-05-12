package unip.joo.controller.drone;

import unip.joo.controller.humanoFactory.InventoryFactoryController;
import unip.joo.model.entities.Inventario;

public class InventoryController {

    private InventoryFactoryController inventoryFactory = new InventoryFactoryController();

    public Inventario createInventory(long personagemId) {
        return inventoryFactory.createInventory(personagemId);
    }

}