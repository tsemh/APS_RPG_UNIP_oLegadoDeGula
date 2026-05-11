package unip.joo.controller.elodin;

import unip.joo.model.entities.Inventario;
import unip.joo.model.entities.Item;

import java.util.ArrayList;
import java.util.List;

public class InventoryController {
    public Inventario createInventory(long personagemId) {
        List<Item> itens = new ArrayList<>();
        return new Inventario(1L, personagemId, 10, itens);
    }
}
