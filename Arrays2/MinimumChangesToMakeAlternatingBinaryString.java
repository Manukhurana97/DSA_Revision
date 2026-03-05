// https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string

public class MinimumChangesToMakeAlternatingBinaryString {
	pblic int minOperations(String s) {
        int n = s.length();
        String newString = new String(s+s);
        StringBuilder even = new StringBuilder();
        StringBuilder odd = new StringBuilder();
        
        for(int i=0; i<2*n; i++) {
            even.append((i & 1));
            odd.append(1 - (i & 1));
        }

        int evenDiff = 0, oddDiff = 0;
        for(int i=0; i<n; i++) {
            evenDiff += newString.charAt(i) == even.charAt(i) ? 1 : 0;
            oddDiff += newString.charAt(i) == odd.charAt(i) ? 1 : 0;
        }

        int result = Integer.MAX_VALUE;
        result = Math.min(evenDiff, oddDiff);

        int j=0;
        for(int i=n; i<2*n; i++) {
            evenDiff += newString.charAt(j) == even.charAt(j) ? 1 : 0;
            oddDiff += newString.charAt(j) == odd.charAt(j) ? 1 : 0;

            evenDiff += newString.charAt(i) == even.charAt(i) ? 1 : 0;
            oddDiff += newString.charAt(i) == odd.charAt(i) ? 1 : 0;

            result = Math.min(result, Math.min(evenDiff, oddDiff));
            j+=1;
        }

        return result;
    }
}