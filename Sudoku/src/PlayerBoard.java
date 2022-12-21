
public class PlayerBoard extends Board{

	public PlayerBoard() {
		super();
	}

	public PlayerBoard(Key k) {
		super();
		
		/*int row = 0;
		int col = 0;
		int count = 0;*/
		
		for(int i = 0; i < 30; i++) {
			
			int ranRow = (int) Math.random()*super.getLenRow();
			int ranCol = (int) Math.random()*super.getLenCol();
			
			if(super.getNum(ranRow, ranCol) != 0) {
				outer : for(int r = ranRow; r < super.getLenRow(); r++) {
					for(int c = ranCol; c < super.getLenCol(); c++) {
						if(super.getNum(ranRow, ranCol) == 0) {
							ranRow = r;
							ranCol = c;
							break outer;
						}
					}
				}
			}
			
			super.setNum(k.getNum(ranRow, ranCol), ranRow, ranCol);
			
			/*super.setNum(k.getNum(row, col), row, col);
			
			if(col < super.getLenCol()-1) col++;
			else if(row < super.getLenRow()-1) {
				row++;
				col = 0;
			}
			else {
				row = 0;
				col = 0;
			}*/
		}
	}
	
}
