# https://leetcode.com/problems/number-of-1-bits/
class NumberOfOnce:
	def hammingWeight(self, n: int) -> int:
        # 1011
        count = 0
        while n>0:
            count += 1 if n&1==1 else 0
            n>>=1

        return count


    def hammingWeight(self, n: int) -> int:
        count = 0

        while n > 0:
            count+=1
            n = n & n-1

        return count

