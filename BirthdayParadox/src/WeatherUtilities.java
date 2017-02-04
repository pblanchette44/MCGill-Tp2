import java.util.Scanner;

public class WeatherUtilities {

	WeatherUtilities() {

	}

	public static void main(String[] args) {
		// initialise the weatherEntry array with the first parameter passed
		// from the console
		weatherEntry[] theWeatherEntry = new weatherEntry[Integer.parseInt((args[0]))];

		// Init the Scanner to read from console input
		Scanner s = new Scanner(System.in);

		/*
		 * This loop runs N times and ask the user to enter a double and a
		 * boolean to init the associated weatherEntry object in the array
		 * initialise previously.
		 */
		for (int i = 0; i < theWeatherEntry.length; i++) {
			System.out.println("Please enter a temperature: ");
			double temperatures = s.nextDouble();
			System.out.println("Please enter a Boolean: ");
			boolean sunnyStatus = s.nextBoolean();
			theWeatherEntry[i] = new weatherEntry(temperatures, sunnyStatus);
		}
		// Closes the Scanner.
		s.close();

		/*
		 * Init the three monitoring variables.
		 */
		
		double highestTemperature = 0;
		double lowestTemperature = 0;

		
		/*
		 * Goes trough the array of weatherEntry instances and evaluate if they
		 * are good days
		 */
		int count = countGoodDays(theWeatherEntry);
		
		for (int i = 0; i < theWeatherEntry.length; i++) {
			
			/*
			 * Evaluate if the weatherEntry instances temperature is the highest seen up to date
			 */
			if (theWeatherEntry[i].getTemperatureCelsius() > highestTemperature) {
				highestTemperature = theWeatherEntry[i].getTemperatureCelsius();
			}
			/*
			 * Evaluate if the weahterEntry instance temperature is the lowest seen up to date.
			 */
			if (theWeatherEntry[i].getTemperatureCelsius() < lowestTemperature) {
				lowestTemperature = theWeatherEntry[i].getTemperatureCelsius();
			}
		}
		
		/*
		 * Displays the count of nice days and the highest and lowest temperature from the array.
		 */
		System.out.println("There were " + count + " nice days");
		System.out.println("The highest temperature was " + highestTemperature + " degrees Celsius and the lowest was "
				+ lowestTemperature + ".");

	}

	
	/*
	 * utility method to count the number of good days in two array of temprature and booleans
	 */
	public static int countGoodDays(double[] temperatures, boolean[] goodDays) {
		
		//Throws an exception if the two arrays don't match in lengths
		if (temperatures.length != goodDays.length) {
			throw new IllegalArgumentException();
		}
		int count = 0;
		
		/*
		 * For each element in the two input arrays
		 * we create a new instance of weatherEntry which takes the matching
		 * values as input.
		 */
		for (int i = 0; i < temperatures.length; i++) {
			/*
			 * If the weatherEntry returns a true boolean
			 * then increment the count
			 */
			if (new weatherEntry(temperatures[i], goodDays[i]).isGoodWeather()) {
				count++;
			}
		}
		/*
		 * return the count of goodWeather
		 */
		return count;
	}

	/*
	 * Utility method that count the number of good weather by taking
	 * an array of weatherEntry as input
	 */
	public static int countGoodDays(weatherEntry[] w) {
		int count = 0;
		for (weatherEntry wE : w) {
			if (wE.isGoodWeather()) {
				count++;
			}
		}
		return count;
	}

}
