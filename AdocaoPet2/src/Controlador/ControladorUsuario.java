package Controlador;

import TelaUsuario.TelaHistorico;
import Entidade.Animal;
import Entidade.Cachorro;
import Entidade.ConteudoTelaUsuario;
import Entidade.Gato;
import Entidade.Passaro;
import Entidade.Usuario;
import Mapeadores.MapeadorUsuario;
import TelaUsuario.CriarUsuario;
import TelaUsuario.EditarDados;
import TelaUsuario.HistoricoSuperUser;
import TelaUsuario.Login;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public final class ControladorUsuario {

    private static ControladorUsuario instancia;
    private MapeadorUsuario mapeador;
    private String cpfLogado;
    private Login login;
    private CriarUsuario criarUsuario;
    private EditarDados editarDados;
    private TelaHistorico telaHistorico;
    private HistoricoSuperUser historicoSuperUsuario;
    
    private ControladorUsuario() {
        this.mapeador = new MapeadorUsuario();
        this.login = new Login();
        this.criarUsuario = new CriarUsuario();
        this.editarDados = new EditarDados();
        this.telaHistorico = new TelaHistorico();
        this.historicoSuperUsuario = new HistoricoSuperUser();
    }
    
    public static synchronized ControladorUsuario getInstance() {
        if (instancia == null) {
            instancia = new ControladorUsuario();
        }
        return instancia;
    }
    
    public void fazerLoginTela() {
        login.fecha();
        login = new Login();
        login.exibe();
    }
    
    public void fazerCadastroUsuario() {
        criarUsuario.fecha();
        criarUsuario = new CriarUsuario();
        criarUsuario.exibe();
    }
    
    public void logar(String loginUsuario) {     
        for (Usuario usuario : mapeador.getList()) {
            String loginDeUsuarios = usuario.getLogin();
            if (loginDeUsuarios.equals(loginUsuario)) {
                cpfLogado = loginUsuario.substring(0, 3);
                System.out.println(cpfLogado);
                login.fecha();
                ControladorPrincipal.getInstancia().menu();
                return;
            }
        }
        login.erroLogin();
    }
    
    public void addSuperUsuario(Usuario usuario) {
        for (Usuario user : mapeador.getList()) {
            if (user.getCpf().equals(usuario.getCpf())) {                
                return;
            }            
        }
        usuario.eSuperUser();        
        mapeador.put(usuario);        
        return;
    }
    
    public void incluiUsuario(ConteudoTelaUsuario conteudoTela) {
        String cpf = conteudoTela.cpfUsuario;
        for (Usuario usuario : mapeador.getList()) {
            if (cpf.equals(usuario.getCpf())) {
                criarUsuario.fecha();
                criarUsuario.erro();
                return;
             }else if (cpf.length() != 3 || !cpf.matches("[0-9]+")){
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
    
    public void historicoUsuario() {
        Usuario usuario = mapeador.getUsuario(cpfLogado);
        if (usuario.getSuperuser() == true) {
            ArrayList<Usuario> usuarios = mapeador.getList();
            historicoSuperUsuario = new HistoricoSuperUser();
            historicoSuperUsuario.listagem(usuarios);
            return;
        } else {
            imprimeHistorico(cpfLogado);            
        }
    }
    
    public void imprimeHistorico(String cpf) {
        Usuario usuario = mapeador.getUsuario(cpf);
        String nome = usuario.getNome();
        ArrayList<Animal> adocao = usuario.getAdocao();
        ArrayList<Animal> doacao = usuario.getDoacao();
        telaHistorico = new TelaHistorico();
        telaHistorico.historico(nome, adocao, doacao);
    }
    
    public void telaPrincipal() {
        ControladorPrincipal.getInstancia().menu();
    }
    
    public void mudarSenha(String senha) {
        Usuario usuario = mapeador.getUsuario(cpfLogado);
        usuario.setSenha(senha);
        mapeador.put(usuario);
        ControladorPrincipal.getInstancia().menu();
    }
    
    public void mudarNome(String nome) {
        Usuario usuario = mapeador.getUsuario(cpfLogado);
        usuario.setNome(nome);
        mapeador.put(usuario);
        ControladorPrincipal.getInstancia().menu();
    }
    
    public void adocaoCachorro(Cachorro cachorro) {
        Usuario usuario = mapeador.getUsuario(cpfLogado);
        usuario.registroCachorro(cachorro);
        mapeador.put(usuario);
    }
    
    public void adocaoGato(Gato gato) {
        Usuario usuario = mapeador.getUsuario(cpfLogado);
        usuario.registroGato(gato);
        mapeador.put(usuario);
    }
    
    public void adocaoPassaro(Passaro passaro) {
        Usuario usuario = mapeador.getUsuario(cpfLogado);
        usuario.registroPassaro(passaro);
        mapeador.put(usuario);
    }
    
    public void doaCachorro(Cachorro cachorro) {
        Usuario usuario = mapeador.getUsuario(cpfLogado);
        usuario.doaCachorro(cachorro);
        mapeador.put(usuario);
    }
    
    public void doaGato(Gato gato) {
        Usuario usuario = mapeador.getUsuario(cpfLogado);
        usuario.doaGato(gato);
        mapeador.put(usuario);
    }
    
    public void doaPassaro(Passaro passaro) {
        Usuario usuario = mapeador.getUsuario(cpfLogado);
        usuario.doaPassaro(passaro);
        mapeador.put(usuario);
    }
    
    public ArrayList<Animal> enviaListaAdocao() {
        Usuario usuario = mapeador.getUsuario(cpfLogado);
        return usuario.getAdocao();
    }
    
    public void apagaConta() {
        Usuario usuario = mapeador.getUsuario(cpfLogado);
        mapeador.remove(usuario);
        ControladorPrincipal.getInstancia().iniciaPrograma();
    }
    
    public void iniciar() {
        ControladorPrincipal.getInstancia().iniciaPrograma();
    }
    
    public void editarDados() {
        editarDados.fecha();
        editarDados = new EditarDados();
        editarDados.exibe();
    }
}
