package trabalho2_cg;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;


public class DesenhaAnalGeo extends JFrame{
	String cor;
	private Lados lados[];
    private Vx vx[];
    
    int px1=50, px2=250, px3=210, px4=200,
         py1=50, py2=50, py3=200, py4=200;  
    
	public DesenhaAnalGeo(String title, String cor) {
		this.cor = cor;
		this.setTitle(title);
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		lados = new Lados[4];
        vx = new Vx[312];
        for(int i=0;i<312;i++) vx[i] = new Vx();
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
		
        algBres(g,px1,py1,px2,py2);
        algBres(g,px2,py2,px3,py3);
        algBres(g,px3,py3,px4,py4);
        algBres(g,px4,py4,px1,py1);
        
        
        criaLados();
        g.setColor(Color.blue);
        preAGeo(g);
        
    }
        
    public void algBres(Graphics g, int xi, int yi, int xf, int yf) {
        int t, dist;
        int xerr=0, yerr=0, dx, dy;
        int incX, incY;
        
        dx = xf - xi ;
        dy = yf - yi; 
        
        if (dx > 0) incX = 1;
        else if(dx==0) incX = 0;
        else incX = -1;
        
         if (dy > 0) incY = 1;
         else if(dy==0) incY = 0;
        else incY = -1;
         
         dx = Math.abs(dx);
         dy = Math.abs(dy);
         
         if (dx > dy) dist = dx;
         else dist = dy;
         
         for (int k=0; k<=dist; k++) {
             putPixel(g,xi,yi);
             xerr = xerr + dx;
             yerr = yerr + dy;
             
             if(xerr>dist) {xerr = xerr - dist; xi = xi + incX;}
             if(yerr>dist) {yerr = yerr - dist; yi = yi + incY;}
         }
        
    }
    
    public void putPixel(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
    }

    private void criaLados() {
        
   
        lados[0] = new Lados(1,49,50,50,200);
        lados[1] = new Lados(2,50,200,250,-0.2666);
        lados[2] = new Lados(3,200,210,210,-1);
        lados[3] = new Lados(4,49,200,50,0.9375);
    }

    private void preAGeo(Graphics g) {
      
        int x;
        for(int i=0;i<4;i++) {
            for(int yvar=lados[i].ymin; yvar<=lados[i].ymax; yvar++) {
               x = (int) (lados[i].um_s_m * (yvar - lados[i].ymin) + lados[i].xymin);
               if(vx[yvar].x1== -1) vx[yvar].x1 = x;
               else vx[yvar].x2= x;
            }
         }
        ordernaVx();
        imprimeVx(g);
        
    }

    private void ordernaVx() {
        for (int y=0; y<312; y++)
        {
            int aux =vx[y].x1;
            if(vx[y].x1 > vx[y].x2) {
                vx[y].x1 =vx[y].x2;
                vx[y].x2 = aux;
            }
        }
        
    }

    private void imprimeVx(Graphics g) {
        for (int y=0; y<312; y++) {
            if(vx[y].x1 != -1) {
                  algBres(g,vx[y].x1,y,vx[y].x2,y);
            }
        }
        
    }

    public class Lados {
        
        int lado;
        int ymin;
        int ymax;
        int xymin;
        double um_s_m;

        public Lados() {
            this(0,0,0,0,0.0);
        }

        public Lados(int lado, int ymin, int ymax, int xymin, double um_s_m) {
            this.lado = lado;
            this.ymin = ymin;
            this.ymax = ymax;
            this.xymin = xymin;
            this.um_s_m = um_s_m;
        }
        
        
    }

    public class Vx {
        
        int x1;
        int x2;

        public Vx() {
            this.x1 = -1;
            this.x2 = -1;
        }
    }
    

}
