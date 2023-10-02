package gui;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import engine.Game;
import engine.Player;
import model.world.Champion;
import model.world.Cover;


public class Frame  extends JFrame{
	private PlayerNames pnp;
	private String pn1;
	private String pn2;
	private chooseL clp;
	private Game game;
	private leader lead;
	private String c1;
	private String c2;
	private String c3;
	private String c4;
	private String c5;
	private String c6;
	private boardp bp;
	private Player t1;
	private Player t2;
	private end send;
	
	
	
	public Frame() {
		
		this.game=game;
		pnp=new PlayerNames(this);
		this.getContentPane().add(pnp);
		this.setSize(800,800);
		this.setVisible(true);
		this.setTitle("marvel");
		ImageIcon img = new ImageIcon(   ("icon.png"));
		this.setIconImage(img.getImage());
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		   
	}
	public void switchPanel(String name1, String name2)  {
		this.pn1=name1;
		this.pn2=name2;
		
		
		
		try {
			Game.loadAbilities("Abilities.csv");
			Game.loadChampions("Champions.csv");
			this.setSize(800, 800);
			this.getContentPane().remove(pnp);
			
			clp=new chooseL(this);
			this.getContentPane().add(clp);
		}
		catch(IOException e) {
			
			e.printStackTrace();
		}
		
		this.validate();
		this.repaint();
		
	}
//	public String[] getChampion() {
//		ArrayList<Champion> list=Game.getAvailableChampions();
//		String[]r= new String[list.size()];
//		for(int i=0;i<list.size();i++)
//			r[i]=list.get(i).getName();
//		return r;
//	}
	
	public  String cinfo(int i) {
		
		Champion c =Game.getAvailableChampions().get(i);
		String s= " Name: " + c.getName() +"\n" + " Attack: " + c.getAttackDamage() +"\n"
				+" Range: " + c.getAttackRange() + "\n" + " Health : " + c.getCurrentHP() 
				+ "\n" + " Mana : " + c.getMana() + "\n" + " Abilities : " + "\n";
		for (int n=0;n<c.getAbilities().size();n++) {
			s=s + (n+1) + ")" + c.getAbilities().get(n).getName() + "\n";
		}
		
		return s;
		
	}
	public void switchleader (String s1, String s2,String s3,String s4,String s5,String s6) {
		this.c1=s1;
		this.c2=s2;
		this.c3=s3;
		this.c4=s4;
		this.c5=s5;
		this.c6=s6;
		
this.getContentPane().remove(clp);
lead=new leader(this,s1,s2,s3,s4,s5,s6);
this.getContentPane().add(lead);
this.validate();
this.repaint();
	}
	public void photo(JButton b, String s) {
		if(s.equals("Captain America"))
			b.setIcon(new ImageIcon("caption america.jpg"));
		else if(s.equals("Deadpool"))
			b.setIcon(new ImageIcon("deadpool.jpg"));
		else if(s.equals("Dr Strange"))
			b.setIcon(new ImageIcon("dr-strange.jpg"));
		else if(s.equals("Electro"))
			b.setIcon(new ImageIcon(   ("electro.jpg")));
		else if(s.equals("Ghost Rider"))
			b.setIcon(new ImageIcon(   ("ghost rider.jpg")));
		else if(s.equals("Hela"))
			b.setIcon(new ImageIcon(   ("hela.jpg")));
		else if(s.equals("Hulk"))
			b.setIcon(new ImageIcon(   ("hulk.jpg")));
		else if(s.equals("Iceman"))
			b.setIcon(new ImageIcon(   ("iceman.jpg")));
		else if(s.equals("Ironman"))
			b.setIcon(new ImageIcon(   ("ironman.jpg")));
		else if(s.equals("Loki"))
			b.setIcon(new ImageIcon(   ("loki.jpg")));
		else if(s.equals("Quicksilver"))
			b.setIcon(new ImageIcon(   ("quicksilver.png")));
		else if(s.equals("Spiderman"))
			b.setIcon(new ImageIcon(   ("spiderman.jpg")));
		else if(s.equals("Thor"))
			b.setIcon(new ImageIcon(   ("thor.jpg")));
		else if(s.equals("Thor"))
			b.setIcon(new ImageIcon(   ("thor.jpg")));
		else if(s.equals("Venom"))
			b.setIcon(new ImageIcon(   ("venom.jpg")));
		else if(s.equals("Yellow Jacket"))
			b.setIcon(new ImageIcon(   ("yellowjacket.jpg")));
		
		
		
		
		
	}
	public void sboardp(String l1, String l2) {
		this.getContentPane().remove(lead);
		 t1=new Player(pn1);
		t2=new Player(pn1);
		
		for (int i=0;i<Game.getAvailableChampions().size();i++) {
			if(c1.equals(Game.getAvailableChampions().get(i).getName()))
				t1.getTeam().add(Game.getAvailableChampions().get(i));
			if(c2.equals(Game.getAvailableChampions().get(i).getName()))
				t1.getTeam().add(Game.getAvailableChampions().get(i));
			if(c3.equals(Game.getAvailableChampions().get(i).getName()))
				t1.getTeam().add(Game.getAvailableChampions().get(i));
			if(c4.equals(Game.getAvailableChampions().get(i).getName()))
				t2.getTeam().add(Game.getAvailableChampions().get(i));
			if(c5.equals(Game.getAvailableChampions().get(i).getName()))
				t2.getTeam().add(Game.getAvailableChampions().get(i));
			if(c6.equals(Game.getAvailableChampions().get(i).getName()))
				t2.getTeam().add(Game.getAvailableChampions().get(i));
			if(l1.equals(Game.getAvailableChampions().get(i).getName()))
				t1.setLeader(Game.getAvailableChampions().get(i));
			if(l2.equals(Game.getAvailableChampions().get(i).getName()))
				t2.setLeader(Game.getAvailableChampions().get(i));
				
		}
		
		game=new Game (t1,t2);
		bp=new boardp (this,pn1,pn2,c1,c2,c3,c4,c5,c6,l1,l2);
		this.getContentPane().add(bp);
		this.validate();
		this.repaint();
		
		
	}
	public void enddd(String s) {
		this.getContentPane().remove(bp);
		send=new end(s);
		this.getContentPane().add(send);
		this.validate();
		this.repaint();
		
	}
	
	public Game getGame() {
		return game;
	}
	public static void main(String[] args) {
		
		Frame f=new Frame();
		
		
		 
		 
		
		
	}

}
