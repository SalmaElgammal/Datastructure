package eg.edu.alexu.csd.datastructure.queue.cs31;

public class main {
	public static void main(String[] args){
		arrayBased q=new arrayBased(5);
		System.out.println("*********** Array Based *************");
		q.enqueue(4);
		q.enqueue(66);
		q.enqueue(3);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.size());
		System.out.println(q.isEmpty());
		
		
		linkedlistBased q2=new linkedlistBased();
		System.out.println("*********** LinkedList Based *************");

		q2.enqueue(0);
		q2.enqueue(1);
		q2.enqueue(2);
		System.out.println(q2.dequeue());
		System.out.println(q2.dequeue());
		System.out.println(q2.isEmpty());
		
	}
}

