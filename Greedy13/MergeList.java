public class MergeList{
	public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] prev = intervals[0];
        List<int[]> mergeList = new ArrayList<>();
        mergeList.add(prev);

        for(int i = 1;i<intervals.length;i++){
            
            if(prev[1]>=intervals[i][0]){
                prev[1] = Math.max(prev[1], intervals[i][1]);
            }else{
                prev = intervals[i];
                mergeList.add(prev);
            }
        }

        return mergeList.toArray(new int[mergeList.size()][]);
    }
}