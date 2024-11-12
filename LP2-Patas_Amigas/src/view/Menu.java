import model.Funcionario;
import model.Pessoa;
import service.PessoaService;

import java.util.Scanner;

public class Menu {
    private static PessoaService pessoaService = new PessoaService();

    public static void show() {
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Cadastrar Funcionario");
            System.out.println("2. Listar Pessoas");
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
        // tem que ser um cpf valido ? 0 vontade de fazer aquele negócio de validar cpf...
        System.out.print("Cargo: ");
        String cargo = sc.nextLine();

        Funcionario funcionario = new Funcionario(nome, dataNascimento, cpf, cargo);
        pessoaService.cadastrar(funcionario);
    }
}
