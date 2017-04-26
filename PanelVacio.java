import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class PanelVacio extends JPanel implements ActionListener{
	private JButton color,
					regresar;
	private Label numMinas;
	private PruebaVentana pv;
	private VentanaJuego vi;
	
	public PanelVacio(int x, int y){
		super();
		this.setPreferredSize(new Dimension(x,y));
		this.setBackground(new Color(101, 142, 198));
	}
	public PanelVacio(int x, int y, PruebaVentana a, String numMinas, VentanaJuego vj){
		super();
		this.pv = a;
		this.vi = vj;
		this.setPreferredSize(new Dimension(x,y));
		this.setBackground(new Color(101, 142, 198));
		
		this.numMinas = new Label("Minas : "+ numMinas);
		this.numMinas.setFont(new Font("Arial",Font.BOLD,18));
		this.add(this.numMinas);
		
		this.color = new JButton("Cambiar color");
		this.color.addActionListener(this);
		this.add(this.color);
		
		this.regresar = new JButton("Regresar");
		this.regresar.addActionListener(this);
		this.add(this.regresar);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.color){
		Color seleccion = JColorChooser.showDialog(this, "Selecciona el color de la base", Color.BLUE);
		this.pv.setColorBloques(seleccion);
		}
		else{
			this.pv.setVisible(false);
			this.vi.setVisible(true);
					}
	}
}
