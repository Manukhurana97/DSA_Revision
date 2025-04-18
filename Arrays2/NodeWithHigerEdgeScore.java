// https://leetcode.com/problems/node-with-highest-edge-score/

public class NodeWithHigerEdgeScore{
	public int edgeScore(int[] edges) {
        int n = edges.length, minIndex = 0;
        long maxScore = 0;
        long[] inbound = new long[n];

        for(int i=0; i<n; i++){
            inbound[edges[i]] += i;            
        }

        for(int i=0; i<n; i++){
            if(maxScore < inbound[i]){
                maxScore = inbound[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}