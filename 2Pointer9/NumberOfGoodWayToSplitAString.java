// https://leetcode.com/problems/number-of-good-ways-to-split-a-string/

public class NumberOfGoodWayToSplitAString {
    public int numSplits(String s) {
        int count = 0;
        for(int i=1; i<s.length(); i++) {
            count += (Math.abs(distinct(0, i, s) - distinct(i, s.length(), s)) == 0) ? 1 : 0;
        }

        return count;
    }

    private int distinct(int start, int end, String s) {
        Set<Character> set = new HashSet<>();
        for(int i=start; i<end; i++) {
            set.add(s.charAt(i));
        }

        return set.size();
    } 


    public int numSplits(String s) {
        int n = s.length(), count = 0;

        int[] left = new int[n];

        Set<Character> set = new HashSet<>();
        for(int i=0; i<n; i++) { 
            set.add(s.charAt(i));
            left[i] = set.size();
        }

        set.clear();
        for(int i=n-1; i>=0; i--) {
            count += (left[i] == set.size()) ? 1 : 0;   

            set.add(s.charAt(i));
        }

        return count;
    }

    public int numSplits(String s) {
        int count = 0, distinctLeft = 0, distinctRight = 0;
        int[] left = new int[26];
        int[] right = new int[26];

        for(char ch: s.toCharArray()) {
            if(right[ch - 'a'] == 0) distinctRight++;
            right[ch - 'a'] += 1;
        }

        for(int i=0; i<s.length()-1; i++) {
            char ch = s.charAt(i);

            if(left[ch - 'a'] == 0) distinctLeft++;
            left[ch - 'a'] += 1;

            right[ch - 'a'] -= 1;
            if(right[ch - 'a'] == 0) distinctRight--;
            

            if(distinctLeft == distinctRight) count+=1;
        }

        return count;
    }
}