import java.util.*;

public class KLargestElement{

	public static List<Integer> getkLargestElement(int[] arr, int k){
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for(int i: arr){
			queue.add(i);

			if(k<queue.size()) queue.poll();
		}
		
		List<Integer> result = new ArrayList<>();
		while(!queue.isEmpty()) result.add(queue.poll());

		return result;
	}

	public static void main(String[] args) {
		int[] arr = {6,5,3,2,8,10,9};
		System.out.println(getkLargestElement(arr, 4));
	}

}