// https://leetcode.com/problems/longest-common-prefix/

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        // sol 1: 
        //  -> loop : net the min len eg:- 4
        //  -> loop min len (4) : check if character exist in all them add to string
        // time : O(n + min len) , space : O(min len) + O(1)


        int minLen = Integer.MAX_VALUE;
        for(String str: strs) minLen = Math.min(minLen, str.length());

        StringBuilder result = new StringBuilder(); 
        int n = strs.length;

        for(int i=0; i<minLen; i++) {
            char ch = strs[0].charAt(i);
            
            for(int j=1; j<n; j++) {
                if(ch != strs[j].charAt(i)) return result.toString();
            }

            result.append(ch);
        }

        return result.toString();
    }

}
