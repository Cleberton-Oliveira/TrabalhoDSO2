package TelaUsuario;

import Controlador.ControladorUsuario;
import Entidade.Animal;
import Entidade.Cachorro;
import java.util.Scanner;
import Entidade.ConteudoTelaUsuario;
import Entidade.Usuario;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.InputMismatchException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaUsuario extends JFrame{
    private ControladorUsuario ctrlUsuario;
    private Scanner teclado;  private JLabel lbTexto;
    private JButton btOK;
    private JButton btCancel;
    private JTextField tfNome;          
  
    
    public TelaUsuario(ControladorUsuario ctrlUsuario){
        this.ctrlUsuario = ctrlUsuario;
        this.teclado = new Scanner(System.in);
     
    }
   
        private int leInteiro() {
        try {  
           int inteiro = teclado.nextInt();
           teclado.nextLine();
           return inteiro;
        } catch (InputMismatchException e) {
            System.out.println("Digite uma opção válida!");
            return 0;
        }  
    }
    
  

     public void historico(String nome, ArrayList<Animal> adocao, ArrayList<Animal> doacao) {
        System.out.println("----------------------------------------------------------------");
        System.out.println("                      HISTORICO " + nome );
        System.out.println("----------------------------------------------------------------");
        System.out.println("------------------------- ANIMAIS ADOTADOS ---------------------");
        System.out.println("----------------------------------------------------------------");
        if(adocao.isEmpty()){
            System.out.println("");       
            System.out.println("Você não adotou nenhum animal ainda");
            System.out.println("");   
        }else{
            for (Animal pet : adocao){ 
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
         if(doacao.isEmpty()){
            System.out.println("");       
            System.out.println("Você não doou nenhum animal ainda");
            System.out.println("");   
        }else{
            for (Animal pet : doacao){ 
                 System.out.println("");
                 System.out.println("Nome: " + pet.getNome());
                 System.out.println("Idade: " + pet.getIdade());
                 System.out.println("Sexo: " + pet.getNomeSexo(pet.getSexo()));
                 System.out.println("Especie: " + pet.getEspecie());
            }  
        }
    }

   

    public void historicoSuperUsuario(String nome, ArrayList<Animal> adocao, ArrayList<Animal> doacao, ArrayList<Usuario> usuarios) {
        
        System.out.println("----------------------------------------------------------------");
        System.out.println("                      HISTORICO SUPER USUARIO");
        System.out.println("----------------------------------------------------------------");
        System.out.println("                      HISTORICO " + nome );
        System.out.println("----------------------------------------------------------------");
        System.out.println("------------------------- ANIMAIS ADOTADOS ---------------------");
        System.out.println("----------------------------------------------------------------");
        if(adocao.isEmpty()){
            System.out.println("");       
            System.out.println("Você não adotou nenhum animal ainda");
            System.out.println("");   
        }else{
            for (Animal pet : adocao){ 
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
         if(doacao.isEmpty()){
            System.out.println("");       
            System.out.println("Você não doou nenhum animal ainda");
            System.out.println("");   
        }else{
            for (Animal pet : doacao){ 
                 System.out.println("");
                 System.out.println("Nome: " + pet.getNome());
                 System.out.println("Idade: " + pet.getIdade());
                 System.out.println("Sexo: " + pet.getNomeSexo(pet.getSexo()));
                 System.out.println("Especie: " + pet.getEspecie());
            }  
        }
       System.out.println("");
       System.out.println("----------------------------------------------------------------");
       System.out.println("-----------------Historico Todos Clientes ---------------------");
       System.out.println("----------------------------------------------------------------");
       System.out.println("");
       if(usuarios.isEmpty()){
                            System.out.println("Sem mais nenhum registro");
                    }else{
                    for (Usuario usuario : usuarios){
                        System.out.println("----------------------------------------------------------------");
                        System.out.println("                      HISTORICO " + usuario.getNome() );
                        System.out.println("----------------------------------------------------------------");
                        System.out.println("CPF: "+ usuario.getCpf());
                        int a = 2;
                        ArrayList<Animal> pets = usuario.getAdocao();
                         System.out.println("");
                         System.out.println("----------------------- ANIMAIS ADOTADOS -----------------------");
                         System.out.println("----------------------------------------------------------------");
                             if(pets.isEmpty()){
                                System.out.println("");       
                                System.out.println("Não doou nenhum animal ainda");
                                System.out.println(""); 
                             }else{       
                                for (Animal pet : pets){ 
                                    System.out.println("");
                                    System.out.println("Nome: " + pet.getNome());
                                    System.out.println("Idade: " + pet.getIdade());
                                    System.out.println("Sexo: " + pet.getNomeSexo(pet.getSexo()));
                                    System.out.println("Especie: " + pet.getEspecie());
                                }
                        
                            }       
                    
                    ArrayList<Animal> petsDocao = usuario.getDoacao();
                         System.out.println("");
                         System.out.println("------------------------- ANIMAIS DOADOS -----------------------");
                         System.out.println("----------------------------------------------------------------");
                             if(petsDocao.isEmpty()){
                                System.out.println("");       
                                System.out.println("Não doou nenhum animal ainda");
                                System.out.println(""); 
                             }else{       
                                for (Animal pet : petsDocao){ 
                                    System.out.println("");
                                    System.out.println("Nome: " + pet.getNome());
                                    System.out.println("Idade: " + pet.getIdade());
                                    System.out.println("Sexo: " + pet.getNomeSexo(pet.getSexo()));
                                    System.out.println("Especie: " + pet.getEspecie());
                                }
                        
               }
            }             
        }
    }


   
}
