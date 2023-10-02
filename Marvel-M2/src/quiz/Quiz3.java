package quiz;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import engine.Game;
import engine.Player;
import model.world.Champion;


public class Quiz3 extends JFrame
{	
	JPanel pnl;
	JButton bt1;
	JButton bt2;
	JButton bt3;
	JButton bt4;
	Champion c ;
	int r;
	ArrayList<Champion> ac;
	public Quiz3() throws IOException
	{
		r =0;
		
		setLayout(new GridLayout(2,1));
		Game.loadAbilities("Abilities.csv");
		Game.loadChampions("Champions.csv");
		ac = Game.getAvailableChampions();
		int x  = (int) (Math.random() * 15);
		c = Game.getAvailableChampions().get(x);
		pnl = new JPanel();
		bt1 = new JButton();
		bt1.setBackground(Color.red);
		bt1.setText(c.getName());
		bt2 = new JButton();
		bt2.setBackground(Color.GREEN);
		bt3 = new JButton();
		bt3.setBackground(Color.blue);
		bt4 = new JButton();
		bt4.setBackground(Color.yellow);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		pnl.setLayout(new GridLayout(0,3));
		
		
		
		
		
		
		pnl.add(bt2);
		pnl.add(bt3);
		pnl.add(bt4);
		
		add(bt1);
		add(pnl);
		
		bt1.addActionListener(new ActionListener() 
		{
			public void actionPerformed (ActionEvent e)
			{
				if(r==0)
				{
					bt2.setText(c.getAbilities().get(0).getName());
					r++;
				}
				else if(r==1)
				{
					bt3.setText(c.getAbilities().get(1).getName());
					r++;
					
				}
				else if(r==2)
				{
					bt4.setText(c.getAbilities().get(2).getName());
					r++;
				}
				else if(r==3)
				{
					int x  = (int) (Math.random() * 15);
					c = ac.get(x);
					bt1.setText(c.getName());
					bt2.setText("");
					bt3.setText("");
					bt4.setText("");
					r=0;
					
				}
				
			}
		});
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.revalidate();
		this.repaint();
		setVisible(true);
		
	}
	
	public static void main(String[] args) throws IOException 
	{
		new Quiz3();
	}
}