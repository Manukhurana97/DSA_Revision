class Node{

    int key;
    int value;
    Node prev;
    Node next;
    int frequency;

    Node(int key, int value){
        this.key = key;
        this.value = value;
        this.frequency = 1;
    }
}


public class LFUCache {

    int capacity;
    int minFreq; // to keep the track of current min freq
    Map<Integer, Node> cache; // to store the cache
    Map<Integer, List<Node>> freqCount;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        cache = new HashMap<>();
        freqCount = new HashMap<>();
    }
    
    public int get(int key) {
        if(capacity == 0 || !cache.containsKey(key)) return -1;
        
            Node node = cache.get(key);
            updateFrequency(key, node);
            return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;


        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            updateFrequency(key, node);
        }else{
            if(capacity == cache.size()) evict();

            Node node = new Node(key, value);
            cache.put(key, node);
            freqCount.computeIfAbsent(1, k -> new LinkedList<>()).add(node);
            minFreq = 1;
        }
    }

    public void updateFrequency(int key, Node node){
        int freq = node.frequency;
        List<Node> nodes = freqCount.get(freq);
        nodes.remove(node);

        if(nodes.isEmpty() && freq == minFreq)
            minFreq +=1;

        node.frequency +=1;
        freqCount.computeIfAbsent(node.frequency, k -> new LinkedList<>()).add(node);
        

        
    }

    public void evict(){
        List<Node> nodes = freqCount.get(minFreq);
        Node node = nodes.iterator().next();
        cache.remove(node.key);
        nodes.remove(node);
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */