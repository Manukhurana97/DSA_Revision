# https://leetcode.com/problems/group-anagrams/

def cd (self, strs: List[str]) -> List[List[str]]:
    anagram_dict = {}   

    for str in strs: # O(N)
        
        sortedstr = tuple(sorted(str)) # O(klogK)
        
        if sortedstr in anagram_dict:
            anagram_dict[sortedstr].append(str)
        else:
            anagram_dict[sortedstr] = [str]

    result = []
    for val in anagram_dict.values():
        result.append(val)

    return result

def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
    anagram_dict = {}   

    for str in strs: #O(N)
        
        count = [0] * 26
        for s in str: count[ord(s) - ord('a')] +=1
        sortedstr = tuple(count)

        if sortedstr in anagram_dict:
            anagram_dict[sortedstr].append(str)
        else:
            anagram_dict[sortedstr] = [str]

    result = []
    for val in anagram_dict.values():
        result.append(val)

    return result



# ------------------------------------------------------------------------------------


#     public List<List<String>> groupAnagrams(String[] strs) {
#         List<List<String>> result = new ArrayList<>();
        
#         Map<String, List<String>> map = new HashMap<>();

#         for(String str: strs){
#             char chArr[] = new char[26];
#             for(char ch: str.toCharArray()) chArr[ch - 'a']++;
#             String word = new String(chArr);
            
#             map.computeIfAbsent(word, k-> new ArrayList<>()).add(str);              
            
#         }

#         return new ArrayList<>(map.values());
#     }