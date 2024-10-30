def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
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