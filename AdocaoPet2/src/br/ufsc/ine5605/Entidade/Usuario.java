package br.ufsc.ine5605.Entidade;

import br.ufsc.ine5605.Interfaces.IUsuario;
import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements IUsuario, Serializable{
    private String nome;
    private String cpf;
    private String senha;
    private String login;
    private boolean superuser;
    private ArrayList<Animal> adocao;
    private ArrayList<Animal> doacao;



    public Usuario(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.login = cpf+senha; 
        this.superuser = false;
        this.adocao = new ArrayList<>();
        this.doacao = new ArrayList<>();
    }

    public boolean getSuperuser() {
        return superuser;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String getCpf() {
        return cpf;
    }
    public void eSuperUser(){
        this.superuser = true;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
        this.login = cpf+getSenha();
    }

    @Override
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
        this.login = getCpf()+senha;
    }

    @Override
    public String getLogin() {
        return login;
    }

    public void registroCachorro(Cachorro cachorro) {  
        this.adocao.add(cachorro);     
    }
    public void registroGato(Gato gato) {
        this.adocao.add(gato);
    }
    public void registroPassaro(Passaro passaro) {
        this.adocao.add(passaro);
    }
    
    public void doaCachorro(Cachorro cachorro) {
        this.doacao.add(cachorro);
    }
    public void doaGato(Gato gato) {
        this.doacao.add(gato);
    }
    public void doaPassaro(Passaro passaro) {
        this.doacao.add(passaro);
    }

    @Override
    public ArrayList<Animal> getAdocao() {
        return adocao;
    }
    
    @Override
     public ArrayList<Animal> getDoacao() {
        return doacao;
    }
    
}
