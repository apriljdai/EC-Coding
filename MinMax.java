import java.util.HashMap;
import java.util.Set;


public class MinMax {
	/*
	Given an NxN matrix with unique integers : Find and print positions of all numbers such that it is the biggest in its row and also the smallest in its column . e.g. : In 3 x 3 with elements 
	1 2 3 
	4 5 6 
	7 8 9 
	the number is 3 and position (1,3)
	*/
	public static int[] minMax(int[][] matrix){
		int row = matrix.length;
		int col = matrix[0].length;
		int[] res = new int[2];
		int max = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < row; i++){
			int c = 0;
			for (int j = 0; j < col; j++){
				if (matrix[i][j] > max){
					max = matrix[i][j];
					c = j;
				}
			}
			if (map.containsKey(c))
				map.put(c, Math.min(map.get(c), max));
			else
				map.put(c, max);
		}
		Set<Integer> seleted = map.keySet();
		for (Integer s : seleted){
			int r = 0;
			for (int i = 0; i < row; i++){
				if (map.get(s) > matrix[i][s])
					break;
				if (map.get(s) == matrix[i][s])
					r = i;
			}
			res[0] = r + 1;
			res[1] = s + 1;
			System.out.println(map.get(s));
		}
		return res;
	}
	public static void main(String[] args){
		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
		int[] res = minMax(matrix);
		System.out.println("The position is (" + res[0] + ", " + res[1] + ")");
	}
}

