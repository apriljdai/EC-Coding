public class SnakeSequence{
	/*
	You are given a grid of numbers. 
	A snake sequence is made up of adjacent numbers such that for each number, 
	the number on the right or the number below it is +1 or -1 its value. 
	For example, 
		1 3 2 6 8 
		-9 7 1 -1 2 
		1 5 0 1 9 
	In this grid, (3, 2, 1, 0, 1) is a snake sequence. 
	Given a grid, find the longest snake sequences and their lengths 
	(so there can be multiple snake sequences with the maximum length)
	*/
	//main func for find max length snake sequences
	public static int snakeSequence(int[][] grid){
		int row = grid.length;
		int col = grid[0].length;
		int[][] dp = new int[row][col];
		dp[0][0] = 1;
		int max = 1;
		int[] index = new int[2];
		//System.out.println("dp[0][0] = " + dp[0][0]);
		for (int i = 1; i < row; i++){
			dp[i][0] = Math.abs(grid[i][0] - grid[i - 1][0]) == 1 ? dp[i - 1][0] + 1 : 1;
			//System.out.println("dp[" + i + "][0] = " + dp[i][0]);
		}
		for (int i = 1; i < col; i++){
			dp[0][i] = Math.abs(grid[0][i] - grid[0][i - 1]) == 1 ? dp[0][i - 1] + 1 : 1;
			//System.out.println("dp[0][" + i + "] = " + dp[0][i]);
		}
		for (int i = 1;i < row; i++){
			for (int j = 1; j < col; j++){
				if (Math.abs(grid[i][j] - grid[i - 1][j]) == 1 && Math.abs(grid[i][j] - grid[i][j - 1]) == 1){
					dp[i][j]  = Math.max(dp[i - 1][j], dp[i][j - 1]) + 1;
				}
				else if (Math.abs(grid[i][j] - grid[i - 1][j]) == 1){
					dp[i][j] = dp[i - 1][j] + 1;
				} 
				else if (Math.abs(grid[i][j] - grid[i][j - 1]) == 1){
					dp[i][j] = dp[i][j - 1] + 1;
				} 
				else
					dp[i][j] = 1;
				max = Math.max(max, dp[i][j]);
				if (max == dp[i][j]){
					index[0] = i;
					index[1] = j;
				}
				//System.out.println("dp[" + i + "][" + j + "] = " + dp[i][j]);
			}
		}
		//System.out.println("The max length ends at index of " + index[0] + ", " + index[1]);
		printPath(grid, dp, index, max);
		return max;
	}
	public static void printPath(int[][] grid, int[][] dp, int[] index, int length){
		int[] path = new int[length];
		int x = index[0], y = index[1];
		//System.out.println("Right now, x and y equals to " + x + ", " + y);
		length--;
		//System.out.println("length is " + length);
		path[length] = grid[x][y];
		//System.out.println("path[" + length + "] = " + path[length]);
		while (x >= 0 && y >= 0 && length >= 0){
			if (dp[x][y] == 1)
				break;
			if ((x - 1) >= 0 && dp[x - 1][y] == dp[x][y] - 1){
				path[length - 1] = grid[x - 1][y];
				x--;
			}
			else if ((y - 1) >= 0 && dp[x][y - 1] == dp[x][y] - 1){
				path[length - 1] = grid[x][y - 1];
				y--;
			}
			//System.out.println("path[" + (length - 1) + "] = " + path[length - 1]);
			length--;
			//System.out.println("Now length is " + length);
			//System.out.println("Right now x and y is " + x + ", " + y);
		}
		System.out.print("(");
		int i;
		for (i = 0; i < path.length - 1; i++){
			System.out.print(path[i] + ", ");
		}
		
		System.out.println(path[i] + ")");
	}
	public static void main(String[] args){
		int[][] g = {{1,3,2,6,8}, {-9,7,1,-1,2}, {1,5,0,1,9}};
		int len = snakeSequence(g);
		System.out.println("The max length is " + len);
	}
}