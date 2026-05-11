package unip.joo.model.entities;

import unip.joo.model.ENUM.Efeito;

public abstract class Equipamento extends Item {
    private boolean equipado;

    protected Equipamento(long id, Efeito efeito, String nome, String descricao) {
        super(id, efeito, nome, descricao);
        this.equipado = false;
    }

    @Override
    public boolean isEquipavel() {
        return true;
    }

    @Override
    public boolean isEquipado() {
        return equipado;
    }

    public boolean equipar() {
        if (equipado) {
            return false;
        }
        equipado = true;
        return true;
    }

    public boolean desequipar() {
        if (!equipado) {
            return false;
        }
        equipado = false;
        return true;
    }
}
