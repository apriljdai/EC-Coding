public class ReplaceString{
	/*
	From a given string, replace all instances of 'a' with 'one' and 'A' with 'ONE'. 
	Example Input: 
	" A boy is playing in a garden" 
	Example Output: 
	" ONE boy is playing in one garden" 
	-- Not that 'A' and 'a' are to be replaced only when they are single characters, 
	not as part of another word.
	*/
	public static String replaceString(String s){
		String[] str = s.split(" ");
		StringBuilder sb = new StringBuilder();
		int i;
		for (i = 0; i < str.length - 1; i++){
			if (str[i].equals("A")){
				sb.append("ONE ");
				continue;
			}
			if (str[i].equals("a")){
				sb.append("one ");
				continue;
			}
			else{
				sb.append(str[i] + " ");
			}
		}
		if (str[i].equals("A"))
			sb.append("ONE");
		if (str[i].equals("a"))
			sb.append("one");
		else
			sb.append(str[i]);
		return sb.toString();
	}
	public static void main(String[] args){
		String s = "A boy playing in a garden";
		System.out.println(s);
		String r = replaceString(s);
		System.out.println(r);
	}
}
