package TelaUsuario;

import Controlador.ControladorUsuario;
import Entidade.Animal;
import Entidade.Cachorro;
import Entidade.Usuario;
import java.util.ArrayList;

// ------------------- NÃO MEXER NESSA TELA ----------------------------

// --------- ela será apagada até o final do trabalho -------------------

public class TelaUsuario {

    private ControladorUsuario ctrlUsuario;

    public TelaUsuario(ControladorUsuario ctrlUsuario) {
        this.ctrlUsuario = ctrlUsuario;
    }

    public void historico(String nome, ArrayList<Animal> adocao, ArrayList<Animal> doacao) {
        // Cria uma j
        System.out.println("                      HISTORICO " + nome);

        System.out.println("------------------------- ANIMAIS ADOTADOS ---------------------");

        if (adocao.isEmpty()) {
            System.out.println("");
            System.out.println("Você não adotou nenhum animal ainda");
            System.out.println("");
        } else {
            for (Animal pet : adocao) {
                // Aqui entra a tabela 

                System.out.println("");
                System.out.println("Nome: " + pet.getNome());
                System.out.println("Idade: " + pet.getIdade());
                System.out.println("Sexo: " + pet.getNomeSexo(pet.getSexo()));
                System.out.println("Especie: " + pet.getEspecie());
            }
        }
        System.out.println("");
        System.out.println("------------------------- ANIMAIS DOADOS -----------------------");
        System.out.println("----------------------------------------------------------------");
        if (doacao.isEmpty()) {
            System.out.println("");
            System.out.println("Você não doou nenhum animal ainda");
            System.out.println("");
        } else {
            for (Animal pet : doacao) {
                System.out.println("");
                System.out.println("Nome: " + pet.getNome());
                System.out.println("Idade: " + pet.getIdade());
                System.out.println("Sexo: " + pet.getNomeSexo(pet.getSexo()));
                System.out.println("Especie: " + pet.getEspecie());
            }
        }

    }
}
