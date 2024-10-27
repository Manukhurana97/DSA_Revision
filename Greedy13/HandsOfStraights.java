// https://leetcode.com/problems/hand-of-straights/

public class HandsOfStraights{
	
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