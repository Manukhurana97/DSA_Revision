 public class EvaluatingBooleanExpressionToTrue{
	private int evaluateExpression(String exp){
		int n = exp.length();

		char[] ch = exp.toCharArray();

		// return recursion(0, ch.length-1, true, ch);

		int[][][] dp = new int[n][n][2];
		// return memoization(0, n-1, true, ch, dp);

		return tabulation(ch, dp);
	}

	private int recursion(int i, int j, boolean isTrue, char[] ch){
		if(i>j) return 0;

		if (i == j) {
            if (isTrue) {
                return ch[i] == 'T' ? 1 : 0;
            } else {
                return ch[i] == 'F' ? 1 : 0;
            }
        }


		int ways = 0;
		for(int ind = i+1; ind<=j-1; ind+=2){
			int lt = recursion(i, ind - 1, true, ch); // looking for left partion to be true
            int lf = recursion(i, ind - 1, false, ch); // looking for left partion to be false
            int rt = recursion(ind + 1, j, true, ch); // looking for right partion to be true
            int rf = recursion(ind + 1, j, false, ch); // looking for right partion to be false

			if(ch[ind] == '&'){
							// if we wan true : if we want false 
				ways +=  isTrue ? (lt * rt) : (lf * rt + lt * rf + lf * rf); 
			}else if(ch[ind] == '^'){
							// if we wan true : if we want false 
				ways += isTrue ? (lt * rf | lf * rt) : (lt * rt + lf * rf);
			}else {
							// if we wan true : if we want false 
				ways += isTrue ? (lt * rt + lt* rf + lf * rt) : (lf * rf);
			}
		}

		return ways;
	}


	private int memoization(int i, int j, boolean isTrue, char[] ch, int[][][] dp){
		if(i>j) return 0;

		if(dp[i][j][isTrue?1:0] != 0) return dp[i][j][isTrue?1:0];

		if (i == j) {
            if (isTrue) {
                return ch[i] == 'T' ? 1 : 0;
            } else {
                return ch[i] == 'F' ? 1 : 0;
            }
        }


		int ways = 0;
		for(int ind = i+1; ind<=j-1; ind+=2){
			int lt = memoization(i, ind - 1, true, ch, dp);
            int lf = memoization(i, ind - 1, false, ch, dp);
            int rt = memoization(ind + 1, j, true, ch, dp);
            int rf = memoization(ind + 1, j, false, ch, dp);

			if(ch[ind] == '&'){
				ways +=  isTrue ? (lt * rt) : (lf * rt + lt * rf + lf * rf); 
			}else if(ch[ind] == '^'){
				ways += isTrue ? (lt * rf | lf * rt) : (lt * rt + lf * rf);
			}else {
				ways += isTrue ? (lt * rt + lt* rf + lf * rt) : (lf * rf);
			}
		}

		return dp[i][j][isTrue?1:0] = ways;
	}


	private int tabulation(char[] ch, int[][][] dp){
		int n = ch.length;

		for(int i=n-1; i>=0; i--){
			for(int j=0; j<n; j++){
				for(int isTrue = 0; isTrue<2; isTrue++){

					if(i>j){
						dp[i][j][isTrue] = 0;
					 	continue;
					}

					if (i == j) {
			            if (isTrue==1) {
			                dp[i][j][isTrue] = ch[i] == 'T' ? 1 : 0;
			            } else {
			                dp[i][j][isTrue] = ch[i] == 'F' ? 1 : 0;
			            }
			            continue;
			        }


					int ways = 0;
					for(int ind = i+1; ind<=j-1; ind+=2){
						int lt = dp[i][ind - 1][1];
			            int lf = dp[i][ind - 1][0];
			            int rt = dp[ind + 1][j][1];
			            int rf = dp[ind + 1][j][0];

						if(ch[ind] == '&'){
							ways +=  isTrue == 1 ? (lt * rt) : (lf * rt + lt * rf + lf * rf); 
						}else if(ch[ind] == '^'){
							ways += isTrue == 1 ? (lt * rf | lf * rt) : (lt * rt + lf * rf);
						}else {
							ways += isTrue == 1 ? (lt * rt + lt* rf + lf * rt) : (lf * rf);
						}
					}

				dp[i][j][isTrue] = ways;
				}
			}
		}

		return dp[0][n-1][1];
	}


	public static void main(String[] args) {
        EvaluatingBooleanExpressionToTrue evaluator = new EvaluatingBooleanExpressionToTrue();
        String expression = "T|F&T^T";
        System.out.println("Ways to evaluate to true: " + evaluator.evaluateExpression(expression));
    }
}