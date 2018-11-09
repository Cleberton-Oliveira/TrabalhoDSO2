package Mapeadores;

import Entidade.Cachorro;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.ArrayList;

public class MapeadorCachorro {

    private HashMap<String, Cachorro> cachorros = new HashMap<>();
    private final String fileName = "arquivos.Cachorro";

    public MapeadorCachorro() {
        load();
    }

    public Cachorro getUsuario(String identificadorCachorro) {
        return cachorros.get(identificadorCachorro);
    }

    public void put(Cachorro cachorro) {
        cachorros.put(cachorro.getIdentificadorCachorro(), cachorro);
        persist();
    }

    public ArrayList<Cachorro> getList() {
        return new ArrayList(cachorros.values());
    }

    public void persist() {

        try {

            FileOutputStream fout = new FileOutputStream(fileName);
            ObjectOutputStream oIS = new ObjectOutputStream(fout);
            oIS.writeObject(cachorros);
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

            this.cachorros = (HashMap<String, Cachorro>) oIPS.readObject();

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

    public void remove(Cachorro cachorro) {
        cachorros.remove(cachorro.getIdentificadorCachorro());
        persist();
    }

}
