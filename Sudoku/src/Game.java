import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements KeyListener, Runnable{

	private boolean[] keys;
	private BufferedImage back;
	
	public Game (){
		//set up game variables
		
		keys = new boolean[13]; //1-9 and arrow keys
		
		setBackground(Color.DARK_GRAY);
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
		
		
		//minor grid lines
		graphToBack.setColor(Color.gray);
		for(int i = 0; i < 8; i++){
			graphToBack.fillRect(95 + (100*i), 0, 10, 900);
			graphToBack.fillRect(0, 95 + (100*i), 10, 900);
		}
		graphToBack.fillRect(95, 0, 10, 900);
		graphToBack.fillRect(195, 0, 10, 900);
		graphToBack.fillRect(395, 0, 10, 900);
		graphToBack.fillRect(495, 0, 10, 900);
		graphToBack.fillRect(695, 0, 10, 900);
		graphToBack.fillRect(795, 0, 10, 900);
		graphToBack.fillRect(0, 95, 900, 10);
		graphToBack.fillRect(0, 195, 900, 10);
		graphToBack.fillRect(0, 295, 900, 10);
		graphToBack.fillRect(0, 495, 900, 10);
		graphToBack.fillRect(0, 595, 900, 10);
		graphToBack.fillRect(0, 795, 900, 10);
		//major grid lines
		graphToBack.setColor(Color.lightGray);
		graphToBack.fillRect(295, 0, 10, 900);
		graphToBack.fillRect(595, 0, 10, 900);
		graphToBack.fillRect(0, 295, 900, 10);
		graphToBack.fillRect(0, 595, 900, 10);
		
		//draw variables
		
		//check things
		
		
		//draw everything
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
