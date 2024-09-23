import java.util.*;


public class LongestGreatingCharacterReplacement{


    public static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxLen = 0; int maxFreq = 0;

        for(int i = 0;i < s.length(); i++){
            for(int j = i+1; j<s.length();j++){
                int val = s.charAt(j) - 'A';
                count[val]++;

                maxFreq = Math.max(maxFreq, count[i]); // max freq of i
                int diff = ((j-i+1) - maxFreq);

                if(diff <= k) maxLen = Math.max(maxLen, j-i+1); // valid window :: maxFreq - k under 0
                else break;
            }
        }

        return maxLen;
    }



    public static int characterReplacement2(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();
        int l = 0, maxLength = 0, maxFreq = 0;

        for(int r=0; r<s.length(); r++){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            // result will going to be max if we find the max freq ( len - maxFreq <= k)
            // if we dont do this, then we need to count the max freq of each time will take O(26 time)
            maxFreq = Math.max(maxFreq, map.get(s.charAt(r)));


            while(l<=r && r - l + 1 - maxFreq >k){ // valid window 
                map.put(s.charAt(l),  map.get(s.charAt(l)) - 1);
                l++;
            }

            maxLength = Math.max(maxLength, r - l + 1);
        }    

        return maxLength;
    }



    public static int characterReplacement3(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();
        int l = 0, maxLength = 0, maxFreq = 0;

        for(int r=0; r<s.length(); r++){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            
            maxFreq = Math.max(maxFreq, map.get(s.charAt(r)));

            // let the max window be as its , even if we reduce the window size it will not contribute to ans   
            if(l<=r && r - l + 1 - maxFreq >k){
                map.put(s.charAt(l),  map.get(s.charAt(l)) - 1);
                l++;
            }

            maxLength = Math.max(maxLength, r - l + 1);
        }    

        return maxLength;
    }


    public static void main(String[] args) {
        int result1 = characterReplacement3("ABAB", 2);
        int result2 = characterReplacement3("ABCDE", 1);
        int result3 = characterReplacement3("AABABBA", 1);
        int result4 = characterReplacement3("AAAA", 2);
        int result5 = characterReplacement3("AABBBCCDDDEEE", 3);

        System.out.println(result1);  // Output: 4
        System.out.println(result2);  // Output: 2
        System.out.println(result3);  // Output: 4
        System.out.println(result4);  // Output: 4
        System.out.println(result5);  // Output: 7

    }

}