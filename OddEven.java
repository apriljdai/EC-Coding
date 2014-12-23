public class OddEven{
	/*Take a series of integers as input till a zero is entered. 
	Among these given integers, 
	find the maximum of the odd numbers and the minimum of the even integers 
	(not including zero) and print them.
	*/
	public static void oddeven(int[] num){
		int odd = Integer.MIN_VALUE;
		int even = Integer.MAX_VALUE;
		for (int n: num){
			if (isOdd(n))
				odd = Math.max(odd, n);
			else
				even  = Math.min(even, n);
		}
		System.out.println("The max odd number is " + odd + " and the min even number is " + even);
	}
	public static boolean isOdd(int num){
		if (num % 2 == 0)
			return false;
		return true;
	}
	public static void main(String[] args){
		int[] num = {1,3,5,2,7,123,85,90,23,6,-1, 29, -20};
		oddeven(num);
	}
	//use system.in 
	public static void main(String[] args){
		int odd = Integer.MIN_VALUE;
		int even = Integer.MAX_VALUE;
		Scanner in = new Scanner(System.in);
		while (true){
			int curr = in.nextInt();
			if (curr == 0)
				break;
			if (isOdd(curr))
				odd = Math.max(odd, curr);
			else
				even  = Math.min(even, curr);
		}
		System.out.println("The max odd number is " + odd + " and the min even number is " + even);
	}
	public static boolean isOdd(int num){
		if (num % 2 == 0)
			return false;
		return true;
	}
}