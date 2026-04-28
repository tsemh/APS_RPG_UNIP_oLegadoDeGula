package unip.joo.model.entities;

import unip.joo.model.ENUM.Efeito;

public class Habilidade {
    private long id;
    private Efeito efeito;
    private String nome;
    private String descricao;
    private int quantidadeDado;
    private int valorDado;

    public Habilidade(long id, Efeito efeito, String nome, String descricao, int quantidadeDado, int valorDado) {
        this.id = id;
        this.efeito = efeito;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidadeDado = quantidadeDado;
        this.valorDado = valorDado;
    }

    public long getId() {
        return id;
    }

    public Efeito getEfeito() {
        return efeito;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
