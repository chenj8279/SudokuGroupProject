import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements KeyListener, Runnable{
	
	private Key ansKey;
	private PlayerBoard pBoard;
	private Block selector;
	private int spotX, spotY;
	
	private boolean[] keys;
	private BufferedImage back;
	
	public Game (){
		//set up game variables
		ansKey = new Key();
		pBoard = new PlayerBoard(ansKey);
		
		Color selectorColor = new Color(211, 211, 211, 50);
		selector = new Block(10, 10, 100, 100, selectorColor);
		spotX = 0;
		spotY = 0;
		
		
		keys = new boolean[13]; //1-9 and arrow keys
		
		setBackground(Color.BLACK);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);
	}
	
	public void update(Graphics window) {
		paint(window);
	}
	
	public void paint(Graphics window) {
		Graphics2D twoDGraph = (Graphics2D)window;
		
		if(back == null) back = (BufferedImage)createImage(getWidth(), getHeight());
		
		Graphics graphToBack = back.createGraphics();
		
		//grid lines
		graphToBack.setColor(Color.DARK_GRAY);
		for(int i = 1; i < 9; i++) {
			graphToBack.fillRect(i*110, 10, 10, 980);
			graphToBack.fillRect(10, i*110, 980, 10);
		}
		graphToBack.setColor(Color.GRAY);
		graphToBack.fillRect(330, 10, 10, 980);
		graphToBack.fillRect(660, 10, 10, 980);
		graphToBack.fillRect(10, 330, 980, 10);
		graphToBack.fillRect(10, 660, 980, 10);
		
		//borders
		graphToBack.fillRect(0, 0, 10, 1000);
		graphToBack.fillRect(990, 0, 10, 1000);
		graphToBack.fillRect(0, 0, 1000, 10);
		graphToBack.fillRect(0, 990, 1000, 10);
		
		graphToBack.setColor(Color.WHITE);
		
		//check things
		//move
		if(keys[9] == true && selector.getX() > 10) {
			selector.moveLeft(graphToBack);
			spotX--;
			keys[9] = false;
		}
		
		if(keys[10] == true && selector.getX() < 800) {
			selector.moveRight(graphToBack);
			spotX++;
			keys[10] = false;
		}
		
		if(keys[11] == true && selector.getY() > 10) {
			selector.moveUp(graphToBack);
			spotY--;
			keys[11] = false;
		}
		
		if(keys[12] == true && selector.getY() < 800) {
			selector.moveDown(graphToBack);
			spotY++;
			keys[12] = false;
		}
		
		//nums
		if(keys[0]) {
			if(pBoard.getNum(spotY, spotX) != ansKey.getNum(spotY, spotX)) pBoard.setNum(1, spotY, spotX);
			keys[0] = false;
		}
		
		if(keys[1]) {
			if(pBoard.getNum(spotY, spotX) != ansKey.getNum(spotY, spotX)) pBoard.setNum(2, spotY, spotX);
			keys[1] = false;
		}
		
		if(keys[2]) {
			if(pBoard.getNum(spotY, spotX) != ansKey.getNum(spotY, spotX)) pBoard.setNum(3, spotY, spotX);
			keys[2] = false;
		}
		
		if(keys[3]) {
			if(pBoard.getNum(spotY, spotX) != ansKey.getNum(spotY, spotX)) pBoard.setNum(4, spotY, spotX);
			keys[3] = false;
		}
		
		if(keys[4]) {
			if(pBoard.getNum(spotY, spotX) != ansKey.getNum(spotY, spotX)) pBoard.setNum(5, spotY, spotX);
			keys[4] = false;
		}
		
		if(keys[5]) {
			if(pBoard.getNum(spotY, spotX) != ansKey.getNum(spotY, spotX)) pBoard.setNum(6, spotY, spotX);
			keys[5] = false;
		}
		
		if(keys[6]) {
			if(pBoard.getNum(spotY, spotX) != ansKey.getNum(spotY, spotX)) pBoard.setNum(7, spotY, spotX);
			keys[6] = false;
		}
		
		if(keys[7]) {
			if(pBoard.getNum(spotY, spotX) != ansKey.getNum(spotY, spotX)) pBoard.setNum(8, spotY, spotX);
			keys[7] = false;
		}
		
		if(keys[8]) {
			if(pBoard.getNum(spotY, spotX) != ansKey.getNum(spotY, spotX)) pBoard.setNum(9, spotY, spotX);
			keys[8] = false;
		}
		
		//check if input matches key; change color to red if it doesn't
		
		//draw variables
		graphToBack.setColor(Color.WHITE);
		for(int row = 0; row < pBoard.getLenRow(); row++) {
			for(int col = 0; col < pBoard.getLenCol(); col++) {
				if(pBoard.getNum(row, col) != 0) {
					if(pBoard.getNum(row, col) == ansKey.getNum(row, col)) graphToBack.setColor(Color.WHITE);
					else graphToBack.setColor(Color.RED);
					String add = "" + pBoard.getNum(row, col);
					graphToBack.setFont(new Font("TimesRoman", Font.PLAIN, 100));
					graphToBack.drawString(add, (col)*110+30, (row+1)*110-15);
				}
			}
		}
		
		selector.draw(graphToBack);
		
		//draws everything
		twoDGraph.drawImage(back, null, 0, 0);
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void keyPressed(KeyEvent e) {
		//movement
		if(e.getKeyCode() == KeyEvent.VK_LEFT) keys[9] = true;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) keys[10] = true;
		if(e.getKeyCode() == KeyEvent.VK_UP) keys[11] = true;
		if(e.getKeyCode() == KeyEvent.VK_DOWN) keys[12] = true;
		//type nums
		switch(e.getKeyCode()) {
			case KeyEvent.VK_1: keys[0] = true; break;
			case KeyEvent.VK_2: keys[1] = true; break;
			case KeyEvent.VK_3: keys[2] = true; break;
			case KeyEvent.VK_4: keys[3] = true; break;
			case KeyEvent.VK_5: keys[4] = true; break;
			case KeyEvent.VK_6: keys[5] = true; break;
			case KeyEvent.VK_7: keys[6] = true; break;
			case KeyEvent.VK_8: keys[7] = true; break;
			case KeyEvent.VK_9: keys[8] = true; break;
		}
		repaint();
	}
	
	public void keyReleased(KeyEvent e) {
		//movement
		if(e.getKeyCode() == KeyEvent.VK_LEFT) keys[9] = false;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) keys[10] = false;
		if(e.getKeyCode() == KeyEvent.VK_UP) keys[11] = false;
		if(e.getKeyCode() == KeyEvent.VK_DOWN) keys[12] = false;
		//type nums
		switch(e.getKeyCode()) {
			case KeyEvent.VK_1: keys[0] = false; break;
			case KeyEvent.VK_2: keys[1] = false; break;
			case KeyEvent.VK_3: keys[2] = false; break;
			case KeyEvent.VK_4: keys[3] = false; break;
			case KeyEvent.VK_5: keys[4] = false; break;
			case KeyEvent.VK_6: keys[5] = false; break;
			case KeyEvent.VK_7: keys[6] = false; break;
			case KeyEvent.VK_8: keys[7] = false; break;
			case KeyEvent.VK_9: keys[8] = false; break;
		}
		repaint();
	}
	
	public void run() {
		try {
			while(true) {
				Thread.currentThread().sleep(10);
				repaint();
			}
		}catch(Exception e) {
			
		}
	}
}
