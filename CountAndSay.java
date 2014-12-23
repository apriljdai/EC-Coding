public class CountAndSay {
    /*
    First, let user input a number, say 1. 
    Then, the function will generate the next 10 numbers which satisfy this condition: 
    1, 11,21,1211,111221,312211... 
    explanation: first number 1, second number is one 1, so 11. 
    Third number is two 1(previous number), so 21. 
    next number one 2 one 1, so 1211 and so on...
    */

    public String countAndSay(int n) {
        if (n <= 1)
            return String.valueOf(1);//Returns the string representation of the int argument.
        else
            return helper(countAndSay(n - 1));
    }
    public String helper(String s){
        int count = 1;
        int i = 0;
        StringBuffer sb = new StringBuffer();
        //Constructs a string buffer with no characters in it and an initial capacity of 16 characters.
        while (i < s.length()){
            int j = i + 1;
            while (j < s.length() && s.charAt(j) == s.charAt(i)){
                count ++;
                j++;
            }
            sb.append(count);//Appends the string representation of the char argument to this sequence.
            sb.append(s.charAt(i));
            i = j;
            count = 1;
        }
        return sb.toString();//Returns a string representing the data in this sequence
    }
    public static void main(String[] args){
        for (int i = 1; i < 11; i++){
            String s = countAndSay(i);
            System.out.println(s);
        }
    }
}