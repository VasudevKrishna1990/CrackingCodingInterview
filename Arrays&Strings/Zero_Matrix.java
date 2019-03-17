package _001_ArraysandStrings;

public class Zero_Matrix {

	public static void main(String[] args) {
		int [][] matrixZero = { {1,1,1,0},
								{1,1,1,1},
								{1,0,1,1},  
								{1,1,1,1}};
		
		
		zeroInfo(matrixZero);
		
	}

	private static void printMatrix(int[][] theArray) 
	{
		for(int[] row:theArray)
		{
			for(int col:row)
			{
				System.out.print(col + " ");
			}
			System.out.println();
		}		
	}
	
	private static void zeroInfo(int[][] matrixZero) {
		
		int rowArray[] = new int[matrixZero.length];
		int colArray[] = new int[matrixZero.length];
		
		for(int i=0;i<matrixZero.length;i++)
		{
			for(int j=0;j<matrixZero[0].length;j++)
			{
				if(matrixZero[i][j] == 0)
				{
					colArray[j] = 1;
					rowArray[i] = 1;
				}
			}
		}
				
		for(int i=0;i<matrixZero.length;i++)
		{
			if(rowArray[i] == 1)
			{
				for(int j =0;j<matrixZero[0].length;j++)
				{
					matrixZero[i][j] = 0;
				}
			}
			
			if(colArray[i] == 1)
			{
				for(int j =0;j<matrixZero[0].length;j++)
				{
					matrixZero[j][i] = 0;
				}
			}
		}
		printMatrix(matrixZero);
		
	}
}
