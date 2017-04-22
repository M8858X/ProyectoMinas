import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class PruebaBloque extends JPanel implements ActionListener {

	private int tamaño;
	private Bloque[][] bloques; 
	
	public PruebaBloque(){
		
		super();
		this.tamaño = 9;
		this.bloques = new Bloque[tamaño][tamaño]; //adentro va a ir el tamaño del que quiere
		this.setLayout(new GridLayout(tamaño,tamaño));
		for(int i = 0; i < tamaño; i++)
		    {
		        for(int j = 0; j < tamaño; j++)
		        {
		            bloques[i][j] = new Bloque();
		            bloques[i][j].setBackground(Color.BLUE);
		            bloques[i][j].setForeground(Color.BLACK);	
		            bloques[i][j].setPreferredSize(new Dimension(40,40)); //Aqui se va a poner al dimension segun lo que queira el vato
		            bloques[i][j].setCordX(j);
		            bloques[i][j].setCordY(i);
		            bloques[i][j].addActionListener(this);
		            this.add(bloques[i][j]);
		        }
		    }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Bloque a = (Bloque) e.getSource();
		if(a.getMina()==true){
			//Terminar juego
		}else{
			a.setDestapada();
		}
		
	}
	
	//http://stackoverflow.com/questions/36779354/java-creating-a-grid-of-buttons-using-a-2d-array
	//Para saber si las minas alrededor contienen mina o no tengo que sumar las cordenadas a 1 y restar a 1.
	
}
