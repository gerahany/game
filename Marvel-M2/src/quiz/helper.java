package quiz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import engine.Game;
import engine.Player;
import gui.PlayerNames;

public class helper extends JFrame implements ActionListener{
	private Game game;
	private JButton b1;
	private JLabel l;
	private JButton[] b2;
	private JButton[][] b3;
	private JLabel L;
	 private JTextArea ta;
	public helper() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.game=game;
		this.setSize(800,800);
		this.setVisible(true);
		this.setLayout(new GridLayout(2,2));
		
		
		b1=new JButton();
		b1.setBounds(50, 50, 200, 150);
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		this.add(b1);
		
		try {
			Game.loadAbilities("Abilities.csv");
			Game.loadChampions("Champions.csv");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Player p1 = new Player("H");
		p1.getTeam().add(Game.getAvailableChampions().get(0));
		p1.getTeam().add(Game.getAvailableChampions().get(1));
		p1.getTeam().add(Game.getAvailableChampions().get(2));

		Player p2 = new Player("HA");
		p2.getTeam().add(Game.getAvailableChampions().get(3));
		p2.getTeam().add(Game.getAvailableChampions().get(4));
		p2.getTeam().add(Game.getAvailableChampions().get(5));

		game = new Game(p1, p2);
		
		
		b2 = new JButton[15];
		for (int i = 0; i < 15; i++) {
			b2[i] = new JButton("");
			this.add(b2[i]);
			
		}
		for(int i=0;i<5;i++){
			for(int j=0; j<5; j++){
			b3[i][j]=new JButton();
			this.add(b3[i][j]);
			}}
		

		l=new JLabel("Champion info");
		l.setBounds(50,20,120,30);
		l.setForeground(Color.white);
		this.add(l);
		
		ta=new JTextArea();
		ta.setEditable(false);
		ta.setBounds(20,60,150,100);
		JScrollPane in=new JScrollPane(ta);
		in.setBounds(20,60,150,150);
		this.add(in);
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new helper();
	}
	

}
