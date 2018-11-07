
package Entidade;

import Interfaces.IAnimal;

public abstract class Animal implements IAnimal {
    
    String nome;
    int sexo;
    int idade;
    int raca;

    public Animal(String nome, int sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    @Override
    public String getNome() {
        return nome;
    }
    @Override
    public int getIdade(){
        return idade;
    }
    @Override
    public int getSexo(){
        return sexo;
    }
    
    
    @Override
    public String getNomeSexo(int sexo){
        if(sexo == 1){
            return "Masculino";
        }else  if(sexo == 2){
            return "Feminino";
        } 
        return "Erro ao tentar cadastrar esse animal";
    }     
    public abstract String getEspecie();       
}
