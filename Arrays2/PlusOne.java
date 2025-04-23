// https://leetcode.com/problems/plus-one/

public class PlusOne {

	// Time: O(n), Space: O(n)
	public int[] plusOne(int[] digits) {
        List<Integer> list = new LinkedList<>();
        int n = digits.length, carry = 1;

        for(int i=n-1; i>=0; i--){
            int val = (digits[i] + carry);
            carry = val / 10;
            list.add(val % 10);
        }

        if(carry !=0) list.add(carry);

        int[] result = new int[list.size()];
        for(int i=list.size()-1; i>=0; i--) result[i] = list.remove(0);
        return result;
    }


    // Time: O(n), Space: O(1)
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
}