package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class end extends JPanel implements ActionListener{
	private JLabel l;
public end(String s) {  
	this.setBackground(Color.BLACK);
	this.setLayout(null);
	l=new JLabel(s);
	l.setBounds(400,400,400,400);
	l.setForeground(Color.yellow);
	l.setFont(new Font("Arial",Font.BOLD,30));
	this.add(l);
	
	
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
