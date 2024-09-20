// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

// abc : Given a string s consisting only of characters a, b and c.
import java.util.*;

public class NumberOfSubsetContainingAll3Char{
	public int numberOfSubstrings(String s) {

        return  atMostElement(s, 3)-atMostElement(s, 2);
    }

    public int atMostElement(String s, int atMost){
        Map<Character, Integer> charSet = new HashMap<>(); // max size 3
        int current = 0, last = 0, n = s.length(), result = 0;

        while(current < n){
            charSet.put(s.charAt(current), charSet.getOrDefault(s.charAt(current), 0) + 1);

            while(charSet.size() > atMost)
                if(charSet.get(s.charAt(last)) == 1) charSet.remove(s.charAt(last++));
                else charSet.put(s.charAt(last), charSet.get(s.charAt(last++)) - 1);

            result += (charSet.size()<=atMost) ? current - last: 0;
            current+=1;

        }

        return result;
    }

    public static void main(String[] args) {
        
    }
}