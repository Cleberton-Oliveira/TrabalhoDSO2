package Controlador;

import Entidade.Animal;
import Entidade.Cachorro;
import Entidade.ConteudoTelaUsuario;
import Entidade.Gato;
import Entidade.Passaro;
import Entidade.Usuario;
import Mapeadores.MapeadorUsuario;
import TelaUsuario.CriarUsuario;
import TelaUsuario.EditarDados;
import TelaUsuario.Login;
import TelaUsuario.TelaUsuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ControladorUsuario {

	private MapeadorUsuario mapeador;
	private ControladorPrincipal ctrlPrincipal;
	private TelaUsuario telaUsuario;
	private String cpfLogado;
	private Login login;
	private CriarUsuario criarUsuario;
        private EditarDados editarDados;

	public ControladorUsuario(ControladorPrincipal ctrlPrincipal) {
		this.mapeador = new MapeadorUsuario();
		this.ctrlPrincipal = ctrlPrincipal;
		this.telaUsuario = new TelaUsuario(this);
		this.login = new Login(this);
		this.criarUsuario = new CriarUsuario(this);
                this.editarDados = new EditarDados(this);

	}

            
    public void fazerLoginTela() {
        login.exibe();
    }

    public void fazerCadastroUsuario() {
        criarUsuario.exibe();
    }


    public void logar(String loginUsuario) {
        
        for(Usuario usuario: mapeador.getList()){
            String loginDeUsuarios = usuario.getLogin();
            if(loginDeUsuarios.equals(loginUsuario)){
                   cpfLogado = loginUsuario.substring(0, 3);
                   System.out.println(cpfLogado);
                   login.fecha();
                   ctrlPrincipal.menu();
                return;
            }
        }
        login.fecha();
        login.erroLogin();
    }
    
    public void addUsuario(Usuario usuario){
        mapeador.put(usuario);
        usuario.eSuperUser();
    }
    
    public void incluiUsuario(ConteudoTelaUsuario conteudoTela) {
        String cpf = conteudoTela.cpfUsuario;
        for(Usuario usuario: mapeador.getList()){
            if(cpf.equals(usuario.getCpf())){
                criarUsuario.fecha();
                criarUsuario.erro();
                return;
            }
        }
        Usuario usuario = desempacota(conteudoTela);
        mapeador.put(usuario);
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
        Usuario usuario = mapeador.getUsuario(cpfLogado);
        String nome = usuario.getNome();
        
        if(usuario.getSuperuser() == true){
            ArrayList<Animal> adocao = usuario.getAdocao();
            ArrayList<Animal> doacao = usuario.getDoacao();
            telaUsuario.historicoSuperUsuario(nome, adocao, doacao, mapeador.getList());
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
        Usuario usuario = mapeador.getUsuario(cpfLogado);
        usuario.setSenha(senha);
        ctrlPrincipal.menu();
    }
    
    public void mudarNome(String nome){
      Usuario usuario = mapeador.getUsuario(cpfLogado);
      usuario.setNome(nome);
      ctrlPrincipal.menu();
    }
    
    public void adocaoCachorro(Cachorro cachorro){
        Usuario usuario = mapeador.getUsuario(cpfLogado);
        usuario.registroCachorro(cachorro);
    }
    
    public void adocaoGato(Gato gato) {
        Usuario usuario = mapeador.getUsuario(cpfLogado);
        usuario.registroGato(gato);
    }

    public void adocaoPassaro(Passaro passaro) {
         Usuario usuario = mapeador.getUsuario(cpfLogado);
            usuario.registroPassaro(passaro);    
    }

    public void doaCachorro(Cachorro cachorro) {
        Usuario usuario = mapeador.getUsuario(cpfLogado);
        usuario.doaCachorro(cachorro);
    }

    public void doaGato(Gato gato) {
        Usuario usuario = mapeador.getUsuario(cpfLogado);
        usuario.doaGato(gato);
    }

    public void doaPassaro(Passaro passaro) {
        Usuario usuario = mapeador.getUsuario(cpfLogado);
        usuario.doaPassaro(passaro);
    }
   
    public ArrayList<Animal> enviaListaAdocao(){
        Usuario usuario = mapeador.getUsuario(cpfLogado);  
        return usuario.getAdocao();
    }

    public void apagaConta(){
    Usuario usuario = mapeador.getUsuario(cpfLogado);
    mapeador.remove(usuario);
    ctrlPrincipal.iniciaPrograma();
    }  

    public void iniciar() {
        login.fecha();
        ctrlPrincipal.iniciaPrograma();
    }

    public void editarDados() {
        editarDados.exibe();
    }
}
