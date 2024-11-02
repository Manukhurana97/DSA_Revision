class SumTwoNumber:
	 def getSum(self, a: int, b: int) -> int:
        bit, carry = 0, 0
        ind = 0
        result = [0] * 32

        while (a > 0 or b > 0 or carry > 0) and ind < 32:
            a_bit = a & 1
            b_bit = b & 1
            
            bit = a_bit ^ b_bit ^ carry
            carry = (a_bit & b_bit) | (carry & (a_bit ^ b_bit))
            
            result[31 - ind] = bit
            
            a >>= 1
            b >>= 1
            ind += 1

        out = 0
        for bit in result:
            out = (out << 1) | bit

        if result[0] == 1:  
            out = out - (1 << 32)

        return out

# -----------------------------------------------------------------------------------------------------------------

	    def getSum(self, a: int, b: int) -> int:
	        carry = 0
	        res = 0
	        mask = 0xFFFFFFFF

	        for i in range(32):
	            a_bit = (a >> i) & 1
	            b_bit = (b >> i) & 1
	            cur_bit = a_bit ^ b_bit ^ carry
	            carry = (a_bit + b_bit + carry) >= 2
	            if cur_bit:
	                res |= (1 << i)

	        if res > 0x7FFFFFFF:
	            res = ~(res ^ mask)
	            
	        return res