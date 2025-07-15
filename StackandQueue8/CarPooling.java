// https://leetcode.com/problems/car-pooling/description/

class Node{
    int index;
    int passengerCount;
    int pos;
    boolean isInsert;

    Node(int index, int passengerCount, int pos, boolean isInsert) {
        this.index = index;
        this.passengerCount = passengerCount;
        this.pos = pos;
        this.isInsert = isInsert;
    }
}


public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> {
            if (a.pos != b.pos) return a.pos - b.pos;
            if (a.isInsert != b.isInsert) return Boolean.compare(a.isInsert, b.isInsert); // false < true
            return a.index - b.index;
        });
        int i = 0;
        for(int[] trip : trips){
            queue.add(new Node(i, trip[0], trip[1], true));
            queue.add(new Node(i, trip[0], trip[2], false));
            i++;
        }

        while(!queue.isEmpty()) {
            Node current = queue.poll();

            if(current.isInsert){ 
                if(capacity-current.passengerCount < 0)
                    return false;
                capacity-=current.passengerCount;
            }else{
                capacity+=current.passengerCount;
            }

        }

        return true;
    }


    // sweep line algorithm:

    public boolean carPooling(int[][] trips, int capacity) {
        int[] change = new int[1001];
        for(int[] trip: trips) {
            int passengers = trip[0], from = trip[1], to = trip[2];
            change[from] += passengers;
            change[to] -= passengers;
        }

        int currentCapacity = 0;
        for(int i=0; i<1001; i++) {
            currentCapacity += change[i];

            if(currentCapacity > capacity) return false;
        }

        return true;
    }
}