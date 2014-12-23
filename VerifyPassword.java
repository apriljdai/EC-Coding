public class VerifyPassword{
	/*
	Verify if the given password is valid/invalid; 
	1. must be 5-12 characters long 
	2. must contain at least one number and one lowercase character 
	3. a sequence must not be followed by the same sequence 
	   (like 123123qs is invalid, 123qs123 is valid)
	*/
	public static boolean verifyPassword(String pwd){
		//must be 5-12 characters long
		if (pwd.length() > 12 || pwd.length() < 5)
			return false;
		System.out.println("pwd pass the length requirement.");
		//must contain at least one number and one lowercase character
		boolean number = false;
		boolean lowercase = false;
		for (int i = 0; i < pwd.length(); i++){
			if (number == false && (pwd.charAt(i) >= '0' && pwd.charAt(i) <= '9'))
				number = true;
			if (lowercase == false && (pwd.charAt(i) >= 'a' && pwd.charAt(i) <= 'z'))
				lowercase = true;
		}
		if (number == false || lowercase == false)
			return false;
		System.out.println("pwd pass the number and char requirement.");
		//a sequence must not be followed by the same sequence

		for (int i = 0; i < pwd.length(); i++){
			char c = pwd.charAt(i);
			System.out.println("char is: " + c);
			int i2 = pwd.indexOf(c, i + 1);
			System.out.println("The index of i2 is: " + i2);
			if (i2 != -1){
				String s1 = pwd.substring(i, i2);
				System.out.println("s1 is: " + s1);
				if (2 * i2 - i < pwd.length()){
					String s2 = pwd.substring(i2, 2 * i2 - i);
					System.out.println("s2 is: " + s2);
					if (s1.equals(s2))
						return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args){
		String pwd = "A1b3ovdas";
		boolean valid = verifyPassword(pwd);
		//String pwd1 = "ABCDEFG";
		//boolean valid1 = verifyPassword(pwd1);
		if (valid)
			System.out.println("The password is Valid!");
		else
			System.out.println("The password if Invalid!");
	}
}
