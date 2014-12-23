public class SubstringAddition{
	/*
	Write a program to add the substring 
	eg :say you have a list {1 7 6 3 5 8 9 } and user is entering a sum 16.
	Output should display (2-4) that is {7 6 3} cause 7+6+3=16.
	*/
	public static void substringAddition(int sum, int[] num){
		int[] totalsum = new int[num.length];
		int currSum = 0;
		for (int i = 0; i < num.length; i++){
			currSum += num[i];
			totalsum[i] = currSum;
			//System.out.println(totalsum[i]);
		}
		for (int i = 0; i < totalsum.length - 1; i++){
			for (int j = i + 1; j < totalsum.length; j++){
				if (totalsum[j] - totalsum[i] == sum){
					//System.out.println(i + ", " + j);
					System.out.println("(" + (i+2) + "-" + (j+1) + ")");
				}
			}
		}
	}
	public static void main(String[] args){
		int[] num = {1, 7, 6, 3, 5, 8, 9};
		substringAddition(16, num);
	}
}

}