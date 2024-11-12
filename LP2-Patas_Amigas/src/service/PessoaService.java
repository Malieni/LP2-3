package service;

import model.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class PessoaService implements Cadastro<Pessoa> {
    private List<Pessoa> pessoas;

    public PessoaService() {
        this.pessoas = new ArrayList<>();
    }

    @Override
    public void cadastrar(Pessoa pessoa) {
        if (!pessoas.contains(pessoa)) {
            pessoas.add(pessoa);
            System.out.println("Pessoa cadastrada com sucesso.");
        } else {
            System.out.println("Pessoa já está cadastrada.");
        }
    }

    @Override
    public void listar() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            pessoas.forEach(System.out::println);
        }
    }
}
