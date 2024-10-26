public class JumpGame2{
	 public int jump(int[] nums) {
        
        int[] visited = new int[nums.length];
        return getCounts(0, nums, visited);

    }

    public int getCounts(int ind, int[] nums, int[] visited){
        if(ind == nums.length-1)  return 0;
        if (ind >= nums.length) return Integer.MAX_VALUE;
        
        if(visited[ind] != 0) return visited[ind];

        int minJumps = Integer.MAX_VALUE;
        for(int i = 1; i <= nums[ind]; i++){
            int jj = getCounts(ind + i, nums, visited);
            if(jj != Integer.MAX_VALUE)
                minJumps = Math.min(minJumps, jj+1);
        }

        visited[ind] = minJumps;
        return minJumps;
    }

    // ------------------------------------------------------------------------


    public int jump(int[] nums) {
        int fartherWeCanGo = 0;
        int jumps = 0;
        int currentEnd = 0;

        if(nums.length==1) return 0;

        for(int i=0;i<nums.length;i++){
            fartherWeCanGo = Math.max(fartherWeCanGo, i + nums[i]);

            if(i == currentEnd){ // end of current jump
                jumps++;
                currentEnd = fartherWeCanGo;

                if(currentEnd >= nums.length-1) break; // if found end
            }
        }

        return jumps;
    }
}