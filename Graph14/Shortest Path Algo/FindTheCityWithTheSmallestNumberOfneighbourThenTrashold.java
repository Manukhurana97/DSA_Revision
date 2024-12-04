publoc class FindTheCityWithTheSmallestNumberOfneighbourThenTrashold{

    // can be done by dijastra also, perform digstra on all the nodes
    int findCity(int n, int m, int[][] edges,int distanceThreshold)
      {
        //   created an distance array
            int[][] dist = new int[n][n];
            for(int i = 0; i< n; i++){
                for(int j=0; j< n; j++){
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            
            // convert undirected graph to directed
            for(int i=0; i<m; i++){
                int u = edges[i][0];
                int v = edges[i][1];
                int wt = edges[i][2];
                dist[u][v] = wt;
                dist[v][u] = wt;
            }
            
            for(int i = 0; i< n; i++) dist[i][i] = 0;
            
            // floyd warshall
            for(int k=0; k<n; k++){
                for(int i=0; i< n; i++){
                    for(int j = 0; j<n; j++){
                        if(dist[i][k] != Integer.MAX_VALUE & dist[k][j] != Integer.MAX_VALUE)
                        dist[i][j] = Math.min(dit[i][j], (dist[i][k] + dist[k][j]));
                    }
                }
            }
            
            // count the city count less then or equals to trashold and return the largest / last possible city
            int city  = -1;
            int minCount = n;
            for(int i=0; i< n; i++){
                int count = 0;
                for(int j = 0; j<n; j++){
                    if(dist[i][j] <= distanceThreshold){
                        count += 1;
                    }
                }
                if(minCount >= count){
                    minCount = count;
                    city = i;
                }
            }
            
            
            return city;
      }
}