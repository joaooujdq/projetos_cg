package trabalho2_cg;

import javax.swing.JFrame;

public class JanelaEspecifica extends JFrame{
	
	
	public JanelaEspecifica(String title){
		setTitle(title);
	    setSize(360, 250);
	    this.setLocationRelativeTo(null);
        this.setVisible(true);
		
        switch(title) {
        case "Analítico":
        	new DesenhaAnalitico();
        	break;
        case "DDA":
        	new DesenhaDDA();
        	break;
        case "Bresenham Polígonos":
        	new DesenhaBresenhamPoli();
        	break;
        case "Varredura":
        	new DesenhaVarredura();
        	break;
        case "Boundary-Fill":
        	new DesenhaBoundary();
        	break;
        case "Análise Geométrica":
        	new DesenhaAnalGeo();
        	break;
        case "Paramétrica":
        	new DesenhaParametrica();
        	break;
        case "Incremental com Simetria":
        	new DesenhaIncSim();
        	break;
        case "Bresenham Círculos":
        	new DesenhaBresenhamCirc();
        	break;
        
        }
	}
	
}
