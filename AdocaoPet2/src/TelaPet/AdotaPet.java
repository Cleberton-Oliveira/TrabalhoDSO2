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

public class AdotaPet extends JFrame implements ActionListener{
    private ControladorPet ctrlPet;
    private JLabel lbTexto;
    private JButton btCachorro;
    private JButton btGato;
    private JButton btPassaro;
    private JButton btOk;
    private JButton btCancel;
    private JComboBox sexo;
    private JComboBox raca;
//    private JTextField tfNome;          
//    private GerenciadorBotoes btManager;
    
    private int animal;
    
    public AdotaPet(ControladorPet ctrlPet){
       
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
        c.gridx = 0;
        c.gridy = 2;
        btGato.addActionListener(this);
        container.add(btGato, c);
        
        btPassaro = new JButton("Passaro");
        c.gridx = 0;
        c.gridy = 3;
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
        
        
        String[] racaCachorro  = {"Pastor Alemão", "Labrador","Buldogle","Beagle","Poodle"}; 
        raca = new JComboBox(racaCachorro);
        raca.setSelectedIndex(0);
        c.gridx = 0;
        c.gridy = 4;
        raca.addActionListener(this);
        container.add(raca, c);
       
        lbTexto = new JLabel("Qual a raca?");
        c.gridx = 0;
        c.gridy = 5;
        container.add(lbTexto, c);
        
        DefaultComboBoxModel DefaultComboBoxModellistaDoCombo = new DefaultComboBoxModel();
        
        String[] s  = {"Masculino", "Feminino"}; 
        sexo = new JComboBox(s);
        
        sexo.setSelectedIndex(0);
        c.gridx = 0;
        c.gridy = 6;
        sexo.addActionListener(this);
        container.add(sexo, c);
        
        lbTexto = new JLabel("Qual o sexo?");
        c.gridx = 0;
        c.gridy = 7;
        container.add(lbTexto, c);
        
        btOk = new JButton("Enviar");
        c.gridx = 0;
        c.gridy = 8;
        btOk.addActionListener(this);
        container.add(btOk, c);
        
        btCancel = new JButton("Cancel");
        c.gridx = 1;
        c.gridy = 8;
        btCancel.addActionListener(this);
        container.add(btCancel, c);
        
        setSize(460, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
     public void gato(){
        Container container = getContentPane();
        container.setLayout(new GridBagLayout()); 
        GridBagConstraints c = new GridBagConstraints();
        
        
        String[] racaGato  = {"Persa", "Siames","Vira Lata","AzulRusso"}; 
        raca = new JComboBox(racaGato);
        raca.setSelectedIndex(0);
        c.gridx = 0;
        c.gridy = 4;
        raca.addActionListener(this);
        container.add(raca, c);
       
        lbTexto = new JLabel("Qual a raca?");
        c.gridx = 0;
        c.gridy = 5;
        container.add(lbTexto, c);
        
        DefaultComboBoxModel DefaultComboBoxModellistaDoCombo = new DefaultComboBoxModel();
        
        String[] s  = {"Masculino", "Feminino"}; 
        sexo = new JComboBox(s);
        
        sexo.setSelectedIndex(0);
        c.gridx = 0;
        c.gridy = 6;
        sexo.addActionListener(this);
        container.add(sexo, c);
        
        lbTexto = new JLabel("Qual o sexo?");
        c.gridx = 0;
        c.gridy = 7;
        container.add(lbTexto, c);
        
        btOk = new JButton("Enviar");
        c.gridx = 0;
        c.gridy = 8;
        btOk.addActionListener(this);
        container.add(btOk, c);
        
        btCancel = new JButton("Cancel");
        c.gridx = 1;
        c.gridy = 8;
        btCancel.addActionListener(this);
        container.add(btCancel, c);
        
        setSize(460, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
     
      public void passaro(){
        Container container = getContentPane();
        container.setLayout(new GridBagLayout()); 
        GridBagConstraints c = new GridBagConstraints();
        
        
        String[] racaPassaro  = {"Cacatua", "Calopsita","Canario","Papagaio","Periquito"}; 
        raca = new JComboBox(racaPassaro);
        raca.setSelectedIndex(0);
        c.gridx = 0;
        c.gridy = 4;
        raca.addActionListener(this);
        container.add(raca, c);
       
        lbTexto = new JLabel("Qual a raca?");
        c.gridx = 0;
        c.gridy = 5;
        container.add(lbTexto, c);
        
        DefaultComboBoxModel DefaultComboBoxModellistaDoCombo = new DefaultComboBoxModel();
        
        String[] s  = {"Masculino", "Feminino"}; 
        sexo = new JComboBox(s);
        
        sexo.setSelectedIndex(0);
        c.gridx = 0;
        c.gridy = 6;
        sexo.addActionListener(this);
        container.add(sexo, c);
        
        lbTexto = new JLabel("Qual o sexo?");
        c.gridx = 0;
        c.gridy = 7;
        container.add(lbTexto, c);
        
        btOk = new JButton("Enviar");
        c.gridx = 0;
        c.gridy = 8;
        btOk.addActionListener(this);
        container.add(btOk, c);
        
        btCancel = new JButton("Cancel");
        c.gridx = 1;
        c.gridy = 8;
        btCancel.addActionListener(this);
        container.add(btCancel, c);
        
        setSize(460, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource().equals(btCachorro)){
         cachorro();
         animal = 1;
         
        }else if(e.getSource().equals(btGato)){
         gato();
         animal = 2;
            
        }else if(e.getSource().equals(btPassaro)){
         passaro();
         animal =3;
    
       }else if(e.getSource().equals(btOk)){
            int intRaca = raca.getSelectedIndex() + 1;
            int intSexo = sexo.getSelectedIndex() + 1;
            fecha();
            ctrlPet.adocao(animal, intRaca, intSexo);
           
            
       }else if(e.getSource().equals(btCancel)){
           fecha();
           ctrlPet.menuPrincipal();    
       }            
    }
    public void exibe(){
        setVisible(true);
    }
    public void fecha(){
        setVisible(false);
    }
}

