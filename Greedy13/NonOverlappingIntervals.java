import java.util.*;

public class NonOverlappingIntervals{

	public int eraseOverlapIntervals(int[][] intervals) {
     	PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);  

     	for(int[] interval: intervals) queue.add(interval);

     	int erasedIntervals = 0;
     	int[] prevInterval = queue.poll();

     	while(!queue.isEmpty()){
     		int[] currentInterval = queue.poll();

     		if(prevInterval[1]>currentInterval[0]){
     			erasedIntervals +=1;
     		}else{
     			prevInterval[1] = currentInterval[1];
     		}
     	} 

     	return erasedIntervals;
    }

    // ------------------------------------------------------------------------------------------------------------



    public int eraseOverlapIntervals(int[][] intervals) {
        
     	Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);  

     	int erasedIntervals = 0;
     	int[] prevInterval = intervals[0];

     	for(int ind=1; ind < intervals.length; ind++){
     		int[] currentInterval = intervals[ind];

     		if(prevInterval[1]>currentInterval[0]){
     			erasedIntervals +=1;
     		}else{
     			prevInterval[1] = currentInterval[1];
     		}
     	} 

     	return erasedIntervals;
    }




    public static void main(String[] args) {
    	NonOverlappingIntervals obj = new NonOverlappingIntervals();
    	
    	int[][] arr = {{1,2},{2,3},{3,4},{1,3}};
    	System.out.println(obj.eraseOverlapIntervals(arr));


    	int[][] arr1 = {{1,2},{1,2},{1,2}};
    	System.out.println(obj.eraseOverlapIntervals(arr1));

    	int[][] arr2 = {{1,2},{2,3}};
    	System.out.println(obj.eraseOverlapIntervals(arr2));
    }
}