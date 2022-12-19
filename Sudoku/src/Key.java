
public class Key {
	
	private int[][] ans;
	
	public Key() {
		ans = new int[9][9];
	}
	
	public int getHint(int row, int col) {
		return ans[row][col];
	}
	
}
