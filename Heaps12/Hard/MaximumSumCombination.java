// https://www.interviewbit.com/problems/maximum-sum-combinations/

import java.util.*;

public class MaximumSumCombination{
	public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        PriorityQueue<Integer> queue =new PriorityQueue<>((a, b) -> a-b);
        for(int i: A){
            for(int j: B){
                queue.add(i+j);
                if(queue.size() > C) queue.poll();
            }
        }
        
        LinkedList<Integer> result = new LinkedList<>();
        while(!queue.isEmpty()){
            result.addFirst(queue.poll());
        }
        
        
        return new ArrayList(result);
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(2);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(4);
        System.out.println(solve(a, b, 2));
    }

}