public class AdviserNumber{
	/*
	Write a program to display the advisered average for the list of numbers 
	by omitting the three largest number in the series. 
	E.g :3,6,12,55,289,600,534,900,172.  
	avg=(3+6+12+55+289+172) /6and eliminating 534,900,600
	*/
	public static int adviserNumber(int[] num){
		int[] max = {num[0], num[1], num[2]};
		int sum = 0, total = 0;
		for (int i : max){
			sum += i;
			total += i;
		}
		max = sort(max, sum);
		for (int i = 3; i < num.length; i++){
			if (num[i] > max[0]){
				sum =sum - max[0] + num[i];
				total += num[i];
				max[0] = num[i];
				max = sort(max, sum);
			}
			else
				total += num[i];
		}
		int ans = (total - sum) / (num.length - 3);
		return ans;
	}
	public static int[] sort(int[] num, int sum){
		int[] max = new int[3];
		max[0] = Math.min(num[0], Math.min(num[1], num[2]));
		max[2] = Math.max(num[0], Math.max(num[1], num[2]));
		max[1] = sum - max[0] - max[2];
		return max;
	}
	public static void main(String[] args){
		int[] s = {90,25,12,78,56,21,7};
		int an = adviserNumber(s);
		System.out.println(an);
	}
}