import java.awt.Color;
import java.awt.Graphics;

public class Block {



	private int xPos = 0;
	private int yPos = 0;
	private int width = 100;
	private int height = 100;
	private Color color = Color.green;

	public Block() {
		this(0, 0, 100, 100, Color.green);
	}

	public Block(int x, int y) {
		xPos = x;
		yPos = y;
	}

	public Block(int x, int y, int wid, int ht) {
		xPos  = x;
		yPos = y;
		width = wid;
		height = ht;
	}

	public Block(int x, int y, int wid, int ht, Color col) {
		xPos = x;
		yPos = y;
		width = wid;
		height = ht;
		color = col;
	}
	
	//setters
	public void setPos( int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	public void setX( int x ) {xPos = x;}
	
	public void setY( int y ) {yPos = y;}
	
	public void setWidth(int w) {width = w;}
	
	public void setHeight(int h) {height = h;}
	
	public void setColor(Color col) {color = col;}

	//getters
	public int getX() {return xPos;}
	
	public int getY() {return yPos;}
	
	public int getWidth() {return width;}
	
	public int getHeight() {return height;}
	
	public Color getColor() {return color;}
	
	//draw
	public void draw(Graphics window) {
		window.setColor(color);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
	public void draw(Graphics window, Color col) {
		window.setColor(col);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
	//move
	public void moveLeft(Graphics window) {
		draw(window, Color.BLACK);
		setX(getX()-110);
		draw(window, getColor());
	}
	
	public void moveRight(Graphics window) {
		draw(window, Color.BLACK);
		setX(getX()+110);
		draw(window, getColor());
	}
	
	public void moveUp(Graphics window) {
		draw(window, Color.BLACK);
		setY(getY()-110);
		draw(window, getColor());
	}
	
	public void moveDown(Graphics window) {
		draw(window, Color.BLACK);
		setY(getY()+110);
		draw(window, getColor());
	}

}
