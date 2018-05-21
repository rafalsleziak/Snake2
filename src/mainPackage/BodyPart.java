package mainPackage;

import java.awt.Color;
import java.awt.Graphics;


public class BodyPart 
{
	private int xCoordinate, yCoordinate, height, width;
	
	public BodyPart(int xCoordinate, int yCoordinate, int segmentSize)
	{
		this.xCoordinate=xCoordinate;
		this.yCoordinate=yCoordinate;
		width = segmentSize;
		height = segmentSize;
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

	public void draw(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(xCoordinate*width, yCoordinate*height,width,height); //kolorwanie bloczka
		g.setColor(Color.GREEN);
		g.fillRect(xCoordinate*width + 2, yCoordinate*height + 2,width,height); //rysowanie krawedzi bloczka
	}
}
