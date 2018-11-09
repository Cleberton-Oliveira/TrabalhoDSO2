package Controlador;

import TelaPet.DoarPet;
import Entidade.Animal;
import Entidade.ConteudoTelaPet;
import Entidade.Cachorro;
import Entidade.Gato;
import Entidade.Passaro;
import Mapeadores.MapeadorCachorro;
import Mapeadores.MapeadorGato;
import Mapeadores.MapeadorPassaro;
import TelaPet.AdotaPet;
import TelaPet.ListaParaAdocao;
import TelaPet.TelaPets;
import java.util.ArrayList;

public class ControladorPet {
    private ControladorPrincipal ctrlPrincipal;
    private TelaPets telaPets;
    private AdotaPet adotaPet;
    private DoarPet doarPet;
    private ListaParaAdocao listaParaAdocao;
    private MapeadorCachorro mapeadorCachorro;
    private MapeadorGato mapeadorGato;
    private MapeadorPassaro mapeadorPassaro;
    
    private final int CACHORRO=1,GATO=2, PASSARO=3;
        
    public ControladorPet(ControladorPrincipal ctrlPrincipal){
        this.ctrlPrincipal = ctrlPrincipal;
        this.telaPets = new TelaPets(this);
        this.adotaPet = new AdotaPet(this);
        this.listaParaAdocao = new ListaParaAdocao(this);
        this.doarPet = new DoarPet(this);
        this.mapeadorCachorro = new MapeadorCachorro();
        this.mapeadorGato = new MapeadorGato();
        this.mapeadorPassaro = new MapeadorPassaro();
    }
   // ---------------------- Construção automatica------------------------------- 
//    public void addCachorro(Cachorro cachorro){
//        mapeadorCachorro.put(cachorro);    
//    }
//    public void addGato(Gato gato){
//        gatos.add(gato);
//    }
//    public void addPassaro(Passaro passaro){
//        passaros.add(passaro);
//    }
    //----------------------------------------------------------------------------
    
    public void doarPet() {
        doarPet.exibe();
    }

    public void adotaPet() {
        adotaPet.exibe();
    }
    
    public void exibeAdocao(int pet, int opcaoRaca, int opcaoSexo) {
        ArrayList<ConteudoTelaPet> listagemPets = new ArrayList<ConteudoTelaPet>();
                  switch(pet){
            case CACHORRO: 
                for(Cachorro cachorro: mapeadorCachorro.getList()){
                    if(opcaoRaca == cachorro.getRaca() && opcaoSexo == cachorro.getSexo()){
                       listagemPets.add(empacotaCachorro(cachorro));
                    }
                }
                listaParaAdocao.listagem(CACHORRO, listagemPets);
                break;
            case GATO:
                 for(Gato gato: mapeadorGato.getList()){
                    if(opcaoRaca == gato.getRaca()  && opcaoSexo == gato.getSexo()){
                       listagemPets.add(empacotaGato(gato));
                    }
                }
                listaParaAdocao.listagem(GATO, listagemPets);
                break;
             case PASSARO:
                  for(Passaro passaro: mapeadorPassaro.getList()){
                    if(opcaoRaca == passaro.getRaca() && opcaoSexo == passaro.getSexo()){
                       listagemPets.add(empacotaPassaro(passaro));
                    }
                }
                listaParaAdocao.listagem(PASSARO, listagemPets);
                break; 
        
        
          }
    }
    

    public void cadastroDog(ConteudoTelaPet conteudoTela) {
        conteudoTela.identificador = Integer.toString(mapeadorCachorro.getList().size() + 1);
        System.out.println("O indentificador do cachorro é: cachorro" + conteudoTela.identificador);
        Cachorro cachorro = desempacotaCachorro(conteudoTela);
        mapeadorCachorro.put(cachorro);
        ctrlPrincipal.doaCachorro(cachorro);
        menuPrincipal();
    }

