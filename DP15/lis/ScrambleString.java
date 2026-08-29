// https://leetcode.com/problems/scramble-string/

public class ScrambleString {
	
	public boolean isScramble(String a, String b) {
        Map<String, Boolean> map = new HashMap<>();

        return recursion(a, b, map);
    }

    public boolean recursion(String a, String b, Map<String, Boolean> map) {
        if(a.equals(b)) return true;
        if(a.length() != b.length()) return false;
        
        char[] arr = a.toCharArray();
        char[] brr = b.toCharArray();

        Arrays.sort(arr);
        Arrays.sort(brr);

        if(!Arrays.equals(arr, brr)) return false;

        int n = a.length();
        String key = a +" "+b;

        if(map.containsKey(key)) return map.get(key);

        for(int i=1; i<n; i++) {
            if(recursion(a.substring(0, i), b.substring(0, i), map) && recursion( a.substring(i), b.substring(i), map)) { // no swap
                map.put(key, true);
                return true;
            }
            if(recursion(a.substring(0, i), b.substring(n-i), map) && recursion(a.substring(i), b.substring(0, n-i), map)) { // swap
                map.put(key, true);
                return  true;
            }
        }
        map.put(key, false);
        return false;
    }
}