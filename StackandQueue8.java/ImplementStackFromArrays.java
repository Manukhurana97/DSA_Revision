public class ImplementStackFromArrays{
	
	// last in last out
	int[] arr1;
	int size = 0;
	int maxSizeAllowed = 0;

	public ImplementStackFromArrays(int capacity){
		this.maxSizeAllowed = capacity;
		this.arr1 = new int[capacity];
	}

	public void push(int i){
		if(size == maxSizeAllowed) return;
		
		this.arr1[size] = i;
		this.size += 1;
		return;
	}

	public int pop(){
		if(this.size == 0) return -1;

		this.size -=1;
		int r = this.arr1[size];
		return r;

	}

	public int size(){
		return this.size < 0 ? 0 : this.size;
	}


	public static void main(String[] args) {
		ImplementStackFromArrays obj = new ImplementStackFromArrays(10);
		System.out.println("Size "+obj.size());
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		obj.push(5);
		System.out.println("Size "+obj.size());
		System.out.print(obj.pop()+","+obj.pop()+","+obj.pop()+","+obj.pop()+","+obj.pop()+","+obj.pop()+"\n");
		System.out.println("Size "+obj.size);
	}
}