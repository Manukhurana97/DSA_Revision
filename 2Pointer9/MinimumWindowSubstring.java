public class MinimumWindowSubstring{

	// Time : O(T) + O(S) , Space: O(s.length + t.length())
	public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        for(var i: t.toCharArray()) tMap.put(i, tMap.getOrDefault(i, 0) + 1);
        

        Map<Character, Integer> sMap = new HashMap<>();
        int current = 0, last = 0, n = s.length(), minLen = Integer.MAX_VALUE;
        String minString = "";

        while(current < n){
            var value = s.charAt(current);
            sMap.put(value, sMap.getOrDefault(value, 0) + 1);

            while(last <=current && containsAll(tMap, sMap)){
                if(minLen >= current - last){
                    minLen = current - last;
                    minString = s.substring(last, current+1);
                }
                
                var sVal = s.charAt(last);
                sMap.put(sVal, sMap.get(sVal) - 1);
                if(sMap.get(sVal) == 0) sMap.remove(sVal);
                last += 1;
   
            }

            current+=1;
        }

        return minString;
    }

    public boolean containsAll(Map<Character, Integer> tMap, Map<Character, Integer> sMap){
        for(Map.Entry<Character, Integer> map: tMap.entrySet())
            if(!sMap.containsKey(map.getKey()) || sMap.get(map.getKey()) < map.getValue()) return false;

        return true;
    }


    // ----------------------------------------------------------------------------------

    // Time : O(T) + O(S) , Space: O(s.length + t.length())
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";

        int[] tCount = new int[128];
        int[] sCount = new int[128];
        
        for (char c : t.toCharArray()) tCount[c]++;
        
        int current = 0, last = 0, n = s.length(), minLen = Integer.MAX_VALUE, have = 0, required = t.length();
        String minString = "";

        while(current < n){
            var value = s.charAt(current);
            sCount[value]++;

            if(sCount[value] <= tCount[value]) have++;

            while(have == required){
                if(minLen >= current - last+1){
                    minLen = current - last+1;
                    minString = s.substring(last, current+1);
                }

                var sVal = s.charAt(last);
                sCount[sVal]--;

                if (sCount[sVal] < tCount[sVal]) have--;
                
                last += 1;
            }
            current+=1;
        }

        return minString;
    }
}