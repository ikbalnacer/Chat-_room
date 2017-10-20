package _Filter;

import java.awt.Graphics;

import javax.swing.JApplet;
import javax.swing.JLabel;

public class applet extends JApplet{
	JLabel label = new JLabel("yeah i'm here ");
    public void init(){
    	this.setSize(200,200);
    	this.add(label);
    }
	
	public void paint(Graphics g){
		
	}
	
}
