public class FindMedianInDataStream{
	PriorityQueue<Integer> maxHeap; // Max-heap for the smaller half of numbers
    PriorityQueue<Integer> minHeap; // Min-heap for the larger half of numbers

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();

    }
    
    public void addNum(int num) {
        maxHeap.add(num);

        // Balance: Ensure maxQueue only has the smaller half of numbers
        if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.add(maxHeap.poll());
        }


        if(maxHeap.size() > minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }

        if(maxHeap.size() + 1 < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
        
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()) return maxHeap.peek();
        if(maxHeap.size() < minHeap.size()) return minHeap.peek();
        return (double) (maxHeap.peek() + minHeap.peek()) / 2;
    }
}