package br.ufsc.ine5605.Entidade;

import java.io.Serializable;


public class Passaro extends Animal implements Serializable{
      private int  raca;
      private String identificadorPassaro;
      
    public enum RACAPASSARO  {
        CACATUA(1),
        CALOPSITA(2),
        CANARIO(3),
        PAPAGAIO(4),
        PERIQUITO(5);  
        
        public final int id;
        
        RACAPASSARO(int idRacaPassaro){
            id = idRacaPassaro;
        }
    }

    public Passaro(String nome, int idade, int raca, int sexo, String id) {
        super(nome,sexo,idade);
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.sexo = sexo;
        this.identificadorPassaro = id;
    }

    public String getIdentificadorPassaro() {
        return identificadorPassaro;
    }



    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public int getIdade() {
        return idade;
    }

   
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getRaca() {
        return raca;
    }

    public void setRaca(int raca) {
        this.raca = raca;
    }

    
    public int getSexo() {
       return sexo;
    }
    
    public void setSexo(int sexo) {
        this.sexo = sexo;
    }
    
     @Override
    public String getEspecie() {
        int id = raca;   
        switch(id){
              case 1:
                  return "Cacatua";
              case 2:
                  return "Calopsita";
              case 3:
                  return "Canario";
              case 4:
                  return "Papagaio";
              case 5:
                  return "Periquito";                 
          }
          return "Erro ao cadastrar Passaro";
    }
}
