public class HandOfStraights{
	public boolean isNStraightHand(int[] hand, int groupSize) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : hand) map.put(i, map.getOrDefault(i, 0) + 1);

        while(!map.isEmpty()){
            int key = map.firstKey();
            for(int i = key; i < groupSize + key; i++){
                if(!map.containsKey(i)) return false;

                int freq = map.get(i);
                if(freq <= 1) map.remove(i);
                else map.put(i, freq-1);
            }
        }

        return true;
    }


    // ------------------------------------------------------------------
    
    public boolean isNStraightHand(int[] hand, int groupSize) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : hand) queue.add(i);

        while(!queue.isEmpty()){
            int start = queue.poll();
            
            for(int i = 1; i < groupSize ; i++)
                if(!queue.remove(i + start)) return false;
        }

        return true;
    }


    // -------------------------------------------

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i: hand) map.put(i, map.getOrDefault(i, 0) + 1);
        PriorityQueue<Integer> queue = new PriorityQueue<>(map.keySet());

        while(!queue.isEmpty()){
            int smallestInGroup = queue.peek();
            
            for(int i=0; i < groupSize; i++){
                int card = smallestInGroup + i;
                
                if(!map.containsKey(card)) return false;

                int count = map.get(card);
                if(count == 1){ 
                    if(card != queue.peek()) return false;
                    map.remove(card);
                    queue.poll();
                }
                else map.put(card, count-1);
            }
        }
        return true;
    }
}