import java.util.ArrayList;


public class FibbonaciNumber {
	/*
	There is one kind of numbers call Fibbonaci Number, which satisfy the following situation:
	A. can be spilt into several numbers;
	B. The first two number are the same, the next number is equal to the sum of previous two
	eg. 112 (2 = 1 + 1), 12,122,436(12 + 12 = 24, 12 + 24 = 36)
	If you are given a range by the user, find all numbers that are Fibbonaci numbers.
	*/
	public static void fibbonaci(int start, int end, ArrayList<Integer> res){
		if (start > end)
			return;
		for (int i = start; i <= end; i++){
			boolean fib = check(String.valueOf(i));
			if (fib){
				res.add(i);
				System.out.println(i);
			}
		}
	}
	public static boolean check(String num){
		for (int i = 1; i < num.length(); i++){
			//define the first number
			int n1 = Integer.parseInt(num.substring(0, i));
			if (2 * i < num.length()){
				//define the second number
				int n2 = Integer.parseInt(num.substring(i, 2 * i));
				//check if the first number and second number are equal
				if (n1 != n2)
					continue;
				int j = 2 * i;
				int temp = n1;
				//give the rest number
				int rest = Integer.parseInt(num.substring(j));
				while (temp + n2 <= rest){
					//define the third number
					int n3 = temp + n2;
					String newNum = (new Integer(n3)).toString();
					int length = newNum.length();
					//check three number linked exceed the number or not
					if (j + length > num.length())
						break;
					if (num.substring(j, j + length).equals(newNum)){
						j += length;
						//check if the number has end
						if (j == num.length())
							return true;
						//if not end, then continue
						temp = n2;
						n2 = n3;
						rest = Integer.parseInt(num.substring(j));

					}
					else
						break;
				}
			}
		}
		return false;
	}
	public static void main(String[] args){
		int start = 100;
		int end = 1000000;
		ArrayList<Integer> res = new ArrayList<Integer>();
		fibbonaci(start, end, res);
	}
}