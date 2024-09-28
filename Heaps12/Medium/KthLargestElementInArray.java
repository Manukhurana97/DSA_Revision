// https://leetcode.com/problems/kth-largest-element-in-an-array/

import java.util.*;

public KthLargestElementInArray{

	public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i : nums){ queue.add(i);

            if(queue.size()>k) queue.poll();
        }

        return queue.peek();
        
    }

    // ---------------------------------------------------

    /*

		def findKthLargest(self, nums: List[int], k: int) -> int:
        if not nums:
            return 

        pivot = random.choice(nums)

        greaterThenPivot = [i for i in nums if i>pivot]
        equalsThenPivot = [i for i in nums if i==pivot]
        lessThenPivot = [i for i in nums if i<pivot]

        if k <= len(greaterThenPivot): return self.findKthLargest(greaterThenPivot, k);
        if k > len(equalsThenPivot)+len(greaterThenPivot): return self.findKthLargest(lessThenPivot, k - len(equalsThenPivot) - len(greaterThenPivot));
        return equalsThenPivot[0]

    */ 


    // ---------------------------------------------------

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1; // Handle case where input is invalid
        }

        Random rand = new Random();
        int pivot = nums[rand.nextInt(nums.length)];

        List<Integer> greaterThanPivot = new ArrayList<>();
        List<Integer> equalsToPivot = new ArrayList<>();
        List<Integer> lessThanPivot = new ArrayList<>();

        for (int num : nums) {
            if (num > pivot) {
                greaterThanPivot.add(num);
            } else if (num == pivot) {
                equalsToPivot.add(num);
            } else {
                lessThanPivot.add(num);
            }
        }

        if (k <= greaterThanPivot.size()) {
            int[] greaterArray = greaterThanPivot.stream().mapToInt(i -> i).toArray();
            return findKthLargest(greaterArray, k);
        } else if (k > greaterThanPivot.size() + equalsToPivot.size()) {
            int[] lessArray = lessThanPivot.stream().mapToInt(i -> i).toArray();
            return findKthLargest(lessArray, k - greaterThanPivot.size() - equalsToPivot.size());
        }

        return equalsToPivot.get(0);
    }

}