package trabalho3_cg;

import javax.swing.JFrame;

public class Janela extends JFrame{
	public Janela() {

		this.add(new Desenha());
        this.setTitle("Algoritmo de Preenchimento de Areas - An�lise Geom�trica");
        this.setSize(300,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}
}