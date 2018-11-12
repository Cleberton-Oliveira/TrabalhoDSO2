package TelaPet;

import Controlador.ControladorPet;
import Entidade.Cachorro;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Entidade.Gato;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import Entidade.ConteudoTelaPet;
import java.awt.Color;
import java.awt.Insets;
import java.lang.NumberFormatException;
import javax.swing.border.LineBorder;

public class DoarPet extends JFrame implements ActionListener {

    private JLabel lbTexto;
    private JLabel lbTitulo;
    private JButton btCachorro;
    private JButton btGato;
    private JButton btPassaro;
    private JButton btOk;
    private JButton btCancel;
    private JComboBox sexo;
    private JComboBox raca;
    private JTextField nome;
    private JTextField idade;
//    private GerenciadorBotoes btManager;

    private int animal;

    public DoarPet() {
        tela();
    }

    public void tela() {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;

        lbTitulo = new JLabel("Qual Animal deseja doar?");
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

        lbTexto = new JLabel("                                    -- DOAÇÃO DE CACHORRO --");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        container.add(lbTexto, c);

        lbTexto = new JLabel("Nome: ");
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        container.add(lbTexto, c);

        nome = new JTextField();
        c.gridx = 1;
        c.gridy = 4;
        container.add(nome, c);

        lbTexto = new JLabel("Idade: ");
        c.gridx = 0;
        c.gridy = 5;
        container.add(lbTexto, c);

        idade = new JTextField();
        c.gridx = 1;
        c.gridy = 5;
        c.weightx = 1.;
        c.fill = GridBagConstraints.HORIZONTAL;
        container.add(idade, c);

        String[] racaCachorro = {"Pastor Alemão", "Labrador", "Buldogle", "Beagle", "Poodle"};
        raca = new JComboBox(racaCachorro);
        raca.setSelectedIndex(0);
        c.gridx = 1;
        c.gridy = 6;
        raca.addActionListener(this);
        container.add(raca, c);

        lbTexto = new JLabel("Qual a raca?");
        c.gridx = 0;
        c.gridy = 6;
        container.add(lbTexto, c);

        DefaultComboBoxModel DefaultComboBoxModellistaDoCombo = new DefaultComboBoxModel();

        String[] s = {"Masculino", "Feminino"};
        sexo = new JComboBox(s);
        sexo.setSelectedIndex(0);
        c.gridx = 1;
        c.gridy = 7;
        sexo.addActionListener(this);
        container.add(sexo, c);

        lbTexto = new JLabel("Qual o sexo?");
        c.gridx = 0;
        c.gridy = 7;
        container.add(lbTexto, c);

        btOk = new JButton("Enviar");
        c.gridx = 1;
        c.gridy = 8;
        btOk.addActionListener(this);
        container.add(btOk, c);

        btCancel = new JButton("Cancel");
        c.gridx = 0;
        c.gridy = 8;
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

        lbTexto = new JLabel("                                   -- DOAÇÃO DE GATO --");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        container.add(lbTexto, c);

        lbTexto = new JLabel("Nome: ");
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        container.add(lbTexto, c);

        nome = new JTextField();
        c.gridx = 1;
        c.gridy = 4;
        c.weightx = 1.;
        c.fill = GridBagConstraints.HORIZONTAL;
        container.add(nome, c);

        lbTexto = new JLabel("Idade: ");
        c.gridx = 0;
        c.gridy = 5;
        container.add(lbTexto, c);

        idade = new JTextField();
        c.gridx = 1;
        c.gridy = 5;
        c.weightx = 1.;
        c.fill = GridBagConstraints.HORIZONTAL;
        container.add(idade, c);

        String[] racaGato = {"Persa", "Siames", "Vira Lata", "AzulRusso"};
        raca = new JComboBox(racaGato);
        raca.setSelectedIndex(0);
        c.gridx = 1;
        c.gridy = 6;
        raca.addActionListener(this);
        container.add(raca, c);

        lbTexto = new JLabel("Qual a raca?");
        c.gridx = 0;
        c.gridy = 6;
        container.add(lbTexto, c);
        DefaultComboBoxModel DefaultComboBoxModellistaDoCombo = new DefaultComboBoxModel();

        String[] s = {"Masculino", "Feminino"};
        sexo = new JComboBox(s);
        sexo.setSelectedIndex(0);
        c.gridx = 1;
        c.gridy = 7;
        sexo.addActionListener(this);
        container.add(sexo, c);

        lbTexto = new JLabel("Qual o sexo?");
        c.gridx = 0;
        c.gridy = 7;
        container.add(lbTexto, c);

        btOk = new JButton("Enviar");
        c.gridx = 1;
        c.gridy = 8;
        btOk.addActionListener(this);
        container.add(btOk, c);

        btCancel = new JButton("Cancel");
        c.gridx = 0;
        c.gridy = 8;
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

        lbTexto = new JLabel("                                 -- DOAÇÃO DE PASSARO --");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        container.add(lbTexto, c);

        lbTexto = new JLabel("Nome:");
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        container.add(lbTexto, c);

        nome = new JTextField();
        c.gridx = 1;
        c.gridy = 4;
        c.weightx = 2.;
        c.fill = GridBagConstraints.HORIZONTAL;
        container.add(nome, c);

        lbTexto = new JLabel("Idade: ");
        c.gridx = 0;
        c.gridy = 5;
        container.add(lbTexto, c);

        idade = new JTextField();
        c.gridx = 1;
        c.gridy = 5;
        c.weightx = 1.;
        c.fill = GridBagConstraints.HORIZONTAL;
        container.add(idade, c);

        String[] racaPassaro = {"Cacatua", "Calopsita", "Canario", "Papagaio", "Periquito"};
        raca = new JComboBox(racaPassaro);
        raca.setSelectedIndex(0);

        c.gridx = 1;
        c.gridy = 6;
        raca.addActionListener(this);
        container.add(raca, c);

        lbTexto = new JLabel("Qual a raca?");
        c.gridx = 0;
        c.gridy = 6;
        container.add(lbTexto, c);

        DefaultComboBoxModel DefaultComboBoxModellistaDoCombo = new DefaultComboBoxModel();

        String[] s = {"Masculino", "Feminino"};
        sexo = new JComboBox(s);

        sexo.setSelectedIndex(0);
        c.gridx = 1;
        c.gridy = 7;
        sexo.addActionListener(this);
        container.add(sexo, c);

        lbTexto = new JLabel("Qual o sexo?");
        c.gridx = 0;
        c.gridy = 7;
        container.add(lbTexto, c);

        btOk = new JButton("Enviar");
        c.gridx = 1;
        c.gridy = 10;
        btOk.addActionListener(this);
        container.add(btOk, c);

        btCancel = new JButton("Cancel");
        c.gridx = 0;
        c.gridy = 10;
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
            ConteudoTelaPet conteudoTela = new ConteudoTelaPet();
            conteudoTela.racaPet = raca.getSelectedIndex() + 1;
            conteudoTela.sexoPet = sexo.getSelectedIndex() + 1;
            conteudoTela.nomePet = nome.getText();
            try {
                conteudoTela.idadePet = Integer.parseInt(idade.getText());
            } catch (NumberFormatException erro) {
                System.out.println("Digite uma opção válida!" + erro.getMessage());
                JOptionPane.showMessageDialog(null, "Valor Invalido\n Digite um valor inteiro para idade");
                return;
            }

            switch (animal) {
                case 1:
                    ControladorPet.getInstance().cadastroDog(conteudoTela);
                    fecha();
                    JOptionPane.showMessageDialog(null, "PARABÉNS\n Cachorro doado com sucesso.");
                    break;
                case 2:
                    ControladorPet.getInstance().cadastroGato(conteudoTela);
                    fecha();
                    JOptionPane.showMessageDialog(null, "PARABÉNS\n Gato doado com sucesso.");
                    break;
                case 3:
                    ControladorPet.getInstance().cadastroPassaro(conteudoTela);
                    fecha();
                    JOptionPane.showMessageDialog(null, "PARABÉNS\n Passaro doado com sucesso.");
                    break;
            }

        } else if (e.getSource().equals(btCancel)) {
            fecha();
            ControladorPet.getInstance().menuPrincipal();
        }
    }

    public void exibe() {
        setVisible(true);
    }

    public void fecha() {
        setVisible(false);
    }
}
