import java.util.*;

class Node{
	int r;
	int c;
	int steps;

	Node(int r, int c, int steps){
		this.r = r;
		this.c = c;
		this.steps = steps;
	}
}

public class MinimumKnitesMoves{

	public static int minKniteMoves(int r, int c){

		int cr = 0, cc = 0;

		PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.steps - b.steps);
		queue.add(new Node(0, 0, 0));

		Set<String> visited = new HashSet<>();
		visited.add("0,0");

		int[] dr = {-2, -2, 2, 2, -1, -1, 1, 1};
        int[] dc = {-1, 1, -1, 1, -2, 2, -2, 2};


		while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

			for(int i=0; i<dr.length; i++){
				int nr = currentNode.r+dr[i];
				int nc = currentNode.c+dc[i];
				String pos = nr + "," + nc;

				if (currentNode.r == r && currentNode.c == c) {
	                return currentNode.steps;
	            }


				if(!visited.contains(pos)){
					queue.add(new Node(nr, nc, currentNode.steps+1));
					visited.add(pos);
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(minKniteMoves(5, 5));
	}
}