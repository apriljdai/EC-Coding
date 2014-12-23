public class PhoneNumber{
	/*
	Print all valid phone numbers of length n subject to following constraints: 
	If a number contains a 4, it should start with 4 
	No two consecutive digits can be same 
	Three digits (e.g. 7,2,9) will be entirely disallowed, take as input
	*/
	public static void phoneNumber(int n, char num1, char num2, char num3){
		StringBuilder digits = new StringBuilder();
		for (char i = '0'; i <= '9'; i++){
			if (i == num1 || i == num2 || i == num3)
				continue;
			else
				digits.append(i);
		}
		phoneNumber(n, digits.toString(), "");
	}
	public static void phoneNumber(int len, String digits, String phone){
		if (phone.length() == len){
			System.out.println(phone);
			return;
		}
		for (int i = 0; i < digits.length(); i++){
			if (phone.length() > 0){
				if (phone.charAt(phone.length() - 1) == digits.charAt(i))
					continue;
				if (digits.charAt(i) == '4' && phone.charAt(0) != '4')
					continue;
			}
			phoneNumber(len, digits, phone + digits.charAt(i));
		}
	}
	public static void main(String[] args){
		int n = 2; 
		phoneNumber(n,'1','2','5');
	}
}
