import java.util.ArrayList;
import java.util.Scanner;

public class PessoaManager {
    private static ArrayList<Pessoa> pessoas = new ArrayList<>();

    public static void cadastrarPessoa() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Data de Nascimento: ");
        String dataNascimento = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        Pessoa novaPessoa = new Pessoa(nome, dataNascimento, cpf);
        pessoas.add(novaPessoa);
        System.out.println("Pessoa cadastrada com sucesso!");
    }

    public static void listarPessoas() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            for (Pessoa pessoa : pessoas) {
                System.out.println(pessoa);
            }
        }
    }
}
