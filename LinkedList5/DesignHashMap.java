    // https://leetcode.com/problems/design-hashmap/?

class Node{
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class DesignHashMap {

    int size;
    Node[] bucket;

    public MyHashMap() {
        size = 1000000;
        bucket = new Node[size];
    }
    
    public void put(int key, int val) {
        int index = bucketIndex(key);
        Node current = bucket[index];

        if(current == null){
            bucket[index] = new Node(key, val);
            return;
        }

        while(current != null) {
            if(current.key == key) {
                current.val = val;
                return;
            }

            if(current.next == null) {
                current.next = new Node(key, val);
                current.next.prev = current;
                return;
            }
            current = current.next;
        }
    }
    
    public int get(int key) {
        int index = bucketIndex(key);
        Node current = bucket[index];

        if(current == null){
            return -1;
        }

        while(current != null) {
            if(current.key == key) return current.val;
            current = current.next;
        }

        return -1;
    }
    
    public void remove(int key) {
        int index = bucketIndex(key);
        Node current = bucket[index];

        if(current == null){
            return;
        }

        if(current.key == key) { 
            bucket[index] = current.next;
            if(bucket[index] != null) {
                bucket[index].prev = null;
            }
            return;
        }

        while(current != null) {
            if(current.key == key) { 
                if(current.prev != null) current.prev.next = current.next;
                if(current.next != null) current.next.prev = current.prev;
                return;
            }
            current = current.next;
        }
    }

    public int bucketIndex(int key) {
        return key % size;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */