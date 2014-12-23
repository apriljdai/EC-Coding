public class ValidPassword{
	/*
	In 1-9 keypad one key is not working. 
	If some one enters a password then not working key will not be entered. 
	You have given expected password and entered password. 
	Check that entered password is valid or not. 
	Ex: entered 164, expected 18684 
	(you need to take care as when u enter 18684 and 164 only both will be taken as 164 input)
	*/
	public static boolean validPassword(String enter, String expect){
		char broken = '\0';
		int j = 0;
		for (int i = 0; i < expect.length(); i++){
			if (j >= enter.length()){
				if (expect.charAt(i) != broken)
					return false;
				else
					continue;
			}
			System.out.println("Now enter char is " + enter.charAt(j) + " and expect char is " + expect.charAt(i));
			if (enter.charAt(j) != expect.charAt(i)){
				if (broken == '\0'){
					broken = expect.charAt(i);
				}
				else if (broken == expect.charAt(i))
					continue;
				else
					return false;
			}
			else
				j++;
		}
		return true;
	}
	public static void main(String[] args){
		String s1 = "164";
		String s2 = "186848888";
		boolean valid = validPassword(s1, s2);
		if (valid)
			System.out.println(s1 + " is valid.");
		else
			System.out.println(s1 + " is invalid.");

	}
}