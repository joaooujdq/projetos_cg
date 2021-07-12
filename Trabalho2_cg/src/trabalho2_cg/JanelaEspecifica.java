package trabalho2_cg;

import javax.swing.JFrame;

public class JanelaEspecifica extends JFrame{
	
	
	public JanelaEspecifica(String title){
		setTitle(title);
	    setSize(360, 250);
	    this.setLocationRelativeTo(null);
        this.setVisible(true);
		
        switch(title) {
        case "Anal�tico":
        	new DesenhaAnalitico();
        	break;
        case "DDA":
        	new DesenhaDDA();
        	break;
        case "Bresenham Pol�gonos":
        	new DesenhaBresenhamPoli();
        	break;
        case "Varredura":
        	new DesenhaVarredura();
        	break;
        case "Boundary-Fill":
        	new DesenhaBoundary();
        	break;
        case "An�lise Geom�trica":
        	new DesenhaAnalGeo();
        	break;
        case "Param�trica":
        	new DesenhaParametrica();
        	break;
        case "Incremental com Simetria":
        	new DesenhaIncSim();
        	break;
        case "Bresenham C�rculos":
        	new DesenhaBresenhamCirc();
        	break;
        
        }
	}
	
}
