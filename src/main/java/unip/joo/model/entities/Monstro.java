package unip.joo.model.entities;

import java.util.Map;

// Herança: Monstro estende Personagem
public class Monstro extends Personagem{
    private Boolean saque; // Encapsulamento

    public Boolean getSaque() {
        return saque;
    }

    public void setSaque(Boolean saque) {
        this.saque = saque;
    }

    // Método Construtor
    public Monstro(Boolean saque,long id,
                   String nome, String descricao, Classe classe, Map<String, String> fala, Inventario inventario) {
        super(id, nome, descricao, classe, fala, inventario);
        this.saque = saque;
    }

    @Override
    public String getTipo() {
        return "Monstro"; // Sobrescrita / Polimorfismo de Classe
    }
}
