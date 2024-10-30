public class TopKFrequentElement{

	// Time : O(N+klogk), Space: O(N + 2k)
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 1) return nums;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((a, b)-> a.count - b.count);
        for(Map.Entry<Integer, Integer>kv: map.entrySet()){
            queue.add(new Node(kv.getKey(), kv.getValue()));
            if (queue.size()>k) queue.poll();
        }

        int[] result = new int[k];
        int i = 0;
        while(!queue.isEmpty()){
            result[i++] = queue.poll().no;
        }

        return result;
    }
}