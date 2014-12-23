public class CoinChange{
	/*
	Something cost $10.25 and the customer pays with a $20 bill, 
	the program will print out the most efficient "change-breakdown" 
	which is 1 five, 4 ones, and 3 quarters.
	Find the minimum number of coins required to make change for a given sum 
	(given unlimited cumber of N different denominations coin)
	*/
	public static void coinChange(int[] coins, int sum){
		//list from 0 to sum array
		int[] minCoin = new int[sum + 1];
		minCoin[0] = 0;
		for (int i = 1; i < sum + 1; i++)
			minCoin[i] = Integer.MAX_VALUE;
		for (int i = 1; i < sum + 1; i++){
			for (int j = 0; j < coins.length; j++){
				//make sure the coins[j] is less or equal to the index of sum array
				//
				if (coins[j] <= i && minCoin[i - coins[j]] != Integer.MAX_VALUE && minCoin[i - coins[j]] + 1 < min.coins[i])
					minCoin[i] = minCoin[i - coins[j]] + 1;
			}
		}
		if (minCoin[sum] == Integer.MAX_VALUE){
			System.out.println("Not exist any change for sum.");
			return;
		}
		else
			return minCoin[sum];
	}
	public static void main(String[] args){
		Scanner input = new Sanner(System.in);
		int n = input.nextInt();
		int[] coins = new int[n];
		for (int i = 0; i < n; i++){
			coins[i] = input.nextInt();
		}
		int sum = input.nextInt();
		coinChange(coins, sum);
	}
}