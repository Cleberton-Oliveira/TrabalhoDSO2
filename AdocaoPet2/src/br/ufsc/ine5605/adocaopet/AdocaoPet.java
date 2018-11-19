package br.ufsc.ine5605.adocaopet;

import br.ufsc.ine5605.Controlador.ControladorPrincipal;
import br.ufsc.ine5605.Entidade.Usuario;

public class AdocaoPet {
    public static void main(String[] args) {
        incializaAdmin();
        ControladorPrincipal.getInstancia().iniciaPrograma(); 
    }

    private static void incializaAdmin() {
        Usuario superusuario = new Usuario("Cleberton", "123", "123");
        ControladorPrincipal.getInstancia().getCtrlUsuario().addSuperUsuario(superusuario);
    }
    
}
