import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOpciones extends JPanel implements ActionListener{
	private JButton op1,
					op2,
					op3,
					perz,
					hidden; 
	private Image logo;//Personalizacion del color
	private VentanaJuego vi;
	private PruebaVentana vj;
	private boolean visVentanaInicio,
					visVentanaJuego;
	
	public PanelOpciones(VentanaJuego frame){
		
		super();
		
		this.visVentanaInicio = true;
		this.visVentanaJuego = false;
		
		this.vi = frame;
		this.vj = new PruebaVentana(this.vi);
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
		
		this.perz = new JButton ("Personalizar");
		this.perz.setPreferredSize(new Dimension(250,35));
		this.perz.setFont(new Font("Arial",Font.BOLD,25));
		this.perz.addActionListener(this);
		this.add(this.perz);
		
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
	
	public void setVisVentanaJuego(boolean visVentanaJuego) {
		this.visVentanaJuego = visVentanaJuego;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(this.logo,160,0,181,223,null);
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.op1){
			this.visVentanaInicio = false;
			this.visVentanaJuego = true;
			this.vi.setVisible(this.visVentanaInicio);
			this.vj.setVisible(this.visVentanaJuego);
		}else if(e.getSource() == this.op2){
			this.visVentanaInicio = false;
			this.visVentanaJuego = true;
			this.vi.setVisible(this.visVentanaInicio);
			this.vj.setVisible(this.visVentanaJuego);
		} else if(e.getSource() == this.op3){
			this.visVentanaInicio = false;
			this.visVentanaJuego = true;
			this.vi.setVisible(this.visVentanaInicio);
			this.vj.setVisible(this.visVentanaJuego);
		}else if (e.getSource() == this.perz){
			//Para cambiar color del fondo
		}
		
	}
}
