import java.util.*;

class Node{
	int startTime;
	int endTime;

	Node(int startTime, int endTime){
		this.startTime = startTime;
		this.endTime = endTime;
	}
}

public class NMeetingInOneRoom{
	
	public int maxMeetings(int start[], int end[]) {
		PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.endTime == b.endTime ? a.startTime - b.startTime : a.endTime - b.endTime);
		
		for(int i = 0; i < start.length; i++) 
			queue.add(new Node(start[i], end[i]));

		int count = 0;
		int currentTime = 0;

		while(!queue.isEmpty()){
			Node currentNode = queue.poll();


			if(currentNode.startTime > currentTime){
				count +=1;
				currentTime = currentNode.endTime;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		NMeetingInOneRoom obj = new NMeetingInOneRoom();
		int[] start = {0, 3, 1, 5, 5, 8};
		int[] end = {5, 4, 2, 9, 7, 9};
		System.out.println(obj.maxMeetings(start, end)); // [1:2, 3:4,0:5, ]


		int[] start1 = {1, 3, 0, 5, 8, 5};
		int[] end1 = {2, 4, 6, 7, 9, 9};
		System.out.println(obj.maxMeetings(start1, end1));


		int[] start2 = {10, 12, 20};
		int[] end2 = {20, 25, 30};
		System.out.println(obj.maxMeetings(start2, end2));

	}
}