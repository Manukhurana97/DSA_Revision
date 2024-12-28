import java.util.*;


/*this is an extention of LongestIncreasingSubSequence*/
public class LongestIncreasingSubSequenceBinarySearch{

	/** 
	 * with this approach, we can only get count , we cant print the value.
	 * just put the value if value greater then last else remove the value that is equal or next greater to current.
	*/	

	// Time: O(nlogn), Space: O(n)
	private int getLongestSubstringCount(int[] arr){
		List<Integer> list = new ArrayList<>();

		list.add(0);
		int last = -1;

		for(int i: arr){
			if(last < i){
				list.add(i);
				last = i;
			}else{
				int nextGreaterElementIndex = getIndex(i, list);
				list.set(nextGreaterElementIndex, i);
			}
		}

		return list.size();
	}


	/**Binary search to find the next greater or equals value*/
	private int getIndex(int val, List<Integer> list){

		int left = 0, right = list.size();

		while(left < right){
			int mid = left + (right - left) /2;

			if(list.get(mid) == val) return mid;
			if(list.get(mid) > val) right = mid-1;
			else left = mid+1;
		}

		return left;
	}

	public static void main(String[] args) {
		LongestIncreasingSubSequenceBinarySearch obj = new LongestIncreasingSubSequenceBinarySearch();
		int arr[] = {1,7,8,4,5,6,-1, 9};
		System.out.println(obj.getLongestSubstringCount(arr));
	}
}