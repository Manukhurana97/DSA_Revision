# count the size and check element using set
# reverse a linked list till center and check 

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class CheckIfTheGivenLLisPalindrome:

	# Time: O(2N), Space: O(N)
	def isPalindrome(self, head) -> bool:
		lst = []
		current = head;

		while current :
			lst.append(current.val)
			current = current.next

		n = len(lst)
		for i in range(0, n // 2):
			if lst[i] != lst[n-i-1]:
				return False
		return True

	# Time: O(N), Space: O(1)
	def isPalindrome1(self, head) -> bool:

		if not head or not head.next: return True

		fast = head.next
		slow = head

		while fast and fast.next:
			fast = fast.next.next
			slow = slow.next


		prev = None
		current = slow
		while current:
			nextNode = current.next
			current.next = prev
			prev = current
			current = nextNode



		while head and prev:
			if head.val != prev.val:
				return False
			head = head.next
			prev = prev.next
		return True



obj = CheckIfTheGivenLLisPalindrome()
node = ListNode(1)
node.next= ListNode(2)
node.next.next = ListNode(2)
node.next.next.next = ListNode(1)
print(obj.isPalindrome(node))
print(obj.isPalindrome1(node))		