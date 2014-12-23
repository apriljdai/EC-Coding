import java.util.HashMap;


public class BullsAndCows {
	/*There’s a word guessing game. 
	One person think a word, and the other one guess a word, both words have the same length. 
	The person should return the number of bulls and cows for the guessing. 
	Bulls represent the number of same characters in the same spots, 
	whereas cows represent the number of characters guessed right but in the wrong spots. 
	Write a program with two input strings, return the number of bulls and cows.
	*/
	public static int[] bullcow(String s1, String s2){
		int[] res = new int[2];
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s1.length(); i++){
			map.put(s1.charAt(i), i);
		}
		for (int i = 0; i < s2.length(); i++){
			if (map.containsKey(s2.charAt(i))){
				int index = map.get(s2.charAt(i));
				if (index == i)
					res[0]++;
				else
					res[1]++;
			}
		}
		return res;
	}
	public static void main(String[] args){
		String s1 = "study";
		String s2 = "style";
		int[] guess = bullcow(s1, s2);
		System.out.println("The string " + s1 + " and string " + s2 + " has bulls " + guess[0] + " and cows " + guess[1]);
	}
}
