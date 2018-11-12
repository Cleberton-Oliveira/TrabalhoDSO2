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
import java.util.Scanner;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
    private JLabel texto;
    private JButton btSair;
    private JButton btEntrar;
    private JTextField cpf;
    private JPasswordField senha;
    
    
    public Login() {
        tela();
    } 
    public void tela(){
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());    
        GridBagConstraints c = new GridBagConstraints();
        
                
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;      
        
        texto = new JLabel("       -- LOGIN --");
        c.gridx =0;
        c.gridy =0;
        c.gridwidth = 2;
        container.add(texto, c);  
                
        texto = new JLabel("CPF: ");
        c.gridx =0;
        c.gridy =1;
        c.gridwidth = 1;
        container.add(texto, c);  
        
        texto = new JLabel("Senha: ");
        c.gridx =0;
        c.gridy =2;
        container.add(texto, c);  
                
        cpf = new JTextField();
        c.gridx =1;
        c.gridy =1;
        container.add(cpf, c); 
                   
        senha = new JPasswordField();
        c.gridx =1;
        c.gridy =2;
        container.add(senha, c);
        
        btSair = new JButton("Sair");
        c.gridx = 0;
        c.gridy = 3;
        btSair.addActionListener(this); 
        container.add(btSair, c);
        
        btEntrar = new JButton("Entrar");
        c.gridx = 1;
        c.gridy = 3;
        btEntrar.addActionListener(this);
        container.add(btEntrar, c);
          
        setSize(460, 290);
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
        String login = cpf.getText() +  senha.getText();          
        if(e.getSource().equals(btEntrar)){
            fecha();
            ControladorUsuario.getInstance().logar(login);
        }else if(e.getSource().equals(btSair)){
            fecha();
            ControladorUsuario.getInstance().iniciar();
        }
    }

    public void erroLogin(){   
        JOptionPane.showMessageDialog(null,"ERRO AO TENTAR LOGAR\n CPF ou Senha incorreta");
        exibe();
    }

    public void contaCriadaComSucesso() {
       JOptionPane.showMessageDialog(null,"CONTA CRIADA COM SUCESSO\n Agora já pode fazer login");
       exibe();
    }
    
}

   
