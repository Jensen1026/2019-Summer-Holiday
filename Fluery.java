package fluerys;

import java.util.Scanner;

public class Algorithm2 {
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	        
	        System.out.println("Enter The Number Of Matrix Rows "
	        		+ "(# of vertices for incidence matrix)");
	         
	        int matrixRow = scan.nextInt();
	         
	        System.out.println("Enter The Number Of Matrix Columns "
	        		+ "(# of edges for incidence matrix)");
	         
	        int matrixCol = scan.nextInt();
	         
	        //defining 2D array to hold matrix data
	        int[][] matrix = new int[matrixRow][matrixCol];
	        // Enter Matrix Data
	        enterMatrixData(scan, matrix, matrixRow, matrixCol);
	        
	        // Print Matrix Data
	        printMatrix(matrix, matrixRow, matrixCol);
	        System.out.println();
	        int[][] adjM = inciToAdj(matrix, matrixRow, matrixCol);
	        int e = isEulerian(matrix, matrixRow, matrixCol, numOddDegInci(matrix, matrixRow, matrixCol));
	        if(e == 1 || e == 2) {
	        	begin(findStartVert(matrix, matrixRow, matrixCol), adjM,
	        			matrixRow);
	        	//start(matrix, matrixRow, matrixCol);
	        }
	  }
	  public static void enterMatrixData(Scanner scan, int[][] matrix, int matrixRow, int matrixCol){
	     //System.out.println("Enter Matrix Data");
	          
	          for (int i = 0; i < matrixRow; i++)
	          {
	        	  System.out.println("Enter matrix data for vertex " + (i + 1));
	              for (int j = 0; j < matrixCol; j++)
	              {
	            	  System.out.println("Edge " + (j + 1) +":");
	                  matrix[i][j] = scan.nextInt();
	              }
	          }
	  }
	  public static void printMatrix(int[][] matrix, int matrixRow, int matrixCol){
		    System.out.println("Your Matrix is : ");
		        
		        for (int i = 0; i < matrixRow; i++)
		        {
		            for (int j = 0; j < matrixCol; j++)
		            {
		                System.out.print(matrix[i][j]+"\t");
		            }
		             
		            System.out.println();
		        }
		  }
	  public static int numOddDegInci(int[][] matrix, int matrixRow, int matrixCol) {
		  int count = 0;
		  int odds = 0;
		  for (int i = 0; i < matrixRow; i++){
	            for (int j = 0; j < matrixCol; j++){
	            	if(matrix[i][j] == 1) {
	            		count++;
	            	}
	            }
	            if(!(count % 2 == 0)) {
	            	odds++;
	            }
	            count = 0;
	         }
		  return odds;
	  }
	  
	  public static boolean connected(int[][] matrix, int matrixRow, int matrixCol) 
	    { 
	        // Mark all the vertices as not visited 
	        boolean visited[] = new boolean[matrixRow]; 
	        int i = 0; 
	        for (i = 0; i < matrixRow; i++) { 
	        	visited[i] = false; 
	        }
	  
	        // Find a vertex with non-zero degree 
	        for (i = 0; i < matrixRow; i++) {
	        	if (degree(matrix, i, matrixCol) != 0) { 
	        			break; 
	        	}
	        }
	  
	        // If there are no edges in the graph, return true 
	        if (i == matrixRow) { 
	            return true; 
	        }
	        // Start DFS traversal from a vertex with non-zero degree 
	        DFSUtil(i, visited, matrix, matrixRow); 
	  
	        // Check if all non-zero degree vertices are visited 
	        for (i = 0; i < matrixRow; i++) { 
	        	if (visited[i] == false && degree(matrix, i, matrixCol) > 0) 
	        		return false;
	        }
	  
	        return true; 
	    } 
	  
	// A function used by DFS 
	  public static void DFSUtil(int v, boolean visited[], 
			  int matrix[][], int matrixRow) 
	    { 
	        // Mark the current node as visited 
	        visited[v] = true; 
	  
	        // Recur for all the vertices adjacent to this vertex 
	        for (int i = v ; i < matrixRow; i++) { 
	        	if (!visited[i]) {
	        		DFSUtil(i, visited, matrix, matrixRow); 
	        	}
	        }
	    } 
	  
	  /*
      0 --> If graph is not Eulerian 
      1 --> If graph has an Euler trail (Semi-Eulerian) 
      2 --> If graph has an Euler Circuit (Eulerian)  */
	  public static int isEulerian(int[][] matrix, int matrixRow, int matrixCol, int odds) {
		  if(!connected(matrix, matrixRow, matrixCol)) {
			  return 0;
		  }
		  
		  if(odds > 2) {
			  System.out.println("The graph is not Eulerian");
			  return 0;
		  }
		  
		  if(odds == 2) {
			  System.out.println("The graph has an Euler trail");
			  return 1;
		  }
		  
		  if(odds == 0) {
			  System.out.println("The graph has an Euler Circuit");
			  return 2;
		  }
		  return -1;
	  }
	  
	  public static int degree(int[][] matrix, int row, int matrixCol) {
		  int count = 0;
		  for(int j = 0; j < matrixCol; j++) {
			  if(matrix[row][j] == 1) {
				  count++;
			  }
		  }
		  return count;
	  }
	  
	  public static int[] getAdjV(int[][] matrix, int row, int matrixRow, int matrixCol) {
	      int[] adjV = new int[matrixRow-1];
	      int c = 0;
		  for (int j = 0; j < matrixCol; j++) {
	            	if(matrix[row][j] == 1) {
	            		int e = j;
	            		for(int i = 0; i < matrixRow; i++) {
	            			if(matrix[i][e] == 1 && i != row) {
	            				adjV[c++] = i;
	            			}
	            		}
	            	}
	        }
	      	return adjV;
	  }
	  
	  private static int[][] inciToAdj(int[][] matrix, int matrixRow, int matrixCol){
		  int[][] adj = new int[matrixRow][matrixRow];
		  for(int a = 0; a < matrixRow; a++) {
			  for(int b = 0; b < matrixRow; b++) {
				  adj[a][b] = 0;
			  }
		  }
		  int v1;
		  int e;
		  
		  for(int i = 0; i < matrixRow; i++) {
			  for(int j = 0; j < matrixCol; j++) {
				  if(matrix[i][j] == 1) {
					  v1 = i;
					  e = j;
					  for(int x = 0; x < matrixRow; x++) {
						  if(matrix[x][e] == 
						1 && v1 != x) {
						adj[v1][x] = 1;
						  }
					  }
				  }
			  }
		  }
		  printMatrix(adj, matrixRow, matrixRow);
		  return adj;
	  }
	  
	  public static int findStartVert(int[][] matrix, int matrixRow, int matrixCol) {
		  for(int i = 0; i < matrixRow; i++) {
			  if((degree(matrix, i, matrixCol)) % 2 != 0) {
				  return i;
			  }
		  }
		  return 0;
	  }
	  
	  public static boolean isBridge(int u, int v, int[][] matrix, int matrixRow) {
		  int d = 0;
		  for(int i = 0; i < matrixRow; i++) {
			  if(matrix[v][i] == 1) {
				  d++;
			  }
		  }
		  if(d > 1) {
			  return false;
		  }
		  return true;
	  }
	  
	  private static int edgeCount(int[][] matrix, int matrixRow) {
		  int c = 0;
		  for(int i = 0; i < matrixRow; i++) {
			  for(int j = i; j < matrixRow; j++) {
				  if(matrix[i][j] == 1) {
					  c++;
				  }
			  }
		  }
		  return c;
	  }
	  
	  public static void begin(int start, int[][] matrix, int matrixRow) {
		  int edge = edgeCount(matrix, matrixRow);
		  
		  for(int v = 0; v < matrixRow; v++) {
			  if(matrix[start][v] == 1) {
				  if(edge <= 1 || !isBridge(start, v, matrix, matrixRow)) {
					  System.out.print((start + 1) + "-" + (v+1) + " ");
					  matrix[start][v] = matrix[v][start] = 0;
					  edge--;
					  begin(v, matrix, matrixRow);
				  }
			  }
		  }
	  }
}
