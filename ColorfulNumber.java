import java.util.HashSet;

public class ColorfulNumber{
	/*
	A number can be broken into different sub-sequence parts. 
	Suppose a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
	And this number is a colorful number since product of every digit of a sub-sequence are different.
	That is, 3 2 4 5 (3*2)=6 (2*4)=8 (4*5)=20 (3*2*4)= 24 (2*4*5)= 40. 
	But 326 is not a colorful number as it generates 3 2 6 (3*2)=6 (2*6)=12. 
	You have to write a function that tells if the given number is a colorful number or not.
	*/
	public static boolean isColorful(int number){
		HashSet<Integer> hp = new HashSet<Integer>();
		int num = number;
		int i = 10;
		while (i < number){
			while (num >= (i / 10)){
				int temp = num % i;
				int product = getProduct(temp);
				if (hp.contains(product))
					return false;
				else{
					hp.add(product);
					num = num / 10;
				}
			}
			num = number;
			i *= 10;
		}
		return true;
	}

	public static int getProduct(int number){
		if (number < 10)
			return number;
		int ans = 1;
		while (number > 0){
			ans = ans * (number % 10);
			number /= 10;
		}
		return ans;
	}

	public static void main(String[] args){
		int num = 3245;
		System.out.println(isColorful(num));
		int num2 = 236;
		System.out.println(isColorful(num2));
		int num3 = 230;
		System.out.println(isColorful(num3));
	}
}