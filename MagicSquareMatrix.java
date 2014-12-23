public class MagicSquareMatrix {
	/*
	A magic square of order n is an arrangement of the numbers from 1 to n^2 in an n by n matrix 
	with each number occurring exactly once so that each row, 
	each column and each main diagonal has the same sum. The n should be an odd number. 
	In the middle cell of the top row, fill number 1. 
	Then go to above row and right column, and fill following number 2. 
	If it’s out of boundary, go to the opposite row or column. 
	If the next cell is already occupied, 
	go to the cell below this cell and fill following number. 
	An example of 5*5 grid is like this for the first 9 numbers:
	0 0 1 8 0
	0 5 7 0 0
	4 6 0 0 0
	0 0 0 0 3
	0 0 0 2 9
	*/
	public static void fillMatrix(int n){
		if (n % 2 == 0)
			return;
		int[][] matrix = new int[n][n];
		matrix[0][n / 2] = 1;
		fillMatrix(matrix, -1, n / 2 + 1, 2, n);
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				System.out.print(matrix[i][j] + ", ");
			}
			System.out.println("");
		}
	}
	public static void fillMatrix(int[][] matrix, int row, int col, int num, int n){
		while (num <= n * n){
			boolean  fliprow= false;
			boolean flipcol = false;
			if (row < 0){
				row = n - 1;
				fliprow = true;
			}
			if (col > n - 1){
				col = 0;
				flipcol = true;
			}
			if (matrix[row][col] == 0){
				matrix[row][col] = num;
				row--;
				col++;
				num++;
			}
			else{
				if (fliprow && flipcol){
					row = 1;
					col = n - 1;
				}
				else if (fliprow && !flipcol){
					row = 1;
					col--;
				}
				else if (flipcol && !fliprow){
					row += 2;
					col = n - 1;
				}
				else{
					row += 2;
					col --;
				}
			}
		}
	}
	public static void main(String[] args){
		int n = 5;
		fillMatrix(n);
	}
}

