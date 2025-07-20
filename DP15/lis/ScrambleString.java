// https://leetcode.com/problems/scramble-string/s

public class ScrambleString {
	
	public boolean isScramble(String s1, String s2) {
        Map<String, Boolean> map = new HashMap<>();

        return recursion(s1.length(), s1, s2, map);
    }

    private boolean recursion(int n, String a, String b, Map<String, Boolean> map) {
        if(a.equals(b)) return true;
        if(a.length() != b.length()) return false;

        n = a.length();
        String key = a+" "+b;
        if(map.containsKey(key)) return map.get(key);

        var ta = a.toCharArray();
        var tb = b.toCharArray();
        Arrays.sort(ta);
        Arrays.sort(tb);

        if(!Arrays.equals(ta, tb)) return false;

        for(int i=1; i<n; i++) {
            if(recursion(n, a.substring(0, i), b.substring(0, i), map) && recursion(n, a.substring(i), b.substring(i), map)) {
                map.put(key, true);
                return true;
            }

            if(recursion(n, a.substring(0, i), b.substring(n-i), map) && recursion(n, a.substring(i), b.substring(0, n-i), map)) {
                map.put(key, true);
                return true;
            }
        }

        map.put(key, false);
        return false;
    }

	public static void main(String[] args) {
		
	}
}