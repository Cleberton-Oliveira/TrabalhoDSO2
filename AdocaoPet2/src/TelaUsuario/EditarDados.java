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

public class EditarDados extends JFrame implements ActionListener{

    
    private ControladorUsuario ctrlUsuario;
    private JLabel texto;
    private JButton btSair;
    private JButton btEditaNome;
    private JButton btEditaSenha;
    private JButton btNome;
    private JButton btSenha;
    private JTextField nome;
    private JPasswordField senha;
    
    
    public EditarDados(ControladorUsuario ctrlUsuario) {
        this.ctrlUsuario = ctrlUsuario; 
        tela();
    } 
    public void tela(){
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());    
        GridBagConstraints c = new GridBagConstraints();
        
            
        texto = new JLabel("Oque deseja editar:");
        c.gridx =0;
        c.gridy =0;
        container.add(texto, c);  
         
        
        btNome = new JButton("Nome");
        c.gridx =0;
        c.gridy =1;
        btNome.addActionListener(this); 
        container.add(btNome, c);
        
        
        btSenha = new JButton("Senha");
        c.gridx =0;
        c.gridy =2;
        btSenha.addActionListener(this); 
        container.add(btSenha, c);  
        
   
        setSize(700, 370);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public void editaNome(){
        Container container = getContentPane();
        container.setLayout(new GridBagLayout()); 
        GridBagConstraints c = new GridBagConstraints();
        
        nome = new JTextField("Digite o novo nome");
        c.gridx =0;
        c.gridy =3;
        container.add(nome, c); 
     
        btSair = new JButton("Sair");
        c.gridx = 0;
        c.gridy = 4;
        btSair.addActionListener(this); 
        container.add(btSair, c);
        
        btEditaNome = new JButton("Salvar");
        c.gridx = 1;
        c.gridy = 4;
        btEditaNome.addActionListener(this);
        container.add(btEditaNome, c);
        
        
        setSize(460, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
          
    }
     public void editaSenha(){
        Container container = getContentPane();
        container.setLayout(new GridBagLayout()); 
        GridBagConstraints c = new GridBagConstraints();
     
        
        senha = new JPasswordField("Digite a nova senha");
        c.gridx =0;
        c.gridy =3;
        container.add(senha, c); 

      
        btSair = new JButton("Sair");
        c.gridx = 0;
        c.gridy = 4;
        btSair.addActionListener(this); 
        container.add(btSair, c);
        
        btEditaSenha = new JButton("Salvar");
        c.gridx = 1;
        c.gridy = 4;
        btEditaSenha.addActionListener(this);
        container.add(btEditaSenha, c);
        
        

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

//        conteudoTela.nomeUsuario = nome.getText();

//        conteudoTela.senhaUsuario = senha.getText();
        
        if(e.getSource().equals(btNome)){
            fecha();
            editaNome();
        }else if(e.getSource().equals(btSenha)){
            editaSenha();
        }else if(e.getSource().equals(btSair)){
            fecha();
            ctrlUsuario.telaPrincipal();
        }else if(e.getSource().equals(btEditaSenha)){
            fecha();
            JOptionPane.showMessageDialog(null,"Senha editada com sucesso");
            ctrlUsuario.mudarSenha(senha.getText());
        }else if(e.getSource().equals(btEditaNome)){
            fecha();
            JOptionPane.showMessageDialog(null,"Nome editada com sucesso");
            ctrlUsuario.mudarSenha(nome.getText());
        }
    }
   
    
}

   
