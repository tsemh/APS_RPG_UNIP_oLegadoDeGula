package unip.joo.model.entities;


import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private Long id;
    private Long personagemId;
    private int armazenamento;
    private List<Item> itens;

    public Inventario(Long id, Long personagemId, int armazenamento, List<Item> itens) {
        this.id = id;
        this.personagemId = personagemId;
        this.armazenamento = armazenamento;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public Long getPersonagemId() {
        return personagemId;
    }

    public int getArmazenamento() {
        return armazenamento;
    }

    public List<Item> getItens() {
        return itens;
    }

  public Item getItemById(long itemId) {
 return itens.stream()
            .filter(item -> item.getId() == itemId)
            .findFirst()
            .orElse(null);
}

    public boolean addItem(Item item) {
        if (item == null) {
            return false;
        }
        if (itens == null) {
            itens = new ArrayList<>();
        }
        return itens.add(item);
    }

    public boolean removeItem(Item item) {
        return itens != null && itens.remove(item);
    }
}

