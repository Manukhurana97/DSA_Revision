class minBitsFlip:

    def minBitFlips(self, start: int, goal: int) -> int:
        count = 0

        # while start and goal:
        #    count += 1 if start & 1 == 0 and goal & 1 == 1 or start & 1 == 1 and goal & 1 == 0 else 0
        #    start >>=1
        #    goal >>=1

        # while start:
        #    count += 1 if start & 1 == 1 else 0
        #    start >>=1

        # while goal:
        #    count += 1 if goal & 1 == 1 else 0
        #    goal >>=1




        xor = start ^ goal # 101

        while xor:
            count += 1 if xor & 1 == 1 else 0
            xor >>=1


        return count

# start = 1 : 001
# goal = 4 : 100

obj = minBitsFlip()
print(obj.minBitFlips(1, 4))
