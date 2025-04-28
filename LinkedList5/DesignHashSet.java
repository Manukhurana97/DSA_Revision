// https://leetcode.com/problems/design-hashset/

class Node{
    int key;
    Node next;
    Node prev;

    Node(int key){
        this.key = key;
    }
}


public class DesignHashSet {

    private Node[] bucket;
    int size;

    public MyHashSet() {
        size = 1000001;
        bucket = new Node[size];
    }
    
    public void add(int key) {

        int index = hash(key);

        if(bucket[index] == null){
            bucket[index] = new Node(key);
            return;
        }

        Node current = bucket[index];
        while(current != null) {
            if(current.key == key) return;

            if(current.next == null){
                current.next = new Node(key);
                current.next.prev = current;
                return;
            }

            current = current.next;
        }
        
    }
    
    public void remove(int key) {
        int index = hash(key);
        Node current = bucket[index];
        
        if(current == null) return;

        if (current.key == key) {
            bucket[index] = current.next;
            if (bucket[index] != null) {
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
    
    public boolean contains(int key) {
        int index = hash(key);
        Node current = bucket[index];
        
        if(current == null) return false;

        while(current != null) {
            if(current.key == key) return true;
            current = current.next;
        }

        return false;
    }

    private int hash(int key) {
        return key % size;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */