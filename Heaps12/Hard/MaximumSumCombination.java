// https://www.interviewbit.com/problems/maximum-sum-combinations/

public class Node{
	int sum;
	int a;
	int b;

	Node(int sum, int a, int b){
		this.sum = sum;
		this.a = a;
		this.b = b;
	}
}

public class MaximumSumCombination{
	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        PriorityQueue<Integer> queue =new PriorityQueue<>();
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


}