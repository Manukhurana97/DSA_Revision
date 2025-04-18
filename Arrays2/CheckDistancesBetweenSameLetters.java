// https://leetcode.com/problems/check-distances-between-same-letters/description/

public class CheckDistancesBetweenSameLetters{

	public boolean checkDistances(String s, int[] distance) {
        int n = s.length();
        if(n == 0) return true;
        
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            
            if(map.containsKey(ch)){
                if(distance[ch - 'a'] != (i - map.get(ch) - 1)) {
                    return false;
                }
            }else{
                map.put(ch, i);
            }            
        }

        return true;
    }
}