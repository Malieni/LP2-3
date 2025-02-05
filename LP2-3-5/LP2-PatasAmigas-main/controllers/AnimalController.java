package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import model.Animal;
import model.HistoricoMedico;
import view.Menus;

public class AnimalController {

    private static ArrayList<Animal> listaAnimais = new ArrayList<>();

    public static Animal cadastrarAnimal(Scanner scanner) {

        String nome, especie, tutor, descricaoMed, tratamentoMed, medicacaoMed, obsMed;
        Integer id, idade;
        Double pesoMed;
        boolean statusAdocao;

        System.out.println("Qual é o ID do animal?");
        id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nQual é o nome do animal?");
        nome = scanner.nextLine();

        System.out.println("\nE de que espécie ele é?");
        especie = scanner.nextLine();

        System.out.println("\nVocê sabe a idade dele? (digite sim ou não)");
        String resposta = scanner.nextLine();
        boolean sabeIdade = resposta.equalsIgnoreCase("sim");

        if (sabeIdade) {
            System.out.println("\nCerto, digite aqui a idade do animal: (apenas números)");
            idade = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("\nTudo certo! Vamos pular essa etapa.");
            scanner.nextLine();
            idade = null;
        }

        System.out.println(
                "\nJá estamos finalizando! Mas precisamos saber do histórico do animal.\nDigite aqui uma descrição breve do estado de saúde do animal: ");
        descricaoMed = scanner.nextLine();

        System.out.println("\nO animal faz ou fez algum tipo de tratamento recentemente? Se sim, qual? ");
        tratamentoMed = scanner.nextLine();

        System.out.println("\nQual o peso do animal? (Em kg) ");
        pesoMed = Double.parseDouble(scanner.nextLine());

        System.out.println("\nO animal toma alguma medicação controlada? Se sim, qual? ");
        medicacaoMed = scanner.nextLine();

        System.out
                .println("\nIndique no espaço abaixo outras observações que julgue importante sobre a saúde do pet! ");
        obsMed = scanner.nextLine();

        System.out.println("\nPor último, ele está sob a tutoria de quem? \nDigite o nome da pessoa: ");
        tutor = scanner.nextLine();

        HistoricoMedico historicoMed = new HistoricoMedico(descricaoMed, tratamentoMed, pesoMed, medicacaoMed, obsMed);
        statusAdocao = false;

        Animal novoAnimal = new Animal(id, idade, nome, especie, historicoMed, statusAdocao, tutor);

        listaAnimais.add(novoAnimal);
        return novoAnimal;
    }

