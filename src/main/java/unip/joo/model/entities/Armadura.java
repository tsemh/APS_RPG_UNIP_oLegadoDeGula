package unip.joo.model.entities;

import unip.joo.model.ENUM.Efeito;

public class Armadura extends Equipamento {
    private int ignorarImpactoPercentual;

    public Armadura(long id, String nome, String descricao, int ignorarImpactoPercentual) {
        super(id, Efeito.DEFESA, nome, descricao);
        this.ignorarImpactoPercentual = ignorarImpactoPercentual;
    }

    public int getIgnorarImpactoPercentual() {
        return ignorarImpactoPercentual;
    }

    public int getBonusDefesa() {
        return ignorarImpactoPercentual;
    }

    @Override
    public String obterResumo() {
        StringBuilder resumo = new StringBuilder();
        resumo.append(getNome()).append(" - Armadura\n");
        resumo.append(getDescricao()).append("\n");
        resumo.append("Ignora ").append(ignorarImpactoPercentual).append("% de danos de impacto");
        resumo.append("\nEquipado: ").append(isEquipado() ? "Sim" : "Não");
        return resumo.toString();
    }
}
