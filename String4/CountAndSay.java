// https://leetcode.com/problems/count-and-say/

public class CountAndSay {
    public String countAndSay(int n) {
        String result = "1";
        if(n == 1) return result;
        
        for(int i=1; i<n; i++){
            StringBuilder builder = new StringBuilder();
            int prev = 0, j=1;
            
            for(j=1; j<result.length(); j++){
                if(result.charAt(j-1) != result.charAt(j)){
                    builder.append(j-prev).append(result.charAt(j-1));
                    prev = j;
                }
            }
            builder.append(j-prev).append(result.charAt(j-1));
            result = builder.toString();
            
        }
        return result;
    }

    public static void main(String[] args) {
        CountAndSay obj = new CountAndSay();
        System.out.println(obj.countAndSay(4));
    }
}