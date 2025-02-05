package view;

import controllers.*;
import java.util.Scanner;

public class FiltroView {

    public static void buscaPorFiltro(Scanner scanner, int escolhaBuscar) {

        switch (escolhaBuscar) {
            case 1:
                PessoaController.filtrarPessoa(scanner);
                break;
            case 2:
                AnimalController.filtrarAnimal(scanner);
                break;
            case 3:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

}
