import java.awt.BorderLayout;

import javax.swing.JFrame;

public class PruebaVentana extends JFrame{

	private PruebaBloque pb;
	private boolean visVentanaJuego;
	
	public PruebaVentana(VentanaJuego vi){
		super("Buscaminas");
		this.visVentanaJuego = false;
		this.pb = new PruebaBloque(vi,this);
		this.add(pb,BorderLayout.CENTER);
		PanelVacio pvn = new PanelVacio(500,50);
		PanelVacio pvo = new PanelVacio(150,600);
		PanelVacio pvs = new PanelVacio(500,50);
		PanelVacio pve = new PanelVacio(150,600);
		
		this.add(pve, BorderLayout.EAST);
		this.add(pvn, BorderLayout.NORTH);
		this.add(pvs, BorderLayout.SOUTH);
		this.add(pvo, BorderLayout.WEST);
		
		this.pack();
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(this.visVentanaJuego);
		
	}
	
	public boolean isVisVentanaJuego() {
		return visVentanaJuego;
	}

	public void setVisVentanaJuego(boolean visVentanaJuego) {
		this.visVentanaJuego = visVentanaJuego;
	}

	/*public static void main(String[] args){
		
		PruebaVentana pv= new PruebaVentana();
		
	}*/
}
