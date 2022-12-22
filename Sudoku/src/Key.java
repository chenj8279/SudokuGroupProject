import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Key extends Board{

	public Key() {
		super();

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

		for(int row = 0; row < super.getLenRow(); row++) 
			for(int col = 0; col < super.getLenCol(); col++) 
				super.setNum(ans[row][col], row, col);
	}

	//not integrated with program because not needed but could be cool if we could create our own boards
	public void createKey() {
		/* no dups in row
		 * no dups in col
		 * no dups in each 3x3
		 * */
		
		List<Integer> possibleAcross = new ArrayList<Integer>();
		for(int i = 0; i < 9; i++) {
			possibleAcross.add(i+1);
		}
		
		List<Integer> possibleDown = new ArrayList<Integer>();
		for(int i = 0; i < 9; i++) {
			possibleDown.add(i+1);
		}
		
		List<Integer> possibleBox = new ArrayList<Integer>();
		for(int i = 0; i < 9; i++) {
			possibleBox.add(i+1);
		}
		
		List<Integer> possibleForSpot = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

		
		// 0,0 0,1 0,2
		// 1,0 1,1 1,2
		// 2,0 2,1 2,2
		int toRemove = -1;
		for(int row = 0; row < super.getLenRow(); row++) {
			for(int col = 0; col < super.getLenCol(); col++) {
				possibleForSpot = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
				for(int i = 0; i < 9; i++) {
					//nums in that col
					toRemove = possibleForSpot.indexOf(super.getNum(row, i));
					if(toRemove != -1) possibleForSpot.remove(toRemove);
					//nums in that row
					toRemove = possibleForSpot.indexOf(super.getNum(i, col));
					if(toRemove != -1) possibleForSpot.remove(toRemove);
				}
				//nums in 3x3 box
				int boxRow = (int) Math.floor(row/3);
				int boxCol = (int) Math.floor(col/3);
				for(int r = 0; r < 3; r++) {
					for(int c = 0; c < 3; c++) {
						toRemove = possibleForSpot.indexOf(super.getNum(boxRow*3+r, boxCol*3+c));
						if(toRemove != -1) possibleForSpot.remove(toRemove);
					}
				}
				int ranNum = (int) Math.floor(Math.random()*possibleForSpot.size());
				if(possibleForSpot.get(ranNum) != null) super.setNum(possibleForSpot.get(ranNum), row, col);
			}
		}
	}

}
