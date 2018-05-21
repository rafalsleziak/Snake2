package mainPackage;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class Frame extends JFrame{

	public Frame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Snake");
		//setColor(Color.BLACK);
		setResizable(false);
		init();
	}
	
	public void init()
	{
		setLayout(new GridLayout(1,1,0,0) );
		//setBackground(Color.BLACK);

		Screen s = new Screen();
		add(s);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public static void main(String[] args)
	{
		new Frame();
	}
}
