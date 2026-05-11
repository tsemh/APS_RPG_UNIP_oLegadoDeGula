package unip.joo.controller.humanoFactory;

import unip.joo.model.entities.Inventario;
import unip.joo.model.entities.Item;

import java.util.ArrayList;
import java.util.List;

public class InventoryFactoryController {

    public Inventario createInventory(long personagemId) {
        List<Item> itens = new ArrayList<>();
        return new Inventario(1L, personagemId, 10, itens);
    }

    public Inventario createInventoryDante(long personagemId) {
        List<Item> itens = new ArrayList<>();
        itens.add(ItemFactoryController.createKitSobrevivencia());
        itens.add(ItemFactoryController.createJaquetaReforcada());
        itens.add(ItemFactoryController.createBarraDeMetal());
        itens.add(ItemFactoryController.createPistola());
        return new Inventario(1L, personagemId, 10, itens);
    }
}
