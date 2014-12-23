import java.util.HashMap;
import java.util.Stack;


public class BalancedString {
	/*
	Given a string that has{},[],() and characters. 
	Check if the string is balanced. E.g. {a[(b)]} is balanced. {a[()b]} is unbalanced.
	*/
	public static boolean balancedString(String s){
		HashMap<Character, Character> hm = new HashMap<Character, Character>();
		hm.put('{', '}');
		hm.put('[', ']');
		hm.put('(', ')');
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++){
			if (!hm.containsKey(s.charAt(i)) && !hm.containsValue(s.charAt(i)))
				continue;
			if (hm.containsKey(s.charAt(i)))
				stack.push(s.charAt(i));
			else if (!stack.isEmpty() && hm.get(stack.peek()) == s.charAt(i))
				stack.pop();
			else
				return false;
		}
		return stack.isEmpty();
	}
	public static void main(String[] args){
		String s1 = "{a[(b)]}";
		boolean valid1 = balancedString(s1);
		System.out.println(valid1);
		String s2 = "{a[(b])}";
		boolean valid2 = balancedString(s2);
		System.out.println(valid2);
	}
}
