package unip.joo.model.entities;

import unip.joo.model.ENUM.NomeAtributo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public abstract class Personagem implements Descritivel { // Classe Abstrata
    private long id; // Encapsulamento
    protected String nome; // Encapsulamento
    protected String descricao;
    protected Classe classe;
    protected Map<String, String> fala;
    protected Inventario inventario;

    // Método Construtor


    public Personagem(long id, String nome, String descricao, Classe classe, Map<String, String> fala, Inventario inventario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.classe = classe;
        this.fala = fala;
        this.inventario = inventario;
    }

    public long getId() {
        return id;
    }
    
    public String getNome() { return nome; }

    public String getDescricao() {
        return descricao;
    }

    public String getFala(String key) {
        return fala.get(key);
    }
    public Map<String, String> getAllFalas() { return new LinkedHashMap<>(fala); }
    public Classe getClasse() { return classe; }

    public Inventario getInventario() {
        return inventario;
    }

    public boolean transferItemTo(Item item, Personagem destino) {
        if (item == null || destino == null || inventario == null || destino.getInventario() == null) {
            return false;
        }

        if (!inventario.removeItem(item)) {
            return false;
        }

        boolean adicionado = destino.getInventario().addItem(item);
        if (!adicionado) {
            inventario.addItem(item);
            return false;
        }

        return true;
    }

    public String getStatus() {
        StringBuilder status = new StringBuilder();
        status.append("========== STATUS ==========\n");
        status.append("Nome: ").append(nome).append("\n");
        status.append("Vida: ").append(classe.getVida()).append("  |  Defesa: ").append(classe.getDefesa()).append("\n");
        status.append("-------- Atributos --------\n");
        status.append("Forca: ").append(classe.getAtributo(NomeAtributo.FORCA)).append("\n");
        status.append("Agilidade: ").append(classe.getAtributo(NomeAtributo.AGILIDADE)).append("\n");
        status.append("Vigor: ").append(classe.getAtributo(NomeAtributo.VIGOR)).append("\n");
        status.append("Intelecto: ").append(classe.getAtributo(NomeAtributo.INTELECTO)).append("\n");
        status.append("===========================");
        return status.toString();
    }
    public String profile() {
        StringBuilder perfil = new StringBuilder();
        perfil.append("========== PERFIL ==========\n");
        perfil.append("Nome: ").append(nome).append("  |  Vida: ").append(classe.getVida()).append("  |  Defesa: ").append(classe.getDefesa()).append("\n");
        perfil.append("-------- Atributos --------\n");
        perfil.append("Forca: ").append(classe.getAtributo(NomeAtributo.FORCA)).append("  |  ");
        perfil.append("Agilidade: ").append(classe.getAtributo(NomeAtributo.AGILIDADE)).append("\n");
        perfil.append("Vigor: ").append(classe.getAtributo(NomeAtributo.VIGOR)).append("  |  ");
        perfil.append("Intelecto: ").append(classe.getAtributo(NomeAtributo.INTELECTO)).append("\n");
        perfil.append("------ Descricao do Personagem ------\n");
        perfil.append(descricao).append("\n");
        perfil.append("-------- Classe --------\n");
        perfil.append("Nome: ").append(classe.getNomeClasse()).append("\n\n");
        perfil.append("Habilidades: ").append(classe.getNameAbilities()).append("\n\n");
        perfil.append("Descricao: ").append(classe.getDescricao()).append("\n\n");
        perfil.append("===========================");
        return perfil.toString();
    }

    public void inventoryOpen(Scanner scanner) {
        if (inventario == null) {
            System.out.println("Nenhum inventário disponível.");
            return;
        }

        List<Item> itens = inventario.getItens();
        
        while (true) {
            System.out.println("\n========== INVENTÁRIO ==========");
            System.out.println("Personagem: " + nome);
            
            if (itens.isEmpty()) {
                System.out.println("Inventário vazio.");
                break;
            }

            // Exibir itens
            for (int i = 0; i < itens.size(); i++) {
                Item item = itens.get(i);
                System.out.println("["+(i + 1) + "] " + item.getNome());
                System.out.println("   " + item.obterResumo().replace("\n", "\n   "));
            }
            
            System.out.println("["+(itens.size() + 1) + "] . Sair");
            System.out.println("===============================");
            System.out.print("Selecione um item: ");
            
            try {
                String input = scanner.nextLine();
                int escolha = Integer.parseInt(input);
                
                if (escolha == itens.size() + 1) {
                    System.out.println("Fechando inventário...");
                    break;
                }
                
                if (escolha < 1 || escolha > itens.size()) {
                    System.out.println("Opção inválida!");
                    continue;
                }

                Item itemSelecionado = itens.get(escolha - 1);
                exibirOpcoesPorTipo(scanner, itemSelecionado, itens);
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida!");
            }
        }
    }

    private void exibirOpcoesPorTipo(Scanner scanner, Item item, List<Item> itens) {
        if (item instanceof KitSobrevivencia) {
            manipularConsumivel(scanner, (KitSobrevivencia) item, itens);
        } else if (item instanceof Equipamento) {
            manipularEquipamento(scanner, (Equipamento) item);
        }
    }

    private void manipularConsumivel(Scanner scanner, KitSobrevivencia kit, List<Item> itens) {
        System.out.println("\n--- Opções do Consumível ---");
        System.out.println("[1] Usar");
        System.out.println("[2] Voltar");
        System.out.print("Escolha: ");
        
        try {
            String input = scanner.nextLine();
            int choice = Integer.parseInt(input);
            
            if (choice == 1) {
                if (kit.usar(this)) {
                    System.out.println("Item consumido!");
                    double percentual = kit.getCuraPercentual() / 100.0;
                    int heal = (int) (getClasse().getVida() * percentual);
                    int newLife = getClasse().getVida() + heal;
                    getClasse().setVida(newLife);
                    if (kit.getUsosRestantes() <= 0) {
                        itens.remove(kit);
                        System.out.println("Item foi removido do inventário.");
                    }
                } else {
                    System.out.println("Não foi possível usar este item.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida!");
        }
    }

    private void manipularEquipamento(Scanner scanner, Equipamento equipamento) {
        System.out.println("\n--- Opções do Equipamento ---");
        
        try {
            if (equipamento.isEquipado()) {
                System.out.println("[1] Desequipar");
                System.out.println("[2] Voltar");
                System.out.print("Escolha: ");
                
                String input = scanner.nextLine();
                int escolha = Integer.parseInt(input);
                if (escolha == 1) {
                    equipamento.desequipar();
                    System.out.println("Equipamento desequipado.");
                }
            } else {
                System.out.println("[1] Equipar");
                System.out.println("[2] Voltar");
                System.out.print("Escolha: ");
                
                String input = scanner.nextLine();
                int escolha = Integer.parseInt(input);
                if (escolha == 1) {
                    equipamento.equipar();
                    System.out.println("Equipamento equipado.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida!");
        }
    }

    // Menu de Personagem
    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("\n========== MENU DO PERSONAGEM ==========");
            System.out.println("[1] Abrir Perfil");
            System.out.println("[2] Ver Status");
            System.out.println("[3] Ver Inventário");
            System.out.println("[4] Ver Habilidades");
            System.out.println("[5] Sair");
            System.out.println("========================================");
            System.out.print("Escolha uma opção: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                
                if (choice < 1 || choice > 5) {
                    System.out.println("Opção inválida!");
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.println(profile());
                        scanner.nextLine();
                        break;
                    case 2:
                        System.out.println(getStatus());
                        scanner.nextLine();
                        break;
                    case 3:
                        inventoryOpen(scanner);
                        break;
                    case 4:
                        showAbilities(scanner);
                        break;
                    case 5:
                        System.out.println("Fechando menu...");
                        return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida!");
            }
        }
    }

    // Função para exibir habilidades
    public void showAbilities(Scanner scanner) {
        if (classe == null) {
            System.out.println("Nenhuma classe disponível.");
            scanner.nextLine();
            return;
        }

        List<Habilidade> habilidades = classe.getHabilidades();
        
        if (habilidades == null || habilidades.isEmpty()) {
            System.out.println("Nenhuma habilidade disponível.");
            scanner.nextLine();
            return;
        }

        System.out.println("\n========== HABILIDADES ==========");
        for (Habilidade habilidade : habilidades) {
            System.out.println("- " + habilidade.getNome());
            System.out.println("  Descrição: " + habilidade.getDescricao());
            System.out.println("  Dados: " + habilidade.getQuantidadeDado() + "d" + habilidade.getValorDado() + " + " + habilidade.getValorExtra());
            System.out.println();
        }
        System.out.println("=================================");
        System.out.print("Pressione [ENTER] para continuar: ");
        scanner.nextLine();
    }

    public abstract String getTipo(); // Método Abstrato

}
