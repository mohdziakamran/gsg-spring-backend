package utils;

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
}
