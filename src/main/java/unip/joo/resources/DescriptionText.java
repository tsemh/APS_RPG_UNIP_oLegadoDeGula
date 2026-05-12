package unip.joo.resources;

import java.util.LinkedHashMap;
import java.util.Map;

public class DescriptionText {
    private final Map<String, String> classes = Map.of(
            "classe.sobrevivente",
            "Um sobrevivente nato, capaz de suportar longos combates e desafios ambientais. Seu \n" +
                    "corpo e mente resistem ao desgaste, mas fraquezas climáticas e energia limitada exigem \n" +
                    "planejamento e cuidado.\n",

            "classe.drone",
            ""

            );
    private final Map<String, String> characters = Map.of(

    );

    private final Map<String, String> abilities = new LinkedHashMap<>() {{
        put(
                "RupturaDesesperada",
                "Tipo: Ataque corpo a corpo\n" +
                        "Teste: d20 + Força vs Defesa\n" +
                        "Dano: 2d10 + 3\n" +
                        "Descrição: Você avança sem hesitar, agarra o oponente com força e desce o cano de metal contra sua cabeça em um golpe seco e brutal."

        );
        put(
                "ViolenciaImprovisada",
                "Tipo: Ataque corpo a corpo\n" +
                        "Teste: d20 + Força vs Defesa\n" +
                        "Dano (sucesso): 2d10 + 3\n" +
                        "Descrição: Sem técnica ou hesitação, você avança usando o que tiver à mão, desferindo golpes caóticos e imprevisíveis contra o alvo."
        );
        put(
                "ImpactoDeslizante",
                "Tipo: Ataque corpo a corpo improvisado\n" +
                        "Teste: d20 + Força vs Defesa\n" +
                        "Dano: 2d10 +3\n" +
                        "Descrição: Avança contra o alvo, desliza por baixo dele e desfere um golpe rápido em movimento."
        );
        put(
                "EsmagaCranios",
                "Tipo: Ataque corpo a corpo\n" +
                        "Teste: d20 + Força vs Defesa\n" +
                        "Dano: 2d10 + 3\n" +
                        "Descrição: Salta e desfere um golpe poderoso na cabeça do alvo."
        );
        put(     "habilidade.esquivaDesesperada",
                "Após vários anos de sua vida sobrevivendo a combates \n" +
                        "extremos, o sobrevivente sabe que ficar na frente de um ataque não é uma opção \n" +
                        "válida, sendo assim, o sobrevivente consegue esquivar de ataques inimigos. (1d4 \n" +
                        "rodadas de cooldown) "
                );

        put(   "habilidade.ultimoFolego",
                "após a vida do personagem ficar menor que 30%, o personagem ganha +1 \n" +
                        "dado de dado do mesmo tipo na arma que está usando e 10% de resistência a dano. \n" +
                        "(1 vez por combate) "
        );

    }};

    public String getAbilities(String key) {
        return abilities.get(key);
    }
    public String getcharacters(String key) {
        return characters.get(key);
    }
    public String getclasses(String key) { return classes.get(key); }
}
