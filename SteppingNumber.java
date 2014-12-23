public class SteppingNumber{
	/*
	A number is called as a stepping number if the adjacent digits are having a difference of 1. 
	For eg. 8,343,545 are stepping numbers. 
	While 890, 098 are not. The difference between a ‘9’ and ‘0’ should not be considered as 1. 
	Given start number(s) and an end number (e) your function should list out all the stepping numbers 
	in the range including both the numbers s & e.
	*/
	public static void stepNumber(long s, long e){
		//ArrayList<long> res = new ArrayList<long>();
		while (s <= e){
			if (isStepping(s))
				//res.add(s);
				System.out.println(s);
			s++;
		}
		//return res;
	}
	public static boolean isStepping(long s){
		if (s >= 0 && s <= 9)
			return true;
		while (s >= 10){
			if (Math.abs(s % 10 - (s / 10) % 10) != 1)
				return false;
			s = s / 10;
		}
		return true;
	}
	public static void main(String[] args){
		stepNumber(5, 1000);
	}
}