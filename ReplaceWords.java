public class ReplaceWords{
	/*
	Given a string. 
	Replace the words whose length>=4 and is even, 
	with a space between the two equal halves of the word. 
	Consider only alphabets for finding the evenness of the word 
	I/P "A person can't walk in this street" 
	O/P "A per son ca n't wa lk in th is str eet"
	*/
	public static String replaceWords(String s){
		StringBuilder sb = new StringBuilder();
		String[] str = s.split(" ");
		int i;
		for (i = 0; i < str.length; i++){
			char[] arr = str[i].toCharArray();
			int count = 0;
			int index = -1;
			for (int c = 0; c < arr.length; c++){
				if (alphabet(arr[c]))
					count++;
				else
					index = c;
			}
			if (count %2 == 0 && count >= 4){
				if (index != -1 && index <= count / 2){
					sb.append(str[i].substring(0, count / 2 + 1) + " ");
					if (i < str.length - 1){
						sb.append(str[i].substring(count / 2 + 1) + " ");
					}
					else{
						sb.append(str[i].substring(count / 2 + 1));
					}
				}
				else{
					sb.append(str[i].substring(0, count / 2) + " ");
					if (i < str.length - 1)
						sb.append(str[i].substring(count / 2) + " ");
					else
						sb.append(str[i].substring(count / 2));
				}
			}
			else{
				if (i < str.length - 1)
					sb.append(str[i] + " ");
				else
					sb.append(str[i]);
			}
		}
		return sb.toString();
	}
	public static boolean alphabet(char c){
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
			return true;
		return false;
	}
	public static void main(String[] args){
		String in = "A person can't walk in this street";
		System.out.println(in);
		String out = replaceWords(in);
		System.out.println(out);
	}	
}