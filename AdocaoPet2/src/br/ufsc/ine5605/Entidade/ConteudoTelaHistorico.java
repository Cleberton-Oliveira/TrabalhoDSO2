package br.ufsc.ine5605.Entidade;

import java.io.Serializable;
import java.util.ArrayList;

public class ConteudoTelaHistorico implements Serializable {

    public String nome;
    public ArrayList<Animal> adocao;
    public ArrayList<Animal> doacao;

    public ConteudoTelaHistorico(String nome, ArrayList<Animal> adocao, ArrayList<Animal> doacao) {
        this.nome = nome;
        this.adocao = adocao;
        this.doacao = doacao;
    }

    public ConteudoTelaHistorico() {
    }

}
