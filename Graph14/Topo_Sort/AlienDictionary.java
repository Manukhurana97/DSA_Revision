/* 
    compare input, and find the different character with each string (from i to n)
    once's difference element is found, break the comparing loop, and create a graph from char[i]->char[i+1]
    also calculate in inbound notes
    perform topo sort : 
    1. calculate inbound of all the nodes
    2. get all the element with 0 inbound
    3. remove the element and connction with neighbours and store the new inbound with 0
    
*/


public class AlienDictionary{

    private static String findOrder(String[] dictionary, int N, int k) {

    	if(N == 1) return dictionary[0];

    	// create adjancy list
    	List<List<Integer>> adjList = new ArrayList<>();
    	for(int i = 0; i < k; i++){
    		adjList.add(new ArrayList<>());
    	}

    	int[] inbound = new int[k];

    	// create directed graph 
    	for(int i = 1; i < N; i++){
    		String s1 = dictionary[i - 1];
    		String s2 = dictionary[i];

    		int minElemLen = Math.min(s1.length(), s2.length());

    		for(int j = 0; j < minElemLen; j++){
    			if(s1.charAt(j) != s2.charAt(j)){
    				
    				adjList.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
    				inbound[s2.charAt(j) - 'a'] += 1;
    				
    				break;
    			}
    		}

    		// topo sort
    		Queue<Integer> queue = new LinkedList<>();
    		for(int i = 0;i < k; i++){
    			if(inbound[i] == 0){
    				queue.add(i);
    			}
    		}

    		StringBuilder builder = new StringBuilder();
    		while(!queue.isEmpty()){
    			int current = queue.poll();
    			builder.append((char)('a' + current));

    			for(var neighbour: adjList.get(current)){
    				inbound[neighbour] -= 1;

    				if(inbound[neighbour] == 0){
    					queue.add(neighbour);
    				}
    			}
    		}
    	}

    	if(builder.length() < k) return "";

    	return builder.toString();
    }
}