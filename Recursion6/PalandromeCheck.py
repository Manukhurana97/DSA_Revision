def PalandromeCheck(str):

	def check(str, startIndex, endIndex):
		if startIndex>endIndex: return True

		if str[startIndex] != str[endIndex]: return False

		if not check(str, startIndex + 1, endIndex - 1):
			return False
		return True

	return check(str, 0, len(str)-1)


print(PalandromeCheck("abcba"))
