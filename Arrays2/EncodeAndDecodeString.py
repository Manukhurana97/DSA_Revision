class EncodeAndDecodeString:

	# len+#+str
	def encode(self, strs):
		result = ""

		for s in strs:
			result += str(len(s)) + "#" + s

		return result


	def decode(self, s):
		result = []
		i=0
		while i < len(s):
			j = i
			while s[j] != '#': # get the #
				j+=1
			length = int(s[i:j]) # get the length till hash
			result.append(s[j + 1: j + 1 + length]) # #+1, #+1+length
			i = j + 1 + length

		return result



obj = EncodeAndDecodeString()

inputStr = ["how", "are", "you"]
encodedString = obj.encode(inputStr)
decodedString = obj.decode(encodedString)
print(inputStr == decodedString)