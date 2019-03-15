package eg.edu.alexu.csd.datastructure.queue.cs31;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

public class arrayBased implements IArrayBased, IQueue {
	
	int maxSize=1000;
	int f,r,size;
	public arrayBased(int n){
		maxSize=n;
		f=r=size=0;
	}
	Object[] arr=new Object[maxSize];
	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		if(size>=maxSize){
			throw new RuntimeException();
		}else{
			arr[r]=item;
			r=(r+1)%arr.length;
			size++;
		}
	}

	public Object dequeue() {
		// TODO Auto-generated method stub
		Object ret=new Object();
		if(isEmpty()){
			throw new RuntimeException();
		}else{
			ret=arr[f];
			arr[f]=null;
			f=(f+1)%arr.length;
			size--;
		}
		return ret;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size<=0);
	}

	public int size() {
		// TODO Auto-generated method stub
		
		return r-f;
	}

}

