from collections import Counter

class LongestSubstringWithAtMostKChars:
	def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
		countMap = {}
		current = last = 0
		n = len(s)
		maxLen = 0

		while(current < n):
			currentval = s[current]
			countMap[currentval] = countMap[currentval] + 1 if currentval in countMap else 1

			while len(countMap) > k:
				leftVal = s[last]

				if countMap[leftVal] == 1: del countMap[leftVal]
				else: countMap[leftVal] = countMap[leftVal] - 1

				last+=1

			maxLen = max(maxLen, current - last + 1)
			current+=1

		return maxLen


	def lengthOfLongestSubstringKDistinct1(self, s: str, k: int) -> int:
		l = 0
		cnt = Counter()
		for c in s:
			cnt[c] += 1
			if len(cnt) > k:
				cnt[s[l]] -= 1
				if cnt[s[l]] == 0:
				    del cnt[s[l]]
				l += 1
		return len(s) - l



obj = LongestSubstringWithAtMostKChars()
print(obj.lengthOfLongestSubstringKDistinct('eceba', 2))
print(obj.lengthOfLongestSubstringKDistinct('aa', 1))
print(obj.lengthOfLongestSubstringKDistinct('aaabbccd', 2))

		
