public class TwoPrimes{
		/*
	Goldbach's conjecture : 
	Every even integer greater than 2 can be expressed as the sum of two primes. 
	Write a function which takes a number as input, 
	verify if is an even number greater than 2 and also print at least one pair of prime numbers.
	*/
	public static void twoPrimes(int num){
		if (num % 2 != 0){
			System.out.println("The number " + num + " is not even!");
			return;
		}
		for (int i = 2; i < num / 2; i++){
			if (isPrime(i) && isPrime(num - i)){
				System.out.println("The num " + num + " is the sum of " + i +" and " + (num - i));
			}
		}
	}
	public static boolean isPrime(int num){
		if (num == 2)	
			return true;
		for (int i = 2; i < num; i++){
			if (num % i == 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args){
		twoPrimes(24);
		int b = 11;
		twoPrimes(b);
		int c = 560;
		twoPrimes(c);
	}
}