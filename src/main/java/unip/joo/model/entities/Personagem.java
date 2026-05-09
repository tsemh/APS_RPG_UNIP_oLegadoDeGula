package unip.joo.model.entities;

import unip.joo.model.ENUM.NomeAtributo;

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

    public String getStatus() {
        StringBuilder status = new StringBuilder();
        status.append("========== STATUS ==========\n");
        status.append("Nome: ").append(nome).append("\n");
        status.append("Vida: ").append(classe.getVida()).append("  |  Defesa: ").append(classe.getDefesa()).append("\n");
        status.append("-------- Atributos --------\n");
        status.append("Forca: ").append(classe.getAtributo(NomeAtributo.FORCA)).append("\n");
        status.append("Agilidade: ").append(classe.getAtributo(NomeAtributo.AGILIDADE)).append("\n");
        status.append("Vigor: ").append(classe.getAtributo(NomeAtributo.VIGOR)).append("\n");
        status.append("Intelecto: ").append(classe.getAtributo(NomeAtributo.INTELECTO)).append("\n");
        status.append("===========================");
        return status.toString();
    }
    public String profile() {
        StringBuilder perfil = new StringBuilder();
        perfil.append("========== PERFIL ==========\n");
        perfil.append("Nome: ").append(nome).append("  |  Vida: ").append(classe.getVida()).append("  |  Defesa: ").append(classe.getDefesa()).append("\n");
        perfil.append("-------- Atributos --------\n");
        perfil.append("Forca: ").append(classe.getAtributo(NomeAtributo.FORCA)).append("  |  ");
        perfil.append("Agilidade: ").append(classe.getAtributo(NomeAtributo.AGILIDADE)).append("\n");
        perfil.append("Vigor: ").append(classe.getAtributo(NomeAtributo.VIGOR)).append("  |  ");
        perfil.append("Intelecto: ").append(classe.getAtributo(NomeAtributo.INTELECTO)).append("\n");
        perfil.append("------ Descricao do Personagem ------\n");
        perfil.append(descricao).append("\n");
        perfil.append("-------- Classe --------\n");
        perfil.append("Nome: ").append(classe.getNomeClasse()).append("\n\n");
        perfil.append("Habilidades: ").append(classe.getNameAbilities()).append("\n\n");
        perfil.append("Descricao: ").append(classe.getDescricao()).append("\n\n");
        perfil.append("===========================");
        return perfil.toString();
    }

    public abstract String getTipo(); // Método Abstrato

}
