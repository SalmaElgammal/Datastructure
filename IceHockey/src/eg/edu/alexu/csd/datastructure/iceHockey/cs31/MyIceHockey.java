package eg.edu.alexu.csd.datastructure.iceHockey.cs31;

import java.awt.Point;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

public class MyIceHockey implements IPlayersFinder {
	public static int arraySize;
	public static int minRow, maxRow, minCol, maxCol, countCells = 0,
			npoints = 0;
	public static Point[] points = new Point[50];
	public char[][] charArr=new char[50][50];
	
	public java.awt.Point[] findPlayers(String[] photo, int team, int threshold) {
		boolean check[][] = new boolean[photo.length][photo[0].length()];
		npoints=0;
		for(int i=0; i<points.length ;i++){
			points[i]=new Point();
		}
		int i, j, area;
		for (i = 0; i < photo.length; i++) {
            for (j = 0; j < photo[0].length(); j++) {
                    charArr[i][j] = photo[i].charAt(j);
            }
    }
		for (i = 0; i < photo.length; i++) {
			for (j = 0; j <= photo[0].length(); j++) {
				minRow = i;
				minCol = j;
				maxRow = i ;
				maxCol = j ;

				
					countCells=0;
					
					DFS(photo, check, i, j, team, threshold);
					area = countCells * 4;
					if (area >= threshold) {
						points[npoints].x = minCol + maxCol+1;
						points[npoints].y = minRow + maxRow+1;
						npoints++;
						
					

					}
				

			}

		}
		sort();
		Point[] rePoints=new Point[npoints];
		for(int t=0; t<rePoints.length ;t++){
			rePoints[t]=new Point();
		}
		for(int k=0;k<npoints;k++){
			rePoints[k].x=points[k].x;
			rePoints[k].y=points[k].y;
		}
		return rePoints;

	}

	public void DFS(String[] photo, boolean[][] check, int x, int y, int team,
			int threshold) {
		int k = charArr[x][y] - '0';
		if (k == team && x > 0 && y > 0 && x < photo.length
				&& y <photo[0].length() && check[x][y]==false) {
			check[x][y] = true;
			countCells++;
			minRow = Math.min(minRow, x);
			maxRow = Math.max(maxRow, x );
			minCol = Math.min(minCol, y);
			maxCol = Math.max(maxCol, y );
			DFS(photo, check, x + 1, y, team, threshold);
			DFS(photo, check, x, y + 1, team, threshold);
			DFS(photo, check, x - 1, y, team, threshold);
			DFS(photo, check, x, y - 1, team, threshold);
		}
		if(k == team && (x == 0 || y == 0) && x < photo.length
				&& y <photo[0].length() && check[x][y]==false){
			check[x][y] = true;
			countCells++;
			minRow = Math.min(minRow, x);
			maxRow = Math.max(maxRow, x );
			minCol = Math.min(minCol, y);
			maxCol = Math.max(maxCol, y );
			DFS(photo, check, x + 1, y, team, threshold);
			DFS(photo, check, x, y + 1, team, threshold);
		}

	}

	public void sort() {
		for (int i = 0; i < npoints; i++) {
			Point temp = new Point();
			temp = points[i];
			int pos = i;
			while (pos > 0
					&& (temp.x < points[pos - 1].x || (temp.x == points[pos - 1].x && temp.y < points[pos - 1].y))) {
				points[pos] = points[pos - 1];
				pos--;
			}
			points[pos] = temp;

		}
	}

}

