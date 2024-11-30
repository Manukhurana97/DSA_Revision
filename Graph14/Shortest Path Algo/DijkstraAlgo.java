class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}


// Time Cmplexity: O(ElognV) , E: edges, v: nodes
public class DijkstraAlgo{

	/*
		PriorityQueue: Reason of using priority queue : we will get the smortest algo first
		Set: we can also user set , advantage is if we have the distance smaller the exiting and also availabe in q, we can delete old (with greater distance)
		Queue: we can also use (but we dont prefer), but the problem is , if we get to a node from 2 direction and got weight in decending order. In that case we will process first with bigger distance and then with smaller distance, thats why.

	*/ 
	ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
		int n = adj.size();

		// O(logV)
		PriorityQueue<iPair> queue = new PriorityQueue<>((a, b) -> a.second == b.second ? a.first - b.first : a.second - b.second);
        queue.add(new iPair(src, 0));

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        // BFS // dijkstra

        while(!queue.isEmpty()){ // O(V)
        	iPair currentNode = queue.remove();

        	for(iPair neighbours: adj.get(currentNode.first)){
        		int weight = neighbours.second;
        		int nn = neighbours.first;

        		if(distance[nn] > weight + currentNode.second){
        			distance[nn] = weight + currentNode.second;
        			queue.add(new iPair(nn, distance[nn]));
        		}
        	}
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int dist: distance) result.add(dist);
        return result;
    }
}