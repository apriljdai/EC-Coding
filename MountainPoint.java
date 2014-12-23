public class MountainPoint{
	/*Given a M * N matrix, 
	if the element in the matrix is larger than other 8 elements who stay around it,
	then named that element be mountain point. 
	Print all the mountain points.
	*/
	public static void mountainPoint(int[][] matrix){
		int row = matrix.length;
		int col = matrix[0].length;
		for (int i = 1; i < row - 1; i++){
			for (int j = 1; j < col - 1; j++){
				if (matrix[i - 1][j - 1] > matrix[i][j])
					continue;
				if (matrix[i - 1][j] > matrix[i][j])
					continue;
				if (matrix[i - 1][j + 1] > matrix[i][j])
					continue;
				if (matrix[i][j - 1] > matrix[i][j])
					continue;
				if (matrix[i][j + 1] > matrix[i][j])
					continue;
				if (matrix[i + 1][j - 1] > matrix[i][j])
					continue;
				if (matrix[i + 1][j] > matrix[i][j])
					continue;
				if (matrix[i+ 1][j + 1] > matrix[i][j])
					continue;
				System.out.println("The mountain point is: " + matrix[i][j]);
			}
		}
	}
	public static void main(String[] args){
		int[][] matrix = {{1,3,4,7,9},{53,86,23,15,57},{31,46,76,98,71}, {54,57,12,76,19}};
		mountainPoint(matrix);
	}
}

