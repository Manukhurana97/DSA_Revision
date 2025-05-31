def josephusProblem(arr, k) -> int:

    def dfs(arr, i, k):
        if len(arr) == 1: return arr[0]

        i = (i+k) % len(arr)
        arr.pop(i);

        return dfs(arr, i, k)

    return dfs(arr, 0, k-1)

result = josephusProblem([1,2,3,4,5], 3)
print(result)
