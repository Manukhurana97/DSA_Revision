public class FindAllAnagramInAString{
	public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pMap = new HashMap<>(); // 26
        Map<Character, Integer> sMap = new HashMap<>(); // 26
        List<Integer> result = new ArrayList<>();

        for(var ch: p.toCharArray()) pMap.put(ch, pMap.getOrDefault(ch, 0)+1);

        int current = 0, last = 0, n = s.length(), matches = 0;

        while(current < n){
            var cVal = s.charAt(current);
            sMap.put(cVal, sMap.getOrDefault(cVal, 0) + 1);
            
            
            if(pMap.containsKey(cVal) && sMap.get(cVal) == pMap.get(cVal)) matches+=1;

            while(matches == pMap.size()){
                if(current - last + 1 == p.length()) result.add(last);            

                var lVal = s.charAt(last++);

                if(pMap.containsKey(lVal)){
                    if(pMap.get(lVal) == sMap.get(lVal)) matches--;
                }
                    
                    sMap.put(lVal, sMap.get(lVal) -1);
                    if(sMap.get(lVal) == 0) sMap.remove(lVal);
                
                
            }
            
            current++;
        }
        return result;
    }


    public boolean isValidAnagram(Map<Character, Integer> sMap,  Map<Character, Integer> pMap){
        for(Map.Entry<Character, Integer> map: pMap.entrySet())
            if(sMap.get(map.getKey()) != map.getValue()) return false;
        

        return true;
    }


    // ----------------------------------------------------------------------------------------

    public List<Integer> findAnagrams(String s, String p) {
        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for(var ch: p.toCharArray()) pCount[ch - 'a']++;

        int current = 0, last = 0, slen = s.length();
        List<Integer> result = new ArrayList<>(); 

        while(current < slen){
            sCount[s.charAt(current) - 'a']++;

            if(current - last + 1 > p.length()){
                sCount[s.charAt(last) - 'a']--;
                last++;
            }

            if(Arrays.equals(sCount, pCount)) result.add(last);
            
            current++;
        }

        return result;
    }
}