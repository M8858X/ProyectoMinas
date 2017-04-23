import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaJuego extends JFrame{
	
	private PanelVacio pve,
						pvo,
						pvs,
						pvn;
	private PanelOpciones po;
	private boolean isVisivilidad,
					visibleJuego;
	
	public VentanaJuego(){
		super("Buscaminas");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.pve = new PanelVacio(150,600);
		this.pvn = new PanelVacio(500,50);
		this.pvo = new PanelVacio(150,600);
		this.pvs = new PanelVacio(500,50);
		this.po = new PanelOpciones(this);
		
		this.add(this.pve, BorderLayout.EAST);
		this.add(this.pvn, BorderLayout.NORTH);
		this.add(this.pvs, BorderLayout.SOUTH);
		this.add(this.pvo, BorderLayout.WEST);
		this.add(this.po, BorderLayout.CENTER);
		
		this.pack();
		
		this.setVisible(po.isVisVentanaInicio());
		
	}
	public boolean isVisivilidad() {
		return isVisivilidad;
	}
	public void setVisivilidad(boolean isVisible) {
		this.isVisivilidad = isVisible;
	}
	public boolean isVisibleJuego() {
		return visibleJuego;
	}
	public void setVisibleJuego(boolean visibleJuego) {
		this.visibleJuego = visibleJuego;
	}
	public static void main(String [] args){
		VentanaJuego venj = new VentanaJuego();
	}
}
