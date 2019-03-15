package eg.edu.alexu.csd.datastructure.linkedList.cs31;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

public class PolynomialSolver implements IPolynomialSolver {
	Singly Aterms=new Singly();
	Singly Bterms=new Singly();
	Singly Cterms=new Singly();
	Singly Rterms=new Singly();
	
	
	
	@Override
	public void setPolynomial(char poly, int[][] terms) {
		// TODO Auto-generated method stub
		
		addTerms(poly,terms);
	}

	void addTerms(char poly,int[][] terms) {
		
		int size=terms.length;
		
		for(int i=0;i<size;i++) {
			Pair term = new Pair();
			term.setPair(terms[i][0], terms[i][1]);
			if(poly=='A') {
				Aterms.add(term);
			}else if(poly=='B') {
				Bterms.add(term);
			}else if(poly=='C') {
				Cterms.add(term);
			}else {
				System.out.print("Error.Plynomial must bs A,B or C.");

			}
		}
	}
	@Override
	public String print(char poly) {
		// TODO Auto-generated method stub
		String s=Character.toString(poly)+Character.toString('=');
		int size;
		if(poly=='A') {
			size=Aterms.size;

			for(int i=0;i<size;i++) {
				s=s+Integer.toString(((Pair) Aterms.get(i)).getCoeff())+"X^"+Integer.toString(((Pair) Aterms.get(i)).getExp());

				if(i<size-1 && ((Pair) Aterms.get(i+1)).getCoeff()>0) {
					s=s+"+";
				}
			}
		}else if(poly=='B') {
			size=Bterms.size;
			for(int i=0;i<size;i++) {
				s=s+Integer.toString(((Pair) Bterms.get(i)).getCoeff())+"X^"+Integer.toString(((Pair) Bterms.get(i)).getExp());
				if(i<size-1 && ((Pair) Bterms.get(i+1)).getCoeff()>0) {
					s=s+"+";
				}
			}
		}else if(poly=='C') {
			size=Cterms.size;
			for(int i=0;i<size;i++) {
				s=s+Integer.toString(((Pair) Cterms.get(i)).getCoeff())+"X^"+Integer.toString(((Pair) Cterms.get(i)).getExp());
				if(i<size-1 && ((Pair) Cterms.get(i+1)).getCoeff()>0) {
					s=s+"+";
				}
			}
		}else if(poly=='R'){
			size=Rterms.size;
			for(int i=0;i<size;i++) {
				s=s+Integer.toString(((Pair) Rterms.get(i)).getCoeff())+"X^"+Integer.toString(((Pair) Rterms.get(i)).getExp());
				if(i<size-1 && ((Pair) Rterms.get(i+1)).getCoeff()>0) {
					s=s+"+";
				}
			}
		}else {
			System.out.println("Error.Plynomial must be A,B,C or R.");
		}
		
		
		return s;
	}
	
	@Override
	public void clearPolynomial(char poly) {
		if(poly=='A') {
			clear(Aterms);
		}else if(poly=='B') {
			clear(Bterms);
		}else if(poly=='C') {
			clear(Cterms);
		}else {
			System.out.println("Error. Polynomial must be A,B or C.");
		}

	}
	void clear(Singly list) {
		for(int i=list.size;i>0;i--) {
			list.remove(i);
		}
	}
	@Override
	public float evaluatePolynomial(char poly, float value) {
		// TODO Auto-generated method stub
		float res = 0;
		if(poly=='A') {
			res=(float)evaluate(Aterms,value);
		}else if(poly=='B') {
			res=(float)evaluate(Bterms,value);
		}else if(poly=='C') {
			res=(float)evaluate(Cterms,value);
		}else if(poly=='R') {
			res=(float)evaluate(Rterms,value);
		} 
		
		return res;
	}
	double evaluate(Singly list,float value) {
		double r = 0;
		int size=list.size;
		for(int i=0;i<size;i++) {
			r=r+((Pair) list.get(i)).getCoeff()*Math.pow(value,((Pair) list.get(i)).getExp());
		}
		return r;
	}
	@Override
	public int[][] add(char poly1, char poly2) {
		// TODO Auto-generated method stub
		if(poly1=='A') {
			moveToR(Aterms);
		}else if(poly1=='B') {
			moveToR(Bterms);
		}else if(poly1=='C') {
			moveToR(Cterms);
		}
		
		if(poly2=='A') {
			moveToR(Aterms);
		}else if(poly2=='B') {
			moveToR(Bterms);
		}else if(poly2=='C') {
			moveToR(Cterms);
		}
		sortR();
		int[][] res=convertListToArray();
		
		return res;
	}
	int[][] convertListToArray(){
		int[][] res=new int[Rterms.size][2];
		
		for(int i=0;i<Rterms.size;i++) {
			for(int j=0;j<2;j++) {
				if(j==0)
					res[i][j]=((Pair) Rterms.get(i)).getCoeff();
				else
					res[i][j]=((Pair) Rterms.get(i)).getExp();
			}
		}
		return res;
	}
	void moveToR(Singly list) {
		int size=list.size;
		for(int i=0;i<size;i++) {
			Rterms.add(list.get(i));
		}
	}
	
	void moveSub(Singly list) {
		int size=list.size;
		for(int i=0;i<size;i++) {
			Pair temp = new Pair();
			temp.setPair(((Pair) list.get(i)).getCoeff()* (-1),((Pair) list.get(i)).getExp() );
			Rterms.add(temp);
		}
	}
	
	void sortR() {
		int n = Rterms.size; 
		  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (((Pair) Rterms.get(j)).getExp() > ((Pair) Rterms.get(min_idx)).getExp()) 
                    min_idx = j; 
  
            // Swap the found minimum element with the first 
            // element 
            int temp = ((Pair) Rterms.get(min_idx)).getExp(); 
            //arr[min_idx] = arr[i]; 
            ((Pair) Rterms.get(min_idx)).setExp(((Pair) Rterms.get(i)).getExp());
            //arr[i] = temp; 
            ((Pair) Rterms.get(i)).setExp(temp);
        } 
	}
	@Override
	public int[][] subtract(char poly1, char poly2) {
		// TODO Auto-generated method stub
		if(poly1=='A') {
			moveToR(Aterms);
		}else if(poly1=='B') {
			moveToR(Bterms);
		}else if(poly1=='C') {
			moveToR(Cterms);
		}
		if(poly2=='A') {
			moveSub(Aterms);
		}else if(poly2=='B') {
			moveSub(Bterms);
		}else if(poly2=='C') {
			moveSub(Cterms);
		}
		
		sortR();
		int[][] res=convertListToArray();

		return res;
	}

	@Override
	public int[][] multiply(char poly1, char poly2) {
		// TODO Auto-generated method stub
		return null;
	}

}
