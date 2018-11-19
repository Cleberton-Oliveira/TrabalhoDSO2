package br.ufsc.ine5605.TelaPet;

import br.ufsc.ine5605.Controlador.ControladorPet;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;

public class AdotaPet extends JFrame implements ActionListener {
    private JLabel lbTexto;
    private JLabel lbTitulo;
    private JButton btCachorro;
    private JButton btGato;
    private JButton btPassaro;
    private JButton btOk;
    private JButton btCancel;
    private JComboBox sexo;
    private JComboBox raca;


    private int animal;

    public AdotaPet() {
        tela();
    }

    public void tela() {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;

        
        lbTitulo = new JLabel("Qual Animal deseja adotar?");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        container.add(lbTitulo, c);

        btCachorro = new JButton("Cachorro");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        btCachorro.addActionListener(this);
        container.add(btCachorro, c);

        btGato = new JButton("Gato");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        btGato.addActionListener(this);
        container.add(btGato, c);

        btPassaro = new JButton("Passaro");
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        btPassaro.addActionListener(this);
        container.add(btPassaro, c);

        setSize(460, 290);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void cachorro() {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();      
         
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
        
        lbTexto = new JLabel("    -- ADOÇÃO DE CACHORRO --");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        container.add(lbTexto, c);
        
        
        String[] racaCachorro = {"Pastor Alemão", "Labrador", "Buldogle", "Beagle", "Poodle"};
        raca = new JComboBox(racaCachorro);
        raca.setSelectedIndex(0);
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 1;
        raca.addActionListener(this);
        container.add(raca, c);

        lbTexto = new JLabel("Qual a raca?");
        c.gridx = 0;
        c.gridy = 4;
        container.add(lbTexto, c);

        DefaultComboBoxModel DefaultComboBoxModellistaDoCombo = new DefaultComboBoxModel();

        String[] s = {"Masculino", "Feminino"};
        sexo = new JComboBox(s);

        sexo.setSelectedIndex(0);
        c.gridx = 1;
        c.gridy = 5;
        sexo.addActionListener(this);
        container.add(sexo, c);

        lbTexto = new JLabel("Qual o sexo?");
        c.gridx = 0;
        c.gridy = 5;
        container.add(lbTexto, c);

        btOk = new JButton("Enviar");
        c.gridx = 1;
        c.gridy = 6;
        btOk.addActionListener(this);
        container.add(btOk, c);

        btCancel = new JButton("Cancel");
        c.gridx = 0;
        c.gridy = 6;
        btCancel.addActionListener(this);
        container.add(btCancel, c);

  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void gato() {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
        
        lbTexto = new JLabel("      -- ADOÇÃO DE GATO --");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        container.add(lbTexto, c);
        
        
        String[] racaGato = {"Persa", "Siames", "Vira Lata", "AzulRusso"};
        raca = new JComboBox(racaGato);
        raca.setSelectedIndex(0);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        raca.addActionListener(this);
        container.add(raca, c);

        lbTexto = new JLabel("Qual a raca?");
        c.gridx = 0;
        c.gridy = 1;
        container.add(lbTexto, c);

        DefaultComboBoxModel DefaultComboBoxModellistaDoCombo = new DefaultComboBoxModel();

        String[] s = {"Masculino", "Feminino"};
        sexo = new JComboBox(s);

        sexo.setSelectedIndex(0);
        c.gridx = 1;
        c.gridy = 2;
        sexo.addActionListener(this);
        container.add(sexo, c);

        lbTexto = new JLabel("Qual o sexo?");
        c.gridx = 0;
        c.gridy = 2;
        container.add(lbTexto, c);

        btOk = new JButton("Enviar");
        c.gridx = 1;
        c.gridy = 3;
        btOk.addActionListener(this);
        container.add(btOk, c);

        btCancel = new JButton("Cancel");
        c.gridx = 0;
        c.gridy = 3;
        btCancel.addActionListener(this);
        container.add(btCancel, c);

      
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void passaro() {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
         c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
        
        lbTexto = new JLabel("   -- ADOÇÃO DE PASSARO --");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        container.add(lbTexto, c);
        
        

        String[] racaPassaro = {"Cacatua", "Calopsita", "Canario", "Papagaio", "Periquito"};
        raca = new JComboBox(racaPassaro);
        raca.setSelectedIndex(0);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        raca.addActionListener(this);
        container.add(raca, c);

        lbTexto = new JLabel("Qual a raca?");
        c.gridx = 0;
        c.gridy = 1;
        container.add(lbTexto, c);

        DefaultComboBoxModel DefaultComboBoxModellistaDoCombo = new DefaultComboBoxModel();

        String[] s = {"Masculino", "Feminino"};
        sexo = new JComboBox(s);
        sexo.setSelectedIndex(0);
        c.gridx = 1;
        c.gridy = 2;
        sexo.addActionListener(this);
        container.add(sexo, c);

        lbTexto = new JLabel("Qual o sexo?");
        c.gridx = 0;
        c.gridy = 2;
        container.add(lbTexto, c);

        btOk = new JButton("Enviar");
        c.gridx = 1;
        c.gridy = 3;
        btOk.addActionListener(this);
        container.add(btOk, c);

        btCancel = new JButton("Cancel");
        c.gridx = 0;
        c.gridy = 3;
        btCancel.addActionListener(this);
        container.add(btCancel, c);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btCachorro)) {
             lbTitulo.setVisible(false);
            btCachorro.setVisible(false);
            btGato.setVisible(false);
            btPassaro.setVisible(false);
            cachorro();
            animal = 1;

        } else if (e.getSource().equals(btGato)) {
             lbTitulo.setVisible(false);
            btCachorro.setVisible(false);
            btGato.setVisible(false);
            btPassaro.setVisible(false);
            gato();
            animal = 2;

        } else if (e.getSource().equals(btPassaro)) {
             lbTitulo.setVisible(false);
            btCachorro.setVisible(false);
            btGato.setVisible(false);
            btPassaro.setVisible(false);
            passaro();
            animal = 3;

        } else if (e.getSource().equals(btOk)) {
            int intRaca = raca.getSelectedIndex() + 1;
            int intSexo = sexo.getSelectedIndex() + 1;
            fecha();
            ControladorPet.getInstance().exibeAdocao(animal, intRaca, intSexo);

        } else if (e.getSource().equals(btCancel)) {
            fecha();
            ControladorPet.getInstance().menuPrincipal();
        }
    }

    public void exibe() {
        dispose();
        setVisible(true);
    }

    public void fecha() {

        setVisible(false);
    }

}
