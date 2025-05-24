# sort an array Time : O(NlogN), Space : O(1)
def sortAnArrayZeroOneTwo1(arr):
	arr.sort()
	return arr

# count number of 0,1,2 and run a loop and put the number of 0,1,2
def sortAnArrayZeroOneTwo2(arr):
	zero = 0
	one = 0
	two = 0

	for i in arr:
		if i==0 : zero+=1
		elif i==1 : one +=1
		else: two+=1;


	for i in range(zero): arr[i] = 0
	for i in range(zero, one+zero): arr[i] = 1
	for i in range(one+zero, two+one+zero): arr[i] = 2

	return arr

# dnf
def sortAnArrayZeroOneTwo3(arr):
	i=0
	j=0
	k=len(arr)-1

	while(j<=k):
		if(arr[j]==0):
			arr[i], arr[j] = arr[j], arr[i]
			i+=1
			j+=1
		elif(arr[j]==1):
			j+=1
		else:
			arr[j], arr[k] = arr[k], arr[j]
			k-=1
	return arr



print(sortAnArrayZeroOneTwo1([2,0,2,1,1,0]))
print(sortAnArrayZeroOneTwo2([2,0,2,1,1,0]))
print(sortAnArrayZeroOneTwo3([2,0,2,1,1,0]))