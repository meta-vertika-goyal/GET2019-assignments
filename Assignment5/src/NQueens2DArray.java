public class NQueens2DArray {
	/*
	 * This method checks the validity of the dimension of matrix and calls placeAllQueens()
	 * @param dimensionOfMatrix size of chessboard on which N-Queens is to be applied
	 * @return boolean returns true id n-Queens is applicable else returns false
	 */
	public static boolean placeQueens(int dimensionOfMatrix){

		//If Grid is 1*1 or 2*2 or 3*3 then solution is not possible as, 
		//In 1*1 or 2*2 grid, Queen placed in 1st row at any position will attack queen placed at all the positions in row 2. 
		//In 3*3 grid, Queen placed in 1st row and 2nd row for all combinations position will attack queen placed at all the positions in row 3. 
		if(dimensionOfMatrix<4){ 
			System.out.println("No Solution available");
			return false;
		}else{
			int[][] board = new int[dimensionOfMatrix][dimensionOfMatrix]; 
			boolean result=placeAllQueens(board, 0,dimensionOfMatrix);
			printBoard(board,dimensionOfMatrix);
			return result;
		}
	}
	/*
	 * This method solves the N-Queens problem
	 * @param board[][] is the N*N board on which N-Queens is to be applied
	 * @param row is the start row index
	 * @param dimensionOfMatrix holds the value of N in the N-Queens Problem
	 * @return boolean true if all the N queens can be placed on the board of the specified dimension
	 */
	public static boolean placeAllQueens(int board[][], int row,int dimensionOfMatrix){
		if(row>=dimensionOfMatrix){  
			return true;             //return true if all rows have been checked
		}
		boolean isAllQueensPlaced = false;
		for (int j = 0; j < dimensionOfMatrix; j++) {
			if(isSafe(board, row, j,dimensionOfMatrix)){
				board[row][j] = 1;
				isAllQueensPlaced = placeAllQueens(board, row+1,dimensionOfMatrix);
			}
			if(isAllQueensPlaced){
				break;
			}else{
				board[row][j] = 0;
			}
		}
		return isAllQueensPlaced;
	}
	/*
	 * This method checks if there exists any 1 in the same row,column or diagonal
	 * @param row is the row index with respect to which all the other cells are to be checked
	 * @param row is the column index with respect to which all the other cells are to be checked
	 * @param dimensionOfMatrix holds the value of N in the N-Queens Problem
	 * @return boolean true if the queen can be placed in the specified row and column else returns false
	 */
	private static boolean isSafe(int board[][], int row, int col,int dimensionOfMatrix){
		//Check Left Upper Diagonal
		for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
			if(board[i][j] == 1){
				return false;
			}
		}
		//Check Right Upper Diagonal
		for (int i = row-1, j = col+1; i >= 0 && j < dimensionOfMatrix; i--, j++) {
			if(board[i][j] == 1){
				return false;
			}
		}
		//Check in same Column
		for (int i = row-1; i >= 0; i--) {
			if(board[i][col] == 1){
				return false;
			}
		}
		return true;
	}
	/*
	 * This method prints the board for the N-Queens problem
	 * @param board[][] is the N*N board on which N-Queens is to be applied
	 * @param dimensionOfMatrix holds the value of N in the N-Queens Problem
	 */
	private static void printBoard(int[][] board,int dimensionOfMatrix){
		for (int row = 0; row < dimensionOfMatrix; row++) {
			for (int col = 0; col < dimensionOfMatrix; col++) {
				if(board[row][col] == 1){
					System.out.print("Q ");
				}else{
					System.out.print("_ ");
				}
			}
			System.out.println();
		}
		System.out.println("");
	}

}

