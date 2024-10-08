import java.util.Scanner;

public class Menu {
    public static void show() {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Cadastrar Pessoa");
            System.out.println("2. Listar Pessoas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    PessoaManager.cadastrarPessoa();
                    break;
                case 2:
                    PessoaManager.listarPessoas();
                    break;
                case 0:
                    System.out.println("\n--- Obrigado por usar nosso sistema! ---");
                    break;
                default:
                    System.out.println("\n--- Opção inválida! Tente novamente. ---");
            }
        } while (option != 0);

        sc.close();

    }
}
