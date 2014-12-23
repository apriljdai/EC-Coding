public class Palindrome{
	/*
	Print all palindromes of size greater than or equal to 3 of a given string.
	*/
	*
	Print all palindromes of size greater than or equal to 3 of a given string.
	*/
	public static void palindrome(String str){
		if (str == null || str.length() < 3)
			return;
		for (int i = 0; i < str.length() - 2; i++){
			for (int j = i + 3; j <= str.length(); j++){
				if (isPalindrome(str.substring(i, j)))
					System.out.println(str.substring(i, j));
			}
		}
	}
	public static boolean isPalindrome(String s){
		int left = 0, right = s.length() - 1;
		while (left < right){
			if (s.charAt(left) != s.charAt(right))
				return false;
			left ++;
			right --;
		}
		return true;
	}
	public static void main(String[] args){
		//String s = "abccaabcddcbacabcbaddbabd";
		String s = "aabcbcba";
		palindrome(s);
	}
	//dynamic programming
	public static void palindrome(String str){
		int len = str.length();
		boolean[][] dp = new boolean[len][len];
		for (int i = 0; i < len; i++){
			dp[i][i] = true;
		}
		
	}
}