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

    private JLabel lbTexto;
    private JButton btOk;
    private JButton btCancel; 
    private JComboBox animal; 
    private int valorPet;
    private ArrayList<String>  id;
    

    public void listagem(int pet, ArrayList<ConteudoTelaPet> listagemPets){
        Container container = getContentPane();
        container.setLayout(new GridBagLayout()); 
        GridBagConstraints c = new GridBagConstraints();
        this.id =  new ArrayList<>();
        valorPet = pet;
        
        lbTexto = new JLabel("Listagem de animais para adoção:" );
        c.gridx = 0;
        c.gridy = 0;
        container.add(lbTexto, c);
     
        
        if(listagemPets.isEmpty()){
             lbTexto = new JLabel("Não temos nenhum animal com essas caracteristicas no momento" );
             c.gridx = 0;
             c.gridy = 1;
             container.add(lbTexto, c);
             
            btCancel = new JButton("Cancel");
            c.gridx = 0;
            c.gridy = 2;
            btCancel.addActionListener(this);
            container.add(btCancel, c);
             
             
        }else{
            ArrayList<String> pets = new ArrayList<>();
           
            for (ConteudoTelaPet conteudoTela : listagemPets){
                
                String petParaAdocao =  "NOME:  " + conteudoTela.nomePet + " || IDADE: " + conteudoTela.idadePet  +" || CODIGO: " + conteudoTela.identificador;
                id.add(conteudoTela.identificador);
          
               pets.add(petParaAdocao);
            }
            
                    
            animal = new JComboBox(pets.toArray());
            animal.setSelectedIndex(0);
            c.gridx = 0;
            c.gridy = 1;
            c.ipady = 15;
           
            
            animal.addActionListener(this);
            container.add(animal, c);   
             
             
            btOk = new JButton("Adotar");
            c.gridx = 1;
            c.gridy = 1;
            btOk.addActionListener(this);
            container.add(btOk, c);    
                
            btCancel = new JButton("Não adotar nenhum");
            c.gridx = 0;
            c.gridy = 2;
            c.ipady = 10;
            btCancel.addActionListener(this);
            container.add(btCancel, c);
            
            
        }
        
        setSize(490, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource().equals(btCancel)){
         fecha();
         JOptionPane.showMessageDialog(null,"NENHUM PET ADOTADO");
         ControladorPet.getInstance().menuPrincipal();
     
        }else if(e.getSource().equals(btOk)){
            fecha();
            ControladorPet.getInstance().petAdotado(id.get(animal.getSelectedIndex()), valorPet);
        }    
    
    }
   
public void fecha(){
        setVisible(false);
   }

    public void exibeSucessoAdocao(String pet) {
       JOptionPane.showMessageDialog(null,"PARABÉNS\n Pet " + pet + " adotado com sucesso.");
       ControladorPet.getInstance().menuPrincipal();
    }

    public void exibeMaximoEspecie() {
       JOptionPane.showMessageDialog(null,"ERRO\n Você já adotou o numero maximo para essa especie");
       ControladorPet.getInstance().menuPrincipal();
    }

    public void exibeMaximoAdocao() {
       JOptionPane.showMessageDialog(null,"ERRO\n Você já adotou o numero maximo que o sistema permite");
       ControladorPet.getInstance().menuPrincipal();
    }
}