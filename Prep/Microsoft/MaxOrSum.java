import java.util.*;

public class MaxOrSum {

	public static long getMaxOrSum(List<Integer> arr, int k) {
		int n = arr.size();
		long result = 0;

		for(int i=0; i<n; i++) {
			long sum = 0;
			for(var j=0; j<n; j++) {
				if(i!=j){
					sum |= (long)(arr.get(j) << k);
				} else{
					sum |= arr.get(i);
				}
			}

			result = Math.max(result, sum);
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(getMaxOrSum(List.of(12, 9), 1));
	}
}