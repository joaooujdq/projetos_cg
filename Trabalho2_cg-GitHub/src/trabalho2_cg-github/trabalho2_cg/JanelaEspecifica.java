package trabalho2_cg;

import java.awt.Graphics;

import javax.swing.JFrame;

public class JanelaEspecifica extends JFrame {

	public JanelaEspecifica(String title, String cor) {
//		setTitle(title);
//	    setSize(360, 250);
//	    this.setLocationRelativeTo(null);
//        this.setVisible(true);

		switch (title) {
		case "Anal�tico":
			new DesenhaAnalitico(title, cor);
			break;
		case "DDA":
			new DesenhaDDA(title, cor);
			break;
		case "Bresenham Pol�gonos":
			new DesenhaBresenhamPoli(title, cor);
			break;
		case "Varredura":
			new DesenhaVarredura(title, cor);
			break;
		case "Boundary-Fill":
			new DesenhaBoundary(title, cor);
			break;
		case "An�lise Geom�trica":
			new DesenhaAnalGeo(title, cor);
			break;
		case "Param�trica":
			new DesenhaParametrica(title, cor);
			break;
		case "Incremental com Simetria":
			new DesenhaIncSim(title, cor);
			break;
		case "Bresenham C�rculos":
			new DesenhaBresenhamCirc(title, cor);
			break;

		}
	}

}
