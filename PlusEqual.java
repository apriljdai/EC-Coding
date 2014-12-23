public class PlusEqual {
	/*
	Given a number find whether the digits in the number can be used to form an equation with + and '='. 
	That is if the number is 123, we can have a equation of 1+2=3. 
	But even the number 17512 also forms the equation 12+5=17.
	*/
	public static boolean plusEqual(String num){
		int mid = num.length() / 2;
		for (int i = 0; i < mid; i++){
			for (int j = i + 1; j < mid + i + 1; j++){
				int n1 = Integer.parseInt(num.substring(0, i + 1));
				int n2 = Integer.parseInt(num.substring(i + 1, j + 1));
				int n3 = Integer.parseInt(num.substring(j + 1));
				boolean temp = check(n1, n2, n3);
				if (temp)
					return true;
				else
					continue;
			}
		}
		return false;
	}
	public static boolean check(int n1, int n2, int n3){
		int max = Math.max(n1, Math.max(n2, n3));
		int min = Math.min(n1, Math.min(n2, n3));
		int mid = n1 + n2 + n3 - max - min;
		if (max == mid + min)
			return true;
		else
			return false;
	}
	public static void main(String[] args){
		String s = "12315";
		boolean check = plusEqual(s);
		System.out.println(check);
	}
}
