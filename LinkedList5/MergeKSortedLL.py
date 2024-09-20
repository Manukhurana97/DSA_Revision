# Time O(n^2), Space: O(1)
def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        
    dummyNode = ListNode(None)
   
    for list in lists:
        if not dummyNode.next:
            dummyNode.next = list
        else:
            current = dummyNode.next
            prev = dummyNode
            
            while list:
                listNext = list.next
                while current and current.val<list.val:
                    prev = current
                    current = current.next
                
                list.next = current
                current = list
                prev.next = list

                list = listNext
                
        return dummyNode.next

# Time O(3n + nlogn), Space: O(n)
def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        

    arr = []
    dummyNode = ListNode(None)
    current = dummyNode
    
    # create a list from all list
    for list in lists:        
        while current.next:
            current = current.next
        current.next = list

    # append all nodes in array
    current = dummyNode.next
    while current:
        arr.append(current.val)
        current = current.next
        

    arr.sort() # sort the array

    # put the value back in list
    current = dummyNode.next
    for i in arr:
        if current:
            current.val = i
            current = current.next

    return dummyNode.next


# Time O(2n + nlogn), Space: O(n)
def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        
    arr = []
    dummyNode = ListNode(None)
    current = dummyNode
    
    for list in lists:        
        while current.next:
            if current.next:
                arr.append(current.next.val)
            current = current.next
        current.next = list


    while current:
        current = current.next
        if current:
            arr.append(current.val)
        

    arr.sort()

    current = dummyNode.next
    for i in arr:
        if current:
            current.val = i
            current = current.next

    return dummyNode.next


# Time : O(N), Space : O(1)
# take 2 list and sort and  merge -> n/2 -> n/2 ---- 1
def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:

        if not lists or len(lists)==0: return None
        
        while len(lists)>1:
            mergeLists = []
            
            for i in range(0, len(lists), 2):
                l1 = lists[i]
                l2 = lists[i + 1] if i+1 < len(lists) else None    
                mergeLists.append(self.mergeList(l1, l2))

            lists = mergeLists   
        return lists[0]

        # merge 
    def mergeList(self, l1, l2):

        dummyNode = ListNode(None)
        current = dummyNode
        while(l1 and l2):
            if l1.val < l2.val:
                current.next = l1
                l1 = l1.next
            else:
                current.next = l2
                l2 = l2.next
            current = current.next
        
        if l1:
            current.next = l1
        if l2:
            current.next = l2

        return dummyNode.next
