package TelaUsuario;

import Controlador.ControladorUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Entidade.Usuario;
import Entidade.Animal;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class TelaHistorico extends JFrame implements ActionListener {

    JLabel label;
    JTable table;
    JButton button;

    public void historico(String nome, ArrayList<Animal> adocao, ArrayList<Animal> doacao) {
        Container container = getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

//    -------------------------------------------------------------------------------------------            
        
//        Imprimir: " HISTORICO " + nome 
//       
//        Imprimir: "ANIMAIS ADOTADOS" 
           
        if (adocao.isEmpty()) {
//                
//            Imprimir: "Você não adotou nenhum animal ainda";

        } else {
            for (Animal pet : adocao) {
//                
//               Aqui entra a primeira tabela
//                
//            Colunas: NOME | IDADE | SEXO | ESPECIE         
//            
//              Dados:
//                  Imprimir: pet.getNome());
//                  Imprimir: pet.getIdade());
//                  Imprimir: pet.getNomeSexo(pet.getSexo()));
//                  Imprimir: pet.getEspecie());
            }
        }

//        Imprimir: "ANIMAIS DOADOS" 
        
        if (doacao.isEmpty()) {

//             Imprimir: "Você não doou nenhum animal ainda";


        } else {
            for (Animal pet : doacao) {
//                
//                Aqui entra a segunda tabela
//                
//              Colunas: NOME | IDADE | SEXO | ESPECIE         
//            
//              Dados:
//                  Imprimir: pet.getNome());
//                  Imprimir: pet.getIdade());
//                  Imprimir: pet.getNomeSexo(pet.getSexo()));
//                  Imprimir: pet.getEspecie());
            }
        }

        button = new JButton("Sair");
        button.addActionListener(this);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        // button.setLocation(0, 1);
        add(button);

        setTitle("Historico " + nome);
        setSize(490, 250);
        setLocationRelativeTo(null); // Aparece a jframe no meio da tela
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//    -------------------------------------------------------------------------------------------    
        JTable tableSuper;

        String[] columnData = {"SUPER", "SUPER", "SUPER"};

        String[][] data
                = {
                    {"Arthur", "DOG", "SUPER"},
                    {"Dayse", "2222", "SUPER"},
                    {"John", "2222", "C:/Usls"},
                    {"Peter", "2222", "C:/Usels"},
                    {"Raquel", "2222", "C:/Usls"},
                    {"Rose", "2222", "C:/Uss"},
                    {"Chet", "2222", "C:/Usexls"},
                    {"John", "2222", "C:/Uss"},};

        tableSuper = new JTable(data, columnData) {

            public boolean isCellEditable(int data, int column) {

                return false;
            }

            public Component prepareRenderer(TableCellRenderer var, int linha, int coluna) {
                // o metodo alterna as linhas do JTable entre brancas e escuras

                Component alteraCorLinha = super.prepareRenderer(var, linha, coluna);

                if (linha % 2 == 0) {
                    alteraCorLinha.setBackground(Color.WHITE);
                } else {
                    alteraCorLinha.setBackground(Color.LIGHT_GRAY);
                }
                if (isCellSelected(linha, coluna)) {
                    alteraCorLinha.setBackground(Color.YELLOW);
                }

                return alteraCorLinha;
            }
        };
        tableSuper.setPreferredScrollableViewportSize(new Dimension(450, 63));
        tableSuper.setFillsViewportHeight(true); // same function setVisible

        JScrollPane scrollpane = new JScrollPane(tableSuper);
        add(scrollpane);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(button)) {
            fechar();
            ControladorUsuario.getInstance().telaPrincipal();

        }

    }

    public void fechar() {
        setVisible(false);
    }

}
