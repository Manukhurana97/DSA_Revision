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
def nextGreaterPermutation3(arr):
    index = -1

    # Find the peak point
    for i in range(len(arr) - 2, -1, -1): # from n-2 to -1, and last -1 for rev loop
        if arr[i] < arr[i + 1]:
            index = i
            break

    # If its a last permutation, then just reverse the array
    if index == -1:
        arr.reverse()
        return arr

    # Find the nearest greater element
    nextGreaterIndex = -1
    for i in range(len(arr) - 1, index, -1):
        if arr[i] > arr[index]:
            nextGreaterIndex = i
            break

    # Swap the elements and then sort the remaining
    arr[index], arr[nextGreaterIndex] = arr[nextGreaterIndex], arr[index]
    arr[index + 1:] = sorted(arr[index + 1:])
    return arr


print(nextGreaterPermutation1([3, 2, 1]))
print(nextGreaterPermutation2([1, 3, 2]))
print(nextGreaterPermutation3([1, 3, 2]))
print(nextGreaterPermutation3([1, 2, 3, 4, 5]))
