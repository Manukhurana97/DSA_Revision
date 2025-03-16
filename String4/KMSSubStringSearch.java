public class KMSSubStringSearch{

	// kmp algo
	private boolean isSubstringExists(String a, String b){
		if(b.length() == 0) return true;
		if(a.length() == 0 || b.length() > a.length()) return false;
		

		// create a array for b to same element checking twice
		int[] lps = new int[b.length()]; // longest palandromic sufix

		int i=1, j=0, n=a.length(), m=b.length();
		while(i<m){
			while(j>0 && b.charAt(i) != b.charAt(j)){
				j = lps[j-1]; // Move to previous LPS value
			}
			if(b.charAt(i) == b.charAt(j)){
				j+=1;
				lps[i] = j;
			}
			i+=1;
		}


		// search the pattern
		i=0;
		j=0;
		while (i<n && j<m){
			while(j>0 && (a.charAt(i) != b.charAt(j))){ 
				j = lps[j-1];
			}
			
			if (a.charAt(i) == b.charAt(j)){ 
				j+=1;
			}
			
			i+=1;
		}

		return j == m;
	}

	public static void main(String[] args) {
		KMSSubStringSearch obj = new KMSSubStringSearch();
		String text = "ababcaabbcabcabcacbab";
		String pattern = "abcabcacb"; // lps : [0 0 0 1 2 3 4 0 0]
		System.out.println(obj.isSubstringExists(text, pattern)); // 0:0 1:1 2:0 3:1 4:2 5:3 6:0 7:1 8:0 9:0 10:0 11:1 12:2 13:3 14:4 15:5 16:6 17:7 18:8
	}
}
