package algdda;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Desenha extends JFrame {

		public Desenha() {
			
			this.setTitle("Algoritmo Anal�tico  - Gera��o de Retas");
			this.setSize(300,300);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		}
		
		@Override
		public void paint(Graphics g) {
			g.setColor(Color.blue);
			//algDDA(g, 10, 40, 60, 90);
			//algDDA(g, 10, 40, 50, 100);
			algDDA(g, 10, 40, 80, 40);
			algDDA(g, 10, 40, 10, 90);
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
				 
			
			

		public void putPixel(Graphics g, int x, int y) {
			g.drawLine(x, y, x , y);
		}
}
