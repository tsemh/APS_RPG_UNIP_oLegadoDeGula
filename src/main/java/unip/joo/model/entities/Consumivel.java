package unip.joo.model.entities;

import unip.joo.model.ENUM.Efeito;

public class Consumivel extends Item {
    private int valorExtra;
    private int usosRestantes;


    public Consumivel(long id, Efeito efeito, String nome, String descricao, int valorExtra, int usosRestantes) {
        super(id, efeito, nome, descricao);
        this.valorExtra = valorExtra;
        this.usosRestantes = usosRestantes;
    }

    public int getValorExtra() {
        return valorExtra;
    }

    public int getUsosRestantes() {
        return usosRestantes;
    }

    @Override
    public boolean isConsumivel() {
        return true;
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
        resumo.append("Efeito: ").append(getEfeito());
        if (valorExtra != 0) {
            resumo.append(" +").append(valorExtra);
        }
        if (usosRestantes > 0) {
            resumo.append(" (cooldown: ").append(usosRestantes).append(" turnos)");
        }
        return resumo.toString();
    }
}
