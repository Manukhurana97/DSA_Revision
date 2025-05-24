// https://leetcode.com/problems/text-justification/
public class Textjistification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        if(words.length == 1) {
            result.add(words[0]+" ".repeat(maxWidth - words[0].length()));
            return result;
        }

        int len = 0;
        List<String> temp = new ArrayList<>();

        for(String word: words) {
            if(len + word.length() + (len == 0 ? 0 : 1) > maxWidth) { // when the word
                result.add(updateString(temp, maxWidth));
                
                temp.clear();
                len = 0;
            }

            temp.add(word);
            if(len>0) len+=1;
            len += word.length();

        }

        StringBuilder lastLine = new StringBuilder(String.join(" ", temp));
        lastLine.append(" ".repeat(maxWidth - lastLine.length()));
        result.add(lastLine.toString());

        return result;
    }

    private String updateString(List<String> words, int maxWidth){
        if(words.size() == 1)
            return words.get(0) + " ".repeat(maxWidth - words.get(0).length());

        int totalChars = 0;
        for(String word: words) totalChars += word.length();
        

        int totalSpaces = maxWidth - totalChars;
        int spaceBetween = totalSpaces / (words.size() - 1);
        int extra = totalSpaces % (words.size() - 1);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.size()-1; i++) {
            result.append(words.get(i) + " ".repeat(spaceBetween));
            if (extra > 0) {
                result.append(" ");
                extra--;
            }
        }

        result.append(words.get(words.size()-1));

        return result.toString();
    }
}