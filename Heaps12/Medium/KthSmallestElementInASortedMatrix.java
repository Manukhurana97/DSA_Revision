// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

public class KthSmallestElementInASortedMatrix{
	public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        // storing the initial element of all the nodes/list 
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        for(int i=0; i<n; i++){
            queue.add(new int[]{i, 0});
        }

        while(!queue.isEmpty()){
            int[] currentPoint = queue.poll(); // get the element
            int r = currentPoint[0], c = currentPoint[1];

            System.out.println(matrix[r][c]);

            if(--k==0) return matrix[r][c];

            if(c+1<n){ // if column is less the add , add the next element of that row
                queue.add(new int[]{r, c+1});
            }
        }

        return -1;
    }
}