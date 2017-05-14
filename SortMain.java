//start of class SortMain
public class SortMain 
{
	//start of main method
	public static void main(String args[]) 
	{
		
		//declare initial size of array size
		int[] size = new int[10];
		
		//iterate through each array and change the size so more tests can 
		//be performed
		for (int i = 0; i < 10; ++i) 
		{
			size[i] = 100 * (i + 1);
		}//end of for loop
		
		//create object sort and pass value of size array to constructor
		//to BenchmarkSorts method in BenchmarkSorts
		BenchmarkSorts sort = new BenchmarkSorts(size);
				
		//run sorts to perform algorithms
		sort.runSorts();
		
		//display the results
		sort.displayReport();
		
	}//end of main method
	
}//end of class SortMain