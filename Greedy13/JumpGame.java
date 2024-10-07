public class JumpGame{
    public boolean canJump(int[] nums) {

        return jump(nums, 0);
    }

    public boolean jump(int[] nums, int i){
        if(i>=nums.length) return false;
        if(i == nums.length-1) return true;

        for(int j = 1; j <= nums[i]; j++)
            if(jump(nums, i+j)) 
                return true; 
        
        return false;
    }

    // --------------------------------------------------------
    public boolean canJump(int[] nums) {

        boolean[] visited = new boolean[nums.length];
        return jump(nums, 0, visited);
    }

    public boolean jump(int[] nums, int i, boolean[] visited){
        if(i>=nums.length) return false;
        if(i == nums.length-1) return true;

        for(int j = 1; j <= nums[i]; j++){
            
            if(visited[i+j]) continue;
            visited[i+j] = true;
            
            if(jump(nums, i+j, visited)) 
                return true; 
        }
        
        return false;
    }


    // --------------------------------------------------------

    public boolean canJump(int[] nums) {  
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        stack.add(0);

        while(!stack.isEmpty()){
            int i = stack.pop();
            if(i == n - 1) return true;

            if(visited[i]) continue;
            visited[i] = true;
            
            for(int j = 1; j <= nums[i] && i + j < n; j++) stack.add(i+j);

        }

        return false;
    }
}