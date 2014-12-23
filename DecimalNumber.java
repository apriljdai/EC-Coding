public class DecimalNumber{
	/*
	Let the user enter a decimal number. 
	The range allowed is 0.0001 to 0.9999. Only four decimal places are allowed. 
	The output should be an irreducible fraction. 
	E.g.: If the user enters 0.35, the irreducible fraction will be 7/20
	*/
	public static String decimal(double num){
		if (num > 0.9999 || num < 0.0001)
			return "";
		num *= 10000;
		//System.out.println("number is " + num);
		int i = (int)num;
		int m = maxCommandDivisor(i, 10000);
		//System.out.println("the max command divisor is " + m);
		return i / m + "/" + 10000 / m;
	}
	public static int maxCommandDivisor(int a, int b){
		//System.out.println("a is " + a + " and b is " + b);
		if (a < b){
			int temp = a;
			a = b;
			b = temp;
		}
		//System.out.println("Now a is " + a + " and b is " + b);
		if (a % b == 0)
			return b;
		else
			return maxCommandDivisor(b, a % b);
	}
	public static void main(String[] args){
		double a = 0.35;
		String s = decimal(a);
		System.out.println(a + " irreducible fraction is " + s);
	}
}

}