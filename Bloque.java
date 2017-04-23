import javax.swing.JButton;

public class Bloque extends JButton  {

	private boolean mina;
	private boolean destapada;
	private boolean marcada;
	private int tamaño;
	private int cordX;
	private int cordY;
	private JButton bloque;
	
	
	public Bloque(){//Inicializa el bloque como default
		this.bloque = new JButton();
		this.mina = false;
		this.destapada = false;
		this.marcada = false;
		this.tamaño = 0;
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

