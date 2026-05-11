package unip.joo.main;

import unip.joo.controller.elodin.HumanoController;
import unip.joo.model.entities.Humano;
import unip.joo.view.FirstAct;
import unip.joo.view.SecondAct;

public class Main { // Classe principal
    public static void main(String[] args) {
        // Criação de objetos e instanciação
        HumanoController humanoController = new HumanoController();
        Humano elodin = humanoController.createElodin();
        int defaultLife = elodin.getClasse().getVida();

        FirstAct firstAct = new FirstAct();
        firstAct.init(elodin);

        SecondAct secondAct = new SecondAct();
        secondAct.init(elodin, defaultLife);
    }
}