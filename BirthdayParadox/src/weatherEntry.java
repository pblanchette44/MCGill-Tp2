
public class weatherEntry {

	private double  temperatureInCelsius;
	private boolean isSunny;
	
	public static void main(String[] args)
	{
		
	}
	
	
	weatherEntry(double temperature,boolean isSunny)
	{
		this.temperatureInCelsius = temperature;
		this.isSunny = isSunny;
	}
	
	/*
	 * Return the temperature in Celsius
	 */
	public double getTemperatureCelsius()
	{
		return temperatureInCelsius;
	}
	
	
	/*
	 * Return the value of the isSunny boolean
	 */
	public boolean isGoodWeather()
	{
		return isSunny;
	}

	/*
	 * Utility Method that return a string matching the state of the
	 * isSunny boolean. 
	 */
	private String isSunnyString()
	{
		if(this.isSunny)
		{
			return "is Sunny";
		} else {
			return "isn't Sunny";
		}
	}
	
	/*
	 * Utility String that return a string matching the gooddayCriteria
	 * 20 Celsius degree has been selected as a treshold because
	 * of personnal preferences. 
	 */
	private String isAGoodDay()
	{
		if(this.temperatureInCelsius > 20 && this.isSunny)
		{
			return "It is a good day";
		} else{
			return "It's not a good day";
		}
	}
	
	/*
	 * Display method that output the property of the instance
	 * and the result of the two previous utility strings 
	 */
	public void display(boolean isCelsius)
	{
		if(isCelsius)
		{
			System.out.println("It is " + this.temperatureInCelsius + " Celsius and " + this.isSunnyString() + this.isAGoodDay());
		} else {
			System.out.println("Is is " + this.celsiusToFahreneit() + " Fahrenheit and " + this.isSunnyString()+ this.isAGoodDay());
		}
	}
	
	/*
	 * Return the value of the temperature 
	 * converted to Fahrenheit.
	 */
	private double celsiusToFahreneit()
	{
		return (temperatureInCelsius*1.8)+32;
	}
	
}
