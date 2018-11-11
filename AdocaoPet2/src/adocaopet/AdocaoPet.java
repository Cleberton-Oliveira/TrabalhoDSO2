package adocaopet;

import Controlador.ControladorPrincipal;
import Entidade.Cachorro;
import Entidade.Gato;
import Entidade.Passaro;
import Entidade.Usuario;

public class AdocaoPet {
    public static void main(String[] args) {
//        Cachorro bidu = new Cachorro("Bidu", 12, 5, 1,);
//        Cachorro rex = new Cachorro("Rex", 2, 1, 1);
//        Cachorro toto = new Cachorro("Toto", 7, 1, 1);
//        Cachorro laica = new Cachorro("Laica", 1, 1, 2);
//        Gato kiara = new Gato("Kaira", 2, 3, 2);
//        Gato gatolina = new Gato("Gatolina", 12, 3, 2);
//        Gato chico = new Gato("Chico", 4, 3, 1);
//        Gato roberval = new Gato("Roberval", 9, 1, 1);
//        Passaro chitao = new Passaro("Chitão", 3, 1, 1);
//        Passaro gerson = new Passaro("Gerson", 15, 1, 1);
//        Passaro etvaldo = new Passaro("Etvaldo", 4, 2, 1);
//        Passaro piupui = new Passaro("Piu Piu", 8, 3, 1);
//        Passaro canarinha = new Passaro("Canarionha", 3, 3, 2);  
        Usuario superusuario = new Usuario("Cleberton", "123", "123");
        ControladorPrincipal.getInstancia().getCtrlUsuario().addSuperUsuario(superusuario);
//        ControladorPrincipal.getInstancia().getCtrlPet().addCachorro(bidu);
//        ControladorPrincipal.getInstancia().getCtrlPet().addCachorro(rex);
//        ControladorPrincipal.getInstancia().getCtrlPet().addCachorro(toto);
//        ControladorPrincipal.getInstancia().getCtrlPet().addCachorro(laica);
//        ControladorPrincipal.getInstancia().getCtrlPet().addGato(chico);
//        ControladorPrincipal.getInstancia().getCtrlPet().addGato(gatolina);
//        ControladorPrincipal.getInstancia().getCtrlPet().addGato(chico);
//        ControladorPrincipal.getInstancia().getCtrlPet().addGato(roberval);
//        ControladorPrincipal.getInstancia().getCtrlPet().addPassaro(chitao);
//        ControladorPrincipal.getInstancia().getCtrlPet().addPassaro(gerson);
//        ControladorPrincipal.getInstancia().getCtrlPet().addPassaro(etvaldo);
//        ControladorPrincipal.getInstancia().getCtrlPet().addPassaro(piupui);
//        ControladorPrincipal.getInstancia().getCtrlPet().addPassaro(canarinha);
        ControladorPrincipal.getInstancia().iniciaPrograma(); 
    }
    
}
