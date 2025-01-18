public class WordLetter2{
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();

        if (wordList == null || wordList.size() == 0) return result;

        Set<String> wordSet = new HashSet<>(wordList);

        if(!wordSet.contains(endWord)) return result;

        Queue<List<String>> queue = new LinkedList<>();
        queue.add(List.of(beginWord));

        boolean found = false;

        while(!queue.isEmpty() && !found){
            int size = queue.size();
            Set<String> elementToRemove = new HashSet<>();

            for(int i=0; i<size; i++){
                List<String> currentList = queue.poll();
                String currentword = currentList.get(currentList.size() - 1);
                char[] charArr = currentword.toCharArray(); 
                
                for(int j=0; j<currentword.length(); j++){
                    char origChar = charArr[j];

                    for(char ch='a'; ch<='z'; ch++){
                        if(ch == origChar) continue;

                        charArr[j] = ch;
                        String newWord = new String(charArr);

                        if(wordSet.contains(newWord)){
                            List<String> nextList = new ArrayList<>(currentList);
                            nextList.add(newWord);

                            if(newWord.equals(endWord)){
                                result.add(nextList);
                                found = true;
                            }else{
                                queue.add(nextList);
                            }
                            elementToRemove.add(newWord);
                        }
                    }
                    charArr[j] = origChar;
                }
                
            }
            wordSet.removeAll(elementToRemove);
        }

        return result;
    }
}