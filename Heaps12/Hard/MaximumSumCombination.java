// https://www.interviewbit.com/problems/maximum-sum-combinations/

import java.util.*;

class Node {
    int a;
    int b;
    int data;

    Node(int a, int b, int data) {
        this.data =  data;
        this.a = a;
        this.b = b;
    }
}

public class MaximumSumCombination{
	public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        PriorityQueue<Integer> queue =new PriorityQueue<>((a, b) -> a-b);
        for(int i: A){
            for(int j: B){
                queue.add(i+j);
                if(queue.size() > C) queue.poll();
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            result.addFirst(queue.poll());
        }
        
        
        return result;
    }

    public static ArrayList<Integer> solve1(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        Collections.sort(A, Comparator.reverseOrder());
        Collections.sort(B, Comparator.reverseOrder());

        ArrayList<Integer> result = new ArrayList<>(); 
        Set<String> visited = new HashSet<>();
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> b.data - a.data);

        queue.add(new Node(0, 0, A.get(0) + B.get(0)));
        visited.add("0#0");

        int n = A.size();
        int m = B.size();

        while(result.size() < C && !queue.isEmpty()) {
            Node current = queue.poll();
            result.add(current.data);

            int i = current.a;
            int j = current.b;

            if(i+1 < n && visited.add((i+1) + "#"+j)){
                queue.add(new Node(i+1, j, A.get(i+1) + B.get(j)));
            }

            if (j + 1 < m && visited.add(i + "#" + (j + 1))) {
                queue.add(new Node(i, j + 1, A.get(i) + B.get(j + 1)));
            }
        }        

        return result;
        
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(2);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(4);
        System.out.println(solve(a, b, 2));
        System.out.println(solve1(a, b, 2));
    }

}