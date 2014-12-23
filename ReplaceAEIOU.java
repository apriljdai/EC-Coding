public class ReplaceAEIOU{
	/*
	replace a,e,i,o,u with A,E,I,O,U 
	at most four eligible letters from the rear of the string are replaced 
	the first three eligible letters in the string are always exempted from replacement
	*/
	public static String replace(String s){
		if (s.length() < 4)
			return s;
		int count = 0;
		int i;
		char[] sub = s.toCharArray();
		for (i = 0; i < sub.length; i++){
			if (sub[i] == 'a' || sub[i] == 'e' || sub[i] == 'i' || sub[i] == 'o' || sub[i] == 'u'){
				count ++;
			}
			if (count == 3)
				break;
		}
		if (i < s.length()){
			count = 0; 
			for (int j = s.length() - 1; j > i; j--){
				if (sub[j] == 'a' || sub[j] == 'e' || sub[j] == 'i' || sub[j] == 'o' || sub[j] == 'u'){
					sub[j]  = (char)(sub[j] - 'a' + 'A');
					count++;
				}
				if (count == 4)
					break;
			}
		}
		String res = "";
		for (Character str: sub){
			res += str;
		}
		return res;
	}
	public static void main(String[] args){
		String s1 = "aei";
		String ans1 = replace(s1);
		System.out.println(ans1);
		String s2 = "dkafhskjiowerqpeturdlhvlasdfast";
		String ans2 = replace(s2);
		System.out.println(ans2);
		String s3 = "aeiu";
		String ans3 = replace(s3);
		System.out.println(ans3);
	}
}

