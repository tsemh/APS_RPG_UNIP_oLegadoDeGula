package unip.joo.controller.Gula;

import unip.joo.model.entities.Monstro;

public class MonstroController {
    private ClasseController classe = new ClasseController();
    private InventoryController inventoryFactory = new InventoryController();

    public Monstro createGula() {
        String nome = "Gula";
        long id = 401L;
        return new Monstro(
                false,
                id,
                nome,
                "A entidade tudo destruiu - A I.A que se tornou um deus",
                classe.createClasse(),
                null,
                inventoryFactory .createInventory(id)
        );
    }
    public Monstro createCorruptedGula() {
        String nome = "Gula Corrompida";
        long id = 402L;
        return new Monstro(
                false,
                id,
                nome,
                "A entidade corrompida que tudo destruiu - A I.A que se tornou um deus e caiu",
                classe.createClasseCorrupted(),
                null,
                inventoryFactory .createInventory(id)
        );
    }
}
