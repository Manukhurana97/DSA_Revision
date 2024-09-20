import java.util.*;

public class MedianOfTwoSortedArray{

	// Time : O(N + M + N + MlogN + M), Space: O(N+M)
	public static float getMedian(int[] arr1, int[] arr2){
		List<Integer> mergedArray = new ArrayList<>();

		for(int i: arr1) mergedArray.add(i);
		for(int j: arr2) mergedArray.add(j);

		Collections.sort(mergedArray);
		int n = mergedArray.size();
		return (n%2 == 0) ? (float)(mergedArray.get(n/2) + mergedArray.get(n/2 - 1))/2 : mergedArray.get(n/2);	
	}


	// Time Complexity: O(n+n), Space: O(1) 
	public static double getMedian1(int[] arr1, int[] arr2){
		int i=0, j=0, m = arr1.length, n = arr2.length;

		int cur = 0, prev = 0;
		int ith = (m + n) / 2, jth = ((m + n) % 2 == 0) ? ith - 1 : 0;

		while(i<n && j<m){
			int val = (arr1[i] < arr2[j]) ? arr1[i++] : arr2[j++];
			if (ith == 0) cur = val;
			if (jth == 0) prev = val;
			ith--;
			jth--;
		}

		while(i<n){
			int val = arr1[i++];
			if (ith == 0) cur = val;
			if (jth == 0) prev = val;
			ith--;
			jth--;

		}

		while(j<m){
			int val = arr2[j++];
			if (ith == 0) cur = val;
			if (jth == 0) prev = val;
			ith--;
			jth--;
		}

		return ((m + n) % 2 == 0) ? (double) (cur + prev) / 2 : cur;
	}



	// The Approach is to divided the array 
	// 1. Take the array which is smalled and the divide the array from 0 to len(small)
	// like 0 -> 5 : take 0 element from array1 and remaing element from array2 and see the if array is sorted
	// these will always be a  point when after diving both array will be sorted, once the point is found
	// compare element of left and right and return the result.
	public static double getMedian2(int[] arr1, int[] arr2){
		int n1 = arr1.length, n2 = arr2.length;
		int left = 0, right = (n1 < n2) ? n1 : n2;
		int len = n1+n2;
		
		while(left<=right){
			int mid1 = (left + right)/2;
			int mid2 = (len + 1)/2 - mid1;

			int l1 = mid1 > 0 ? arr1[mid1 - 1]: Integer.MIN_VALUE;
			int l2 = mid2 > 0 ? arr2[mid2 - 1]: Integer.MIN_VALUE;
			int r1 = mid1 < n1 ? arr1[mid1]: Integer.MAX_VALUE;
			int r2 = mid2 < n2 ? arr2[mid2]: Integer.MAX_VALUE;

			if(l1<=r2 && l2<=r1){
				if(len % 2 != 0) return Math.max(l1, l2); 
				return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
			}else if (l1 > r2) right = mid1 - 1;
			else left = mid1 + 1;
			
		
		}

		return 0;
	}


	public static void main(String[] args) {
		int[] arr1 = {1, 3, 8};
        int[] arr2 = {7, 9, 10};

		// System.out.println(getMedian(arr1, arr2));
		// System.out.println(getMedian1(arr1, arr2));
		System.out.println(getMedian2(arr1, arr2));
	}
}