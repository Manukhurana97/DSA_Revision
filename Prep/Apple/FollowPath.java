import java.util.*;
public class FollowPath {

    static StringBuilder builder = new StringBuilder();

   public static String followPath(List<String> gridMap) {
        boolean[][] visited = new boolean[10][15];
        
        dfs(0, 0, gridMap, visited);
        return builder.toString();
    }

    public static void dfs(int r, int c, List<String> grid, boolean[][] visited) {
        if (r < 0 || c < 0 || r >= grid.size() || c >= grid.get(r).length() || visited[r][c] || grid.get(r).charAt(c) == ' ') {
            return;
        }

        visited[r][c] = true;

        if ('a' <= grid.get(r).charAt(c) && grid.get(r).charAt(c) <= 'z') {
            builder.append(grid.get(r).charAt(c));
        }

        // Change order: Down → Right → Left → Up
        dfs(r - 1, c, grid, visited); // Up
        dfs(r, c - 1, grid, visited); // Left
        dfs(r + 1, c, grid, visited); // Down
        dfs(r, c + 1, grid, visited); // Right
        
        
    }


    public static void main(String[] args) {
         List<String> list = Arrays.asList(
            "***           ",
            "  *           ",
            "  *           ",
            "  **c**od**i**",
            "             *",
            "    e        *",
            "    *        n",
            "    **m*a*g***"
        );



        System.out.println(followPath(list));
    }

}