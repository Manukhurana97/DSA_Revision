public class reconstructItinerary{
	public List<String> findItinerary(List<List<String>> tickets) {
        // using priority queue in order to sort in lexical graphical order <a,b, c...>
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(List<String> tiicket: tickets){
            map.computeIfAbsent(tiicket.get(0), k -> new PriorityQueue<>()).add(tiicket.get(1));
        }

        List<String> result = new ArrayList<>();        
        dfs("JFK", map, result); // JFK is the starting point (all the time)
        return result;
    }

    public void dfs(String currentPoint, Map<String, PriorityQueue<String>> map, List<String> result){
        while(map.containsKey(currentPoint) && !map.get(currentPoint).isEmpty()){
            String neighbour = map.get(currentPoint).poll();
            dfs(neighbour, map, result);
        }
        result.add(0, currentPoint);  
        
    }
}