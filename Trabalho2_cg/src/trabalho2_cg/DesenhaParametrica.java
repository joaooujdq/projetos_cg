package trabalho2_cg;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class DesenhaParametrica extends JFrame{
	private int desloc;
	String cor;
	public DesenhaParametrica(String title, String cor) {
		this.cor = cor;
	this.setTitle(title);
	this.setSize(300,300);
	this.setLocationRelativeTo(null);
	this.setVisible(true);
		desloc = 150;
	}
	@Override
	public void paint (Graphics g) {
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
		algParam(g,100);
		
	}
	
	public void algParam(Graphics g, int raio) {
        int x, y;
        for (int ang=0; ang<360; ang++) {
            x = (int) (raio * Math.cos(Math.PI*ang/180));
            y = (int) (raio * Math.sin(Math.PI*ang/180));
            putPixel(g,x,y);
        }
    }
	
	 private void putPixel(Graphics g, int x, int y) {
	        g.drawLine(x+desloc, y+desloc, x+desloc, y+desloc);
	    }
}
