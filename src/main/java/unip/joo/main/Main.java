package unip.joo.main;

import unip.joo.controller.elodin.HumanoController;
import unip.joo.controller.humanoFactory.HumanoFactoryController;
import unip.joo.model.entities.Humano;
import unip.joo.view.FirstAct;
import unip.joo.view.SecondAct;
import unip.joo.view.ThirdAct;

public class Main { // Classe principal
    public static void main(String[] args) {
        boolean escape = false;
        // Criação de objetos e instanciação
        HumanoController humanoController = new HumanoController();
        Humano elodin = humanoController.createElodin();

        HumanoFactoryController humanoFactoryController = new HumanoFactoryController();
        Humano lena = humanoFactoryController.createLena();

        FirstAct firstAct = new FirstAct();


        firstAct.init(elodin);

        SecondAct secondAct = new SecondAct();
        secondAct.init(elodin, lena, elodin.getClasse().getVidaMaxima());
        escape = secondAct.escape();

        ThirdAct thirdAct = new ThirdAct();
        thirdAct.init(elodin, lena, elodin.getClasse().getVidaMaxima(), escape);
    }
}