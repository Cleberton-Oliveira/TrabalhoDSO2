package Controlador;

import TelaPet.DoarPet;
import Entidade.Animal;
import Entidade.ConteudoTelaPet;
import Entidade.Cachorro;
import Entidade.Gato;
import Entidade.Passaro;
import TelaPet.AdotaPet;
import TelaPet.TelaPets;
import java.util.ArrayList;

public class ControladorPet {
    private ControladorPrincipal ctrlPrincipal;
    private TelaPets telaPets;
    private AdotaPet adotaPet;
    private DoarPet doarPet;
    private ArrayList<Cachorro> cachorros;
    private ArrayList<Gato> gatos;
    private ArrayList<Passaro> passaros;
    
    private final int CACHORRO=1,GATO=2, PASSARO=3;
        
    public ControladorPet(ControladorPrincipal ctrlPrincipal){
        this.ctrlPrincipal = ctrlPrincipal;
        this.telaPets = new TelaPets(this);
        this.adotaPet = new AdotaPet(this);
        this.doarPet = new DoarPet(this);
        this.cachorros = new ArrayList<>();
        this.gatos = new ArrayList<>();
        this.passaros = new ArrayList<>();
    }
    
    public void addCachorro(Cachorro cachorro){
        cachorros.add(cachorro);
    }
    public void addGato(Gato gato){
        gatos.add(gato);
    }
    public void addPassaro(Passaro passaro){
        passaros.add(passaro);
    }

    public void doarPet() {
        doarPet.exibe();
    }

    public void adotaPet() {
        adotaPet.exibe();
    }


    
//    public void adocao(int pet, int opcaoRaca, int opcaoSexo) {
//        ArrayList<ConteudoTelaPet> listagemPets = new ArrayList<ConteudoTelaPet>();
//   
//               switch(pet){
//            case CACHORRO: 
//                for(Cachorro cachorro: cachorros){
//                    if(opcaoRaca == cachorro.getRaca() && opcaoSexo == cachorro.getSexo()){
//                       listagemPets.add(empacotaCachorro(cachorro));
//                    }
//                }
//                telaPets.mostraListaPets(pet, listagemPets);
//                break;
//            case GATO:
//                 for(Gato gato: gatos){
//                    if(opcaoRaca == gato.getRaca()  && opcaoSexo == gato.getSexo()){
//                       listagemPets.add(empacotaGato(gato));
//                    }
//                }
//                telaPets.mostraListaPets(pet, listagemPets);
//                telaPets.doarGato();
//                break;
//             case PASSARO:
//                  for(Passaro passaro: passaros){
//                    if(opcaoRaca == passaro.getRaca() && opcaoSexo == passaro.getSexo()){
//                       listagemPets.add(empacotaPassaro(passaro));
//                    }
//                }
//                telaPets.mostraListaPets(pet, listagemPets);
//                telaPets.doarPassaro();
//                break; 
//        
//        
//          }
//    }
    

//    public void cadastroDog(ConteudoTelaPet conteudoTela) {
//        Cachorro cachorro = desempacotaCachorro(conteudoTela);
//        cachorros.add(cachorro);
//        ctrlPrincipal.doaCachorro(cachorro);   
//        ctrlPrincipal.registroSucesso();
//    }
//
//    public void cadastroGato(ConteudoTelaPet conteudoTela) {
//        Gato gato = desempacotaGato(conteudoTela);
//        gatos.add(gato);
//        ctrlPrincipal.doaGato(gato);   
//        ctrlPrincipal.registroSucesso();
//    }
//
//    public void cadastroPassaro(ConteudoTelaPet conteudoTela) {
//        Passaro passaro = desempacotaPassaro(conteudoTela);
//        passaros.add(passaro);
//        ctrlPrincipal.doaPassaro(passaro);   
//        ctrlPrincipal.registroSucesso();
//    }
//    
//    
    
      
    private Cachorro desempacotaCachorro(ConteudoTelaPet conteudoTela) {
       return new Cachorro(conteudoTela.nomePet, conteudoTela.idadePet, conteudoTela.racaPet, conteudoTela.sexoPet);
    }
    private Gato desempacotaGato(ConteudoTelaPet conteudoTela) {
       return new Gato(conteudoTela.nomePet, conteudoTela.idadePet, conteudoTela.racaPet, conteudoTela.sexoPet);
    }
    private Passaro desempacotaPassaro(ConteudoTelaPet conteudoTela) {
       return new Passaro(conteudoTela.nomePet, conteudoTela.idadePet, conteudoTela.racaPet, conteudoTela.sexoPet);
    }
    
    
    private ConteudoTelaPet empacotaCachorro(Cachorro cachorro) {
       return new ConteudoTelaPet(cachorro.getNome(), cachorro.getIdade(), cachorro.getRaca(), cachorro.getSexo());
    }
    private ConteudoTelaPet empacotaGato(Gato gato) {
       return new ConteudoTelaPet(gato.getNome(), gato.getIdade(), gato.getRaca(), gato.getSexo());
    }
    private ConteudoTelaPet empacotaPassaro(Passaro passaro) {
       return new ConteudoTelaPet(passaro.getNome(), passaro.getIdade(), passaro.getRaca(), passaro.getSexo());
    }
    
    public void menuPrincipal() {
        ctrlPrincipal.menu();
    }
    
    public ArrayList<Animal> adocoesUsuario(){
       ArrayList<Animal> adocoes = ctrlPrincipal.adocoesUsuario();
       return adocoes;
    }

    public void petAdotado(int opcao, int pet){
        ArrayList<Animal> animal = adocoesUsuario();
        if(adocoesUsuario().size() > 4){
            telaPets.exibeMaximoAdocao();             
        }else{        
        switch(pet){
            case CACHORRO:
                Cachorro cachorro = cachorros.get(opcao - 1);
                    for(Animal adocao: animal){
                        if(adocao.getEspecie() == cachorro.getEspecie()){
                            telaPets.exibeMaximoEspecie(pet);
                            menuPrincipal();
                            break;
                        }
                    }
                    ctrlPrincipal.adocaoCachorro(cachorro);    
                    cachorros.remove(opcao - 1);
                    telaPets.exibeSucessoAdocao(pet);
                    menuPrincipal();   
                    break;       
            case GATO:
                Gato gato = gatos.get(opcao - 1);
                for(Animal adocao: animal){
                        if(adocao.getEspecie() == gato.getEspecie()){
                            telaPets.exibeMaximoEspecie(pet);
                            menuPrincipal();
                            break;
                        }
                    }
                ctrlPrincipal.adocaoGato(gato);    
                gatos.remove(opcao - 1);
                telaPets.exibeSucessoAdocao(pet);
                menuPrincipal();
                break;
            case PASSARO:
                Passaro passaro = passaros.get(opcao - 1);
                 for(Animal adocao: animal){
                        if(adocao.getEspecie() == passaro.getEspecie()){
                            telaPets.exibeMaximoEspecie(pet);
                            menuPrincipal();
                            break;
                        }
                    }
                ctrlPrincipal.adocaoPassaro(passaro);    
                passaros.remove(opcao - 1);
                telaPets.exibeSucessoAdocao(pet);
                menuPrincipal();
                break;  
            }
        }
       menuPrincipal();
    }
}
