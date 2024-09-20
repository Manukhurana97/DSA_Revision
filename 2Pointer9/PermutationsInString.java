public class PermutationsInString{
	public boolean checkInclusion(String s1, String s2) {
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];
        for(var ch: s1.toCharArray()) s1Arr[ch -'a']++;

        int right = 0, left = 0, n = s2.length();
        
        while(right < n){
            if((right - left + 1) > s1.length()){
                s2Arr[s2.charAt(left) - 'a']--;
                left++;
            } 

            s2Arr[s2.charAt(right) - 'a']++;

            if(Arrays.equals(s1Arr, s2Arr)) return true;

            right++;

       }

       return false;
    }
}