import java.text.DecimalFormat;


public class BasketballHit {
	/*The hit rate of the basketball game is given by 
	the number of hits divided by the number of chances. 
	For example, you have 73 chances but hit 15 times, then your hit rate is 15/73=0.205 
	(keep the last 3 digits). 
	On average, you have 4.5 chances in each basketball game. 
	Assume the total number of games is 162. 
	Write a function for a basketball player. He will input the number of hits he has made, 
	the number of chances he had, and the number of remaining games. 
	The function should return the number of future hits, 
	so that he can refresh his hit rate to 0.45
	*/
	public static double hitRate(int hit, int chance, int remain){
		double curr = (double)hit / chance;
		System.out.println("Current hit rate is: " + curr);
		double futureHits = 0;
		//((futureHits + (162 - remain) * curr * 4.5) / (4.5 * 162) = 0.45
		futureHits = 0.45 * 4.5 * 162 - (4.5 * curr * (162 - remain));
		System.out.println("The future hits should be: " + futureHits);
		DecimalFormat df = new DecimalFormat("0.000");
		String s = df.format(futureHits);
		futureHits = Double.parseDouble(s);
		return futureHits;
	}
	public static void main(String[] args){
		double fh = hitRate(15, 73, 123);
		System.out.println("The future hits need to be " + fh);
	}
}
