package trabalho2_cg;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class DesenhaIncSim extends JFrame {
	private int desloc;
	String cor;

	public DesenhaIncSim(String title, String cor) {
		this.cor = cor;
		this.setTitle(title);
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		desloc = 150;
	}

	@Override
	public void paint(Graphics g) {
		switch (cor) {
		case "green":
			g.setColor(Color.green);
			break;
		case "red":
			g.setColor(Color.red);
			break;
		case "blue":
			g.setColor(Color.blue);
			break;
		}
		algIncSem(g, 100);

	}

	public void algIncSem(Graphics g, int raio) {
		int x, y;
		double ang = 0.0;
		while (ang < Math.PI / 4) {
			x = (int) (raio * Math.cos(ang));
			y = (int) (raio * Math.sin(ang));
			simetria(g, x, y);
			ang = ang + (double) 1 / raio;
		}

	}

	private void simetria(Graphics g, int x, int y) {

		putPixel(g, x, y);
		putPixel(g, x, -y);
		putPixel(g, -x, y);
		putPixel(g, -x, -y);

		putPixel(g, y, x);
		putPixel(g, y, -x);
		putPixel(g, -y, x);
		putPixel(g, -y, -x);
	}

	private void putPixel(Graphics g, int x, int y) {
		g.drawLine(x + desloc, y + desloc, x + desloc, y + desloc);
	}
}
