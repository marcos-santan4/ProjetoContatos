package pmain;

import javax.swing.JFrame;

import dao.Frame;

public class ProgramaPrincipal {
	public static void main(String[] args) {
			Frame contatoFrame = new Frame();
			
			contatoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			contatoFrame.setSize(500, 250);
			contatoFrame.setVisible(true);
	}
}