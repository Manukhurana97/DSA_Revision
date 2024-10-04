import java.util.*;

class Node{
	int distance;
	int data;

	Node(int distance, int data){
		this.distance = distance;
		this.data = data;
	}
}

public class KClosestElements{
	public static int[] getKNearestElement(int[] arr, int n, int k){
		int[] result = new int[k];
		PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> b.distance - a.distance);

		for(int i: arr){
			queue.add(new Node(Math.abs(n-i), i));

			if (queue.size()>k) queue.poll();
		}

		int i = 0;
		while(!queue.isEmpty()){
			result[i++] = queue.poll().data;
		}

		return result;
	}


	public static int[] getKNearestElement1(int[] arr, int n, int k){
		int[] result = new int[k];
		PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Math.abs(n-b) - Math.abs(n-a));

		for(int i: arr){
			queue.add(i);

			if (queue.size()>k) queue.poll();
		}

		int i = 0;
		while(!queue.isEmpty()){
			result[i++] = queue.poll();
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = {5,6,7,8,9};
		arr = getKNearestElement1(arr, 7, 3);
		for(int i: arr) System.out.print(i+" ");
	}
}