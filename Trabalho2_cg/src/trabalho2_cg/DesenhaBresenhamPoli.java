package trabalho2_cg;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class DesenhaBresenhamPoli extends JFrame{
	String cor;

	public DesenhaBresenhamPoli(String title, String cor) {
		this.cor = cor;
		this.setTitle(title);
		this.setSize(300,300);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
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
		algBres(g, 10, 40, 60, 90);
		algBres(g, 10, 40, 50, 100);
		algBres(g, 10, 40, 80, 40);
		algBres(g, 10, 40, 10, 90);
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
			if(incX<0) dx++;
			for(;;) {
				putPixel(g,x,y);
				if(x == xf)break;
				x += incX;
				d =+ m;
				if(d >= dx) {
					y =+ incY;
					d -=c;
				}
				
			}
		}else {
			c = 2 * dy;
			m = 2 * dx;
			if(incY<0) dy++;
			for(;;) {
				putPixel(g,x,y);
				if(y == yf)break;
				y += incY;
				d =+ m;
				if(d >=dy) {
					x =+ incX;
					d -=c;
				}
			}
		}
	}

	public void putPixel(Graphics g, int x, int y) {
		g.drawLine(x, y, x , y);
	}
}
