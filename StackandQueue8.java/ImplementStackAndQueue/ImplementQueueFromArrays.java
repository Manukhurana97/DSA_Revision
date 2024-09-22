public class ImplementQueueFromArrays{

	int startIndex = 0;
	int endIndex = 0;
	int maxCapacityAllowed = 0;
	int[] arr;

	public ImplementQueueFromArrays(int size){
		this.maxCapacityAllowed = size;
		this.arr = new int[size+1];
	}

	public void push(int val){
		if(this.endIndex >= this.maxCapacityAllowed)
			return;
		
		arr[endIndex] = val;
		endIndex += 1;
	}

	public int pop(){
		if(this.endIndex <= 0) return -1;
	
		var ret = arr[startIndex];
		startIndex += 1;

		if(startIndex<endIndex) startIndex = endIndex = 0;
		

		return ret;	
	}

	public int size(){
		var diff = this.endIndex - this.startIndex;
		return diff < 0 ? 0: diff;
	}

	public int top(){
		if(this.size() == 0) return -1;

		return this.arr[startIndex];
	}


	public static void main(String[] args) {
		ImplementQueueFromArrays obj = new ImplementQueueFromArrays(5);
		System.out.println("size "+obj.size());
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		obj.push(5);
		obj.push(6);
		System.out.println("size "+obj.size());
		System.out.println("top "+ obj.top());
		System.out.println("pop "+ obj.pop());
		System.out.println("pop "+ obj.pop());
		System.out.println("pop "+ obj.pop());
		System.out.println("size "+obj.size());


	}
}