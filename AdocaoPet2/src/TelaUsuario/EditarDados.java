package TelaUsuario;

import Controlador.ControladorUsuario;
import Entidade.ConteudoTelaUsuario;
import java.util.InputMismatchException;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class EditarDados extends JFrame implements ActionListener {

    private JLabel texto;
    private JLabel titulo;
    private JButton btSair;
    private JButton btEditaNome;
    private JButton btEditaSenha;
    private JButton btNome;
    private JButton btSenha;
    private JTextField nome;
    private JPasswordField senha;

    public EditarDados() {
        tela();
    }

    public void tela() {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
        c.gridwidth = 2;

        titulo = new JLabel("Oque deseja editar:");
        c.gridx = 0;
        c.gridy = 0;
        container.add(titulo, c);

        btNome = new JButton("Nome");
        c.gridx = 0;
        c.gridy = 1;
        btNome.addActionListener(this);
        container.add(btNome, c);

        btSenha = new JButton("Senha");
        c.gridx = 0;
        c.gridy = 2;
        btSenha.addActionListener(this);
        container.add(btSenha, c);
       
        setSize(460, 290);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void editaNome() {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;

        texto = new JLabel("   -- Novo nome -- ");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        container.add(texto, c);

        nome = new JTextField();
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.ipady = 8;
        container.add(nome, c);

        btSair = new JButton("Sair");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        btSair.addActionListener(this);
        container.add(btSair, c);

        btEditaNome = new JButton("Salvar");
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        btEditaNome.addActionListener(this);
        container.add(btEditaNome, c);
           
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void editaSenha() {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;

        texto = new JLabel("  -- Nova senha --  ");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        container.add(texto, c);

        senha = new JPasswordField();
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.ipady = 8;
        container.add(senha, c);

        btSair = new JButton("Sair");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        btSair.addActionListener(this);
        container.add(btSair, c);

        btEditaSenha = new JButton("Salvar");
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        btEditaSenha.addActionListener(this);
        container.add(btEditaSenha, c);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }


    public void exibe() {
        setVisible(true);
    }

    public void fecha() {
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btNome)) {
            btNome.setVisible(false);
            btSenha.setVisible(false);
            titulo.setVisible(false);
            editaNome();
        } else if (e.getSource().equals(btSenha)) {
            btNome.setVisible(false);
            btSenha.setVisible(false);
            titulo.setVisible(false);
            editaSenha();       
        } else if (e.getSource().equals(btSair)) {
            fecha();
            ControladorUsuario.getInstance().telaPrincipal();
        } else if (e.getSource().equals(btEditaSenha)) {
            fecha();
            JOptionPane.showMessageDialog(null, "Senha editada com sucesso");
            ControladorUsuario.getInstance().mudarSenha(senha.getText());
        } else if (e.getSource().equals(btEditaNome)) {
            fecha();
            JOptionPane.showMessageDialog(null, "Nome editado com sucesso");
            ControladorUsuario.getInstance().mudarNome(nome.getText());
        }
    }
}
