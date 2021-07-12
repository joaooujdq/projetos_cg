package trabalho2_cg;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class DesenhaAnalitico extends JFrame {
	String cor;
	public DesenhaAnalitico(String title, String cor){

		this.setTitle(title);
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.cor = cor;
		
	}
	
	@Override
	public void paint(Graphics g) {
		switch(cor) {
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
		
		algAnalitic(g, 10, 50, 60, 100);
		algAnalitic(g, 10, 50, 60, 50);
		algAnalitic(g, 20, 50, 20, 100);
	}
	
	
	public void algAnalitic(Graphics g, int xi, int yi, int xf, int yf) {
		float m, b, dy, dx;
		dy = yf - yi;
		dx = xf - xi;
		
		m = (float) dy/dx;
		
		b= (float) (yi - m*xi);
		
		for(int x = xi; x <= xf; x++ ) {
			int y = (int)(m*x+b);
			putPixel(g,x,y);
		}
	}
	
	public void putPixel(Graphics g, int x, int y) {
		g.drawLine(x, y, x , y);
	}
}
