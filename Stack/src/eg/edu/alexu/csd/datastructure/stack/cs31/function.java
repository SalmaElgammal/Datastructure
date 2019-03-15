package eg.edu.alexu.csd.datastructure.stack.cs31;

import eg.edu.alexu.csd.datastructure.stack.IStack;

public class function implements IStack {
	static int maxSize=1000000;
	static Object[] ArrStack= new Object[maxSize];
	int t=-1;
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		if(t==maxSize-1 || index>t){
			throw new RuntimeException();
		}
		t++;
		for(int i=t-1;i>=index;i--){
			ArrStack[i+1]=ArrStack[i];
		}
		ArrStack[index]=element;
	}
	
	public Object pop() {
		// TODO Auto-generated method stub
		if(t==-1){
			//throw new RuntimeException();
			return null;
		}else{
			Object top=ArrStack[t];
			ArrStack[t]=null;
			t--;
			return top;
		}
	}

	public Object peek() {
		// TODO Auto-generated method stub
		if(t==-1){
			throw new RuntimeException();
		}else{
			return ArrStack[t] ;
		}
	}

	public void push(Object element) {
		// TODO Auto-generated method stub
		if(t==maxSize){
			throw new RuntimeException();
		}else{
			t++;
		ArrStack[t]=element;
		}
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		return (t==-1);
	}

	public int size() {
		// TODO Auto-generated method stub
		return t+1;
	}

}

