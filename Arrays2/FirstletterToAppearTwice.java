public class FirstletterToAppearTwice {

	public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i-1) == s.charAt(i) || set.contains(s.charAt(i))) return s.charAt(i);

            set.add(s.charAt(i));
        }
        
        return '1';
    }
}