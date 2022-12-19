
public class PlayerBoard{

	private int[][] pBoard;
	
	public PlayerBoard() {
		pBoard = new int [9][9];
	}
	
	public void addNum (int num, int row, int col) {
		pBoard[row][col] = num;
	}
	
	public void addHints(Key k) {
		for(int i = 0; i < 17; i++) {
			int row = (int) Math.random()*pBoard.length;
			int col = (int) Math.random()*pBoard[0].length;
			
			while(pBoard[row][col] != 0) {
				row = (int) Math.random()*pBoard.length;
				col = (int) Math.random()*pBoard[0].length;
			}
			pBoard[row][col] = k.getHint(row, col);
		}
	}
	
	public boolean display(int row, int col) {
		if(pBoard[row][col] != 0) {
			return true;
		}
		return false;
	}
	
	public int getNum(int row, int col) {
		return pBoard[row][col];
	}
	
	public int getLengthRow() {
		return pBoard.length;
	}
	
	public int getLengthCol() {
		return pBoard[0].length;
	}
	
}
