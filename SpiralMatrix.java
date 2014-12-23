public class SpiralMatrix{
		/*
	Given a NXN matrix, starting from the upper right corner of the matrix 
	start printing values in a counter-clockwise fashion. 
	E.g.: Consider N = 4 
			Matrix = {a, b, c, d, 
        			  e, f, g, h, 
        			  i, j, k, l, 
        			  m, n, o, p} 
	Your function should output: dcbaeimnoplhgfjk 
	*/
	public static String spiralMatrix(char[][] matrix){
		StringBuilder sb = new StringBuilder();
		int row = matrix.length;
		int col = row;
		int x = 0, y = col - 1;
		while (row > 0 && col > 0){
			if (row == 1){
				for (int i = 0; i < col; i++)
					sb.append(matrix[x][y--]);
				break;
			}
			if (col == 1){
				for (int i = 0; i < row; i++)
					sb.append(matrix[x++][y]);
				break;
			}
			for (int i = 0; i < col - 1; i++)
				sb.append(matrix[x][y--]);
			for (int i = 0; i < row - 1; i++)
				sb.append(matrix[x++][y]);
			for (int i = 0; i < col - 1; i++)
				sb.append(matrix[x][y++]);
			for (int i = 0; i < row - 1; i++)
				sb.append(matrix[x--][y]);
			x++;
			y--;
			row -= 2;
			col -= 2;
		}

		return sb.toString();
	}
	public static void main(String[] args){
		char[][] matrix = {{'a','b','c','d'}, {'e','f','g','h'}, {'i','j','k','l'}, {'m','n','o','p'}};
		String s = spiralMatrix(matrix);
		System.out.println(s);
		char[][] matrix2 = {{'a','b','c','d','1'}, {'e','f','g','h','2'}, {'i','j','k','l','3'}, {'m','n','o','p','4'}, {'q','r','s','t','5'}};
		String s2 = spiralMatrix(matrix2);
		System.out.println(s2);
	}
}