package eg.edu.alexu.csd.datastructure.maze.cs31;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
import eg.edu.alexu.csd.datastructure.queue.cs31.linkedlistBased;
import eg.edu.alexu.csd.datastructure.stack.cs31.function;

public class methods implements IMazeSolver {
	int n,m;
	int endI=-1;
	int endJ=-1;
	int nS=0;
	int nE=0;
	int startI,startJ;
	char[][] charArr=new char[5][5];
	boolean[][] visited=new boolean[5][5];
	function s=new function();
	function sInd=new function();
	linkedlistBased q=new linkedlistBased();
	@Override
	public int[][] solveBFS(File maze) {
		// TODO Auto-generated method stub
		if(maze==null){
			return null;
		}
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(maze));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = null;
		try {
			line=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		n=5;
		m=5;
		for(int i=0;i<n;i++){
			try {
				line = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int j=0;j<m;j++){
				if(line.charAt(j)!=0)
				charArr[i][j]=line.charAt(j);
			}
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(charArr[i][j]=='S'){
					nS++;
					startI=i;
					startJ=j;
				}else if(charArr[i][j]=='E'){
					nE++;
				}
			}
		}
		if(nS!=1 || nE!=1){
			return null;
		}else{
			BFS(startI,startJ);
		}
		int currSize=q.size();
		int[][] cos=new int[currSize/2][2];
		for(int i=0;i<currSize/2;i++){
			cos[i][0]=(int) q.dequeue();
			cos[i][1]=(int) q.dequeue();
		}
		if(cos[currSize/2-1][0]!=endI && cos[currSize/2-1][0]!=endJ){
			return null;
		}
		setAll(false);
		return cos;
	}

	@Override
	public int[][] solveDFS(File maze) {
		// TODO Auto-generated method stub
		if(maze==null){
			return null;
		}
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(maze));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = null;
		try {
			line=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		n=5;
		m=5;
		for(int i=0;i<5;i++){
			try {
				line = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int j=0;j<5;j++){
				//System.out.println(line.charAt(j));
				charArr[i][j]=line.charAt(j);
			}
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(charArr[i][j]=='S'){
					nS++;
					startI=i;
					startJ=j;
				}else if(charArr[i][j]=='E'){
					nE++;
				}
			}
		}
		if(nS!=1 || nE!=1){
			return null;
		}else{
			DFS(startI,startJ);
		}
		int[][] cos=new int[sInd.size()/2][2];
		int currSize=sInd.size();
		for(int i=currSize/2-1;i>=0;i--){
			cos[i][0]=(int) sInd.pop();
			cos[i][1]=(int) sInd.pop();
		}
		if(currSize!=0 && cos[currSize/2-1][0]!=endI && cos[currSize/2-1][0]!=endJ){
			return null;
		}
		setAll(false);
		return cos;
	}
	void DFS(int i,int j){
		int flag=0;
		if((charArr[i][j]=='.' || charArr[i][j]=='S')&& visited[i][j]==false){
			visited[i][j]=true;
			sInd.push(j);
			sInd.push(i);
			
		}
		else if(charArr[i][j]=='E'){
			setAll(true);
			sInd.push(j);
			sInd.push(i);
			endI=i;
			endJ=j;
			//System.out.println(i+" * "+j);
			return;
		}
		if(i>=0 && i<=n-1 && j>=0 && j<=m-1){
			if(j!=m-1 &&(charArr[i][j+1]=='.' || charArr[i][j+1]=='E')&& visited[i][j+1]==false){
				flag=1;
				DFS(i,j+1);
			}
			if(j!=0 &&(charArr[i][j-1]=='.' || charArr[i][j-1]=='E')&& visited[i][j-1]==false){
				flag=1;
				DFS(i,j-1);
			}
			if(i!=n-1 &&(charArr[i+1][j]=='.' || charArr[i+1][j]=='E')&& visited[i+1][j]==false){
				flag=1;
				DFS(i+1,j);
			}
			if(i!=0 && (charArr[i-1][j]=='.' || charArr[i-1][j]=='E')&& visited[i-1][j]==false){
				flag=1;
				DFS(i-1,j);
			}
		}
		if(flag==0){
			sInd.pop();
			sInd.pop();
			return;
		}
		
	}

	void setAll(boolean All){
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(charArr[i][j]=='.' && visited[i][j]!=All){
					visited[i][j]=All;
				}
			}
		}
	}
	void BFS(int i,int j){
		int flag=0;
		if((charArr[i][j]=='.' || charArr[i][j]=='S')&& visited[i][j]==false){
			visited[i][j]=true;
			q.enqueue(i);
			q.enqueue(j);
			
		}
		else if(charArr[i][j]=='E'){
			setAll(true);
			q.enqueue(i);
			q.enqueue(j);
			endI=i;
			endJ=j;
			return;
		}
		if(i>=0 && i<=n-1 && j>=0 && j<=m-1){
			if(j!=m-1 &&(charArr[i][j+1]=='.' || charArr[i][j+1]=='E')&& visited[i][j+1]==false){
				flag=1;
				BFS(i,j+1);
			}
			if(j!=0 &&(charArr[i][j-1]=='.' || charArr[i][j-1]=='E')&& visited[i][j-1]==false){
				flag=1;
				BFS(i,j-1);
			}
			if(i!=n-1 &&(charArr[i+1][j]=='.' || charArr[i+1][j]=='E')&& visited[i+1][j]==false){
				flag=1;
				BFS(i+1,j);
			}
			if(i!=0 && (charArr[i-1][j]=='.' || charArr[i-1][j]=='E')&& visited[i-1][j]==false){
				flag=1;
				BFS(i-1,j);
			}
		}
		if(flag==0){
			linkedlistBased q2=new linkedlistBased();
			int currSize=q.size();
			for(int k=0;k<currSize-2;k++){
				q2.enqueue(q.dequeue());
			}
			q=q2;
			return;
		}
	}
	
}


