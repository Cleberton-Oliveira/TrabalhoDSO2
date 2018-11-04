package Controlador;
import Entidade.Animal;
import Entidade.Cachorro;
import Entidade.Gato;
import Entidade.Passaro;
import TelaUsuario.Login;
import TelaPrincipal.Iniciar;
import TelaPrincipal.Menu;
import java.util.ArrayList;


public class ControladorPrincipal {
    private static ControladorPrincipal instancia;
    private ControladorUsuario ctrlUsuario;
    private Iniciar iniciar;
    private Login login;
    private Menu menu;
    private ControladorPet ctrlPet;
    private final int CACHORRO=1,GATO=2, PASSARO=3;

    
    private ControladorPrincipal() {
        this.ctrlUsuario = new ControladorUsuario(this);
        this.ctrlPet = new ControladorPet(this);
        this.iniciar =  new Iniciar(this);
        this.menu =  new Menu(this);

    }
    public static ControladorPrincipal getInstancia(){
        if(instancia == null){
            instancia = new ControladorPrincipal();
        }
        return instancia;
    }
    
    public ControladorUsuario getCtrlUsuario(){
        return this.ctrlUsuario;
    } 
     public ControladorPet getCtrlPet(){
        return this.ctrlPet;
    } 
    
    public void iniciaPrograma(){
        iniciar.exibe();
    }

    public void executaOpcaoLogin(int opcao) {
        switch(opcao){
                    case 1 : iniciar.fecha();
                        ctrlUsuario.fazerLoginTela();
                        break;
                    case 2 : iniciar.fecha();
                        ctrlUsuario.fazerCadastroUsuario();
                        break;
        }
    }

    public void menu(){
        menu.exibe();
    }
//
//    public void historico(){
//      ctrlUsuario.historicoUsuario();
//      telaPrincipal.exibeTelaPrincipal();
//    }

    public void adotarPet(int opcao) {
        ctrlPet.adotarPet(opcao);
    }

//    public void doarPet(int opcao) {
//        ctrlPet.doarPet(opcao);
//    }
//    public void registroSucesso() {
//        telaPrincipal.registroSucessoTela();
//    }

   
    public void mudaSenha(String senha) {
        ctrlUsuario.mudarSenha(senha);
    }

    public void mudaNome(String nome) {
         ctrlUsuario.mudarNome(nome);
    }

    public void mudaCpf(String cpf) {
          ctrlUsuario.mudarCpf(cpf);
    }
    
    
    public void adocaoCachorro(Cachorro cachorro){
       ctrlUsuario.adocaoCachorro(cachorro);
    }
    
    public void adocaoGato(Gato gato) {
       ctrlUsuario.adocaoGato(gato);
    }

    public void adocaoPassaro(Passaro passaro) {
       ctrlUsuario.adocaoPassaro(passaro);
    }

    public void doaCachorro(Cachorro cachorro) {
        ctrlUsuario.doaCachorro(cachorro); 
    }

    public void doaGato(Gato gato) {
   ctrlUsuario.doaGato(gato);   
    }

    public void doaPassaro(Passaro passaro) {
        ctrlUsuario.doaPassaro(passaro);   
    }
    public ArrayList<Animal> adocoesUsuario(){
       ArrayList<Animal> adocoes = ctrlUsuario.enviaListaAdocao();
       return adocoes;
    }

    public void apagaConta() {
        menu.fecha();
        ctrlUsuario.apagaConta();
    }

    public void adotaPet() {
        menu.fecha();
        ctrlPet.telaAdotaPet();
    }
    
}