    public static void filtrarAnimal(Scanner scanner) {
        int escolha;

        System.out.println("Desejar filtrar por: ");
        System.out.println("1 - Espécie");
        System.out.println("2 - Idade");
        System.out.println("3 - Status de Adoção");
        System.out.println("4 - Voltar");
        escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                filtrarEspecie(scanner);
                break;

            case 2:
                filtrarIdade(scanner);
                break;

            case 3:
                filtrarStatusAdocao(scanner);

            default:
            Menus.menuEscolhaPessoaAnimal(scanner, escolha);
            break;
        }
    }

    public static void filtrarEspecie(Scanner scanner) {
        System.out.println("Qual é a especie do animal?");
        String escolhaEspecie = scanner.nextLine();

        List<Animal> animaisEncontrados = listaAnimais.stream()
                .filter(a -> a.getEspecie().equalsIgnoreCase(escolhaEspecie))
                .collect(Collectors.toList());

        if (animaisEncontrados != null) {
            System.out.println("Animais dessa espécie encontrados: \n");
            animaisEncontrados.forEach(animal -> System.out.println(animal));
        } else {
            System.out.println("Nenhum animal da espécie " + escolhaEspecie + " foi encontrado!");
        }
    }

    public static void filtrarIdade(Scanner scanner) {
        System.out.println("Qual é a idade do animal?");
        int escolhaIdade = scanner.nextInt();

        List<Animal> animaisEncontrados = listaAnimais.stream()
                .filter(a -> a.getIdade().equals(escolhaIdade))
                .collect(Collectors.toList());

        if (animaisEncontrados != null) {
            System.out.println("Animais com essa idade foram encontrados: \n");
            animaisEncontrados.forEach(animal -> System.out.println(animal));
        } else {
            System.out.println("Nenhum animal da idade: " + escolhaIdade + ", foi encontrado!");
        }
    }

    public static void filtrarStatusAdocao(Scanner scanner) {
        System.out.println("Você deseja filtrar animais:");
        System.out.println("1 - Adotados");
        System.out.println("2 - Disponíveis");
        System.out.println("3 - Voltar");
        int escolha = scanner.nextInt();

        boolean adotado;

        switch (escolha) {
            case 1:
            adotado = true;
            List<Animal> animaisAdotados = listaAnimais.stream()
                .filter(a -> a.getStatusAdocao().equals(adotado))
                .collect(Collectors.toList());

                if (animaisAdotados!= null) {
                    System.out.println("Foram encontrados" + animaisAdotados.size() + " adotados\n");
                    animaisAdotados.forEach(animal -> System.out.println(animal));
                } else {
                    System.out.println("Nenhum animal adotado foi encontrado!");
                }
                break;
            case 2:
            adotado = false;
            List<Animal> animaisDisponiveis = listaAnimais.stream()
                .filter(a -> a.getStatusAdocao().equals(adotado))
                .collect(Collectors.toList());

                if (animaisDisponiveis != null) {
                    System.out.println("Foram encontrados" + animaisDisponiveis.size() + " disponíveis\n");
                    animaisDisponiveis.forEach(animal -> System.out.println(animal));
                } else {
                    System.out.println("Nenhum animal disponível para a adoção foi encontrado!");
                }
                break;
            default:
            filtrarAnimal(scanner);
        }
    }

    public static void visualizarDadosAnimal(Scanner scanner) {

        System.out.println("---- Lista de Animais ----");
        for (int i = 0; i < listaAnimais.size(); i++) {
            System.out.println((i + 1) + ". " + listaAnimais.get(i).getNome());
        }

        System.out.println("Escolha o nome do animal para ver os detalhes:");
        int escolha = scanner.nextInt();

        if (escolha > 0 && escolha <= listaAnimais.size()) {
            Animal animalEscolhido = listaAnimais.get(escolha - 1);
            System.out.printf("\n---- Detalhes de %s ----\n", animalEscolhido.getNome());
            System.out.printf("%-25s %-30s\n", "Atributo", "Valor");
            System.out.println("------------------------------");

            System.out.printf("%-25s %-30s\n", "Id:", animalEscolhido.getIdAnimal());
            System.out.printf("%-25s %-30s\n", "Nome:", animalEscolhido.getNome());
            System.out.printf("%-25s %-30s\n", "Especie:", animalEscolhido.getEspecie());
            System.out.printf("%-25s %-30s\n", "Idade:", animalEscolhido.getIdade());
            System.out.printf("%-25s %-30s\n", "Histórico médico: ", animalEscolhido.getHistoricoMed().getDescricao());
            System.out.printf("%-25s %-30s\n", "Tratamento: ", animalEscolhido.getHistoricoMed().getTratamento());
            System.out.printf("%-25s %-30s\n", "Peso: ", animalEscolhido.getHistoricoMed().getPeso());
            System.out.printf("%-25s %-30s\n", "Medicação: ", animalEscolhido.getHistoricoMed().getMedicacao());
            System.out.printf("%-25s %-30s\n", "Observações: ", animalEscolhido.getHistoricoMed().getObservacoes());
            System.out.printf("%-25s %-30s\n", "Status da Adoção:", animalEscolhido.getStatusAdocao());
            System.out.printf("%-25s %-30s\n", "Tutor:", animalEscolhido.getTutor());

        } else {
            System.out.println("Escolha inválida.");
        }
    }

    public static Animal escolherAnimal(Scanner scanner) {

        System.out.println("---- Animais Cadastrados ----");

        for (int i = 0; i < listaAnimais.size(); i++) {
            Animal animal = listaAnimais.get(i);
            System.out.println((i + 1) + ". " + animal.getNome());
        }

        System.out.print("Escolha o animal que deseja editar: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha do buffer

        if (escolha > 0 && escolha <= listaAnimais.size()) {
            Animal animalSelecionado = listaAnimais.get(escolha - 1);
            return animalSelecionado;
        } else {
            System.out.println("Esse animal ainda não foi cadastrado. Tente novamente");
            return null;
        }

    }

    public static void editarAnimal(Scanner scanner, Animal animal) {
        System.out.println();
        System.out.println("Editando informações do animal: " + animal.getNome());
        System.out.println("Escolha o atributo que deseja editar:");
        System.out.println("1 - Nome");
        System.out.println("2 - Espécie");
        System.out.println("3 - Idade");
        System.out.println("4 - Tutor");
        System.out.println("5 - Status de Adoção");
        System.out.println("6 - Histórico Médico");

        System.out.printf("Digite o número do campo que deseja editar: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        switch (opcao) {
            case 1:
                System.out.println("Digite o novo nome: ");
                String novoNome = scanner.nextLine();
                animal.setNome(novoNome);
                break;

            case 2:
                System.out.println("Digite a nova espécie: ");
                String novaEspecie = scanner.nextLine();
                animal.setEspecie(novaEspecie);
                break;

            case 3:
                System.out.println("Digite a nova idade: ");
                int novaIdade = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha
                animal.setIdade(novaIdade);
                break;

            case 4:
                System.out.println("Digite o novo tutor: ");
                String novoTutor = scanner.nextLine();
                animal.setTutor(novoTutor);
                break;

            case 5:
                System.out.println("Digite o novo status de adoção (adotado/nao-adotado): ");
                String resposta = scanner.nextLine();
                boolean novoStatus = resposta.equalsIgnoreCase("adotado");
                animal.setStatusAdocao(novoStatus);
                break;

            case 6:
                editarHistoricoMedico(scanner, animal.getHistoricoMed());
                break;

            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public static void editarHistoricoMedico(Scanner scanner, HistoricoMedico historicoMed) {
        System.out.println();
        System.out.println("Editando histórico médico:");
        System.out.println("Escolha o atributo que deseja editar:");
        System.out.println("1 - Descrição");
        System.out.println("2 - Tratamento");
        System.out.println("3 - Peso");
        System.out.println("4 - Medicação");
        System.out.println("5 - Observações");

        System.out.printf("Digite o número do campo que deseja editar: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        switch (opcao) {
            case 1:
                System.out.println("Digite a nova descrição: ");
                String novaDescricao = scanner.nextLine();
                historicoMed.setDescricao(novaDescricao);
                break;

            case 2:
                System.out.println("Digite o novo tratamento: ");
                String novoTratamento = scanner.nextLine();
                historicoMed.setTratamento(novoTratamento);
                break;

            case 3:
                System.out.println("Digite o novo peso: ");
                double novoPeso = scanner.nextDouble();
                scanner.nextLine(); // Consumir nova linha
                historicoMed.setPeso(novoPeso);
                break;

            case 4:
                System.out.println("Digite a nova medicação: ");
                String novaMedicacao = scanner.nextLine();
                historicoMed.setMedicacao(novaMedicacao);
                break;

            case 5:
                System.out.println("Digite as novas observações: ");
                String novasObservacoes = scanner.nextLine();
                historicoMed.setObservacoes(novasObservacoes);
                break;

            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    // public static Void deletarPessoa() {
    //     System.out.println("Qual pessoa você deseja ");

    // }
}
