// https://leetcode.com/problems/valid-parenthesis-string/

public class ValidParanthesisString{

	public boolean checkValidString(String s) {
        int min = 0;
        int max = 0;

        for(var ch: s.toCharArray()){
            if(ch == '('){
                min += 1;
                max += 1;
            }else if (ch ==')'){
                min -= 1;
                max -=1;
            }else{
                min-=1;
                max+=1;
            }
            min = Math.max(min, 0);

            if(max<0) return false; // if closing ('(') gets more
        }

        return min == 0;
    }
}