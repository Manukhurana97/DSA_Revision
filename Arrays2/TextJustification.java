// https://leetcode.com/problems/text-justification/

        int clen = 0;
        List<String> temp = new ArrayList<>();

        for(String word: words) {
            if(clen + word.length() + (clen == 0 ? 0 : 1) > maxWidth) { // current length is greater then 0 means, we already have some words and we need to add " " 
                result.add(updateString(temp, maxWidth));
                
                temp.clear();
                clen = 0;
            }

            temp.add(word);
            if(clen>0) clen+=1;
            clen += word.length();

        }

        // for last line
        StringBuilder lastLine = new StringBuilder(String.join(" ", temp));
        lastLine.append(" ".repeat(maxWidth - lastLine.length()));
        result.add(lastLine.toString());

        return result;
    }

    private String updateString(List<String> words, int maxWidth){
        if(words.size() == 1){
            return words.get(0) + " ".repeat(maxWidth - words.get(0).length());
        }

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

        result.append(words.get(words.size() - 1));

        return result.toString();
    }
}