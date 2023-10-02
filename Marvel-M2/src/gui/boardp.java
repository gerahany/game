package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import engine.Game;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.abilities.Ability;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Cover;
import model.world.Direction;
import model.world.Hero;
import model.world.Villain;

public class boardp extends JPanel implements ActionListener{
private Frame frame;
private JPanel p1;
private JButton[][] b1;

private JLabel name1;
private JButton aup;
private JButton adown;
private JButton aright;
private JButton aleft;
private JButton mup;
private JButton mdown;
private JButton mright;
private JButton mleft;

private JPanel p2;
private JButton endturn;
private JTextArea currentchamp;
private String n1;
private String n2;
private JLabel l;
private JLabel attack; 
private JLabel move;


private JLabel info;
private JTextArea infotext;

private JLabel turn;
private JTextArea turntext;
private JButton cup;
private JButton cdown;
private JButton cright;
private JButton cleft;
private JButton team;

private JComboBox<String> x;
private JComboBox<String> y;
private JButton cast;

private JButton la;
private JComboBox<String> chooseab;
private Ability ability;
private JLabel chooseability;



public boardp(Frame frame, String n1, String n2, String c1,String c2,String c3,String c4,String c5,String c6,String l1,String l2) {
	this.n1=n1;
	this.n2=n2;
	this.frame=frame;
	this.setLayout(null);
	this.setBackground(Color.BLACK);
	p1=new JPanel();
	p1.setBounds(200,40,400,400);
	p1.setLayout(new GridLayout(5,5));
	this.add(p1);
	name1= new JLabel ("Player1: " + n1 + "       Player2: " + n2);
	name1.setForeground(Color.GREEN);
	name1.setBackground(Color.BLACK);
	name1.setBounds(300,0,300,30);
	this.add(name1);
	
	
	b1=new JButton[5][5];
	for(int i=0;i<b1.length;i++) {
		for(int j=0;j<b1.length;j++) {
			b1[i][j]=new JButton();
			b1[i][j].addActionListener(this);
			p1.add(b1[i][j]);
		}
	}
		
	
	
	
	
	
	
	aup=new JButton ();
	aup.setIcon(new ImageIcon(("up.jpg")));
	aup.setBackground(Color.BLACK);
	aup.addActionListener(this);
	aup.setBounds(100,550,50,50);
	this.add(aup);
	
	adown=new JButton ();
	adown.setIcon(new ImageIcon( ("down.jpg")));
	adown.setBackground(Color.BLACK);
	adown.addActionListener(this);
	adown.setBounds(100,600,50,50);
	this.add(adown);
	
	aleft=new JButton ();
	aleft.setIcon(new ImageIcon( ("left.jpg")));
	aleft.setBackground(Color.BLACK);
	aleft.addActionListener(this);
	aleft.setBounds(50,570,50,50);
	this.add(aleft);
	
	aright=new JButton ();
	aright.setIcon(new ImageIcon( ("right.jpg")));
	aright.setBackground(Color.BLACK);
	aright.addActionListener(this);
	aright.setBounds(150,570,50,50);
	this.add(aright);
	
	mup=new JButton ();
	mup.setIcon(new ImageIcon( ("up.jpg")));
	mup.setBackground(Color.BLACK);
	mup.addActionListener(this);
	mup.setBounds(600,550,50,50);
	this.add(mup);
	
	mdown=new JButton ();
	mdown.setIcon(new ImageIcon( ("down.jpg")));
	mdown.setBackground(Color.BLACK);
	mdown.addActionListener(this);
	mdown.setBounds(600,600,50,50);
	this.add(mdown);
	
	mleft=new JButton ();
	mleft.setIcon(new ImageIcon( ("left.jpg")));
	mleft.setBackground(Color.BLACK);
	mleft.addActionListener(this);
	mleft.setBounds(550,570,50,50);
	this.add(mleft);
	
	mright=new JButton ();
	mright.setIcon(new ImageIcon( ("right.jpg")));
	mright.setBackground(Color.BLACK);
	mright.addActionListener(this);
	mright.setBounds(650,570,50,50);
	this.add(mright);
	 
	p2=new JPanel();
	p2.setBounds(230,450,300,300);
	p2.setLayout(null);
	this.add(p2);
	p2.setBackground(Color.BLACK);
	
	currentchamp=new JTextArea();
	currentchamp.setEditable(false);
	currentchamp.setBackground(Color.black);
	currentchamp.setForeground(Color.yellow);
	currentchamp.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
	JScrollPane sp=new JScrollPane(currentchamp);
	sp.setBounds(0,0,300,240);
	p2.add(sp);
	
	endturn =new JButton("end turn");
	endturn.setBounds(90, 250,100, 30);
	endturn.addActionListener(this);
	p2.add(endturn);
	
	 l=new JLabel();
	
	attack=new JLabel("attack");
	attack.setForeground(Color.red);
	attack.setBackground(Color.BLACK);
	attack.setBounds(95,650,120,30);
	attack.setFont(new Font("Arial",Font.BOLD,25));
	this.add(attack);
	
	move=new JLabel("move");
	move.setForeground(Color.red);
	move.setBackground(Color.BLACK);
	move.setBounds(600,650,120,30);
	move.setFont(new Font("Arial",Font.BOLD,25));
	this.add(move);
	
	info=new JLabel("Champion info");
	info.setBounds(50,20,120,30);
	info.setForeground(Color.yellow);
	this.add(info);
	
	infotext=new JTextArea();
	infotext.setEditable(false);
	infotext.setBounds(20,60,150,100);
	infotext.setBackground(Color.black);
	infotext.setForeground(Color.yellow);
	infotext.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
	JScrollPane in=new JScrollPane(infotext);
	in.setBounds(20,60,150,150);
	this.add(in);
	
	turn=new JLabel("turns");
	turn.setBounds(70,250,120,30);
	turn.setForeground(Color.yellow);
	this.add(turn);
	
	String t="";
	ArrayList<Champion> at=new ArrayList<Champion>();
	
	
	
	while(!frame.getGame().getTurnOrder().isEmpty()) {
		at.add((Champion) frame.getGame().getTurnOrder().peekMin());
		t=t+ ((Champion)frame.getGame().getTurnOrder().peekMin()).getName()+ "\n";
		frame.getGame().getTurnOrder().remove();
	}
	for(int i=0;i<at.size();i++) {
		frame.getGame().getTurnOrder().insert(at.get(i));
	}

	turntext=new JTextArea();
	turntext.setEditable(false);
	turntext.setBounds(20,295,150,100);
	turntext.setBackground(Color.black);
	turntext.setForeground(Color.yellow);
	turntext.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
	turntext.setText(t);
	this.add(turntext);
	
	chooseability=new JLabel("choose ability");
	chooseability.setBounds(670,20,120,50);
	chooseability.setForeground(Color.red);
	this.add(chooseability);
	
	cup=new JButton ();
	cup.setIcon(new ImageIcon( ("up.jpg")));
	cup.setBackground(Color.BLACK);
	cup.addActionListener(this);
	cup.setBounds(670,120,50,50);
	this.add(cup);
	
	cdown=new JButton ();
	cdown.setIcon(new ImageIcon( ("down.jpg")));
	cdown.setBackground(Color.BLACK);
	cdown.addActionListener(this);
	cdown.setBounds(670,170,50,50);
	this.add(cdown);
	
	cleft=new JButton ();
	cleft.setIcon(new ImageIcon( ("left.jpg")));
	cleft.setBackground(Color.BLACK);
	cleft.addActionListener(this);
	cleft.setBounds(620,127,50,50);
	this.add(cleft);
	
	cright=new JButton ();
	cright.setIcon(new ImageIcon( ("right.jpg")));
	cright.setBackground(Color.BLACK);
	cright.addActionListener(this);
	cright.setBounds(720,127,50,50);
	this.add(cright);
	team=new JButton ("cast");
	team.setForeground(Color.black);
	team.setBackground(Color.red);
	team.addActionListener(this);
	team.setBounds(620,240,120,50);
	this.add(team);
	;
	String[]n= {"1","2","3","4","5"};
	x=new JComboBox(n);
	x.setBounds(620,295,50, 25);
	this.add(x);
	
	y=new JComboBox(n);
	y.setBounds(675,295,50, 25);
	this.add(y);
	
	cast=new JButton ("Cast index");
	cast.setForeground(Color.black);
	cast.setBackground(Color.red);
	cast.addActionListener(this);
	cast.setBounds(620,330,120,50);
	this.add(cast);
	la=new JButton ("Leader Ability");
	la.setForeground(Color.black);
	la.setBackground(Color.red);
	la.addActionListener(this);
	la.setBounds(620,390,120,50);
	this.add(la);
		
	chooseab=new JComboBox();
	chooseab.setBounds(620,80,100, 25);
	this.add(chooseab);

	win();
	makeboard();
	currentchamp.setText(champinfo());
	makeability();
	
}
public void makeability() {
	chooseab.removeAllItems();
	for(int i=0;i<frame.getGame().getCurrentChampion().getAbilities().size();i++) {
		chooseab.addItem(frame.getGame().getCurrentChampion().getAbilities().get(i).getName());
	}
}


public String makeinfo(Champion c) {
	String s= "name: " +c.getName() + "\n" + "Health: " + c.getCurrentHP() + "\n"
			+ "Mana: " + c.getMana() + "\n" + "speed: " + c.getSpeed() + "\n" + "Max action points: " + 
			c.getMaxActionPointsPerTurn() +"\n" + "Attack Damage: " + c.getAttackDamage() +"\n"+ "Attack raneg:" + c.getAttackRange() +
			"\n" + " Type: ";
  if(c instanceof Hero)
  s=s + "Hero" + "\n";
  if(c instanceof Villain)
  s=s + "Villain" + "\n";
  if(c instanceof AntiHero)
  s=s + "AntiHero" + "\n";
   
   s=s+ "leader or not: ";
   
   if(c.getName()==frame.getGame().getFirstPlayer().getLeader().getName()|| c.getName()==frame.getGame().getSecondPlayer().getLeader().getName())
   s=s+ "True" + "\n";
   else
   s=s + "False" + "\n";
    
    s=s+ "Applied effects: " + "\n";
     for (int i=0; i<c.getAppliedEffects().size(); i++){
     s=s + "Name: " + c.getAppliedEffects().get(i).getName()+ "\n" +
     "Durartion: " + c.getAppliedEffects().get(i).getDuration() + "\n";
     }
   this.validate();
   this.repaint();
  return s;
  
  
	
	
}
public void makeboard() {
	for(int i=0;i<5;i++) {
		for(int j=0;j<5;j++) {
			
			if(frame.getGame().getBoard()[i][j] instanceof Cover) {
				 l=new JLabel();
				l.setText(((Cover)frame.getGame().getBoard()[i][j]).getCurrentHP()+"");
				l.setFont(new Font("Arial",Font.BOLD,20));
				b1[i][j].setIcon(new ImageIcon( ("wall.jpg")));
			b1[i][j].setForeground(Color.green);
			b1[i][j].add(l);
			}
			else if(frame.getGame().getBoard()[i][j] instanceof Champion) {
				frame.photo(b1[i][j],((Champion)frame.getGame().getBoard()[i][j]).getName() );
				
				if((Champion)frame.getGame().getBoard()[i][j]==frame.getGame().getCurrentChampion()) {
					
					
					b1[i][j].setBorder(BorderFactory.createLineBorder(Color.YELLOW));
					
				}
				else if(frame.getGame().getFirstPlayer().getTeam().contains((Champion)frame.getGame().getBoard()[i][j])) {
					
					b1[i][j].setBorder(BorderFactory.createLineBorder(Color.red));
					
				}
				else if(frame.getGame().getSecondPlayer().getTeam().contains((Champion)frame.getGame().getBoard()[i][j])) {
					
					b1[i][j].setBorder(BorderFactory.createLineBorder(Color.blue));
					
				}
				
			}
			else {
				b1[i][j].setIcon(new ImageIcon( ("null.jpg")));
				b1[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
			}
		}
	}
	this.validate();
	this.repaint();
	win();
}
public String champinfo() {
	String s="Player:   ";
	if(frame.getGame().getFirstPlayer().getTeam().contains(frame.getGame().getCurrentChampion()))
		s=s + n1 + "\n";
		else
			s=s+ n2 + "\n";
	s=s + "Name: " + frame.getGame().getCurrentChampion().getName() + "\n" + "Type: " + champtype(frame.getGame().getCurrentChampion()) +"\n" + "Range: " + frame.getGame().getCurrentChampion().getAttackRange() + "\n"
			+  "Attack:  " + frame.getGame().getCurrentChampion().getAttackDamage() + "\n" + "Health:  " + frame.getGame().getCurrentChampion().getCurrentHP() +
			"\n" + "Action Points: " + frame.getGame().getCurrentChampion().getCurrentActionPoints() + "\n" +"Mana: " + frame.getGame().getCurrentChampion().getMana() +
			"\n" +   "Attack Damage: " + frame.getGame().getCurrentChampion().getAttackDamage() + "\n" + "Attack Range: " + frame.getGame().getCurrentChampion().getAttackRange()+ "\n" 
+ "-----------"+"Abilities: " +  "\n" ;
	if(frame.getGame().getFirstPlayer().getTeam().contains(frame.getGame().getCurrentChampion()))
		s=s + "leader ability used: " +  frame.getGame().isFirstLeaderAbilityUsed() +"\n";
	else
		s=s+ "leader ability used: " +  frame.getGame().isSecondLeaderAbilityUsed() +"\n";
	
	for(int i=0;i<frame.getGame().getCurrentChampion().getAbilities().size();i++) {
		s=s + frame.getGame().getCurrentChampion().getAbilities().get(i).getName()+ "\n"
		 + "Mana Cost: " + frame.getGame().getCurrentChampion().getAbilities().get(i).getManaCost()+ "\n"
		 + " Current Cool Down: " + frame.getGame().getCurrentChampion().getAbilities().get(i).getCurrentCooldown()+ "\n"
		 + "Base Cool Down" + frame.getGame().getCurrentChampion().getAbilities().get(i).getBaseCooldown()+ "\n"
		 + "Action Points:" + frame.getGame().getCurrentChampion().getAbilities().get(i).getRequiredActionPoints()+ "\n"
		+ "Area of Effect" + frame.getGame().getCurrentChampion().getAbilities().get(i).getCastArea()+ "\n"
		 + "Cast Range" + frame.getGame().getCurrentChampion().getAbilities().get(i).getCastRange()+ "\n"
		 + "Type: " + type(frame.getGame().getCurrentChampion().getAbilities().get(i)) + "\n"
		
		 + "...."+ "\n";
		
		
	}
	s=s + "--------------"+ "\n";
	s=s + "Effects: " + "\n";
	for(int i=0;i<frame.getGame().getCurrentChampion().getAppliedEffects().size();i++) {
	s= s + "name" + frame.getGame().getCurrentChampion().getAppliedEffects().get(i).getName() + "\n"
	+ "Duration: " + frame.getGame().getCurrentChampion().getAppliedEffects().get(i).getDuration() + "\n"

	 + "...."+ "\n";}
	this.validate();
	this.repaint();
	return s;}
public String type (Ability a) {
	String s="";
	if(a instanceof HealingAbility)
		s="Healing Ability";
	else if(a instanceof DamagingAbility)
		s="Damaging Ability";
	else
		s="Cast Ability";
	return s;
	
}
public  void win () {
if(frame.getGame().checkGameOver() != null) {
	String winner =frame.getGame().checkGameOver().getName()+" "+"Won";
	frame.enddd(winner);
}}
private String champtype(Champion c) {
	String s="";
	if(c instanceof Hero)
		s="Hero";
	else if(c instanceof Villain)
		s="Villain";
	else
		s="Anti Hero";
		return s;
}




	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==mup) {
			try {
				win();
				frame.getGame().move(Direction.DOWN);
				makeboard();
				
				currentchamp.setText(champinfo());
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			}
			
			
		}
		if(e.getSource()==mdown) {
			try {
				win();
				frame.getGame().move(Direction.UP);
				makeboard();
				currentchamp.setText(champinfo());
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			}
			
			
		}
		if(e.getSource()==mleft) {
			try {
				win();
				frame.getGame().move(Direction.LEFT);
				makeboard();
				currentchamp.setText(champinfo());
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			}
			
			
		}
		if(e.getSource()==mright) {
			try {
				frame.getGame().move(Direction.RIGHT);
				makeboard();
				currentchamp.setText(champinfo());
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			}
			
			
		}
		if(e.getSource()==aup) {
			try {
				win();
				frame.getGame().attack(Direction.DOWN);
				l.setText("");
				makeboard();
				currentchamp.setText(champinfo());
				
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (ChampionDisarmedException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			}
		}
		if(e.getSource()==adown) {
			try {
				win();
				frame.getGame().attack(Direction.UP);
				l.setText("");
				makeboard();
				currentchamp.setText(champinfo());
				
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (ChampionDisarmedException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			}
		}
		if(e.getSource()==aright) {
			try {
				win();
				frame.getGame().attack(Direction.RIGHT);
				l.setText("");
				makeboard();
				currentchamp.setText(champinfo());
				
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (ChampionDisarmedException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			}
		}
		if(e.getSource()==aleft) {
			try {
				win();
				frame.getGame().attack(Direction.LEFT);
				l.setText("");
				makeboard();
				currentchamp.setText(champinfo());
				
				
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (ChampionDisarmedException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			}
		}
		if(e.getSource()==endturn) {
			win();
			frame.getGame().endTurn();
			makeboard();
			currentchamp.setText(champinfo());
			makeability();
		}
		for(int i=0;i<5;i++){
		for(int j=0; j<5; j++){
		if(frame.getGame().getBoard()[i][j] instanceof Champion){
		if( e.getSource()== b1[i][j])
		infotext.setText(makeinfo((Champion) frame.getGame().getBoard()[i][j]));
		}
		else {
		if( e.getSource()== b1[i][j])
		infotext.setText("");
		}
	}
	

}
		if(e.getSource()==cup) {
			int chooseabindex= chooseab.getSelectedIndex();
			try {
				win();
				frame.getGame().castAbility(frame.getGame().getCurrentChampion().getAbilities().get(chooseabindex), Direction.DOWN);
				makeboard();
				currentchamp.setText(champinfo());
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			}
		}
		if(e.getSource()==cdown) {
			int chooseabindex= chooseab.getSelectedIndex();
			try {
				win();
				frame.getGame().castAbility(frame.getGame().getCurrentChampion().getAbilities().get(chooseabindex), Direction.UP);
				makeboard();
				currentchamp.setText(champinfo());
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			}
		}
		if(e.getSource()==cleft) {
			int chooseabindex= chooseab.getSelectedIndex();
			try {
				win();
				frame.getGame().castAbility(frame.getGame().getCurrentChampion().getAbilities().get(chooseabindex), Direction.LEFT);
				makeboard();
				currentchamp.setText(champinfo());
				
			
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			}
		}
		if(e.getSource()==cright) {
			int chooseabindex= chooseab.getSelectedIndex();
			try {
				win();
				frame.getGame().castAbility(frame.getGame().getCurrentChampion().getAbilities().get(chooseabindex), Direction.RIGHT);
				makeboard();
				currentchamp.setText(champinfo());
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			}
		}
		if(e.getSource()==team) {
			int chooseabindex= chooseab.getSelectedIndex();
			try {
				win();
				frame.getGame().castAbility(frame.getGame().getCurrentChampion().getAbilities().get(chooseabindex));
				makeboard();
				currentchamp.setText(champinfo());
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			}
		}
		
		if(e.getSource()==cast) {
			int chooseabindex= chooseab.getSelectedIndex();
			int xi= x.getSelectedIndex();
			int yi= y.getSelectedIndex();
			try {
				frame.getGame().castAbility(frame.getGame().getCurrentChampion().getAbilities().get(chooseabindex), xi, yi);
				makeboard();
				currentchamp.setText(champinfo());
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			}
		}
		if(e.getSource()==la) {
			try {
				win();
				frame.getGame().useLeaderAbility();
				
				makeboard();
				currentchamp.setText(champinfo());
			} catch (LeaderNotCurrentException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			} catch (LeaderAbilityAlreadyUsedException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE );
			}
		}
		
		
		
}
	

	
}
