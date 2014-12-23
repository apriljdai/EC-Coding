public class SecurityKeypad{
	/*
	There is a security keypad at the entrance of a building. 
	It has 9 numbers 1 - 9 in a 3x3 matrix format. 
	1 2 3 
	4 5 6 
	7 8 9 	
	The security has decided to allow one digit error for a person 
	but that digit should be horizontal or vertical. 
	Example: for 5 the user is allowed to enter 2, 4, 6, 8 
	or for 4 the user is allowed to enter 1, 5, 7. 
	IF the security code to enter is 1478 and if the user enters 1178 he should be allowed. 
	Write a function to take security code from the user 
	and print out if he should be allowed or not.
	*/
	public static boolean securityKeypad(int[] user, int[] target){
		int[][] keypad = {{1,2,3}, {4,5,6}, {7,8,9}};
		boolean mistake = false;
		for (int i = 0; i < target.length; i++){
			if (user[i] != target[i]){
				if (mistake){
					return false;
				}
				for (int r = 0; r < 3; r++){
					for (int c = 0; c < 3; c++){
						if (user[i] == keypad[r][c]){
							boolean solve = false;
							if (c - 1 >= 0 && target[i] == keypad[r][c - 1])
								solve = true;							
							if (c + 1 <= 2 && target[i] == keypad[r][c + 1])
								solve = true;
							if (r - 1 >= 0 && target[i] == keypad[r - 1][c])
								solve = true;
							if (r + 1 <= 2 && target[i] == keypad[r + 1][c])
								solve = true;
							if (solve == false)
								return false;
						}
					}
				}
				mistake = true;
			}
		}
		return true;
	}
	public static void main(String[] args){
		int[] user = {1, 1, 4, 7};
		int[] tar = {1, 2, 4, 7};
		if (securityKeypad(user, tar))
			System.out.println("Allowed");
		else
			System.out.println("Not Allowed");
	}
}
