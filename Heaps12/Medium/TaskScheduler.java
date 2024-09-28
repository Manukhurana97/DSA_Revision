class Node{
    int time;
    int val;

    Node(int val, int time){
        this.val = val;
        this.time = time;
    }
}

public class TaskScheduler{

	// failing for one use case
	public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> countMap = new HashMap<>();
        for(Character task: tasks) countMap.put(task, countMap.getOrDefault(task, 0)+1);

        int index = 0;
        Map<Character, Integer> lastPlacementMap = new HashMap<>();
        
        while(!countMap.isEmpty()){
            List<Character> taskToRemove = new ArrayList<>();
            
            for(Map.Entry<Character, Integer> k_v: countMap.entrySet()){
                if(lastPlacementMap.containsKey(k_v.getKey()))
                    if (index - lastPlacementMap.get(k_v.getKey()) <= n)
                        index += Math.abs(index - lastPlacementMap.get(k_v.getKey())-n-1);
                
                lastPlacementMap.put(k_v.getKey(), index++);
                if(k_v.getValue() == 1) taskToRemove.add(k_v.getKey());
                else countMap.put(k_v.getKey(), k_v.getValue()-1);
            }

            for(var ch: taskToRemove) countMap.remove(ch);
        }

        return index;
    }

    // ----------------------------------------------------------------------------------------



    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char task : tasks) countMap.put(task, countMap.getOrDefault(task, 0) + 1);

        PriorityQueue<Integer> task = new PriorityQueue(Comparator.reverseOrder());
        for(int value:  countMap.values()) task.add(value);

        Deque<Node> coolDownPeriod = new LinkedList<>();
        int index = 0;

        while(!task.isEmpty() || !coolDownPeriod.isEmpty()) {
            index += 1;

            if(!task.isEmpty()){
                int remainingCount = task.poll() - 1;
                if (remainingCount > 0) coolDownPeriod.add(new Node(remainingCount, index + n));
            }

            if(!coolDownPeriod.isEmpty() && coolDownPeriod.peekFirst().time <= index)
                task.add(coolDownPeriod.pollFirst().val);
        }

        return index;
    }

}