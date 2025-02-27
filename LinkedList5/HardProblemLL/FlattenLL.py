# https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1

# Approach 1: Collect, Sort, and Reconstruct
# Time: O(N + NlogN + N), Space: O(1) 
def flatten(root):
    arr = []
    
    columns = root
    while columns:
        row = columns
        
        while row:
            arr.append(row.data)
            row = row.bottom
        

        columns = columns.next
            
    arr.sort()
    
    dummyNode = Node(None)
    dummy = dummyNode
    
    for i in arr:
        dummy.bottom = Node(i)
        dummy = dummy.bottom
    
    
    return dummyNode.bottom


# Approach 2: In-Place Merge
# Time: O(N ), Space: O(1) 
def flatten(root):
    # Initialize a dummy node to act as the starting point
    dummyNode = Node(None)
    dummyNode.bottom = root
    
    # Start with the first column
    columns = root.next
    
    # Process each column one by one
    while columns:
        firstRowCurrent = root
        firstRowPrev = None
        nextColumn = columns.next
        columns.next = None
        
        # Merge current column into the first row
        while firstRowCurrent and columns:
            if firstRowCurrent.data > columns.data:
                bottom = columns.bottom 
                
                columns.bottom = firstRowCurrent
                firstRowPrev.bottom = columns
                
                firstRowPrev = columns
                columns = bottom
            else:
                firstRowPrev = firstRowCurrent
                firstRowCurrent = firstRowCurrent.bottom
        
        # If there are remaining nodes in the current column, append them
        if columns: 
            firstRowPrev.bottom = columns
        
        # Move to the next column
        columns = nextColumn
        
    return dummyNode.bottom


# -----------------------------------------------------------------------------------------------------------

 # Node flatten(Node root) {
       
 #        if(root == null || root.next == null) return root;
        
 #        root.next = flatten(root.next);
        
 #        root = merge(root, root.next);
    
 #        return root;
 #    }
    
 #    public Node merge(Node a, Node b){
 #        if(a == null) return b;
 #        if(b == null) return a;
        
 #        Node dummy = new Node(0);
 #        Node current = dummy;
        
 #        while(a != null && b != null){
 #            if(a.data < b.data){
 #                current.bottom = a;
 #                a = a.bottom;
 #            }else{
 #                current.bottom = b;
 #                b = b.bottom;
 #            }
 #            current = current.bottom;
 #        }
        
 #        if(a != null) current.bottom = a;
 #        if(b != null) current.bottom = b;
        
 #        return dummy.bottom;
 #    }
        