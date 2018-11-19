package br.ufsc.ine5605.Exception;

public class MaximoDeAnimaisAdotadosException extends Exception {
    
    public MaximoDeAnimaisAdotadosException() {
        this("Adotado o numero maximo de animais!");
    }
       
    public MaximoDeAnimaisAdotadosException(String mensagem) {
        super(mensagem);
    }   
}

