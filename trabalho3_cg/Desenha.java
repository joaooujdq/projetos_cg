package trabalho3_cg;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

public class Desenha extends JComponent {

	private Lados lados[];
	private Vx vx[];

	int numpontos;
//	int px1 = 50, px2 = 250, px3 = 210, px4 = 200, py1 = 50, py2 = 50, py3 = 200, py4 = 200;

	public Desenha() {

		// lados = new Lados[4];
		vx = new Vx[312];
		for (int i = 0; i < 312; i++)
			vx[i] = new Vx();

	}

	@Override
	public void paint(Graphics g) {
		int pontoSorteado;
		Random gerador = new Random();
		int numlados = gerador.nextInt(6) + 3;
		System.out.println(numlados);
		lados = new Lados[numlados];
		int pontos[] = new int[numlados * 2];

		for (int i = 0; i < numlados * 2; i++) {
			pontoSorteado = gerador.nextInt(251);
			System.out.println(pontoSorteado);
			pontos[i] = pontoSorteado;
		}

		g.setColor(Color.red);

//        algBres(g,px1,py1,px2,py2); // i=0 
//        algBres(g,px2,py2,px3,py3); //i=1
//        algBres(g,px3,py3,px4,py4);//i=2
//        algBres(g,px4,py4,px1,py1);//i=3

		for (int i = 0; i < numlados; i++) {
			if (i == numlados - 1) {
				algBres(g, pontos[i * 2], pontos[i * 2] + 1, pontos[0], pontos[1]);
			} else {
				algBres(g, pontos[i * 2], pontos[i * 2] + 1, pontos[i * 2] + 2, pontos[i * 2] + 3);
			}

		}

//        lados[0] = new Lados(1,49,50,50,200);
//        lados[1] = new Lados(2,50,200,250,-0.2666);
//        lados[2] = new Lados(3,200,210,210,-1);
//        lados[3] = new Lados(4,49,200,50,0.9375);

		// algBres(g,px1 80,py1 0,px2 0,py2 10);
		// algBres(g,px2 0,py2 10,px3 40,py3 30); //i=1
		// algBres(g,px3 40,py3 30,px4 20,py4 50);//i=2
		// algBres(g,px4 20,py4 50,px1 80,py1 0);//i=3
		// py1 = menorY;
		// i=0 ymin = 0 | ymax = 10 | xymin = xmin - menor y | xymin = px1 - py1 | 80 =
		// 80 - 0 = 80
		// if(py2 < py1 ){
		// menorY = py2;
		// }
		// i=1 xymin = px2 - menorY(ainda é py1) = 0 - 0 = 0;
		// i=2 xymin = px3 - menorY(ainda é py1) = 40 - 0 = 40;

		int dx = 0;
		int dy = 0;
		double um_sob_m;
		int xymin;
		int menorY = pontos[1]; // py1

		for (int i = 0; i < numlados; i++) {

			dx = (pontos[i * 2] + 2) - (pontos[i * 2]);
			dy = (pontos[i * 2] + 3) - (pontos[i * 2] + 1);
			um_sob_m = dx / dy;

			xymin = pontos[i * 2] - menorY;

			if (xymin < 0) {
				xymin = xymin * -1;
			}

			if (pontos[i * 2] + 1 < menorY) {
				menorY = pontos[i * 2] + 1;
			}

//                   if(i == numlados -1) {	
//                		lados[i] = new Lados(i + 1, pontos[i*2], pontos[i*2] + 1, pontos[0], pontos[1]);
//                	}else {
//                		lados[i] = new Lados(i + 1, pontos[i*2] + 2, pontos[i*2] + 3, xymin, um_sob_m);
//        			}

			lados[i] = new Lados(i + 1, pontos[i * 2] + 1, pontos[i * 2] + 3, xymin, um_sob_m);

		}

		g.setColor(Color.blue);
		preAGeo(g);

	}

	public void algBres(Graphics g, int xi, int yi, int xf, int yf) {
		int dist;
		int xerr = 0, yerr = 0, dx, dy;
		int incX, incY;

		dx = xf - xi;
		dy = yf - yi;

		if (dx > 0)
			incX = 1;
		else if (dx == 0)
			incX = 0;
		else
			incX = -1;

		if (dy > 0)
			incY = 1;
		else if (dy == 0)
			incY = 0;
		else
			incY = -1;

		dx = Math.abs(dx);
		dy = Math.abs(dy);

		if (dx > dy)
			dist = dx;
		else
			dist = dy;

		for (int k = 0; k <= dist; k++) {
			putPixel(g, xi, yi);
			xerr = xerr + dx;
			yerr = yerr + dy;

			if (xerr > dist) {
				xerr = xerr - dist;
				xi = xi + incX;
			}
			if (yerr > dist) {
				yerr = yerr - dist;
				yi = yi + incY;
			}
		}

	}

	public void putPixel(Graphics g, int x, int y) {
		g.drawLine(x, y, x, y);
	}

	private void preAGeo(Graphics g) {
		int x;
		for (int i = 0; i < 4; i++) {
			for (int yvar = lados[i].ymin; yvar <= lados[i].ymax; yvar++) {
				x = (int) (lados[i].um_s_m * (yvar - lados[i].ymin) + lados[i].xymin);
				if (vx[yvar].x1 == -1)
					vx[yvar].x1 = x;
				else
					vx[yvar].x2 = x;
			}
		}
		ordernaVx();
		imprimeVx(g);

	}

	private void ordernaVx() {
		for (int y = 0; y < 312; y++) {
			int aux = vx[y].x1;
			if (vx[y].x1 > vx[y].x2) {
				vx[y].x1 = vx[y].x2;
				vx[y].x2 = aux;
			}
		}

	}

	private void imprimeVx(Graphics g) {
		for (int y = 0; y < 312; y++) {
			if (vx[y].x1 != -1) {
				algBres(g, vx[y].x1, y, vx[y].x2, y);
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
			this(0, 0, 0, 0, 0.0);
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