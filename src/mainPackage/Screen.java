package mainPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable
{
	public static final int WIDTH = 800, HEIGHT = 800;
	private Thread thread;
	private boolean running = false;
	
	private BodyPart bodyPart;
	private ArrayList<BodyPart> snake;
	
	private Food apple;
	private ArrayList<Food> apples;
	private int xHead = 10, yHead = 10;
	private int size = 4;
	
	private boolean right = true, left = false, up = false, down = false;
	private int ticks = 0;
	private Key key;
	private Random random;;
	
	public Screen()
	{
		setFocusable(true);
		key = new Key();
		addKeyListener(key);
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setBackground(Color.BLACK);
		snake = new ArrayList<BodyPart>(); //Snake jako ArrayList
		
		random = new Random();
		apples = new ArrayList<Food>();
		start();
	}
	
	public void tick() 
	{
		if(snake.size() == 0) //Tworzenie nowego weza
		{
			bodyPart = new BodyPart(xHead, yHead, 20);
			snake.add(bodyPart);
		}
		
		if(apples.size() == 0)
		{
			
			int xCoordinate = random.nextInt(39);
			int yCoordinate = random.nextInt(39);
			
			apple = new Food(xCoordinate, yCoordinate , 20);
			apples.add(apple);
		}
		
		for(int i = 0; i<apples.size(); i++)
		{
			if(xHead == apples.get(i).getxCoordinate() && yHead == apples.get(i).getyCoordinate() )
			{
				size++;
				apples.remove(i);
				i--;
			}
		}
		
		for(int i=0; i<snake.size(); i++)
		{
			if(xHead == snake.get(i).getxCoordinate() && yHead == snake.get(i).getyCoordinate())
			{
				if(i != snake.size() - 1)
					stop();
			}
		}
	
		if(xHead < 0) xHead = 40;
		if(xHead > 40) xHead = 0;
		if(yHead < 0) yHead = 40;
		if(yHead > 40) yHead = 0;

			
			
		ticks++;
		if(ticks > 1000000 )
		{
			if(right) xHead++;
			if(left) xHead--;
			if(up) yHead--;
			if(down) yHead++;
			
			ticks = 0;
			bodyPart =  new BodyPart(xHead, yHead, 20);
			snake.add(bodyPart);
			
			if(snake.size() > size)
			{
				snake.remove(0);
			}
		}
	}
	
	public void paint(Graphics g)

	{
		g.clearRect(0,0,WIDTH,HEIGHT);
		
		for(int i = 0; i < WIDTH / 20; i++)
		{
			//g.drawLine(i * 20, 0 , i * 20, HEIGHT);	//punkt x1, punkt y1, punkt xkoncowy,punkt ykocnoiwy
		}
		for(int i = 0; i < HEIGHT; i++)
		{
			//g.drawLine(0, i * 20, WIDTH ,i * 20);
		}
		
		for(int i = 0; i < snake.size(); i++)	/////////////Rysowanie Snake
		{
			snake.get(i).draw(g);
		}
		for(int i = 0; i<apples.size(); i++)
		{
			apples.get(i).draw(g);
		}
		
	}
	
	public void start() 
	{
		running = true;
		thread = new Thread(this, "Game Loop");
		thread.start();
	}
	
	public void stop() {
		running = false;
		try {
		thread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(running) 
		{
			tick();
			repaint();
		}
	}
	
	private class Key implements KeyListener{
		
		@Override
		public void keyPressed(KeyEvent e)
		{
			int key = e.getKeyCode();
			
			if(key == KeyEvent.VK_RIGHT && !left)
			{
				up=false;
				down=false;
				right=true;
			}
			if(key == KeyEvent.VK_LEFT && !right)
			{
				up=false;
				down=false;
				left=true;
			}
			if(key == KeyEvent.VK_UP && !down)
			{
				left=false;
				right=false;
				up=true;
			}
			if(key == KeyEvent.VK_DOWN && !up)
			{
				left=false;
				right=false;
				down=true;
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
}






