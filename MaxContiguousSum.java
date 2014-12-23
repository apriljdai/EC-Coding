public class MaxContiguousSum{
	/*
	Find the largest sum contiguous sub array. 
	The length of the returned sub array must be at least of length 2.
	*/
	public static int maxSum(int[] num){
		if (num == null || num.length == 0)
			return 0;
		int temp = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < num.length; i++){
			temp += num[i];
			max = Math.max(temp, max);
			temp = Math.max(temp, 0);
		}
		return max;
	}
	public static void main(String[] args){
		int[] num = {2,3 , -2 , 4 , -8 , 8, 9, -2, 10};
		int max = maxSum(num);
		System.out.println(max);
	}
}