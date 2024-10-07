import java.util.*;

public class ShortedJobFirst{
	public static float shortestJobFirst(int[] arr){
		Arrays.sort(arr);

		int time = 0, totalTime = 0;

		for(int i=0;i<arr.length-1;i++){
			time += arr[i];
			totalTime += time;
		}

		return totalTime/arr.length;
	}


	public static void main(String[] args) {
		int[] arr = {4,3,7,1,2};
		System.out.println(shortestJobFirst(arr));
	}
}