public class KthLargestInStream{

	int n = 0;
    PriorityQueue<Integer> scoreQueue = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        n = k;
        for(int score: nums){
            scoreQueue.add(score);

            if(scoreQueue.size() > n)  scoreQueue.poll();
        }
    }
    
    public int add(int val) {
        scoreQueue.add(val);

        if(scoreQueue.size() > n)  scoreQueue.poll();
        
        return scoreQueue.peek();
    }
}