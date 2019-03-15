package eg.edu.alexu.csd.datastructure.linkedList.cs31;
import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class Singly implements ILinkedList {

	public class Node
    {
        protected Object data;
        protected Node link;
     
        /*  Constructor  */
        public Node()
        {
            link = null;
            data = 0;
        }    
        /*  Constructor  */
        public Node(Object d,Node n)
        {
            data = d;
            link = n;
        }    
        /*  Function to set link to next Node  */
        public void setLink(Node n)
        {
            link = n;
        }    
        /*  Function to set data to current Node  */
        public void setData(Object d)
        {
            data = d;
        }    
        /*  Function to get link to next node  */
        public Node getLink()
        {
            return link;
        }    
        /*  Function to get data from current Node  */
        public Object getData()
        {
            return data;
        }
       
    }
     

	/** Inserts the specified element at the end of the list. */
	 protected Node start;
     protected Node end ;
     public int size ;
  
     /*  Constructor  */
     public Singly()
     {
         start = null;
         end = null;
         size = 0;
     }
     /*  Function to check if list is empty  */
     public boolean isEmpty()
     {
         return start == null;
     }
     /*  Function to get size of list  */
     public int size()
     {
         return size;
     }    

     /*  Function to insert an element at end  */
     public void add(Object element)
     {
         Node nptr = new Node(element,null);    
         size++ ;    
         if(start == null) 
         {
        	 
             start = nptr;
             end=nptr;

         }
         else 
         {
             end.setLink(nptr);
             end = nptr;
         }
     }
     /*  Function to insert an element at position  (one indexed)*/
     public void add(int pos,Object val)
     {
         Node nptr = new Node(val, null);                
         Node ptr = start;
         pos = pos - 1 ;
         for (int i = 1; i < size; i++) 
         {
             if (i == pos) 
             {
                 Node tmp = ptr.getLink() ;
                 ptr.setLink(nptr);
                 nptr.setLink(tmp);
                 break;
             }
             ptr = ptr.getLink();
         }
         size++ ;
     }
     /*  Function to delete an element at position  (one indexed)*/
     public void remove(int index)
     {        
         if (index == 1) 
         {
             start = start.getLink();
             size--; 
             return ;
         }
         if (index == size) 
         {
             Node s = start;
             Node t = start;
             while (s != end)
             {
                 t = s;
                 s = s.getLink();
             }
             end = t;
             end.setLink(null);
             size --;
             return;
         }
         Node ptr = start;
         index = index - 1 ;
         for (int i = 1; i < size - 1; i++) 
         {
             if (i == index) 
             {
                 Node tmp = ptr.getLink();
                 tmp = tmp.getLink();
                 ptr.setLink(tmp);
                 break;
             }
             ptr = ptr.getLink();
         }
         size-- ;
     } 
     public Object get(int index){
     	Node q = start;
     	
     	for(int i= 0; i<size ; i++){
     		if (i == index){
     			return q.data;
     		}
     		q = q.getLink();
     	}
     	return null;
     }
     public void set(int index, Object element){
     	Node q = start;
     	for(int i= 0; i<size-1 ; i++){
     		if (i == index){
     			q.setData(element);
     		}
     		q = q.getLink();
     	}
     }
     public void clear(){
     	Node q = start;
     	for(int i= 0; i<size-1 ; i++){
     		remove(0);
     		q = q.getLink();
     	}
     }
     public Singly sublist(int fromIndex, int toIndex){
     	Node q = start;
     	Singly empty = new Singly();
     	if(fromIndex >= size || toIndex < 0){
     		return empty;
     	}
     	
     	for(int i = 0; i< fromIndex; i++){
     		q= q.getLink();
     	}
     	Singly res = new Singly();
     	res.add(q.data);
     	for(int i = fromIndex ; i< toIndex; i++){
     		if(i == size-1){
     			return null;
     		}
     		q= q.getLink();
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
     		q = q.getLink();
     	}
     	return false;
     }
     public void printNode(Node n){
     	System.out.println(n.data);
     }
     public void display()
     {
         System.out.print("\nSingly Linked List = ");
         if (size == 0) 
         {
             System.out.print("empty\n");
             return;
         }    
         if (start.getLink() == null) 
         {
             System.out.println(start.getData() );
             return;
         }
         Node ptr = start;
         System.out.print(start.getData()+ "->");
         ptr = start.getLink();
         while (ptr.getLink() != null)
         {
             System.out.print(ptr.getData()+ "->");
             ptr = ptr.getLink();
         }
         System.out.print(ptr.getData()+ "\n");
     }
 }

