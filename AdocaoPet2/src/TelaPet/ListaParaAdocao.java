package TelaPet;
import Controlador.ControladorPet;
import Entidade.ConteudoTelaPet;
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
import java.util.ArrayList;
import javax.swing.ComboBoxModel;

public class ListaParaAdocao extends JFrame implements ActionListener{
    private ControladorPet ctrlPet;
    private JLabel lbTexto;
    private JButton btOk;
    private JButton btCancel; 
    private JComboBox animal;
//    private GerenciadorBotoes btManager;
    
    public ListaParaAdocao(ControladorPet ctrlPet){
       
       this.ctrlPet = ctrlPet; 
     } 

    public void listagem(int pet, ArrayList<ConteudoTelaPet> listagemPets){
        Container container = getContentPane();
        container.setLayout(new GridBagLayout()); 
        GridBagConstraints c = new GridBagConstraints();

        lbTexto = new JLabel("Listagem de animais para adoção:" );
        c.gridx = 0;
        c.gridy = 0;
        container.add(lbTexto, c);
        
        int numero = 1;
        
        
        
        if(listagemPets.isEmpty()){
             lbTexto = new JLabel("Não temos nenhum animal com essas caracteristicas no momento" );
             c.gridx = 0;
             c.gridy = 1;
             container.add(lbTexto, c);
             
            btCancel = new JButton("Cancel");
            c.gridx = 1;
            c.gridy = 8;
            btCancel.addActionListener(this);
            container.add(btCancel, c);
             
             
        }else{
            ArrayList<String> pets = new ArrayList<>();
           
            for (ConteudoTelaPet conteudoTela : listagemPets){
                
                String nome =  conteudoTela.nomePet;
                
                pets.add(nome);
                
                numero++;

            }
            
                animal = new JComboBox(pets.toArray());
                animal.setSelectedIndex(0);
                c.gridx = 0;
                c.gridy = 1;
                animal.addActionListener(this);
                container.add(animal, c);   
     
                numero++; 
           
            btCancel = new JButton("Cancel");
            c.gridx = 0;
            c.gridy = 0 + numero;
            btCancel.addActionListener(this);
            container.add(btCancel, c);
            
            
        }
        
        setSize(460, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource().equals(btCancel)){
         fecha();
         ctrlPet.menuPrincipal();
     
        }else if(e.getSource().equals(btOk)){
              ctrlPet.petAdotado(1,1);
        }    
    
    }
   
public void fecha(){
        setVisible(false);
   }
}