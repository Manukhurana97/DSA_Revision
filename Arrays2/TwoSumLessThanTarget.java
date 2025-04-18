// https://leetcode.com/problems/two-sum-less-than-k/description/

import java.util.*;
public class TwoSumLessThanTarget{

	// solution 1: for loop and rev while loop
	public static int twoSumLessThanTarget(int[] nums, int target) {
		int n = nums.length, maxSum = -1;
		if(n == 1) return -1;


		for(int i=1; i<n; i++){

			if(nums[i] > target) continue;
 
			int j = i-1;
			while(j>0 && nums[i] + nums[j] > target) j-=1;

			if(nums[i] + nums[j] < target)
				maxSum = Math.max(maxSum, (nums[i] + nums[j]));
		}


		return maxSum;
	}


	// sort the array
	public static int twoSumLessThanTarget1(int[] nums, int target) {
		int n = nums.length, maxSum = -1;
		if(n == 1) return -1;

		Arrays.sort(nums);
		

		int left = 0, right = n-1;

		while(left<right){
			if(nums[left] + nums[right] < target){ 
				maxSum = Math.max(maxSum, nums[left] + nums[right]);
				left += 1;
			}
			else right -=1;
		}

		return maxSum;
	}



	public static void main(String[] args) {
		int[] arr = {2,7,11,15};
		System.out.println(twoSumLessThanTarget(arr, 24)+" "+twoSumLessThanTarget1(arr, 24));
	

		int[] arr1 = {3,5,1,9,7};
		System.out.println(twoSumLessThanTarget(arr1, 3) +" "+ twoSumLessThanTarget1(arr1, 3));
	}
}