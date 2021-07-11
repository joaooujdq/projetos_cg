package algpreebf;

import javax.swing.JFrame;

public class Janela extends JFrame{
	public Janela() {

		this.add(new Desenha());
        this.setTitle("Algoritmo de Preenchimento de Areas - Boundary-Fill");
        this.setSize(300,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}
}
