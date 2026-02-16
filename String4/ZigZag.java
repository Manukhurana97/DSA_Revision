// https://leetcode.com/problems/zigzag-conversion/

public class ZigZag {
	public String convert(String s, int numRows) {
        if(numRows == 1) return s;

       List<StringBuilder> list = new ArrayList<>();
       for(int i=0; i<numRows; i++) list.add(new StringBuilder());

        int i = 0, down = 0;
        while(i < s.length()) {
            // down
            while(i < s.length() && down < numRows) {
                list.get(down++).append(s.charAt(i++));
            }
            // up right
            down -= 1;
            while(i < s.length() && --down > 0) {
                list.get(down).append(s.charAt(i++));
            }
        }
        

        StringBuilder result = new StringBuilder();
        for(var lst: list) {
            result.append(lst.toString());
        }

        return result.toString();
    }
}