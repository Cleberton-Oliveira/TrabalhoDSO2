package TelaPrincipal;
import Controlador.ControladorPrincipal;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Iniciar extends JFrame implements ActionListener{
    private ControladorPrincipal ctrlPrincipal;
    private JLabel lbTexto;
    private JButton btEntrar;
    private JButton btCriarConta;
//    private JTextField tfNome;          
//    private GerenciadorBotoes btManager;
    
    public Iniciar(ControladorPrincipal ctrlPrincipal){
       this.ctrlPrincipal = ctrlPrincipal; 
       tela();
    } 

    public void tela(){
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
 
        
        lbTexto = new JLabel("Bem Vindo ao controlador Principal");
        c.gridx = 0;
        c.gridy = 0;
        container.add(lbTexto, c);
        
        
//        tfNome = new JTextField();
//        c.gridx = 1;
//        c.gridy = 0;
//        container.add(tfNome, c);
        
        btEntrar = new JButton("Entrar");
        c.gridx = 0;
        c.gridy = 1;
        btEntrar.addActionListener(this);
        container.add(btEntrar, c);
        
        
        btCriarConta = new JButton("Criar Conta");
        c.gridx = 1;
        c.gridy = 1;
        btCriarConta.addActionListener(this); 
        container.add(btCriarConta, c);
        
        setSize(460, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource().equals(btEntrar)){
         fecha();   
         ctrlPrincipal.executaOpcaoLogin(1);
        }else if(e.getSource().equals(btCriarConta)){
            fecha();
            ctrlPrincipal.executaOpcaoLogin(2);
            
        }
    
    }

    public void exibe(){
        setVisible(true);
    }
    public void fecha(){
        setVisible(false);
    }
    


}

