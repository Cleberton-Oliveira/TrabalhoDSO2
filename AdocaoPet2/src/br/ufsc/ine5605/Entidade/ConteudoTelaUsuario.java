package br.ufsc.ine5605.Entidade;

import java.io.Serializable;


public class ConteudoTelaUsuario implements Serializable {
    public String nomeUsuario;
    public String cpfUsuario;
    public String senhaUsuario;
    
    
    
    public ConteudoTelaUsuario(){
        
    }

    public ConteudoTelaUsuario(String nome, String cpf, String senha) {
        this.nomeUsuario = nome;
        this.cpfUsuario = cpf;
        this.senhaUsuario = senha;
    }

}
