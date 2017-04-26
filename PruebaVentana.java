import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class PruebaVentana extends JFrame{

	private PruebaBloque pb;
	private PanelOpciones po;
	private VentanaJuego vj;
	private boolean visVentanaJuego;
	
	public PruebaVentana(VentanaJuego vi, int t, String numMinas, PanelOpciones p, VentanaJuego vj, int m){
		super("Buscaminas");
		this.visVentanaJuego = false;
		this.po = p;
		this.vj = vj;
		this.pb = new PruebaBloque(vi,this,t,m);
		this.add(pb,BorderLayout.CENTER);
		PanelVacio pvn = new PanelVacio(500,50);
		PanelVacio pvo = new PanelVacio(150,600,this, numMinas,this.vj);
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
	public void setColorBloques(Color c){
		this.pb.setColorBloques(c);
	}

	/*public static void main(String[] args){
		
		PruebaVentana pv= new PruebaVentana();
		
	}*/
}
