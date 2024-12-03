package service;

import model.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalService implements Cadastro<Animal> {
    private List<Animal> animais;

    public AnimalService() {
        this.animais = new ArrayList<>();
    }

    @Override
    public void cadastrar(Animal animal) {
        if (!animais.contains(animal)) {
            animais.add(animal);
            System.out.println("Animal cadastrado com sucesso.");
        } else {
            System.out.println("Animal já está cadastrado.");
        }
    }

    @Override
    public void listar() {
        if (animais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
        } else {
            animais.forEach(System.out::println);
        }
    }
    
    public List<Animal> buscarAnimais(String raca, Integer idadeMinima, Integer idadeMaxima, String tamanho) {
        List<Animal> resultados = new ArrayList<>();
        for (Animal animal : animais) {
            boolean matches = true;
            if (raca != null && !raca.isEmpty() && !animal.getRaca().equalsIgnoreCase(raca)) {
                matches = false;
            }
            if (idadeMinima != null && animal.getIdade() < idadeMinima) {
                matches = false;
            }
            if (idadeMaxima != null && animal.getIdade() > idadeMaxima) {
                matches = false;
            }
            if (tamanho != null && !tamanho.isEmpty() && !animal.getTamanho().equalsIgnoreCase(tamanho)) {
                matches = false;
            }
            if (matches) {
                resultados.add(animal);
            }
        }    // tem que testar o tratamento de exceções e ver se n vai dar problema.
            // o front eu testei em outro rep e bagunçou, falei com o quirino e ele disse que vai ajudar nois ;)
        return resultados;
    }
}