public class KeypadPermutation {
	/*
	Phone has letters on the number keys. 
	for example, number 2 has ABC on it, number 3 has DEF, 4 number has GHI,... , 
	and number 9 has WXYZ. 
	Write a program that will print out all of the possible combination of those letters 
	depending on the input.
	*/
	public static void keypadPermutation(String num){
		String[] keypad = {"","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
		//System.out.println("num is " + num + " and the length of the number is " + num.length());
		combination(num, num.length() - 1, keypad, "");
	}
	public static void combination(String num, int length, String[] keypad, String letter){
		//System.out.println("Now the length is " + length);
		if (length < 0){
			System.out.println(new String(letter));
			return;
		}
		int keyIndex = num.charAt(0) - '1';
		//System.out.println("The key index is " + keyIndex);
		//System.out.println("Now the letter is " + letter);
		String s = keypad[keyIndex];
		for (int i = 0; i < s.length(); i++){
			combination(num.substring(1), length - 1, keypad, letter + s.charAt(i));
		}
	}
	public static void main(String[] args){
		String s = "237";
		keypadPermutation(s);
	}
}
