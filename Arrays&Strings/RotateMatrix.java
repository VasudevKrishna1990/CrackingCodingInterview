package _001_ArraysandStrings;
/*Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. (an you do this in place?*/
public class RotateMatrix {

	public static void main(String[] args) {
		int[][] theArray = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		System.out.println("************Before rotation******************");
		printMatrix(theArray);
		//theArray = rotateMatrixby90(theArray);
		rotateMatrixby90Inplace(theArray);
		System.out.println("************After rotation******************");
		printMatrix(theArray);
	}

	private static void rotateMatrixby90Inplace(int[][] theArray) {
		
		int N = theArray.length;
		int x,y;
		for(x=0;x<N/2;x++) 
		{
			for(y = x;y<N-x-1;y++)
			{
				int temp = theArray[x][y];
				theArray[x][y] = theArray[y][N-x-1];
				theArray[y][N-x-1] = theArray[N-x-1][N-y-1];
				theArray[N-x-1][N-y-1] = theArray[N-y-1][x];
				theArray[N-y-1][x] = temp;
			}
		}
		
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

	private static int[][] rotateMatrixby90(int[][] theArray) {
		
		int[][] resArray= new int[theArray.length][theArray[0].length];
		for(int i=0;i<theArray.length;i++)
		{
			for(int j=0;j<theArray[0].length;j++)
			{
				resArray[j][theArray.length-i-1] = theArray[i][j];
			}
		}
		
		return resArray;
	}
}
