
public class birthdayParadox {

	public static void main(String[] args) {
		for(int i =1; i <= 100; i ++)
		{
			System.out.println(runExperiment(i));
		}
	}

	public static int[] generateArray(int size, int range) {
		
		//Initialise the Array to be output with the passed size.
		int[] temp = new int[size];
		//Iterates trough the array 
		for (int i = 0; i < temp.length; i++) {
			/*
			 * replace the value of temp[i] with the output of 
			 * Math.random() scale to the input range;
			*/
			temp[i] = ((int)(Math.random()*range));
		}
		//Return the array
		return temp;
	}

	
	public static int[][] generateAllData(int iterations, int size, int range)
	{
		//initialise 2D array with specified dimensions;
		int[][] temp = new int[iterations][size];
		
		//iterates trough each of the sub array in temp
		for(int i =0; i < iterations;i++)
		{
			//init a subarray with the generateArray method
			int[] subArray = generateArray(size,range);
			
			//for each subArray in temp add the newly created subarray
			for(int j =0; j < subArray.length;j++)
			{
				temp[i][j] = subArray[j];
			}
		}
		//return the array
		return temp;
	}
	
	
	public static int countElement(int[][] input,int element)
	{
		//Initialise the value occurence
		int occurence = 0;
		
		//Iterates trough the list of subArray
		for(int i =0; i < input.length;i++)
		{
			//Iterates trough the subArray
			for(int j=0; j < input[i].length;j++)
			{
				//If the current value is equal to the Element
				//Increment the occurence value
				if(input[i][j] == element)
				{
					occurence ++;
				}
			}
		}
		//return the ocurrence
		return occurence;
	}
	
	public static int maxDay(int[][] input)
	{
		//init the value of mode to 0;
		int mode = 0;
		//compare the occurence of every value from 0 to 365 in the input and
		//and output the value that has the most occurence.
		for(int i =0; i <= 365;i++)
		{
			if(countElement(input,i) > countElement(input,mode))
			{
				mode = i;
			}
		}
		return mode;
	}
	
	public static boolean hasDuplicate(int[] input)
	{
		//initialise a new 2d array with the value the input array
		int[][] temp = new int[1][input.length];
		
		for(int i =0; i < input.length;i++)
		{
			temp[0][i] = input[i];
		}
		
		//initialise a boolean for output
		boolean check = false;
		
		for(int i =0; i < 365;i++)
		{
			//if the countElement return a number bigger than 1 
			//then there's a duplicate
			if(countElement(temp,i) > 1)
			{
				check = true;
			} 
		}
		//return the check value;
		return check;
	}
	
	public static float runExperiment(int size) throws IllegalArgumentException
	{
		//generates all the subArrays
		if(size < 1)
		{
			throw  new IllegalArgumentException();
		}
		int[][] temp = generateAllData(200,size,365);
		int duplicateSum = 0;
		
		//for each sub array increment the duplicateSum if there's a duplicate
		for(int[] t:temp)
		{
			if(hasDuplicate(t))
			{
				duplicateSum ++;
			}
		}
		//return the fractionnal value
		return (float)((float)duplicateSum/200.0);
	}
	
	
}
