package alglinhatodos;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Desenha extends JFrame{

	public Desenha() {
		this.setTitle("Algoritmo de Geração de Linhas  - Todos os algoritmos");
		this.setSize(300,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.blue);
		algAnalitic(g, 10, 40, 60, 90);
		algAnalitic(g, 10, 40, 50, 100);
		algAnalitic(g, 10, 40, 80, 40);
		algAnalitic(g, 10, 40, 10, 90);
		g.setColor(Color.red);
		algDDA(g, 10, 40, 60, 90);
		algDDA(g, 10, 40, 50, 100);
		algDDA(g, 10, 40, 80, 40);
		algDDA(g, 10, 40, 10, 90);
		g.setColor(Color.green);
		algBres(g, 10, 40, 60, 90);
		algBres(g, 10, 40, 50, 100);
		algBres(g, 10, 40, 80, 40);
		algBres(g, 10, 40, 10, 90);
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
	
	private void algDDA(Graphics g, int xi, int yi, int xf, int yf) {
		int steps;
		float x=xi, y=yi, incX, incY;
		
		int dx = xf - xi;
		int dy = yf - yi;
		
		if(Math.abs(dx)>Math.abs(dy)) {
			 steps = Math.abs(dx); 
			 incX = 1; 
			 incY=(float)dy/dx;
			 }else {
				 steps = Math.abs(dy); 
				 incY = 1; 
				 incX=(float)dx/dy; 
			 }
		
		
		for(int i=0; i< steps; i++) {
			x = x + incX;
			y = y+ incY;
			putPixel(g,Math.round(x),Math.round(y));
			}
	}
	
	private void algBres(Graphics g, int xi, int yi, int xf, int yf) {
		int x = xi, y = yi, d=0,dx = xf- xi, dy = yf-yi, c, m, incX=1,incY=1;
		
		if(dx < 0) {
			incX = -1;
			dx= -dx;
		}
		
		if(dy < 0) {
			incY = -1;
			dy = -dy;
		}
		
		if(dy <= dx) {
			c = 2 * dx;
			m = 2 * dy;
			if(incX < 0) dx++;
			for(;;) {
				putPixel(g,x,y);
				if(x == xf) break;
				x += incX;
				d += m;
				if(d >= dx) {
					y += incY;
					d -=c;
				}
				
			}
		}else {
			c = 2 * dy;
			m = 2 * dx;
			if(incY < 0) dy++;
			for(;;) {
				putPixel(g,x,y);
				if(y == yf) break;
				y += incY;
				d += m;
				if(d >= dy) {
					x += incX;
					d -=c;
				}
			}
		}
	}
		
	
	public void putPixel(Graphics g, int x, int y) {
		g.drawLine(x, y, x , y);
	}
}
