// https://leetcode.com/problems/letter-combinations-of-a-phone-number/


public class LetterCombinationOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;
        
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', List.of('a','b','c'));
        map.put('3', List.of('d','e','f'));
        map.put('4', List.of('g','h','i'));
        map.put('5', List.of('j','k','l'));
        map.put('6', List.of('m','n','o'));
        map.put('7', List.of('p','q','r','s'));
        map.put('8', List.of('t','u','v'));
        map.put('9', List.of('w','x','y','z'));

       
        recursion(0, digits, new StringBuilder(), result, map);
        return result;
    }


    public void recursion(int i, String digit, StringBuilder builder, List<String> result, Map<Character, List<Character>> map){
        if(builder.length() == digit.length()){
            result.add(builder.toString());
            return;
        }

        for(var val: map.get(digit.charAt(i))){
            builder.append(val);
            recursion(i+1, digit, builder, result, map);
            builder.deleteCharAt(builder.length()-1);
        }
    }

}