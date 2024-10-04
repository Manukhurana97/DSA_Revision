import java.util.*;



public class TopKFrequenceNumber{

	public static int[] getTopkFreqElements(int[] arr, int k){

		Map<Integer, Integer> freqMap = new HashMap<>();
		for(int i: arr) freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);

		PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> freqMap.get(a) - freqMap.get(b));
		for(int i: freqMap.keySet()){
			queue.add(i);

			if(queue.size() > k) queue.poll();
		}		


		int i = 0;
		int[] result = new int[queue.size()];
		while(!queue.isEmpty()) result[i++] = queue.poll();

		return result;
	}

	public static void main(String[] args) {
		int[] arr = {1,1,1,3,2,2,4};

		arr = getTopkFreqElements(arr, 2);
		for(int i: arr) System.out.print(i+" ");
	}
}