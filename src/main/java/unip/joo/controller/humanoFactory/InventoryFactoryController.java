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
        itens.add(ItemFactoryController.criarKitSobrevivencia(1L));
        itens.add(ItemFactoryController.criarJaquetaReforcada(2L));
        itens.add(ItemFactoryController.criarBarraDeMetal(3L));
        itens.add(ItemFactoryController.criarPistola(4L));
        return new Inventario(1L, personagemId, 10, itens);
    }
}
