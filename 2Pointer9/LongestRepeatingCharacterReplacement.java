public class LongestRepeatingCharacterReplacement{
	public int characterReplacement(String s, int k) {
        int prev = 0, maxCount = 0, longestString = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int current = 0; current < s.length(); current++){
            var currval = s.charAt(current);
            map.put(currval, map.getOrDefault(currval, 0) + 1);

            maxCount = Math.max(maxCount, map.get(currval));

            while(current - prev + 1 - maxCount > k){ 
                var prevVal = s.charAt(prev);
                map.put(prevVal, map.get(prevVal) - 1);
                prev += 1;
            }

            longestString = Math.max(longestString, current - prev + 1);
        }

        return longestString;
    }
}