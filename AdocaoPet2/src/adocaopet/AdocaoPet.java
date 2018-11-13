package adocaopet;

import Controlador.ControladorPrincipal;
import Entidade.Cachorro;
import Entidade.Gato;
import Entidade.Passaro;
import Entidade.Usuario;

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
