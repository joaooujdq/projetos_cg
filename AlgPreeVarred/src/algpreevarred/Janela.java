package algpreevarred;

import javax.swing.JFrame;


public class Janela extends JFrame {

    public Janela() {
        
        this.add(new Desenha());
        
        this.setTitle("Algoritmo de Preenchimento de Areas - Varredura");
        this.setSize(300,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
                
    }
    
}