package eg.edu.alexu.csd.datastructure.queue.cs31;

public class Node {
	private Object element;
	private Node next;
	public Node(){
		this(null,null);
	}
	public Node(Object object, Node n) {
		// TODO Auto-generated constructor stub
		element=object;
		next=n;
	}
	public Object getElement(){
		return element;
	}
	public Node getNext(){
		return next;
	}
	public void setElement(Object newElement){
		element=newElement;
	}
	public void setNext(Node newNext){
		next=newNext;
	}
}

