# Time : O(n^2), Space : O(1)
def twoSum1(arr: [int], k: int):
    for i in range(0, len(arr)):
        for j in range(0, len(arr)):
            if j != i:
                if arr[i] + arr[j] == k: return True

    return False


# Time : O(N), Space : O(N)
def twoSum2(arr: [int], k: int):
    set = []

    for i in arr:
        if (k - i) in set: return True
        set.append(i)

    return False


# Time : O(NlogN), Space : O(1)
def twoSum3(arr: [int], k: int):
    arr.sort()
    i = 0
    j = len(arr) - 1

    while (i < j):
        if arr[i] + arr[j] == k: return True
        elif arr[i] + arr[j] < k: i += 1
        else: j -= 1
    return False

# use map to store the element and check if k - i in map

print(twoSum1([2, 6, 5, 8, 11], 14))
print(twoSum2([2, 6, 5, 8, 11], 14))
print(twoSum3([2, 6, 5, 8, 11], 44))
