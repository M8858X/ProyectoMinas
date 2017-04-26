import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class PanelVacio extends JPanel implements ActionListener{
	private JButton color;
	private PruebaVentana pv;
	
	public PanelVacio(int x, int y){
		super();
		this.setPreferredSize(new Dimension(x,y));
		this.setBackground(new Color(101, 142, 198));
	}
	public PanelVacio(int x, int y, PruebaVentana a){
		super();
		this.pv = a;
		this.setPreferredSize(new Dimension(x,y));
		this.setBackground(new Color(101, 142, 198));
		this.color = new JButton("Cambiar color");
		this.color.addActionListener(this);
		this.add(this.color);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Color seleccion = JColorChooser.showDialog(this, "Selecciona el color de la base", Color.BLUE);
		this.pv.setColorBloques(seleccion);
	}
}
