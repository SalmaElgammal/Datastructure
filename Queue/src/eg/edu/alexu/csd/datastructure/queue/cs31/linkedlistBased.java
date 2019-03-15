package eg.edu.alexu.csd.datastructure.queue.cs31;

import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

public class linkedlistBased implements ILinkedBased, IQueue {
	Node node=new Node();
	linkedlist list=new linkedlist();
	
	@Override
	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		Node node=new Node();
		node.setElement(item);
		node.setNext(null);
		if(list.size==0){
			list.head=node;
			list.tail=list.head;
		}else{
			list.tail.setNext(node);
			list.tail=node;
		}
		list.size++;
	}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		if(list.size==0){
			throw new RuntimeException();
		}
		Object ret=list.head.getElement();
		list.head=list.head.getNext();
		list.size--;
		if(list.size==0){
			list.tail=null;
		}
		return ret;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (list.tail==null);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size;
	}

}

