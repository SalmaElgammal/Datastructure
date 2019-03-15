package eg.edu.alexu.csd.datastructure.linkedList.cs31;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		int[][] A=new int[2][2];
		A[0][0]=1;
		A[0][1]=2;
		A[1][0]=1;
		A[1][1]=0;
		
		int[][] B=new int[2][2];
		B[0][0]=1;
		B[0][1]=3;
		B[1][0]=-1;
		B[1][1]=1;
		
		PolynomialSolver ps=new PolynomialSolver();
		ps.setPolynomial('A', A);
		ps.setPolynomial('B', B);
		ps.add('A', 'B');
		System.out.println(ps.print('A'));
		System.out.println(ps.print('B'));
		System.out.println(ps.print('R'));

	}

}
