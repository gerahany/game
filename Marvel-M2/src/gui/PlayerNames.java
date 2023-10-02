package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PlayerNames extends JPanel implements ActionListener{
private Frame  frame;

private JLabel l1;
private JLabel l2;

private JTextField n1;
private JTextField n2;

private JButton next;
private JLabel background;

public PlayerNames(Frame frame) {
	this.frame=frame;
	this.setLayout(null);

	
	
	
	l1=new JLabel("First Player's Name");
	l1.setBounds(350,500,150,30);
	l1.setForeground(Color.WHITE);this.add(l1);
	
	l2=new JLabel("Second Player's Name");
	l2.setBounds(350,600,150,30);l2.setForeground(Color.WHITE);this.add(l2);
	
	
	
	
	n1=new JTextField();
	n1.setBounds(270,550,250,30);
	this.add(n1);
	
	n2=new JTextField();
	n2.setBounds(270,650,250,30);
	this.add(n2);
	next=new JButton();
	
	next.setIcon(new ImageIcon( ("next.jpg")));
	next.setBounds(350,700,100,30);
	next.addActionListener(this);
	this.add(next);
	
	background=new JLabel();
	background.setSize(800,800);
	background.setIcon(new ImageIcon(("marvel1.jpg")));
	validate();
	this.add(background);
	
	validate();
	repaint();
	
	
}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==next) {
			if(n1.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Player 1 must have a name", "Erorr", JOptionPane.ERROR_MESSAGE);
				
			}
			else if(n2.getText().equals("")) {
				JOptionPane.showMessageDialog(this,"Player 2 must have a name", "Erorr", JOptionPane.ERROR_MESSAGE);
					
				}
			else {
				frame.switchPanel(n1.getText(), n2.getText());
			}
		}
		
		
	}
	
}

