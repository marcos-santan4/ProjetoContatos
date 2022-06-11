package dao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame extends JFrame {
    
    JTextField nomeField;
    JTextField emailField;
    JTextField telefoneField;
    
    public  Frame() {
        super ("Agenda Telefônica");
        
        criarMenu();
        criarFormulario();
    }

    public void criarFormulario(){
        setLayout(new BorderLayout());
        
        Contato cont = new Contato();
        
        SalvarAction salvarAction = new SalvarAction();
        FecharAction fecharAction = new FecharAction();
        
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());
        
        JLabel titulo = new JLabel("Cadastro de Contato");
        titulo.setFont(new Font("Verdana", Font.PLAIN, 16));
        
        panelTitulo.add(titulo);
        
        JPanel panelCadastro = new JPanel();
        panelCadastro.setLayout(new FlowLayout());
        
        JLabel nomeLabel = new JLabel("Nome: ");
        nomeField = new JTextField(40);
        
        JLabel emailLabel = new JLabel("E-mail: ");
        emailField = new JTextField(40);
        
        JLabel telefoneLabel = new JLabel("Telefone: ");
        telefoneField = new JTextField(10);
        
        panelCadastro.add(nomeLabel);
        panelCadastro.add(nomeField);
        panelCadastro.add(emailLabel);
        panelCadastro.add(emailField);
        panelCadastro.add(telefoneLabel);
        panelCadastro.add(telefoneField);
        
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new FlowLayout());
        
        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(salvarAction);
        JButton botaoFechar = new JButton("Fechar");
        botaoFechar.addActionListener(fecharAction);
        
        panelBotoes.add(botaoSalvar);
        panelBotoes.add(botaoFechar);
        
        add(panelTitulo, BorderLayout.NORTH);
        add(panelCadastro, BorderLayout.CENTER);
        add(panelBotoes, BorderLayout.SOUTH);   
    }

    public void criarMenu(){
        
        NovoAction novoAction = new NovoAction();
        SalvarAction salvarAction = new SalvarAction();
        FecharAction fecharAction = new FecharAction();
        SobreAction sobreAction = new SobreAction();
        
        JMenu menuContato = new JMenu("Contato");
        
        JMenuItem menuItemNovo = new JMenuItem("Novo");
        menuItemNovo.addActionListener(novoAction);
        menuContato.add(menuItemNovo);
        
        JMenuItem menuItemSalvar = new JMenuItem("Salvar");
        menuItemSalvar.addActionListener(salvarAction);
        menuContato.add(menuItemSalvar);
        
        JMenuItem menuItemFechar = new JMenuItem("Fechar");
        menuItemFechar.addActionListener(fecharAction);
        menuContato.add(menuItemFechar);
        
        JMenu menuAjuda = new JMenu("Ajuda");
        
        JMenuItem menuSobre = new JMenuItem("Sobre");
        menuSobre.addActionListener(sobreAction);
        menuAjuda.add(menuSobre);
        
        JMenuBar barra = new JMenuBar();
        setJMenuBar(barra);
        barra.add(menuContato);
        barra.add(menuAjuda); 
    }

    private class NovoAction implements ActionListener{

        public void actionPerformed(ActionEvent event){
            nomeField.setText("");
            telefoneField.setText("");
            emailField.setText("");    
        }     
    }

    private class FecharAction implements ActionListener{
        public void actionPerformed(ActionEvent event){
            System.exit(0);
        }    
    }

    private class SalvarAction implements ActionListener{        
        Contato cont = new Contato();

        public void actionPerformed(ActionEvent event) {

            cont.setNome(nomeField.getText());
            cont.setEmail(emailField.getText());
            cont.setCelular(telefoneField.getText());
            JOptionPane.showMessageDialog(null, cont.imprime(), "Contato", JOptionPane.INFORMATION_MESSAGE);

            ContatoDAO contato = new ContatoDAO();

            try {
                contato.adiciona(cont);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static class SobreAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Atividade Realizada por Marcos Santana" +
            "\nAtividade de POO - DAO" + "\nObrigado!", "Sobre", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}