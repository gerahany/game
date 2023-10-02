package quiz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import engine.Game;

public class quiz  extends JFrame implements ActionListener{
private Game game;
private JButton b1;
private JButton b2;
private JButton b3;
private int i;
private int z;
private int t;
private String s1;
private String s2;
private String s3;
private int i1;
private int i2;
private int i3;

	public quiz() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.game=game;
		this.setSize(800,800);
		this.setVisible(true);
		this.setLayout(new GridLayout(3,1));
		try {
			Game.loadAbilities("Abilities.csv");
			Game.loadChampions("Champions.csv");
			
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 i=(int) (Math.random()*15);
		 z=(int) (Math.random()*15);
		 t=(int) (Math.random()*15);
		b1=new JButton( );
		s1=game.getAvailableChampions().get(i).getName();
		i1 =game.getAvailableChampions().get(i).getCurrentHP();
		b1.setText(game.getAvailableChampions().get(i).getName() + "\n"+ "  " + game.getAvailableChampions().get(i).getCurrentHP());
					
		
		
		b1.addActionListener(this);
		
		this.add(b1);
		s2=game.getAvailableChampions().get(z).getName();
		b2=new JButton();
		i2= game.getAvailableChampions().get(z).getCurrentHP();
		b2.setText(game.getAvailableChampions().get(z).getName() + "\n"+ "  " + game.getAvailableChampions().get(z).getCurrentHP());
		b2.addActionListener(this);
		
		this.add(b2);
		b3=new JButton();
		s3=game.getAvailableChampions().get(t).getName();
		i3=game.getAvailableChampions().get(t).getCurrentHP();
		b3.setText(game.getAvailableChampions().get(t).getName() + "\n"+ "  " + game.getAvailableChampions().get(t).getCurrentHP());
		b3.addActionListener(this);
		
		this.add(b3);
		this.validate();
		this.repaint();
}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1) {
			if(i1<500 ) {
				i1=0;
				b1.setText(s1+ "  " +  i1  ); 
			}
				
			if(i1>=500) {
				i1=i1-500;
				b1.setText(s1+ "  " +  i1  ); 
		
		}}
		else if(e.getSource()==b2) {
			if(i2<500 ) {
				i2=0;
				b2.setText(s2+ "  " +  i2  ); 
			}
			if(i2>=500) {
				i2=i2-500;
				b2.setText(s2+ "  " +  i2  );  
		
		}}
		else if(e.getSource()==b3) {
			if(i3<500 ) {
				i3=0;
				b3.setText(s3+ "  " +  i3  ); 
			}
			if(i3>=500) {
			i3=i3-500;
			b3.setText(s3+ "  " +  i3  ); 
		
		}}
		
		
		
	}
	public static void main(String[] args) {
		new quiz();
	}
	

}
