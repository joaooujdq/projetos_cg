package trabalho2_cg;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class DesenhaBresenhamCirc extends JFrame {
	String cor;
	private int desloc;

	public DesenhaBresenhamCirc(String title, String cor) {
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
		algBres(g, 100);

	}

	public void algBres(Graphics g, int raio) {
		int x = 0, y = raio, u = 1, v = 2 * raio - 1, e = 0;

		while (x <= y) {
			simetria(g, x, y);
			x++;
			e = e + u;
			u = u + 2;
			if (v < (2 * e)) {

				y--;
				e = e - v;
				v = v - 2;
			}
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
