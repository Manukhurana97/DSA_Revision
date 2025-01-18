// https://leetcode.com/problems/word-ladder/submissions/1511535925/

public class WordLadder{
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for(String word: wordList) wordSet.add(word);

        if(!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int level = 1;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                String currentWord = queue.poll();
                char[] charArr = currentWord.toCharArray();

                for(int j=0; j<currentWord.length(); j++){
                    char orignalWord = charArr[j];

                    for(char ch = 'a'; ch <= 'z'; ch++){
                        if(ch == orignalWord) continue;

                        charArr[j] = ch;
                        String newWord = new String(charArr);

                        if(newWord.equals(endWord)) return level + 1;

                        if(wordSet.contains(newWord)){
                            queue.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }

                    charArr[j] = orignalWord;
                }
            }
            level += 1;
        }

        return 0;

    }
}