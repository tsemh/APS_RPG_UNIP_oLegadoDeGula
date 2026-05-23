package unip.joo.model.entities;

import unip.joo.model.ENUM.NomeAtributo;
import unip.joo.model.ENUM.NomeClasse;

import java.util.ArrayList;
import java.util.List;

public class Classe { // Classe
    private long id; // Encapsulamento
    private int vida;
    private int vidaMaxima;
    private int defesa;
    private NomeClasse nomeClasse;
    private String descricao;
    private List<Atributo> atributos;
    private List<Habilidade> habilidades;

    // Método Construtor
    public Classe(long id, List<Atributo> atributos, int vida, int vidaMaxima, int defesa, NomeClasse nomeClasse, String descricao, List<Habilidade> habilidades) {
        this.id = id;
        this.atributos =  atributos;
        this.vida = vida;
        this.vidaMaxima = vida;
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
    public int getVidaMaxima() {
        return vidaMaxima;
    }
    public void setVidaMaxima(int vidaMaxima) {this.vidaMaxima = vidaMaxima;}

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

        public void addHabilidade(List<Habilidade> habilidade) {
            if (habilidade == null) {
                return;
            }
            if (this.habilidades == null) {
                this.habilidades = new ArrayList<>();
            }
            this.habilidades.addAll(habilidade);
        }

    public String getNameAbilities() {
        if (habilidades == null || habilidades.isEmpty()) {
            return "Nenhuma habilidade disponivel";
        }

        StringBuilder names = new StringBuilder();
        for (int i = 0; i < habilidades.size(); i++) {
            names.append(habilidades.get(i).getNome());
            if (i < habilidades.size() - 1) {
                names.append(", ");
            }
        }
        return names.toString();
    }

    public Habilidade getHabilidade(long id) {
        return habilidades.stream()
                .filter(h -> h.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public int getAtributo(NomeAtributo tipo) {
        return atributos.stream()
                .filter(a -> a.getTipo() == tipo)
                .map(Atributo::getValue)
                .findFirst()
                .orElse(0);
    }

}
