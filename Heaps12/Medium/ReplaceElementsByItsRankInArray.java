// https://www.geeksforgeeks.org/problems/replace-elements-by-its-rank-in-the-array/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=replace-elements-by-its-rank-in-the-array

class Node{
    int index;
    int value;
    
    Node(int index, int value){
        this.index = index;
        this.value = value;
    }
}

public class ReplaceElementsByItsRankInArray{
	static int[] replaceWithRank(int arr[], int N) {
     // code here
     
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing((Node node) -> node.value));
     
        for(int i=0;i<N;i++) 
            queue.add(new Node(i, arr[i]));
     
        int index = 1;
        int prev = -1;
        int[] result = new int[N];
        
        while(!queue.isEmpty()){
            Node current= queue.poll();
            if(prev != current.value){
                result[current.index] =  index++;
                prev = current.value;
            }else{
                result[current.index] =  index-1 ;
            }
        }
        
        return result;
  }
}