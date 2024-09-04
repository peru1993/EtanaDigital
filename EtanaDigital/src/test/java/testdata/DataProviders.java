package testdata;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	 @DataProvider(name = "invalidLoginData")
	    public Object[][] invalidLoginData() {
	        return new Object[][] {
	            {"Perulalitha@gmail.com", "SmartWork@123"},
	            {"perulalitha@gmail.com", "smartWork@123"},
	            {"Perulalitha@gmail.com", "smartwork@1234"},
	            {"", "SmartWork@123"},   //Empty Username
	            {"perulalitha@gmail.com", ""},  //Empty Password.
	            {"perulalitha@gmail.com", "SmartWork@123"}, // Valid Username. Valid Email
	        };
	    }
	
}
