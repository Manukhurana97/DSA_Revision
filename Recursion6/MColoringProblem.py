# https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1

def graphColoring(self, v, edges, m):
        color = [0] * v
        
        def recursion(i: int):
            
            if(i == v): 
                return True
            
            for col in range(1, m+1):
                if canColor(i, col):
                    color[i] = col
                    if recursion(i+1):
                        return True
                    color[i] = 0
            
            return False
            
        def canColor(node, col):
            
            for u, v in edges:
                if (node == u and color[v] == col) or (node == v and color[u] == col):
                    return False
            
            return True
            
        
        return recursion(0)