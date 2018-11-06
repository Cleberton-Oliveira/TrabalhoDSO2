package TelaPet;
import Controlador.ControladorPet;
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
import Entidade.Cachorro;

public class EscolhaPet extends JFrame implements ActionListener{
    private ControladorPet ctrlPet;
    private JLabel lbTexto;
    private JButton btCachorro;
    private JButton btGato;
    private JButton btPassaro;
    private JButton btOk;
   

  
//    private JTextField tfNome;          
//    private GerenciadorBotoes btManager;
    
    public EscolhaPet(ControladorPet ctrlPet){
       
       this.ctrlPet = ctrlPet; 
       tela();
    } 

    public void tela(){
        Container container = getContentPane();
        container.setLayout(new GridBagLayout()); 
        GridBagConstraints c = new GridBagConstraints();

        lbTexto = new JLabel("Qual Animal deseja adotar?");
        c.gridx = 0;
        c.gridy = 0;
        container.add(lbTexto, c);

        btCachorro = new JButton("Cachorro");
        c.gridx = 0;
        c.gridy = 1;
        btCachorro.addActionListener(this);
        container.add(btCachorro, c);
        
        btGato = new JButton("Gato");
        c.gridx = 1;
        c.gridy = 1;
        btGato.addActionListener(this);
        container.add(btGato, c);
        
        btPassaro = new JButton("Passaro");
        c.gridx = 2;
        c.gridy = 1;
        btPassaro.addActionListener(this);
        container.add(btPassaro, c);
       
        setSize(460, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    
        public void cachorro(){
        Container container = getContentPane();
        container.setLayout(new GridBagLayout()); 
        GridBagConstraints c = new GridBagConstraints();

        String[] petStrings = {};

        JComboBox racaCachorro = new JComboBox(Cachorro.RACACACHORRO.values());
        racaCachorro = new JComboBox();
        c.gridx = 1;
        c.gridy = 1;
        racaCachorro.addActionListener(this);
        container.add(racaCachorro, c);
        
        lbTexto = new JLabel("Qual a raca?");
        c.gridx = 0;
        c.gridy = 1;
        container.add(lbTexto, c);
        
        setSize(460, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource().equals(btCachorro)){
        cachorro();
         
        }else if(e.getSource().equals(btGato)){
//            ctrlPrincipal.doaPet();
            
        }else if(e.getSource().equals(btPassaro)){
//            ctrlPrincipal.historico();
       }    
    }
    public void exibe(){
        setVisible(true);
    }
    public void fecha(){
        setVisible(false);
    }
}

