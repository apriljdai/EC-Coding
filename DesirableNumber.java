public class DesirableNumber{
	/*
	A number is called 'desirable' if all the digits are strictly ascending 
	eg: 159 as 1<5<9. 
	You know that your rival has a strictly numeric password that is 'desirable'. 
	Your close ally has given you the number of digits (N) in your rival's password. 
	WAP th\hjtat takes in 'N' as input and prints out all possible 'desirable' numbers that can be formed with N digits.
	*/
	public static void desirableNumber(int length){
		if (length == 0)
			return;
		desirableNumber(length, 0, "");
	}
	public static void desirableNumber(int length, int start, String s){
		if (length == 0){
			System.out.println(s);
			return;
		}
		for (int i = start; i <= 9; i++){
			desirableNumber(length - 1, i + 1, s + (char)('0' + i));
		}
	}
	public static void main(String[] args){
		desirableNumber(2);
		desirableNumber(3);
	}
}