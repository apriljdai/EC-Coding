public class SeparateNumber{
	/*
	Print the sequences from the input given by the user separated by semicolon 
	e.g.: 4678912356012356 
	output: 4;6789;123;56;0123;56;
	*/
	public static void separateNumber(String str){
		StringBuilder sb = new StringBuilder();
		separateNumber(str, sb, 0, 0);
	}
	public static void separateNumber(String str, StringBuilder sb, int start, int end){
		for (int i = 0; i < str.length() - 1; i++){
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
				if (str.charAt(i) == str.charAt(i + 1) - 1)
					end ++;
				else{
					if (start != end)
						sb.append(str.substring(start, end + 1) + ";");
					start = i + 1; 
					end  = start;
				}
			}
		}
		System.out.println(sb.toString());		
	}
	public static void main(String[] args){
		String s = "4678912356012356";
		separateNumber(s);
		String t = "156345912333";
		separateNumber(t);
	}
}