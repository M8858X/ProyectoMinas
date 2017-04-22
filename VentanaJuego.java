import java.awt.Dimension;

import javax.swing.JFrame;

public class VentanaJuego extends JFrame{
	public VentanaJuego(){
		super("Busca Minas");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(800,600));
		this.setVisible(true);
		
	}
	public static void main(String [] args){
		VentanaJuego venj = new VentanaJuego();
	}
}
