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
                PriorityQueue<Node> queue = new PriorityQueue<>(((a, b) ->  a.freq - b.freq));

        Map<Integer, Node> map = new HashMap<>();
        
        for(int i: nums){
            Node current = new Node(1, i); 

            if(map.containsKey(i)){
                current = map.get(i);
                queue.remove(current);
                current.freq +=1;
            }
            
            map.put(i, current);
            queue.add(current);

            if(queue.size() > k){
                queue.poll();
            }
        }
            
        int index = queue.size();
        int[] result = new int[queue.size()];
        while(!queue.isEmpty()){
            result[--index] = queue.poll().data;
        }
        

        return result;
    }
}