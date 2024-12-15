public class SnakesAndLaddersGame{
    public int snakesAndLadders(int[][] board) {
        int len = board.length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});

        Set<Integer> visited = new HashSet<>();
        visited.add(1);

        while(!queue.isEmpty()){
            int[] currentNode = queue.poll();
            int currentPosition = currentNode[0];
            int steps = currentNode[1];

            // roll dice
            for (int i = 1; i <= 6; i++) {
                int nextPosition = currentPosition + i;

                // move outside the box    
                if (nextPosition > len * len)  continue;
                
                int[] coord = getCoord(len, nextPosition);
                int r = coord[0];
                int c = coord[1];
                
                // Handle snakes or ladders
                if (board[r][c] != -1) {
                    nextPosition = board[r][c];
                }
                
                // If we reach the last cell, return the number of steps
                if (nextPosition == len * len) {
                    return steps + 1;
                }
                // Add the next position to the queue if not visited
                if(!visited.contains(nextPosition)){
                    visited.add(nextPosition);
                    queue.add(new int[]{nextPosition, steps+1});
                }
            }
        }

        return -1;
    }

    public int[] getCoord(int len, int position){
        int row = (position - 1) / len;
        int col = (position - 1) % len;
        int r = len - 1 - row; // Flip the row index because the board is bottom-up.
        int c = (row % 2 == 0) ? col : len - 1 - col; // Reverse column for odd rows.
        return new int[]{r, c};
    }
}