    public void cadastroGato(ConteudoTelaPet conteudoTela) {
        conteudoTela.identificador = Integer.toString(mapeadorGato.getList().size() + 1);
        System.out.println("O indentificador do gato é: gato" + conteudoTela.identificador);
        Gato gato = desempacotaGato(conteudoTela);
        mapeadorGato.put(gato);
        ctrlPrincipal.doaGato(gato);   
        menuPrincipal();
    }

    public void cadastroPassaro(ConteudoTelaPet conteudoTela) {
        conteudoTela.identificador = Integer.toString(mapeadorPassaro.getList().size() + 1);
        System.out.println("O indentificador do passaro é: passaro" + conteudoTela.identificador);
        Passaro passaro = desempacotaPassaro(conteudoTela);
        mapeadorPassaro.put(passaro);
        ctrlPrincipal.doaPassaro(passaro);  
        menuPrincipal();
    }
    
    
    
      
    private Cachorro desempacotaCachorro(ConteudoTelaPet conteudoTela) {
      return new Cachorro(conteudoTela.nomePet, conteudoTela.idadePet, conteudoTela.racaPet, conteudoTela.sexoPet, conteudoTela.identificador);
    }
    private Gato desempacotaGato(ConteudoTelaPet conteudoTela) {
      return new Gato(conteudoTela.nomePet, conteudoTela.idadePet, conteudoTela.racaPet, conteudoTela.sexoPet, conteudoTela.identificador);
    }
    private Passaro desempacotaPassaro(ConteudoTelaPet conteudoTela) {
      return new Passaro(conteudoTela.nomePet, conteudoTela.idadePet, conteudoTela.racaPet, conteudoTela.sexoPet, conteudoTela.identificador);
    }
    
    
    private ConteudoTelaPet empacotaCachorro(Cachorro cachorro) {
       return new ConteudoTelaPet(cachorro.getNome(), cachorro.getIdade(), cachorro.getRaca(), cachorro.getSexo(), cachorro.getIdentificadorCachorro());
    }
    private ConteudoTelaPet empacotaGato(Gato gato) {
       return new ConteudoTelaPet(gato.getNome(), gato.getIdade(), gato.getRaca(), gato.getSexo(), gato.getIdentificadorGato());
    }
    private ConteudoTelaPet empacotaPassaro(Passaro passaro) {
       return new ConteudoTelaPet(passaro.getNome(), passaro.getIdade(), passaro.getRaca(), passaro.getSexo(), passaro.getIdentificadorPassaro());
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
                Cachorro cachorro = mapeadorCachorro.getList().get(opcao);
                    for(Animal adocao: animal){
                        if(adocao.getEspecie() == cachorro.getEspecie()){
                            telaPets.exibeMaximoEspecie(pet);
                            menuPrincipal();
                            break;
                        }
                    }
                    ctrlPrincipal.adocaoCachorro(cachorro);    
                    mapeadorCachorro.remove(cachorro);
                    telaPets.exibeSucessoAdocao(pet);
                    System.out.print(cachorro.getIdentificadorCachorro());
                    menuPrincipal();   
                    break;       
            case GATO:
                Gato gato = mapeadorGato.getList().get(opcao);
                for(Animal adocao: animal){
                        if(adocao.getEspecie() == gato.getEspecie()){
                            telaPets.exibeMaximoEspecie(pet);
                            menuPrincipal();
                            break;
                        }
                    }
                ctrlPrincipal.adocaoGato(gato);    
                mapeadorGato.remove(gato);
                telaPets.exibeSucessoAdocao(pet);
                System.out.print(gato.getIdentificadorGato());
                menuPrincipal();
                break;
            case PASSARO:
                Passaro passaro = mapeadorPassaro.getList().get(opcao);
                 for(Animal adocao: animal){
                        if(adocao.getEspecie() == passaro.getEspecie()){
                            telaPets.exibeMaximoEspecie(pet);
                            menuPrincipal();
                            break;
                        }
                    }
                ctrlPrincipal.adocaoPassaro(passaro);    
                mapeadorPassaro.remove(passaro);
                telaPets.exibeSucessoAdocao(pet);
                System.out.print(passaro.getIdentificadorPassaro());
                menuPrincipal();
                break;  
            }
        }
       menuPrincipal();
    }
}
