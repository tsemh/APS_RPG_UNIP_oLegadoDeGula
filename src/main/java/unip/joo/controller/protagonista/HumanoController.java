package unip.joo.controller.protagonista;

import unip.joo.model.ENUM.Sexo;
import unip.joo.model.entities.Humano;

import java.util.Map;

import static unip.joo.util.Util.idGenerator;

public class HumanoController {
    private ClasseController classe =  new ClasseController();

    public Humano createProtagonista() {
        String nome = "Protagonista da silva";
        return new Humano(
                Sexo.MASCULINO,
                true,
                nome,
                "Descrição protagonista",
                classe.createClasse(),
                Map.of("firstAct.lixo", "<" + nome + ">: Argh merda, eu não devia ter misturado aquele lixo todo. ",
                        "firstAct.claridade", "<" + nome + ">: Céus, que claridade"),
                idGenerator()
                );
    }
}
