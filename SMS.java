public class SMS{
	/*
	You are given a telephone keyboard
	0-0, 1-1, 2-ABC2, 3-DEF3, 4-GHI4, 5-JKL5, 6-MNO6, 7-PQRS7, 8-TUV8, 9-WXYZ9, *-space, #-char separater
	if you type "2", you will get 'A', that is "2"-'A', "22"-'B' , "222"-'C', "2222"-'D'
	However, the digits can repeated many times
	"22222"-you get 'A' again 
	You can use "#" to separate characters, for example
	"2#22", you get "AB"	
	However, you may also have consecutive different digits without separator: "23"-'AD'
	If you type "*", it means space.
	You a given a sequence of digits, translate it into a text message
	*/
	public static String message(String digits){
		StringBuilder res = new StringBuilder();
		String[] key = {"", "ABC2", "DEF3", "GHI4", "JKL5", "MNO6", "PQRS7", "TUV8", "WXYZ9", "*", "0", "#"};
		//System.out.println("Key has been set.");
		for (int i = 0; i < digits.length(); i++){
			//System.out.println("Here, i is: " + i);
			if (digits.charAt(i) == '*'){
				res.append(' ');
				//System.out.println("The space has been detected!");
				continue;
			}
			if (digits.charAt(i) == '#' || digits.charAt(i) == '1')
				continue;
			else{
				int count = 1;
				int keyIndex = digits.charAt(i) - '1';
				String select = key[keyIndex];
				while (i + 1 < digits.length() && digits.charAt(i + 1) == digits.charAt(i)){
					count++;
					i++;
				}
				int index = (count - 1) % select.length();
				res.append(select.charAt(index));
			}
			//System.out.println("At this moment, result is " + res.toString());
		}
		return res.toString();
	}
	public static void main(String[] args){
		String digit = "27#777444555*2555#5553366";
		//System.out.println("The digit is: " + digit);
		String sms = message(digit);
		System.out.println(sms);
	}
}