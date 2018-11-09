package Entidade;


public class Gato extends Animal{
      private int  raca;
      public String identificadorGato;


    public enum RACAGATO  {
        PERSA(1),
        SIAMES(2),
        VIRA_LATA(3),
        AZUL_RUSSO(4);
        
        public final int id;
        
        RACAGATO(int idRacaGato){
            id = idRacaGato;
        }
    }

    public Gato(String nome, int idade, int raca, int sexo, String id) {
        super(nome,sexo,idade);
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.sexo = sexo;
        this.identificadorGato = "gato" + id;
    }

    public String getIdentificadorGato() {
        return identificadorGato;
    }

    public void setIdentificadorGato(String identificadorGato) {
        this.identificadorGato = identificadorGato;
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
                  return "Persa";
              case 2:
                  return "Siames";
              case 3:
                  return "Vira Lata";
              case 4:
                  return "AzulRusso";               
          }
          return "Erro ao cadastrar Gato";
    }
}
