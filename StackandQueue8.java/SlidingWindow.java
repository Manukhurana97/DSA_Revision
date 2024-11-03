class Node{
    int data;
    int index;
    Node(int data, int index){
        this.index = index;
        this.data = data;
    }
}

public class SlidingWindow{
	// Time : O(Nlogk)
	public int[] maxSlidingWindow(int[] nums, int k) {
        int  n = nums.length;
        
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> Integer.compare(b.data, a.data));

        // put first k element
        for(int index=0; index<k; index++) queue.add(new Node(nums[index], index));
        
        int[] result = new int[n - k + 1];
        result[0] = queue.peek().data;


        for(int index = k; index < n; index++){
            // remove the element that are out of window
            while(!queue.isEmpty() && (queue.peek().index <= index-k || queue.peek().data < nums[index])){
                queue.poll();
            }

            // add next greater element
            queue.add(new Node(nums[index], index));
            result[index - k + 1] = queue.peek().data;
        }
        
        return result;
    }

    // Time : O(N+N)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, maxElement = nums[0], maxElementIndex = 0;

        // monotonocally increasing queue
        Deque<Integer> queue = new ArrayDeque<>();
        int[] result = new int[n - k + 1];
        
        for(int i=0;i<n;i++){
            if(!queue.isEmpty() && queue.peekFirst() < i-k+1) queue.removeFirst();
                           
            while(!queue.isEmpty() && nums[queue.peekLast()]<nums[i]) queue.removeLast();
            queue.addLast(i);

            if(i >= k-1)
                result[i - k + 1] = nums[queue.getFirst()];
            
        } 

        return result;
    }
}