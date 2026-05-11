package unip.joo.model.entities;

import unip.joo.model.ENUM.Efeito;

public class Consumivel extends Item {
    private int valorExtra;
    private int tempoEspera;

    public Consumivel(long id, Efeito efeito, String nome, String descricao, int valorExtra, int tempoEspera) {
        super(id, efeito, nome, descricao);
        this.valorExtra = valorExtra;
        this.tempoEspera = tempoEspera;
    }

    public int getValorExtra() {
        return valorExtra;
    }

    public int getTempoEspera() {
        return tempoEspera;
    }

    @Override
    public boolean isConsumivel() {
        return true;
    }

    @Override
    public String obterResumo() {
        StringBuilder resumo = new StringBuilder();
        resumo.append(getNome()).append(" - Consumível\n");
        resumo.append(getDescricao()).append("\n");
        resumo.append("Efeito: ").append(getEfeito());
        if (valorExtra != 0) {
            resumo.append(" +").append(valorExtra);
        }
        if (tempoEspera > 0) {
            resumo.append(" (cooldown: ").append(tempoEspera).append(" turnos)");
        }
        return resumo.toString();
    }
}
