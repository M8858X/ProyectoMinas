import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
//Panel del juego
public class PruebaBloque extends JPanel implements ActionListener, MouseListener {

	private int tamaño,
				numeroMinas;
	private Bloque[][] bloques; 
	private VentanaJuego frame;
	private PruebaVentana pv;
	private Color color;
	
	public PruebaBloque(VentanaJuego vi, PruebaVentana vj, int t, int m){//, int t parametros
		
		super();
		this.frame = vi;
		this.pv = vj;
		this.tamaño = t;
		this.numeroMinas = m;
		this.bloques = new Bloque[this.tamaño][this.tamaño]; //adentro va a ir el tamaño del que quiere
		this.color = Color.BLUE;
		this.setLayout(new GridLayout(tamaño,tamaño));
		for(int i = 0; i < tamaño; i++)
		    {
		        for(int j = 0; j < tamaño; j++)
		        {		           
		        	bloques[i][j] = new Bloque();
		            bloques[i][j].setBackground(this.color);
		            bloques[i][j].setForeground(Color.BLACK);	
		            bloques[i][j].setPreferredSize(new Dimension(45,45)); //Aqui se va a poner al dimension segun lo que queira el vato
		            bloques[i][j].setCordX(j);
		            bloques[i][j].setCordY(i);
		            bloques[i][j].addActionListener(this);
		            bloques[i][j].addMouseListener(this);
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
	public int CuentaMinas(int ii, int jj){
	        int nm = 0;
	        for(int x=ii-1; x<=ii+1; x++)
	            for(int y=jj-1; y<=jj+1; y++)
	                if(!(x==ii && y==jj) &&
	                    x>=0 && x<this.tamaño &&
	                    y>=0 && y<this.tamaño)
	                    if(this.bloques[x][y].getMina())
	                        nm++;
	        return nm;
	}
	public Bloque[][] getBloques() {
		return bloques;
	}
	public void setBloques(Bloque[][] bloques) {
		this.bloques = bloques;
	}
	public void setColorBloques(Color c){
		this.color = c;
		for(int i = 0; i < tamaño; i++)
	    {
	        for(int j = 0; j < tamaño; j++)
	        {
	            bloques[i][j].setBackground(this.color);	
	        }
	        
	    }
		
	}
	public void setVisibleVentanaInicio(boolean visVentanaInicio){
		this.frame.setVisVentanaInicio(visVentanaInicio);
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
			//a.setDestapada();
			int x = a.getCordX();
			int y = a.getCordY();
			a.setBackground(this.color);
			a.setEnabled(false);
			
			if((x!=0)&&(x!=this.tamaño-1)&&(y!=0)&&(y!=this.tamaño-1)){
				
				if(bloques[y-1][x-1].getMina()==false){
					////bloques[y-1][x-1].setDestapada();
					bloques[y-1][x-1].setVisible(false);
					
				}else{
					bloques[y][x].setMinasCerca();
				}
				if(bloques[y-1][x].getMina()==false){
					//bloques[y-1][x].setDestapada();
					bloques[y-1][x].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
				
				if(bloques[y-1][x+1].getMina()==false){
					//bloques[y-1][x+1].setDestapada();
					bloques[y-1][x+1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();;
				}
				
				if(bloques[y][x-1].getMina()==false){
					//bloques[y][x-1].setDestapada();
					bloques[y][x-1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
				
				if(bloques[y][x+1].getMina()==false){
					//bloques[y][x+1].setDestapada();
					bloques[y][x+1].setVisible(false);
					
				}else{
					bloques[y][x].setMinasCerca();
				}
				
				if(bloques[y+1][x-1].getMina()==false){
					//bloques[y+1][x-1].setDestapada();	
					bloques[y+1][x-1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
				
				if(bloques[y+1][x].getMina()==false){
					//bloques[y+1][x].setDestapada();	
					bloques[y+1][x].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
					
				}
				
				if(bloques[y+1][x+1].getMina()==false){
					//bloques[y+1][x+1].setDestapada();
					bloques[y+1][x+1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
			
			//Esquina Superior Izquierda
			}else if((y==0)&&(x==0)){
				
				if(bloques[y][x+1].getMina()==false){
					//bloques[y][x+1].setDestapada();
					bloques[y][x+1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
				if(bloques[y+1][x+1].getMina()==false){
					//bloques[y+1][x+1].setDestapada();
					bloques[y+1][x+1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}if(bloques[y+1][x].getMina()==false){
					//bloques[y+1][x].setDestapada();
					bloques[y+1][x].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
				
				
			//Esquina Superior Derecha	
			}else if((y==0)&&(x==this.tamaño-1)){
				
				if(bloques[y][x-1].getMina()==false){
					//bloques[y][x-1].setDestapada();
					bloques[y][x-1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
				if(bloques[y+1][x-1].getMina()==false){
					//bloques[y+1][x-1].setDestapada();
					bloques[y+1][x-1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}if(bloques[y+1][x].getMina()==false){
					//bloques[y+1][x].setDestapada();
					bloques[y+1][x].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
			}
			
			//Esquina Inferior Izquierda
			else if((y==this.tamaño-1)&&(x==0)){
				
				if(bloques[y-1][x].getMina()==false){
					//bloques[y-1][x].setDestapada();
					bloques[y-1][x].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
				if(bloques[y-1][x+1].getMina()==false){
					//bloques[y-1][x+1].setDestapada();
					bloques[y-1][x+1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}if(bloques[y][x+1].getMina()==false){
					//bloques[y][x+1].setDestapada();
					bloques[y][x+1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
			}
			
			//Esquina Inferior Derecha
			else if((y==this.tamaño-1)&&(x==this.tamaño-1)){
				
				if(bloques[y-1][x].getMina()==false){
					//bloques[y-1][x].setDestapada();
					bloques[y-1][x].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
				if(bloques[y-1][x-1].getMina()==false){
					//bloques[y-1][x-1].setDestapada();
					bloques[y-1][x-1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}if(bloques[y][x-1].getMina()==false){
					//bloques[y][x-1].setDestapada();
					bloques[y][x-1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
			
			//FILA SUPERIOR
			}else if((y==0)&&((x!=0)&&(x!=this.tamaño-1))){
				
				if(bloques[y][x-1].getMina()==false){
					//bloques[y][x-1].setDestapada();
					bloques[y][x-1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}if(bloques[y][x+1].getMina()==false){
					//bloques[y][x+1].setDestapada();
					bloques[y][x+1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
				if(bloques[y+1][x-1].getMina()==false){
					//bloques[y+1][x-1].setDestapada();
					bloques[y+1][x-1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
				if(bloques[y+1][x].getMina()==false){
					//bloques[y+1][x].setDestapada();
					bloques[y+1][x].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}if(bloques[y+1][x+1].getMina()==false){
					//bloques[y+1][x+1].setDestapada();
					bloques[y+1][x+1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}	
			}
			
			//FILA INFERIOR
			else if((y==this.tamaño-1)&&((x!=0)&&(x!=this.tamaño-1))){
				
				if(bloques[y][x-1].getMina()==false){
					//bloques[y][x-1].setDestapada();
					bloques[y][x-1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}if(bloques[y][x+1].getMina()==false){
					//bloques[y][x+1].setDestapada();
					bloques[y][x+1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
				if(bloques[y-1][x-1].getMina()==false){
					//bloques[y-1][x-1].setDestapada();
					bloques[y-1][x-1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
				if(bloques[y-1][x].getMina()==false){
					//bloques[y-1][x].setDestapada();
					bloques[y-1][x].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}if(bloques[y-1][x+1].getMina()==false){
					//bloques[y-1][x+1].setDestapada();
					bloques[y-1][x+1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
				
			}
			
			//FILA IZQUIERDA
			else if((x==0)&&((y!=0)&&(y!=this.tamaño-1))){
				
				if(bloques[y-1][x].getMina()==false){
					//bloques[y-1][x].setDestapada();
					bloques[y-1][x].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}if(bloques[y-1][x+1].getMina()==false){
					//bloques[y-1][x+1].setDestapada();
					bloques[y-1][x+1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
				if(bloques[y][x+1].getMina()==false){
					//bloques[y][x+1].setDestapada();
					bloques[y][x+1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
				if(bloques[y+1][x+1].getMina()==false){
					//bloques[y+1][x+1].setDestapada();
					bloques[y+1][x+1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}if(bloques[y+1][x].getMina()==false){
					//bloques[y+1][x].setDestapada();
					bloques[y+1][x].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
				
			}
			
			//FILA DERECHA
			else if((x==this.tamaño-1)&&((y!=0)&&(y!=this.tamaño-1))){
				
				if(bloques[y-1][x].getMina()==false){
					//bloques[y-1][x].setDestapada();
					bloques[y-1][x].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}if(bloques[y-1][x-1].getMina()==false){
					//bloques[y-1][x-1].setDestapada();
					bloques[y-1][x-1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
				if(bloques[y][x-1].getMina()==false){
					//bloques[y][x-1].setDestapada();
					bloques[y][x-1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
				if(bloques[y+1][x-1].getMina()==false){
					//bloques[y+1][x-1].setDestapada();
					bloques[y+1][x-1].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}if(bloques[y+1][x].getMina()==false){
					//bloques[y+1][x].setDestapada();
					bloques[y+1][x].setVisible(false);
				}else{
					bloques[y][x].setMinasCerca();
				}
				
			}
			
			
			//Si al momento de dar click en un bloque hay que validar si los bloques que colindan existen.
			
			bloques[y][x].setText(bloques[y][x].getMinasCerca()+"");
			
			
		}
		}catch(ArrayIndexOutOfBoundsException aiobe){
			
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		 if (SwingUtilities.isRightMouseButton(arg0)) {
			
			Bloque a = (Bloque) arg0.getSource();
			if(a.getHabilitada()){
				if(a.getMarcada()==false){
					a.setMarcada();
					a.setImagen();
					
					if(a.getMina()==true){
						a.setHabilitada();
						
					}
					
				}else{
					a.setDesmarcada();
					a.setNoImagen();
					a.setBackground(this.color);
				}
			}
							
		}	
	}
	
	
	
	
	//http://stackoverflow.com/questions/36779354/java-creating-a-grid-of-buttons-using-a-2d-array
	//Para saber si las minas alrededor contienen mina o no tengo que sumar las cordenadas a 1 y restar a 1.
	
	}

