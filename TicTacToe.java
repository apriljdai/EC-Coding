public class TicTacToe{
	/*
	N*N matrix is given with input red or black. 
	You can move horizontally, vertically or diagonally. 
	If 3 consecutive same color found, that color will get 1 point. 
	So if 4 red are vertically then point is 2. 
	Given a boolean array, True represents red, false represents black.
	Find the winner.
	*/
	public static int findWinner(boolean[][] matrix, int row, int col, boolean c){
		//horizontal count
		int count = 0;
		for (int i = 0; i < row; i++){
			for (int j = 0; j < col - 2; j++){
				if (matrix[i][j] == c && matrix[i][j + 1] == c && matrix[i][j + 2] == c)
					count ++;
			}
		}
		//vertical count
		for (int i = 0; i < col; i++){
			for (int j = 0; j < row - 2; j++){
				if (matrix[j][i] == c && matrix[j + 1][i] == c && matrix[j + 2][i] == c)
					count ++;
			}
		}
		//diagonal count
		for (int i = 0; i < row - 2; i++){
			for (int j = 0; j < col - 2; j++){
				if (matrix[i][j] == c && matrix[i + 1][j + 1] == c && matrix[i + 2][j + 2] == c)
					count ++;
			}
		}
		for (int i = 0; i < row - 2; i++){
			for (int j = col - 1; j > 1; j--){
				if (matrix[i][j] == c && matrix[i + 1][j - 1] == c && matrix[i + 2][j - 2] == c)
					count ++;
			}
		}
		return count;
	}
	public static void main(String[] args){
		boolean[][] matrix = {{true, true, true, true, false}, 
							 {false, true, false, true, false}, 
							 {false, true, true, false, false}, 
							 {false, true, false, false, false}, 
							 {false, true, true, true, false}};
		int row = matrix.length;
		int col = row;
		int red = findWinner(matrix, row, col, true);
		//System.out.println("red counts for " + red);
		int black = findWinner(matrix, row, col, false);
		//System.out.println("black counts for " + black);
		if (red > black)
			System.out.println("The winner of Tic Tac Toe is red!");
		if (black < red)
			System.out.println("The winner of Tic Tac Toe is black!");
		else
			System.out.println("There's no winner!");
			
	}
}
