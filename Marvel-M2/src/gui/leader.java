package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class leader  extends JPanel implements ActionListener {
private Frame frame;
private JButton b1;
private JButton b2;
private JButton b3;
private JButton b4;
private JButton b5;
private JButton b6;
private String l1;
private String l2;
private JLabel n1;
private JLabel n2;
private JLabel n3;
private JLabel n4;
private JLabel n5;
private JLabel n6;
private JLabel n7;
private JLabel n8;
private String s1;
private String s2;
private String s3;
private String s4;
private String s5;
private String s6;

private JButton start;



	public leader(Frame frame, String s1, String s2, String s3, String s4, String s5, String s6) {
		l1="";
		l2="";
	this.frame=frame;
	this.s1=s1;
	this.s2=s2;
	this.s3=s3;
	this.s4=s4;
	this.s5=s5;
	this.s6=s6;
	this.setLayout(null);
	this.setBackground(Color.BLACK);
	this.setSize(800,800);
	n7=new JLabel ("choose first leader");
	n7.setBounds(95,10,200,30);
	n7.setForeground(Color.RED);
	n7.setBackground(Color.BLACK);
	this.add(n7);
	n7.setFont(new Font("Arial",Font.BOLD,20));
	n8=new JLabel ("choose second leader");
	n8.setBounds(470,10,250,30);
	n8.setForeground(Color.blue);
	n8.setBackground(Color.BLACK);
	this.add(n8);
	n8.setFont(new Font("Arial",Font.BOLD,20));
	
	b1=new JButton();
	b1.setBounds(50, 50, 200, 150);
	b1.addActionListener(this);
	frame.photo(b1, s1);
	b1.setBackground(Color.BLACK);
	this.add(b1);
	n1=new JLabel (s1);
	n1.setBounds(120,210,200,30);
	n1.setForeground(Color.RED);
	n1.setBackground(Color.BLACK);
	this.add(n1);
	n1.setFont(new Font("Arial",Font.BOLD,25));
		
	b2=new JButton();
	b2.setBounds(50, 250, 200, 150);
	b2.addActionListener(this);
	frame.photo(b2, s2);
	b2.setBackground(Color.BLACK);
	this.add(b2);
	n2=new JLabel (s2);
	n2.setBounds(120,410,200,30);
	n2.setForeground(Color.RED);
	n2.setBackground(Color.BLACK);
	this.add(n2);
	n2.setFont(new Font("Arial",Font.BOLD,25));
	
	b3=new JButton();
	b3.setBounds(50, 450, 200, 150);
	b3.addActionListener(this);
	frame.photo(b3, s3);
	b3.setBackground(Color.BLACK);
	this.add(b3);
	n3=new JLabel (s3);
	n3.setBounds(120,610,200,30);
	n3.setForeground(Color.RED);
	n3.setBackground(Color.BLACK);
	this.add(n3);
	n3.setFont(new Font("Arial",Font.BOLD,25));
	
	
	
	b4=new JButton();
	b4.setBounds(450, 50, 200, 150);
	b4.addActionListener(this);
	frame.photo(b4, s4);
	b4.setBackground(Color.BLACK);
	this.add(b4);
	n4=new JLabel (s4);
	n4.setBounds(500,210,200,30);
	n4.setForeground(Color.blue);
	n4.setBackground(Color.BLACK);
	this.add(n4);
	n4.setFont(new Font("Arial",Font.BOLD,25));
		
	b5=new JButton();
	b5.setBounds(450, 250, 200, 150);
	b5.addActionListener(this);
	frame.photo(b5, s5);
	b5.setBackground(Color.BLACK);
	this.add(b5);
	n5=new JLabel (s5);
	n5.setBounds(500,410,200,30);
	n5.setForeground(Color.blue);
	n5.setBackground(Color.BLACK);
	this.add(n5);
	n5.setFont(new Font("Arial",Font.BOLD,25));
	
	b6=new JButton();
	b6.setBounds(450, 450, 200, 150);
	b6.addActionListener(this);
	frame.photo(b6, s6);
	b6.setBackground(Color.BLACK);
	this.add(b6);
	n6=new JLabel (s6);
	n6.setBounds(500,610,200,30);
	n6.setForeground(Color.blue);
	n6.setBackground(Color.BLACK);
	this.add(n6);
	n6.setFont(new Font("Arial",Font.BOLD,25));
	
	start=new JButton("next");
	start.setFont(new Font("Arial",Font.BOLD,25));
	start.setBounds(300,700,150,30);
	start.addActionListener(this);
	start.setBackground(Color.RED);
	
	this.add(start);
	}
	


	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
			l1=s1;
		if(e.getSource()==b2)
			l1=s2;
		if(e.getSource()==b3)
			l1=s3;
		if(e.getSource()==b4)
			l2=s4;
		if(e.getSource()==b5)
			l2=s5;
		if(e.getSource()==b6)
			l2=s6;
		
		if(e.getSource()==start) {
			boolean b= true;
			if(l1=="") {
				JOptionPane.showMessageDialog(this,"must select a leader for the first player", "Erorr", JOptionPane.ERROR_MESSAGE);
			b=false;
			}
			if(l2=="") {
				JOptionPane.showMessageDialog(this,"must select a leader for the second player", "Erorr", JOptionPane.ERROR_MESSAGE);
		b=false;
			}
			if(b==true) {
				frame.sboardp(l1, l2);
				
			}
		
	}

}}
