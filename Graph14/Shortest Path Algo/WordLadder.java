import java.util.*;

public class WordLadder {
    public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(wordList));
        
        // If the target word is not in the word list, no transformation is possible
        if (!wordSet.contains(targetWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(startWord);

        int level = 1; // Transformation count starts at 1

        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                char[] wordChars = currentWord.toCharArray();

                // Try changing each character in the current word
                for (int j = 0; j < wordChars.length; j++) {
                    char originalChar = wordChars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue; // Skip the same character

                        wordChars[j] = c;
                        String newWord = new String(wordChars);

                        // If the target word is found, return the transformation count
                        if (newWord.equals(targetWord)) {
                            return level + 1;
                        }

                        // If the new word exists in the word set, add it to the queue
                        if (wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord); // Mark as visited
                        }
                    }

                    wordChars[j] = originalChar; // Restore the original character
                }
            }
            
            level++; // Increment level after processing all words at the current level
        }

        return 0; // Return 0 if no transformation sequence is found
    }

    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        String startWord = "hit";
        String targetWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        
        System.out.println(wl.wordLadderLength(startWord, targetWord, wordList)); // Output: 5
    }
}
