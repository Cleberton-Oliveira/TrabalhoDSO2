package br.ufsc.ine5605.TelaUsuario;

import br.ufsc.ine5605.Controlador.ControladorUsuario;
import br.ufsc.ine5605.Entidade.ConteudoTelaUsuario;
import java.awt.Container;
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
    private JLabel texto;
    private JButton btSair;
    private JButton btEnviar;
    private JTextField nome;
    private JTextField cpf;
    private JPasswordField senha;
    
    
    public CriarUsuario() {
 
        tela();
    } 
    public void tela(){
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());    
        GridBagConstraints c = new GridBagConstraints();
        
                
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
       
            
        texto = new JLabel("       --  Criar Conta  -- ");
        c.gridx =0;
        c.gridy =0;
        c.gridwidth = 2;
        container.add(texto, c);  
         
        
        texto = new JLabel("Nome: ");
        c.gridx =0;
        c.gridy =1;
        c.gridwidth = 1;
        container.add(texto, c);
        
        
        texto = new JLabel("CPF: ");
        c.gridx =0;
        c.gridy =2;
         c.gridwidth = 1;
        container.add(texto, c);  
        
        texto = new JLabel("Senha: ");
        c.gridx =0;
        c.gridy =3;
         c.gridwidth = 1;
        container.add(texto, c);  
        
        
        nome = new JTextField();
        c.gridx =1;
        c.gridy =1;
         c.gridwidth = 1;
        container.add(nome, c); 

        
        cpf = new JTextField();
        c.gridx =1;
        c.gridy =2;
         c.gridwidth = 1;
        container.add(cpf, c); 

           
        senha = new JPasswordField();
        c.gridx =1;
        c.gridy =3;
         c.gridwidth = 1;
        container.add(senha, c); 

      
        btSair = new JButton("Sair");
        c.gridx = 0;
        c.gridy = 4;
         c.gridwidth = 1;
        btSair.addActionListener(this); 
        container.add(btSair, c);
        
        btEnviar = new JButton("Enviar");
        c.gridx = 1;
        c.gridy = 4;
         c.gridwidth = 1;
        btEnviar.addActionListener(this);
        container.add(btEnviar, c);
          
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
        ConteudoTelaUsuario conteudoTela = new ConteudoTelaUsuario();
        conteudoTela.nomeUsuario = nome.getText();
        conteudoTela.cpfUsuario = cpf.getText();
        conteudoTela.senhaUsuario = senha.getText();
        
        if(e.getSource().equals(btEnviar)){
            fecha();
            ControladorUsuario.getInstance().incluiUsuario(conteudoTela);
        }else if(e.getSource().equals(btSair)){
            fecha();
            ControladorUsuario.getInstance().iniciar();
        }
    }
    
    public void erro(){
        JOptionPane.showMessageDialog(null,"ERRO AO CRIAR CONTA\n CPF já cadastrado ou quantidade de caracteres invalida");
        exibe();
    }
    
}

   
