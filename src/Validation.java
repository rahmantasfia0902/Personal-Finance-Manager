import java.nio.file.Path;

public class Validation
{

	/**
	 * Checks to see if the path to the .csv file exists on the filesystem
	 * <p>
	 *@param p takes in a Path object to the .csv file
	 *@return Return true if the file exists in the current directory and if it follows the naming convention
	 *of YYYY.csv. Also, returns true if the file exits using a fully qualified name path without using the naming convention.
	 *@author David Guanga
	 * */
	public static boolean isValidFileName(Path p){ return false;}
	
	/**
	 * Checks to see if the .csv file has the header as: Date, Category, Amount
	 *@param p Takes in a Path object for the path to the csv file
	 *@return Returns true if the header contains the three categories in order: Date, Category, and Amount
	 *@author
	 *
	 * */
	public static boolean isValidHeader(Path p) {return false;}
	 
	/**
	 * Checks to see if the year of each entry of the .csv file is the same
	 *@param year the year of the given .csv file 
	 *@return Returns true if the passed date is of the same year as all the other dates 
	 *@author David Guanga
	 * */
	public static boolean isSameYear(String year) {
		return false;
	}

	/**
	 * Checks to see if the category matches one of the accepted categories 
	 *@param categ the name of the category to validate
	 *@return Returns true if the input category is one of the following: Compensation, Allowance, Investments,
	 *Home, Utilities, Food, Appearance, Work, Education, Transportation, Entertainment, Professional Services, Other
	 *@author
	 * */
	private static boolean isValidCategory(String categ){
		return false;
	}
	
	/**
	 * Checks to see if the amounts can be converted to a number
	 *@param am the amount to process and validate
	 *@return Returns true if the String am can be converted into a number 
	 *@author David Guanga
	 * */
	private static boolean isValidAmount(String am){
		return false;
	}

	/**
	 * Checks to see if the date is in the proper format and represents a valid month, date, and year
	 *@param date takes in the date as a String object
	 *@return Returns true if date is in the correct format MM/DD/YYYY and checks to see if the date is valid
	 *@author David Guanga
	 * */
	private static boolean isValidDateFormat(String date){
		return false;
	}

	/**
	 * Checks to see if an entry in the .csv file has a valid date, category, and amount
	 *@param take in a BudgetRecord that must be validated
	 *@return true if the records hava a valid date format, category, and amount
	 *@author David Guanga
	 * */
	public static boolean isValidRecord(){
		return false;
	}

}
