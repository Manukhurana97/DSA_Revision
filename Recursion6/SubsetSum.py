# https://www.geeksforgeeks.org/problems/subset-sums2234/1
from typing import List

def SubsetSumHelper(arr, index, sum, result):
    if index == len(arr):
        result.append(sum)
        return

    SubsetSumHelper(arr, index + 1, sum, result)
    SubsetSumHelper(arr, index + 1, sum + arr[index], result)
    

def SubsetSum(arr):
    result = []
    SubsetSumHelper(arr, 0, 0, result)
    result.sort()
    return result



# -----------------------------------------------------------------------------


def subsets( nums: List[int]):
    result = [0]
    for num in nums:
        newSubset = [num + cur for cur in result]
        result.extend(newSubset)

    return result


arr = [2,3]
print(SubsetSum(arr))
print(subsets(arr))