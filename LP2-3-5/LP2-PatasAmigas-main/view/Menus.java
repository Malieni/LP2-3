package view;

import java.util.Scanner;

public class Menus {

    public static int menuPrincipal(Scanner scanner, int escolha) {
        // mostra o menu
        System.out.println();
        System.out.println("---- Menu ----");
        System.out.println("1. Página de Cadastro");
        System.out.println("2. Página de Edição");
        System.out.println("3. Página de Visualização");
        System.out.println("4. Buscar");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
        escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha para tirar do buffer

        return escolha;
    }

    public static int menuEscolhaPessoaAnimal(Scanner scanner, int novaEscolha) {
        System.out.println("Selecione uma das opções: ");
        System.out.println("1- Pessoa");
        System.out.println("2- Animal");
        System.out.println("3- Sair");

        novaEscolha = scanner.nextInt();
        scanner.nextLine();

        return novaEscolha;
    }
    public static void sayhello (){
        
        String dogArt = 

        "         / \\__\n" +

        "        (    @\\___\n" +

        "        /         O\n" +

        "      /   (_____ / \n" +

        "    /_____/    \n";



System.out.println(dogArt);
System.out.println("- PATAS AMIGAS -");
    }

}
