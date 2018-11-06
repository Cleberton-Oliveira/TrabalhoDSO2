package Controlador;

import Entidade.Animal;
import Entidade.Cachorro;
import Entidade.ConteudoTelaUsuario;
import Entidade.Gato;
import Entidade.Passaro;
import Entidade.Usuario;
import TelaUsuario.CriarUsuario;
import TelaUsuario.Login;
import TelaUsuario.TelaUsuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ControladorUsuario {
    private ControladorPrincipal ctrlPrincipal;
    private TelaUsuario telaUsuario;
    private ArrayList<Usuario> usuarios;
    private int usuarioLogado; 
    private Login login;
    private CriarUsuario criarUsuario;
    
    public ControladorUsuario(ControladorPrincipal ctrlPrincipal){
        this.ctrlPrincipal = ctrlPrincipal;
        this.telaUsuario = new TelaUsuario(this);
    
        this.usuarios = new ArrayList<>();
        this.login =  new Login(this);
       this.criarUsuario = new CriarUsuario(this);
        
    }
            
    public void fazerLoginTela() {
        login.exibe();
    }

    public void fazerCadastroUsuario() {
        criarUsuario.exibe();
    }


    public void logar(String loginUsuario) {
        
        for(Usuario usuario: usuarios){
            String loginDeUsuarios = usuario.getLogin();
            if(loginDeUsuarios.equals(loginUsuario)){
                usuarioLogado = usuarios.lastIndexOf(usuario);
                    login.fecha();
                    ctrlPrincipal.menu();
                return;
            }
        }
        login.fecha();
        login.erroLogin();
    }
    
    public void addUsuario(Usuario usuario){
        usuarios.add(usuario);
        usuario.eSuperUser();
    }
    
    public void incluiUsuario(ConteudoTelaUsuario conteudoTela) {
        String cpf = conteudoTela.cpfUsuario;
        for(Usuario usuario: usuarios){
            if(cpf.equals(usuario.getCpf())){
                criarUsuario.fecha();
                criarUsuario.erro();
                return;
            }
        }
        Usuario usuario = desempacota(conteudoTela);
        usuarios.add(usuario);
        criarUsuario.fecha();
        login.contaCriadaComSucesso();
                
    }
    private Usuario desempacota(ConteudoTelaUsuario conteudoTela) {
       return new Usuario(conteudoTela.nomeUsuario, conteudoTela.cpfUsuario, conteudoTela.senhaUsuario);
    }
    
    
    private ConteudoTelaUsuario empacota(Usuario usuario) {
       return new ConteudoTelaUsuario(usuario.getNome(), usuario.getCpf(), usuario.getSenha());
    }

    public void historicoUsuario(){
        Usuario usuario = usuarios.get(usuarioLogado);
        String nome = usuario.getNome();
        if(usuario.getSuperuser() == true){
            ArrayList<Animal> adocao = usuario.getAdocao();
            ArrayList<Animal> doacao = usuario.getDoacao();
            telaUsuario.historicoSuperUsuario(nome, adocao, doacao, usuarios);
        }else{
        ArrayList<Animal> adocao = usuario.getAdocao();
        ArrayList<Animal> doacao = usuario.getDoacao();        
        telaUsuario.historico(nome, adocao, doacao);
        }
    }
    public void telaPrincipal() {
        ctrlPrincipal.menu();
    }
    
    public void mudarSenha(String senha){
        Usuario usuario = usuarios.get(usuarioLogado);
        usuario.setSenha(senha);
        ctrlPrincipal.menu();
    }
    
    public void mudarNome(String nome){
      Usuario usuario = usuarios.get(usuarioLogado);
      usuario.setNome(nome);
      ctrlPrincipal.menu();
    }
        
    public void mudarCpf(String cpf){
      for(Usuario usuarios: usuarios){
            if(cpf.equals(usuarios.getCpf())){
            telaUsuario.cpfNaoPodeMudar();
            break;
            }
        }
      Usuario usuario = usuarios.get(usuarioLogado);
      usuario.setCpf(cpf);
      ctrlPrincipal.menu();
    }
    
    public void adocaoCachorro(Cachorro cachorro){
        Usuario usuario = usuarios.get(usuarioLogado);
        usuario.registroCachorro(cachorro);
    }
    public void adocaoGato(Gato gato) {
        Usuario usuario = usuarios.get(usuarioLogado);
        usuario.registroGato(gato);
    }

    public void adocaoPassaro(Passaro passaro) {
         Usuario usuario = usuarios.get(usuarioLogado);
            usuario.registroPassaro(passaro);    
    }

    public void doaCachorro(Cachorro cachorro) {
        Usuario usuario = usuarios.get(usuarioLogado);
        usuario.doaCachorro(cachorro);
    }

    public void doaGato(Gato gato) {
        Usuario usuario = usuarios.get(usuarioLogado);
        usuario.doaGato(gato);
    }

    public void doaPassaro(Passaro passaro) {
        Usuario usuario = usuarios.get(usuarioLogado);
        usuario.doaPassaro(passaro);
    }
   
    public ArrayList<Animal> enviaListaAdocao(){
        Usuario usuario = usuarios.get(usuarioLogado);    
        return usuario.getAdocao();
    }

    public void apagaConta(){
    Usuario usuario = usuarios.get(usuarioLogado);
    usuarios.remove(usuario);
    ctrlPrincipal.iniciaPrograma();
    }  

    public void iniciar() {
        login.fecha();
        ctrlPrincipal.iniciaPrograma();
    }
}
