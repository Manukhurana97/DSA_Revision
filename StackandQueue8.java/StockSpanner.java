// https://leetcode.com/problems/online-stock-span/description/

import java.util.*;

class Node {
    int val;
    int index;

    Node(int val, int index){
        this.val = val;
        this.index = index;
    }
}
public class StockSpanner{

    int index;
    Stack<Node> stack;

    public StockSpanner() {
        index = 0;
        stack = new Stack<>();
    }
    
    public int next(int price) {

        while(!stack.isEmpty() && stack.peek().val <= price){
            stack.pop();
        }

        if(!stack.isEmpty()){
            int result = index - stack.peek().index;
            stack.add(new Node(price, index++));
            return result;
        }else{
            stack.add(new Node(price, index++));
            return index;
        }
    }

    public static void main(String[] args){
        StockSpanner obj = new StockSpanner();
        int[] arr = {100, 80, 60, 70, 60, 75, 85};

        for(var i: arr)
            System.out.print(obj.next(i)+" ");
    }
}