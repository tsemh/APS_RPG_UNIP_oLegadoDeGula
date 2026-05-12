package unip.joo.model.entities;

import unip.joo.model.ENUM.Efeito;

public class KitSobrevivencia extends Consumivel {
    private int curaPercentual;

    public KitSobrevivencia(long id, String nome, String descricao, int curaPercentual, int usosRestantes) {
        super(id, Efeito.CURA, nome, descricao, curaPercentual, usosRestantes);
        this.curaPercentual = curaPercentual;
        this.usosRestantes = usosRestantes;
    }

    public int getCuraPercentual() {
        return curaPercentual;
    }

    @Override
    public String obterResumo() {
        StringBuilder resumo = new StringBuilder();
        resumo.append(getNome()).append(" - Consumível\n");
        resumo.append(getDescricao()).append("\n");
        resumo.append("Cura: ").append(curaPercentual).append("% da vida");
        resumo.append("\nUsos restantes: ").append(usosRestantes);
        return resumo.toString();
    }
}
