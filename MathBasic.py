def countDigit(val):
	count=0
	while(val!=0):
		count+=1;

		val=int(val/10);
	return count;



def reverseaNumber(val):
	result = 0;
	while(val!=0):
		result*=10;
		result += int(val%10);
		val=int(val/10);
	return result;



def palandrome(val): 
	temp = val
	reverse = 0;
	while(val!=0):
		reverse = reverse * 10 + val % 10;
		val = val // 10;
	return temp==reverse



def gsd(a, b):
	max = 1;
	for i in range(1, min(a, b)+1):
		if a%i == 0 and b%i==0: 
			max = i
	return max
	

def armstrongNumber(num):
	temp = num;
	arms = 0;

	while temp != 0:
		arms += pow(temp%10, 3)
		temp //=10;	


	return num == arms



print("count ", countDigit(12345))
print("reverseaNumber ", reverseaNumber(12345))
print("isPalandrome ", palandrome(121))
print("GSD ", gsd(4, 6))
print("armstrongNumber", armstrongNumber(153))

