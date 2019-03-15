package eg.edu.alexu.csd.datastructure.linkedList.cs31;

public class Pair {
	int coeff,exp;
	
	void setPair(int n,int m) {
		coeff=n;
		exp=m;
	}
	void setExp(int n) {
		exp=n;
	}
	int getCoeff() {
		return coeff;
	}
	
	int getExp() {
		return exp;
	}
}
