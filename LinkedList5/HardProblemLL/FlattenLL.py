
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
        