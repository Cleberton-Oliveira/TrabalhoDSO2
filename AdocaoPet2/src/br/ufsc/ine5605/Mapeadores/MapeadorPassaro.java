package br.ufsc.ine5605.Mapeadores;

import br.ufsc.ine5605.Entidade.Passaro;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.ArrayList;

public class MapeadorPassaro {

    private HashMap<String, Passaro> passaros = new HashMap<>();
    private final String fileName = "arquivos.Passaro";

    public MapeadorPassaro() {
        load();
    }

    public Passaro getPassaro(String identificadorPassaro) {
        return passaros.get(identificadorPassaro);
    }

    public void put(Passaro passaro) {
        passaros.put(passaro.getIdentificadorPassaro(), passaro);
        persist();
    }

    public ArrayList<Passaro> getList() {
        return new ArrayList(passaros.values());
    }

    public void persist() {

        try {

            FileOutputStream fout = new FileOutputStream(fileName);
            ObjectOutputStream oIS = new ObjectOutputStream(fout);
            oIS.writeObject(passaros);
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

            this.passaros = (HashMap<String, Passaro>) oIPS.readObject();

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

    public void remove(Passaro passaro) {
        passaros.remove(passaro.getIdentificadorPassaro());
        persist();
    }

}
