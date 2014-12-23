public class WellOrdered{
	/*
		You know a password is well-ordered string. 
		Well-ordered string means that the order of the characters is in an alphabetical increasing order. 
		Like “abEm” is a well-ordered number. 
		However, “abmE” is not a well-order number. 
		Given an input # that tells you also how many digits are in the password, print all possible passwords.
		*/
		public static void wellOrdered(int length){
			if (length == 0)	
				return; 
			wellOrdered(length, 0, "");
		}
		public static void wellOrdered(int length, int start, String sb){
			if (length == 0){
				System.out.print(sb + ",");
				return;
			}
			for (int i = start; i < 26; i++){
				wellOrdered(length - 1, i + 1, sb + (char)('a' + i));
				wellOrdered(length - 1, i + 1, sb + (char)('A' + i));
			}
		}
		public static void main(String[] args){
			wellOrdered(2);
			wellOrdered(26);
		}
}