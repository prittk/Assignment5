
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
//KashPritt
//Assignment5
//SE320
//https://stackoverflow.com/questions/2458049/how-to-get-previous-date-in-java

public class DaysSinceBirth {

	//THis program takes in your birthday and converts it to julian to find how many days passed since the current date
	public static void main(String[] args) throws ParseException
	{
		int[] Year_Month_Day = new int[3];
		int[] Born_Date = new int[3];
		
		//make a date format for parsing a given date into a format this is really only used to print the date
		
		
		Scanner scan = new Scanner(System.in);
		boolean end = true;
		
		//loop to enter in born year
		do
		{
			end = true;
			try {
				
		System.out.println(" Enter in Year you were born between 1800 and 2023");
		Born_Date[0] = scan.nextInt();
		assert 1800 <=Born_Date[0] && Born_Date[0] <= 2023: "The year you were born, has to be between 1800's and 2023";
		
		System.out.println(" Enter in Month between 1 and 12");
		Born_Date[1] = scan.nextInt();
		assert (1 <=Born_Date[1] && Born_Date[1]<= 12): "The month you were born, has to be between 0 and 12";

		
		System.out.println(" Enter in Day between 1 and 31");
		Born_Date[2] = scan.nextInt();
		assert (1 <=Born_Date[2] && Born_Date[2]<= 31): "The day you were born, has to be between 0 and 31";
			}
			catch(InputMismatchException  e)
			{
				System.out.println("Not a number");
			end = false;
			}
			catch(AssertionError e1)
			{
				System.out.println("Number out of bounds");
				end = false;
			}
			
		}
		while (end == false);
		scan.close();
		
		System.out.println("Birthdate "+Born_Date[0] + "-" + Born_Date[01]+"-"+Born_Date[2]);
		
			
		LocalDate now =  LocalDate.now(); //Date class no longer works for getDate, use Local
		
		System.out.println("Current date "+ now.toString()+ "\n");
		//Locale puts date in year-m-d format, parse the "-" out
		String[] parts = now.toString().split("-");
		
		//put each value into an array to use for julian date
			Year_Month_Day = new int[parts.length];
			
	        for (int i = 0; i < parts.length; i++) 
	        {
	        	Year_Month_Day[i] = Integer.parseInt(parts[i]);
	        }
	        
	       //Get julian dates and subtract from one another
	        int birthday_days =toJulian(Born_Date[0],Born_Date[1],Born_Date[2]);
	        int current_days = toJulian(Year_Month_Day[0],Year_Month_Day[1],Year_Month_Day[2]);
	       

			System.out.println("Birthday Julian days = " +toJulian(Born_Date[0],Born_Date[1],Born_Date[2]));
			System.out.println("Current Julian Days = " +toJulian(Year_Month_Day[0],Year_Month_Day[1],Year_Month_Day[2]));
			
			System.out.println("\nDays Since birthday "+(current_days-birthday_days));

	
		
	}
	
//provided in supplement notes 1 and 2 for date class
	 private static int toJulian(int year, int month, int date)
	 {  
		 
		 int jy = year;
		 
		 if (year < 0) jy++;
	 int jm = month;
	 if (month > 2) jm++;
	 else
	 {  
		 jy--;
		 jm += 13;
	 }
	 int jul = (int) (java.lang.Math.floor(365.25 * jy) 
	 + java.lang.Math.floor(30.6001 * jm) + date + 1720995.0);
	 
	 int IGREG = 15 + 31 * (10 + 12 * 1582);
	 // Gregorian Calendar adopted Oct. 15, 1582
	 if (date + 31 * (month + 12 * year) >= IGREG)
	 // Change over to Gregorian calendar
	 {  
	 int ja = (int) (0.01 * jy);
	 jul += 2 - ja + (int) (0.25 * ja);
	 }
	 return jul;
	 }

}
