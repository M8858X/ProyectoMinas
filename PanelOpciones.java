import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelOpciones extends JPanel implements ActionListener{
	private JButton op1,
					op2,
					op3,
					hidden,
					Instruc; 
	private Image logo;//Personalizacion del color
	private VentanaJuego vi;
	private PruebaVentana vj;
	private boolean visVentanaInicio,
					visVentanaJuego;
	private Color color;
	
	public PanelOpciones(VentanaJuego frame){
		
		super();
		
		this.visVentanaInicio = true;
		this.visVentanaJuego = false;
		
		this.vi = frame;
		this.setPreferredSize(new Dimension(500,500));
		this.setBackground(new Color(101, 142, 198));
		
		this.logo = new ImageIcon("gib.png").getImage();
		
		//Boton para que el logo se alcanze a ver, solo funge para cubrir espacio
		this.hidden = new JButton();
		this.hidden.setPreferredSize(new Dimension(300,250));
		this.hidden.setContentAreaFilled(false);
		this.hidden.setBorderPainted(false);
		this.add(this.hidden);
		
		this.op1 = new JButton("9x9");
		this.op1.setPreferredSize(new Dimension(250,35));
		this.op1.setFont(new Font("Arial",Font.BOLD,25));
		this.op1.addActionListener(this);
		this.add(this.op1);
		
		this.op2 = new JButton("16x16");
		this.op2.setPreferredSize(new Dimension(250,35));
		this.op2.setFont(new Font("Arial",Font.BOLD,25));
		this.op2.addActionListener(this);
		this.add(this.op2);
		
		this.op3 = new JButton("24x24");
		this.op3.setPreferredSize(new Dimension(250,35));
		this.op3.setFont(new Font("Arial",Font.BOLD,25));
		this.op3.addActionListener(this);
		this.add(this.op3);
		
		this.Instruc = new JButton("Instrucciones");
		this.Instruc.setPreferredSize(new Dimension(250,35));
		this.Instruc.setFont(new Font("Arial",Font.BOLD,25));
		this.Instruc.addActionListener(this);
		this.add(this.Instruc);
	}
	public boolean isVisVentanaInicio() {
		return visVentanaInicio;
	}
	
	public void setVisVentanaInicio(boolean visVentanaInicio) {
		this.visVentanaInicio = visVentanaInicio;
	}
	
	public boolean isVisVentanaJuego() {
		return visVentanaJuego;
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(this.logo,160,0,181,223,null);
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.op1){
			this.vj = new PruebaVentana( 9, 10,this,this.vi,10);
			this.visVentanaInicio = false;
			this.visVentanaJuego = true;
			this.vi.setVisible(this.visVentanaInicio);
			this.vj.setVisible(this.visVentanaJuego);
		}else if(e.getSource() == this.op2){
			this.vj = new PruebaVentana(16,25 ,this,this.vi, 25);
			this.visVentanaInicio = false;
			this.visVentanaJuego = true;
			this.vi.setVisible(this.visVentanaInicio);
			this.vj.setVisible(this.visVentanaJuego);
		} else if(e.getSource() == this.op3){
			this.vj = new PruebaVentana(24, 50,this,this.vi,50);
			this.visVentanaInicio = false;
			this.visVentanaJuego = true;
			this.vi.setVisible(this.visVentanaInicio);
			this.vj.setVisible(this.visVentanaJuego);
		}else if (e.getSource() == this.Instruc){
			JOptionPane.showMessageDialog(null,"Las reglas del juego son simple:"
					+ "\n 1- El jugador debe de buscar las minas puestas al azar en la cuadricula"
					+ "\n 2- Solo se debe de pulsar el boton derecho sobre ell cuadro una vez que este seguro que este es una mina"
					+ "\n 3- Si su elección fue correcta, el cuadro se desabilitara y podra continuar, si fue erronea el cuadro se pondra de color rojo"
					+ "\n 4- Al pulsas uno de los cuadros este mostrara el numero de minas que se encuentran cerca de él"
					+ "\n 5- Si pulsas una mina el juego termina"
					+ "\n 6- Encontrar cada cuadro libre te dara 100 puntos", "Resultados", 3);
		}
		
	}
}
