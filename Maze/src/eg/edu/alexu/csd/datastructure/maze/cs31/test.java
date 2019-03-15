package eg.edu.alexu.csd.datastructure.maze.cs31;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class test {
	private static File maze =new File("C:\\Users\\Experts\\eclipse-workspace\\Maze\\Maze.txt");
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		methods m=new methods();
		int[][] a=m.solveBFS(maze);
		for(int i=0;i<=a.length-1;i++){
				System.out.println(a[i][0]+" "+a[i][1]);
		}
	}

}

