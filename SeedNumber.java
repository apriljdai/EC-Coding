public class SeedNumber{
	/*
	Find the seed of a number. 
	Eg : 1716 = 143*1*4*3 =1716 so 143 is the seed of 1716. 
	find all possible seed for a given number.
	*/
	public static void seedNumber(int number){
		for (int seed = (int)Math.sqrt(number); seed <= number; seed++){
			if (number % seed == 0){
				int product = seed;
				int temp = seed;
				while (temp != 0){
					product *= (temp % 10);
					temp /= 10;
				}
				if (product == number){
					System.out.println(number + " has seed number " + seed);
				}
			}
		}

	}
	public static void main(String[] args){
		seedNumber(1716);
		seedNumber(138);
		seedNumber(24);
	}
}
