public class FloodFills{
	public int[][] floodFill(int[][] image, int r, int c, int color) {
        if (image[r][c] != color)
            // dfs(image, r, c, image[r][c], color);
            bfs(image, r, c,  image[r][c], color);

        return image;
    }

   
    // BFS: Time : O(n), Space : O(m)
    public void dfs(int[][] image, int r, int c, int startColor, int endColor){
        if(r < 0 || c < 0 || r >= image.length || c >= image[r].length || image[r][c] != startColor) return ;

        image[r][c] = endColor;

        dfs(image, r - 1, c, startColor, endColor);
        dfs(image, r, c - 1, startColor, endColor);
        dfs(image, r + 1, c, startColor, endColor);
        dfs(image, r, c + 1, startColor, endColor);
    }

     // BFS: Time : O(n), Space : O(n)
    public void bfs(int[][] image, int r, int c, int startColor, int endColor){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            r = current[0];
            c = current[1];

            image[r][c] = endColor;


            if (r - 1 >= 0 && image[r - 1][c] == startColor) queue.add(new int[]{r - 1 , c});
            if (c - 1 >= 0 && image[r][c - 1] == startColor) queue.add(new int[]{r , c - 1});
            if (r + 1 < image.length && image[r + 1][c] == startColor) queue.add(new int[]{r + 1 , c});
            if(c + 1 < image[r].length && image[r][c + 1] == startColor) queue.add(new int[]{r , c + 1});

        }

        return;
    }
}