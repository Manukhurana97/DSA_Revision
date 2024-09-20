# approach 1 : create 2 for loop and check if the element comes twice or not : Time O(N^2) , Space : O(1)
# approach 2 : create a array and count array , run a loop again if count is 1 return 
# approach 3 : run a for loop and change the sign of element, those element with -ve will once Time O(2N) , Space : O(1)
# approach 4 : run a for loop and do xor 

def numberAppearsOnce1(arr):
	for i in range(len(arr)):
		count =1;
		for j in range(len(arr)):
			if(i!=j and arr[i] == arr[j]):
				count+=1;
		if(count==1): 
			return arr[i]

	return -1



def numberAppearsOnce2(arr):
	lar = max(i for i in arr)

	count = [0] * (lar+1)

	for i in arr:
		count[i]+=1

	for i in range(len(count)):
		if(count[i]==1):
			return i



def numberAppearsOnce3(arr):
	for i in arr:
		if(i<0) :
			i*=-1
		arr[i]*=-1


	for i in range(len(arr)):
		if(arr[i]<0): 
			return i
	return -1;


def numberAppearsOnce4(arr):
	xor = 0;
	for i in arr:
		xor ^= i
	return xor



# print(numberAppearsOnce1([4,1,2,1,2]))
# print(numberAppearsOnce2([4,1,2,1,2]))
# print(numberAppearsOnce3([4,1,2,1,2]))
print(numberAppearsOnce4([4,1,2,1,2]))