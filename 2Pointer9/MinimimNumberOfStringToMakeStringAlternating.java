public class MinimimNumberOfStringToMakeStringAlternating{
	public int minFlips(String s) {
       int  slen = s.length();
        s+=s;

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            s1.append((i % 2 == 0) ? "0": "1");
            s2.append((i % 2 == 0) ? "1": "0");
        }

        int s1DiffCount = 0, s2DiffCount = 0, last = 0, minFreq = Integer.MAX_VALUE;
        
        for(int i = 0;i < s.length(); i++){
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