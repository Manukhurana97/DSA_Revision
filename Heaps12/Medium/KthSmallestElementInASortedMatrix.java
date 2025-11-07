// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

public class KthSmallestElementInASortedMatrix{
	public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        // storing the initial element/ro of all the rows
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        for(int i=0; i<n; i++){
            queue.add(new int[]{i, 0});
        }

        while(!queue.isEmpty()){
            int[] currentPoint = queue.poll(); // get the element
            int r = currentPoint[0], c = currentPoint[1];

            System.out.println(matrix[r][c]);

            if(--k==0) return matrix[r][c];

            if(c+1<n){ // if column is less then n , add the next element of that row
                queue.add(new int[]{r, c+1});
            }
        }

        return -1;
    }


    // -------------------------------------------------------------------------------------------------------



    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n-1][n-1];

        while(left<right) {
            int mid = left + (right - left) / 2;
            int count = getElementLessThenEquals2(matrix, mid);

            if(count < k) {
                left = mid+1;
            } else {
                right = mid;
            }
        }

        return left;
    }


    public int getElementLessThenEquals1(int[][] matrix, int val) {
        int n = matrix.length, count = 0;

        for(int r=0; r<n; r++) {
            int left = 0, right = n-1;
            
            while(left<=right) {
                int mid = (left + right) / 2;

                if(matrix[r][mid] <= val) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            count += left;
        }

        return count;
    }


    public int getElementLessThenEquals2(int[][] matrix, int val) {
        int n = matrix.length;
        int r = 0, c = n-1, count = 0;

        while(r<n && c>=0) {
            if(matrix[r][c] <= val) {
                count += c+1;
                r++;
            } else {
                c--;
            }
        }
        return count;
    }
}