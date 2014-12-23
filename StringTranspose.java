import java.util.ArrayList;
import java.util.HashMap;


public class StringTranspose{
	/*
	Given two strings, 
	you need to transpose the first string to the second string 
	by means of only swaps between 2 consecutive characters in the first string. 
	This must be performed by doing a series of these swaps in order to get the second string.
	*/
	public static ArrayList<String> transpose(String s1, String s2){
		ArrayList<String> res = new ArrayList<String>();
		if (s1.length() != s2.length())
			return res;
		res.add(s1);
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for (int i = 0; i < s2.length(); i++){
			hm.put(s2.charAt(i), i);
		}
		for (int i = 0; i < s1.length(); i++){
			if (!hm.containsKey(s1.charAt(i)))
				return null;
			int index = hm.get(s1.charAt(i));
			if (index != i){
				s1 = swap(s1, i, index, res);
				i--;
			}
		}
		return res;
	}
	public static String swap(String s1, int start, int end, ArrayList<String> res){
		for (int i = start; i < end; i++){
			s1 = s1.substring(0, i) + s1.charAt(i + 1) + s1.charAt(k) + s1.substring(k + 2);
			res.add(s1);
		}
		return s1;
	}
	public static void main(String[] args){
		String s1 = "GUW";
		String s2 = "WUG";
		ArrayList<String> res = transpose(s1, s2);
		for (int i = 0; i < res.size(); i++){
			System.out.println(res.get(i));
		}
	}
}