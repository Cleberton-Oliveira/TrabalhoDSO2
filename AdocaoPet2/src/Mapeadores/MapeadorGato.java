package Mapeadores;

import Entidade.Gato;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.ArrayList;

public class MapeadorGato {

    private HashMap<String, Gato> gatos = new HashMap<>();
    private final String fileName = "arquivos.Gato";

    public MapeadorGato() {
        load();
    }

    public Gato getUsuario(String identificadorGato) {
        return gatos.get(identificadorGato);
    }

    public void put(Gato gato) {
        gatos.put(gato.getIdentificadorGato(), gato);
        persist();
    }

    public ArrayList<Gato> getList() {
        return new ArrayList(gatos.values());
    }

    public void persist() {

        try {

            FileOutputStream fout = new FileOutputStream(fileName);
            ObjectOutputStream oIS = new ObjectOutputStream(fout);
            oIS.writeObject(gatos);
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

            this.gatos = (HashMap<String, Gato>) oIPS.readObject();

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

    public void remove(Gato gato) {
        gatos.remove(gato.getIdentificadorGato());
        persist();
    }

}
