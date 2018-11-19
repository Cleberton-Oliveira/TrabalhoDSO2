package br.ufsc.ine5605.Exception;

public class MaximoDaMesmaEspecieException extends Exception{
    
    public MaximoDaMesmaEspecieException() {
        this("Adotado o numero maximo de animais da mesma especie!");
    }
       
    public MaximoDaMesmaEspecieException(String mensagem) {
        super(mensagem);
    }   
}


