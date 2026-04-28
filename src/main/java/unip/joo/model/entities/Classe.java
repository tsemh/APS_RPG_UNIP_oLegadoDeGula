package unip.joo.model.entities;

import unip.joo.model.ENUM.NomeAtributo;
import unip.joo.model.ENUM.NomeClasse;

import java.util.List;

public class Classe {
    private long id;
    private int vida;
    private int defesa;
    private NomeClasse nomeClasse;
    private String descricao;
    private List<Atributo> atributos;
    private List<Habilidade> habilidades;

    public Classe(long id, List<Atributo> atributos, int vida, int defesa, NomeClasse nomeClasse, String descricao, List<Habilidade> habilidades) {
        this.id = id;
        this.atributos =  atributos;
        this.vida = vida;
        this.defesa = defesa;
        this.nomeClasse = nomeClasse;
        this.descricao = descricao;
        this.habilidades = habilidades;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public NomeClasse getNomeClasse() {
        return nomeClasse;
    }

    public void setNomeClasse(NomeClasse nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public int getAtributo(NomeAtributo tipo) {
        return atributos.stream()
                .filter(a -> a.getTipo() == tipo)
                .map(Atributo::getValue)
                .findFirst()
                .orElse(0);
    }

}
