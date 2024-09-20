public class SlidingWindowMaximum{
	public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer> queue = new LinkedList<>();
        int i = 0, current = 0, last = 0;

        for(current=0; current < k;current++){
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[current]) queue.pollLast();
            queue.add(current);
        }

        result[i++] = nums[queue.peekFirst()];

        while(current < n){
            if(queue.peekFirst() < current - k + 1) queue.pollFirst();
            
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[current]) queue.pollLast();
        
            queue.add(current);
            result[i++] = nums[queue.peekFirst()];
            current++;
        }
        
        return result;
    }
}