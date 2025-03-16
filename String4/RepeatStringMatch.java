class RepeatStringMatch:
	def repeatedStringMatch(self, a: str, b: str) -> int:
        if a == b: return 1

        min_rep =math.ceil(len(b) / len(a))
        repeating = a*min_rep

        if b in repeating: return min_rep
        elif b in (repeating + a): return min_rep + 1
        
        return -1