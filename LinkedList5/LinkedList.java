class Node{
	int val;
	Node next;

	Node(int val){
		this.val = val;
		next = null;
	}
}


public class LinkedList{
	Node head = null;
	Node last = null;
	int size = 0;

	public Node insertFirst(int value){
		Node newNode = getNewNode(value);

		if(isEmpty()) last = newNode;
		else newNode.next = head;
		
		head = newNode;
		
		size += 1;

		return head;
	}

	public Node insert(int value){
		if(isEmpty()) this.insertFirst(value);

		Node newNode = getNewNode(value);
		last.next = newNode;
		last = newNode;

		size +=1;

		return head;
	}

	public void delete(int val){
		if(isEmpty()) return;

		if(length() == 1 && head.val == val) {
			head = null;
			last = null;
		}
		Node current = head;
		Node prev = null;

		while(current != null && current.val != val){
			prev = current;
			current = current.next;
		}

		if(current.val == val){
			prev.next = current.next;
			if(current.next == null){ // if last element 
				last = prev;
			}
			size-=1;
		}

		return;
	}

	public void deleteLast(){
		if(isEmpty()) return;

		if(length() == 1) {
			head = null;
			last = null;
		}

		Node current = head;
		Node prev = null;

		while(current.next != null){
			prev = current;
			current = current.next;
		}

		prev.next = null;
		last = prev;
		size-=1;
		return;
	}

	public boolean search(int val){
		if(isEmpty()) return false;

		Node node = head;
		while(node != null && node.val != val){
			node = node.next;
		}

		return (node != null && node.val == val);
	}

	public void display(){
		Node temp = head;

		if(isEmpty()) return;

		while(temp != null){
			System.out.print(temp.val+", ");
			temp = temp.next;
		}
		System.out.println();
	}

	public int length(){
		return size;
	}

	public boolean isEmpty(){
		return head == null;
	}

	private Node getNewNode(int value){
		return new Node(value);
	}


	public Node reverse(){
		if(this.isEmpty()) return head;

		return reverseWithTwoPointer();
		// return this.reverseWithRecurssion(head, null);
	}

	private Node reverseWithTwoPointer(){
		Node current = head;
		Node newHead = head;

		while(current != null && current.next !=null){
			Node nextNode = current.next;
			current.next = nextNode.next;
			nextNode.next = newHead;

			newHead = nextNode;
		}

		head = newHead;
		return head;
	}

	

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertFirst(5);
		ll.insertFirst(4);
		ll.insertFirst(3);
		ll.insertFirst(2);
		ll.insertFirst(1);
		ll.insert(0);
		ll.insert(6);
		ll.insert(7);
		ll.display();
		System.out.println(ll.length());
		ll.deleteLast();
		ll.display();
		System.out.println("\n"+ll.length());
		ll.delete(6);
		ll.delete(4);
		ll.display();
		System.out.println(ll.length());
		System.out.println(ll.search(2));
		System.out.println(ll.search(8));
		ll.insertFirst(9);
		ll.insert(10);
		ll.display();
		ll.reverse();
		ll.display();
	}
}