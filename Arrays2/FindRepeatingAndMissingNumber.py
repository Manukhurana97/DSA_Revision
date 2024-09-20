# Time: O(N), Space O(N)
def findRepeatingAndMissingNumber(arr):
	seen = set()

	n = len(arr)
	total = n * (n + 1) // 2
	repeating = 0;
	sum = 0

	for i in arr:
		if i in seen:
			repeating  = i;
		
		seen.add(i)
		sum += i

	return { repeating, total - sum + repeating }


# using math formula
def findRepeatingAndMissingNumber1(arr):
	
	n = len(arr)

	# sum and square of first n number
	s1n = n * (n + 1) // 2
	s2n = n * (n + 1) * (2 * n + 1) // 6

	# sum and square of number1
	s = sum(arr)
	s1 = sum(x*x for x in arr)

	# difference of expected and actual
	v1 = s1n - s # x + y
	v2 = s2n - s1 # x^2 - y^2

	# X+Y = (X^2-Y^2)/(X-Y):
	x_plus_y = v2 // v1

	x = (v1+x_plus_y)//2
	y = x_plus_y - x

	return {y, x}
	

# use element as index



print(findRepeatingAndMissingNumber([3,1,2,5,3]))
print(findRepeatingAndMissingNumber1([3,1,2,5,3]))

