package TelaPet;

import Controlador.ControladorPet;
import Entidade.ConteudoTelaPet;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TelaPets {
    private ControladorPet ctrlPet;
    private Scanner teclado;
    
    private final int CACHORRO=1,GATO=2, PASSARO=3;
    
    public TelaPets(ControladorPet ctrlPet) {
        this.ctrlPet= ctrlPet;
        this.teclado = new Scanner(System.in);
    }
    
    private int leInteiro() {
        try {  
           int inteiro = teclado.nextInt();
            teclado.nextLine();
            return inteiro;
        } catch (InputMismatchException e) {
            System.out.println("Digite uma opção válida!" + e.getMessage());
            return 0;
        }        
    }

    public void adotaDog() {
        ConteudoTelaPet conteudoTela = new ConteudoTelaPet();
        System.out.println("----------------------------------------------------------------");
        System.out.println("--------------------------ADOÇÃO DE CÃO-------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("");
        System.out.println("Qual a Raça de cachorro gostaria de adotar:");
        System.out.println("");
        System.out.println("(1) Pastor Alemão");
        System.out.println("(2) Labrador");
        System.out.println("(3) Buldogle");
        System.out.println("(4) Beagle");
        System.out.println("(5) Poodle"); 
        int opcaoRaca = leInteiro();
        System.out.println("Qual sexo do cão:"); 
        System.out.println("");
        System.out.println("(1) Masculino "); 
        System.out.println("(2) Feminino "); 
        int opcaoSexo = leInteiro();
//        enviarInformacaoAdocao(CACHORRO, opcaoRaca, opcaoSexo);
       

    }

    public void adotaGato() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("--------------------------ADOÇÃO DE GATO------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("");
        System.out.println("Qual a Raça de gato gostaria de adotar:");
        System.out.println("");
        System.out.println("(1) Persa");
        System.out.println("(2) Seames");
        System.out.println("(3) Vira Lata");
        System.out.println("(4) Azul Russo");
        int opcaoRaca = leInteiro();
        System.out.println("Qual sexo do gato:"); 
        System.out.println("");
        System.out.println("(1) Masculino "); 
        System.out.println("(2) Feminino "); 
        int opcaoSexo = leInteiro();
//        enviarInformacaoAdocao(GATO, opcaoRaca, opcaoSexo);
    }

    public void adotaPassaro() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("-------------------------ADOÇÃO DE PASSARO----------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("");
        System.out.println("Qual a especie de passaro gostaria de adotar:");
        System.out.println("");
        System.out.println("(1) Cacatua");
        System.out.println("(2) Calopsita");
        System.out.println("(3) Canario");
        System.out.println("(4) Papagaio");
        System.out.println("(5) Periquito");
        int opcaoRaca = leInteiro();
        System.out.println("Qual sexo do passaro:"); 
        System.out.println("");
        System.out.println("(1) Masculino "); 
        System.out.println("(2) Feminino "); 
        int opcaoSexo = leInteiro();
//        enviarInformacaoAdocao(PASSARO, opcaoRaca, opcaoSexo);
        
    }

//    public void doarDog() {
//        ConteudoTelaPet conteudoTela = new ConteudoTelaPet();
//        int pet = 1;
//        System.out.println("----------------------------------------------------------------");
//        System.out.println("--------------------------DOAÇÃO DE CÃO-------------------------");
//        System.out.println("----------------------------------------------------------------");
//        System.out.println("");
//        System.out.print("Qual o nome do seu PET: ");
//        conteudoTela.nomePet = teclado.nextLine();
//        System.out.println("----------------------------------------------------------------");
//        System.out.println("");
//        System.out.print("Qual idade do seu PET: ");
//        conteudoTela.idadePet = leInteiro();
//        System.out.println("----------------------------------------------------------------");
//        System.out.println("Qual a raça de cachorro gostaria de doar:");
//        System.out.println("");
//        System.out.println("(1) Pastor Alemão");
//        System.out.println("(2) Labrador");
//        System.out.println("(3) Buldogle");
//        System.out.println("(4) Beagle");
//        System.out.println("(5) Poodle");
//        conteudoTela.racaPet = leInteiro();
//        System.out.println("----------------------------------------------------------------");
//        System.out.println("Qual sexo do Cão:"); 
//        System.out.println("");
//        System.out.println("(1) Masculino "); 
//        System.out.println("(2) Feminino "); 
//        conteudoTela.sexoPet = leInteiro();
//        enviarInformacaoCadastroPet(CACHORRO, conteudoTela);
//    }
//
//    public void doarGato() {
//        ConteudoTelaPet conteudoTela = new ConteudoTelaPet();
//        int pet = 2;
//        System.out.println("----------------------------------------------------------------");
//        System.out.println("--------------------------DOÇÃO DE GATO-------------------------");
//        System.out.println("----------------------------------------------------------------");
//        System.out.println("");
//        System.out.print("Qual o nome do seu PET: ");
//        conteudoTela.nomePet = teclado.nextLine();
//        System.out.println("----------------------------------------------------------------");
//        System.out.println("");
//        System.out.print("Qual idade do seu PET: ");
//        conteudoTela.idadePet = leInteiro();
//        System.out.println("----------------------------------------------------------------");
//        System.out.println("Qual a Raça de gato gostaria de doar:");
//        System.out.println("");
//        System.out.println("(1) Persa");
//        System.out.println("(2) Seames");
//        System.out.println("(3) Vira Lata");
//        System.out.println("(4) Azul Russo");
//        conteudoTela.racaPet = leInteiro();
//        System.out.println("----------------------------------------------------------------");
//        System.out.println("Qual sexo do Gato:"); 
//        System.out.println("");
//        System.out.println("(1) Masculino "); 
//        System.out.println("(2) Feminino "); 
//        conteudoTela.sexoPet = leInteiro();
//        enviarInformacaoCadastroPet(GATO, conteudoTela);
//    }
//
//    public void doarPassaro() {
//        ConteudoTelaPet conteudoTela = new ConteudoTelaPet();
//        int pet = 3;
//        System.out.println("----------------------------------------------------------------");
//        System.out.println("------------------------DOAÇÃO DE PASSARO-----------------------");
//        System.out.println("----------------------------------------------------------------");
//        System.out.println("");
//        System.out.print("Qual o nome do seu PET: ");
//        conteudoTela.nomePet = teclado.nextLine();
//        System.out.println("----------------------------------------------------------------");
//        System.out.println("");
//        System.out.print("Qual idade do seu PET: ");
//        conteudoTela.idadePet = leInteiro();
//        System.out.println("----------------------------------------------------------------");
//        System.out.println("Qual a especie de passaro gostaria de doar:");
//        System.out.println("");
//        System.out.println("(1) Cacatua");
//        System.out.println("(2) Calopsita");
//        System.out.println("(3) Canario");
//        System.out.println("(4) Papagaio");
//        System.out.println("(5) Periquito");
//        conteudoTela.racaPet = leInteiro();
//        System.out.println("----------------------------------------------------------------");
//        System.out.println("Qual sexo do Passaro:"); 
//        System.out.println("");
//        System.out.println("(1) Masculino "); 
//        System.out.println("(2) Feminino "); 
//        conteudoTela.sexoPet = leInteiro();
//        enviarInformacaoCadastroPet(PASSARO, conteudoTela);
//    }
    
     

//    public void enviarInformacaoAdocao(int pet,int opcaoRaca, int opcaoSexo) {
//        ctrlPet.adocao(pet, opcaoRaca, opcaoSexo);
//    }

//    private void enviarInformacaoCadastroPet(int pet, ConteudoTelaPet conteudoTela) {
//        switch(pet){
//            case CACHORRO: 
//                ctrlPet.cadastroDog(conteudoTela);
//                break;
//            case GATO:
//                ctrlPet.cadastroGato(conteudoTela);
//                break;
//             case PASSARO:
//                ctrlPet.cadastroPassaro(conteudoTela);
//                break;    
//        }
//    }

    public void mostraListaPets(int pet, ArrayList<ConteudoTelaPet> listagemPets) {
 
                 System.out.println("----------------------------------------------------------------");
                 System.out.println("                        Listagem PET");
                 System.out.println("----------------------------------------------------------------");
                 int numero = 1;
                    if(listagemPets.isEmpty()){
                            System.out.println("Não temos animais dessa raça e sexo no momento");
                            ctrlPet.menuPrincipal();
                    }else{
                    for (ConteudoTelaPet conteudoTela : listagemPets){


                            System.out.println("");
                            System.out.println("Registro do PET: " + numero);
                            System.out.println("nome: " + conteudoTela.nomePet);
                            System.out.println("Idade: " + conteudoTela.idadePet);
                            System.out.println("");
                            System.out.println("----------------------------------------------------------------");
                            numero++;
                            
                        } 
                    gostariaDeAdotar(pet);
        }
        
    }   

    private void gostariaDeAdotar(int pet) {
            System.out.println("Qual pet gostaria de adotar?");
            System.out.println("----------------------------------------------------------------");
            System.out.println("Didite o registro do PET ou digite 0 para não adotar nenhum:");
            
            int opcao = leInteiro();
            if(opcao == 0){
              System.out.println("----------------------");
              System.out.println("Nenhum animal adotado");
              System.out.println("----------------------");
              ctrlPet.menuPrincipal();
            }else{            
                ctrlPet.petAdotado(opcao, pet);       
            }
    }
        public void exibeMaximoAdocao() {
        System.out.println("");
        System.out.println("Você ja adotou o numero maximo de animais");
        System.out.println("");
    }

    public void exibeMaximoEspecie(int pet) {
       switch(pet){
            case CACHORRO: 
                System.out.println("");
                System.out.println("Numero maximo de adoção de cachorros dessa especie");
                System.out.println("");
                break;
            case GATO:
                System.out.println("");
                System.out.println("Numero maximo de adoção de gatos dessa especie");
                System.out.println("");
                break;
             case PASSARO:
                System.out.println("");
                System.out.println("Numero maximo de adoção de passaros dessa especie");
                System.out.println("");
                break;    
        }
    }
        public void exibeSucessoAdocao(int pet) {
       switch(pet){
            case CACHORRO: 
                System.out.println("");
                System.out.println("Cachorro Adotado com sucesso");
                System.out.println("");
                break;
            case GATO:
                System.out.println("");
                System.out.println("Gato Adotado com sucesso");
                System.out.println("");
                break;
             case PASSARO:
                System.out.println("");
                System.out.println("Passaro Adotado com sucesso");
                System.out.println("");
                break;    
        }
    }
}
