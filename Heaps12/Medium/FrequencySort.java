import java.util.*;

public class FrequencySort{
	public static int[] sort(int[] arr){
		Map<Integer, Integer> map = new HashMap<>();

		for(int i: arr) map.put(i, map.getOrDefault(i, 0) + 1);

		PriorityQueue<Integer> queue = new PriorityQueue<>((a , b) -> map.get(a) - map.get(b));

		for(int i: map.keySet()) queue.add(i);

		int index = queue.size();
		int[] result = new int[queue.size()];

		while(!queue.isEmpty()) 
			result[--index] = queue.poll();

		return result;

	}




	public static void main(String[] args) {
		int[] arr = {1,1,2,2,2,3,3,4};

		arr = sort(arr);
		for(int i: arr) System.out.print(i+" ");
	}
}