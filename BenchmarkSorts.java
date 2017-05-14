import java.text.DecimalFormat;
import java.util.Arrays;

//start of class BenchmarkSorts
public class BenchmarkSorts 
{

	DecimalFormat df = new DecimalFormat(".00");
	
	//array that will hold the size after it is passes
	private int[] arrSize;
	
	//will store the count each operation
	private double[][][] count;
	
	//will store the efficiency time 
	private double[][][] time;
	
	//create new sort object from InsertionSort
	private InsertionSort sort = new InsertionSort();;

	//set the private array values
	BenchmarkSorts(int[] arrSize) 
	{
		//set the size of the array's that was passed by constructor
		this.arrSize = arrSize;
		
		//set time and count to hold values for It and Rec
		this.count = new double[arrSize.length][2][50];
		this.time = new double[arrSize.length][2][50];
	}//end of BenchmarkSorts method

	//start of runSorts method
	public void runSorts() 
	{
		
		//Iterate through arrSize size
		for (int i = 0; i < arrSize.length; ++i) 
		{
			
			//each array will run 50 times and store the j value in the triple array
			for (int j = 0; j < 50; ++j) 
			{
				
				//creation for iterative array and will pass the size
				int[] iterative = new int[arrSize[i]];
				
				//assign a random number between 1-100 to each index of each iterative
				for (int k = 0; k < iterative.length; ++k) 
				{
					iterative[k] = (int)(Math.random()*100 + 1);					
				}
				//System.out.println("Numbers Generated: " + Arrays.toString(iterative));
				//close the iterative array so the same test values can be used for recursive
				int [] recursive = iterative.clone();
		
				//store the initial return value of getCount method in InsertionSort				
				int count1 = sort.getCount();
				
				//Store the initial time in milliseconds from InsertionSort getTime method
				double time1 = sort.getTime();
				
				//run iterative method for calculation
				sort.iterativeSort(iterative);
				//System.out.println("Numbers    sorted: " + Arrays.toString(iterative));
				//store count 2 for final count of iterative  method
				int count2 = sort.getCount();
				
				//store final time of iterative method
				double time2 = sort.getTime();
				
				//first array is size, second is assigned iterative operations 
				//last will store the count and time for each operation up to 50 times
				count[i][0][j] =  count2 - count1;;
				time[i][0][j] = time2 - time1;

				//store recursive first run count
				count1 = sort.getCount();
				
				//store recursive first run time
				time1 = sort.getTime();
				
				//run recursive sort method
				sort.recursiveSort(recursive);
				
				//store final count and time
				count2 = sort.getCount();
				time2 = sort.getTime();
				
				//first array is size, second is assigned recursive operations 
				//last will store the count and time for each operation up to 50 times
				count[i][1][j] = count2 - count1;
				time[i][1][j] = time2 - time1;
				
			}//end of for loop to run each operation 50 times
			
		}//end of for loop for the specified size of array
		
	}//end of run sorts method

	//method that is determine the average critical operation
	//of all 50 run test for the given arr size
	private double aveCritOperation(double[] arr) 
	{
		
		//store initial total
		double total = 0;
		
		//run the the length of the array and add to total
		for (int i = 0; i < arr.length; ++i) 
		{
			total += arr[i];
		}//end of for loop
		
		//find the final total average
		return total / arr.length;
	}//end of ave method

	//find the standard deviation of each array
	private double standardDeviation(double[] arr) 
	{
		//set initial values 
		double deviation = 0;
		double mean = aveCritOperation(arr);
		
		//run through the array and set the deviation
		for (int i = 0; i < arr.length; ++i) 
		{
			//subtract mean and square results
			deviation += (arr[i] - mean) * (arr[i] - mean);
		}
		
		//take sqrt to find the deviation
		return Math.sqrt(deviation / arr.length);
	}

	//display method that will return the result of each run through the array
	public void displayReport() 
	{
	
		
		System.out.println("\t\t\t\t"+"ITERATIVE"+"\t\t\t\t\t\t\t"+"RECURSIVE\n");
		System.out.println("SIZE" 
				+ "    Crit Count"
				+ "      Count Dev"
				+ "     Critical Time"
				+ "     Time Dev"
				+ "        Crit Count"
				+ "      Count Dev"
				+ "     Critical Time"
				+ "     Time Dev\n");
		//for each size of the array, display the deviation of time and count
		for (int i = 0; i < arrSize.length; ++i) 
		{
	
			System.out.println(arrSize[i] 
					+ "\t" + df.format(aveCritOperation(count[i][0])) 
					+ "\t" + df.format(standardDeviation(count[i][0]))
					+ "\t\t" + df.format(aveCritOperation(time[i][0]))
					+ "\t\t" + df.format(standardDeviation(time[i][0]))
					+ "\t\t" + df.format(aveCritOperation(count[i][1]))
					+ "\t" + df.format(standardDeviation(count[i][1]))
					+ "\t\t" + df.format(aveCritOperation(time[i][1]))
					+ "\t\t" + df.format(standardDeviation(time[i][1])));
			
			//System.out.printf();
		}//end of for loop
	}// end of display method

}//end of class benchmarks
