import java.util.*;

class Node{
    int pos;
    int speed;

    Node(int pos, int speed){
        this.pos=pos;
        this.speed = speed;
    }
}

public class CarFleet{
	public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        List<Node> list = new ArrayList<>();

        for(int i=0; i<n; i++) list.add(new Node(position[i], speed[i]));

        list.sort((n1, n2) -> n2.pos - n1.pos); // sort by position
        
        Stack<Double> stack = new Stack<>();

        for(Node node: list){
            double time = (double) (target-node.pos)/node.speed;
            if(!stack.isEmpty() && stack.peek()>=time) continue;

            stack.push(time);   
        }

        return stack.size();
    }

    public static void main(String[] args) {
        
    }
}