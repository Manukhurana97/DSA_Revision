# generate all possible permutations and get the perms[currentIndex+1] Time: O(!N) ,Space: O(1)
def generateAllPossiblePermutations(arr, lst, result, flag):
    if len(lst) == len(arr):
        result.append(lst.copy())
        return

    for i in range(len(arr)):
        if not flag[i]:
            flag[i] = True
            lst.append(arr[i])
            generateAllPossiblePermutations(arr, lst, result, flag)
            flag[i] = False
            lst.pop()


def nextGreaterPermutation1(arr: [int]):
    result = []
    flag = [False] * len(arr)
    generateAllPossiblePermutations(arr, [], result, flag)
    result.sort()

    index = (result.index(arr) + 1)
    if index >= len(result):
        arr.sort()
        return arr
    return result[index]



# // for temp get the next greater number of ith position and sort the remaining, Time Complexity O(N^2 LogN), Space: O(N) 
def nextGreaterPermutation2(arr):
    temp = arr.copy()  # to check if the array has any next greater element or not

    for i in range(len(arr)):
        nextGreater = float('inf')
        nextGreaterIndex = -1
        for j in range(i + 1, len(arr)):
            if arr[i] < arr[j] and arr[j] < nextGreater:
                nextGreater = arr[j] # get the number greater then i, but shoud min in all element
                nextGreaterIndex = j;

        if nextGreaterIndex != -1:
            arr[i], arr[nextGreaterIndex] = arr[nextGreaterIndex], arr[i]
            arr[i + 1:] = sorted(arr[i + 1:])
            break

    if (temp == arr):
        arr.sort()
    return arr



# find the largest element from the right Space O(3N), Space O(1)
def nextGreaterPermutation3(nums):
        peekIndex = -1 # acutally for peek-1

        for i in range(len(nums)-2, -1, -1):
            if nums[i] < nums[i+1]:
                peekIndex = i
                break

        if peekIndex == -1: return nums.sort()

        nextGreaterElemIndex = -1;
        for i in range(len(nums)-1, -1, -1):
            if nums[i]>nums[peekIndex]: 
                nextGreaterElemIndex = i
                break
        
        nums[peekIndex], nums[nextGreaterElemIndex] =  nums[nextGreaterElemIndex], nums[peekIndex]
        nums[peekIndex+1: ] =sorted(nums[peekIndex+1:] )
        return nums


print(nextGreaterPermutation1([3, 2, 1]))
print(nextGreaterPermutation2([1, 3, 2]))
print(nextGreaterPermutation3([1, 3, 2]))
print(nextGreaterPermutation3([1, 2, 3, 4, 5]))
