package pmain;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.*;

public class ContatoMenu extends JMenuBar {
    private JMenu menuContato;
    private JMenu menuAjuda;

    private JMenuItem menuItemNovo;
    private JMenuItem menuItemSalvar;
    private JMenuItem menuItemFechar;    
    private JMenuItem menuItemSobre;

    public ContatoMenu() {
        menuContato = new JMenu("Contato");
        menuAjuda = new JMenu("Ajuda");
    
        menuItemNovo = new JMenuItem("Novo");
        menuItemSalvar = new JMenuItem("Salvar");
        menuItemFechar = new JMenuItem("Fechar");
        menuItemSobre = new JMenuItem("Sobre");
    }
    
    public void adicionarItens(ActionListener n, ActionListener s, ActionListener f) {
        menuItemNovo.addActionListener(n);
        menuContato.add(menuItemNovo);
    
        menuItemSalvar.addActionListener(s);
        menuContato.add(menuItemSalvar);
    
        menuItemFechar.addActionListener(f);
        menuContato.add(menuItemFechar);
    
        menuAjuda.add(menuItemSobre);
    
        add(menuContato);
        add(menuAjuda);
    } 
}

  