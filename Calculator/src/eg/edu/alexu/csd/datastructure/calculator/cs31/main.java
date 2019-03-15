package eg.edu.alexu.csd.datastructure.calculator.cs31;

import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;
public class main {
	public static void main(String[] args){
		MyCalculator cal = new MyCalculator();
		Scanner s=new Scanner(System.in);
		int x,y;
		x=s.nextInt();
		y=s.nextInt();
		System.out.println(cal.add(x, y));
		System.out.printf("%.1f",cal.division(x, y));
		s.close();
	}
}

