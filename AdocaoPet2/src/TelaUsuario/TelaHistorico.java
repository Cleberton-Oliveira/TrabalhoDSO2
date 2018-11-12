package TelaUsuario;

import Controlador.ControladorUsuario;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTable;
import Entidade.Usuario;
import Entidade.Animal;
import java.awt.GridBagLayout;
import java.util.ArrayList;

public class TelaHistorico extends JFrame implements ActionListener {
    
    private JLabel label;
    private JButton btSair;
    // private GerenciadorBotoes btManager;

    public void historico(String nome, ArrayList<Animal> adocao, ArrayList<Animal> doacao) {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout()); 
        GridBagConstraints c = new GridBagConstraints();

        label = new JLabel("Historico ");
        c.gridx = 0;
        c.gridy = 0;
        container.add(label, c);
        
        
        btSair = new JButton("Sair");
        c.gridx = 0;
        c.gridy = 5;
        btSair.addActionListener(this);
        container.add(btSair, c);

        setVisible(true);
        setSize(460, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    
    
    public void historicoSuperUsuario(String nome, ArrayList<Animal> adocao,
            ArrayList<Animal> doacao, ArrayList<Usuario> list) {
        

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btSair)) {
            fechar();
            ControladorUsuario.getInstance().telaPrincipal();

        }

    }

    public void fechar() {
        setVisible(false);
    }

    

}
