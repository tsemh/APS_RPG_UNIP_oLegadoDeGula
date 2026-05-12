package unip.joo.controller.humanoFactory;

import unip.joo.model.entities.Inventario;
import unip.joo.model.entities.Item;

import java.util.ArrayList;
import java.util.List;

public class InventoryFactoryController {

    public Inventario createInventory(long characterId) {
        List<Item> items = new ArrayList<>();
        return new Inventario(1L, characterId, 10, items);
    }

    public Inventario createInventoryDante(long characterId) {
        List<Item> items = new ArrayList<>();
        items.add(ItemFactoryController.createKitSobrevivencia());
        items.add(ItemFactoryController.createJaquetaReforcada());
        items.add(ItemFactoryController.createBarraDeMetal());
        items.add(ItemFactoryController.createPistola());
        return new Inventario(2L, characterId, 10, items);
    }
    public Inventario createInventoryLena(long characterId) {
        List<Item> items = new ArrayList<>();
        items.add(ItemFactoryController.createMascaraDeGas());
        items.add(ItemFactoryController.createPendrive());
        return new Inventario(3L, characterId, 10, items);
    }
}
