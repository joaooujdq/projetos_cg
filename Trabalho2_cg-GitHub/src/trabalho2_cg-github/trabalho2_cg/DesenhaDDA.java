package trabalho2_cg;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class DesenhaDDA extends JFrame {
	String cor;

	public DesenhaDDA(String title, String cor) {
		this.cor = cor;
		this.setTitle(title);
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
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

		// algDDA(g, 10, 40, 60, 90);
		// algDDA(g, 10, 40, 50, 100);
		algDDA(g, 10, 40, 80, 40);
		algDDA(g, 10, 40, 10, 90);
	}

	private void algDDA(Graphics g, int xi, int yi, int xf, int yf) {
		int steps;
		float x = xi, y = yi, incX, incY;

		int dx = xf - xi;
		int dy = yf - yi;

		if (Math.abs(dx) > Math.abs(dy)) {
			steps = Math.abs(dx);
			incX = 1;
			incY = (float) dy / dx;
		} else {
			steps = Math.abs(dy);
			incY = 1;
			incX = (float) dx / dy;
		}

		for (int i = 0; i < steps; i++) {
			x = x + incX;
			y = y + incY;
			putPixel(g, Math.round(x), Math.round(y));
		}
	}

	public void putPixel(Graphics g, int x, int y) {
		g.drawLine(x, y, x, y);
	}

}
