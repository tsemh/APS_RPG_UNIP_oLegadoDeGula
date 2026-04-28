package unip.joo.model.entities;

import java.util.Map;

public class Monstro extends Personagem{
    private Boolean saque;

    public Boolean getSaque() {
        return saque;
    }

    public void setSaque(Boolean saque) {
        this.saque = saque;
    }

    public Monstro(Boolean saque,long id,
                   String nome, String descricao, Classe classe, Map<String, String> fala) {
        super(id, nome, descricao, classe, fala);
        this.saque = saque;
    }
}
