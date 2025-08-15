// https://leetcode.com/problems/word-break-ii/

public class WordBreak2 {
	public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        recursion(0, s, new HashSet<>(wordDict), new ArrayList(), result);
        return result;
    }

    private void recursion(int i, String s, Set<String> wordDict, List<String> words, List<String> result) {
        if(i == s.length()) {
            result.add(String.join(" ", words));
            return;
        }


        for(int j=i; j<s.length(); j++) {
            String word = s.substring(i, j+1);
            if(wordDict.contains(word)) {
                words.add(word);
                recursion(j+1, s, wordDict, words, result);
                words.remove(words.size()-1);
            }
        }
    }
}