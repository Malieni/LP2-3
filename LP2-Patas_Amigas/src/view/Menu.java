import model.Funcionario;
import model.Animal;
import service.PessoaService;
import service.AnimalService;

import java.util.Scanner;

public class Menu {
    private static PessoaService pessoaService = new PessoaService();
    private static AnimalService animalService = new AnimalService();

    public static void show() {
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Cadastrar Funcionario");
            System.out.println("2. Listar Pessoas");
            System.out.println("3. Cadastrar Animal");
            System.out.println("4. Listar Animais");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = sc.nextInt();
            sc.nextLine(); 

            switch (option) {
                case 1:
                    cadastrarFuncionario(sc);
                    break;
                case 2:
                    pessoaService.listar();
                    break;
                case 3:
                    cadastrarAnimal(sc);
                    break;
                case 4:
                    animalService.listar();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (option != 0);

        sc.close();
    }

    private static void cadastrarFuncionario(Scanner sc) {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Data de Nascimento: ");
        String dataNascimento = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Cargo: ");
        String cargo = sc.nextLine();

        Funcionario funcionario = new Funcionario(nome, dataNascimento, cpf, cargo);
        pessoaService.cadastrar(funcionario);
    }

    private static void cadastrarAnimal(Scanner sc) {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Espécie: ");
        String especie = sc.nextLine();
        System.out.print("Raça: ");
        String raca = sc.nextLine();
        System.out.print("Idade (em anos): ");
        int idade = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Tamanho (Pequeno, Médio, Grande): ");
        String tamanho = sc.nextLine();

        Animal animal = new Animal(nome, especie, raca, idade, tamanho);
        animalService.cadastrar(animal);
    }
}