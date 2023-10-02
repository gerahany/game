package quiz;



import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import engine.Game;
import model.abilities.Ability;
import model.world.Champion;

public class highlight extends JFrame implements ActionListener {

	private JButton get1;

	private JPanel p1;
	private JButton[] buttons;

	private JButton get2;

	private JPanel p2;
	private JButton[] buttons2;

	public highlight() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		try {
			Game.loadAbilities("Abilities.csv");
			Game.loadChampions("Champions.csv");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		get1 = new JButton("Get1");
		get1.setBounds(20, 400, 100, 25);
		get1.addActionListener(this);
		this.getContentPane().add(get1);

		p1 = new JPanel();
		p1.setLayout(new GridLayout(3, 5));
		p1.setBounds(20, 20, 400, 350);
		p1.setBackground(Color.BLACK);
		this.getContentPane().add(p1);

		buttons = new JButton[15];
		for (int i = 0; i < 15; i++) {
			buttons[i] = new JButton("");
			buttons[i].addActionListener(this);
			p1.add(buttons[i]);
		}

		get2 = new JButton("Get2");
		get2.setBounds(500, 400, 100, 25);
		get2.addActionListener(this);
		this.getContentPane().add(get2);

		p2 = new JPanel();
		p2.setBounds(500, 20, 400, 350);
		p2.setBackground(Color.BLACK);
		this.getContentPane().add(p2);

		buttons2 = new JButton[45];
		for (int i = 0; i < 45; i++) {
			buttons2[i] = new JButton("");
			p2.add(buttons2[i]);
		}

		this.getContentPane().setLayout(null);
		this.setSize(1000, 500);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == get1) {
			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				Champion c = Game.getAvailableChampions().get(i);

				buttons[i].setText(c.getName());
			}
			p1.validate();
			p1.repaint();

		} else if (e.getSource() == get2) {
			for (int i = 0; i < Game.getAvailableAbilities().size(); i++) {
				Ability c = Game.getAvailableAbilities().get(i);

				buttons2[i].setText(c.getName());

			}
			p2.validate();
			p2.repaint();

		} else {
			for (int i = 0; i < buttons.length; i++) {
				if (e.getSource() == buttons[i]) {
					Champion c = Game.getAvailableChampions().get(i);

					for (int k = 0; k < buttons2.length; k++) {

						buttons2[k].setBackground(Color.WHITE);

					}

					for (int j = 0; j < c.getAbilities().size(); j++) {
						Ability a = c.getAbilities().get(j);

						for (int k = 0; k < buttons2.length; k++) {
							if (buttons2[k].getText().equals(a.getName())) {
								buttons2[k].setBackground(Color.GRAY);
							}
						}
					}

				}
			}

		}

	}

	public static void main(String[] args) {
		highlight q = new highlight ();
	}

}