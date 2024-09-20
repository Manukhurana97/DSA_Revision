import java.lang.NullPointerException;


class Node{
	int val;
	Node prev;
	Node next;


	Node(int val){
		this.val = val;
		this.prev = prev;
		this.next = next;
	}
}

public class DoubleLinkedList{

	Node head = null;
	Node last = null;
	int size = 0;

	// insert at last
	public void insert(int val){
		Node newNode = getNewNode(val);
		size+=1;

		if(this.insertionInEmptyList(newNode)) return;

		this.insertionAtLast(newNode);
	}

	// insert at position
	public void insert(int index, int val){
		Node newNode = getNewNode(val);
		
		if(insertionInEmptyList(newNode)){
			return;
		}
		if(index == size){
			this.insertionAtLast(newNode);
		}
		size+=1; 
		

		Node current = head;
		Node prev = null;
		while(current !=null && --index>0){
			prev = current;
			current  = current.next;
		}

		if(prev == null)  {
			this.insertFirst(val);
			return;
		}
		if(index > 0 || current == null){
			this.insertionAtLast(newNode);
			return;
		}
		
		newNode.next = current;
		newNode.prev = prev;

		current.prev = newNode;
		prev.next = newNode;
		return;

	}

	// insert at top
	public void insertFirst(int val){
		Node newNode = getNewNode(val);
		size+=1;

		if(insertionInEmptyList(newNode)){
			return;
		}

		newNode.next = head;
		head.prev = newNode;
		head = newNode;
		return;
	}

	// insert in last 
	public void insertLast(int val){
		Node newNode = getNewNode(val);
		size+=1;

		if(this.insertionInEmptyList(newNode)){
			return;
		}

		this.insertionAtLast(newNode);
		return;
	}

	// INTERNAL: insert in empty list
	private boolean insertionInEmptyList(Node newNode){
		if(isEmpty()) {
			head = newNode;
			last = newNode;
			return true;
		}
		return false;
	}

	// INTERNAL: insert at Last
	private void insertionAtLast(Node newNode){
		last.next = newNode;
		newNode.prev = last;
		last = newNode;
	}


	public int delete(int val) {
		if(isDeletingInEmptyList()) return -1;
		if(isHeadValueDeleting(val)) return val;
		if(isLastValueDeleting(val)) return val;

		Node prev = null;
		Node current = head;

		while(current != null && current.val != val){
			prev = current;
			current = current.next;
		}

		if(current == null) return -1;
		
		if(prev == null){
			head = head.next;
			head.prev = null;
			return val;
		}

		prev.next = current.next;
		if(current.next != null) current.next.prev = prev;
		return val;
	}


	// deleting at last
	public int deleteLast() {
		if(isDeletingInEmptyList()) return -1;
		int val = last.val;
		deletingLastValue();

		return val;
	}

	// check if list is empty
	public boolean isDeletingInEmptyList(){
		return isEmpty();
	}

	// checking and deleting if the value is at head
	private boolean isHeadValueDeleting(int value){
		if(head.val == value){
			this.deletingHeadValue();
			return true;
		}
		return false;
	}

	// INTERNAL: checking and deleting if the value is at last;
	private boolean isLastValueDeleting(int value){
		if(last.val == value){
			this.deletingLastValue();
			return true;
		}
		return false;
	}

	// INTERNAL: deleting at head
	private void deletingHeadValue(){
		if(head.next == null)
			head = last = null;
		else
			head = head.next;
			head.prev = null;
	}

	// INTERNAL: deleting at last
	private void deletingLastValue(){
		if(last.prev == null)
			head = last = null;
		else{
			last = last.prev;
			last.next = null;
		}
	}

	// INTERNAL:
	private Node getNewNode(int val){
		return new Node(val);
	}

	//  is list is Empty
	public boolean isEmpty(){
		return head == null;
	}

	// display the entire list
	public void display(){
		if(isEmpty()) return;

		Node tempHead = head;
		while(tempHead != null){
			System.out.print(tempHead.val+", ");
			tempHead = tempHead.next;
		}
		System.out.println();
	}

	// display length of list
	public int size(){
		return size;
	}


	// moving each node in head position one by one
	// public Node reverse(){
		
	// 	Node current = head;
	// 	Node newHead = head;

	// 	while(current !=null && current.next !=null){
	// 		// connection from prev to next eg: 1 2 3 4, 2-> 4
	// 		Node nextHead = current.next;
	// 		current.next = nextHead.next;

	// 		// putting 3 behind 1: 3,1,2,4
	// 		newHead.prev = nextHead;
	// 		nextHead.next = newHead;
	// 		newHead.prev = null;

	// 		newHead = nextHead;
	// 	}

	// 	head = newHead;
	// 	last = current;
	// 	return head; 

	// }

	// changing the pointer position
	public Node reverse(){

		Node current = head;
		last = head;


		while(current!=null){
			Node temp = current.next;
			current.next = current.prev;
			current.prev = temp;

			if(current !=null){
				head = current;
			}

			current = current.prev;
		}

		return head;

	}



	// 2 1 : 3 4 - 3 2 1 : 4

	public static void main(String[] args) {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.insert(1);
		dll.insert(2);
		dll.insert(4);
		dll.insert(5);
		dll.display();
		System.out.println("length "+dll.size());
		dll.insert(3, 3);
		dll.insert(9, 6);
		dll.insert(0, 0);
		dll.insertFirst(-1);
		dll.insertLast(7);
		dll.display();
		System.out.println("length "+dll.size());
		dll.delete(4);
		dll.deleteLast();
		dll.display();
		System.out.println("length "+dll.size());
		System.out.println();
		dll.reverse();
		dll.display();

	}
}