import java.util.*;

public class MaxRequestsInWindow {

	public int maxRequestsInWindow(int[] nums, int n) {
		Arrays.sort(nums);
		
		int max = nums[nums.length-1], maxCount = 0;

		for(int i=1; i<=max; i++) {
			maxCount = Math.max(maxCount, getElementInWindow(i, i+n-1, nums));
		}
		
		return maxCount;
	}

	public int getElementInWindow(int start, int end, int[] nums) {
		return upperBound(0, nums.length, end, nums) - lowerBound(0, nums.length, start, nums);
	} 

	private int lowerBound(int left, int right, int elem, int[] nums) {
		while(left<right) {
			int mid = (left + right) / 2;

			if(nums[mid] >= elem) {
				right = mid;
			} else {
				left = mid+1;
			}
		}

		return left;
	}

	private int upperBound(int left, int right, int elem, int[] nums) {
		while(left<right) {
			int mid = (left + right) / 2;

			if(nums[mid] > elem) {
				right = mid;
			} else {
				left = mid+1;
			}
		}

		return left;
	}


	// -----------------------------------------------------------------

	public int maxRequestsInWindow2(int[] timestamps, int windowSize) {
	    Arrays.sort(timestamps);

	    int left = 0, maxCount = 0;

	    for (int right = 0; right < timestamps.length; right++) {

	        // shrink until window fits
	        while (timestamps[right] - timestamps[left] >= windowSize) {
	            left++;
	        }

	        maxCount = Math.max(maxCount, right - left + 1);
	    }

	    return maxCount;
	}



	public static void main(String[] args) {
		Test test = new Test();

		int[] arr = {1,3,7,5};
		System.out.println(test.maxRequestsInWindow(arr, 4));
		System.out.println(test.maxRequestsInWindow2(arr, 4));
	}
}