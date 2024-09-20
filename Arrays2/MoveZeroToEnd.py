# approach 1: create an aux arr and index to count number of zeros
# approach 2: using 2, pointer keep 1 pointer for 0 and othr pointer for number 

def moveZeroToEnd1(arr):
	aux = []


	for i in range(0, len(arr)):
		if(arr[i] != 0):
			aux.append(arr[i])
	for j in range (0, len(arr) - len(aux)):
		aux.append(0)

	return aux

# find the first zero, move ahead if non zero is encountered then swap
def moveZeroToEnd2(arr):
	i=0
	j=0

	# to find the first zero
	while(j < len(arr) and arr[j] != 0):
		j+=1;


	i = j+1
	while(i < len(arr)):
		if(arr[i] != 0 and j < i):
			arr[i], arr[j] = arr[j], arr[i]
			j += 1

		i+=1;
	return arr





print(moveZeroToEnd1([1 ,0 ,2 ,3 ,0 ,4 ,0 ,1]))	
print(moveZeroToEnd2([1 ,0 ,2 ,3 ,0 ,4 ,0 ,1]))		
