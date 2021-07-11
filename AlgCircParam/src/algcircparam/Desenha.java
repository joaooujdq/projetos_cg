package algcircparam;

import java.awt.Graphics;

import javax.swing.JComponent;

public class Desenha extends JComponent {
		
		private int desloc;
		public Desenha() {
			desloc = 150;
		}
		
		@Override
		public void paint (Graphics g) {
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
