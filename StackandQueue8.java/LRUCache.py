
class Node:
    def __init__(self, key=0, val=0, next = None, prev = None):
            self.key = key
            self.val = val
            self.next = next
            self.prev = prev

class LRUCache:

    def __init__(self, capacity: -1):
        self.head = None
        self.tail = None
        self.size = 0
        self.capacity = capacity
        self.map = {}
        
        
    # if element exist move the element in top
    def get(self, key: int) -> int:
        if self.size == 0 or key not in self.map: 
            return -1
        
        node = self.map[key]
        self.updateNodePositionToTop(node)
        return node.val


    # add the top
    # remove from last
    def put(self, key: int, value: int) -> None:
        if key in self.map:
            node = self.map[key]
            node.val = value
            self.updateNodePositionToTop(node);
            return
        else :
            self.evictFromLastIfRequired()
            newNode = Node(key, value)
            
            if self.size == 0:
                self.head = self.tail = newNode
            else:
                self.head.prev = newNode
                newNode.next = self.head
                self.head = newNode
            
            self.map[key] = newNode
            self.size += 1



    def updateNodePositionToTop(self, node):
        if not node: 
            return # if node is none, just return
        if self.size == 1 : 
            return
        if self.head == node: 
            return # if node is already head, just return

        # Remove node from its current position
        if node.prev:
            node.prev.next = node.next
        if node.next : 
            node.next.prev = node.prev
        if node == self.tail:
            self.tail = node.prev

        # move node to top
        node.next = self.head
        node.prev = None
        self.head.prev = node
        self.head = node
    

    def evictFromLastIfRequired(self):
        if self.size == 0 or self.size < self.capacity:  
            return          

        key = self.tail.key
        if self.size  <= 1:
            self.head = self.tail = None
        else:
            prev = self.tail.prev
            self.tail.prev = None
            self.tail = prev
            self.tail.next = None
            
        self.map.pop(key)
        self.size -= 1
        
        return