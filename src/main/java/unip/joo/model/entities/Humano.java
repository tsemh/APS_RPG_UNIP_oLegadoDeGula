package unip.joo.model.entities;

import unip.joo.model.ENUM.Sexo;

import java.util.Map;

public class Humano extends Personagem{
    private Sexo sexo;
    private Boolean jogavel;

    public Humano(Sexo sexo, Boolean jogavel,
                  String nome, String descricao, Classe classe, Map<String, String> fala, long id) {

        super(id, nome, descricao, classe, fala);
        this.sexo = sexo;
        this.jogavel = jogavel;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public Boolean getJogavel() {
        return jogavel;
    }

}
