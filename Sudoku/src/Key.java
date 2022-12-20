
public class Key extends Board{
	
	public Key() {
		super();
	}
	
	public void createKey() {
		int[][] ans = new int[][] {
			{8,1,6,2,4,5,3,7,9},
			{4,7,3,8,1,9,5,2,6},
			{2,5,9,6,3,7,4,1,8},
			{1,6,4,9,8,2,7,5,3},
			{7,9,2,3,5,1,8,6,4},
			{3,8,5,4,7,6,1,9,2},
			{6,3,1,7,2,8,9,4,5},
			{5,2,8,1,9,4,6,3,7},
			{9,4,7,5,6,3,2,8,1},
		};
		
		for(int row = 0; row < getLenRow(); row++) 
			for(int col = 0; col < getLenCol(); col++) 
				setNum(ans[row][col], row, col);	
	}
	
}
