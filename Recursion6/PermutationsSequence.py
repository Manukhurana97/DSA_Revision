import math
def generateAllPermutations(s: str, index: int, allPermutations: list):
    if index == len(s):
        allPermutations.append(s)
        return

    for i in range(index, len(s)):
        s_list = list(s)
        s_list[i], s_list[index] = s_list[index], s_list[i]
        generateAllPermutations(''.join(s_list), index + 1, allPermutations)
        s_list[i], s_list[index] = s_list[index], s_list[i]


# generate all permutations , get kth +1 index parandrome if exists else -1
def getPermutation(n: int, k: int) -> str:
    s = ""
    for i in range(1, n+1): s +=str(i)

    allPermutations = []
    generateAllPermutations(s, 0, allPermutations)

    allPermutations.sort()

    if len(allPermutations)<k: return -1

    return allPermutations[k-1]



# ---------------------------------------------------------------------------------


def getPermutationHelper1(s, k, currentIndex):
    
    n = len(s) - currentIndex
    fact = math.factorial(n - 1)
    index = ( k // fact) + currentIndex
    k %= fact

    s_list = list(s)
    s_list[index], s_list[currentIndex] = s_list[currentIndex], s_list[index]
    s = ''.join(i for i in s_list)

    
    return s, k


def getPermutation1(n: int, k: int) -> str:
    s = ''.join(str(i) for i in range(1, n+1))
    k -= 1
    index = 0


    for i in range(n):
        s, k = getPermutationHelper1(s, k, i)

    return s

# ---------------------------------------------------------------------

def getPermutation2(n: int, k: int) -> str:
    s = list(range(1, n+1))
    k-=1
    result = []

    for index in range(n):
        fact = math.factorial(len(s)-1)
        index = k // fact # index: 1, 1, 0, 0 
        result.append(str(s.pop(index))) # 2 3 1 4
        k%=fact

    return ''.join(result)


print(getPermutation2(4, 9))
# print(getPermutation(3, 1))
# print(getPermutation(3, 3))
# print(getPermutation(3, 5))

        