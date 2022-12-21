
public class Board {
	
	private int[][] b;
	
	public Board() {
		b = new int[9][9];
		for(int row = 0; row < b.length; row++) 
			for(int col = 0; col < b[row].length; col++) 
				b[row][col] = 0;
	}
	
	public void setNum(int num, int row, int col) {
		b[row][col] = num;
	}
	
	public int getNum(int row, int col) {
		return b[row][col];
	}
	
	public int getLenRow() {
		return b.length;
	}
	
	public int getLenCol() {
		return b[0].length;
	}
	
	public int[][] getBoard() {
		return b;
	}
	
	public String toString() {
		String out = "";
		for(int row = 0; row < b.length; row++) {
			for(int col = 0; col < b[row].length; col++) {
				out += b[row][col];
			}
			out += "\n";
		}
		return out;
	}
	
}
