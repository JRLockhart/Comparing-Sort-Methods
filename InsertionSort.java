
//start of class InsertionSort
public class InsertionSort implements SortInterface
{
  
	//variable that will store count after ever critical operation
	private int count = 0;

	//per the instructions, this method will determine that 
	//the array is sorted properly
	private boolean isSorted(int[] arr) 
	{
		//run through the array
		for (int i = 0; i < arr.length - 1; ++i) 
		{
			//if a an index value is greater than the next one, return false(the sort failed)
			if (arr[i] > arr[i + 1]) 
			{
				return false;
			}
		}//end of for
		return true;
	}//end of isSorted

	//method to swap numbers at indicated index
	private void swap(int[] arr, int i, int j) 
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}//end of swap

	//override interface method
	//sent to sortRec method and then check to see if it worked
	@Override
	public void recursiveSort(int[] arr) 
	{
		recSort(arr, arr.length - 1);
		
		//if array isn't sorted then thrown exception
		if (!isSorted(arr)) 
		{
			try 
			{
				throw new UnsortedException("Something went wrong with Recursion");
			} catch (UnsortedException e) {
				e.printStackTrace();
			}
		}//end of check
	}//end of method

	//recSort algorithm
	private void recSort(int[] arr, int n) {
		if (n == 0) {
			return;
		}
		recSort(arr, n - 1);
		
		//count every time a new operation is pushed
		++count; 
		for (int i = n; i > 0; --i) 
		{
			//count every time a new operation is pushed
			++count; 
			
			if (arr[i] < arr[i - 1]) 
			{
				swap(arr, i, i - 1);
				
				//count every time a new operation is pushed
				++count; 
			} else {
				break;
			}
		}//end of for
	}//end of recSort Method

	@Override
	public void iterativeSort(int[] arr) {
		for (int i = 1; i < arr.length; ++i) {
			for (int j = i; j > 0; --j) {
				++count; // condition critical
				if (arr[j] < arr[j - 1]) {
					swap(arr, j, j - 1);
					++count; // swapping critical
				} else {
					break;
				}
			}
		}
		if (!isSorted(arr)) {
			try {
				throw new UnsortedException("Something went wrong with Iteration");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//method that will return the count of class variable
	@Override
	public int getCount() {
		return count;
	}

	@Override
	public long getTime() {
		return System.currentTimeMillis();
	}

}