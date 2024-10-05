import java.util.*;

public class KClosestPointsToOrigin{
	public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            long distA = (long) a[0] * a[0] + (long) a[1] * a[1];
            long distB = (long) b[0] * b[0] + (long) b[1] * b[1];
            return Long.compare(distB, distA); 
        });


        for(int[] coord: points){
            queue.add(coord);

            if(queue.size() > k) queue.poll();
        }

        int[][] result = new int[queue.size()][2];
        while(!queue.isEmpty()) result[--k] = queue.poll();
        

        return result;

    }

	public static void main(String[] args) {
		int[][] arr = {{1,3}, {-2, 2}, {5, 8},{0, 1}};

		var arr1 = kClosest(arr, 2);
		for(var i: arr1) System.out.println(i[0]+" "+i[1]);
	}
}