package unip.joo.model.entities;

import unip.joo.model.ENUM.Efeito;

public class Arma extends Equipamento {
    private int quantidadeDados;
    private int ladosDados;
    private int bonusDano;

    public Arma(long id, String nome, String descricao, int quantidadeDados, int ladosDados, int bonusDano) {
        super(id, Efeito.DANO, nome, descricao);
        this.quantidadeDados = quantidadeDados;
        this.ladosDados = ladosDados;
        this.bonusDano = bonusDano;
    }

    public int getQuantidadeDados() {
        return quantidadeDados;
    }

    public int getLadosDados() {
        return ladosDados;
    }

    public int getBonusDano() {
        return bonusDano;
    }

    public String getFormulaDano() {
        return quantidadeDados + "d" + ladosDados + (bonusDano >= 0 ? "+" + bonusDano : String.valueOf(bonusDano));
    }

    @Override
    public String obterResumo() {
        StringBuilder resumo = new StringBuilder();
        resumo.append(getNome()).append(" - Arma\n");
        resumo.append(getDescricao()).append("\n");
        resumo.append("Dano: ").append(getFormulaDano());
        resumo.append("\nEquipado: ").append(isEquipado() ? "Sim" : "Não");
        return resumo.toString();
    }
}
