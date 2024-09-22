import java.util.*;

class Node{
    int price;
    int index;

    Node(int price, int index){
        this.price = price;
        this.index = index;
    }
}

public class StockSpanner{

    Stack<Node> stack = new Stack<>();

    public StockSpanner() {}
    
    public int next(int price) {
        int index = 1;
        while(!stack.isEmpty() && stack.peek().price<=price){
            Node node = stack.pop();
            index += node.index;
        }
        stack.push(new Node(price, index));

        return index;
    }

    public static void main(String[] args){
        StockSpanner obj = new StockSpanner();
        int[] arr = {100, 80, 60, 70, 60, 75, 85};

        for(var i: arr)
            System.out.print(obj.next(i)+" ");
    }
}