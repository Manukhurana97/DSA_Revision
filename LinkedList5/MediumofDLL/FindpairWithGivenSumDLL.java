public class FindpairWithGivenSumDLL{

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        
        Node current = head;
        
        while(current != null){
             if(visited.contains(target - current.data)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(target - current.data);
                list.add(current.data);
                result.add(list);
            }
            visited.add(current.data);
            current = current.next;
        }
        
        Collections.sort(result, (l1, l2) -> l1.get(0) == l2.get(0) ?  l1.get(1) - l2.get(1):  l1.get(0) - l2.get(0));

        
        return result;
    }
}