package br.ufsc.ine5605.Entidade;

import java.io.Serializable;


public class Cachorro extends Animal implements Serializable{
    private String identificadorCachorro;
    private int  raca;
    
    public enum RACACACHORRO  {
        PASTOR_ALEMAO(1),
        LABRADOR(2),
        BULDOGLE(3),
        BEAGLE(4),
        POODLE(5);  
        
        
        public final int id;
        
        RACACACHORRO(int idRacaCachorro){
            id = idRacaCachorro;
        }     
        
    }
    
    
    public Cachorro(String nome, int idade, int raca, int sexo, String id){
        super(nome,sexo,idade);
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.sexo = sexo;
        this.identificadorCachorro = id;
    }

    public String getIdentificadorCachorro() {
        return identificadorCachorro;
    }

    public void setIdentificadorCachorro(String identificadorCachorro) {
        this.identificadorCachorro = identificadorCachorro;
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
                  return "Pastor Alemao";
              case 2:
                  return "Labrador";
              case 3:
                  return "Buldogle";
              case 4:
                  return "Beagle";
              case 5:
                  return "Poodle";                 
          }
          return "Erro ao cadastrar Cachorro";
    }
    
}
