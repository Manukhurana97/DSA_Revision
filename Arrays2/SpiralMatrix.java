// https://leetcode.com/problems/spiral-matrix-ii/

public class SpiralMatrix{
	public int[][] generateMatrix(int n) {
        int c=0, left = 0, right = n-1, top=0, bottom=n-1;
        int[][] result = new int[n][n];

        while(c<n*n) {
            // top left to right
            for(int i=left; i<=right; i++) result[top][i] = ++c;
            top++;
            
            // right top to bottom
            for(int i=top; i<=bottom; i++) result[i][right] = ++c;
            right--;

            // bottom right to left
            if(top<bottom){
                for(int i=right; i>=left; i--) result[bottom][i] = ++c;
                bottom-=1;
            }

            // left botto to top
            if(left<right) {
                for(int i=bottom; i>=top; i--) result[i][left] = ++c;
                left++;
            }
        }

        return result;
    }
}