package model;

import java.util.Scanner;

public interface Papel {

    void exibirDetalhes();

    void editarDetalhes(Scanner scanner);

    String getNomePapel();
}
