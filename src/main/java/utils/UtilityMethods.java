package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UtilityMethods {
	
    /**
     * If assert is true throw given exception
     * 
     * @param bool
     * @param exception
     * @throws Exception
     */
    public static void assertOverload(boolean bool, Exception exception) throws Exception {
    	if(bool) 
    		throw exception;
	}
    
    /**Method to return day string like monday
     * @param date
     * @return
     */
    public static String getDayOfWeek(String date){
    	  return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy")).getDayOfWeek().name();
    	}
}
