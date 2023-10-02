package quiz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import model.abilities.Ability;
import model.world.Champion;
import engine.Game;
import engine.Player;
import model.world.Cover;

public class Quiz7 extends JFrame implements ActionListener {
	
	private Game game;
	//private JButton[] buttons;
	//engine.PriorityQueue q=new  engine.PriorityQueue(6);
	private JButton get1;
	//private JPanel p1;
	private JTextArea t;
	private JTextArea t2;
	private JPanel p1;
	private JButton[][] buttons;
	public Quiz7() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
		try {
			Game.loadAbilities("Abilities.csv");
			Game.loadChampions("Champions.csv");

			Player p1 = new Player("H");
			p1.getTeam().add(Game.getAvailableChampions().get(0));
			p1.getTeam().add(Game.getAvailableChampions().get(1));
			p1.getTeam().add(Game.getAvailableChampions().get(2));

			Player p2 = new Player("HA");
			p2.getTeam().add(Game.getAvailableChampions().get(3));
			p2.getTeam().add(Game.getAvailableChampions().get(4));
			p2.getTeam().add(Game.getAvailableChampions().get(5));

			game = new Game(p1, p2);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p1=new JPanel();
		p1.setLayout(new GridLayout(5, 5));
     	//p1.setBounds(20, 20, 400, 350);
     	 this.add(p1, BorderLayout.CENTER);
		//p1.setBackground(Color.BLACK);
		//this.getContentPane().add(p1);
		
		buttons = new JButton[5][5];
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				buttons[i][j] = new JButton();
				if (game.getBoard()[i][j] == null) {
					buttons[i][j].setBackground(Color.white);
				} else if (game.getBoard()[i][j] instanceof Cover) {
					buttons[i][j].setBackground(Color.BLACK);
				} else {
					if (game.getBoard()[i][j] == game.getCurrentChampion()) {
						buttons[i][j].setBackground(Color.GREEN);
					}
				}
				p1.add(buttons[i][j]);
			}
		}
		
		
		t=new JTextArea();
		t.setSize(200,100);	
		t2=new JTextArea();
		t2.setSize(300,100);	
		String r ="";
		for (int i = 0; i < 15; i++) {
			r=r+Game.getAvailableChampions().get(i).getName()+"\n";
			
		}
		t.setText(r);
		this.add(t, BorderLayout.WEST);
		String z ="";
		for (int i = 0; i < 45; i++) {
			z=z+Game.getAvailableAbilities().get(i).getName()+"\n";
			
		}
		t2.setText(z);
		this.add(t2, BorderLayout.EAST);
		//this.add(p1, BorderLayout.CENTER);
		
		//this.getContentPane().setLayout(new BorderLayout());
		this.setSize(1000, 800);
		this.setVisible(true);
		
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		Quiz7 q = new Quiz7();
	}
}