public class ContinuousAlphabets{
	/*
	Print continuous alphabets from a sequence of arbitrary alphabets 
	For example: 
	Input: abcdefljdflsjflmnopflsjflasjftuvwxyz 
	Output: abcdef; mnop; tuvwxyz
	Input: AbcDefljdflsjflmnopflsjflasjftuvWxYz 
	Output: abcdef; mnop; tuvwxyz
	*/
	public static String alphabet(String s){
		s = s.toLowerCase();
		String res = "";
		int count = 1;
		for (int i = 1; i < s.length(); i++){
			if (s.charAt(i) == (s.charAt(i - 1) + 1)){
				res += s.charAt(i - 1);
				count++;
			}
			else{
				if (i < s.length()){
					if (count > 1){
						res += s.charAt(i - 1) + "; ";
						count = 1;
					}
					else
						continue;
				}
				else
					res += s.charAt(i - 1);
			}
		}
		return res;
	}
	public static void main(String[] args){
		String s = "AbcDefljdflsjflmnopflsjflasjftuvWxYz";
		String res = alphabet(s);
		System.out.println(res);
	}
}

}