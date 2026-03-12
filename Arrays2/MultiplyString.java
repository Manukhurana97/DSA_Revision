// https://leetcode.com/problems/multiply-strings/

public class MultiplyString {
    public String multiply(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        int[] result = new int[n+m];

        for(int i=n-1; i>=0; i--) {
            for(int j=m-1; j>=0; j--) {
                int mat = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mat + result[i+j+1];
            
                result[i+j+1] = sum % 10;
                result[i+j] += sum / 10;
            }
        }

        StringBuilder builder = new StringBuilder();
        for(int i: result) {
            builder.append(i);
        }

        while(builder.length() > 0 && builder.charAt(0) == '0') {
            builder.deleteCharAt(0);
        }

        return builder.length() == 0 ? "0" :builder.toString();
    }
}