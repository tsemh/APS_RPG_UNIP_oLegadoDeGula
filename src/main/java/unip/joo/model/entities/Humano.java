package unip.joo.model.entities;

import unip.joo.model.ENUM.Sexo;

import java.util.Map;

// Herança: Humano estende Personagem
public class Humano extends Personagem{
    private Sexo sexo; // Encapsulamento
    private Boolean jogavel;

    // Método Construtor
    public Humano(Sexo sexo, Boolean jogavel,
                  String nome, String descricao, Classe classe, Map<String, String> fala, long id, Inventario inventario) {

        super(id, nome, descricao, classe, fala, inventario);
        this.sexo = sexo;
        this.jogavel = jogavel;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public Boolean getJogavel() {
        return jogavel;
    }

    @Override
    public String getTipo() {
        return "Humano"; // Sobrescrita / Polimorfismo de Classe
    }

}
