// https://leetcode.com/problems/find-unique-binary-string/

public class FindUniqueBinaryString {
	public String findDifferentBinaryString(String[] nums) {
        int n = 1<<nums.length;
        Set<String> set = new HashSet<>();
        for(String str: nums) set.add(str);

        for(int i=0; i<n; i++) {
            int j=i;
            StringBuilder builder = new StringBuilder();
            while(j>0) {
                builder.append((j&1));
                j>>>=1;
            }

            while(builder.length() < nums.length) {
                builder.append(0);
            }
            
            if(!set.contains(builder.toString())) return builder.toString();
        }

        return "1".repeat(nums.length);
    }



    public String findDifferentBinaryString(String[] nums) {
        StringBuilder builder = new StringBuilder();

        for(int i=0; i<nums.length; i++) {
            builder.append(nums[i].charAt(i) == '1' ? "0" : "1");
        }
        
        return builder.toString();
    }
}