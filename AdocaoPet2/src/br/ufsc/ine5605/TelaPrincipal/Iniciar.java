package br.ufsc.ine5605.TelaPrincipal;

import br.ufsc.ine5605.Controlador.ControladorPrincipal;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Iniciar extends JFrame implements ActionListener {

    private JLabel lbTexto;
    private JButton btEntrar;
    private JButton btCriarConta;
//    private JTextField tfNome;          
//    private GerenciadorBotoes btManager;

    public Iniciar() {

        tela();
    }

    public void tela() {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        lbTexto = new JLabel("Bem Vindo ao Doação de Pet");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 20; // faz este componente alto
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        container.add(lbTexto, c);

        btEntrar = new JButton("Entrar");
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        btEntrar.addActionListener(this);
        container.add(btEntrar, c);

        btCriarConta = new JButton("Criar Conta");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        btCriarConta.addActionListener(this);
        container.add(btCriarConta, c);

        setSize(460, 290);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btEntrar)) {
            fecha();
            ControladorPrincipal.getInstancia().executaOpcaoLogin(1);
        } else if (e.getSource().equals(btCriarConta)) {
            fecha();
            ControladorPrincipal.getInstancia().executaOpcaoLogin(2);

        }

    }

    public void exibe() {
        setVisible(true);
    }

    public void fecha() {
        setVisible(false);
    }

}
