package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import engine.Game;
import model.world.Champion;

public class chooseL extends JPanel implements ActionListener {
private Frame frame;
private JButton b1;
private JButton b2;
private JButton b3;
private JButton b4;
private JButton b5;
private JButton b6;
private JButton b7;
private JButton b8;
private JButton b9;
private JButton b10;
private JButton b11;
private JButton b12;
private JButton b13;
private JButton b14;
private JButton b15;
private JTextArea info;


private JButton start;
private JLabel name;
private JTextArea choosec1;
private JTextArea choosec2;
private ArrayList<String> a1;
private JLabel lp1;
private JLabel lp2;
private int x;

public chooseL(Frame frame) {
	 a1=new ArrayList();
	 x=0;
	this.frame=frame;
	this.setBackground(Color.BLACK);
	this.setLayout(null);
	JPanel p1=new JPanel();
	name=new JLabel("Choose 3 Champions for the first player and 3 for the second player");
	name.setForeground(Color.green);
	name.setBounds(300,1,400,30);
	this.add(name);
	
	info=new JTextArea();
	info.setBounds(600, 500, 150, 200);
	info.setEditable(false);
	info.setBackground(Color.black);
	info.setForeground(Color.yellow);
	info.setBorder(BorderFactory.createLineBorder(Color.yellow));
	this.add(info);
	
	
	choosec1=new JTextArea();
	choosec1.setBounds(150, 500, 150, 150);
	choosec1.setEditable(false);
	choosec1.setBackground(Color.black);
	choosec1.setForeground(Color.red);
	choosec1.setBorder(BorderFactory.createLineBorder(Color.red));
	this.add(choosec1);
	
	lp1=new JLabel(" Champions of the first player ");
	lp1.setForeground(Color.RED);
	lp1.setBounds(150,450,200,30);
	this.add(lp1);
	
	choosec2=new JTextArea();
	choosec2.setBounds(350, 500, 150, 150);
	choosec2.setEditable(false);
	choosec2.setBackground(Color.black);
	choosec2.setForeground(Color.blue);
	choosec2.setBorder(BorderFactory.createLineBorder(Color.blue));
	this.add(choosec2);
	
	lp2=new JLabel(" Champions of the second player ");
	lp2.setForeground(Color.BLUE);
	lp2.setBounds(350,450,200,30);
	this.add(lp2);
	
	start=new JButton("next");
	start.setFont(new Font("Arial",Font.BOLD,25));
	start.setBounds(350,700,150,30);
	start.addActionListener(this);
	start.setBackground(Color.RED);
	
	this.add(start);
	
	p1.setBounds(0,40,800,400);
	p1.setBackground(Color.BLACK);
	p1.setLayout(new GridLayout(4,4));
	this.add(p1);
	
	b1=new JButton();
	frame.photo(b1,Game.getAvailableChampions().get(0).getName());
	b1.addActionListener(this);
	b1.setToolTipText(frame.cinfo(0));
	
	
	b2=new JButton();
	frame.photo(b2,Game.getAvailableChampions().get(1).getName());
	b2.addActionListener(this);
	b2.setToolTipText(frame.cinfo(1));
	
	b3=new JButton();
	frame.photo(b3,Game.getAvailableChampions().get(2).getName());
	b3.addActionListener(this);
	b3.setToolTipText(frame.cinfo(2));
	
	
	b4=new JButton();
	frame.photo(b4,Game.getAvailableChampions().get(3).getName());
	b4.addActionListener(this);
	b4.setToolTipText(frame.cinfo(3));
	
	
	
	b5=new JButton();
	frame.photo(b5,Game.getAvailableChampions().get(4).getName());
	b5.addActionListener(this);
	b5.setToolTipText(frame.cinfo(4));
	
	
	b6=new JButton();
	frame.photo(b6,Game.getAvailableChampions().get(5).getName());
	b6.addActionListener(this);
	b6.setToolTipText(frame.cinfo(5));
	
	
	b7=new JButton();
	frame.photo(b7,Game.getAvailableChampions().get(6).getName());
	b7.addActionListener(this);
	b7.setToolTipText(frame.cinfo(6));
	
	
	b8=new JButton();
	frame.photo(b8,Game.getAvailableChampions().get(7).getName());
	b8.addActionListener(this);
	b8.setToolTipText(frame.cinfo(7));
	
	
	b9=new JButton();
	frame.photo(b9,Game.getAvailableChampions().get(8).getName());
	b9.addActionListener(this);
	b9.setToolTipText(frame.cinfo(8));
	
	b10=new JButton();
	frame.photo(b10,Game.getAvailableChampions().get(9).getName());
	b10.addActionListener(this);
	b10.setToolTipText(frame.cinfo(9));
	
	b11=new JButton();
	frame.photo(b11,Game.getAvailableChampions().get(10).getName());
	b11.addActionListener(this);
	b11.setToolTipText(frame.cinfo(10));
	
	b12=new JButton();
	frame.photo(b12,Game.getAvailableChampions().get(11).getName());
	b12.addActionListener(this);
	b12.setToolTipText(frame.cinfo(11));
	
	b13=new JButton();
	frame.photo(b13,Game.getAvailableChampions().get(12).getName());
	b13.addActionListener(this);
	b13.setToolTipText(frame.cinfo(12));
	
	b14=new JButton();
	frame.photo(b14,Game.getAvailableChampions().get(13).getName());
	b14.addActionListener(this);
	b14.setToolTipText(frame.cinfo(13));
	
	b15=new JButton();
	frame.photo(b15,Game.getAvailableChampions().get(14).getName());
	b15.addActionListener(this);
	b15.setToolTipText(frame.cinfo(14));
	
	
	
	
	
	p1.add(b1);
	p1.add(b2);
	p1.add(b3);
	p1.add(b4);
	p1.add(b5);
	p1.add(b6);
	p1.add(b7);
	p1.add(b8);
	p1.add(b9);
	p1.add(b10);
	p1.add(b11);
	p1.add(b12);
	p1.add(b13);
	p1.add(b14);
	p1.add(b15);
	
	
	
	
	
}

	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1){
			
			info.setText(frame.cinfo(0));
			
			a1.add(Game.getAvailableChampions().get(0).getName());
			String s1=new String();
			String s2=new String();
			for(int i=0;i<a1.size();i++) {
				s1=s1+a1.get(i)+"\n";
			}
			if(x<3)
			choosec1.setText(s1);
			else {
				for(int i=3;i<a1.size();i++) {
					s2=s2+a1.get(i)+"\n";
				}
				choosec2.setText(s2);
			}
			x++;
		}
		
		
		else if(e.getSource()==b2){
info.setText(frame.cinfo(1));
			
			a1.add(Game.getAvailableChampions().get(1).getName());
			String s1=new String();
			String s2=new String();
			for(int i=0;i<a1.size();i++) {
				s1=s1+a1.get(i)+"\n";
			}
			if(x<3)
			choosec1.setText(s1);
			else {
				for(int i=3;i<a1.size();i++) {
					s2=s2+a1.get(i)+"\n";
				}
				choosec2.setText(s2);
			}
			x++;
		
		}
		
		
		else if(e.getSource()==b3){
			
info.setText(frame.cinfo(2));
			
			a1.add(Game.getAvailableChampions().get(2).getName());
			String s1=new String();
			String s2=new String();
			for(int i=0;i<a1.size();i++) {
				s1=s1+a1.get(i)+"\n";
			}
			if(x<3)
			choosec1.setText(s1);
			else {
				for(int i=3;i<a1.size();i++) {
					s2=s2+a1.get(i)+"\n";
				}
				choosec2.setText(s2);
			}
			x++;
		}
		
		
		else if(e.getSource()==b4){
info.setText(frame.cinfo(3));
			
			a1.add(Game.getAvailableChampions().get(3).getName());
			String s1=new String();
			String s2=new String();
			for(int i=0;i<a1.size();i++) {
				s1=s1+a1.get(i)+"\n";
			}
			if(x<3)
			choosec1.setText(s1);
			else {
				for(int i=3;i<a1.size();i++) {
					s2=s2+a1.get(i)+"\n";
				}
				choosec2.setText(s2);
			}
			x++;
		}
		
		
		
		else if(e.getSource()==b5){
			
info.setText(frame.cinfo(4));
			
			a1.add(Game.getAvailableChampions().get(4).getName());
			String s1=new String();
			String s2=new String();
			for(int i=0;i<a1.size();i++) {
				s1=s1+a1.get(i)+"\n";
			}
			if(x<3)
			choosec1.setText(s1);
			else {
				for(int i=3;i<a1.size();i++) {
					s2=s2+a1.get(i)+"\n";
				}
				choosec2.setText(s2);
			}
			x++;
		}
		
		
		
		else if(e.getSource()==b6){
info.setText(frame.cinfo(5));
			
			a1.add(Game.getAvailableChampions().get(5).getName());
			String s1=new String();
			String s2=new String();
			for(int i=0;i<a1.size();i++) {
				s1=s1+a1.get(i)+"\n";
			}
			if(x<3)
			choosec1.setText(s1);
			else {
				for(int i=3;i<a1.size();i++) {
					s2=s2+a1.get(i)+"\n";
				}
				choosec2.setText(s2);
			}
			x++;
		}
		
		
		else if(e.getSource()==b7){
			
info.setText(frame.cinfo(6));
			
			a1.add(Game.getAvailableChampions().get(6).getName());
			String s1=new String();
			String s2=new String();
			for(int i=0;i<a1.size();i++) {
				s1=s1+a1.get(i)+"\n";
			}
			if(x<3)
			choosec1.setText(s1);
			else {
				for(int i=3;i<a1.size();i++) {
					s2=s2+a1.get(i)+"\n";
				}
				choosec2.setText(s2);
			}
			x++;
		}
		else if(e.getSource()==b8){
info.setText(frame.cinfo(7));
			
			a1.add(Game.getAvailableChampions().get(7).getName());
			String s1=new String();
			String s2=new String();
			for(int i=0;i<a1.size();i++) {
				s1=s1+a1.get(i)+"\n";
			}
			if(x<3)
			choosec1.setText(s1);
			else {
				for(int i=3;i<a1.size();i++) {
					s2=s2+a1.get(i)+"\n";
				}
				choosec2.setText(s2);
			}
			x++;
		}
		else if(e.getSource()==b9){
			
info.setText(frame.cinfo(8));
			
			a1.add(Game.getAvailableChampions().get(8).getName());
			String s1=new String();
			String s2=new String();
			for(int i=0;i<a1.size();i++) {
				s1=s1+a1.get(i)+"\n";
			}
			if(x<3)
			choosec1.setText(s1);
			else {
				for(int i=3;i<a1.size();i++) {
					s2=s2+a1.get(i)+"\n";
				}
				choosec2.setText(s2);
			}
			x++;
		}
		else if(e.getSource()==b10){
info.setText(frame.cinfo(9));
			
			a1.add(Game.getAvailableChampions().get(9).getName());
			String s1=new String();
			String s2=new String();
			for(int i=0;i<a1.size();i++) {
				s1=s1+a1.get(i)+"\n";
			}
			if(x<3)
			choosec1.setText(s1);
			else {
				for(int i=3;i<a1.size();i++) {
					s2=s2+a1.get(i)+"\n";
				}
				choosec2.setText(s2);
			}
			x++;
		}
         else if(e.getSource()==b11){
			
        	 info.setText(frame.cinfo(10));
 			
 			a1.add(Game.getAvailableChampions().get(10).getName());
 			String s1=new String();
 			String s2=new String();
 			for(int i=0;i<a1.size();i++) {
 				s1=s1+a1.get(i)+"\n";
 			}
 			if(x<3)
 			choosec1.setText(s1);
 			else {
 				for(int i=3;i<a1.size();i++) {
 					s2=s2+a1.get(i)+"\n";
 				}
 				choosec2.setText(s2);
 			}
 			x++;
 		}
		else if(e.getSource()==b12){
info.setText(frame.cinfo(11));
			
			a1.add(Game.getAvailableChampions().get(11).getName());
			String s1=new String();
			String s2=new String();
			for(int i=0;i<a1.size();i++) {
				s1=s1+a1.get(i)+"\n";
			}
			if(x<3)
			choosec1.setText(s1);
			else {
				for(int i=3;i<a1.size();i++) {
					s2=s2+a1.get(i)+"\n";
				}
				choosec2.setText(s2);
			}
			x++;
		}
		else if(e.getSource()==b13){
			
info.setText(frame.cinfo(12));
			
			a1.add(Game.getAvailableChampions().get(12).getName());
			String s1=new String();
			String s2=new String();
			for(int i=0;i<a1.size();i++) {
				s1=s1+a1.get(i)+"\n";
			}
			if(x<3)
			choosec1.setText(s1);
			else {
				for(int i=3;i<a1.size();i++) {
					s2=s2+a1.get(i)+"\n";
				}
				choosec2.setText(s2);
			}
			x++;
		}
		else if(e.getSource()==b14){
info.setText(frame.cinfo(13));
			
			a1.add(Game.getAvailableChampions().get(13).getName());
			String s1=new String();
			String s2=new String();
			for(int i=0;i<a1.size();i++) {
				s1=s1+a1.get(i)+"\n";
			}
			if(x<3)
			choosec1.setText(s1);
			else {
				for(int i=3;i<a1.size();i++) {
					s2=s2+a1.get(i)+"\n";
				}
				choosec2.setText(s2);
			}
			x++;
		}
		else if(e.getSource()==b15){
			info.setText(frame.cinfo(14));
						
						a1.add(Game.getAvailableChampions().get(14).getName());
						String s1=new String();
						String s2=new String();
						for(int i=0;i<a1.size();i++) {
							s1=s1+a1.get(i)+"\n";
						}
						if(x<3)
						choosec1.setText(s1);
						else {
							for(int i=3;i<a1.size();i++) {
								s2=s2+a1.get(i)+"\n";
							}
							choosec2.setText(s2);
						}
						x++;
					}
		else if(e.getSource()==start) {
			boolean f=true;
			if(a1.size()!=6) {
				JOptionPane.showMessageDialog(this,"Player 1 must select 3 champions and player 2 must select 3 champions", "Erorr", JOptionPane.ERROR_MESSAGE);	
				a1.clear();
				choosec1.setText(null);
				choosec2.setText(null);
				x=0;
				f=false;
			}
			
			
					
			for(int i=0;i<a1.size();i++) {
				
				for(int j=i+1;j<a1.size();j++) {
					if(a1.get(i)==a1.get(j)) {
						JOptionPane.showMessageDialog(this,"selected champions must be different", "Erorr", JOptionPane.ERROR_MESSAGE);
						a1.clear();
						choosec1.setText(null);
						choosec2.setText(null);
						x=0;
						f=false;
						return;
				}}
				
			}
			if(f==true){
				
				frame.switchleader(a1.get(0),a1.get(1),a1.get(2),a1.get(3),a1.get(4),a1.get(5));
			}
		}
	}

}
