import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
//Panel del juego
public class PruebaBloque extends JPanel implements ActionListener {

	private int tamaño,
				numeroMinas;
	private Bloque[][] bloques; 
	private VentanaJuego frame;
	private PruebaVentana pv;
	
	public PruebaBloque(VentanaJuego vi, PruebaVentana vj, int t){//, int t parametros
		
		super();
		this.frame = vi;
		this.pv = vj;
		this.tamaño = t;
		this.numeroMinas = 10;
		this.bloques = new Bloque[this.tamaño][this.tamaño]; //adentro va a ir el tamaño del que quiere
		this.setLayout(new GridLayout(tamaño,tamaño));
		for(int i = 0; i < tamaño; i++)
		    {
		        for(int j = 0; j < tamaño; j++)
		        {
		            bloques[i][j] = new Bloque();
		            bloques[i][j].setBackground(Color.BLUE);
		            bloques[i][j].setForeground(Color.BLACK);	
		            bloques[i][j].setPreferredSize(new Dimension(30,30)); //Aqui se va a poner al dimension segun lo que queira el vato
		            bloques[i][j].setCordX(j);
		            bloques[i][j].setCordY(i);
		            bloques[i][j].addActionListener(this);
		            this.add(bloques[i][j]);
		        }
		        
		    }
		for(int i = 0; i < this.numeroMinas; i++){
			
			//Codigo obtenido para generar un numero random
			Random generadorRandom = new Random();
			int y = generadorRandom.nextInt(this.tamaño);
			int x = generadorRandom.nextInt(this.tamaño);
			
			while(bloques[y][x].getMina()==true){
				y = generadorRandom.nextInt(this.tamaño);
				x = generadorRandom.nextInt(this.tamaño);
			}
			//if(bloques[y][x].getMina()==false){
				bloques[y][x].setMina();
			//}
		}
	}
	public Bloque[][] getBloques() {
		return bloques;
	}
	public void setBloques(Bloque[][] bloques) {
		this.bloques = bloques;
	}
	public void setColorBloques(Color c){
		for(int i = 0; i < tamaño; i++)
	    {
	        for(int j = 0; j < tamaño; j++)
	        {
	            bloques[i][j].setBackground(c);	
	        }
	        
	    }
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
		Bloque a = (Bloque) e.getSource();
		if(a.getMina()==true){
			for(int i = 0; i < tamaño; i++){
		    
		        for(int j = 0; j < tamaño; j++){
		        	bloques[i][j].setEnabled(false);
		        }
		    }
		JOptionPane.showMessageDialog(this, "Exploto una mina, perdiste", "perdiste", 3);
		}else{
			a.setDestapada();
			int x = a.getCordX();
			int y = a.getCordY();
			a.setVisible(false);

			
			if((x!=0)||(x!=this.tamaño-1)||(y!=0)||(y!=this.tamaño-1)){
				
				if(bloques[y+1][x-1].getMina()==false){
					bloques[y-1][x-1].setDestapada();
					bloques[y-1][x-1].setVisible(false);
					
				}else{
					bloques[y][x].setMinasCerca();
				}
				if(bloques[y-1][x].getMina()==false){
					bloques[y-1][x].setDestapada();
					bloques[y-1][x].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
				
				if(bloques[y-1][x+1].getMina()==false){
					bloques[y-1][x+1].setDestapada();
					bloques[y-1][x+1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();;
				}
				
				if(bloques[y][x-1].getMina()==false){
					bloques[y][x-1].setDestapada();
					bloques[y][x-1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
				
				if(bloques[y][x+1].getMina()==false){
					bloques[y][x+1].setDestapada();
					bloques[y][x+1].setVisible(false);
					
				}else{
					bloques[y][x].setMinasCerca();
				}
				
				if(bloques[y+1][x-1].getMina()==false){
					bloques[y+1][x-1].setDestapada();	
					bloques[y+1][x-1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
				
				if(bloques[y+1][x].getMina()==false){
					bloques[y+1][x].setDestapada();	
					bloques[y+1][x].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
					
				}
				
				if(bloques[y+1][x+1].getMina()==false){
					bloques[y+1][x+1].setDestapada();
					bloques[y+1][x+1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
			
			}else if(y==0&&x==0){
				
				if(bloques[y][x+1].getMina()==false){
					bloques[y][x+1].setDestapada();
					bloques[y][x].setMinasCerca();
				}
			}
			//Si al momento de dar click en un bloque hay que validar si los bloques que colindan existen.
		}
		}catch(ArrayIndexOutOfBoundsException aiobe){
			
		}
		
	}
	
	//http://stackoverflow.com/questions/36779354/java-creating-a-grid-of-buttons-using-a-2d-array
	//Para saber si las minas alrededor contienen mina o no tengo que sumar las cordenadas a 1 y restar a 1.
	
}
