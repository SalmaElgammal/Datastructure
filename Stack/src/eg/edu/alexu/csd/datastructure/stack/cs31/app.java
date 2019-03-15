package eg.edu.alexu.csd.datastructure.stack.cs31;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

public class app implements IExpressionEvaluator {
	
	function fn=new function();


	public String infixToPostfix(String expression){
		// TODO Auto-generated method stub
		char[] Arr=new char[2*expression.length()];
		int nChars=0;
		for(int i=0;i<expression.length();i++){
			if(expression.charAt(i)=='+' || expression.charAt(i)=='-' || expression.charAt(i)=='/' || expression.charAt(i)=='*' || expression.charAt(i)=='('){
				if(i>0 && (expression.charAt(i-1) == '+' || expression.charAt(i-1) == '-' || expression.charAt(i-1) == '*' || expression.charAt(i-1) == '/')){
					throw new RuntimeException();
				}
				if(fn.isEmpty()){
					fn.push(expression.charAt(i));}
				else if(check(expression.charAt(i))>check((char) fn.peek())){
					fn.push(expression.charAt(i));}
				else{
					while(fn.isEmpty()==false && check(expression.charAt(i))!=0 &&check(expression.charAt(i))<=check((char) fn.peek())){
						Arr[nChars]=(char) fn.pop();
						nChars++;}
					fn.push(expression.charAt(i));
				}
			}else if(expression.charAt(i)==')'){
				while((char)fn.peek()!='('){
					Arr[nChars]=(char)fn.pop();
					nChars++;}
				fn.pop();
			}
			else{
				if(expression.charAt(i)!=' '){
					Arr[nChars]=expression.charAt(i);
					nChars++;}
			}
		}
		while(!fn.isEmpty()){
			Arr[nChars]=(char)fn.pop();
			nChars++;
		}
		StringBuilder sb = new StringBuilder();

		for(int index=0; index < nChars-1; index++) {
		   sb.append(Arr[index]);
		   sb.append(" ");
		}
		sb.append(Arr[nChars-1]);
		String str=new String(sb);
		return str;
			
	}

	public int evaluate(String expression)  {
		for(int i=0;i<expression.length();i++){
			if(expression.charAt(i)=='/' || expression.charAt(i)=='*' || expression.charAt(i)=='+' || expression.charAt(i)=='-'){
				fn.push(operation((int)fn.pop(),(int)fn.pop(),expression.charAt(i)));
			}else{
				if(expression.charAt(i)!=' ' && expression.charAt(i)-'0'>=0 && expression.charAt(i)-'0'<=9){
					int res=expression.charAt(i)-'0';
					while(expression.charAt(i+1)-'0'>=0 && expression.charAt(i+1)-'0'<=9){
						res=(res*10)+expression.charAt(i+1)-'0';
						i++;
				}
					fn.push(res);
				}
			}
		}
		return (int) fn.pop();
	}
	int check(char operator){
		if(operator=='(' || operator==')'){
			return 0;
		}else if(operator=='+' || operator=='-'){
			return 1;
		}else if(operator=='*' || operator=='/'){
			return 2;
		}else{
			return -1;
		}
	}
	int operation(int a,int b,char operator){
		if(operator=='/'){
			return  b/a;
		}else if(operator=='*'){
			return b*a;
		}else if(operator=='+'){
			return b+a;
		}else{
			return (b-a);
		}
	}
	

}

