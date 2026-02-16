// https://leetcode.com/problems/integer-to-roman/

public class IntegerToRoman {
	String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    String[] tens = {"", "X", "XX", "XXX", "XL", "L","LX","LXX","LXXX","XC"};
    String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] thousands = {"", "M", "MM", "MMM"};

    public String intToRoman(int num) {
       
        return helper(num);
    }

    public String helper(int num) {
        if(num < 10) {
            return tens[num];
        } 
        if(num < 100) {
            return tens[num/10] + helper(num%10);
        } 
        if(num < 1000) { 
            return hundreds[num/100] + helper(num%100);
        }
        return thousands[num/1000] + helper(num%1000);
    }


}