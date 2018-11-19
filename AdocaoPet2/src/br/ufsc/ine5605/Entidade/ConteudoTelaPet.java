package br.ufsc.ine5605.Entidade;

import java.io.Serializable;


public class ConteudoTelaPet implements Serializable{
    public String nomePet;
    public int idadePet;
    public int racaPet;
    public int sexoPet;
    public String identificador;
    
      public ConteudoTelaPet(String nomePet, int idadePet, int racaPet, int sexoPet, String identificador) {
        this.nomePet = nomePet;
        this.idadePet = idadePet;
        this.racaPet = racaPet;
        this.sexoPet = sexoPet;
        this.identificador = identificador;
    }

    public ConteudoTelaPet() {

    }
    
    
}
