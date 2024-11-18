# https://www.geeksforgeeks.org/problems/print-adjacency-list-1587115620/1

class GraphRepresentation:
	def printGraph(self, V : int, edges : List[List[int]]) -> List[List[int]]:
        # code here
        linkMap = [[] for _ in range(V)]
        
        for edge in edges:
            linkMap[edge[0]].append(edge[1])
            linkMap[edge[1]].append(edge[0])
            
        
        return linkMap