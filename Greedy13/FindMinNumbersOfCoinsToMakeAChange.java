import java.util.*;

public class FindMinNumbersOfCoinsToMakeAChange{

	public static int minCoins(int coins[], int m, int sum){
		if(sum == 0) return 0;

		Arrays.sort(coins);

		int count = 0, i=0, n=m-1;

		while(n>=0){
			if(coins[n] > sum) n--;
			else {
				sum-=coins[n];
				count +=1;
			}
		}

		return sum == 0 ? count : -1;  
	}

	public static void main(String[] args) {
		int coins[] =  {9, 6, 5, 1};
		System.out.println(minCoins(coins, coins.length, 11));

		int coins1[] =  {25, 10, 5};
		System.out.println(minCoins(coins1, coins1.length, 30));
	}
}