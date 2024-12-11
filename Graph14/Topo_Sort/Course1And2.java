public class Course1And2{

	public boolean isPossible(int n,int P, int[][] prerequisites){

		/* create adjency list */
		List<List<Integer>> adjList = new ArrayList<>();
		for(int i = 0; i < n; i++) adjList.add(new ArrayList());


		int[] indegree = new int[n];

		for(int[] prerequisite: prerequisites){
			adjList.get(prerequisite[1]).add(prerequisite[0]);
			indegree[prerequisite[0]] += 1;
		}

		/* calculate indegree of all the element */ 
		
		// for(List<Integer> nodes: adjList){
		// 	for(int node: nodes){
		// 		indegree[node] += 1;
		// 	}
		// }

		/* get initial element with indegree */ 
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < n; i++){
			if(indegree[i] == 0){
				queue.add(i);
			}
		}

		/* remove all connection with neighbour nodex*/
		int count = 0;
		List<Integer> result = new ArrayList<>();

		while(!queue.isEmpty()){
			var current = queue.poll();
			count += current;

			for(int neighbour: adjList.get(current)){
				indegree[neighbour] -= 1;

				if(indegree[neighbour] == 0){
					queue.add(neighbour);
				}
			}
		} 

		return count == n;
    }


    // --------------------------------------------------------------------------------------------
    // Course schedule  1: https://leetcode.com/problems/course-schedule/

    //can be done using cycle detection
    // DFS

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0;i< numCourses; i++) adjList.add(new ArrayList<>());
        for(int[] node: prerequisites) adjList.get(node[0]).add(node[1]);
        
        int[] visited = new int[numCourses];
        int[] parent = new int[numCourses];
        
        for(int i=0;i<numCourses; i++){
            if(visited[i] == 0 && dfs(i, adjList, visited, parent)){
                return false;
            }
        }

       return true;
    }

    public boolean dfs(int i, List<List<Integer>> adjList, int[] visited, int[] pathVisited){
        visited[i] = 1;
    	pathVisited[i] = 1;

        for (int neighbour : adjList.get(i)) {
            if(visited[neighbour] == 0){
                if(dfs(neighbour, adjList, visited, pathVisited)) return true;
            }else if(pathVisited[neighbour] == 1){
                return true;
            }
        }
        
        pathVisited[i] = 0;
        return false;

    }

    // --------------------------------------------------------------------
    // toposort

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        // Create adjancy list

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adjList.add(new ArrayList());
    
        int[] indegree = new int[numCourses];

        for(int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]] += 1;
		}
	
        /* get initial element with indegree */ 
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        /* remove all connection with neighbour nodex*/
        int count = 0;
        while(!queue.isEmpty()){
            int current = queue.poll();
            count += 1;

            for(int neighbour: adjList.get(current)){
                indegree[neighbour] -= 1;

                if(indegree[neighbour] == 0){
                    queue.add(neighbour);
                }
            }
        }

        return count == numCourses;
    }
    

    // --------------------------------------------------------------------------------------------
    // Course schedule 2 : https://leetcode.com/problems/course-schedule-ii/
    // DFS

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adjList = new ArrayList<>();
		for(int i = 0; i < numCourses; i++) adjList.add(new ArrayList());

        for (int[] edge : prerequisites) {
            adjList.get(edge[0]).add(edge[1]);
        }

        int[] visited = new int[numCourses];
        int[] pathVisited = new int[numCourses];
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            if(visited[i] == 0 &&  dfs(i, adjList, visited, pathVisited, result)){
                return new int[0];
            }
        }

        
        return result.stream().mapToInt(i -> i).toArray();
    }


    public boolean dfs(int current, List<List<Integer>> adjList, int[] visited, int[] pathVisited, List<Integer> result){
        visited[current] = 1;
        pathVisited[current] = 1;

        for(var neighbour: adjList.get(current)){
            if(visited[neighbour] == 0){
                if(dfs(neighbour, adjList, visited,pathVisited,  result)){
                    return true;
                }
            }else if(pathVisited[neighbour] == 1){
                return true;
            }
        }
        
        result.add(current);
        pathVisited[current] = 0;
        return false;
    }

    // -----------------------------------------------------------------------------------
    // toposort

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        /* create adjency list */
		List<List<Integer>> adjList = new ArrayList<>();
		for(int i = 0; i < numCourses; i++) adjList.add(new ArrayList());


		int[] indegree = new int[numCourses];

		for(int[] prerequisite: prerequisites){
			adjList.get(prerequisite[1]).add(prerequisite[0]);
			indegree[prerequisite[0]] += 1;
		}

		/* get initial element with indegree */ 
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < numCourses; i++){
			if(indegree[i] == 0){
				queue.add(i);
			}
		}

		/* remove all connection with neighbour nodex*/
		int[] result = new int[numCourses];
        int i = 0;

		while(!queue.isEmpty()){
			var current = queue.poll();
			result[i++] = current;

			for(int neighbour: adjList.get(current)){
				indegree[neighbour] -= 1;

				if(indegree[neighbour] == 0){
					queue.add(neighbour);
				}
			}
		}

        return (i == numCourses) ? result: new int[0];
        
    }


}