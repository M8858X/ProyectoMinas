import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PanelVacio extends JPanel{
	
	public PanelVacio(int x, int y){
		super();
		this.setPreferredSize(new Dimension(x,y));
		this.setBackground(new Color(101, 142, 198));
	}
}
