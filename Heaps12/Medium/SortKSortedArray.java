import java.util.*;

public class SortKSortedArray{

	public static int[] nearlyKSorted(int[] arr, int k){
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int index = 0;

		for(int i: arr){
			queue.add(i);
			if(queue.size() > k) arr[index++] = queue.poll();
		}

		while(!queue.isEmpty()) arr[index++] = queue.poll();

		return arr;
	}
	

	public static void main(String[] args) {
		int[] arr = {6,5,3,2,8,10,9};
		arr = nearlyKSorted(arr, 4);
		for(int i: arr)
			System.out.println(i);
	}
}