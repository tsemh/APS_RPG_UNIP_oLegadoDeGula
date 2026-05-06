package unip.joo.main;

import unip.joo.controller.elodin.HumanoController;
import unip.joo.model.entities.Humano;
import unip.joo.view.FirstAct;

public class Main {
    public static void main(String[] args) {
        HumanoController humanoController = new HumanoController();
        Humano elodin = humanoController.createElodin();

        FirstAct firstAct = new FirstAct();
        firstAct.init(elodin);
    }
}