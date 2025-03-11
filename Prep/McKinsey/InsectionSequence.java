import java.util.*;

public class InsectionSequence{

	public int sequenceCount(int[] arr, int[] infected){
		int mod = 1_000_000_007;
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		
		for(int i: infected){ 
			queue.add(i-1);
			visited.add(i-1);
		}
		
		int count = 0;

		while(!queue.isEmpty()){
			Queue<Integer> temp = new LinkedList<>();
			int size = queue.size();

			for(int i=0; i<size; i++){
				int current = queue.poll();

				if(current-1>=0 && !visited.contains(current-1)){
					temp.add(current-1);
					visited.add(current-1);
				}
				if(current+1<arr.length && !visited.contains(current+1)){
					temp.add(current+1);
					visited.add(current+1);
				}
			}
			count = (count + temp.size())%mod;

			queue.addAll(temp);
		}

		return count;
	}	

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int[] infected = {1,  5};

		InsectionSequence obj = new InsectionSequence();

		System.out.println(obj.sequenceCount(arr, infected));
	}
}