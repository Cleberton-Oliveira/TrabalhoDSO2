package TelaUsuario;

import Controlador.ControladorUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Entidade.Usuario;
import Entidade.Animal;
import Entidade.ConteudoTelaHistorico;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class TelaHistorico extends JFrame implements ActionListener {

    JLabel label;
    JTable table;
    JButton button;

    public void historico(ConteudoTelaHistorico conteudoTela) {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


         label = new JLabel("| ANIMAIS ADOTADOS |");
        c.gridx = 0;
        c.gridy = 1;
        container.add(label, c);

        if (conteudoTela.adocao.isEmpty()) {

            label = new JLabel("Você ainda não adotou nenhum ");
            c.gridx = 0;
            c.gridy = 2;
            container.add(label, c);

        } else {
            DefaultTableModel conteudoAdocao = new DefaultTableModel();
            conteudoAdocao.addColumn("NOME");
            conteudoAdocao.addColumn("IDADE");
            conteudoAdocao.addColumn("SEXO");
            conteudoAdocao.addColumn("ESPECIE");

            for (Animal pet : conteudoTela.adocao) {
                conteudoAdocao.addRow(new Object[]{pet.getNome(), pet.getIdade(), pet.getNomeSexo(pet.getSexo()), pet.getEspecie()});
            }

            JTable tableAdocao = new JTable() {
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
            tableAdocao.setPreferredScrollableViewportSize(new Dimension(400, 50));
            tableAdocao.setFillsViewportHeight(true);

            c.gridx = 0;
            c.gridy = 2;
            JScrollPane scrollpane = new JScrollPane(tableAdocao);
            container.add(scrollpane, c);

            tableAdocao.setModel(conteudoAdocao);
            this.repaint();

        }

        label = new JLabel("| ANIMAIS DOADOS |");
        c.gridx = 0;
        c.gridy = 3;
        container.add(label, c);

        if (conteudoTela.doacao.isEmpty()) {

            label = new JLabel("Você ainda não doou nenhum ");
            c.gridx = 0;
            c.gridy = 4;
            container.add(label, c);

        } else {
            DefaultTableModel conteudoDoacao = new DefaultTableModel();
            conteudoDoacao.addColumn("NOME");
            conteudoDoacao.addColumn("IDADE");
            conteudoDoacao.addColumn("SEXO");
            conteudoDoacao.addColumn("ESPECIE");

            for (Animal pet : conteudoTela.doacao) {
                conteudoDoacao.addRow(new Object[]{pet.getNome(), pet.getIdade(), pet.getNomeSexo(pet.getSexo()), pet.getEspecie()});
            }

            JTable tableDoacao = new JTable() {
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
            tableDoacao.setPreferredScrollableViewportSize(new Dimension(400, 50));
            tableDoacao.setFillsViewportHeight(true);

            c.gridx = 0;
            c.gridy = 4;
            JScrollPane scrollpane = new JScrollPane(tableDoacao);
            container.add(scrollpane, c);

            tableDoacao.setModel(conteudoDoacao);
            this.repaint();
        }

        button = new JButton("Sair");
        c.gridx = 0;
        c.gridy = 5;
        button.addActionListener(this);
        add(button, c);

        setTitle("Historico " + conteudoTela.nome);
        setSize(460, 290);
        setLocationRelativeTo(null); // Aparece a jframe no meio da tela
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
