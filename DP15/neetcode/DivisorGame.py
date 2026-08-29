# https://leetcode.com/problems/divisor-game/description/

class DivisorGame:
	def divisorGame(self, n: int) -> bool:
        dp = [-1 for _ in range(n+1)]

        def recursion (n):
            if n == 1: 
                return False
            if dp[n]!= -1:
                return dp[n]

            for i in range(n-1, 0, -1):
                if n % i == 0 and not recursion(n-i):
                    dp[n] = True
                    return True
        
            dp[n] = False
            return False
        return recursion(n)


# here we have a trick: instead of check who is the current player, we r checking whoevey is the current player can win the game from this step or not
