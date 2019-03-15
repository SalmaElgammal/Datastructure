package eg.edu.alexu.csd.datastructure.linkedList.cs31;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class Doubly implements ILinkedList {	
	class Node
	{
	    protected Object data;
	    protected Node next, prev;
	 
	    /* Constructor */
	    public Node()
	    {
	        next = null;
	        prev = null;
	        data = 0;
	    }
	    /* Constructor */
	    public Node(Object d, Node n, Node p)
	    {
	        data = d;
	        next = n;
	        prev = p;
	    }
	    /* Function to set link to next node */
	    public void setLinkNext(Node n)
	    {
	        next = n;
	    }
	    /* Function to set link to previous node */
	    public void setLinkPrev(Node p)
	    {
	        prev = p;
	    }    
	    /* Funtion to get link to next node */
	    public Node getLinkNext()
	    {
	        return next;
	    }
	    /* Function to get link to previous node */
	    public Node getLinkPrev()
	    {
	        return prev;
	    }
	    /* Function to set data to node */
	    public void setData(Object d)
	    {
	        data = d;
	    }
	    /* Function to get data from node */
	    public Object getData()
	    {
	        return data;
	    }
	}
	 protected Node start;
	    protected Node end ;
	    public int size;
	 
	    /* Constructor */
	    public Doubly()
	    {
	        start = null;
	        end = null;
	        size = 0;
	    }
	    /* Function to check if list is empty */
	    public boolean isEmpty()
	    {
	        return start == null;
	    }
	    /* Function to get size of list */
	    public int size()
	    {
	        return size;
	    }
	    /* Function to insert element at begining */
	    public void insertAtStart(Object val)
	    {
	        Node nptr = new Node(val, null, null);        
	        if(start == null)
	        {
	            start = nptr;
	            end = start;
	        }
	        else
	        {
	            start.setLinkPrev(nptr);
	            nptr.setLinkNext(start);
	            start = nptr;
	        }
	        size++;
	    }
	    /* Function to insert element at end */
	    public void add(Object val)
	    {
	        Node nptr = new Node(val, null, null);        
	        if(start == null)
	        {
	            start = nptr;
	            end = start;
	        }
	        else
	        {
	            nptr.setLinkPrev(end);
	            end.setLinkNext(nptr);
	            end = nptr;
	        }
	        size++;
	    }
	    /* Function to insert element at position */
	    public void add(int pos , Object val)
	    {
	        Node nptr = new Node(val, null, null);    
	        if (pos == 1)
	        {
	            insertAtStart(val);
	            return;
	        }            
	        Node ptr = start;
	        for (int i = 2; i <= size; i++)
	        {
	            if (i == pos)
	            {
	                Node tmp = ptr.getLinkNext();
	                ptr.setLinkNext(nptr);
	                nptr.setLinkPrev(ptr);
	                nptr.setLinkNext(tmp);
	                tmp.setLinkPrev(nptr);
	            }
	            ptr = ptr.getLinkNext();            
	        }
	        size++ ;
	    }
	    /* Function to delete node at position */
	    public void remove(int index)
	    {        
	        if (index == 1) 
	        {
	            if (size == 1)
	            {
	                start = null;
	                end = null;
	                size = 0;
	                return; 
	            }
	            start = start.getLinkNext();
	            start.setLinkPrev(null);
	            size--; 
	            return ;
	        }
	        if (index == size)
	        {
	            end = end.getLinkPrev();
	            end.setLinkNext(null);
	            size-- ;
	        }
	        Node ptr = start.getLinkNext();
	        for (int i = 2; i <= size; i++)
	        {
	            if (i == index)
	            {
	                Node p = ptr.getLinkPrev();
	                Node n = ptr.getLinkNext();
	 
	                p.setLinkNext(n);
	                n.setLinkPrev(p);
	                size-- ;
	                return;
	            }
	            ptr = ptr.getLinkNext();
	        }        
	    }    
	    /* Function to display status of list */
	    public void display()
	    {
	        System.out.print("\nDoubly Linked List = ");
	        if (size == 0) 
	        {
	            System.out.print("empty\n");
	            return;
	        }
	        if (start.getLinkNext() == null) 
	        {
	            System.out.println(start.getData() );
	            return;
	        }
	        Node ptr = start;
	        System.out.print(start.getData()+ " <-> ");
	        ptr = start.getLinkNext();
	        while (ptr.getLinkNext() != null)
	        {
	            System.out.print(ptr.getData()+ " <-> ");
	            ptr = ptr.getLinkNext();
	        }
	        System.out.print(ptr.getData()+ "\n");
	    }
	
	/** Returns the element at the specified position in this list. */
	public Object get(int index){
		Node q = start;
     	
     	for(int i= 0; i <= size ; i++){
     		if (i == index){
     			return q.data;
     		}
     		q = q.getLinkNext();
     	}
     	return null;
	}
	/**
	* Replaces the element at the specified position in this list with
	* the specified element.
	*/
	public void set(int index, Object element){
     	Node q = start;
     	for(int i= 0; i<size-1 ; i++){
     		if (i == index){
     			q.setData(element);
     		}
     		q = q.getLinkNext();
     	}
	}
	/** Removes all of the elements from this list. */
    public void clear(){
    	remove(1);
    	for(int i= 0; i<= size ; i++){
    		remove(1);
    		size --;
    	}
    }

    public Doubly sublist(int fromIndex, int toIndex){
     	Node q = start;
     	Doubly empty = new Doubly();
     	if(fromIndex >= size || toIndex < 0){
     		return empty;
     	}
     	
     	for(int i = 0; i< fromIndex; i++){
     		q= q.getLinkNext();
     	}
     	Doubly res = new Doubly();
     	res.add(q.data);
     	for(int i = fromIndex ; i< toIndex; i++){
     		if(i == size-1){
     			return null;
     		}
     		q= q.getLinkNext();
     		res.add(q.data);
     	}
     	return res;
     }
	public boolean contains(Object o){
     	Node q = start;
     	for(int i= 0; i<size ; i++){
     		if(q.data == o){
     			return true;
     		}
     		q = q.getLinkNext();
     	}
     	return false;
     }
	/**
	* Returns true if this list contains an element with the same value
	* as the specified element.
	*/
	
}


