package Controlador;

import Entidade.Animal;
import Entidade.Cachorro;
import Entidade.Gato;
import Entidade.Passaro;
import TelaUsuario.Login;
import TelaPrincipal.Iniciar;
import TelaPrincipal.Menu;
import java.util.ArrayList;

public final class ControladorPrincipal{
    private static ControladorPrincipal instancia;
    private Iniciar iniciar;
    private Login login;
    private Menu menu;

    private final int CACHORRO = 1, GATO = 2, PASSARO = 3;

    private ControladorPrincipal() {
        this.iniciar = new Iniciar();
        this.menu = new Menu();
    }

    public static synchronized ControladorPrincipal getInstancia() {
        if (instancia == null) {
            instancia = new ControladorPrincipal();
        }
        return instancia;
    }

    public ControladorUsuario getCtrlUsuario() {
        return ControladorUsuario.getInstance();
    }

    public void iniciaPrograma() {
        iniciar.exibe();
    }

    public void executaOpcaoLogin(int opcao) {
        switch (opcao) {
            case 1:
                ControladorUsuario.getInstance().fazerLoginTela();
                break;
            case 2:
                ControladorUsuario.getInstance().fazerCadastroUsuario();
                break;
        }
    }

    public void menu() {
        menu.exibe();
    }

    public void historico() {
        ControladorUsuario.getInstance().historicoUsuario();
    }

    public void mudaSenha(String senha) {
        ControladorUsuario.getInstance().mudarSenha(senha);
    }

    public void mudaNome(String nome) {
        ControladorUsuario.getInstance().mudarNome(nome);
    }

    public void adocaoCachorro(Cachorro cachorro) {
        ControladorUsuario.getInstance().adocaoCachorro(cachorro);
    }

    public void adocaoGato(Gato gato) {
        ControladorUsuario.getInstance().adocaoGato(gato);
    }

    public void adocaoPassaro(Passaro passaro) {
        ControladorUsuario.getInstance().adocaoPassaro(passaro);
    }

    public void doaCachorro(Cachorro cachorro) {
        ControladorUsuario.getInstance().doaCachorro(cachorro);
    }

    public void doaGato(Gato gato) {
        ControladorUsuario.getInstance().doaGato(gato);
    }

    public void doaPassaro(Passaro passaro) {
        ControladorUsuario.getInstance().doaPassaro(passaro);
    }

    public ArrayList<Animal> adocoesUsuario() {
        ArrayList<Animal> adocoes = ControladorUsuario.getInstance().enviaListaAdocao();
        return adocoes;
    }

    public void apagaConta() {
        ControladorUsuario.getInstance().apagaConta();
    }

    public void adotaPet() {
        ControladorPet.getInstance().adotaPet();
    }

    public void doarPet() {
        ControladorPet.getInstance().doarPet();
    }

    public void editarDados() {
        ControladorUsuario.getInstance().editarDados();
    }

}
