import java.awt.Color;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Bloque extends JButton  {

	private boolean mina,
					marcada,
					habilitada;
	private int tamaño,
				minasCerca,
				cordX,
				cordY;
	private ImageIcon bandera;
	private Color color;
	
	
	public Bloque(){//Inicializa el bloque como default
		super();
		this.mina = false;
		this.marcada = false;
		this.tamaño = 0;
		this.minasCerca = 0;
		this.cordX = 0;
		this.cordY = 0;
		this.bandera = new ImageIcon("bandera.png");
		this.habilitada = true;
		
	}
	
	public void setMina(){
		this.mina = true;
	}
	
	public void setMarcada(){
		this.marcada = true;
	}
	
	public void setDesmarcada(){
		this.marcada = false;
	}
	
	public void setMinasCerca(){
		this.minasCerca++;
	}
	
	public void setCordX(int cordX){
		this.cordX=cordX;
	}
	
	public void setCordY(int cordY){
		this.cordY=cordY;
	}
	
	public void setColor(Color color){
		this.color = color;
	}
	
	public void setImagen(){
		this.bandera = new ImageIcon("bandera.png");
		setIcon(this.bandera);
	}
	
	public void setNoImagen(){
		this.bandera = null;
		setIcon(this.bandera);
	}
	
	public void setHabilitada(){
		this.habilitada = false;
		this.setEnabled(false);
	}

	public boolean getMina(){
		return this.mina;
	}
	
	/*public boolean getDestapada(){
		return this.destapada;
	}*/
	
	public boolean getMarcada(){
		return this.marcada;
	}
	
	public int getMinasCerca(){
		return this.minasCerca;
	}
	
	public int getCordX(){
		return this.cordX;
	}
	
	public int getCordY(){
		return this.cordY;
	}


	
	public boolean getHabilitada(){
		return this.habilitada;
	}
}

