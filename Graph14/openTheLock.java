// https://leetcode.com/problems/open-the-lock/
// for any source and destination, we use bfs
class Node{
    char[] charArr;
    int step;

    Node(char[] charArr, int step){
        this.charArr = charArr;
        this.step = step;
    }

}
public class openTheLock {
    public int openLock(String[] deadends, String target) {
        Set<String> deadEndSet = new HashSet<>();
        for(String s: deadends) deadEndSet.add(s);

        // Early termination if the starting point or target is invalid
        if(deadEndSet.contains("0000") || deadEndSet.contains(target)) return -1;
        if("0000".contains(target)) return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node("0000".toCharArray(), 0));

        Set<String> visited = new HashSet<>();
        visited.add("0000");

        while(!queue.isEmpty()){
            Node node = queue.poll();
            char[] currentNodeCharArr = node.charArr;
            int steps = node.step;

            for(int index=0; index<4; index++){
                // increment
                char[] currentIncCharArr = currentNodeCharArr.clone();
                currentIncCharArr[index] = (char)(((currentNodeCharArr[index] - '0' + 1) % 10) + '0');
                String incString = new String(currentIncCharArr);
                
                if(incString.equals(target)) return steps + 1;
                if(!deadEndSet.contains(incString) && !visited.contains(incString)) {
                    visited.add(incString);
                    queue.add(new Node(currentIncCharArr, steps+1));
                }

                // decrement
                char[] currentDecCharArr = currentNodeCharArr.clone();
                currentDecCharArr[index] = (char) (((currentNodeCharArr[index] - '0' + 9) % 10) + '0'); // Add 9 to avoid negative mod

                String decString = new String(currentDecCharArr);
                
                if(decString.equals(target)) return steps + 1;
                if(!deadEndSet.contains(decString) && !visited.contains(decString)) {
                    visited.add(decString);
                    queue.add(new Node(currentDecCharArr, steps+1));
                }
            }
        }

        return -1;
    }
}
