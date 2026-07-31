// https://leetcode.com/problems/top-k-frequent-elements/

class Node{
    int freq;
    int data;

    Node(int freq, int data){
        this.freq = freq;
        this.data = data;
    }
}

public class TopKFrequentElement{
	public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for(int i: map.keySet()) {
            queue.add(i);

            if(queue.size() > k) 
                queue.poll();
        }

        int[] result = new int[k];
        while(!queue.isEmpty())
            result[queue.size()-1] = queue.poll();
    
        return result;
    }
}