// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/

public class FindKPairWithSmallestSum{

	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a, b) -> -(a.get(0) + a.get(1)) + (b.get(0) + b.get(1)));
        
        for(int i: nums1){
            for(int j: nums2){
                queue.add(List.of(i, j));

                if(queue.size()>k) queue.poll();
            }
        }

        while(!queue.isEmpty()){
            result.add(queue.poll());
        }

        return result;
    }



	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0] + a[1]));

        for(int i=0; i<Math.min(k, nums1.length); i++){
            queue.add(new int[]{nums1[i], nums2[0], 0});
        }

        while(k-->0 && !queue.isEmpty()){
            int[] current = queue.poll();
            result.add(List.of(current[0], current[1]));

            int nextIndex = current[2]+1;
            if(nextIndex<nums2.length){
                queue.offer(new int[]{current[0], nums2[nextIndex], nextIndex});
            }
        }

        return result;
    }
}