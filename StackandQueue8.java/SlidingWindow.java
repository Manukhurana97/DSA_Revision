// https://leetcode.com/problems/sliding-window-maximum/

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
        Deque<Integer> queue = new LinkedList<>();

        // add the k element in queue
        for(int i=0; i<k; i++){
            int val = nums[i];
            while(!queue.isEmpty() && nums[queue.peekLast()]<val){
                queue.pollLast();
            }
            queue.addLast(i);
        }

        int n=nums.length, j=0;

        int[] result = new int[n-k+1];
        result[j++] = nums[queue.peekFirst()];

        for(int i=k; i<n; i++){
            if(!queue.isEmpty() && queue.peekFirst() < i-k+1) queue.pollFirst();

            int val = nums[i];
            while(!queue.isEmpty() && nums[queue.peekLast()]<val){
                queue.pollLast();
            }
            queue.addLast(i);

            result[j++] = nums[queue.peekFirst()];
        }

        return result;
    }
}