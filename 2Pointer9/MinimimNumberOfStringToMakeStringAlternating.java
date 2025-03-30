// https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/

public class MinimimNumberOfStringToMakeStringAlternating{
	public int minFlips(String s) {
       int  slen = s.length();
        s+=s; // 2x string

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            s1.append((i % 2 == 0) ? "0": "1");
            s2.append((i % 2 == 0) ? "1": "0");
        }

        int s1DiffCount = 0, s2DiffCount = 0, last = 0, minFreq = Integer.MAX_VALUE;
        
        for(int i = 0;i < s.length(); i++){
            // one validation is performed on s (orignal len) the just move to next change but bofore thar remove from first and add in last 
            if(i >= slen){
                s1DiffCount -= s.charAt(last) != s1.charAt(last) ? 1 : 0;
                s2DiffCount -= s.charAt(last) != s2.charAt(last) ? 1 : 0;
                last++;
            }

            s1DiffCount += s.charAt(i) != s1.charAt(i) ? 1 : 0;
            s2DiffCount += s.charAt(i) != s2.charAt(i) ? 1 : 0;

            if(i>=slen-1) minFreq = Math.min(minFreq, Math.min(s1DiffCount, s2DiffCount));
            
        }

        return minFreq;
    }
}