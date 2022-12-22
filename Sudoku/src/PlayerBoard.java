
public class PlayerBoard extends Board{

	public PlayerBoard() {
		super();
	}

	public PlayerBoard(Key k) {
		super();
		
		int ranRow = 0;
		int ranCol = 0;
		for(int i = 0; i < 30; i++) {
			ranRow = (int) Math.floor(Math.random()*super.getLenRow());
			ranCol = (int) Math.floor(Math.random()*super.getLenCol());
			if(super.getNum(ranRow, ranCol) != 0) {
				for(int offset = 0; offset < super.getLenRow(); offset++) {
					//only shift row; +; -
					if(ranRow+offset < super.getLenRow() && super.getNum(ranRow + offset, ranCol) == 0) {
						ranRow += offset;
						break;
					}
					
					if(ranRow-offset >= 0 && super.getNum(ranRow - offset, ranCol) == 0) {
						ranRow -= offset;
						break;
					}
					
					//only shift col; +; -
					if(ranCol+offset < super.getLenCol() && super.getNum(ranRow, ranCol + offset) == 0) {
						ranCol += offset;
						break;
					}
					
					if(ranCol-offset >=0 && super.getNum(ranRow, ranCol - offset) == 0) {
						ranCol -= offset;
						break;
					}
					
					//shift row and col; ++; +-; -+; --
					if(ranRow+offset < super.getLenRow() && ranCol+offset < super.getLenCol() && super.getNum(ranRow + offset, ranCol + offset) == 0) {
						ranRow += offset;
						ranCol += offset;
						break;
					}
					
					if(ranRow+offset < super.getLenRow() && ranCol-offset >= 0 && super.getNum(ranRow + offset, ranCol - offset) == 0) {
						ranRow += offset;
						ranCol -= offset;
						break;
					}
					
					if(ranRow-offset >= 0 && ranCol+offset < super.getLenCol() && super.getNum(ranRow - offset, ranCol + offset) == 0) {
						ranRow -= offset;
						ranCol += offset;
						break;
					}
					
					if(ranRow-offset >= 0 && ranCol-offset >= 0 && super.getNum(ranRow - offset, ranCol - offset) == 0) {
						ranRow -= offset;
						ranCol -= offset;
						break;
					}
				}
			}
			super.setNum(k.getNum(ranRow, ranCol), ranRow, ranCol);
		}
	}
	
}
