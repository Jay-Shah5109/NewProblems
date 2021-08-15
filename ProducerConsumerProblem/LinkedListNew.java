package ProducerConsumerProblem;

// defining the class Node
class Node{
	int data;
	Node next;
	public Node(int data){
		this.data=data;
		next=null;
	}
}

public class LinkedListNew {
	
	Node head=null;
	
	// insert function
	public void insert_At_end(int data){
		Node newnode=new Node(data);
		Node temp=head;
		if(head==null){
			newnode.data=data;
			newnode.next=null;
			head=newnode;
		}
		else{
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next=newnode;
			newnode.data=data;
			newnode.next=null;
		}
	}
	
	// print the linked list
	public static void printLinked(Node head){
		Node temp=head;
		while(temp!=null){
			System.out.print(temp.data+"->");
			 temp=temp.next;
		}
	}
	
	// find middle element
	public int find_middle(){
		
		Node slow=head;
		Node fast=head;
		
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		
		return slow.data;
	}
	
	
	// concatenate 2 linked lists
	
	public static Node concatenate_linked(Node head1, Node head2){
		
		Node temp=head1;
		System.out.println("Head1: "+temp.data);
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=head2;
		return head1;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedListNew ll=new LinkedListNew();
		
		LinkedListNew ll2=new LinkedListNew();
		
		ll.insert_At_end(10);
		ll.insert_At_end(12);
		ll.insert_At_end(14);ll.insert_At_end(18);
		ll.insert_At_end(15);ll.insert_At_end(11);
		ll.insert_At_end(123);
		
		ll2.insert_At_end(100);
		ll2.insert_At_end(103);
		ll2.insert_At_end(104);
		ll2.insert_At_end(130);
		ll2.insert_At_end(180);
		
		
		
		
		//ll.printLinked();
		
		System.out.println("Middle element: "+ll.find_middle());
		
		System.out.println("Printing the newlist");
		
		Node link1=new Node(15);
		link1.next=new Node(24);
		link1.next.next=new Node(44);
		
		
		Node link2=new Node(45);
		link2.next=new Node(89);
		link2.next.next=new Node(92);
		
		Node link3=concatenate_linked(link1, link2);
		
		printLinked(link3);
		

	}

}
