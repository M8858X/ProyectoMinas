import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOpciones extends JPanel implements ActionListener{
	private JButton op1,
					op2,
					op3,
					perz; 
	//Personalizacion del color
	public PanelOpciones(){
		
		super();
		this.setPreferredSize(new Dimension(500,500));
		this.setBackground(new Color(101, 142, 198));
		
		this.op1 = new JButton("9x9");
		this.op1.setPreferredSize(new Dimension(250,35));
		this.op1.setFont(new Font("Arial",Font.BOLD,36));
		this.add(this.op1);
		
		this.op2 = new JButton("16x16");
		this.op2.setPreferredSize(new Dimension(250,35));
		this.op2.setFont(new Font("Arial",Font.BOLD,25));
		this.add(this.op2);
		
		this.op3 = new JButton("24x24");
		this.op3.setPreferredSize(new Dimension(250,35));
		this.op3.setFont(new Font("Arial",Font.BOLD,36));
		this.add(this.op3);
		
		this.perz = new JButton ("Personalizar");
		this.perz.setPreferredSize(new Dimension(250,35));
		this.perz.setFont(new Font("Arial",Font.BOLD,36));
		this.add(this.perz);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
