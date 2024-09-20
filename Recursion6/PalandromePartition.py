class createPartition:
    def ispalandrome(self, arr, start, end):
        if len(arr) == 0: return False

        while(start<=end):
            if arr[start] != arr[end]: return False
            start += 1
            end -= 1
        return True

    def generateAllpalandrome(self, s, index, arr, result):
        if index == len(s):
            result.append(arr[:])
            return

        for i in range(index, len(s)):
            if self.ispalandrome(s, index, i):
                arr.append(s[index: i+1])
                self.generateAllpalandrome(s, i + 1, arr, result)
                arr.pop(-1)
        
    def partition(self, s: str):
        result = []
        self.generateAllpalandrome(s, 0, [], result)
        return result

obj = createPartition();
print(obj.partition("abccba"))