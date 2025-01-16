// https://leetcode.com/problems/palindromic-substrings/description/

public class PalandromicSubString{

    public int countSubstrings(String s) {
        int n = s.length(), count = 0;
        
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(isPalandrome1(i, j, s)){
                    count += 1;
                }
            }
        }

        return count;
    }


    private boolean isPalandrome(int start, int end, String s){
        while(start<end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }



    // ---------------------------------------------------------------------------------------------



    public int countSubstrings(String s) {
        int count = 0;
        
        // consider each element as center and check for its left-- and right++
        for(int i=0; i<s.length(); i++){
            count += palandromeCount(i, i, s); // for odd
            count += palandromeCount(i, i+1, s); // for even
        }

        return count;
    }

    // check if string is palandrome then increment the count; 
    private int palandromeCount(int start, int end, String s){
        int count = 0;
        while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end)){
            start-=1;
            end+=1;
            count+=1;
        }
        return count;
    }
}