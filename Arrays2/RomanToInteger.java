// https://leetcode.com/problems/roman-to-integer/

public class RomanToInteger {
	public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
        Map<String, Integer> oneLess = Map.of("IV", 4, "IX", 9, "XL", 40, "XC", 90, "CD", 400, "CM", 900);

        int result = 0, i = 0;

        while(i<s.length()) {
            if(i<s.length()-1) {
                if(oneLess.containsKey(s.substring(i, i+2))){
                    result += oneLess.get(s.substring(i, i+2));
                    i+=2;
                    continue;
                }
            }
            
            result += map.get(s.charAt(i));
            i++;

            
        }

        return result;
    }
}