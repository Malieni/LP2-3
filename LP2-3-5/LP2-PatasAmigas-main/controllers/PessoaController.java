package controllers;

import funcoes_compartilhadas.Funcoes;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.Adotante;
import model.Animal;
import model.Funcionarios;
import model.HistoricoAdotante;
import model.HistoricoTutor;
import model.Papel;
import model.Pessoa;
import model.PreferenciaAdocao;
import model.TipoAnimal;
import model.Tutores;

public class PessoaController {

    private static ArrayList<Pessoa> listaPessoas = new ArrayList<>();

    public static Pessoa cadastrarPessoa(Scanner scanner) {

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a data de nascimento (formato: AAAA-MM-DD): ");
        LocalDate nascimento = LocalDate.parse(scanner.nextLine());

        System.out.print("Digite o gênero : ('M' para masculino, 'F' para feminino e 'O' para outros): ");
        String genero = scanner.nextLine();

        System.out.print("Digite o CPF: (ex.: 123.123.123-12): ");
        String CPF = scanner.nextLine();

        System.out.print("Digite o logradouro: ");
        String logradouro = scanner.nextLine();

        System.out.print("Digite o número: ");
        String numero = scanner.nextLine();

        System.out.print("Digite o bairro: ");
        String bairro = scanner.nextLine();

        System.out.print("Digite a cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("Digite o estado: ");
        String estado = scanner.nextLine();

        System.out.print("Digite o país: ");
        String pais = scanner.nextLine();

        System.out.print("Digite o telefone: (ex.: '11 11111-1111'): ");
        String telefone = scanner.nextLine();

        System.out.print("Digite o email: ");
        String email = scanner.nextLine();

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();
        String hashsenha = Funcoes.generateHash(senha);

        System.out.println();

        // Inicializa uma nova pessoa
        Pessoa novaPessoa = new Pessoa(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais,
                telefone, email, hashsenha);

        // Pergunta se a pessoa é tutor
        System.out.print("Essa pessoa é um tutor? (s/n)\n");
        String resposta = scanner.nextLine();
        boolean ehTutor = resposta.equalsIgnoreCase("s");

        if (ehTutor) {
            System.out.print("Digite o id do Tutor: ");
            int id_tutor = scanner.nextInt();

            System.out.print("Quantos animais estão sob sua custódia? ");
            int animaisCustodia = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha para tirar do buffer

            System.out.print("Digite a descrição do histórico do tutor: ");
            String descricaoHistoricoT = scanner.nextLine();

            System.out.print("Digite o número de adoções realizadas: ");
            int numeroAdocoesT = Integer.parseInt(scanner.nextLine());

            System.out.print("Tutor está ativo? (s/n)\n");
            resposta = scanner.nextLine();
            boolean statusTutor = resposta.equalsIgnoreCase("s");
            HistoricoTutor historico_tutor = new HistoricoTutor(descricaoHistoricoT, numeroAdocoesT);

            // Cria um objeto Tutor e o adiciona à pessoa
            novaPessoa.adicionarPapel(new Tutores(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade,
                    estado, pais, telefone, email, hashsenha, id_tutor, animaisCustodia, historico_tutor, statusTutor));
        }

        // Pergunta se a pessoa é adotante
        System.out.println();
        System.out.print("Essa pessoa é um adotante? (s/n)\n");
        resposta = scanner.nextLine();
        boolean ehAdotante = resposta.equalsIgnoreCase("s");

        if (ehAdotante) {
            System.out.print("Digite o ID do adotante: ");
            int id_adotante = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha para tirar do buffer

            System.out.print("Digite a descrição da preferência de adoção: ");
            String descricaoPreferencia = scanner.nextLine();

            System.out.print("Qual o tipo de animal preferido? (Cachorro, Gato, Coelho ou Outro): ");
            TipoAnimal tipoAnimal = TipoAnimal.valueOf(scanner.nextLine().toLowerCase());
            //valueOf é utilizado para converter String em Enum

            System.out.print("Qual a idade preferida do animal? (Apenas o número):");
            String idadePreferida = scanner.nextLine();

            System.out.print("Qual o tamanho preferido do animal? (Apenas o numero em centimetros):");
            String tamanhoPreferido = scanner.nextLine();

            System.out.print("Qual o sexo preferido do animal (M/F)?:");
            String sexoPreferido = scanner.nextLine();

            System.out.print("Deseja considerar animais com necessidades especiais? (s/n): ");
            String respostaNecessidadeEspeciais = scanner.nextLine();
            boolean necessidadeEspeciais = respostaNecessidadeEspeciais.equalsIgnoreCase("s");

            PreferenciaAdocao preferenciaAdocao = new PreferenciaAdocao(
                    descricaoPreferencia,
                    0,
                    tipoAnimal,
                    idadePreferida,
                    tamanhoPreferido,
                    sexoPreferido,
                    necessidadeEspeciais
            );

            System.out.print("Digite a descrição do histórico do adotante: ");
            String descricaoHistorico = scanner.nextLine();

            System.out.print("Digite o número de adoções realizadas: ");

            int numeroAdocoes = Integer.parseInt(scanner.nextLine());

            System.out.print("Qual a data da última adoção (formato: AAAA-MM-DD): ");
            LocalDate dataUltimaAdocao = LocalDate.parse(scanner.nextLine());

            List<Animal> animaisAdotados = new ArrayList<>();

            HistoricoAdotante historico_adotante = new HistoricoAdotante(
                    descricaoHistorico,
                    numeroAdocoes,
                    dataUltimaAdocao,
                    animaisAdotados
            );

            // Adiciona os dados do Adotante
            novaPessoa.adicionarPapel(new Adotante(
                    nome,
                    nascimento,
                    genero,
                    CPF,
                    logradouro,
                    numero,
                    bairro,
                    cidade,
                    estado,
                    pais,
                    telefone,
                    email,
                    hashsenha,
                    id_adotante,
                    preferenciaAdocao,
                    historico_adotante,
                    true
            ));
        }

        // Pergunta se a pessoa é funcionário
        System.out.println();
        System.out.print("Essa pessoa é um funcionário? (s/n)\n");
        resposta = scanner.nextLine();
        boolean ehFuncionario = resposta.equalsIgnoreCase("s");

        if (ehFuncionario) {
            System.out.print("Digite o ID do funcionário: ");
            int id_funcionario = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha para tirar do buffer

            System.out.print("Digite a data de contratação (formato: AAAA-MM-DD): ");
            LocalDate dataContratacao = LocalDate.parse(scanner.nextLine());

            System.out.print("Digite o cargo do funcionário: ");
            String cargo = scanner.nextLine();

            System.out.print("Digite o salário do funcionário: ");
            float salario = scanner.nextFloat();
            scanner.nextLine(); // Consumir a nova linha para tirar do buffer

            System.out.print("Digite o departamento do funcionário: ");
            String departamento = scanner.nextLine();

            novaPessoa.adicionarPapel(new Funcionarios(
                    nome,
                    nascimento,
                    genero,
                    CPF,
                    logradouro,
                    numero,
                    bairro,
                    cidade,
                    estado,
                    pais,
                    telefone,
                    email,
                    hashsenha,
                    id_funcionario,
                    dataContratacao,
                    cargo,
                    salario,
                    departamento
            ));
        }

        // Adiciona a nova pessoa na lista de pessoas
        listaPessoas.add(novaPessoa);
        return novaPessoa;
    }

    public static void visualizarDadosPessoa(Scanner scanner) {

        System.out.println("---- Lista de Pessoas ----");
        for (int i = 0; i < listaPessoas.size(); i++) {
            System.out.println((i + 1) + ". " + listaPessoas.get(i).getNome());
        }

        System.out.println("Escolha o número da pessoa para ver os detalhes:");
        int escolha = scanner.nextInt();

        if (escolha > 0 && escolha <= listaPessoas.size()) {
            Pessoa pessoaEscolhida = listaPessoas.get(escolha - 1);

            // Exibe as infos de pessoas em formato de tabela
            System.out.printf("\n---- Detalhes de %s ----\n", pessoaEscolhida.getNome());
            System.out.printf("%-15s %-30s\n", "Atributo", "Valor");
            System.out.println("------------------------------");
            System.out.printf("%-15s %-30s\n", "Nome", pessoaEscolhida.getNome());
            System.out.printf("%-15s %-30s\n", "Nascimento", pessoaEscolhida.getNascimento());
            System.out.printf("%-15s %-30s\n", "Gênero", pessoaEscolhida.getGenero());
            System.out.printf("%-15s %-30s\n", "CPF", pessoaEscolhida.getCPF());
            System.out.printf("%-15s %-30s\n", "Logradouro", pessoaEscolhida.getLogradouro());
            System.out.printf("%-15s %-30s\n", "Número", pessoaEscolhida.getNumero());
            System.out.printf("%-15s %-30s\n", "Bairro", pessoaEscolhida.getBairro());
            System.out.printf("%-15s %-30s\n", "Cidade", pessoaEscolhida.getCidade());
            System.out.printf("%-15s %-30s\n", "Estado", pessoaEscolhida.getEstado());
            System.out.printf("%-15s %-30s\n", "País", pessoaEscolhida.getPais());
            System.out.printf("%-15s %-30s\n", "Telefone", pessoaEscolhida.getTelefone());
            System.out.printf("%-15s %-30s\n", "E-mail", pessoaEscolhida.getEmail());

            // Exibe as infos dos papeis em tabela
            System.out.println("\n---- Infos dos Papeis ----");
            for (Papel papel : pessoaEscolhida.getPapeis()) {
                System.out.println("-----------------------------------------------");
                System.out.printf("         ---- %s ----\n", papel.getNomePapel());
                System.out.printf("%-25s %-30s\n", "Atributo", "Valor");
                System.out.println("-----------------------------------------------");
                papel.exibirDetalhes();
            }

        } else {
            System.out.println("Escolha inválida.");
        }
    }

    public static Pessoa escolherPessoa(Scanner scanner) {

        System.out.println("---- Pessoas Cadastradas ----");

        for (int i = 0; i < listaPessoas.size(); i++) {
            Pessoa pessoa = listaPessoas.get(i);
            System.out.println((i + 1) + ". " + pessoa.getNome());
        }

        System.out.print("Escolha a pessoa que deseja editar: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha do buffer

        if (escolha > 0 && escolha <= listaPessoas.size()) {
            Pessoa pessoaSelecionada = listaPessoas.get(escolha - 1);
            return pessoaSelecionada;
        } else {
            System.out.println("Essa pessoa não existe. Tente novamente");
            return null;
        }

    }

    public static void editarPessoa(Scanner scanner, Pessoa pessoa) {

        System.out.println();
        System.out.println("Editando informações de " + pessoa.getNome());
        System.out.println("Escolha o atributo que deseja editar:");
        System.out.println("1 - Nome");
        System.out.println("2 - Data de nascimento");
        System.out.println("3 - Gênero");
        System.out.println("4 - CPF");
        System.out.println("5 - Endereço (Logradouro, Número, Bairro, Cidade, Estado, País)");
        System.out.println("6 - Telefone");
        System.out.println("7 - Email");
        System.out.println("8 - Senha");
        System.out.println("9 - Editar infos de um papel específico");

        System.out.printf("Digite o número do campo que deseja editar:");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha para tirar do buffer
        System.out.println();

        switch (opcao) {

            case 1:
                System.out.println("Digite o novo nome: ");
                String novoNome = scanner.nextLine();
                pessoa.setNome(novoNome);
                break;

            case 2:
                System.out.println("Digite a nova data de nascimento (formato: AAAA-MM-DD):");
                LocalDate novaData = LocalDate.parse(scanner.nextLine());
                pessoa.setNascimento(novaData);
                break;

            case 3:
                System.out.println("Digite o novo gênero:");
                String novoGenero = scanner.nextLine();
                pessoa.setGenero(novoGenero);
                break;

            case 4:
                System.out.println("Digite o novo CPF:");
                String novoCPF = scanner.nextLine();
                pessoa.setCPF(novoCPF);
                break;

            case 5:
                System.out.println("Digite o novo logradouro:");
                String logradouro = scanner.nextLine();
                pessoa.setLogradouro(logradouro);

                System.out.println("Digite o novo número:");
                String numero = scanner.nextLine();
                pessoa.setNumero(numero);

                System.out.println("Digite o novo bairro:");
                String bairro = scanner.nextLine();
                pessoa.setBairro(bairro);

                System.out.println("Digite a nova cidade:");
                String cidade = scanner.nextLine();
                pessoa.setCidade(cidade);

                System.out.println("Digite o novo estado:");
                String estado = scanner.nextLine();
                pessoa.setEstado(estado);

                System.out.println("Digite o novo país:");
                String pais = scanner.nextLine();
                pessoa.setPais(pais);
                break;

            case 6:
                System.out.println("Digite o novo telefone:");
                String telefone = scanner.nextLine();
                pessoa.setTelefone(telefone);
                break;

            case 7:
                System.out.println("Digite o novo email:");
                String email = scanner.nextLine();
                pessoa.setEmail(email);
                break;

            case 8:
                System.out.println("Digite a nova senha:");
                String novaSenha = scanner.nextLine();
                pessoa.setHashsenha(novaSenha);
                break;

            case 9:
                editarPapeis(scanner, pessoa);
                break;

            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public static void editarPapeis(Scanner scanner, Pessoa pessoa) {
        List<Papel> papeis = pessoa.getPapeis();
        if (papeis.isEmpty()) {
            System.out.println("Esta pessoa não possui papéis.");
            return;
        }

        System.out.println("Escolha o papel que deseja editar:");
        for (int i = 0; i < papeis.size(); i++) {
            System.out.println((i + 1) + " - " + papeis.get(i).getClass().getSimpleName());
        }
        //Percorre a lista de papéis e usa os métodos getClass() e getSimpleName() para pegar o nome da classe e retornar em string para facilitar a leitura

        int escolhaPapel = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir a nova linha

        if (escolhaPapel >= 0 && escolhaPapel < papeis.size()) {
            Papel papelSelecionado = papeis.get(escolhaPapel);
            papelSelecionado.editarDetalhes(scanner);
        } else {
            System.out.println("Opção de papel inválida!");
        }
    }

    public static void filtrarPessoa(Scanner scanner) {

        System.out.println("Digite um nome para buscar: ");
        String escolhaNome = scanner.nextLine();

        // Filtra a lista de pessoas pelo nome
        List<Pessoa> pessoasEncontradas = listaPessoas.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(escolhaNome))
                .collect(Collectors.toList());

        // Verifica se a pessoa foi encontrada
        if (pessoasEncontradas != null) {
            System.out.println("Pessoas encontradas': \n\n" + pessoasEncontradas);
            pessoasEncontradas.forEach(pessoa -> System.out.println(pessoa));
        } else {
            System.out.println("Nenhuma pessoa com o nome '" + escolhaNome + "' foi encontrada.");
        }
    }
}
