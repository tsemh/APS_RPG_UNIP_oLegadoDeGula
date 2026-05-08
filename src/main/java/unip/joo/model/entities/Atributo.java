package unip.joo.model.entities;

import unip.joo.model.ENUM.NomeAtributo;

public class Atributo { // Classe
    private NomeAtributo tipo; // Encapsulamento
    private int valor;

    // Método Construtor
    public Atributo(NomeAtributo tipo, int valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public NomeAtributo getTipo() {
        return tipo;
    }

    public int getValue() {
        return valor;
    }
}
