import java.awt.GridLayout;

import javax.swing.JFrame;

public class PruebaVentana extends JFrame{

	private PruebaBloque pb;
	
	public PruebaVentana(){
		
		super("Prueba Ventana");
		this.pb = new PruebaBloque();
		this.add(pb);
		this.pack();
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args){
		
		PruebaVentana pv= new PruebaVentana();
		
	}
}
