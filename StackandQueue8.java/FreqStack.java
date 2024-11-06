public class FreqStack {

    // to store, level/order and values
    Map<Integer, Integer> freqCountCache;
    Map<Integer, Deque<Integer>> freqCountMap;
    private int maxFreq;

    public FreqStack() {
        maxFreq = 0;
        freqCountCache = new HashMap<>(); 
        freqCountMap = new HashMap<>();
    }
    
    public void push(int val) {
        int freq = freqCountCache.getOrDefault(val, 0) + 1;
        freqCountCache.put(val, freq);

        maxFreq = Math.max(maxFreq, freq);
        
        freqCountMap.computeIfAbsent(freq, k -> new LinkedList()).push(val);
        
    }
    
    
    public int pop() {
        // remove the element from current freq list
        Deque<Integer> queue = freqCountMap.get(maxFreq);
        var resultVal = queue.pop();

        
        // queue is empty, remove the queue from freq count map
        if(queue.isEmpty()){ 
            freqCountMap.remove(maxFreq);
            maxFreq--;
        }

        //  if element freq is one, remove from cache
        
        freqCountCache.put(resultVal, freqCountCache.get(resultVal) - 1);
        if (freqCountCache.get(resultVal) == 0) {
            freqCountCache.remove(resultVal);
        }

        return resultVal;
    }
}