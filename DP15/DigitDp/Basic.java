/**
 * 
 * 1. Range is givin
 * 2. Perform operation on the range: e.g count the number of words / letter / numeber b/w the range
 * 3. left < right with very high constraints 10^9 ot 10^12
 * 
 * */ 

public class Basic {

	// basic idea: [0, 23] - [0, 10]: we will the the b/w value
	private static int findThreeBetween(int start, int end) {
		// tight: (we proceed from left to right) let take 23 the first char we can have is {0,1,2} we cannot 3. so the tight = 1, meaning  
		// tight=1: so far, our number is exactly equals to the prefix limit. so we are still restricting the limit. (we haven't not chosen enything yet, so the prefix is still eq to prefix of the limit)
		// tight=0: we have aleady chosen something that is smaller then the limit, so we can freely choose b/w 0-9

		return countThree(end, 100) - countThree(start-1, 100); // range, index, tight, count
	}

	public  static int countThree(int value, int constraints) {
		Integer[][][] dp = new Integer[constraints+1][2][constraints+1]; // index, boolean, count (index, count is based on constrainsts)
		return recursion(Integer.toString(value), 0, 1, 0, dp);
	}

	public static int recursion(String s, int index, int tight, int count, Integer[][][] dp) {
		if(index == s.length()) 
			return count;
		if(dp[index][tight][count] != null) 
			return dp[index][tight][count];

		int limit = (tight == 1) ? s.charAt(index) - '0' : 9; // index=0, limit=nth else 0-9
		int result = 0;

		for(int i=0; i<=limit; i++) { // range: for limit
			int updatedCount = count + (i == 3 ? 1 : 0); 
			result += recursion(s, index+1, (tight == 1 && i == limit) ? 1 : 0 , updatedCount, dp);

		}
		return dp[index][tight][count] = result;
	}

	public static void main(String[] args) {
		System.out.println(findThreeBetween(11, 23));
	}
}

/** 
for :23

	         ""
          /   |   \
         0    1    2
       /      |     \ 
     0-9     0-9     0-2 	

*/