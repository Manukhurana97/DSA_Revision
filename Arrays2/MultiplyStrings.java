https://leetcode.com/problems/multiply-strings/submissions/2070526147/


class MultiplyStrings {
	public String multiply(String num1, String num2) {
        int[] res = new int[401];
        int step = 0;


        for(int j=num2.length()-1; j>=0; j--) {
            int ind = 0, carry = 0;
            for(int i=num1.length()-1; i>=0; i--) {
                int n = res[step + ind] + (num1.charAt(i)-'0') * (num2.charAt(j) - '0') + carry;
                res[step + ind++] = n % 10;
                carry = n / 10;
            }
            if(carry > 0) res[step + ind++] += carry;
            step += 1;
        }
        
        StringBuilder builder = new StringBuilder();
        int t = num1.length() + num2.length();
        for(int i=t-1; i>=0; i--) builder.append(res[i]);

        while(builder.length() > 1 && builder.charAt(0) == '0') builder.deleteCharAt(0); // remove 0 from starting 
        
        return builder.toString();
    }
}
