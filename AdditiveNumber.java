import java.util.ArrayList;


public class AdditiveNumber {
	/*
	An additive sequence is 1,2,3,5,8,13 where T(n) = T(n -1) + T(n - 2). 
	A number range is given to you. Find the additive sequence number in that range.
	*/
	public static void additive(int start, int end, ArrayList<Integer> res){
		//ArrayList<Integer> res = new ArrayList<Integer>();
		if (start > end)
			return;
		int count = 0; 
		for (int i = start; i <= end; i++){
			boolean isAdditive = check(String.valueOf(i));
			if (isAdditive){
				res.add(i);
				count++;
				System.out.println(i);
			}
		}
		System.out.println("The number of additive number between + " + start + " and " + end + " is " + count);
	}
	public static boolean check(String num){
		for (int i = 1; i < num.length(); i++){
			//define the first number
			int n1 = Integer.parseInt(num.substring(0, i));
			for (int j = i + 1; j < num.length(); j++){
				int temp = n1;
				//define the second number
				int n2 = Integer.parseInt(num.substring(i, j));
				int k = j;
				//get the rest number which give the range of the number
				int rest = Integer.parseInt(num.substring(k));
				while (temp + n2 <= rest){
					//generate the third number
					int n3 = temp + n2;
					String newNum = (new Integer(n3)).toString();
					int length = newNum.length();
					//check if the new number'ls length out of the boundary
					if (k + length > num.length())
						break;
					//if the original part number is equal to the new number
					if (num.substring(k, k + length).equals(newNum)){
						k += length;
						if (k == num.length())
							return true;
						//change the number to the next
						temp = n2;
						n2 = n3;
						rest = Integer.parseInt(num.substring(k, num.length()));
					}
					else{
						break;
					}
				}
			}
		}
		return false;
	}
	public static void main(String[] args){
		int start = 100;
		int end = 1000;
		ArrayList<Integer> res = new ArrayList<Integer>();
		additive(start, end, res);
	}
}