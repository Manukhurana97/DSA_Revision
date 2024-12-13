import java.util.*;

public class WallsAndGates{

	public void wallsAndGates(int[][] rooms) {

		int rows = rooms.length, cols = rooms[0].length;

		Queue<int[]> queue = new LinkedList<>();

		for(int r=0; r<rows; r++){
			for(int c=0; c<cols; c++){
				if(rooms[r][c] == 0){
					queue.add(new int[]{r, c, 0});
				}
			}
		}

		boolean[][] visited = new boolean[rows][cols];

		while(!queue.isEmpty()){
			int[] current = queue.poll();
			int r = current[0];
			int c = current[1];
			int l = current[2];

			if(rooms[r][c]> l) rooms[r][c] = l;

			if(r - 1 >= 0 && !visited[r - 1][c]){
				visited[r-1][c] = true;
				queue.add(new int[]{r - 1, c, l + 1});
			}
			if(c-1>=0 && !visited[r][c-1]){
				visited[r][c-1] = true;
				queue.add(new int[]{r, c-1, l+1});
			}

			if(r+1<rows && !visited[r+1][c]){
				visited[r+1][c] = true;
				queue.add(new int[]{r+1, c, l+1});
			}
			if(c+1<cols && !visited[r][c+1]){
				visited[r][c+1] = true;
				queue.add(new int[]{r, c+1, l+1});
			}
		}
	}
}