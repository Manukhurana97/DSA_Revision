def print_n_times(n):
	if(n==0):
		return n

	print_n_times(n-1)
	print(n)


def print_factorial(n):
	if(n==1):
		return n

	return n * print_factorial(n-1)
	

def reverse_a_array(arr, i, n):
	if i == n : 
		return arr

	arr[i], arr[n] = arr[n], arr[i]

	return reverse_a_array(arr, i+1, n-1)


def palandrome_string(str,  i,  n):
	if i == n:
		return True
	if str[i] != str[n]: 
		return Falsereturn 

	return palandrome_string(str, i+1, n-1)




print("print n number", print_n_times(5))
print("factorial", print_factorial(5))
print("reverse a array", reverse_a_array([1,2,3,4,5], 0, 4))
print("is String a palandrome", palandrome_string('abcba', 0, 4))