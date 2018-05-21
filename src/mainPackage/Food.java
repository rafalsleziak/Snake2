package mainPackage;

import java.awt.Color;
import java.awt.Graphics;

public class Food 
{
	private int xCoordinate, yCoordinate,width,height;
	
	public Food(int xCoordinate, int yCoordinate, int blockSize)
	{
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		width = blockSize;
		height = blockSize;
	}
	
	public void tick()
	{
	
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(xCoordinate * width, yCoordinate * height, width, height);
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	
}
