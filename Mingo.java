import java.util.Scanner;


public class Mingo {
	/*A random generator (like a speaker standing in a group housie game calls out a number) 
	generates out any number from 1 to 500. 
	There is a 5X5 matrix. 
	A random generator assigns values to each block of this matrix(within 1 to 500 obviously). 
	Whenever, a row or a column or a diagonal is fully filled in this 5x5 from the numbers called out by the speaker, 
	its called a 'Mingo'. 
	Write a program that will find first Mingo, then second Mingo, then thirds Mingo...and so forth.
	*/
	public static void mingo(int[][] matrix){
		//a matrix to check if the number is in the matrix
		boolean[][] check = new boolean[5][5];
		//a counter to count the time of number
		int count = 0;
		boolean checkMingo = false;
		while(checkMingo == false){
			count ++;
			Scanner in = new Scanner(System.in);
			int num = in.nextInt();
			System.out.println("The number the speaker guessed is " + num);
			//int num = (int) (Math.random() * 500);
			int[] index = inMatrix(num, matrix);
			System.out.println("The index is " + index[0] + ", " + index[1]);
			if (index[0] != -1){
				check[index[0]][index[1]] = true;
				checkMingo = isMingo(check, index[0], index[1]);
			}
		}
		System.out.println("The Mingo is found after " + count + " times.");
	}
	//check if the value is in the matrix
	public static int[] inMatrix(int num, int[][] matrix){
		int[] index = {-1, -1};
		for (int i = 0; i < 5; i++){
			for (int j = 0; j < 5; j++){
				if (num == matrix[i][j]){
					index[0] = i;
					index[1] = j;
					return index;
				}
			}
		}
		return index;
	}
	//check function if mingo
	public static boolean isMingo(boolean[][] check, int r, int c){
		boolean row = true;
		boolean col = true;
		boolean diag1 = true;
		boolean diag2 = true;
		for (int i = 0; i < 5; i++){
			System.out.println("Now is check[" + i + "][" + c + "] = " + check[i][c]);
			if (check[i][c] == false){
				row = false;
				break;
			}
		}
		for (int i = 0; i < 5; i++){
			System.out.println("Now is check[" + r + "][" + i + "] = " + check[r][i]);
			if (check[r][i] == false){
				col = false;
				break;
			}
		}
		int low = Math.min(r, c);
		System.out.println("low is " + low);
		int x = r - low, y = c - low;
		System.out.println("x is " + x + ", y is " + y);
		while(x < 5 && y < 5){
			System.out.println("check[" + x + "][" + y + "] = " + check[x][y]);
			if (check[x++][y++] == false){
				diag1 = false;
				break;
			}
		}
		
		low = Math.min(r, 5 - c);
		System.out.println("Now low is " + low);
		x = r - low;
		y = 4 - low;
		System.out.println("x is " + x + ", y is " + y);
		while(x < 5 && y >= 0){
			System.out.println("check[" + x + "][" + y + "] = " + check[x][y]);
			if (check[x++][y--] == false){
				diag2 = false;
				break;
			}
		}
		if (row || col || diag1 || diag2)
			return true;
		else
			return false;
	}
	public static void main(String[] args){
		int[][] matrix = {{12, 34, 76, 19, 32}, {193, 137, 546, 189, 123}, {123, 645, 75, 165, 765}, {170, 53, 298, 70, 112}};
		mingo(matrix);
	}
}

