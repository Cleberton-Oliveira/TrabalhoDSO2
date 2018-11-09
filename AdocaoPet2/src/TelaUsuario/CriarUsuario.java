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

public class CriarUsuario extends JFrame implements ActionListener{

    
    private ControladorUsuario ctrlUsuario;
    private JLabel texto;
    private JButton btSair;
    private JButton btEnviar;
    private JTextField nome;
    private JTextField cpf;
    private JPasswordField senha;
    
    
    public CriarUsuario(ControladorUsuario ctrlUsuario) {
        this.ctrlUsuario = ctrlUsuario; 
        tela();
    } 
    public void tela(){
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());    
        GridBagConstraints c = new GridBagConstraints();
        
            
        texto = new JLabel("Login");
        c.gridx =0;
        c.gridy =0;
        container.add(texto, c);  
         
        
        texto = new JLabel("Nome: ");
        c.gridx =0;
        c.gridy =1;
        container.add(texto, c);
        
        
        texto = new JLabel("CPF: ");
        c.gridx =0;
        c.gridy =2;
        container.add(texto, c);  
        
        texto = new JLabel("Senha: ");
        c.gridx =0;
        c.gridy =3;
        container.add(texto, c);  
        
        
        nome = new JTextField("Digite seu nome");
        c.gridx =1;
        c.gridy =1;
        container.add(nome, c); 

        
        cpf = new JTextField("Digite seu cpf");
        c.gridx =1;
        c.gridy =2;
        container.add(cpf, c); 

           
        senha = new JPasswordField("Digite sua senha");
        c.gridx =1;
        c.gridy =3;
        container.add(senha, c); 

      
        btSair = new JButton("Sair");
        c.gridx = 0;
        c.gridy = 4;
        btSair.addActionListener(this); 
        container.add(btSair, c);
        
        btEnviar = new JButton("Enviar");
        c.gridx = 1;
        c.gridy = 4;
        btEnviar.addActionListener(this);
        container.add(btEnviar, c);
          
        setSize(700, 370);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public void exibe() {
        setVisible(true);
    }
    
    public void fecha() {
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ConteudoTelaUsuario conteudoTela = new ConteudoTelaUsuario();
        conteudoTela.nomeUsuario = nome.getText();
        conteudoTela.cpfUsuario = cpf.getText();
        conteudoTela.senhaUsuario = senha.getText();
        
        if(e.getSource().equals(btEnviar)){
            fecha();
            ctrlUsuario.incluiUsuario(conteudoTela);
        }else if(e.getSource().equals(btSair)){
            fecha();
            ctrlUsuario.iniciar();
        }
    }
    
    public void erro(){
        JOptionPane.showMessageDialog(null,"ERRO AO CRIAR CONTA\n CPF já cadastrado ou quantidade de caracteres invalida");
        exibe();
    }
    
}

   
