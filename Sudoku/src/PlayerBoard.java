
public class PlayerBoard extends Board{
	
	public PlayerBoard() {
		super();
	}
	
	public PlayerBoard(Key k) {
		super();
		for(int i = 0; i < 30; i++) {
			int row = (int) Math.random()*super.getLenRow();
			int col = (int) Math.random()*super.getLenCol();
			
			while(super.getNum(row, col) != 0) {
				row = (int) Math.random()*super.getLenRow();
				col = (int) Math.random()*super.getLenCol();
			}
			super.setNum(k.getNum(row, col), row, col);
		}
	}
}
