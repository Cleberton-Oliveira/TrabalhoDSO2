package TelaUsuario;

import Controlador.ControladorUsuario;
import Entidade.Usuario;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HistoricoSuperUser extends JFrame implements ActionListener {

    private JLabel lbTexto;
    private JButton btOk;
    private JButton btCancel;
    private JComboBox comboUsuarios;
    private ArrayList<String> id;

    public void listagem(ArrayList<Usuario> usuarios) {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        this.id = new ArrayList<>();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;

        c.gridwidth = 2;

        lbTexto = new JLabel(" -- >> LISTAGEM HISTORICO USUARIOS << --");
        c.gridx = 0;
        c.gridy = 0;
        container.add(lbTexto, c);

        ArrayList<String> exibeUsuario = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            String user = "NOME: " + usuario.getNome() + "  || CPF: " + usuario.getCpf();
            id.add(usuario.getCpf());
            exibeUsuario.add(user);
        }

        comboUsuarios = new JComboBox(exibeUsuario.toArray());
        comboUsuarios.setSelectedIndex(0);
        c.ipady = 4;
        c.gridx = 0;
        c.gridy = 1;
        c.ipady = 12;
        c.gridwidth = 1;
        comboUsuarios.addActionListener(this);
        container.add(comboUsuarios, c);

        btOk = new JButton("Conferir");

        c.gridy = 1;       //third row
        c.gridx = 1;
        c.gridwidth = 1;
        btOk.addActionListener(this);
        container.add(btOk, c);

        btCancel = new JButton("Sair");
        c.ipady = 4;
        c.insets = new Insets(40, 0, 0, 0);
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 2;
        btCancel.addActionListener(this);
        container.add(btCancel, c);

        setSize(490, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    @Override
        public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btCancel)) {
            fecha();
            ControladorUsuario.getInstance().telaPrincipal();

        } else if (e.getSource().equals(btOk)) {
            fecha();        
            ControladorUsuario.getInstance().imprimeHistorico(id.get(comboUsuarios.getSelectedIndex()));
        }
    }
    public void fecha() {
        setVisible(false);
    }
}
