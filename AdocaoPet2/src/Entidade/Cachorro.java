package Entidade;

import java.util.EnumSet;


public class Cachorro extends Animal{
      private int  raca; 

    
    public enum RACACACHORRO  {
        PASTOR_ALEMAO("PASTOR_ALEMAO"),
        LABRADOR("LABRADOR"),
        BULDOGLE("BULDOGLE"),
        BEAGLE("BEAGLE"),
        POODLE("POODLE");  
        
        public final String mensagem;
        
         
        RACACACHORRO(String raca){
            mensagem = raca;
        }
        
        
        
    }
    
    
    public Cachorro(String nome, int idade, int raca, int sexo) {
        super(nome,sexo,idade);
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.sexo = sexo;
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
