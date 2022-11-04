import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.lang.*;

public class Game extends JFrame implements ActionListener
{
    public static void main(String args[])
	{
	   new Game();
	}
	Random random;
	
	
	JPanel title_panel;
	
	
	JPanel button_panel;
	
	
	JLabel textfield;
	
	JButton buttons[]=new JButton[9];
	
	
	boolean player1_turn;
	
	public Game()
	{
	   setSize(800,600);
	   setLocation(150,100);
	   setLayout(new BorderLayout());
	   getContentPane().setBackground(new Color(50,50,50));
	   
	   
	   
	   random=new Random();
	   title_panel=new JPanel();
	   button_panel=new JPanel();
	   textfield=new JLabel();
	   buttons=new JButton[9];
	   
	   textfield.setBackground(new Color(25,25,25));
	   textfield.setForeground(new Color(25,255,0));
	   textfield.setFont(new Font("Ink Free",Font.BOLD,75));
	 //  setLayout(null);
	   textfield.setBounds(100,20,120,30);
	   textfield.setText("Tic-Tac-Toe");
	   textfield.setOpaque(true);
	   
	   title_panel.setLayout(new BorderLayout());
	   title_panel.setBounds(0,0,800,100);
	   
	  // button_panel.setBounds(0,100,800,500);
	  
	  
	  
	  button_panel.setLayout(new GridLayout(3,3));
	  button_panel.setBackground(new Color(150,150,150));
	  
	   
	    for(int i=0;i<9;i++)
		{
			buttons[i]=new JButton();
             buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			 buttons[i].setFocusable(false);
			 buttons[i].addActionListener(this);
			button_panel.add(buttons[i]);
		}
		
	   title_panel.add(textfield);
	   add(title_panel,BorderLayout.NORTH);
	  add(button_panel);
	   
	   firstTurn();
	   setVisible(true);
	   
	}
	public void actionPerformed(ActionEvent e)
	{
		for(int i=0;i<9;i++)
		{
			if(e.getSource() == buttons[i])
			{
				if(player1_turn)
				{
					if(buttons[i].getText() == "")
					{
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1_turn=false;
						textfield.setText("O turn");
						check();
					}
				}
				else{
					if(buttons[i].getText() == "")
					{
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player1_turn=true;
						textfield.setText("X turn");
						check();
					}
				}
			}
		}
	}
	public void firstTurn()
	{
		
		try
		{
			Thread.sleep(2000);
			
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		if(random.nextInt(2) == 0)
		{
			player1_turn=true;
			textfield.setText("X turn");
		}
		else
		{
			player1_turn=false;
			textfield.setText("O turn");
		}
	}
	public void check()
	{
		// check x is win
		
		if(buttons[0].getText() == "X" && buttons[1].getText() == "X" && buttons[2].getText() == "X") xWins(0,1,2);
		
		if(buttons[3].getText() == "X" && buttons[4].getText() == "X" && buttons[5].getText() == "X") xWins(3,4,5);
		
		if(buttons[6].getText() == "X" && buttons[7].getText() == "X" && buttons[8].getText() == "X") xWins(6,7,8);
		
		if(buttons[0].getText() == "X" && buttons[3].getText() == "X" && buttons[6].getText() == "X") xWins(0,3,6);
		
		if(buttons[1].getText() == "X" && buttons[4].getText() == "X" && buttons[7].getText() == "X") xWins(1,4,7);
		if(buttons[2].getText() == "X" && buttons[5].getText() == "X" && buttons[8].getText() == "X") xWins(2,5,8);
		if(buttons[0].getText() == "X" && buttons[4].getText() == "X" && buttons[8].getText() == "X") xWins(0,4,8);
		if(buttons[2].getText() == "X" && buttons[4].getText() == "X" && buttons[6].getText() == "X") xWins(2,4,6);
		// check o is win
		if(buttons[0].getText() == "O" && buttons[1].getText() == "O" && buttons[2].getText() == "O") oWins(0,1,2);
		if(buttons[3].getText() == "O" && buttons[4].getText() == "O" && buttons[5].getText() == "O") oWins(3,4,5);
		if(buttons[6].getText() == "O" && buttons[7].getText() == "O" && buttons[8].getText() == "O") oWins(6,7,8);
		if(buttons[0].getText() == "O" && buttons[3].getText() == "O" && buttons[6].getText() == "O") oWins(0,3,6);
		if(buttons[1].getText() == "O" && buttons[4].getText() == "O" && buttons[7].getText() == "O") oWins(1,4,7);
		if(buttons[2].getText() == "O" && buttons[5].getText() == "O" && buttons[8].getText() == "O") oWins(2,5,8);
		if(buttons[0].getText() == "O" && buttons[4].getText() == "O" && buttons[8].getText() == "O") oWins(0,4,8);
		if(buttons[2].getText() == "O" && buttons[4].getText() == "O" && buttons[6].getText() == "O") oWins(2,4,6);
	}
	public void xWins(int a,int b,int c)
	{
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++)
		{
			buttons[i].setEnabled(false);
		}
		textfield.setText("X Wins");
		
	}
	public void oWins(int a,int b,int c)
	{
		
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++)
		{
			buttons[i].setEnabled(false);
		}
		textfield.setText("O Wins");
	}
}