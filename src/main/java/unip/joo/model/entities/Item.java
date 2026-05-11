package unip.joo.model.entities;

import unip.joo.model.ENUM.Efeito;

public abstract class Item implements Descritivel {
    private long id;
    private Efeito efeito;
    private String nome;
    private String descricao;

    protected Item(long id, Efeito efeito, String nome, String descricao) {
        this.id = id;
        this.efeito = efeito;
        this.nome = nome;
        this.descricao = descricao;
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

    @Override
    public String getDescricao() {
        return descricao;
    }

    public boolean isConsumivel() {
        return false;
    }

    public boolean isEquipavel() {
        return false;
    }

    public boolean isEquipado() {
        return false;
    }

    public abstract String obterResumo();
}
