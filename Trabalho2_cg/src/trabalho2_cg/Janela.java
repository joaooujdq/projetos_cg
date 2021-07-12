package trabalho2_cg;


import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;



public class Janela extends JFrame {
	
	String cor;
	
	JMenuBar menuBar = new JMenuBar();
	JMenu fileMenu = new JMenu("Primitivas");
	JMenu colorMenu = new JMenu("Cores");
	JMenuItem exitMenu= new JMenuItem("Sair");
    
 
    JMenu linhasMenu = new JMenu("Linhas");
    JMenu poliMenu = new JMenu("Polígonos");
    JMenu circMenu = new JMenu("Círculos");
    
    JMenuItem colorRedMenu = new JMenuItem("Vermelho");
    JMenuItem colorGreenMenu = new JMenuItem("Verde");
    JMenuItem colorBlueMenu = new JMenuItem("Azul");

    JMenuItem analiticoItem = new JMenuItem("Analítico");
    JMenuItem DDAItem = new JMenuItem("DDA");
    JMenuItem poliBresItem = new JMenuItem("Bresenham Polígonos");
    
    JMenuItem varreduraItem = new JMenuItem("Varredura");
    JMenuItem boundaryItem = new JMenuItem("Boundary-Fill");
    JMenuItem geoItem = new JMenuItem("Análise Geométrica");

    JMenuItem parametricaItem = new JMenuItem("Paramétrica");
    JMenuItem incSimItem = new JMenuItem("Incremental com Simetria");
    JMenuItem circBresItem = new JMenuItem("Bresenham Círculos");
	
	
	public Janela() {
        initUI();
    }

    private void initUI() {

        createMenuBar();

        setTitle("Trabalho 2 - Computação Gráfica");
        setSize(360, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createMenuBar() {
    	
        
         
        
        
        linhasMenu.add(analiticoItem);
        analiticoItem.addActionListener((event) ->
        new JanelaEspecifica(analiticoItem.getText(), cor));
        
        linhasMenu.add(DDAItem);
        DDAItem.addActionListener((event) ->
        new JanelaEspecifica(DDAItem.getText(),cor));
        
        linhasMenu.add(poliBresItem);
        poliBresItem.addActionListener((event) ->
        new JanelaEspecifica(poliBresItem.getText(),cor));
        
     
        
        
        poliMenu.add(varreduraItem);
        varreduraItem.addActionListener((event) ->
        new JanelaEspecifica(varreduraItem.getText(),cor));
        
        poliMenu.add(boundaryItem);
        boundaryItem.addActionListener((event) ->
        new JanelaEspecifica(boundaryItem.getText(),cor));
        
        poliMenu.add(geoItem);
        geoItem.addActionListener((event) ->
        new JanelaEspecifica(geoItem.getText(),cor));
        
        
        
        
        
        
        
        
        circMenu.add(parametricaItem);
        parametricaItem.addActionListener((event) ->
        new JanelaEspecifica(parametricaItem.getText(),cor));
        
        circMenu.add(incSimItem);
        incSimItem.addActionListener((event) ->
        new JanelaEspecifica(incSimItem.getText(),cor));
        
        circMenu.add(circBresItem);
        circBresItem.addActionListener((event) ->
        new JanelaEspecifica(circBresItem.getText(),cor));
        

   
        exitMenu.setToolTipText("Sair da Aplicação");

        exitMenu.addActionListener((event) -> System.exit(0));


        fileMenu.add(linhasMenu);
        fileMenu.add(poliMenu);
        fileMenu.add(circMenu);
   
        colorMenu.add(colorRedMenu);
        colorMenu.add(colorGreenMenu);
        colorMenu.add(colorBlueMenu);
        
        colorGreenMenu.addActionListener((event) -> cor = selecionarCor("green"));
        		
       colorBlueMenu.addActionListener((event) -> cor = selecionarCor("blue"));
       colorRedMenu.addActionListener((event) -> cor = selecionarCor("red"));
        
        


        menuBar.add(fileMenu);
        menuBar.add(colorMenu);
        menuBar.add(exitMenu);

        setJMenuBar(menuBar);
        
    }

    public String selecionarCor(String cor) {
    	switch(cor){
    	case "green":
    		JOptionPane.showMessageDialog(null, "Cor verde selecionada.");
    		break;
    	case "red":
    		JOptionPane.showMessageDialog(null, "Cor vermelha selecionada.");
    		break;
    	case "blue":
    		JOptionPane.showMessageDialog(null, "Cor azul selecionada.");
    		break;
    	}
    	return cor;
}
}
