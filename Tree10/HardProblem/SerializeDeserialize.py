class SerializeDeserialize:

# ------------------------------------------ BFS --------------------------------------


	def serialize(self, root):
        queue = deque([root])
        result = ""
        

        while queue:
            size = len(queue)

            for _ in range(size):
                current = queue.popleft()

                if current:
                    result += str(current.val) + ","
                    queue.append(current.left)
                    queue.append(current.right)
                else:
                    result += "null,"
        return result
            

    def deserialize(self, data):
        if not data: return None
       
        nodesArr = data.split(",")

        if nodesArr[0] == 'null': return None
        
        current = root = TreeNode(nodesArr.pop(0))
        queue = deque([current])

        while queue: 
            size = len(queue)

            for _ in range(size):
                currentNode = queue.popleft()

                if nodesArr:
                    currentval = nodesArr.pop(0)
                    if currentval != 'null':
                        currentNode.left = TreeNode(int(currentval))
                        queue.append(currentNode.left)
                
                if nodesArr:
                    currentval = nodesArr.pop(0)
                    if currentval != 'null':
                        currentNode.right = TreeNode(int(currentval))
                        queue.append(currentNode.right)
        
        return root



# ------------------------------------------ DFS --------------------------------------


def serialize(self, root):
        result = []

        def dfs(root):
            if not root: 
                result.append(str('null'))
                return

            result.append(str(root.val))
            dfs(root.left)
            dfs(root.right)
        
        dfs(root)
        return ','.join(result)


            

    def deserialize(self, data):
        if not data: return None
       
        nodesArr = data.split(",")
        if nodesArr[0] == 'null': return 

        self.i = 0

        def dfs():
            if nodesArr[self.i] == 'null':
                self.i+=1;
                return None
            
            root = TreeNode(int(nodesArr[self.i]))
            self.i += 1
            root.left = dfs()
            root.right = dfs()
        
            return root
        
        return dfs()
