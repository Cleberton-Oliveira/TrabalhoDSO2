package Mapeadores;

import Entidade.Usuario;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.ArrayList;

public class MapeadorUsuario {

    private HashMap<String, Usuario> usuarios = new HashMap<>();
    private final String fileName = "arquivos.Usuario";

    public MapeadorUsuario() {
        load();
    }

    public Usuario getUsuario(String cpf) {
        return usuarios.get(cpf);
    }

    public void put(Usuario usuario) {
        usuarios.put(usuario.getCpf(), usuario);
        persist();
    }

    public ArrayList<Usuario> getList() {
        return new ArrayList(usuarios.values());
    }

    public void persist() {

        try {

            FileOutputStream fout = new FileOutputStream(fileName);
            ObjectOutputStream oIS = new ObjectOutputStream(fout);
            oIS.writeObject(usuarios);
            oIS.flush();
            fout.flush();
            oIS.close();
            fout.close();

        } catch (FileNotFoundException ex) {

            System.out.println("ARQUIVO NAO ENCONTRADO!!!");

        } catch (IOException ex) {

            System.out.println("PROBLEMA NA EXECUCAO DO PROGRAMA");

        }
    }

    public void load() {

        try {

            FileInputStream fIS = new FileInputStream(fileName);
            ObjectInputStream oIPS = new ObjectInputStream(fIS);

            this.usuarios = (HashMap<String, Usuario>) oIPS.readObject();

            oIPS.close();
            fIS.close();

        } catch (ClassNotFoundException ex) {

            System.out.println("ARQUIVO NAO ENCONTRADO !!");

        } catch (FileNotFoundException ex) {

            System.out.println("ARQUIVO NAO ENCONTRADO!!!");

        } catch (IOException e) {

            System.out.println("# ERROR # ");
            persist();
        }
    }

    public void remove(Usuario usuario) {

        usuarios.remove(usuario.getCpf());

        persist();
    }

}
