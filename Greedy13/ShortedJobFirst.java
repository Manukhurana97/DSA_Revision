import java.util.*;

public class ShortedJobFirst{
	public static float shortestJobFirst(int[] arr){
		Arrays.sort(arr);

		int time = 0, totalTime = 0;

		for(int i=0;i<arr.length-1;i++){
			time += arr[i];
			totalTime += time;
		}

		return totalTime/arr.length;
	}

// -----------------------------------------------------------------------------------

	public int[] getOrder(int[][] tasks) {

        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> 
        a.data == b.data ? (a.time == b.time ? a.index - b.index : a.time - b.time) : a.data - b.data);


        for(int i=0;i<tasks.length;i++) 
            queue.add(new Node(i, tasks[i][0], tasks[i][1]));

        int time = 0;
        int index = 0;
        int[] result = new int[tasks.length];

        PriorityQueue<Node> aux = new PriorityQueue<>((a, b) -> 
        a.time == b.time ? a.index - b.index : a.time - b.time);
        
        while(!queue.isEmpty() || !aux.isEmpty()){
            while (!queue.isEmpty() && queue.peek().data <= time) 
                aux.add(queue.poll());
        
            
            if (!aux.isEmpty()) {
                var node = aux.poll();
                time += node.time;
                result[index++] = node.index;
            }else{ // not task is ready, init time with first task
                time = queue.peek().data;
            }
        }

        return result;
    }


	public static void main(String[] args) {
		int[] arr = {4,3,7,1,2};
		System.out.println(shortestJobFirst(arr));

		int[] arr1 = {{1,2},{2,4},{3,2},{4,1}};
		System.out.println(getOrder(arr1));
	}
}
