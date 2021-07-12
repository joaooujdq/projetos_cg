package trabalho2_cg;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;



public class Janela extends JFrame {
	String faces;
	
	JMenuBar menuBar = new JMenuBar();
	JMenu fileMenu = new JMenu("Primitivas");
	JMenu colorMenu = new JMenu("Cores");
	JMenuItem exitMenu= new JMenuItem("Sair");
    
 
    JMenu linhasMenu = new JMenu("Linhas");
    JMenu poliMenu = new JMenu("Pol�gonos");
    JMenu circMenu = new JMenu("C�rculos");
    
    JMenuItem colorRedMenu = new JMenuItem("Vermelho");
    JMenuItem colorGreenMenu = new JMenuItem("Verde");
    JMenuItem colorBlueMenu = new JMenuItem("Azul");

    JMenuItem analiticoItem = new JMenuItem("Anal�tico");
    JMenuItem DDAItem = new JMenuItem("DDA");
    JMenuItem poliBresItem = new JMenuItem("Bresenham Pol�gonos");
    
    JMenuItem varreduraItem = new JMenuItem("Varredura");
    JMenuItem boundaryItem = new JMenuItem("Boundary-Fill");
    JMenuItem geoItem = new JMenuItem("An�lise Geom�trica");

    JMenuItem parametricaItem = new JMenuItem("Param�trica");
    JMenuItem incSimItem = new JMenuItem("Incremental com Simetria");
    JMenuItem circBresItem = new JMenuItem("Bresenham C�rculos");
	
	
	public Janela() {
		
        initUI();
    }

    private void initUI() {

        createMenuBar();

        setTitle("Trabalho 2 - Computa��o Gr�fica");
        setSize(360, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createMenuBar() {
    	
        
        
        
        
        linhasMenu.add(analiticoItem);
        analiticoItem.addActionListener((event) ->
        new JanelaEspecifica(analiticoItem.getText()));
        
        linhasMenu.add(DDAItem);
        DDAItem.addActionListener((event) ->
        new JanelaEspecifica(DDAItem.getText()));
        
        linhasMenu.add(poliBresItem);
        poliBresItem.addActionListener((event) ->
        new JanelaEspecifica(poliBresItem.getText()));
        
     
        
        
        poliMenu.add(varreduraItem);
        varreduraItem.addActionListener((event) ->
        new JanelaEspecifica(varreduraItem.getText()));
        
        poliMenu.add(boundaryItem);
        boundaryItem.addActionListener((event) ->
        new JanelaEspecifica(boundaryItem.getText()));
        
        poliMenu.add(geoItem);
        geoItem.addActionListener((event) ->
        new JanelaEspecifica(geoItem.getText()));
        
        
        
        
        
        
        
        
        circMenu.add(parametricaItem);
        parametricaItem.addActionListener((event) ->
        new JanelaEspecifica(parametricaItem.getText()));
        
        circMenu.add(incSimItem);
        incSimItem.addActionListener((event) ->
        new JanelaEspecifica(incSimItem.getText()));
        
        circMenu.add(circBresItem);
        circBresItem.addActionListener((event) ->
        new JanelaEspecifica(circBresItem.getText()));
        

   
        exitMenu.setToolTipText("Sair da Aplica��o");

        exitMenu.addActionListener((event) -> System.exit(0));


        fileMenu.add(linhasMenu);
        fileMenu.add(poliMenu);
        fileMenu.add(circMenu);
   
        colorMenu.add(colorRedMenu);
        colorMenu.add(colorGreenMenu);
        colorMenu.add(colorBlueMenu);
        
        colorGreenMenu.addActionListener((event) -> faces = JOptionPane.showInputDialog("Quantidade de faces:"));
        colorBlueMenu.addActionListener((event) -> faces = JOptionPane.showInputDialog("Quantidade de faces:"));
        colorRedMenu.addActionListener((event) -> faces = JOptionPane.showInputDialog("Quantidade de faces:"));

        menuBar.add(fileMenu);
        menuBar.add(colorMenu);
        menuBar.add(exitMenu);

        setJMenuBar(menuBar);
        
    }


}
