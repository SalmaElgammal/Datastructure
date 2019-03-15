package eg.edu.alexu.csd.datastructure.stack.cs31;

public class main {
	public static void main(String[] args){
		function fn=new function();
		app ap=new app();
		
		//test illegal inputs or expressions
		
		System.out.println(ap.infixToPostfix("5++5"));
		System.out.println(fn.peek());
		System.out.println(ap.evaluate("a b+"));

		
		// test legal inputs
		System.out.println(ap.evaluate("555 5+"));
		fn.push(8);
		fn.push(9);
		fn.push(10);
		fn.push('c');
		fn.add(0,"add");
		while(!fn.isEmpty()){
			System.out.println(fn.pop());
		}
		System.out.println(fn.size());
	}
}
