package com.group0931.triagephase2;

/**
 * A temperature reading of a {@code PatientVisit}.
 * @author Christina Chung, Asher MindenWebb, Angel You.
 *
 */
public class TemperatureReading extends VitalSignReading implements Comparable<TemperatureReading>{

	private static final long serialVersionUID = 1L;
	
	/** The temperature of this {@code TemperatureReading}.*/
	private double temperature;
	/** The date and time of this {@code TemperatureReading}. */
	private TimeStamp readingTime;
	/**
	 * **NOT IMPLMENTED IN PHASE 2.**<br> 
	 * The urgency point of this {@code TemperatureReading}.*/
	private int urgency;
	
	/**
	 * Constructs a {@code TemperatureReading} with temperature from 
	 * temperature and date and time from date.
	 * @param temperature The temperature of this {@code TemperatureReading}.
	 * @param date The date and time of this {@code TemperatureReading}.
	 */
	public TemperatureReading(Double temperature, TimeStamp date){
			this.temperature = temperature;
			this.readingTime = date;
			this.urgency = calculateUrgencyPoint();
	}
	
	/**
	 * Returns a {@code TemperatureReading} object iff the given Strings of the 
	 * temperature and date is valid.
	 * @param temperature The temperature of this {@code TemperatureReading}.
	 * @param date The date and time of this {@code TemperatureReading}.
	 * @return The TemperatureReading object.
	 * @throws InvalidVitalSignException If the given parameters are invalid.
	 */
	public static TemperatureReading FactoryTemperatureReading(String temperature, 
			TimeStamp date) throws InvalidVitalSignException{
		if (TemperatureReading.isValid(temperature))
			return new TemperatureReading(Double.parseDouble(temperature), date);
		else 
			throw new InvalidVitalSignException();	
	}
	
	/**
	 * Returns whether the given string is valid.
	 * @param s The String to be checked.
	 * @return True iff s is valid, false otherwise.
	 */
	public static boolean isValid(String s){
		try{
			Double.parseDouble(s);
		}catch (Exception e) {
			return false;
		}
		return true;	
	}

	/**
	 * Returns the temperature of this {@code TemperatureReading}.
	 * @return The temperature of this {@code TemperatureReading}.
	 */
	public double getTemperature(){
		return this.temperature;
	}

	@Override
	public TimeStamp getReadingTime(){
		return this.readingTime;
	}

	@Override
	public int calculateUrgencyPoint(){
		if (this.temperature >= 39.0)
			return 1;
		 else
			return 0;
	}
	
	@Override
	public int getUrgency() {
		return this.urgency;
	}

	@Override
	public int compareTo(TemperatureReading another) {
		TimeStamp otherTime = another.getReadingTime();
		return this.readingTime.compareTo(otherTime);
	}

	/**
	 * Returns the String representation of this TemperatureReading in the
	 * format of "yyyy-MM-dd HH:mm  Temperature: degrees Celcius".
	 */
	@Override
	public String toString() {
		String time = this.getReadingTime().toString();
		String temperature = String.valueOf(this.getTemperature());
		return time + "  Temperature: " + temperature;
	}
	
	public String getReadingAsString() {
		return String.valueOf(this.temperature);
	}
	
}