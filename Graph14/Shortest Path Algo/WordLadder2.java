public class WordLadder2{
	public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
    ArrayList<ArrayList<String>> result = new ArrayList<>();
    Set<String> words = new HashSet<>(Arrays.asList(wordList));
    
    if (!words.contains(targetWord)) return result;  // If target word isn't in the list, no sequences exist.
    
    Queue<List<String>> queue = new LinkedList<>();
    queue.add(List.of(startWord));  // Start with the start word
    
    Set<String> visited = new HashSet<>();  // Set to track visited words at the current level
    visited.add(startWord);
    
    boolean found = false;  // Flag to mark if the target word is found at the current level
    
    while (!queue.isEmpty()) {
        int size = queue.size();
        Set<String> levelVisited = new HashSet<>();
        List<List<String>> currentLevelPaths = new ArrayList<>();
        
        for (int i = 0; i < size; i++) {
            List<String> currentPath = queue.poll();
            String lastWord = currentPath.get(currentPath.size() - 1);
            
            // Try all possible one-character transformations
            char[] lastWordChars = lastWord.toCharArray();
            for (int j = 0; j < lastWord.length(); j++) {
                char originalChar = lastWordChars[j];
                
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == originalChar) continue;  // Skip the same character
                    
                    lastWordChars[j] = c;
                    String newWord = new String(lastWordChars);
                    
                    if (words.contains(newWord) && !visited.contains(newWord)) {
                        ArrayList<String> newPath = new ArrayList<>(currentPath);
                        newPath.add(newWord);
                        
                        if (newWord.equals(targetWord)) {
                            result.add(newPath);
                            found = true;
                        } else {
                            currentLevelPaths.add(newPath);
                            levelVisited.add(newWord);
                        }
                    }
                }
                
                lastWordChars[j] = originalChar;  // Restore the original character
            }
        }
        
        if (found) break;  // Stop as soon as we find the target word in this level
        
        visited.addAll(levelVisited);  // Mark the words from the current level as visited
        queue.addAll(currentLevelPaths);  // Add paths for the next level
    }
    
    return result;
}
}