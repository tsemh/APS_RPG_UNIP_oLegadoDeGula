package unip.joo.model.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class Personagem {
    private long id;
    protected String nome;
    protected String descricao;
    protected Classe classe;
    protected Map<String, String> fala = new HashMap<>();

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

    public Classe getClasse() { return classe; }

    public static int rollDice(int diceAmount, int diceLimit){
        Random random = new Random();
        int result = 0;
        for(int i = 0; i < diceAmount; i++){
            result += random.nextInt(diceLimit)+1;
        }
        return result;
    }
}
