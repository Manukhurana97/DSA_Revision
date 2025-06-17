// https://leetcode.com/problems/find-median-from-data-stream/

public class FindMedianInDataStream{
	PriorityQueue<Integer> maxHeap; // Max-heap for the smaller half of numbers
    PriorityQueue<Integer> minHeap; // Min-heap for the larger half of numbers

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); // val store 1 2 3 4
        minHeap = new PriorityQueue<>(); // val store : 5 6 7 8 9

    }
    
    public void addNum(int num) {
        maxHeap.add(num);

        // Balance: Ensure maxQueue only has the smaller half of numbers
        if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) { // max queue store min element , min queue store largest elemt
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