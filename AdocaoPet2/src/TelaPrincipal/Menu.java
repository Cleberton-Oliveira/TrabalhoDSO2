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

public class Menu extends JFrame implements ActionListener{
    private JLabel lbTexto;
    private JButton btAdotar;
    private JButton btDoar;
    private JButton btHistorico;
    private JButton btEditarDados;
    private JButton btSair;
    private JButton btApagarConta;
  
//    private JTextField tfNome;          
//    private GerenciadorBotoes btManager;
    
    public Menu(){
       tela();
    } 

    public void tela(){
        Container container = getContentPane();
        container.setLayout(new GridBagLayout()); 
        GridBagConstraints c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
        c.gridwidth = 3;
        
        lbTexto = new JLabel(" --- MENU PRINCIPAL ---");
        c.gridx = 0;
        c.gridy = 0;
        container.add(lbTexto, c);

        btAdotar = new JButton("Adotar PET");
        c.gridx = 0;
        c.gridy = 1;
        btAdotar.addActionListener(this);
        container.add(btAdotar, c);
        
        btDoar = new JButton("Doar PET");
        c.gridx = 0;
        c.gridy = 2;
        btDoar.addActionListener(this);
        container.add(btDoar, c);
        
        btHistorico = new JButton("Historico");
        c.gridx = 0;
        c.gridy = 3;
        btHistorico.addActionListener(this);
        container.add(btHistorico, c);
        
        btEditarDados = new JButton("Editar Dados");
        c.gridx = 0;
        c.gridy = 4;
        btEditarDados.addActionListener(this);
        container.add(btEditarDados, c);
        
        btSair = new JButton("Sair");
        c.gridx = 0;
        c.gridy = 5;
        btSair.addActionListener(this);
        container.add(btSair, c);
        
        btApagarConta = new JButton("Apagar Conta");
        c.gridx = 0;
        c.gridy = 6;
        btApagarConta.addActionListener(this);
        container.add(btApagarConta, c);

        setSize(460, 290);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource().equals(btAdotar)){
         fecha();   
        ControladorPrincipal.getInstancia().adotaPet();
        }else if(e.getSource().equals(btDoar)){
            fecha();
          ControladorPrincipal.getInstancia().doarPet();
            
        }else if(e.getSource().equals(btHistorico)){
            fecha();
            ControladorPrincipal.getInstancia().historico();
        }else if(e.getSource().equals(btEditarDados)){
            fecha();
            ControladorPrincipal.getInstancia().editarDados();
            
        }else if(e.getSource().equals(btSair)){
            fecha();
        ControladorPrincipal.getInstancia().iniciaPrograma();
            
        }else if(e.getSource().equals(btApagarConta)){
           fecha();
            ControladorPrincipal.getInstancia().apagaConta();            
        }
    }
    public void exibe(){
        setVisible(true);
    }
    public void fecha(){
        setVisible(false);
    }
    


}

