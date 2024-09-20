import java.util.*;

public class KthElementOfTwoSortedArrays{

	// Time: O(N + NlogN), Space: O(N)
	public static int getKthElement(int[] arr1, int[] arr2, int k){

		List<Integer> resultArr = new ArrayList<>();
		
		for(int i: arr1) resultArr.add(i);
		for(int j: arr2) resultArr.add(j);
		Collections.sort(resultArr); // sort array after merging

		return resultArr.get(k-1);
	}


	// Time: O(N), Space: O(1) 
	public static int getKthElement1(int[] arr1, int[] arr2, int k){
		int i = 0, j = 0;
		int n = arr1.length, m = arr2.length;
		int current = 0;

		while(i < n && j<m && k>0){
			current = (arr1[i]<arr2[j]) ? arr1[i++] : arr2[j++];
			k-=1;			
		}
		while(i < n && k > 0){
			current = arr1[i++];
			k-=1;
		}
		while(j < n && k > 0){
			current = arr2[j++];
			k-=1;
		}

		return  (k == 0) ? current : -1;
	}


	public static int getKthElement2(int[] arr1, int[] arr2, int k){
		int n1 = arr1.length;
		int n2 = arr2.length;

		if(n1 > n2) return getKthElement2(arr2, arr1, k); // to make the binary search on smalled one 

		int left = Math.max(0, k - n2);
		int right = Math.min(k, n1);

		while(left <= right){
			int mid1 = (left + right) / 2;
			int mid2 = k - mid1; 

			int l1 = (mid1 > 0) ? arr1[mid1 - 1] : Integer.MIN_VALUE; // left boundry of sorted arr1
            int l2 = (mid2 > 0) ? arr2[mid2 - 1] : Integer.MIN_VALUE; // left boundry of sorted arr2
            int r1 = (mid1 < n1) ? arr1[mid1] : Integer.MAX_VALUE; // right boundry of sorted arr2
            int r2 = (mid2 < n2) ? arr2[mid2] : Integer.MAX_VALUE; // right boundry of sorted arr2

			if(l1 <= r2 && l2 <= r1){ // if left boundry value is less then or equals to right boundry
                return Math.max(l1, l2);
			}else if(l1>r2){
				right = mid1 - 1;
			}else{
				left = mid1 + 1;
			}
		}

		return 0;
	}


	public static void main(String[] args) {
		int[] arr1 = {2,3,6,7,9};
		int[] arr2 = {1,4,8,10};


		System.out.println(getKthElement(arr1, arr2, 8));
		System.out.println(getKthElement1(arr1, arr2, 8));
		System.out.println(getKthElement2(arr1, arr2, 8));
	}
}