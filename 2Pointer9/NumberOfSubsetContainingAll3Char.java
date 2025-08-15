// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

// abc : Given a string s consisting only of characters a, b and c.
import java.util.*;

public class NumberOfSubsetContainingAll3Char{
	public int numberOfSubstrings(String s) {
        return numberOfSubstringsContainAtMost(s, 3) - numberOfSubstringsContainAtMost(s, 2);
    }

    private int numberOfSubstringsContainAtMost(String s, int k) {
        int n = s.length(), current = 0, prev = 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(current < n) {
            map.put(s.charAt(current), map.getOrDefault(s.charAt(current), 0) + 1);

            while(map.size() > k && current >= prev) {
                map.put(s.charAt(prev), map.get(s.charAt(prev)) - 1);

                if(map.get(s.charAt(prev)) == 0) {
                    map.remove(s.charAt(prev));
                }

                prev += 1;
            }
            result += current - prev + 1;
            current ++;
        }

        return result;
    }
}