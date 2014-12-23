import java.util.Stack;


public class Palindrome {
	/*
	The decimal and octal values of some numbers are both palindromes sometimes. 
	Find such numbers within a given range.
	*/
	public static void palindrome(int start, int end){
		for (int i = start; i <= end; i++){
			//System.out.println("the decimal number is " + i);
			boolean decimal = isPalindrome(String.valueOf(i));
			int octalNum = toOctal(i);
			//System.out.println("the octal number is " + octalNum);
			boolean octal = isPalindrome(String.valueOf(octalNum));
			if (decimal && octal)
				System.out.println(i);
		}
	}
	public static boolean isPalindrome(String s){
		int left = 0, right = s.length() - 1;
		while (left < right){
			if (s.charAt(left) != s.charAt(right))
				return false;
			else{
				left ++;
				right --;
			}
		}
		return true;
	}
	public static int toOctal(int n){
		Stack<Integer> stack = new Stack<Integer>();
		while (n != 0){
			int temp = n % 8;
			stack.push(temp);
			n /= 8;
		}
		int res = 0;
		while (!stack.isEmpty()){
			res = res * 10 + stack.pop();
		}
		return res;
	}
	public static void main(String[] args){
		int s = 0;
		int e = 1000;
		palindrome(s,e);
	}
}

