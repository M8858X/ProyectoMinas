import java.awt.Color;

import javax.swing.JButton;

public class Bloque extends JButton  {

	private boolean mina,
					destapada,
					marcada;
	private int tamaño,
				minasCerca,
				cordX,
				cordY;
	
	
	public Bloque(){//Inicializa el bloque como default
		super();
		this.mina = false;
		this.destapada = false;
		this.marcada = false;
		this.tamaño = 0;
		this.minasCerca = 0;
		this.cordX = 0;
		this.cordY = 0;
		
	}
	
	public void setMina(){
		this.mina = true;
	}
	
	public void setDestapada(){
		this.destapada = true;
	}
	
	public void setMarcada(){
		this.marcada = true;
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

	public boolean getMina(){
		return this.mina;
	}
	
	public boolean getDestapada(){
		return this.destapada;
	}
	
	public boolean getMarcada(){
		return this.marcada;
	}
	
	public int getCordX(){
		return this.cordX;
	}
	
	public int getCordY(){
		return this.cordY;
	}
}