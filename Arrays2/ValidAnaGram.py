def isAnagram(self, s: str, t: str) -> bool:

    # return sorted(s) == sorted(t)

    if len(s) != len(t): return False

    arr1, arr2 = {}, {}

    for i in range(len(s)):
        arr1[s[i]] = 1 + arr1.get(s[i], 0)
        arr2[t[i]] = 1 + arr2.get(t[i], 0)

    for i in s:
        if arr1.get(i) != arr2.get(i):
            return False

    return True