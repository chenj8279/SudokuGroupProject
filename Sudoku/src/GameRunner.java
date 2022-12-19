import java.awt.Component;
import javax.swing.JFrame;

public class GameRunner extends JFrame {
	private static final int WIDTH = 996;
	private static final int HEIGHT = 1016;
	
	public GameRunner() {
		super("Game");
		setSize(WIDTH, HEIGHT);
		
		Game g = new Game();
		
		((Component)g).setFocusable(true);
		getContentPane().add(g);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		GameRunner run = new GameRunner();
	}
}
