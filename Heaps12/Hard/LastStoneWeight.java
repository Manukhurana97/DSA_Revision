public class LastStoneWeight{
	public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i: stones){
            queue.add(i);
        }

        while(!queue.isEmpty() && queue.size() >= 2){
            int a = queue.poll();
            int b = queue.poll();

             if(a != b) queue.add(Math.abs(a-b));
        }

        return queue.isEmpty() ? 0 : queue.poll();
    }
}