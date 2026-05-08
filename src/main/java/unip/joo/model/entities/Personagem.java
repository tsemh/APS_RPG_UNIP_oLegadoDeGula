package unip.joo.model.entities;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public abstract class Personagem implements Descritivel { // Classe Abstrata
    private long id; // Encapsulamento
    protected String nome; // Encapsulamento
    protected String descricao;
    protected Classe classe;
    protected Map<String, String> fala;

    // Método Construtor
    public Personagem(long id, String nome, String descricao, Classe classe, Map<String, String> fala) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.classe = classe;
        this.fala = fala;
    }

    public long getId() {
        return id;
    }
    
    public String getNome() { return nome; }

    public String getDescricao() {
        return descricao;
    }

    public String getFala(String key) {
        return fala.get(key);
    }
    public Map<String, String> getAllFalas() { return new LinkedHashMap<>(fala); }
    public Classe getClasse() { return classe; }

    public abstract String getTipo(); // Método Abstrato

}
