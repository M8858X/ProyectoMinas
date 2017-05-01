import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class PanelVacio extends JPanel implements ActionListener{
	private JButton color,
					regresar,
					NuevaPartida;
	private Label numMinas;
	private int numeroMinas;
	private PruebaVentana pv;
	private VentanaJuego vi;
	
	public PanelVacio(int x, int y){
		super();
		this.setPreferredSize(new Dimension(x,y));
		this.setBackground(new Color(101, 142, 198));
	}
	public PanelVacio(int x, int y, PruebaVentana a, int numeroMinas, VentanaJuego vj){
		super();
		this.pv = a;
		this.vi = vj;
		this.numeroMinas = numeroMinas;
		this.setPreferredSize(new Dimension(x,y));
		this.setBackground(new Color(101, 142, 198));
		
		this.numMinas = new Label("Minas : "+ this.numeroMinas);
		this.numMinas.setFont(new Font("Arial",Font.BOLD,18));
		this.add(this.numMinas);
		
		this.color = new JButton("Cambiar color");
		this.color.addActionListener(this);
		this.add(this.color);
		
		this.regresar = new JButton("Regresar");
		this.regresar.addActionListener(this);
		this.add(this.regresar);
		
		this.NuevaPartida = new JButton ("Nueva Partida");
		this.NuevaPartida.addActionListener(this);
		this.add(this.NuevaPartida);
		
	}
	//public void paintComponent(Graphics g){
		//super.paintComponent(g);
		//g.drawString("Minas: " + String.valueOf(this.numeroMinas), 50, 150);
	//}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.color){
		Color seleccion = JColorChooser.showDialog(this, "Selecciona el color de la base", Color.BLUE);
		this.pv.setColorBloques(seleccion);
		}
		else if (e.getSource() == this.regresar){
			this.pv.setVisible(false);
			this.vi.setVisible(true);
					}
		else{
			
			PruebaVentana nueva = new PruebaVentana(this.pv.getTamaño(),this.pv.getNumMinas(),this.pv.getPo(),this.pv.getVj(),this.pv.getMinas());
			nueva.setVisible(true);
			this.pv.setVisible(false);
		}
	}
	
	public void restarMinas(){
		this.numeroMinas--;
		this.numMinas = new Label("Minas : "+ this.numeroMinas);
		this.numMinas.setFont(new Font("Arial",Font.BOLD,18));
		this.numMinas.repaint();
	}
	public void setNumeroMinas(int numMinas){
		this.numeroMinas = numMinas;
		this.repaint();
	}
	public int getNumeroMinas(){
		return this.numeroMinas;
	}
}
