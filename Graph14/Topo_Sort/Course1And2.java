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