import java.util.*;

public class KClosestPointsToOrigin{
	public static List<int[]> getClosestPoints(int[][] arr, int k){

		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) ->  
			Math.abs((b[0] << 2) + (b[1] << 2)) - Math.abs((a[0] << 2) + (a[1] << 2)));


		for(int[] i: arr){
			queue.add(i);

			if(queue.size()> k) queue.poll();
		}

		List<int[]> result = new ArrayList<>();
		while(!queue.isEmpty()){
			result.add(queue.poll());
		}

		Collections.reverse(result);
		return result;

	}

	public static void main(String[] args) {
		int[][] arr = {{1,3}, {-2, 2}, {5, 8},{0, 1}};

		var arr1 = getClosestPoints(arr, 2);
		for(var i: arr1) System.out.println(i[0]+" "+i[1]);
	}
}