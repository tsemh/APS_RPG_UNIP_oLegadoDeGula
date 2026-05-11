package unip.joo.model.entities;

import unip.joo.model.ENUM.Efeito;

public class KitSobrevivencia extends Consumivel {
    private int usosRestantes;
    private int curaPercentual;

    public KitSobrevivencia(long id, String nome, String descricao, int curaPercentual, int usosRestantes) {
        super(id, Efeito.CURA, nome, descricao, curaPercentual, 0);
        this.curaPercentual = curaPercentual;
        this.usosRestantes = usosRestantes;
    }

    public int getCuraPercentual() {
        return curaPercentual;
    }

    public int getUsosRestantes() {
        return usosRestantes;
    }

    public boolean usar(Personagem personagem) {
        if (usosRestantes <= 0) {
            return false;
        }

        usosRestantes--;
        if (usosRestantes <= 0 && personagem != null && personagem.getInventario() != null) {
            personagem.getInventario().removeItem(this);
        }

        return true;
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
