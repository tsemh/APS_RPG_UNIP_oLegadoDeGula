package unip.joo.model.entities;

import unip.joo.model.ENUM.Efeito;

public class Habilidade {
    private long id;
    private Efeito efeito;
    private String nome;
    private String descricao;
    private int quantidadeDado;
    private int valorDado;
    private int valorExtra;
    private int tempoEspera;

    public Habilidade(long id, Efeito efeito, String nome, String descricao, int quantidadeDado, int valorDado, int valorExtra, int tempoEspera) {
        this.id = id;
        this.efeito = efeito;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidadeDado = quantidadeDado;
        this.valorDado = valorDado;
        this.valorExtra = valorExtra;
        this.tempoEspera = tempoEspera;
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

    public int getQuantidadeDado() {
        return this.quantidadeDado;
    }

    public int getValorDado() {
        return this.valorDado;
    }

    public int getValorExtra() {
        return this.valorExtra;
    }

    public int getTempoEspera() {
        return tempoEspera;
    }
}
